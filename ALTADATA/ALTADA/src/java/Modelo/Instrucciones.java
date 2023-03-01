/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author JIMMI
 * @autor MVASQUEZ
 
 */
public class Instrucciones {    
    private CallableStatement cst=null;
    PreparedStatement pstmt;
    private int _mensajecode=0;
    public Instrucciones(){
        Conexion.getConnection();
    }
    
    public  static Instrucciones getInstrucciones(){
        return Instancia_Instrucciones.Instancia;
    }
    
    private static class Instancia_Instrucciones{
        private static final Instrucciones Instancia=new Instrucciones();
    }
    
    //Instrucciones para ejecutar consultas
    
    public int getCodeError(){
        return _mensajecode;
    }
    
    public void cstConsulta(String consulta){
        try{
            cst=null;
            cst=Conexion.getConnection().prepareCall(consulta);
        }catch(SQLException e){
              e.printStackTrace();
        }
    }
    
    public void cstParametroEntradaIndex(int indiceParametro, Object valor){
        try{
           cst.setObject(indiceParametro, valor);
        }catch(SQLException e){
              e.printStackTrace();   
        }
    }
    public void cstParametroEntradaNombre(String nombreParametro, Object valor){
        try{
            cst.setObject(nombreParametro, valor);
        }catch(SQLException e){
             e.printStackTrace();   
        }
    }
    
    public void cstParametroSalidaIndex(int indiceParametro, int tipo){
        try{
            cst.registerOutParameter(indiceParametro, tipo);
        }catch(SQLException e){
             e.printStackTrace();   
        }
    }
    public void cstParametroSalidaNombre(String nombreParametro,int tipo ){
        try{
            cst.registerOutParameter(nombreParametro, tipo);
        }catch(SQLException e){
             e.printStackTrace();
        }
    }
    public Object cstParametroRetornoIndex(int indiceParametro){
        try{
            return cst.getObject(indiceParametro);
        }catch(SQLException e){
             e.printStackTrace(); 
             return null;
        }
    }
        
    public Object cstParametroRetornoNombre(String nombreParametro){
        try{
            return cst.getObject(nombreParametro);
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public void cerrarConexion(){
        try {
            Conexion.getConnection().close();
        } catch (Exception e) {
        }
        
    }
    public void cstClose(){
        try {
             cst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     // return cst.getString(1);
    public void cstEjecutar(){
        try{
            cst.execute();
           
 //         this._Desconectar();
//          this._Recolector();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }   
    
     public void cstEjecutarUpdate(){
        try{
            cst.executeUpdate();
//          this._Desconectar();
//          this._Recolector();
        }catch(SQLException e){
            e.printStackTrace();
        }
    } 
     
    public ResultSet cstEjecutarRetornaTablaFila(){
        try{
            return cst.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    } 
    
    public void recolector(){
        System.gc();
    }
    
    public boolean iniciarTransaccion(){
        try{
            if (Conexion.getConnection().getAutoCommit()==true){
                Conexion.getConnection().setAutoCommit( false );
            }
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean culminarTransaccion(){
        try{
            Conexion.getConnection().commit();        
            Conexion.getConnection().setAutoCommit(true);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean crearSentenciaSQL(String sql){
        try{
            pstmt = null;
            pstmt = Conexion.getConnection().prepareStatement(sql); 
            return true;
        }catch (SQLException ex){
            return false;
        }
    }

    public boolean creaParametroSQL(int indice, Object valor){
        try{
            pstmt.setObject(indice, valor);
        }catch (SQLException ex){
            return false;
        }
        return true;
    }
    
   public boolean ejecutarSQL(){
        try{
            pstmt.execute();
            _mensajecode=0;
            return true;    
        }catch (SQLException ex){
            _mensajecode=ex.getErrorCode();
            return false;
        }
        //return true;
    }

    public ResultSet ejecutarSQLSelect(){
        ResultSet resultado;
        try {
                //Statement sentencia = conexion.createStatement();
                //resultado = sentencia.executeQuery(sql);
                resultado = pstmt.executeQuery();
        }catch (SQLException ex){
                return null;
        }
        return resultado;
    }
    public ResultSet ejecutarSQLCursor(){
        ResultSet resultado;
        try {
                //Statement sentencia = conexion.createStatement();
                //resultado = sentencia.executeQuery(sql);
                resultado = cst.executeQuery();
        }catch (SQLException ex){
                return null;
        }
        return resultado;
    }
    /**
     * 
     * @param texto ingrese texto a encriptar
     * @return texto o clave encriptado
     */
    public String encriptar(String texto){
        String clave="";
        int lengthText=texto.length();
        
        try{
            for(int i=0; i<lengthText; i++){
                clave+=String.valueOf((char)(texto.trim().substring(i,i + 1).hashCode() + 75));
            }
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,""+e);
        }
        return clave;
    }
    
    /**
     * 
     * @param texto ingrese texto a encriptar
     * @return texto o clave desencriptado
     */
    public String desencriptar(String texto){
        String clave="";
        int lengthText=texto.length();
        
        try{
            for(int i=0; i<lengthText; i++){
                clave+=String.valueOf((char)(texto.trim().substring(i,i + 1).hashCode() - 75));
            }
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,""+ e);
        }
        return clave;
    }
    
    //Coversiones de formato de fecha
        public String Redondear(double valor,int numDecimales)
    {
        String val = valor+"";
        BigDecimal bigDec = new BigDecimal(val);
        bigDec = bigDec.setScale(numDecimales, RoundingMode.HALF_UP);
        return bigDec.toString();

    }
    public String Stringfecha(String formato,Date fecha)
    {
        try
        {
            SimpleDateFormat fdt = new SimpleDateFormat(formato);
            return fdt.format(fecha);
        }
        catch (Exception ex)
        {
            return "";
        }
    }  
    
     public Date Datefecha(String fecha){
       // SimpleDateFormat fdt = new SimpleDateFormat("yyyy-MM-dd");
         SimpleDateFormat fdt = new SimpleDateFormat("dd/MM/yyyy");
        Date f=new Date();
        String fecst="";
        try
        {
            f=fdt.parse(fecha);
            //fecst=fdt.format(f)
            //f=fdt.parse(fecst);
        }
        catch (Exception ex)
        {
            f=new Date();
        }
        return f;
    }
    
    public Date Datefecha(String fecha, String formato) 
    {
        SimpleDateFormat fdt = new SimpleDateFormat(formato);
        Date f=new Date();
        //String fecst="";
        try
        {
            f=fdt.parse(fecha);
            //fecst=fdt.format(f)
            //f=fdt.parse(fecst);
        }
        catch (Exception ex)
        {
            f=new Date();
        }
        return f;
    }
    
    //formatear fecha a tu estillo
    public String DateFecha(Object fecha, String formato) 
    {
        SimpleDateFormat fdt = new SimpleDateFormat(formato);
        String fFormat="";
        //Date f=null;
        //String fecst="";
        try
        {
            //f=fdt.parse(fecha);
            fFormat=fdt.format(fecha);
            //fecst=fdt.format(f)
            //f=fdt.parse(fecst);
        }
        catch (Exception ex)
        {
            //f=new Date();
        }
        return fFormat;
    }
    
//     public String DateFecha(Object fecha){
//        SimpleDateFormat fdt = new SimpleDateFormat("dd/MM/yyyy");
//        String fFormat="";
//        //Date f=null;
//        //String fecst="";
//        try
//        {
//            //f=fdt.parse(fecha);
//            fFormat=fdt.format(fecha);
//            //fecst=fdt.format(f)
//            //f=fdt.parse(fecst);
//        }
//        catch (Exception ex)
//        {
//            //f=new Date();
//        }
//        return fFormat;
//    }
    
     public Object DateFecha(Object fecha){
        SimpleDateFormat fdt = new SimpleDateFormat("dd/MM/yyyy");
       // Date f;
        String fecst="";
        try
        {
            fecst=fdt.format(fecha);
            //fecst=fdt.format(f)
            //f=fdt.parse(fecst);
        }
        catch (Exception ex)
        {
            //fecst=new Date();
        }
        return fecst;
    }
     public Date getFechaSistema(){
        Date hoy=new Date();
        SimpleDateFormat fdt = new SimpleDateFormat("dd/MM/yyyy");
       // Date f;
        String fecst="";
        Date fecha=new Date();
        try
        {
            fecst=fdt.format(hoy);
            fecha=fdt.parse(fecst);
            //fecst=fdt.format(f)
            //f=fdt.parse(fecst);
        }
        catch (Exception ex)
        {
            //fecst=new Date();
        }
        return fecha;
    }
    /*
 * @param dias 
 */
    public Date sumarFechasDias( Date fch, int dias)
    {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, dias);
        return new Date(cal.getTimeInMillis());
    }
    
    // Suma los días recibidos a la fecha  
    public Date sumarRestarDiasFecha(Date fecha, int dias){
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(fecha); // Configuramos la fecha que se recibe
      calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0 
      return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos 
    }
}

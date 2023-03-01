/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author MVASQUEZCH
 */
public class Tools {
    //* @param texto ingrese texto a encriptar
    //* @return texto o clave encriptado

    
    //A space or a tab: [\p{IsWhite_Space}&&[^\p{gc=Zl}\p{gc=Zp}\x0a\x0b\x0c\x0d\x85]] 
    public static boolean areLetter(String texto){
        boolean sw=false;
        try {
            if(texto.trim().matches("[a-zA-Z_'\'p{' '}]*")){
                sw=true;
            }else
            {
                  sw=false;
            }
            
        } catch (Exception e) {
        }
        return sw;
    }
    
      public static boolean isNumberInteger(String texto){
        boolean sw=false;
        try {
            if(texto.trim().matches("[0-9]*")){
                sw=true;
            }else
            {
                  sw=false;
            }
            
        } catch (Exception e) {
        }
        return sw;
    }
      public static boolean isNumberDecimal(String texto){
        boolean sw=false;
        try {
            if(texto.trim().matches("[0-9_'\'p{.}]*")){
                sw=true;
            }else
            {
                  sw=false;
            }
            
        } catch (Exception e) {
        }
        return sw;
    }
      
      //Date hoy=new Date();
//                 String fecha=String.valueOf(Dao.getInstrucciones().CObjectFechaDate(hoy));
//                 if(obje.getFecha_nacimiento().before(Dao.getInstrucciones().CDatefechaString(fecha))){
//                    st.setString(7, String.valueOf(Dao.getInstrucciones().CObjectFechaDate(obje.getFecha_nacimiento())));
     

      public static  boolean isDateMinEqualToday(Date fecha){
          boolean sw=false;
          try {
              Date today=new Date();
              String f=String.valueOf(CObjectFechaDate(today));
              if(fecha.before(CDatefechaString(f)) || fecha.equals(CDatefechaString(f))){
                  sw=true;
              }
            } catch (Exception e) {
                sw=false;
          }
          return sw;
      }
      
       public static  boolean isDateMayEqualToday(Date fecha){
          boolean sw=false;
          try {
              Date today=new Date();
              String f=String.valueOf(CObjectFechaDate(today));
              if(fecha.after(CDatefechaString(f)) || fecha.equals(CDatefechaString(f))){
                  sw=true;
              }
            } catch (Exception e) {
                sw=false;
          }
          return sw;
      }
       
       public static  boolean isDateMin(Date fecha){
          boolean sw=false;
          try {
              Date today=new Date();
              String f=String.valueOf(CObjectFechaDate(today));
              if(fecha.before(CDatefechaString(f))){
                  sw=true;
              }
            } catch (Exception e) {
                sw=false;
          }
          return sw;
      }
              public static  boolean isDateMay(Date fecha){
          boolean sw=false;
          try {
              Date today=new Date();
              String f=String.valueOf(CObjectFechaDate(today));
              if(fecha.after(CDatefechaString(f))){
                  sw=true;
              }
            } catch (Exception e) {
                sw=false;
          }
          return sw;
      }
       
       public static  boolean areDateOrder(Date fechainicio, Date fechafin){
          boolean sw=false;
          try {
              if(fechainicio.before(fechafin)){
                  sw=true;
              }
            } catch (Exception e) {
                sw=false;
          }
          return sw;
      }
            public static  boolean areDateDisctinct(Date fecha1,Date fecha2){
          boolean sw=false;
          try {
              if(!fecha1.equals(fecha2)){
                  sw=true;
              }
            } catch (Exception e) {
                sw=false;
          }
          return sw;
      }
    public static String encriptar(String texto){
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
    public static String desencriptar(String texto){
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
    
    public static boolean  IsRucValid(String dni,String ruc){
        boolean sw=false;
        try {
            sw=(dni.trim().equals(ruc.trim().substring(2, 10))? true : false);
        } catch (Exception e) {
            sw=false;
        }
        return sw;
    }
    
    //Coversiones de formato de fecha
        public static String Round(double valor,int numDecimales)
    {
        String val = valor+"";
        BigDecimal bigDec = new BigDecimal(val);
        bigDec = bigDec.setScale(numDecimales, RoundingMode.HALF_UP);
        return bigDec.toString();

    }

     public static Date CDatefechaString(String fecha){
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
    
     public static Object CObjectFechaDate(Object fecha){
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
     


//          public static String StringFecha(Date fecha)
//    {
//        try
//        {
//            SimpleDateFormat fdt = new SimpleDateFormat("dd/MM/yyyy");
//            return fdt.format(fecha);
//        }
//        catch (Exception ex)
//        {
//            return "";
//        }
//    } 
     public static Date getDateSystem(){
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
//    public static Date sumarFechasDias( Date fch, int dias)
//    {
//        Calendar cal = new GregorianCalendar();
//        cal.setTimeInMillis(fch.getTime());
//        cal.add(Calendar.DATE, dias);
//        return new Date(cal.getTimeInMillis());
//    }
//    
//    // Suma los días recibidos a la fecha  
//    public static Date sumarRestarDiasFecha(Date fecha, int dias){
//      Calendar calendar = Calendar.getInstance();
//      calendar.setTime(fecha); // Configuramos la fecha que se recibe
//      calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0 
//      return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos 
//    }
}

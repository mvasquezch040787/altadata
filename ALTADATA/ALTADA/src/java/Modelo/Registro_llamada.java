
package Modelo;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;

public class Registro_llamada implements Serializable{

    protected int cod_registro;
    protected Cliente obj_cliente=new Cliente();
    protected User obj_user=new User();
    protected String fecha_hora_registro;
    protected String incidente_cliente;
    protected String indicacion_entregada;

    public Registro_llamada() {
        this.obj_cliente=new Cliente();
        this.obj_user=new User();
       
    }

    public int getCod_registro() {
        return cod_registro;
    }

    public void setCod_registro(int cod_registro) {
        this.cod_registro = cod_registro;
    }

    public Cliente getObj_cliente() {
        return obj_cliente;
    }

    public void setObj_cliente(Cliente obj_cliente) {
        this.obj_cliente = obj_cliente;
    }

    public User getObj_user() {
        return obj_user;
    }

    public void setObj_user(User obj_user) {
        this.obj_user = obj_user;
    }

    public String getFecha_hora_registro() {
        return fecha_hora_registro;
    }

    public void setFecha_hora_registro(String fecha_hora_registro) {
        this.fecha_hora_registro = fecha_hora_registro;
    }

    public String getIncidente_cliente() {
        return incidente_cliente;
    }

    public void setIncidente_cliente(String incidente_cliente) {
        this.incidente_cliente = incidente_cliente;
    }

    public String getIndicacion_entregada() {
        return indicacion_entregada;
    }

    public void setIndicacion_entregada(String indicacion_entregada) {
        this.indicacion_entregada = indicacion_entregada;
    }
    
    public static boolean RegistrarLlamada(Registro_llamada obj){
    boolean sw=false;
        try {
            Dao.getInstance().cstConsulta("INSERT INTO REGISTRO_LLAMADA (RUT_CLIENTE,RUT_USUARIO,FECHA_HORA_LLAMADA,INCIDENTE_CLIENTE,INDICACION_ENTREGADA) VALUES (?,?,?,?,?)");
            Dao.getInstance().cstParametroEntradaIndex(1,obj.getObj_cliente().getRut_cliente().trim());
            Dao.getInstance().cstParametroEntradaIndex(2,obj.getObj_user().getRut_usuario().trim());
            Dao.getInstance().cstParametroEntradaIndex(3,obj.getFecha_hora_registro());
            Dao.getInstance().cstParametroEntradaIndex(4,obj.getIncidente_cliente());
            Dao.getInstance().cstParametroEntradaIndex(5,obj.getIndicacion_entregada());
            Dao.getInstance().cstEjecutar();
            sw=true;
        } catch (Exception e) {
           sw=false;
        }
        return sw;
    }
    public static ArrayList<Registro_llamada>ListarHistorialRegistroLlamadaCliente(String rut_cliente) {
        ArrayList<Registro_llamada> arraylist_reg_llamada=new ArrayList<Registro_llamada>();
        ResultSet rs=null;
        try {
            Dao.getInstance().cstConsulta("SELECT C.RUT_CLIENTE, C.APELLIDOS_NOMBRES, RAZON_SOCIAL, C.DIRECCION, C.TELEFONO, C.CORREO_ELECTRONICO,C.NOMBRE_CONTACTO, C.TELEFONO_CONTACTO,\n" +
"U.RUT_USUARIO, U.APELLIDOS_NOMBRES, FECHA_HORA_LLAMADA, INCIDENTE_CLIENTE, INDICACION_ENTREGADA\n" +
"FROM CLIENTE C JOIN REGISTRO_LLAMADA R ON C.RUT_CLIENTE=R.RUT_CLIENTE JOIN USUARIO U ON R.RUT_USUARIO=U.RUT_USUARIO\n" +
"WHERE C.RUT_CLIENTE=?");
            Dao.getInstance().cstParametroEntradaIndex(1, rut_cliente.trim());
            rs=Dao.getInstance().cstEjecutarRetornaTablaFila();
            
            while (rs.next()) { 
                Cliente cliente =new Cliente();
                User user=new User();
                
                Registro_llamada reg=new Registro_llamada();
                cliente.setRut_cliente(rs.getString(1));
                cliente.setApellidos_nombres(rs.getString(2));
                cliente.setRazon_social(rs.getString(3));
                cliente.setDireccion(rs.getString(4));
                cliente.setTelefono(rs.getString(5));
                cliente.setCorreo_electronico(rs.getString(6));
                cliente.setNombre_contacto(rs.getString(7));
                cliente.setTelefono_contacto(rs.getString(8));
                
                user.setRut_usuario(rs.getString(9));
                user.setApellidos_nombres(rs.getString(10));
                
                reg.setObj_cliente(cliente);
                reg.setObj_user(user);
                reg.setFecha_hora_registro(rs.getNString(11));
                reg.setIncidente_cliente(rs.getNString(12));
                reg.setIndicacion_entregada(rs.getNString(13));
                arraylist_reg_llamada.add(reg);
            }
        } catch (Exception e) {
            System.out.println("Error en el método por: "+e.getMessage());
        }
        return arraylist_reg_llamada;
    }
   public static ArrayList<Cliente>Listar() {
        ArrayList<Cliente> arraylist_cliente=new ArrayList<Cliente>();
        ResultSet rs=null;
        try {
            Dao.getInstance().cstConsulta("SELECT * FROM CLIENTE");
            rs=Dao.getInstance().cstEjecutarRetornaTablaFila();
            
            while (rs.next()) { 
                Cliente cliente =new Cliente();
                
                cliente.setRut_cliente(rs.getString(1));
                cliente.setApellidos_nombres(rs.getString(2));
                cliente.setRazon_social(rs.getString(3));
                cliente.setDireccion(rs.getString(4));
                cliente.setTelefono(rs.getString(5));
                cliente.setCorreo_electronico(rs.getString(6));
                cliente.setNombre_contacto(rs.getString(7));
                cliente.setTelefono_contacto(rs.getString(8));
                arraylist_cliente.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("Error en el método por: "+e.getMessage());
        }
        return arraylist_cliente;
    }
}
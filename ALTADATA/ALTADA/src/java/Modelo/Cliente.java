
package Modelo;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import oracle.jdbc.OracleTypes;


public class Cliente  implements Serializable{
protected String rut_cliente;
protected String Apellidos_nombres;
protected String razon_social;
protected String direccion;
protected String telefono;
protected String correo_electronico;
protected String nombre_contacto;
protected String telefono_contacto;

    public Cliente() {
    }
    public String getRut_cliente() {
        return rut_cliente;
    }

    public void setRut_cliente(String rut_cliente) {
        this.rut_cliente = rut_cliente;
    }

    public String getApellidos_nombres() {
        return Apellidos_nombres;
    }

    public void setApellidos_nombres(String Apellidos_nombres) {
        this.Apellidos_nombres = Apellidos_nombres;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

    public String getTelefono_contacto() {
        return telefono_contacto;
    }

    public void setTelefono_contacto(String telefono_contacto) {
        this.telefono_contacto = telefono_contacto;
    }
       public static boolean RegistrarCliente(Cliente obje){
        boolean sw=false;
        try {
            Dao.getInstance().cstConsulta("INSERT INTO CLIENTE (RUT_CLIENTE,APELLIDOS_NOMBRES,RAZON_SOCIAL,DIRECCION,TELEFONO,CORREO_ELECTRONICO,NOMBRE_CONTACTO,TELEFONO_CONTACTO) VALUES (?,?,?,?,?,?,?,?)");
            Dao.getInstance().cstParametroEntradaIndex(1,obje.getRut_cliente().trim());
            Dao.getInstance().cstParametroEntradaIndex(2,obje.getApellidos_nombres().trim());
            Dao.getInstance().cstParametroEntradaIndex(3,obje.getRazon_social().trim());
            Dao.getInstance().cstParametroEntradaIndex(4,obje.getDireccion().trim());
            Dao.getInstance().cstParametroEntradaIndex(5,obje.getTelefono().trim());
            Dao.getInstance().cstParametroEntradaIndex(6,obje.getCorreo_electronico().trim());
            Dao.getInstance().cstParametroEntradaIndex(7,obje.getNombre_contacto().trim());
            Dao.getInstance().cstParametroEntradaIndex(8,obje.getTelefono_contacto().trim());
            Dao.getInstance().cstEjecutar();
        sw=true;
        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
            sw=true;
        }
        return sw;
    }
    
public static Cliente Obtener_cliente(String rut_cliente) {
   Cliente cliente=new Cliente();
    ResultSet rs=null;
    try {
        Dao.getInstance().cstConsulta("SELECT * FROM CLIENTE WHERE RUT_CLIENTE=?");
        Dao.getInstance().cstParametroEntradaIndex(1,rut_cliente.trim());
        rs=Dao.getInstance().cstEjecutarRetornaTablaFila();
        while (rs.next()) { 
        cliente.setRut_cliente(rs.getString(1));
        cliente.setApellidos_nombres(rs.getString(2));
        cliente.setRazon_social(rs.getString(3));
        cliente.setDireccion(rs.getString(4));
        cliente.setTelefono(rs.getString(5));
        cliente.setCorreo_electronico(rs.getString(6));
        cliente.setNombre_contacto(rs.getString(7));
        cliente.setTelefono_contacto(rs.getString(8));
        }      
      
    } catch (Exception e) {
        System.out.println("Error en el método por: "+e.getMessage());
    }
    return cliente;
    }
   public static ArrayList<Cliente>ListarHistorialRegistroLlamadaCliente() {
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

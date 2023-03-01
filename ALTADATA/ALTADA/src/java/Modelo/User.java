
package Modelo;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
import oracle.jdbc.OracleTypes;

public class User implements Serializable{
    protected String rut_usuario;
    protected String apellidos_nombres;
    protected String telefono;
    protected String direccion; 
    
    public String getRut_usuario() {
        return rut_usuario;
    }

    public void setRut_usuario(String rut_usuario) {
        this.rut_usuario = rut_usuario;
    }

    public String getApellidos_nombres() {
        return apellidos_nombres;
    }

    public void setApellidos_nombres(String apellidos_nombres) {
        this.apellidos_nombres = apellidos_nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public static boolean RegistrarUser(User objUser)
    {
        boolean sw=false;
        try{
             Dao.getInstance().cstConsulta("INSERT INTO USUARIO (RUT_USUARIO,APELLIDOS_NOMBRES,TELEFONO,DIRECCION) VALUES (?,?,?,?)");
             Dao.getInstance().cstParametroEntradaIndex(1,objUser.getRut_usuario());
             Dao.getInstance().cstParametroEntradaIndex(2,objUser.getApellidos_nombres());
             Dao.getInstance().cstParametroEntradaIndex(3,objUser.getTelefono());
             Dao.getInstance().cstParametroEntradaIndex(4,objUser.getDireccion());
             Dao.getInstance().cstEjecutar();
             sw=true;
        }catch(Exception e){
            sw=false;
        }
        return sw;
    }
//    public static boolean ActualizarUser(User objUser){
//        String val;
//        boolean sw=false;
//        try{
//            if(objUser.getUser()!=null && objUser.getId_area()!=0 && objUser.getEstado()>-1 & objUser.getEstado()<2){
//                if(!objUser.getUser().trim().equals("")){
//                    if(Utils.Tools.areLetter(objUser.getUser())){
//                        if(Utils.Tools.isNumberInteger(String.valueOf(objUser.getEstado())) && Utils.Tools.isNumberInteger(String.valueOf(objUser.getId_area()))){
//                            if(objUser.getUser().length()>0 && objUser.getUser().length()<51){
//                                 Dao.getInstance().cstConsulta("{call SP_ACTUALIZAR_AREA(?,?,?,?)}");
//                                 Dao.getInstance().cstParametroEntradaIndex(1, objUser.getId_area());
//                                 Dao.getInstance().cstParametroEntradaIndex(2,objUser.getUser());
//                                 Dao.getInstance().cstParametroEntradaIndex(3, objUser.getEstado());
//                                 Dao.getInstance().cstParametroSalidaIndex(4,Types.NUMERIC);
//                                 Dao.getInstance().cstEjecutar();
//                                 val=String.valueOf(Dao.getInstance().cstParametroRetornoIndex(4));
//                                 if(val.equals("1")){
//                                     sw=true;
//                                 }     
//                            }else {
//                                 System.out.println("El nombre del User no debe superar los 50 caracters");
//                            }
//                        }else{
//                             System.out.println("El Estado o el User deben ser valores Numericos Enteros");
//                        }
//                    }else{
//                        System.out.println("Debe ingresar un texto correcto");
//    //                    Dao.getInstance().cstParametroEntradaIndex(1,null);
//                    }
//                }else{
//                     System.out.println("El User no puede ser una cadena vacia");
//                }
//            }else{
//                System.out.println("El User,Id O Estado  no puede ser null O el Estado debe E[0-1]");
//            }
//                                
//        }catch(Exception e){
//            sw=false;
//        }
//        return sw;
//    }
//     public static ArrayList<User> Listar(int es) {
//        ArrayList<User> al=new ArrayList<User>();
//        ResultSet rs=null;
//        try {
//            Dao.getInstance().cstConsulta("{call CURSORES.SP_LISTARAREA(?,?)}");
//            Dao.getInstance().cstParametroEntradaIndex(1, es);
//            Dao.getInstance().cstParametroSalidaIndex(2,OracleTypes.CURSOR);
//            Dao.getInstance().cstEjecutar();
//            rs=(ResultSet)Dao.getInstance().cstParametroRetornoIndex(2);
//            
//            while (rs.next()) {    
//                    User a=new User();
//                    a.setId_area(rs.getInt(1));
//                    a.setUser(rs.getString(2));
//                    a.setEstado(rs.getInt(3));
//                    al.add(a);
//                   
//            }
//        } catch (Exception e) {
//            System.out.println("Error en el método por: "+e.getMessage());
//        }
//        return al;
//    }
//    public  ArrayList<SelectItem> cargarCMBUser() {
//        ArrayList<SelectItem> a=null;
//        ResultSet rs=null;
//        try {
//            Dao.getInstance().cstConsulta("{call CURSORES.SP_LISTARAREA(?,?)}");
//            Dao.getInstance().cstParametroEntradaIndex(1, 2);
//            Dao.getInstance().cstParametroSalidaIndex(2,OracleTypes.CURSOR);
//            Dao.getInstance().cstEjecutar();
//            rs=(ResultSet)Dao.getInstance().cstParametroRetornoIndex(2);
//            if(rs.next()){
//                 a=new ArrayList<SelectItem>();
//                 do{
//                      a.add(new SelectItem(rs.getInt(1),rs.getString(2)));
//                 }while (rs.next());
//            }
//        } catch (Exception e) {
//            System.out.println("Error en el método por: "+e.getMessage());
//        }
//        return a;
//    }
     
}

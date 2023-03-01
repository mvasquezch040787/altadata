/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.DriverManager;

/**
 *
 * @author MVASQUEZCH
 */
public class Conexion {

    public Conexion() {
    }
    //private static final String ipBD = "localhost";
    //private static final int puertoTCP = 3306;
//    private static final String nombreBD = "altada_spa";
//    private static final String usuarioBD = "VENTAS_REPUESTOS";
//    private static final String claveBD = "VENTAS_REPUESTOS";
//       private static final String Bd = "altada_spa";
        private static final String user = "root";
        private static final String password = "FullStack";
 
    private static String getURLBD(){
        return "jdbc:mysql://localhost:3306/altada_spa?characterEncoding=latin1";
        //return "jdbc:oracle:";
        //thin cuando se conecta local(la BD esta en la misma maquina)
    }

    public static java.sql.Connection getConnection(){
        java.sql.Connection conexion = null;
        try{
             Class.forName("com.mysql.jdbc.Driver"); 
            conexion = DriverManager.getConnection (getURLBD(),user, password);        
                       
        }catch(Exception error) {
            System.out.println("Hay un error por: " + error.getMessage());
            error.printStackTrace();
        }
        return conexion;
    }
}
//  Class.forName("com.mysql.jdbc.Driver");
//          // cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/altada_spa:user=root&password=FullStack");
//            //Class.forName("com.mysql.jdbc.Driver");
//            cn = DriverManager.getConnection("jdbc:mysql://localhost/altada_spa", "root", "FullStack");
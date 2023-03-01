/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @autor MVASQUEZ
 */
public class Dao {    
    private Dao(){
    }
    private static final Dao instancia=new Dao();
       public static Dao getInstance(){
           return instancia;
       }

    private CallableStatement cst=null;
    //Instrucciones para ejecutar consultas
    
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
        finally{
            this.CloseConnection();
            this.cstClose();
            this.recolector();
        }
    }
    public Object cstParametroRetornoNombre(String nombreParametro){
        try{
            return cst.getObject(nombreParametro);
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        finally{
            this.CloseConnection();
            this.cstClose();
            this.recolector();
        }
    }
    public void cstEjecutar(){
        try{
            cst.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
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
    private void CloseConnection(){
        try {
            Conexion.getConnection().close();
        } catch (Exception e) {
        }
        
    }
    private void cstClose(){
        try {
             cst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
     private void recolector(){
        System.gc();
    }
}

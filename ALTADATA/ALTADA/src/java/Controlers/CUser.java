/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import Modelo.User;
import Utils.Mensaje;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="dtSelectionView")
@ViewScoped
public class CUser {

    public CUser() {
         this.objectoRegistra=new User();
    }
    private User objectoRegistra;
    private User objectoSelecciona;
    private ArrayList<User> arrayList =new ArrayList<User>();

    public User getObjectoRegistra() {
        return objectoRegistra;
    }

    public void setObjectoRegistra(User objectoRegistra) {
        this.objectoRegistra = objectoRegistra;
    }

    public User getObjectoSelecciona() {
        return objectoSelecciona;
    }

    public void setObjectoSelecciona(User objectoSelecciona) {
        this.objectoSelecciona = objectoSelecciona;
    }

    public ArrayList<User> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<User> arrayList) {
        this.arrayList = arrayList;
    }
   
    
    
    
     public String getSize() {
        if(this.arrayList==null) {
            return "0";
        } else {
            return arrayList.size()+"";
        }
    }
       public String doSendUser( User u){
        this.objectoSelecciona=u;
         return null; 
     }
    public String doRegistrar(){
        try{
            if(User.RegistrarUser(objectoRegistra)){
                Mensaje.guardarMensajeExito("Registrar User");
                this.objectoRegistra=new User();
            }else{
                Mensaje.manejarError(" Error Registrar User");
            }
        }catch(Exception e){
            Mensaje.addMensajeFatal(" Error Fatal Registrar User");
        }
        return null;
    }
    
//    public String doListar(int es){
//        try{
//            this.arrayList=User.Listar(es);
//            if(arrayList.isEmpty()){
//                Mensaje.manejarError("Listar User");                
//            }
//        }catch(Exception e){
//            Mensaje.addMensajeFatal("Listar User");
//        }
//        return null;
//    }
    public String doLimpiarLista(){
        arrayList=new ArrayList<User>();
        return null;
    }
}

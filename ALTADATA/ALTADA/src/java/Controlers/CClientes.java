
package Controlers;

import Modelo.Cliente;
import Utils.Mensaje;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="dtSelectionView")
@ViewScoped
public class CClientes implements Serializable{
    private Cliente objectoRegistra=new Cliente();
    private Cliente objectoSelecciona=new Cliente();
    private Cliente objeto_cliente_encontrado=new Cliente();
    private Cliente objeto_cliente=new Cliente();
    private ArrayList<Cliente> arrayList =new ArrayList<Cliente>();

   public CClientes() {
//        this.objeto_cliente=new Cliente();
//        this.objectoRegistra=new Cliente();
//        this.objeto_cliente_encontrado=new Cliente();
    }

    public Cliente getObjectoRegistra() {
        return objectoRegistra;
    }

    public void setObjectoRegistra(Cliente objectoRegistra) {
        this.objectoRegistra = objectoRegistra;
    }

    public Cliente getObjectoSelecciona() {
        return objectoSelecciona;
    }

    public void setObjectoSelecciona(Cliente objectoSelecciona) {
        this.objectoSelecciona = objectoSelecciona;
    }

    public Cliente getObjeto_cliente_encontrado() {
        return objeto_cliente_encontrado;
    }

    public void setObjeto_cliente_encontrado(Cliente objeto_cliente_encontrado) {
        this.objeto_cliente_encontrado = objeto_cliente_encontrado;
    }

    public Cliente getObjeto_cliente() {
        return objeto_cliente;
    }

    public void setObjeto_cliente(Cliente objeto_cliente) {
        this.objeto_cliente = objeto_cliente;
    }
    
  
   public ArrayList<Cliente> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Cliente> arrayList) {
        this.arrayList = arrayList;
    }

  public String getSize() {
        if(this.arrayList==null) {
            return "0";
        } else {
            return arrayList.size()+"";
        }
    }

     public String doSendCliente( Cliente a){
        this.objectoSelecciona=a;
         return null; 
     }
    
    public String doRegistrar(){
        try{
            if(Cliente.RegistrarCliente(objectoRegistra)){
                Mensaje.guardarMensajeExito("Registrar cliente");
                this.objectoRegistra=new Cliente();
            }else{
                Mensaje.manejarError(" Error Registrar Cliente");
            }
        }catch(Exception e){
            Mensaje.addMensajeFatal(" Error Fatal Registrar Cliente");
        }
        return null;
    }
        public String doListar(){
        try{
            this.arrayList=Cliente.Listar();
            if(arrayList.isEmpty()){
                Mensaje.manejarError("Listar Cliente");                
            }
        }catch(Exception e){
            Mensaje.addMensajeFatal("Listar Cliente");
        }
        return null;
    }

 public String doBuscar(){

        this.objeto_cliente_encontrado=Cliente.Obtener_cliente(this.objeto_cliente.getRut_cliente().trim());
        return null;
    }
    public String doLimpiarLista(){
        arrayList=new ArrayList<Cliente>();
        return null;
    }
}

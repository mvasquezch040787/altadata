
package Controlers;
import Modelo.Cliente;
import Modelo.Registro_llamada;
import Modelo.User;
import Utils.Mensaje;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="dtSelectionView")
@ViewScoped
public class CRegistro_llamada implements Serializable{
    
private Registro_llamada objetoRegistra_llamada=new Registro_llamada();
private Registro_llamada objetoReg=new Registro_llamada();
 private Registro_llamada objectoSelecciona=new Registro_llamada();
private Cliente objeto_cliente=new Cliente();
private Cliente objeto_cliente_encontrado=new Cliente();
private User objeto_usuario=new User();
private ArrayList<Registro_llamada> array_reg=new ArrayList<>();
        
    public CRegistro_llamada() {
        this.objetoRegistra_llamada=new Registro_llamada();
    }

    public Registro_llamada getObjetoRegistra_llamada() {
        return objetoRegistra_llamada;
    }

    public Registro_llamada getObjectoSelecciona() {
        return objectoSelecciona;
    }

    public void setObjectoSelecciona(Registro_llamada objectoSelecciona) {
        this.objectoSelecciona = objectoSelecciona;
    }

    public Registro_llamada getObjetoReg() {
        return objetoReg;
    }

    public void setObjetoReg(Registro_llamada objetoReg) {
        this.objetoReg = objetoReg;
    }

    public ArrayList<Registro_llamada> getArray_reg() {
        return array_reg;
    }

    public void setArray_reg(ArrayList<Registro_llamada> array_reg) {
        this.array_reg = array_reg;
    }

    public void setObjetoRegistra_llamada(Registro_llamada objetoRegistra_llamada) {
        this.objetoRegistra_llamada = objetoRegistra_llamada;
    }

    public Cliente getObjeto_cliente() {
        return objeto_cliente;
    }

    public void setObjeto_cliente(Cliente objeto_cliente) {
        this.objeto_cliente = objeto_cliente;
    }

    public Cliente getObjeto_cliente_encontrado() {
        return objeto_cliente_encontrado;
    }

    public void setObjeto_cliente_encontrado(Cliente objeto_cliente_encontrado) {
        this.objeto_cliente_encontrado = objeto_cliente_encontrado;
    }

    public User getObjeto_usuario() {
        return objeto_usuario;
    }

    public void setObjeto_usuario(User objeto_usuario) {
        this.objeto_usuario = objeto_usuario;
    }

    
    public String getSize() {
        if(this.array_reg==null) {
            return "0";
        } else {
            return array_reg.size()+"";
        }
    }
    
     public String doBuscar(){

        this.objeto_cliente_encontrado=Cliente.Obtener_cliente(this.objeto_cliente.getRut_cliente().trim());
        return null;
    }
        public String doListarHistorial(){
            try {
                this.array_reg=Registro_llamada.ListarHistorialRegistroLlamadaCliente(this.objeto_cliente.getRut_cliente().trim());
            } catch (Exception e) {
            }
       // this.objeto_cliente_encontrado=Cliente.Obtener_cliente(this.objeto_cliente.getRut_cliente().trim());
        return null;
    }
    
        public String doRegistrar(){
        try{
            objetoRegistra_llamada.setObj_user(this.objeto_usuario);
            objetoRegistra_llamada.setObj_cliente(this.objeto_cliente);
            if(Registro_llamada.RegistrarLlamada(objetoRegistra_llamada)){
                Mensaje.guardarMensajeExito("Registrar Llamada");
                this.objetoRegistra_llamada=new Registro_llamada();
            }else{
                Mensaje.manejarError(" Error Registrar Llamada");
            }
        }catch(Exception e){
            Mensaje.addMensajeFatal(" Error Fatal Registrar Llamada");
        }
        return null;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.event.ActionEvent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped

public class Mensaje {
    public Mensaje() {
    
    }
    public static void manejarError( Exception e, String evento )
    {
        String msg2 = "Operacion no se pudo realizar, Motivo " +" " + e.getMessage();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, evento,msg2 );  
        FacesContext.getCurrentInstance().addMessage(null, msg); 
    }
    public static void manejarError(String metodo, String evento )
    {
        String msg2 = "Operación: " + metodo + " " + "No se Pudo Realizar.";
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, evento,msg2 );  
        FacesContext.getCurrentInstance().addMessage(null, msg); 
    }
    public static void manejarError(String metodo, String evento,String razones )
    {
        String msg2 = "Operación: " + metodo + " " + "No se Pudo Realizar." + " " + razones;
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, evento,msg2 );  
        FacesContext.getCurrentInstance().addMessage(null, msg); 
    }
    
    public static void guardarMensajeExito(String metodo, String evento )
    {
    String msg2 = "Operación: " + metodo + " se ha Realizado con Exito.";
    //FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, evento,msg2 );  
    //FacesMessage msg = new FacesMessage("Successful", msg2 );  
    //FacesContext.getCurrentInstance().addMessage(null, msg);     
     FacesContext contex = FacesContext.getCurrentInstance();
     contex.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO,evento, msg2));       
    }
public static void addMensajeInfo(String mensaje){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(mensaje);
    //    message.setSeverity(FacesMessage.SEVERITY_INFO);        
      //  message.setDetail(mensaje);
        context.addMessage(null,message);

}
    public static void addMensajeFatal(String mensaje){
        String msg = "La operacion: " + mensaje + " No se pudo Realizar";
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage();
        message.setSeverity(FacesMessage.SEVERITY_FATAL); 
        message.setSummary("El Sistema Informa");
        message.setDetail(msg);        
        context.addMessage(null,message);
    }
    public static void addMensajeWarn(String mensaje){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage();
        message.setSeverity(FacesMessage.SEVERITY_WARN);
        //message.setSummary("Name Field is Blank");
        message.setSummary("El Sistema Informa");
        message.setDetail(mensaje);
        context.addMessage(null,message);
    }
public static void addMensajeError(String mensaje){
        String msg = "La operacion: " + mensaje + " No se pudo Realizar";    
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage();
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        //message.setSummary("Name Field is Blank");
        message.setDetail(msg);
        message.setSummary("El Sistema Informa");
        context.addMessage(null,message);

    }
 public static void guardarMensajeExito( String metodo )
    {
    String msg = "La operacion: " + metodo + " se ha realizado con Éxito";
    FacesContext context = FacesContext.getCurrentInstance( );
    context.addMessage( null, new FacesMessage( msg ) );
    } 
  public static void manejarError( Exception e ){
 
     String msg = "La operacionÂ³n no se puedo realizar, Motivo" + e.getMessage();
    FacesContext context = FacesContext.getCurrentInstance( );
    context.addMessage( null, new FacesMessage( msg ) );
    }
    public static void manejarError(String metodo )
    {
        String msg = "La operacion: " + metodo + " No se puedo realizar";
    FacesContext context = FacesContext.getCurrentInstance( );
    context.addMessage( null, new FacesMessage( msg ) );
    }


/////////////////////////////////////////////////////////////////////////////////////77

}

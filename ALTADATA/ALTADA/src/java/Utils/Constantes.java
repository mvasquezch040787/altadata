package Utils;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

public class Constantes {
  public final static String RUTA_JASPER=
  "resources"+
 System.getProperty("file.separator") +
 "report"+System.getProperty("file.separator"); 
 public final static String RUTA_DOWNLOAD=
 "resources"+System.getProperty("file.separator")
 + "download"+
  System.getProperty("file.separator");
public final static String 
        RUTA_DOWNLOAD_WEB="/resources/download/";
public final static String RUTA_SERVIDOR_FISICA=
 ((ServletContext)FacesContext.
   getCurrentInstance().getExternalContext().
         getContext()).getRealPath("/");
public final static String 
        PAGE_INGRESO="indexok.uap";
public final static String PAGE_LOGIN=
        "index.uap";
}

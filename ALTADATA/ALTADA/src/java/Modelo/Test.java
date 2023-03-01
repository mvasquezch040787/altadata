/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author FULLSTACK
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
 
//        System.out.println("Obtener_cliente");
//        String rut_cliente = "4445815519";
//        Cliente expResult = null;
//        Cliente result = Cliente.Obtener_cliente(rut_cliente);
//        
//        // TODO review the generated test code and remove the default call to fail.
//       
//        System.out.println(result.Apellidos_nombres);
//        System.out.println(result.direccion);
        
//        ArrayList<Cliente> gunList = Cliente.Listar();
//for (int x=0; x<gunList.size(); x++)
//    System.out.println(gunList.get(x).Apellidos_nombres);
//    }
        String rut_cli="4445815519";
        ArrayList<Registro_llamada> gunList = Registro_llamada.ListarHistorialRegistroLlamadaCliente(rut_cli.trim());
for (int x=0; x<gunList.size(); x++)
    System.out.println(gunList.get(x).getObj_cliente().getApellidos_nombres());
    }
    
}

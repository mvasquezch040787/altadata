/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils;

import java.util.Random;


public class ObtieneNombre {
 public static String getCadenaAlfanumAleatoria (int longitud){
String cadenaAleatoria = "";
long milis = new java.util.GregorianCalendar().getTimeInMillis();
Random r = new Random(milis);
int i = 0;
while ( i < longitud){
char c = (char)r.nextInt(255);
if ( (c >= '0' && c <='9') || (c >='A' && c <='Z') ){
cadenaAleatoria += c;
i ++;
}
}
return cadenaAleatoria;
} 
    public static void main(String[] args) {
       System.out.print(ObtieneNombre.getCadenaAlfanumAleatoria(10));
    }
 
}

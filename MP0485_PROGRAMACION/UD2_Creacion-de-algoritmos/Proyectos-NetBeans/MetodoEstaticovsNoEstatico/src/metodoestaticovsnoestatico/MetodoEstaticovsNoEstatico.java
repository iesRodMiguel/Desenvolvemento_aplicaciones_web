/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodoestaticovsnoestatico;

/**
 *
 * @author miguel
 */

public class MetodoEstaticovsNoEstatico {

    /**
     * @param c
     * @param d
     * @return 
     */
    
    // MÉTODO NO ESTATICO: HAY QUE INSTANCIARLO; EL MÉTODO SUMAR NO PERTENECE A LA CLASE, SINO AL OBJETO QUE CREEMOS
    
    public int sumar(int c, int d) {
        return c + d;
    }
    
    // MÉTODO ESTATICO: SE PUEDE UTILIZAR SIN LA NECESIDAD DE CREAR NINGUN OBJETO
    
    public static int restar (int a, int b){
        return a - b;
    } 
    
    public static void main(String[] args) {
        
        String sep = " ";
        
        int r = MetodoEstaticovsNoEstatico.restar(5, 1); //Invoco el método directamente de la clase
        // int s = MetodoEstaticovsNoEstatico.sumar(5, 1); non-static method sumar(int,int) cannot be referenced from a static context
        
        System.out.println("Método estático:");
        System.out.println("r = "+r);
        System.out.println(sep);

        
        MetodoEstaticovsNoEstatico m = new MetodoEstaticovsNoEstatico(); //CREAMOS EL OBJETO 'm'
        
        int s = m.sumar(5, 1); // Invoco el método desde el objeto 'm' 
        
        System.out.println("Método no estático:");
        System.out.println("s = "+s);

    }
    
    
}

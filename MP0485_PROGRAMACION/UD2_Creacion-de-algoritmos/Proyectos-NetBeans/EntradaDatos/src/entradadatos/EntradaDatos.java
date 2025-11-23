/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package entradadatos;

/**
 *
 * @author miguel
 */

// Importamos a clase Scanner
import java.util.Scanner; 

public class EntradaDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       //1º CREAMOS UN OBJETO 'sc' PARA ESCANEAR A ENTRADA DE DATOS
       Scanner sc = new Scanner(System.in);
       
       //MEDIANTE UN PRINT MOSTRAMOS UN MENSAJE AL USUARIO PARA QUE INTRODUZCA UN TEXTO
       System.out.print("Introduce tu nombre: ");
       
       //Intanciamos la clase 'sc' en la variable nombre para escanear una línea completa de texto
       String nombre = sc.nextLine();
       
       //Pedimos al usuario que introduza a súa idade
       System.out.print("Introduce a túa idade: ");
       
       //Intanciamos la clase 'sc' en la variable edad para escanear una línea completa de texto
       int edad = sc.nextInt(); 
       
        //Mostramos los datos introducidos
       System.out.println("Ola " + nombre + "! Tes " + edad + " anos.");
    }
    
   
}

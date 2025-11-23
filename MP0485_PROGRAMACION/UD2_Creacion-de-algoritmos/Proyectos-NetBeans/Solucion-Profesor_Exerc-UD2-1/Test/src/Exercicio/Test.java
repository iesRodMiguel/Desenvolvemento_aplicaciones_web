/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Exercicio;

import java.util.Scanner;

/**
 *
 * @author xavi
 */
public class Test {
    
     static boolean ePar(int num) {
         return (num%2 == 0);
     }
     
     static void saluda(String saludo) {
         System.out.println(saludo);
     }
    

     static String pregunta(String texto) {
         Scanner scn;
         scn=new Scanner(System.in);
         System.out.print(texto);
         return scn.nextLine();
     }
     
     static int preguntaInt(String texto) {
         Scanner scn;
         scn=new Scanner(System.in);
         int num=0;
         boolean ok=false;
         do {
            System.out.print(texto);
            String str=scn.nextLine();
            try  {
                num=Integer.parseInt(str);
                ok=true;
            } catch(NumberFormatException e) {
                System.out.println("Escribe un número enteiro");
            }
         } while(!ok);
         return num;
     }
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean ok=false;
        Test.saluda("Benvidos ao comprobador de pares");
        do {
            String numstr=Test.pregunta("Escribe un numero entero: ");
            try {
                int numero=Integer.parseInt(numstr);
                if (ePar(numero)) System.out.println("E par");
                else              System.out.println("E Impar");
                ok=true;
            } catch(NumberFormatException e) {
                System.out.println("Debes escribir un número");
            }
        } while(!ok);
        
    }
    
}

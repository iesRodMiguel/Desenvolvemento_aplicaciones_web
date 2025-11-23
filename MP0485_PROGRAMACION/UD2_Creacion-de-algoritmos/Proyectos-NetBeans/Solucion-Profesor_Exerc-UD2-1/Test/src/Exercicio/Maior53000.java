/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio;

/**
 *
 * @author xavi
 */
public class Maior53000 {
        public static void main(String[] args) {
        boolean eprimo=false;
        int suma=0;
        String ok="s";
        int num;
        
        do {        
            num=Test.preguntaInt("Numero:");
            eprimo=NumUtils.ePrimo(num);
            if (eprimo) {
                ok=Test.pregunta("E primo, s para reintentar ");
            }
        } while(eprimo && ok.equals("s"));
        
        if (ok.equals("s")) {
            if (num > 53400)  System.out.println("Sirve, e maior de 53400");
            else              System.out.println("Non sirve");
        }
    }    
}

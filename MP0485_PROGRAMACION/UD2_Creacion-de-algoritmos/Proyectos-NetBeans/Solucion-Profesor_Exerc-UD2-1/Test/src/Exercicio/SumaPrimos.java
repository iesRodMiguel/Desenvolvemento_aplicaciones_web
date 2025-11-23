/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio;

/**
 *
 * @author xavi
 */
public class SumaPrimos {
        public static void main(String[] args) {
        int suma=0;
        int num=Test.preguntaInt("Numero:");
                
        while (num>1) {
            if (NumUtils.ePrimo(num)) suma=suma+num;
            num--;
        }
        System.out.println("Total "+suma);
    }
}

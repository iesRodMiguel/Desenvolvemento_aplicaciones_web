/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio;

/**
 *
 * Pedir el numero
 */
public class Factores {
    public static void main(String[] args) {
        int num=Test.preguntaInt("Numero:");
                
        while (num>1) {
            int divisor=NumUtils.primeiroDivisor(num);
            System.out.println(divisor);
            num=num/divisor;
        }
    }
}

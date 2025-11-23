/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio;

/**
 *
 * @author xavi
 */
public class EPrimo {
    public static void main(String[] args) {
        int num=Integer.parseInt(Test.pregunta("Numero:"));
        if (NumUtils.ePrimo(num)) System.out.println("E primo");
        else                      System.out.println("Non é primo");
    }
}

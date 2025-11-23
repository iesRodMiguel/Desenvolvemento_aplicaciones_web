/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio;

/**
 *
 * @author xavi
 */
public class PrimeiroDivisorV1 {
    public static void main(String[] args) {
        int num=Integer.parseInt(Test.pregunta("Numero:"));
        int divisor=NumUtils.primeiroDivisor(num);
        if (divisor == 0) System.out.println("Non ten divisores maiores que 1");
        else              System.out.println("O primeiro divisor é "+divisor);
    }
}

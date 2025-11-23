/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio;

import java.util.Scanner;

/**
 *  Pedir numero
 *  Si el numero es > 1
 *    Empezando en el 2 buscar un divisor 
 *    Indicar el divisor
 *   Si no
 *    Indicar que debe ser mayor que 1
 * 
 */
public class PrimeiroDivisor {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        System.out.println("Numero: ");
        int num=scn.nextInt();
        if (num > 1) {
            int div=2;
            while (num%div != 0) div++;
            System.out.println("O primeiro divisor de "+num+" e "+div);
        } else {
            System.out.println("Non ten divisores > 1");
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio;

/**
 *
 * @author xavi
 */
public class NumUtils {
    /**
     * 
     * Si el numero es mayor que 1
     *    Empiezo en el 2 y voy dividiendo hasta que encuentre un divisor
     *    Devuelvo el divisor
     * Si no
     *    No existe
     * FinSi
     */
    
    public static int primeiroDivisor(int num) {
        if (num > 1) {
            int div=2;
            while (num%div != 0) div++;
            return div;
        }
        return 0;
    }
    
    public static boolean ePrimo(int num) {
        /**
         * if (num>1) {
         *   if (NumUtils.primeiroDivisor(num)==num) return true;
         * }
         * return false;
         */
        return ((num > 1) && (NumUtils.primeiroDivisor(num)==num));
    }
     
}

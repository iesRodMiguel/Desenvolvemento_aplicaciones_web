/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.rodeira.programacion.utils;

/**
 *
 * @author miguel
 */
public class ComRodeiraProgramacionUtils {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StringUtils strUtl = new StringUtils();
        
        int cuentaNumVocales = strUtl.numvocals("El uso de tonos en contraste (morado y amarillo, por ejemplo) da"
               + " un realce al personaje, destacando las pinceladas gruesas y "
               + "difuminadas del fondo, la figura realza al parecer emerger de "
               + "entre la cortina sombría de pintura rústica utilizada, con "
               + "principal protagonismo en su rostro y manos del Papa, por "
               + "el impacto que causa a primera vista el verlo.");
        
        System.out.printf("El texto introducido tiene %d vocales\n", cuentaNumVocales);
        

        String reversedStr = strUtl.cadenaAlReves("el impacto que causa a primera vista el verlo.");        
        System.out.printf("El texto introducido al revés es: %s\n", reversedStr);
        
        Boolean isPalindromous = strUtl.ePalindroma("Sé verlas al revés");
        System.out.printf("¿El texto introducido es palindromo? %s\n", isPalindromous);
        
        String strLimpio = strUtl.clean("     El uso de tonos    en contraste (morado y amarillo, por ejemplo) da    ");
        System.out.printf("El texto introducido sin espacios no permitidos es: %s\n", strLimpio);
        
        String [] inputPalabras = strUtl.getWords("que buen paseo", 3, 4);
        System.out.println(inputPalabras);

    }
    
}

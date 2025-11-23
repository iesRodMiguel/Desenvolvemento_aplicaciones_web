/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.com.iesrodeira.programacion.utils;

import java.util.Scanner;
/**
 *
 * @author miguel
 */
public class StringUtils {
    
   public static int numvocals (String texto){
       
       texto = "El uso de tonos en contraste (morado y amarillo, por ejemplo) da"
               + " un realce al personaje, destacando las pinceladas gruesas y "
               + "difuminadas del fondo, la figura realza al parecer emerger de "
               + "entre la cortina sombría de pintura rústica utilizada, con "
               + "principal protagonismo en su rostro y manos del Papa, por "
               + "el impacto que causa a primera vista el verlo.";
    
       /*String.charAt(int index)--> Obtener cada carácter del texto.*/
       
       /*Character es una clase (osea un objeto) del paquete java.lan cuyo 
       propósito es encapsular un valor de tipo primitivo char y proporcionar 
       métodos utilitarios para trabajar con caracteres
       
       ¿Por qué uso Character si ya tengo char?

        - char es un tipo primitivo: representa directamente un punto de código 
        UTF-16.
           (Para un número primitivo (int) está la clase Integer.
            Para un carácter primitivo (char) está la clase Character.)

        - Character es la clase envoltorio (wrapper class) para char.

        Esto significa que puedo almacenar un char dentro de un objeto 
        Character, pero sobre todo que puedo usar métodos estáticos que ayudan a 
        inspeccionar y transformar caracteres.
       
       */
       
        int numDeVocales = 0;

        for (int i = 0; i < texto.length();  i++){ 
            
            char caracter = Character.toLowerCase(texto.charAt(i));
            
            if(caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u'){
                numDeVocales++;
            }
        }
        
        System.out.println(numDeVocales);
        return numDeVocales;
    } 
}

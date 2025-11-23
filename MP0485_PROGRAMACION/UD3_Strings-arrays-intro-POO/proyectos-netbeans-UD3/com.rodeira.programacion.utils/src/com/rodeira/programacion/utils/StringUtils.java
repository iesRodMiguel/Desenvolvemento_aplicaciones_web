/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rodeira.programacion.utils;

/**
 *
 * @author miguel
 */
public class StringUtils {
    
    public int numvocals (String texto){
    
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
        
        return numDeVocales;
    } 
    
    public String cadenaAlReves (String s){
        
        
        String reverseString = new StringBuilder(s).reverse().toString();
    
        return reverseString;
        
        /*¿Por qué tengo que utilizar el método toString()?
        
            El constructor StringBuilder devuelve un objeto StringBuilder, no un dato primitivo String
        
            De hecho los datos primitivos (String, Int, etc.) son INMUTABLES --> NO PUEDEN MODIFICARSE
            UNA VEZ CREADOS.
        
            Pero los objetos como StringBuilder SON MUTABLES → puedes invertir, insertar, borrar caracteres 
            sin crear nuevos objetos.
        
            Por eso, en este método, cojo la cadena de texto String s y, para invertirla, la paso por el
            constructor StringBuilder como parámetro. Ahora que es un objeto StringBuilder puedo acceder
            a su método .reverse() y darle la vuelta al texto.
        
            Ahora tengo el texto dado la vuelta pero como objeto StringBuilder, así que para qué mi método
            me devuelva el String reverseString, tengo que convertilo a dato primitivo String mediante el 
            método toString().
        
        */
    }
    
    //public boolean ePalindroma(String s); que nos indica si unha frase recibida como argumento (s) é palíndroma ou non.
    
    public boolean ePalindroma(String s){
        
        Boolean isPal;
        
        String strSinEspacios = s.replace(" ", "");
        
        String validarInput = new StringBuilder(strSinEspacios).reverse().toString();
        
        if (validarInput.equalsIgnoreCase(strSinEspacios)){
            isPal = true;
        } else {
            isPal = false;
        }
        
        
        return isPal;
    }
    
    //public String clean(String s);  que retorna a frases sen espazos no inicio 
    //e no final e como máximo un único espazo de separación entre palabras  
    //( "   hola      que       tal " -->        "hola que tal",  o mellor é facelo con expresións regulares, 
    //mira  replaceAll  na clase String)
    
    public String clean(String s){
    
        String strSinEspInFin = s.trim(); // quita los espacios al principio y al final
        
        String strLimpio = strSinEspInFin.replaceAll("\\s+", " ");
        
        
        return strLimpio;
    }
    
    // public String[] getWords(String s, int min, int max);  que retorna un array de String[] coas palabras 
    //da frase que teñen polo menos min caracteres e como moito max caracteres.  PISTA:      Podes dividir o 
    // String en palabras co método split() de String. Suxiro ir creando un novo String coas palabras elixidas e 
    //a continuación dividilas de novo co método split() da clase String)
    
    public String[] getWords(String s, int min, int max){
        
        String[] inputPalabras = s.split(" ");
        
        for(String i: inputPalabras){
            if(i.length()>=min && i.length()<=max){
                return inputPalabras;
            }
        
        
        }
       
    
        return inputPalabras;
    }
    
}

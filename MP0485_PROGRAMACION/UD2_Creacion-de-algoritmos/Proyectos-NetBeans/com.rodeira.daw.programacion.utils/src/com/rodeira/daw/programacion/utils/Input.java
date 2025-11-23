/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rodeira.daw.programacion.utils;

/**
 *
 * @author miguel
 */

import java.util.Scanner;


public class Input {
    
    /**
     * @param args the command line arguments
     */
    
    public static void runInput (String[] args){
    
        //1º CREAMOS EL PROMPT QUE VA A VER EL USUARIO

        System.out.println("Introduce un texto: ");

        //2º CREAMOS UN OBJETO 'scn' PARA ESCANEAR A ENTRADA DE DATOS

        Scanner scn = new Scanner(System.in);
                
        String textoAmostrar = scn.nextLine();
        
        System.out.println("Respuesta del usuario al prompt (input): " + textoAmostrar);

    }
}

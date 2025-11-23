/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testdatas;

/**
 *
 * @author miguel
 */

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TestDatas {

    /**
     * @param strData
     * @param errmsg
     * @return 
     */

    public static LocalDate StringToDate(String strData, String errmsg){
    
        LocalDate data;

        String format1 = "dd-MM-yyyy";
//        String format2 = "dd/MM/yyyy";
        
        try {
        
            data = LocalDate.parse(strData, DateTimeFormatter.ofPattern(format1));
            
//          System.out.println(data);
//          System.out.println("a variable 'data' é un obxeto da clase: " + data.getClass());
            
       } catch (DateTimeParseException e){
        
            throw new IllegalArgumentException(errmsg);
            
        }
        

        
    return data;
    }
    
    /**
     * Comprueba si una fecha está dentro de un rango (mínimo y máximo).
     * 
     * @param data       la fecha que introdujo el usuario
     * @param dataMin    fecha mínima válida (como String)
     * @param dataMax    fecha máxima válida (como String)
     */
    
    
    public static void validarRango(LocalDate data, LocalDate dataMin, LocalDate dataMax){
    
        if (data.isBefore(dataMin) || data.isAfter(dataMax)){
        
            throw new IllegalArgumentException("A data está fora do rango permitido.");
        
        }
    
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scn = new Scanner(System.in);
        
        String prompt = "Introduce unha data: dd-MM-yyyy";
        
        System.out.println(prompt);
        String texto = scn.nextLine();
        String errmsg = "A data non é correcta";
        
        String dataMin = "01-01-1950";
        String dataMax = "31-12-2050";
        
//      Utilizamos el método stringToDate() para convertir a objetos LocalDate el texto introducido por el usuario,
//      la fecha mínima y la fecha máxima
//
        LocalDate data = TestDatas.StringToDate(texto, errmsg);
        LocalDate data_min = TestDatas.StringToDate(dataMin, errmsg);
        LocalDate data_max = TestDatas.StringToDate(dataMax, errmsg);
        
//      Utilizamos el método validarRango() para comprobar si la fecha introducida por el usuario está dentro del rango
//      que hemos establecido de fechas minima y maxima
        
        TestDatas.validarRango(data, data_min, data_max);
//
        System.out.println("A fecha introducida: " + data + " é válida.");
       
        
    }
    
    
}

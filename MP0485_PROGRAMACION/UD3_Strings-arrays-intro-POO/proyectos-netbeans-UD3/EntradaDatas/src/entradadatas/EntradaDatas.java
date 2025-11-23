/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package entradadatas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author miguel
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class EntradaDatas {
    
       
    public static LocalDate stringToDate(String strdate,String errmsg) {
        LocalDate date=null;
        String formats="[dd-MM-yyyy][dd/MM/yyyy]";
        try {
            System.out.println(strdate);
            date=LocalDate.parse(strdate,DateTimeFormatter.ofPattern(formats));
        } catch(DateTimeParseException e) {
            throw new IllegalArgumentException(errmsg);
        }
        return date;
    }
    
    public static LocalDate inputDate(String prompt,String min, String max) throws InterruptedException {
        Scanner scn=new Scanner(System.in);
        boolean ok=false;
        String extra_prompt="";
        LocalDate date_min=null;
        LocalDate date_max=null;
        LocalDate date_input=null;
        
        if (min!=null) {
            date_min=stringToDate(min,"A data minima é errónea");
            extra_prompt=">="+min;
        }
        if (max!=null) {
            date_max=stringToDate(max,"A data máxima é errónea");
            if (!"".equals(extra_prompt)) extra_prompt+=",";
            extra_prompt+="<="+max;
        }
        if ((date_min!=null) && (date_max!=null) && (!date_min.isBefore(date_max))) 
            throw new IllegalArgumentException("A data minima debe ser anterior a máxima");
        if (!"".equals(extra_prompt)) extra_prompt=" ["+extra_prompt+"]";
        prompt=prompt+extra_prompt+" (* para cancelar): ";
        do {
            try {
                System.out.print(prompt);
                String texto=scn.nextLine();
                if (texto.equals("*"))
                    throw new InterruptedException("Operación Cancelada");
                date_input=stringToDate(texto,"Fecha incorrecta, inténtao de novo");
                if ((date_min!=null) && (date_input.isBefore(date_min)))
                    throw new IllegalArgumentException("A data e menor que a mínima");
                if ((date_max!=null) && (date_input.isAfter(date_max)))
                    throw new IllegalArgumentException("A data e maior que a máxima");
                ok=true;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while(!ok);
        return date_input;
    }

}

    


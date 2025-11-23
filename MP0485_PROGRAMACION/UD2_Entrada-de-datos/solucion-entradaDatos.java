/*
El archivo EntradaDatas.java implementa una librería de utilidades para gestionar entrada de fechas desde teclado.
Su función principal es permitir al usuario escribir una fecha, validarla y devolverla como un objeto LocalDate, garantizando que:

Tiene formato correcto (dd-MM-yyyy o dd/MM/yyyy)

Está dentro de un rango válido (mínimo y máximo)

Puede cancelarse introduciendo *

Lanza excepciones específicas si hay errores.
*/

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/*
                java.time.LocalDate

Clase de la API moderna de fechas en Java (desde Java 8).

Representa una fecha sin hora ni zona horaria (solo año, mes, día).

Permite:

Crear fechas (LocalDate.of(2025, 9, 30))

Comparar fechas (isBefore(), isAfter())

Analizar texto (parse())

Formatear texto (format())

--------------------------------------------------------------------------------
                java.time.format.DateTimeFormatter

Clase que define patrones de formato para leer o escribir fechas.

En este caso, se usa para decirle al programa cómo debe interpretar el texto que escribe el usuario.

--------------------------------------------------------------------------------

                java.time.format.DateTimeParseException

Excepción que lanza LocalDate.parse() si el texto no puede convertirse en fecha.

Ejemplo: "32-13-2025" → lanza esta excepción.

En el código, se captura para personalizar el mensaje de error.

--------------------------------------------------------------------------------

                java.util.Scanner

Clase para leer texto desde una entrada (por ejemplo, el teclado).

Permite leer líneas completas (nextLine()) o valores específicos (nextInt()).

Aquí se usa para capturar lo que el usuario escribe al introducir una fecha.
*/

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
    
    /*
        
    */
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rodeira.daw.programacion.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author miguel
 */
public class EntradaDatas {
    
    
    /*Es una 'clase de utilidades estática', es decir:
    *   Todos sus métodos son `public static`.
    *   No hace falta crear un objeto `EntradaDatas` para usarla.*/
    
    public static LocalDate stringToDate (String strdate, String errmsg){
        
        /*1º Método del programa: Define el formato que queremos que tenga la fecha. Recibe dos argumentos:
        
            - String strdate: Será la fecha introducida por el usuario, que validaremos para ver si tiene el formato correcto
            - String errmsg: Mensaje de error que enviaremos si la fecha provoca un error al intentar parsearla
        */
        
        LocalDate date = null; // La inicializamos como 'null' porque aún no sabemos si el texto es correcto
        String formats = "[dd-MM-yyyy] [dd/MM/yyyy]"; // Definimos los formatos que queremos que tenga la fecha
        
        try {
            
            date = LocalDate.parse(strdate, DateTimeFormatter.ofPattern(formats));
            
            /* AQUI ES DONDE EL MÉTODO HACE COSAS
            
              Llamada a `LocalDate.parse(strdate, DateTimeFormatter.ofPattern(formats))`. Vamos a analizarlo de dentro a fuera:
            
                - strdate: es el texto original del usuario.
                
                - DateTimeFormatter.ofPattern(formats): Crea un objeto que define como se debe entender ese texto.
                  En este caso acepta los formatos definidos por nosotros en la variable 'formats'.
                  
                - LocalDate.parse(): Analiza el texto con ese patrón. Si el texto coincide con el patrón y representa una fecha real, 
                  devuelve un objeto `LocalDate` (el que hemos inicializado antes como LocalDate date = null;).
            
            */
            
        } catch (DateTimeParseException e){
        
            throw new IllegalArgumentException(errmsg);
            
            /*Si el texto no coincide con el patrón y representa una fecha real, lanza `DateTimeParseException`.*/
            
            /*¿QUÉ ES LA 'e'?
            
              La línea 'catch (DateTimeParseException e)' tiene esta estructura general:
            
                    | catch (TipoDeExcepcion nombreDeLaVariable) |
            
              Cuando ocurre un error Java crea un objeto de tipo excepción (por ejemplo DateTimeParseException) que describe:
                   
                    - Qué tipo de error es.
                    - Dónde ocurrió.
                    - Qué mensaje de error trae el sistema.
                    - Opcionalmente, la causa original del error si se encadenan excepciones.
            
              Ese objeto 'se entrega' al bloque catch a través de una variable.
              En el código, esa variable  se llama 'e' por convención. Pero podria llamarse como quieras (error, ex, fallo, etc.).
            
              DENTRO DEL CATCH, esta variable permite acceder a información acerca del error. Por ejemplo:

                        catch (DateTimeParseException e) {
            
                            System.out.println("Ocurrió un error: " + e.getMessage());
                        
                        }
              El método getMessage(), definido en la clase Throwable, devuelve una descripción del error, como:
                
                    Text '31/02/2020' could not be parsed: Invalid date;
            
              También se pueden invocar otros métodos de esta clase como:
                - e.printStackTrace() → muestra en consola toda la traza del error.
                - e.getCause()

            
            */
        }
        
        
        return date;
        
        /*
            return date --> Devuelve el objeto LocalDate para que el resto del código pueda trabajar con él (compararlo, almacenarlo, etc.)
        */
    }
    
    public static LocalDate inputDate (String prompt, String min, String max){
    
    
    /*No es que el método tenga dos nombres; El método se llama inputDate y va a devolver una fecha válida LocalDate.
        
        (String prompt, String min, String max) → son los tres valores de entrada:

            - prompt: mensaje a mostrar.

            - min: fecha mínima.

            - max: fecha máxima.
        
     ¿Cúal es el propósito del método?
        
        Gestionar toda la interacción con el usuario para introducir una fecha válida:

            - Mostrar mensajes.

            - Leer texto con Scanner.

            - Validar contra límites mínimo y máximo.

            - Repetir si hay error.

            - Cancelar con *.
    */
    
        Scanner scn = new Scanner(System.in);
        boolean ok = false;
        prompt = "Introduce unha data: dd-MM-yyyy / dd/MM/yyyy";
        String extra_prompt = ""; // Inicializamos extra_prompt como una cadena de texto vacía
        LocalDate date_min = null;
        LocalDate date_max = null;
        LocalDate input_date = null;
    
        if (min!=null){
    
            date_min = stringToDate(min, "A data mínima é erronea");
            extra_prompt = ">=" + min;
        }
    
        if (max!=null){
        
            date_max = stringToDate(max, "A data máxima é erronea");
            extra_prompt = "<=" + max;
        }
    
        if ((date_min!=null) && (date_max!=null) && (!date_min.isBefore(date_max))) {
            throw new IllegalArgumentException("A fecha mínima debe ser anterior á máxima");
        }
        
        if (!"".equals(extra_prompt)) {
        
            extra_prompt = " [" + extra_prompt + "]";
            prompt = prompt + extra_prompt + " (* para cancelar): ";
        
        }
        
       do {
       
           try {
           
               System.out.print(prompt);
               
               String texto = scn.nextLine();
               
               if(texto.equals("*")){
               
//                   throw new InterruptedException("Operación cancelada");
                   System.out.print("Operación cancelada");
                   input_date = stringToDate(texto,"Fecha incorrecta, inténtao de novo");
               }
               
               if((date_min!=null) && (input_date.isBefore(date_min))){
               
                   throw new IllegalArgumentException("A data é menor que a mínima");
               
               }
               
               if((date_max!=null) && (input_date.isAfter(date_max))){
               
                   throw new IllegalArgumentException("A data é maior que a data máxima");
               
               }
           
           }
               
//               ok = true;
           
            catch (IllegalArgumentException e) {
           
               System.out.println(e.getMessage());
           
           }
       
       } while (!ok);
        
        return input_date;
    }
    
    // Método público que centraliza la ejecución del flujo completo
    public static void runApp() {
        System.out.println("=== Programa de Entrada de Datas ===");
        try {
            LocalDate fecha = inputDate("Introduce unha data", "01-01-2000", "31-12-2030");
            System.out.println("✅ Data introducida correctamente: " + fecha);
//           } catch (InterruptedException e) {
//            System.out.println("⚠️  Operación cancelada polo usuario.");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Erro: " + e.getMessage());
       }
    }
    
       
//    public static LocalDate stringToDate(String strdate,String errmsg) {
//        
//        LocalDate date=null;
//        String formats="[dd-MM-yyyy][dd/MM/yyyy]";
//        
//        try {
//            
//            System.out.println(strdate);
//            
//            date=LocalDate.parse(strdate,DateTimeFormatter.ofPattern(formats));
//            
//            
//        } catch(DateTimeParseException e) {
//            
//            throw new IllegalArgumentException(errmsg);
//        }
//        
//        return date;
//    }
//    
//    public static LocalDate inputDate(String prompt,String min, String max) throws InterruptedException {
//        
//        Scanner scn=new Scanner(System.in);
//        boolean ok=false;
//        
//        String extra_prompt="";
//        
//        LocalDate date_min=null;
//        LocalDate date_max=null;
//        LocalDate date_input=null;
//        
//        if (min!=null) {
//        
//            date_min=stringToDate(min,"A data minima é errónea");
//            extra_prompt=">="+min;
//        }
//        if (max!=null) {
//           
//            date_max=stringToDate(max,"A data máxima é errónea");
//            
//            if (!"".equals(extra_prompt)) extra_prompt+=",";
//            extra_prompt+="<="+max;
//        }
//        if ((date_min!=null) && (date_max!=null) && (!date_min.isBefore(date_max))) 
//            throw new IllegalArgumentException("A data minima debe ser anterior a máxima");
//        
//        if (!"".equals(extra_prompt)) extra_prompt=" ["+extra_prompt+"]";
//        prompt=prompt+extra_prompt+" (* para cancelar): ";
//        
//        do {
//            try {
//                
//                System.out.print(prompt);
//                
//                String texto=scn.nextLine();
//                
//                if (texto.equals("*"))
//                
//                    throw new InterruptedException("Operación Cancelada");
//                date_input=stringToDate(texto,"Fecha incorrecta, inténtao de novo");
//                
//                if ((date_min!=null) && (date_input.isBefore(date_min)))
//                
//                    throw new IllegalArgumentException("A data e menor que a mínima");
//               
//                if ((date_max!=null) && (date_input.isAfter(date_max)))
//                
//                    throw new IllegalArgumentException("A data e maior que a máxima");
//                
//                ok=true;
//            
//            } catch(IllegalArgumentException e) {
//            
//                System.out.println(e.getMessage());
//            }
//        
//        } while(!ok);
//        
//        return date_input;
//    }
//    // 👉 Método público que centraliza la ejecución del flujo completo
//    public static void runApp() {
//        System.out.println("=== Programa de Entrada de Datas ===");
//        try {
//            LocalDate fecha = inputDate("Introduce unha data", "01-01-2000", "31-12-2030");
//            System.out.println("✅ Data introducida correctamente: " + fecha);
//        } catch (InterruptedException e) {
//            System.out.println("⚠️  Operación cancelada polo usuario.");
//        } catch (IllegalArgumentException e) {
//            System.out.println("❌ Erro: " + e.getMessage());
//        }
//    }
}



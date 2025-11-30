/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package axenda.utils;

/**
 *
 * @author miguel
 */

import java.util.InputMismatchException; /*Excepcion propia de Integer.pareInt() y otros métodos
                                          de Integer para cuando el input que se ha introducido no es un numero*/
import java.util.Scanner;

public class Input {
    
    /*static final: Estas variables son constantes (non cambian) e pertencen á clase, non a obxectos específicos. Al ponerles
    final, no se pueden modificar ni desde dentro de la clase */
    
    private static final String REGEX_TELEFONO = "^(\\+34)?[0-9]{9}$";   
    private static final String REGEX_EMAIL = "^[a-z0-9][a-z0-9._-]+\\@[a-z]+\\.[a-z]{2,4}$";
    private static final Scanner scn = new Scanner(System.in);
//    int option;



    
    
    public static void testNif (String nif) throws IllegalArgumentException{
        
        char[] control = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        
        char letra = Character.toUpperCase(nif.charAt(8));
        String num_str = nif.substring(0, 8);
        
        if (nif == null || nif.length() != 9){
            
            throw new IllegalArgumentException("O nif debe conter 9 díxitos e unha letra");            
        } 
        
        try {
             
                int num = Integer.parseInt(num_str); /*INTENTAMOS CONVERTIR LA STRING num_str A NUMERO MEDIANTE EL MÉTODO parseInt() de 
                la clase Integer*/
                int index = num%23;
                char letraControl = control[index];
                
                System.out.println("El dni: " + nif + " es válido");
                
                if (letra!=letraControl) {
                
                    throw new IllegalArgumentException("Non coincide a letra. Nif non válido");
                
                }
            
            } catch (NumberFormatException e){

                System.out.println(e.getMessage());
            
                throw new IllegalArgumentException("Nif non válido");            
            }
    
    
    }
    
    public static void testEmail (String email) throws IllegalArgumentException {
    
        if(!email.toLowerCase().matches(REGEX_EMAIL)){
        
            throw new IllegalArgumentException("Email non valido");
            
        }
    
    
    }
    
    public static void testPhone (String phone) throws IllegalArgumentException {
        
        if (!phone.matches(REGEX_TELEFONO)){
        
            throw new IllegalArgumentException ("O teléfono proporcionado non é válido");
        }
    
    }
    
    public String readText (String title) throws CancelException{
        
//      title = "Introduce un texto. Pulsa ";
        System.out.println(title + " (* para cancelar): ");

        String input = scn.nextLine();
        
        if(input.equals("*")){
            throw new CancelException("A introducción do texto foi cancelada");
        }
        
        System.out.println(input);

        return input;
        
        /*Pide un texto. Si es un asterisco lanza la CancelException que diseñamos, si no, almacena el texto en la variable input*/
       
    }
    
    public String readText (String title, String defaultValue) throws CancelException {
        
          System.out.println(title + " [* para cancelar: ]");
          
          String input = scn.nextLine();
          
          if(input.equals("*")){
              
              throw new CancelException("A introducción do texto foi cancelada");
              
          } if (input.isEmpty()){
          // if (input.equals("")) --> equivalente a lo de arriba.
          
              return defaultValue;
          }
          
          // REFACTORIZADO: Lo que se repite respecto al método readText(String title) lo incluyo en la variable input llamando almétodo de arriba,
          //                Que haga todo lo que hace y le añado que, si el input esta vacío, devuelva el valor por defecto
          
//        String input = readText(title);
//        
//        if (input.isEmpty()){
//            
//            return defaultValue;
//            
//        }
//        
        return input;
    }
    
    public String readPhone (String title) throws CancelException {
        
        while (true) {
        
            String input = readText(title);
            
            try {
                
                testPhone(input);
                
                System.out.println("O telefono e valido. Queda almacenado na variable input como: " + input);
                return input;
            
            } catch (IllegalArgumentException e){
                
                System.out.println("Teléfono inválido, inténtalo otra vez.");

            }
            
        /* While(true) Es un patrón muy común cuando el objetivo del bucle es repetir una operación indefinidamente hasta que se cumpla una condición interna, 
           no en la cabecera del while.

          ✅ ¿Por qué usar while(true) aquí?

            En el caso de:

                while (true) {
                    String input = readText(title);

                    try {
                        testPhone(input);
                        return input;                                                   // salimos del método por aquí
                    } catch (IllegalArgumentException e) {
                        System.out.println("Teléfono inválido, inténtalo otra vez.");
                    }
                }


        La condición de salida no depende de una variable externa, sino de:

            - El usuario introduce un valor válido → usamos return → salimos.

            - El usuario pulsa * → readText() lanza CancelException → salimos.

            - El usuario introduce algo incorrecto → se muestra el mensaje y vuelve a repetir → seguimos en el bucle.*/
        }
    
    }
    
    // Tutoría Monday, November 17, 2025 [1h 7min 23seg]
    
    public String readPhone (String title, String defaultValue) throws CancelException {
    
        String input = readPhone(title);
        
        if (input.isEmpty()) {
            
            return defaultValue;
        }
    
        return input;
    }
    
    public String readEmail (String title) throws CancelException {        
        
        while (true) {
                
            String input = readText(title);

            try {
            
                testEmail(input);
                
                return input;
            
            } catch (IllegalArgumentException e) {
            
                System.out.println("O email non é correcto. Inténtao de novo");
            
            }
        
        }    
    
    }
    
    public String readEmail (String title, String defaultValue) throws CancelException {
    
        String input = readEmail(title);
        
        if (input.isEmpty()) {
            
            return defaultValue;
        
        }
        
        return input;
    
    }
    
    /*  String option(String title,String validos) throws CancelException;
    
           Visualiza o texto title (* para cancelar) e retorna a letra introducida polo usuario 
           que coincida con algunha das especificadas no String validos. Si non coincide con ningunha,
           se debe insistir a non ser que o usuario cancele con *, que lanzará unha CancelException 
           cunha mensaxe axeitada
    */
    
    public String readNif(String title) throws CancelException {
        while (true) {
            String input = readText(title);
            try {
                testNif(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
    
    
    public int option () throws CancelException {

//        String input = readText(title, validos);
        int option = 0;
//        String trash;
        
        
        do {
        
            System.out.println("AXENDA");
            System.out.println("=======");
            System.out.println("1.Listado de contactos");
            System.out.println("2.Alta de contactos");
            System.out.println("3.Buscar contactos");
            System.out.println("4. Opción 4 (Salir)");
    
            try{
                System.out.println("Elije una opción");
                
                option = scn.nextInt();
                scn.nextLine();
//              option = Integer.parseInt(scn.nextLine());
//              trash=scn.nextLine();
                System.out.println("opcion ha almacenado: " + option);
                
                switch (option) {
                    
                    case 1:
                    
                        listado_contactos();
                        break;
                        
                    case 2:
                    
                        alta_contactos();
                        break;
                        
                    case 3:
                    
                        buscar_contactos();
                        break;
                
                }
                
            } catch (InputMismatchException e) {
//                System.out.println("Introdujiste: "+trash+". Debe introducir un número entre 1 y 4");
                scn.nextLine();

                

            }
            
        
        
        } while (option!=4);
        
        //while ((opcion/1)!=opcion);
        
        //System.out.println("opcion ha almacenado: " + opcion);
        return option;
    
    }
    
    public String areYouSure (String title, String validos){
        
        System.out.print(title + validos);
        String siONo = scn.nextLine();
        
        if (siONo.length() == 1 && validos.toLowerCase().contains(siONo)){
             
            return siONo;
        }
        return null;
    }
    
    
    
    public static void listado_contactos() {
            System.out.println("Opción en desarrollo");
    }
    public static void alta_contactos() {
            System.out.println("Opción en desarrollo");
    }
    public static void buscar_contactos() {
            System.out.println("Opción en desarrollo");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}

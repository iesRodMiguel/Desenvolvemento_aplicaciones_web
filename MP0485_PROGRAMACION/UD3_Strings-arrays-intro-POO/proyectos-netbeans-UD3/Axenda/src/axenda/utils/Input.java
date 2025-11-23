/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package axenda.utils;

/**
 *
 * @author miguel
 */
import java.util.Scanner;

public class Input {
    
    /*static final: Estas variables son constantes (non cambian) e pertencen á clase, non a obxectos específicos.*/
    
    private static final String REGEX_TELEFONO = "^(\\+34)?[0-9]{9}$";   
//    private static final String REGEX_TELEFONO = "^(manelregexp)?[0-9]{9}$";
    private static final String REGEX_EMAIL = "^[a-z0-9][a-z0-9._-]+\\@[a-z]+\\.[a-z]{2,4}$";
//    public static final String title = "Pulsa '*' para cancelar";
    private static final Scanner scn = new Scanner(System.in);



    
    
    public void testNif (String nif) throws IllegalArgumentException{
        
        char[] control = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        char letra = nif.charAt(8);
        String num_str = nif.substring(0, 8);
        
        if (nif == null || nif.length() != 9){
            
            throw new IllegalArgumentException("O nif debe conter 9 díxitos e unha letra");            
        } 
        
        try {
             
                int num = Integer.parseInt(num_str);
                int index = num%23;
                char letraControl = control[index];
                
                if (letra!=letraControl) {
                
                    throw new IllegalArgumentException("Non coincide a letra. Nif non válido");
                
                }
            
            } catch (NumberFormatException e){

                System.out.println(e.getMessage());
            
                throw new IllegalArgumentException("Nif non válido");            
            }
    
    
    }
    
    public void testEmail (String email) throws IllegalArgumentException {
    
        if(!email.toLowerCase().matches(REGEX_EMAIL)){
        
            throw new IllegalArgumentException("Email non valido");
            
        }
    
    
    }
    
    public void testPhone (String phone) throws IllegalArgumentException {
        
        if (!phone.matches(REGEX_TELEFONO)){
        
            throw new IllegalArgumentException ("O teléfono proporcionado non é válido");
        }
    
    }
    
    public String readText (String title) throws CancelException{
        
//        title = "Introduce un texto. Pulsa ";
        System.out.println(title + " (* para cancelar): ");

        String input = scn.nextLine();
        
        if(input.equals("*")){
            throw new CancelException("A introducción do texto foi cancelada");
        }
        
        System.out.println(input);

        return input;
        
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
    
    public String option (String title, String validos) throws CancelException {

        String input = readText(title, validos);
        String option = null;
        
        System.out.println("AXENDA");
        System.out.println("=======");
        System.out.println("1. Opción 1");
        System.out.println("2. Opción 2");
        System.out.println("3. Opción 3");

        
        while (!validos.equals("4")){
            switch (validos) {
                case "1":
                    option = "1";
                    System.out.println("Opcion elegida: "+option);
                case "2":
                    option = "2";
                    System.out.println("Opcion elegida: "+option);

                case "3":                    
                    option = "3";
                    System.out.println("Opcion elegida: "+option);

            }
        }
    return input;
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}


import java.util.Scanner;
import java.util.InputMismatchException;

public class Axenda {

    public static void main(String[] args) {
        
        holaMundo();
        option();
    }

    public static void holaMundo () {
        System.out.println("Bienvenidx a la clase para probar métodos del proyecto 'Axenda':");
        System.out.println("======================================");
        System.out.println(" ");
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
    
    public static void option(){
    
        //System.out.println("Escribe un numero");
        
        Scanner scn = new Scanner(System.in);
        int opcion = 0;
        
        do {
        
            System.out.println("AXENDA");
            System.out.println("=======");
            System.out.println("1. Opción 1");
            System.out.println("2. Opción 2");
            System.out.println("3. Opción 3");
            System.out.println("4. Opción 4 (Salir)");
    
            try{
                System.out.println("Elije una opción");
                
                opcion = scn.nextInt();
                scn.nextLine();
                
                System.out.println("opcion ha almacenado: " + opcion);
                
                switch (opcion) {
                    
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
                System.out.println("Debe introducir un número entre 1 y 4");
            }
            
        
        
        } while (opcion!=4);
        
        //while ((opcion/1)!=opcion);
        
        //System.out.println("opcion ha almacenado: " + opcion);
    
    }
}


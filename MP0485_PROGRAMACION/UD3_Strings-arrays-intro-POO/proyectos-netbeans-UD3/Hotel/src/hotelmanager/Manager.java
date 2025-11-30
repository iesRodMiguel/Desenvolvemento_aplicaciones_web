/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotelmanager;


import java.util.Scanner;
/**
 *
 * @author miguel
 */
public class Manager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scn = new Scanner(System.in);
        String option_string;
        int option_num;
        
        
        
        do {
            System.out.println("HOTEL MANAGER");
            System.out.println("========================================");
            System.out.println("1. Consultar e dar de alta novos clientes");
            System.out.println("2. Facer reservas");
            System.out.println("3. Facer o Check-In dunha Reserva");
            System.out.println("4. Facer o Check-Out dunha Reserva");
            System.out.println("5. Cancelar unha reserva");
            System.out.println("6. Salir");

            option_string = scn.nextLine();
            option_num = Integer.parseInt(option_string);
            
            System.out.println("A opción elexida é: " + option_num);
            
            
        
        
        
        
        
        
        } while (option_num != 6);
    }
    
}

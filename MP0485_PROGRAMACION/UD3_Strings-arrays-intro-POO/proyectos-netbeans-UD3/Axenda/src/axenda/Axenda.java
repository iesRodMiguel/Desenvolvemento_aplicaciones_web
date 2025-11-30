/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package axenda;
import axenda.model.Persona;
import axenda.model.Contacto;
import axenda.model.DAO.ContactosDAO;
import axenda.model.DAO.DuplicateElement;
import axenda.model.DAO.StorageFull;
import axenda.utils.CancelException;
import axenda.utils.Input;
/**
 *
 * @author miguel
 */

    
public class Axenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CancelException, DuplicateElement, StorageFull {
        // TODO code application logic here
        System.out.println("EN ELABORACIÓN");
        
       Input test = new Input();
        
//       test.option();
//       test.readNif("Introduce un dni: ");
//       test.readPhone("Introduce tu num de telefono:");
//       test.readEmail("Introduce un email:");
//       test.areYouSure("Estas seguro? ", " [S/N]");
//       
//        Persona p1 = new Persona("Miguel", "Martí Muñoz", "53189946p");
//        Contacto c1 = new Contacto(p1,"Oh, que beleza!" , "mm@df.com", "665219714");
   
//        Persona p2 = new Persona("Aureloop", "Martí Muñoz", "53189943m");
//        Contacto c2 = new Contacto(p2, "Oh, que beleza!","erc@isp.org" ,"665217714");
        
//        System.out.println("Persona 1 e igual que persoa 2? " + p1.equals(p2));
//        System.out.println("Contacto 1 é igual que contacto 2? " + c1.equals(c2));
        
        ContactosDAO miPrimeraAgenda = new ContactosDAO(5);
        
        try {
        
            Persona p1 = new Persona("Miguel", "Martí Muñoz", "53189946p");
            Contacto c1 = new Contacto(p1,"Oh, que beleza!" , "mm@df.com", "665219714");
            
            Persona p2 = new Persona("Aureloop", "Martí Muñoz", "53189943m");
            Contacto c2 = new Contacto(p2, "Fabuloso amigo!","erc@isp.org" ,"665217714");
            
            miPrimeraAgenda.guardarContacto(c1);
            miPrimeraAgenda.guardarContacto(c2);
            
            miPrimeraAgenda.getContactoNif("53189946p");

        
        } catch (){}

    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datosclientes;

/**
 *
 * @author miguel
 */
public class DatosClientes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cliente cliente1 = new Cliente("Juan", "Pérez Dominguez", "58896553q");
                
        String nif = cliente1.getNif();
        cliente1.validarDni(nif);
        
        cliente1.setEmail("miguelmarti590@gmail.com");
        String email = cliente1.getEmail();
        
        cliente1.validarEmail(email);
        
        cliente1.setTelefono("665219714");
        String telefono = cliente1.getTelefono();
        
        cliente1.validarTelefono(telefono);
        
        
        
        cliente1.showClient();

    }
    
}

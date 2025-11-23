/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package herenciausodesuper;

/**
 *
 * @author miguel
 */
public class Animal {

    /**
     * @param args the command line arguments
     */
    
    protected String nome;
    
    //Método Constructor del atributo nome. Los métodos constructores se llaman exactamente igual que la clase a la que pertenecen
    
    public Animal(String nome){
        this.nome = nome;
    }
    
    //Método publico que va a ser común a todos los animales
    public void emitirSonido(){
    
        System.out.println("Los animales emiten un sonido");
    
    }
    
    //Método público para mostrar la información de cualquier animal
    
    public void mostrarInfo(){
        System.out.println("Nome: " + nome);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    
    }
    
    
}

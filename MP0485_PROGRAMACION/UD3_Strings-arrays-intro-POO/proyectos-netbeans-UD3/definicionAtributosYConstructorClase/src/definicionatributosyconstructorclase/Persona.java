/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package definicionatributosyconstructorclase;

/**
 *
 * @author miguel
 */

// HERENCIA, USO DE SUPER, SOBREESCRITURA DE MÉTODOS (@OVERRIDE), THIS EN EL CONSTRUCTOR DE ATRIBUTOS

public class Persona {
/**
     * @param args the command line arguments
     */
    String nome;
    int idade;
    
    //Constructor sen argumentos
    public Persona(){
        this.nome = "";
        this.idade = 0;
    }
    //Constructor sobrecargado con argumentos
    public Persona(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
    //Constructor sobrecargado con el argumento nome y el atributo idade inicializado en '0' y no es un argumento
    public Persona(String nome){
        this.nome = nome;
        this.idade = 0;
    
   }
    
    public void saludar(){
        System.out.println("Ola, son " + nome + " e teño " + idade + " anos.");
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Persona juan = new Persona("Juan González", 27);
        System.out.println("Nombre: " + juan.nome);
        System.out.println("Edad: " + juan.idade);
        
        juan.saludar();
        
        Persona p = new Persona();
        
        System.out.println("Nombre: " + p.nome);
        System.out.println("Edad: " + p.idade);
        
        p.saludar();

        Persona p2 = new Persona("Baruch Spinoza");
        
        System.out.println("Nombre: " + p2.nome);
        System.out.println("Edad: " + p2.idade);
        
        p2.saludar();
        
        System.out.println(p2.getClass());
        System.out.println(p2.toString());

    }
}

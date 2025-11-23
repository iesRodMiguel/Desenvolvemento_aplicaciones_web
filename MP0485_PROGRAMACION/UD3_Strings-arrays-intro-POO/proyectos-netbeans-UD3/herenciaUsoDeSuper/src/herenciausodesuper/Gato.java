/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herenciausodesuper;

/**
 *
 * @author miguel
 */

// CLASE DERIVADA O CLASE HIJA DE ANIMAL

public class Gato extends Animal {
    
    private final String raza;
    
    //Método constructor de Gato. Debe incluir como arg el atributo 'nome' de la clase padre
    
    public Gato(String nome, String raza){
        
        super(nome);
        this.raza = raza;
    
    }
    
    //Método sobreescrito (Override) de la clase padre Animal emitirSonido(). Es decir, invocamos el método de la clase padre pero le damos otro valor en la clase hijo
    
    @Override
    public void emitirSonido(){
        System.out.println("O gato miaña: Miau!");
    }
    
    // Nuevo método específico de la clase hijo
    
    public void trepar(){
        System.out.println(nome + " está a trepar unha árbore.");
    }
    
    // Sobrescritura do método mostrarInfo()
    
    @Override
    public void mostrarInfo(){
        System.out.println("Nome: " + nome + " | Raza: " + raza);
    }
    
    
}



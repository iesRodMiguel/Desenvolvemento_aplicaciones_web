/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herenciausodesuper;

/**
 *
 * @author miguel
 */
public class Main {
    public static void main(String[] args){
        
        Separadores sep = new Separadores();
        
        String sep1 = sep.sepMidDash;
        String sep2 = sep.sepSpace;
        
        Gato g1 = new Gato ("Ushi", "mestiza");
        g1.mostrarInfo();
        g1.emitirSonido();
        g1.trepar();
        
        System.out.println(sep1);
        
        Animal a1 = new Animal ("Vaca");
        a1.mostrarInfo();
        a1.emitirSonido();
        
        System.out.println(sep1);

        //PRUEBAS MÉTODOS CLASE OBJECT
        
        System.out.println(g1.getClass());
        System.out.println(g1.toString());
        
        System.out.println(sep2);

        
        System.out.println(a1.getClass());
        System.out.println(a1.toString());

    }
}

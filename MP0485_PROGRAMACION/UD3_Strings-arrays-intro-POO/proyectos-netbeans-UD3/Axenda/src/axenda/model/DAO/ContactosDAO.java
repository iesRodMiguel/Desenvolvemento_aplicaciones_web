/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package axenda.model.DAO;
import java.lang.Exception;
import axenda.model.Contacto;

/**
 *
 * @author miguel
 */

//DAO: Data Acces Object
public class ContactosDAO {
    
    /*ATRIBUTOS: Un sólo atributo que es un array de contactos de tipo Contacto.Es decir,
    Array que almacena os contactos. Cada posición pode conter un obxecto Contacto ou null.*/
    
    private Contacto axenda[];
    
    //CONSTRUCTOR: 
    
    public ContactosDAO (int num){
        this.axenda = new Contacto[num]; /*Al ponerle el argumento num --> para construir un objeto de este tipo
        habrá que introducir un número que especificará el tamaño del array de contactos. Es decir, O array ten 
        tamaño fixo definido no construtor. As posicións non utilizadas permanecen como null. Esta implementación 
        simple é adecuada para pequenas aplicacións con número limitado
        de contactos.*/
    }
    
    
    //MÉTODOS DE LA CLASE DE ACCESO A CONTACTOS
    
    public void guardarContacto (Contacto contacto) throws DuplicateElement, StorageFull{
    
        if(itExists(contacto) == true){     // Comprueba si ya existe un contacto igual al que introducimos como parámetro
        
            throw new DuplicateElement();
            
        } else { // Buscar posicion libre en el array axenda. Si la hay, meto ahi el contacto que introduje como parametro.
                 // Si no lanza una excepcion StorageFull que dieseñamos anteriormente
        
        for (int i =0; i< axenda.length; i++){ // Membrete sobre la línea 27 de este mismo archivo:
                                                 // "As posicións non utilizadas permanecen como null"
        
            if (axenda[i] == null){
                
                axenda[i]= contacto;
                contacto.setNumeroDeContacto(i);
            
            } throw new StorageFull();
        }
        
        }
        
        
    }
    
    public boolean itExists(Contacto contacto){ /* Método que recorre el array axenda mediante de la variable 'c' de tipo contacto. Si
        c no es nulo y c es igual a algun contacto que ya hay en el array devuelve true --> istExists: true
        Si no, devuelve false. El contacto no existe */
    
        for (Contacto c : axenda) {
            if ((c != null) && (c.equals(contacto))) return true;
            } return false;
        }
    
    
    //MÉTODO PARA OBTER UN CONTACTO POR NIF
    
    public Contacto[] getContactoNif(String nif){
    
        int contador = 0;
        
        for (Contacto c: axenda){
        
            if((c!=null) && (c.getPersona().getNif().equals(nif))) contador ++;
            
        }
        
        if (contador!=0){
        
            Contacto lista[] = new Contacto[contador];
            int i= 0;
            
            for (Contacto c : axenda){
            
                if((c!=null) && (c.getPersona().getNif().equals(nif))){
                
                    lista[i] = c;
                    i++;
                }
                
            } return lista;
            
             
        } return null;
    
    
    }
    
    public Contacto getContactoPorNum(int numero){
    
        return axenda[numero];
    
    }
    
    public String eliminarContactoPorNum (int numero){
        
        if (axenda[numero] == null) System.out.println("Non existe ese contacto");

        axenda[numero] = null; // Al igualar axenda[numero] a null, elimino el contacto.

        return "O contacto foi eliminado";
    }

    public void eliminarTodosContactos () {
    
        for (int i= 0; i< axenda.length; i++) {
        
            axenda[i] = null;
        
        }
    }
    
    
} 

    
    
    
    


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datosClientesUtils;

/**
 *
 * @author miguel
 */
public class CancelException extends Exception {
    
    /*Diseño de la clase CancelException:
    
        * Extiende de la clase Exception de Java           
            
            java.lang.Object
              java.lang.Throwable
                 java.lang.Exception

        * La class Exception y cualquiera de sus subclases son excepciones vigiladas (checked exceptions) 
          que necesitan ser declaradas en un método o en la clausula trhows del constructor.
    
        * Queremos capturar la posibilidad de cancelación:
    
            - Cuando el usuario decide cancelar una operación de introducción de datos pulsando '*'.
            - Esta es una  situación esperada y recuperable en el flujo normal de la aplicación
    
    */
    
    /* CONSTRUCTOR: Usaremos el constructor de la clase padre Exception(String message) --> Constructs a new exception with the specified detail message.
    
        Por tanto, el constructor de nuestra clase CancelException, debe recibir también un parámetro String message 
    
    
    */
    public CancelException (String message){
        super(message);
    }
    
    /*También usaremos el constructor de la clase padre Exception()*/
    
    public CancelException (){
        super("A operación foi cancelada.");
    }
    
    /*Aquí tenemos DOS CONSTRUCTORES:
    
        El segundo, lo creamos para poder lanzar un mensaje por defecto "A operación foi cancelada." Para poder lanzar la excepción de esta manera:
            
            throw new CancelException();

        El primero, permite crear excepciones CancelException con mensajes específicos:
    
            throw new CancelException("O usuario cancelou o rexistro.");

        ** La elección de cuál usar depende de si necesitas un mensaje dinámico o no.
    
    */
}

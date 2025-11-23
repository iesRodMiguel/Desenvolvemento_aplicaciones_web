/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package axenda.utils;

/**
 *
 * @author miguel
 */
public class CancelException extends Exception {
    
    //Lo usaremos cuando queramos lanzar la excepción con otro mensaje: throw new CancelException("O usuario cancelou o rexistro.");
    public CancelException(String message){
    
        super(message);
    }
    
    // Lo usaremos por defecto
    public CancelException(){
        super("Operación cancelada");
    }
}

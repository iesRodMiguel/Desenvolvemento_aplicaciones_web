package utils;

public class CancelException extends Exception {
    
    /**
     *  Sobrecargo o construtor para ter duas maneiras de crear un obxecto CancelException
     *  O construtor por defecto usa a mensaxe por defecto "Operación Cancelada" e 
     *  o construtor sobrecargado permite unha mensaxe persoalizada
     */
    
    
    public CancelException() {
        super("Operación Cancelada");
    }
    
    public CancelException(String msg) {
        super(msg);
    }
}

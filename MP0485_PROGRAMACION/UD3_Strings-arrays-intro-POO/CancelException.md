public class Exception extends Throwable {

    public Exception(){
    
        super();
    }

}

--------------------------------------------------------------------------------

public class CancelException extends Exception {

    public CancelException (String message) {
    
        super(message);
    }
    
    public CancelException(){
    
        super("A operación foi cancelada");
    }

}

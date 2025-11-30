package utils;

import java.time.LocalDateTime;

/**
 */
public class FutureDateValidator extends DateValidator {
    private final LocalDateTime future;

    public FutureDateValidator() {
        this.future=LocalDateTime.now();
    }
    
    public FutureDateValidator(LocalDateTime future) {
        this.future=future;
    }
    
    public boolean isValid(Object data) {
        return super.isValid(data) && super.getDate().atTime(12,0).isAfter(future);
    }
    
    public String message() {
        return "A data non é válida! debes indicar DD-MM-AAAA e debe ser posterior a "+future;
    }
}

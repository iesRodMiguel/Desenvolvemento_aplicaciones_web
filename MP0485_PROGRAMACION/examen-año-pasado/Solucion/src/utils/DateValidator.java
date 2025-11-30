package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author xavi
 */
public class DateValidator extends Validator {
    private LocalDate date;
    
    public boolean isValid(Object data) {
        try {
            String str=(String) data;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            date=LocalDate.parse(str, formatter);
            return true;
        } catch(DateTimeParseException e) {
            return false;
        }
    }
    
    public String message() {
        return "A data non é válida! Debes indicar DD-MM-AAAA";
    }
    
    public LocalDate getDate() {
        return date;
    }
}

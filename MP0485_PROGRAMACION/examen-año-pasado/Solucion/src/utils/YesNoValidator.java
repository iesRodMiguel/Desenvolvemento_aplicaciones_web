/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author xavi
 */
public class YesNoValidator extends Validator {
    public boolean isValid(Object data) {
        String str=(String) data;
        return str.toUpperCase().equals("S")||str.toUpperCase().equals("Y") || str.toUpperCase().equals("N");
    }
    
    public String message() {
        return "Debes indicar s/y ou n";
    }
}

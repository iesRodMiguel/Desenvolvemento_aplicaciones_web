/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package axenda.model.DAO;

import axenda.model.Contacto;

/**
 *
 * @author miguel
 */
public class DuplicateElement extends Exception{
    public DuplicateElement (){
        super();
    }

    public DuplicateElement(Contacto contacto) {
    
        super("O contacto " + contacto + " está duplicado");
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package axenda.model;

import static axenda.utils.Input.testEmail;
import static axenda.utils.Input.testPhone;
import java.util.Objects;

/**
 *
 * @author miguel
 */
public class Contacto {
    
    private String descripcion;
    private String email;
    private String telefono;
    private String direccion;
 
    private int numeroDeContacto = -1;
    private Persona persona;
    
    

    public Contacto (Persona persona, String descripcion, String email, String telefono) throws IllegalArgumentException {
        
        testPhone(telefono);
        testEmail(email);
        
        this.persona = persona;
        this.descripcion = descripcion;
        this.email = email;
        this.telefono = telefono;
        this.numeroDeContacto = -1;
        
    
    }
    
    public Contacto (Persona persona, String telefono, String email){
    
        this.persona = persona;
        this.email = email;
        this.telefono = telefono;
        this.descripcion = "";
    }
    public Contacto (Persona persona, String telefono){
    
        this.persona = persona;
        this.descripcion = "";
        this.email = "";
        this.telefono = telefono;
        this.descripcion = "";
    }
    
    
    // Métodos get

    public String getDescripcion() {
        return descripcion;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getNumeroDeContacto() {
        return numeroDeContacto;
    }

    public Persona getPersona() {
        return persona;
    }
    
    


    //Métodos set()
    
    public void setEmail(String email) {
        
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNumeroDeContacto(int numeroDeContacto) {
        this.numeroDeContacto = numeroDeContacto;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    
    //DOS CONCTACTOS SON IGUALES SI SU DESCRIPCION ES IGUAL O SI SU ATRIBUTO PERSONA ES IGUAL
    
    @Override public boolean equals(Object obj){
        
        if (obj == null){
            return false;
        }
        if(!(obj instanceof Contacto)){
            return false;
        }
        
        Contacto c = (Contacto) obj;
        
       return (this.persona.equals(c.persona)) || (c.descripcion.equals(this.descripcion));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.descripcion);
        hash = 37 * hash + Objects.hashCode(this.persona);
        return hash;
    }
    
    

}

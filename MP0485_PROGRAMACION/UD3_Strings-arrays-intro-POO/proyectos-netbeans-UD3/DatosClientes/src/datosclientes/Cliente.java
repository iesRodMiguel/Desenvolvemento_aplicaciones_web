/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datosclientes;

/**
 *
 * @author miguel
 */
public class Cliente {
    
    private final String nome;
    private final String apelidos;
    private String nif;
    private String telefono;
    private String email;
    
    public Cliente (String nome, String apelidos, String nif){
        this.nome = nome;
        this.apelidos = apelidos;
        this.nif = nif;
    }
    
    //Getters
    
    public String getNome(){
        return nome;
    }
    public String getApelidos(){
        return apelidos;
    }
    public String getNif(){
        return nif;
    }
    public String getTelefono(){
        return telefono;
    }
    public String getEmail(){
        return email;
    }
    
    // Setters
    
    public void setTelefono(String telefono){
    
        this.telefono = telefono;
    }
    public void setEmail(String email){
    
        this.email = email;
    }
    
    
    
    public void validarDni(String nif)throws IllegalArgumentException {
        
        char [] control = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        
        if (nif == null || nif.length()!=9){
            throw new IllegalArgumentException("O Dni debe ter 8 numeros e unha letra");
        }
        
        char letra = nif.toUpperCase().charAt(8);
        String num_str = nif.substring(0,8);
        
        // Verificamos que los 8 primeros caracteres introducidos por el usuario sean números
        
        try{
          
            int num = Integer.parseInt(num_str);
            int index = num%23;
            
            if(control[index]!= letra){
            
                throw new IllegalArgumentException("Dni inválido. A letra non coincide");

            }

        
        } catch (NumberFormatException e){
        
            throw new IllegalArgumentException("Dni non valido");
        
        }
        
    }
    
    public void validarEmail(String email) throws IllegalArgumentException {
        
        if (!email.matches("^[a-zA-z][a-zA-z0-9._-]+@[a-zA-z][a-zA-z0-9._-]+\\.[a-zA-Z]{2,4}$")){
    
            throw new IllegalArgumentException("Email non válido");
        }
    }
        
    public void validarTelefono(String telefono) throws IllegalArgumentException {
        
        if (!telefono.matches("^(\\+34)?[0-9]{9}$")){
        // (!(telefono.matches("\\+34[0-9]{9}") || telefono.matches("[0-9]{9}")))
            try {        
                
                int numTlf = Integer.parseInt(telefono);
                
            } catch (NumberFormatException e) {
                
                throw new IllegalArgumentException("Telefono non válido");
            }
        }
    }
    
    
    
    
    //Método para imprimir de acuerdo al patrón especificado en el enunciado
    
    public void showClient(){
    
       System.out.printf("NIF: %s | Nome: %s | Apelidos: %s | Email: %s | Telefono: %s%n", nif, nome, apelidos, email, telefono);
    }
}

public class Contacto extends Persona{

    private String descripcion;
    private String email;
    private String telefono;
    private String direccion;
    private Persona persoa;
    private int numeroDeContacto = -1;
    
    

    public Contacto (Persona persona, String descripcion, String email, String telefono, String direccion){
    
        super(nome,apelidos,nif);
        
        this.descripcion = descripcion;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        
    
    }
    
    // Métodos get
    
    public String getDescripcion(){
    
        return descripcion;
    
    }
    public String getEmail(){
    
        return email;
    
    }
    public String getTelefono(){
    
        return telefono;
    
    }
    public String getDireccion(){
    
        return direccion;
    
    }

}

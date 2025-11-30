public class Persona {

    private String nome;
    private String apelidos;
    private String nif;
    
    public Persona(String nome, String apelidos, String nif) throws IllegalArgumentException{
        
        //Input.testNif(nif);
        
        this.nif = nif;
        this.nome = nome;
        this.apelidos = apelidos;
        
    
    }
    
    // DOS PERSONAS SON IGUALES SI TIENEN NIF IGUALES
    
    @Override public boolean equals(Object obj){
    
        if (obj == null) {
        
            return false;
        
        }
        
        if (!(obj instanceof Persona)){
        
            return false;
        
        }
        
        Persona p = (Persona) obj;
        
        return p.nif.equals(this.nif);
    
    }
    
    
    //A representación como String dun cliente (O que sae si fago System.out.println(cliente)) será [nif] apelidos, nome
    
    @Override public String toString() {
    
        return "[" + nif + "] " + apelidos + ", " + nome;
    
    }

}

public class Persona {

    private final string nome;
    private final string apelidos;
    private string nif;
    
    public Persona (String nome, String apelidos, String nif) {
    
        this.nome = nome;
        this.apelidos = apelidos;
        this.nif = nif;
    }
    
    // DOS PERSONAS SON IGUALES SI TIENEN NIF IGUALES
    
    /*Para esto necesito utilizar el metodo equals, pero tengo que sobreescribirlo para adaptarla a lo de los nif porque es una clase
      general de java y yo necesito utilizarla de una manera concreta para esto 
    */
    
    /* Este es el metodo equals:
    
        equals:  public boolean equals (Object obj)
            
            Object: Objeto 'modelo' con el que voy a comparar otro objeto
            obj: Parámetro que introduzco. Objeto que quiero comparar con el Object
        
        
        *****************************************************************************
        Parameters:
            obj - the reference object with which to compare.
        
        Returns:
            true if this object is the same as the obj argument; 
            false otherwise.   
        *****************************************************************************        
        
        See Also:
        hashCode(), HashMap*/
        
    @Override public boolean equals (Object object){
        
        if (object == null){
        
            return flase;    
            
        }
        if (!object instanceof Persona) {
        
            return flase;
        
        }
        
        Persona p = (Persona) object; // CAST EXPLICITO DEL OBJETO object que introduzco como parámetro a un objeto tipo Persona
        // Persona p1 = new Persona(object); INSTANCIAR UNA NUEVA PERSONA
        
        /* En esta sobreescritura del método equals me interesa hacer el casting, no instanciar nuevos objetos. 
           
           ¿Por qué? 
           
           Porque el cast explicito sólo funciona si el objeto que le intento pasar ya cumple los requisitos del tipo modelo. Es decir, el cast
           va hacer que java trate al objeto que le pase como un objeto del tipo modelo pero no puede forzarlo a cambiar de tipo.
           
           p.ej:
           
            Object object = 123;     // Un Integer
	        String p = (String) object;  // ❌ ClassCastException

            Esto lanza:

            java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String

            Porque Java no puede reinterpretar un Integer como un String.
        
        */
        
        return this.nif.equals(p.nif);
        
    
    }
    
    //A representación como String dun cliente (O que sae si fago System.out.println(cliente)) será [nif] apelidos, nome
    
    @Override public String toString(){
    
        return "[" + nif + "]" + " " + apelidos + ", " + nome;
    
    }
    


}

/*        Indicates whether some other object is "equal to" this one.
        The equals method implements an equivalence relation on non-null object references:

        It is reflexive: for any non-null reference value x, x.equals(x) should return true.
        It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
        It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
        It is consistent: for any non-null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, provided no information     used in equals comparisons on the objects is modified.
        
        For any non-null reference value x, x.equals(null) should return false.
        
        The equals method for class Object implements the most discriminating possible equivalence relation on objects; that is, for any non-null reference values x and y, this method returns true if and only if x and y refer to the same object (x == y has the value true).


        Note that it is generally necessary to override the hashCode method whenever this method is overridden, so as to maintain the general contract for the hashCode method, which states that equal objects must have equal hash codes.*/

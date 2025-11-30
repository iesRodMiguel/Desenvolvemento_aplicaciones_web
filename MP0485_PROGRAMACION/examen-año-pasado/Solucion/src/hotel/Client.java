package hotel;

import java.util.Objects;
import utils.DniValidator;

public class Client {
    private final String dni;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    /**
     * Constructor que inicializa un cliente cos seus datos completos.
     * Verifica que o DNI sexa válido antes de asignalo.
     * 
     * @param dni O DNI do cliente.
     * @param firstname O nome do cliente.
     * @param lastname Os apelidos do cliente.
     * @param email O correo electrónico do cliente.
     * @param phone O número de teléfono do cliente.
     * @throws IllegalArgumentException Se o DNI non é válido.
     */
    public Client(String dni, String firstname, String lastname, String email, String phone) {
        if (!new DniValidator().isValid(dni)) throw new IllegalArgumentException("O DNI non é correcto");
        this.dni = dni;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }
    
        /**
     * Constructor que inicializa un cliente só co seu DNI.
     * 
     * @param dni O DNI do cliente.
     * @param firstname O nome do client
     * @param lastname Os apelidos do client
     * @throws IllegalArgumentException Se o DNI non é válido.
     */
    public Client(String dni,String firstname,String lastname) {
        this(dni,firstname,lastname,"","");
    }
    
    /**
     * Constructor que inicializa un cliente só co seu DNI.
     * 
     * @param dni O DNI do cliente.
     * @throws IllegalArgumentException Se o DNI non é válido.
     */
    public Client(String dni) {
        this(dni,"","","","");
    }

    /**
     * Obten o DNI do cliente.
     * 
     * @return O DNI do cliente.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Obten o nome do cliente.
     * 
     * @return O nome do cliente.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Establece un novo nome para o cliente.
     * 
     * @param firstname O novo nome do cliente.
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Obten os apelidos do cliente.
     * 
     * @return Os apelidos do cliente.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Establece novos apelidos para o cliente.
     * 
     * @param lastname Os novos apelidos do cliente.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Obten o correo electrónico do cliente.
     * 
     * @return O correo electrónico do cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece un novo correo electrónico para o cliente.
     * 
     * @param email O novo correo electrónico do cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obten o número de teléfono do cliente.
     * 
     * @return O número de teléfono do cliente.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Establece un novo número de teléfono para o cliente.
     * 
     * @param phone O novo número de teléfono do cliente.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Representa a información básica do cliente como unha cadea de texto.
     * 
     * @return Unha cadea que contén o DNI, apelidos e nome do cliente.
     */
    @Override
    public String toString() {
        return String.format("[%s] %s,%s",dni,lastname,firstname);
    }
    
    
    /**
     * Calcula o código hash do cliente baseado no seu DNI.
     * 
     * @return O valor do código hash do cliente.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    /**
     * Compara este cliente con outro obxecto para determinar se son iguais.
     * Dous clientes considéranse iguais se teñen o mesmo DNI.
     * 
     * @param obj O obxecto a comparar.
     * @return true se os obxectos son iguais, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        return Objects.equals(this.dni, other.dni);
    }
}

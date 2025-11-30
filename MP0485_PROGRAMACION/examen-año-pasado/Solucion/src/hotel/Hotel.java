package hotel;

import java.time.LocalDate;
import utils.DinamicArray;

/**
 * A clase Hotel representa un hotel cun nome e unha lista de habitacións.
 * Ofrece funcionalidades para xestionar a dispoñibilidade e reservas de habitacións
 * e para xestionar os clientes que se hospedan no hotel.
 */
public class Hotel {
    
    // Nome do hotel
    private final String name;  
    
    // Array de habitacións que pertencen ao hotel
    private final Room[] rooms;  

    /** Array dinámico que almacena os clientes do hotel. */
    private final DinamicArray guests=new DinamicArray(10);

    /**
     * Constructor que inicializa o hotel co seu nome e coas habitacións dispoñibles.
     * 
     * @param name  O nome do hotel.
     * @param rooms As habitacións dispoñibles no hotel.
     */
    public Hotel(String name, Room[] rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    
    /**
     * Obtén as habitacións dispoñibles nun rango de datas para un número específico de hóspedes.
     * 
     * @param datefrom   Data de inicio da reserva.
     * @param dateto     Data de fin da reserva.
     * @param guestnumber Número de hóspedes.
     * @return Un array de habitacións dispoñibles que cumpren os requisitos.
     */
    public Object[] getAvailableRooms(LocalDate datefrom,LocalDate dateto,int guestnumber) {
        // Usamos unha lista dinámica para almacenar as habitacións dispoñibles
        DinamicArray availableRooms = new DinamicArray(rooms.length);

        // Iteramos sobre todas as habitacións para comprobar se están dispoñibles
        for (Room room : rooms) {
            if (room.isAvailable(datefrom,dateto)) {
                if (guestnumber<=room.getCapacity())
                    availableRooms.add(room);  // Se a habitación está dispoñible, engádese á lista
            }
        }
        
        return availableRooms.toArray();
    }
    
    /**
     * Obtén as reservas realizadas por un cliente nunha data específica.
     * 
     * @param date   A data da reserva.
     * @param client O cliente que realizou a reserva.
     * @return Un array de reservas realizadas polo cliente na data indicada.
     */
    public Object[] booking(LocalDate date,Client client) {
        DinamicArray booklist = new DinamicArray(5);

        for (Room room : rooms) {
            Booking book=room.booking(date);
            if (book!=null && book.getGuest().getDni().equals(client.getDni())) booklist.add(book);
        }
        return booklist.toArray();
    }
    
    /**
     * Obtén todas as reservas realizadas por un cliente identificado polo seu DNI nunha data específica
     * e que teñan realizado o check-in (estan ocupando a habitación)
     *
     * @param date   A data da reserva.
     * @param client O cliente que realizou a reserva.
     * @return Un array de reservas realizadas polo cliente na data indicada.
     */
    public Object[] guestBooks(LocalDate date,Client client) {
        DinamicArray booklist = new DinamicArray(5);

        for (Room room : rooms) {
            Booking book=room.guestBook(date,client.getDni());
            if (book!=null) booklist.add(book);
        }
        return booklist.toArray();
    }
    
    /**
     * Obtén todas as reservas pendentes dun cliente.
     *
     * @param client O cliente do que se desexa consultar as reservas pendentes.
     * @return Un array coas reservas pendentes do cliente.
     */    
    public Object[] booking(Client client) {
                        // Iteramos sobre todas as habitacións para comprobar se están dispoñibles
        DinamicArray booklist=new DinamicArray(5);
        for (Room room : rooms) {
            Object[] books=room.booking(client.getDni());
            for(Object b:books) {
                Booking reserve=(Booking) b;
                if (!reserve.isChecked()) booklist.add(reserve);
            }
            //if (books!=null) booklist.append(books);
        }
        return booklist.toArray();
    }
    
    /**
     * Obtén unha reserva específica identificada polo seu número de reserva.
     *
     * @param number O número da reserva.
     * @return A reserva correspondente ou null se non existe.
     */
    public Booking booking(int number) {
                // Iteramos sobre todas as habitacións para comprobar se están dispoñibles
        for (Room room : rooms) {
            Booking book=room.booking(number);
            if (book!=null) return book;
        }
        return null;
    }

    /**
     * Cancela unha reserva específica.
     *
     * @param booking A reserva a cancelar.
     * @return true se a cancelación foi exitosa, false en caso contrario.
     */
    public boolean cancelBooking(Booking booking) {
        Room room=booking.getRoom();
        return room.cancelBooking(booking);
    }


    public String getName() {
        return name;
    }


    public Room[] getRooms() {
        return rooms;
    }
    
    /**
     * Busca un cliente identificado polo seu DNI.
     *
     * @param dni O DNI do cliente.
     * @return O cliente correspondente ao DNI ou null se non se atopa.
     */
    public Client getClient(String dni)  {
        Integer position=guests.position(new Client(dni));
        if (position!=null) return (Client)guests.get(position);
        return null;
    }
    
    /**
     * Engade un novo cliente á lista de hóspedes do hotel.
     *
     * @param client O cliente a engadir.
     * @return true se o cliente foi engadido correctamente, false se xa existe.
     */
    public boolean addClient(Client client) {
        Integer position=guests.position(client);
        if (position==null) {
            guests.add(client);
            return true;
        }
        return false;
    }
}

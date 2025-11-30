package hotel;

import java.time.LocalDate;
import utils.DinamicArray;

/**
 * A clase Room representa unha habitación no hotel.
 * Contén información sobre o número, o nome, a capacidade e as reservas asociadas.
 */
public class Room {
    private final int number;  // Número da habitación
    private final String name; // Nome da habitación
    private final int capacity; // Capacidade de persoas da habitación
    private final DinamicArray bookings; // Array dinámico que contén as reservas da habitación

    /**
     * Constructor que inicializa unha nova instancia de Room.
     *
     * @param number   O número da habitación.
     * @param name     O nome da habitación.
     * @param capacity A capacidade máxima da habitación.
     */
    public Room(int number, String name, int capacity) {
        this.number = number;
        this.name = name;
        this.capacity = capacity;
        this.bookings = new DinamicArray(5); // Inicializa a lista de reservas cun tamaño inicial de 5.
    }

    /**
     * Busca unha reserva activa nunha data específica.
     *
     * @param date A data na que se busca a reserva.
     * @return A reserva activa nesa data, ou null se non existe.
     */
    Booking booking(LocalDate date) {
        for(int i=0;i<bookings.length();i++) {
            Booking booking=(Booking) bookings.get(i);
            if (!booking.isChecked() && booking.isActiveAt(date.atTime(12,0))) return booking;
        }
        return null;
    }
    
    /* Busca unha reserva polo seu número de identificación.
     *
     * @param booknumber O número da reserva.
     * @return A reserva correspondente, ou null se non existe.
     */
    Booking booking(int booknumber) {
        for (int i = 0; i < bookings.length(); i++) {
            Booking booking =(Booking) bookings.get(i);
            if (booking.getNumber()==booknumber) return booking;
        }
        return null;
    }

    /**
     * Obtén as reservas activas asociadas a un cliente específico identificado polo seu DNI.
     *
     * @param dni O DNI do cliente.
     * @return Un array de reservas activas dese cliente.
     */
    Object[] booking(String dni) {
        DinamicArray booklist=new DinamicArray(5);
        for (int i = 0; i < bookings.length(); i++) {
            Booking booking =(Booking) bookings.get(i);
            if (!booking.isChecked() && booking.getGuest().getDni().equals(dni)) booklist.add(booking);
        }
        return booklist.toArray();
    }
    
    /**
     * Busca unha reserva realizada por un cliente específico nunha data dada que 
     * xa teña realizado o check-in (esta ocupada)
     *
     * @param date A data na que se busca a reserva.
     * @param dni  O DNI do cliente.
     * @return A reserva correspondente, ou null se non existe.
     */
    Booking guestBook(LocalDate date,String dni) {
        DinamicArray result=new DinamicArray(10);
        for(int i=0;i<bookings.length();i++) {
            Booking booking=(Booking) bookings.get(i);
            if (booking.isChecked() && booking.isActiveAt(date.atTime(12,0)) && booking.getGuest().getDni().equals(dni)) return booking;
        }
        return null;
    }
    
    /**
     * Cancela unha reserva identificada polo seu número.
     *
     * @param booknumber O número da reserva a cancelar.
     * @return true se a reserva foi cancelada, false se non se atopou.
     */
    boolean cancelBooking(int booknumber) {
        int index=-1;
        for (int i = 0; i < bookings.length() && index<0; i++) {
            Booking booking =(Booking) bookings.get(i);
            if (booking.getNumber()==booknumber) index=i;
        }
        if (index>=0) {
            bookings.remove(index);
            return true;
        }
        return false;
    }
    
    /**
     * Cancela unha reserva especificada.
     *
     * @param booking A reserva a cancelar.
     * @return true se a reserva foi cancelada, false en caso contrario.
     */
    boolean cancelBooking(Booking booking) {
        return cancelBooking(booking.getNumber());
    }

    /**
     * Comproba se a habitación está dispoñible nun intervalo de datas.
     *
     * @param datefrom A data de inicio.
     * @param dateto   A data de fin.
     * @return true se a habitación está dispoñible, false se está ocupada.
     */
    boolean isAvailable(LocalDate datefrom,LocalDate dateto) {
        for (int i = 0; i < bookings.length(); i++) {
            Booking booking = (Booking) bookings.get(i);
            // Comproba se hai superposición entre a data da reserva e a data consultada
            if (booking.overlapsWith(datefrom, dateto)) {
                return false; // Se hai solapamento, a habitación está ocupada.
            }
        }
        return true; // Se non hai solapamento, a habitación está dispoñible.
    }

    /**
     * Realiza unha nova reserva se a habitación está dispoñible no intervalo de datas.
     *
     * @param startDate A data de inicio da reserva.
     * @param endDate   A data de fin da reserva.
     * @param guest     O cliente que realiza a reserva.
     * @return true se a reserva foi realizada, false se a habitación estaba ocupada.
     */
    public boolean bookRoom(LocalDate startDate, LocalDate endDate, Client guest) {
        // Comprobamos se a habitación está dispoñible para o intervalo de datas completo
        for (int i = 0; i < bookings.length(); i++) {
            Booking existingBooking = (Booking) bookings.get(i);
        
            // Se hai solapamento de datas, a habitación non está dispoñible
            if (existingBooking.overlapsWith(startDate, endDate)) {
                return false;
            }
        }   
        
        // Se está dispoñible, créase unha nova reserva
        Booking newBooking = new Booking(startDate, endDate, guest, this);
        bookings.add(newBooking); // Engádese a reserva ao array dinámico
        return true;
    }    
    
    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }


    public int getCapacity() {
        return capacity;
    }


    @Override
    public String toString() {
        return String.format("[%03d] %s (%d prazas)", number, name, capacity);
    }
}


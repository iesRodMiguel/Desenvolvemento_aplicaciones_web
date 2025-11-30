package hotel;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Representa unha reserva no sistema de xestión dun hotel.
 * Cada reserva ten un número único, unha data de inicio e fin,
 * un cliente, unha habitación e un estado.
 * 
 */
public class Booking {

    /** Contador global que asigna un número único a cada reserva. */
    private static int booknumber = 0;


    /** Número único da reserva. */
    private final int number;

    /** Data de inicio da reserva. */
    private final LocalDateTime startDate;

    /** Data de fin da reserva. */
    private final LocalDateTime endDate;

    /** Cliente asociado á reserva. */
    private final Client guest;

    /** Habitación asignada á reserva. */
    private final Room room;
    
    private boolean checkin;

     /**
     * Constructor que crea unha nova reserva coas datas, cliente e habitación especificados.
     * 
     * @param startDate A data de inicio da reserva.
     * @param endDate   A data de fin da reserva.
     * @param guest     O cliente que realiza a reserva.
     * @param room      A habitación asignada á reserva.
     * @throws IllegalArgumentException Se a data de inicio é posterior ou igual á data de fin.
     */
    public Booking(LocalDate startDate, LocalDate endDate, Client guest, Room room) {
        this.startDate = startDate.atTime(12,0);
        this.endDate = endDate.atTime(12,0);
        if (this.startDate.isAfter(this.endDate)) 
            throw new IllegalArgumentException("A data de saida non pode ser anterior a data de entrada");
        this.checkin=false;
        if (!this.startDate.isBefore(this.endDate)) 
            throw new IllegalArgumentException("A data de inicio debe sera anterior a data de finalización");
        this.guest = guest;
        this.room = room;
        booknumber++;
        this.number = booknumber;

    }

    /**
     * Comproba se esta reserva se solapa con un intervalo de datas dado.
     * 
     * @param start Data de inicio do intervalo.
     * @param end Data de fin do intervalo.
     * @return true se hai solapamento, false en caso contrario.
     */
    boolean overlapsWith(LocalDate start, LocalDate end) {
        return !this.endDate.isBefore(start.atTime(12,01)) && !this.startDate.isAfter(end.atTime(11,59));
    }

    /**
     * Comproba se a reserva está activa nunha data dada.
     * Unha reserva está activa se a data proporcionada está entre a data de inicio
     * e a de fin (incluíndo ambos extremos) 
     * 
     * @param datetime A data a comprobar.
     * @return true se está activa, false en caso contrario.
     */
    boolean isActiveAt(LocalDateTime datetime) {
        if ((datetime.isEqual(startDate) || datetime.isAfter(startDate)) &&
            (datetime.isEqual(endDate) || datetime.isBefore(endDate))) {
            return true;
        }
        return false;
    }

    /**
     * Comproba se o cliente realizou o check-in.
     * 
     * @return true se o check-in foi realizado, false en caso contrario.
     */
    boolean isChecked() {
        return checkin;
    }
    
    /**
     * Cancela a reserva chamando ao método de cancelación da habitación asociada.
     * 
     * @return true se a reserva foi cancelada correctamente, false en caso contrario.
     */
    public boolean cancel() {
        return room.cancelBooking(this);
    }
    
    /**
     * Marca a reserva como realizada (check-in).
     */
    public void check() {
        this.checkin=true;
    }
    
    /**
     * Obtén o número único da reserva.
     * 
     * @return O número da reserva.
     */
    public int getNumber() {
        return number;
    }

    public Client getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "RESERVA: "+room.toString()+" "+startDate.toLocalDate()+" a "+endDate.toLocalDate();
    }
    
}

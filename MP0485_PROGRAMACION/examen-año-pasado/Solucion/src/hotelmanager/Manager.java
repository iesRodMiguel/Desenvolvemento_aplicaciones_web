package hotelmanager;

import hotel.Booking;
import hotel.Client;
import hotel.Hotel;
import hotel.Room;
import java.time.LocalDate;
import utils.CancelException;
import utils.DinamicArray;
import utils.Input;

/**
 *
 * @author xavi
 */
public class Manager {
    private static Hotel hotel;
    
    /**
     * Método estático que constrúe o hotel creando un array de habitacións.
     * O hotel terá 10 habitacións, distribuídas de seguinte forma:
     * - 4 habitacións individuais
     * - 4 habitacións dobres
     * - 2 habitacións triples
     */
    private static void buildHotel() {
        // Array que almacenará as habitacións do hotel
        Room[] rooms = new Room[10]; 

        // Creación das 4 habitacións individuais
        rooms[0] = new Room(101, "Room 101", 1);
        rooms[1] = new Room(102, "Room 102", 1);
        rooms[2] = new Room(103, "Room 103", 1);
        rooms[3] = new Room(104, "Room 104", 1);

        // Creación das 4 habitacións dobres
        rooms[4] = new Room(201, "Room 201", 2);
        rooms[5] = new Room(202, "Room 202", 2);
        rooms[6] = new Room(203, "Room 203", 2);
        rooms[7] = new Room(204, "Room 204", 2);

        // Creación das 2 habitacións triples
        rooms[8] = new Room(301, "Room 301", 3);
        rooms[9] = new Room(302, "Room 302", 3);
        hotel=new Hotel("Hotel Rodeira",rooms);
    }
    
    public static Client fichaCliente(String msg) throws CancelException {
        Client client=null;
        String dni;
        System.out.println(msg);
        dni=Input.getDni("DNI");
        client=hotel.getClient(dni);
        if (client!=null) {
            System.out.println("Nome: "+client.getFirstname());
            System.out.println("Apelidos: "+client.getLastname());
            System.out.println("E-mail: "+client.getEmail());
            System.out.println("Teléfono: "+client.getPhone());
        } else {
            if (Input.question("O cliente non existe. Desexas facer o alta (s/n)?")) {
                String firstname=Input.getStr("Nome");
                String lastname=Input.getStr("Apelidos");
                String email=Input.getStr("E-mail");
                String phone=Input.getStr("Phone");
                client=new Client(dni,firstname,lastname,email,phone);
                if (Input.question("Está vostede seguro de engadir "+client+" (s/n)")){
                    if (hotel.addClient(client))
                        System.out.println("O cliente foi engadido correctamente");
                    else
                        System.out.println("Non se engadiu o cliente. Posiblemente xa existe");
                } else {
                    System.out.println("O cliente non foi engadido");
                }
            }
        }
        return client;
    }
    
    public static void main(String[] args) {
    try {
            int op;
            buildHotel();
            do {
                System.out.println("Hotel Rodeira");
                System.out.println("-------------");
                System.out.println("1.- Consulta de Cliente");
                System.out.println("2.- Facer Reserva");
                System.out.println("3.- Check-In");
                System.out.println("4.- Check-Out");
                System.out.println("5.- Cancelar Reserva");
                System.out.println("6.- Sair");
                op=Input.getInt("Elixe opcion");
                try {
                    switch(op) {
                        case 1 -> {
                            Client cliente=fichaCliente("Ficha de Cliente");
                            Input.pause("\nPara seguir pulsa Enter.");
                        }
                        case 2 -> {
                            Integer choosed=0;
                            LocalDate from=Input.getFutureDate("Data da Entrada");
                            LocalDate to=Input.getFutureDate("Data de Saida",from.atTime(12,0));
                            int px=Input.getInt("Numero de plazas (1-3)",1,3);
                            Object[] rooms=hotel.getAvailableRooms(from, to, px);
                            if (rooms.length>0) { 
                                if (rooms.length > 1) {
                                    choosed=Input.chooser("Elixe habitacion",rooms);
                                }     
                                Client cliente=fichaCliente("Indica o Cliente");
                                if ((cliente!=null) && (choosed!=null)) {
                                    Room rchose=(Room) rooms[choosed];
                                    if (Input.question("Desexa proceder a reserva de "+rchose+" para "+from+" atat "+to))
                                        if (rchose.bookRoom(from, to, cliente)) System.out.println("A reserva se realizou correctamente");
                                        else System.out.println("Non se fixo a reserva. Probablemente a habitación non está dispoñible");
                                }
                            } else System.out.println("Sin habitacións libres para esas datas");
                            Input.pause("\nPara seguir pulsa Enter.");
                        }
                        case 3 -> {
                            Integer choosed=0;
                            String dni=Input.getDni("DNI Cliente");
                            Client cl=hotel.getClient(dni);
                            if (cl!=null) {
                                Object[] bookings=hotel.booking(LocalDate.now(),cl);
                                if (bookings.length > 0) {
                                    if (bookings.length > 1) {
                                        choosed=Input.chooser("Elixe reserva",bookings);
                                    } 
                                    Booking booking=(Booking) bookings[choosed];
                                    if (Input.question("Desexa proceder a realizar o checkin de "+booking+" a cargo de "+cl)){
                                        booking.check();
                                        System.out.println("Ckeck-in Realizado Correctamente");
                                    } else System.out.println("Non se levou a cabo o checkout");
                                } else System.out.println("O cliente non ten reserva");
                            } else System.out.println(dni+" non é cliente do Hotel");
                            Input.pause("\nPara seguir pulsa Enter.");
                        }
                        case 4 -> {
                            Integer choosed=0;
                            String dni=Input.getDni("DNI Cliente");
                            Client cl=hotel.getClient(dni);
                            if (cl!=null) {
                                Object[] bookings=hotel.guestBooks(LocalDate.now(), cl);
                                if (bookings.length > 0) {
                                    if (bookings.length > 1) {
                                        choosed=Input.chooser("Elixe Reserva",bookings);
                                    } 
                                    Booking booking=(Booking) bookings[choosed];
                                    if (Input.question("Desexa proceder a realizar o checkout de "+booking)){
                                        booking.cancel();
                                        System.out.println("Ckeckout Realizado Correctamente");
                                    } else System.out.println("Non se levou a cabo o checkout");
                                } else System.out.println("O cliente non ten reserva");
                            } else System.out.println(dni+" non é cliente do Hotel");
                            Input.pause("\nPara seguir pulsa Enter.");
                        }
                        case 5 -> {
                            Integer choosed=0;
                            String dni=Input.getDni("DNI Cliente");
                            Client cl=hotel.getClient(dni);
                            if (cl!=null) {
                                Object[] bookings=hotel.booking(cl);
                                if (bookings.length > 0) {
                                    if (bookings.length > 1) {
                                        choosed=Input.chooser("Elixe Reserva",bookings);
                                    } 
                                    Booking booking=(Booking) bookings[choosed];
                                    if (Input.question("Desexa proceder a cancelación de "+booking)){
                                        if (booking.cancel())  System.out.println("Reserva cancelada correctamente");
                                        else                   System.out.println("Ocurriu un erro durante a cancelación");
                                    } else System.out.println("Non se levou a cancelación");
                                } else System.out.println("O cliente non ten reserva");
                            } else System.out.println(dni+" non é cliente do Hotel");
                            Input.pause("\nPara seguir pulsa Enter.");
                        }
                    }
                } catch(CancelException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println();
            } while(op!=6);
        } catch(CancelException e) {
            System.out.println(e.getMessage());
            System.out.println("Abandoando o programa");
        }    
    }
   
}

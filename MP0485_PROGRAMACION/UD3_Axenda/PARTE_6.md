Hacer
    Visualizar el menú
    Recoger Opción
    Según la opción:
        Si es 1: Listado de contactos
        Si es 2: Alta de contactos
        Si es 3: Buscar contacto
Mientras la opción no sea 4

[min 32:19s] [min 55] [1h 14min]

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

OJO AL UTILIZAR LOS MÉTODOS DEL OBJETO Scanner!! 

Si para escanear un numero que le pido que introduzca al usuario utilizo scn.nextInt() en lugar de scn.nextLine(), el nextInt va a recoger el número entero, pero no 'recoge' el enter. Esto implica que si depués de scn.nextInt() quiero que el usuario introduzca más cosas, como su nombre por ejemplo, y lo escaneo con scn.nextLine(), el programa va a guardar
en ese scn la línea en blanco que el Enter 'mal recogido' que pulsé después de introducir el número generó, y no va a esperar a que introduzca el nombre como yo querría.

Vamos a ver la sucesión de acontecimientos para ilustrar esto más claramente:

    Scanner scn = new Scanner(System.in);

    System.out.println("Introduce un número: ); --> Aparece en consola el texto "Introduce un número: "

    int numero = scn.nextInt(); --> Escribo el numero 8 y le doy a Enter.
                                    (1)Se almacena el 8 en la variable numero
                                    (2)El hecho de pulsar Enter, además de activar el metodo nextInt(), genera una nueva línea en blanco
    
    System.out.println("Introduce tu nombre"); --> Aparece en consola el texto "Introduce un nombre: "

    String nombre = scn.nextLine(); --> Se almacena en la variable 'nombre' una línea en blanco. La que se generó al darle al Enter antes (2)
                                        El programa continúa su ejecución sin dejarme escribir nada más porque la variable nombre ya recogió la línea en blanco
    
    System.out.println("Introduce tu edad"); --> Aparece en consola el texto "Introduce tu edad: "
                                                 El programa continúa su ejecución y nunca dejó al usuario introducir su nombre
                ......
                
                ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

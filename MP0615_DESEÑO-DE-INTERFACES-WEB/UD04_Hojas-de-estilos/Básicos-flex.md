* justify-content: Alinéa elemntos horizontalmente.

    - flex-start: Alinea elementos al lado izquierdo del contenedor.
    - flex-end: Alinea elementos al lado derecho del contenedor.
    - center: Alinea elementos en el centro del contenedor.
    - space-between: Muestra elementos con la misma distancia entre ellos. (no les pone margenes; solamente controla la distancia ENTRE los elementos)
    - space-around: Muestra elementos con la misma separación alrededor de ellos. (les pone margenes)
    
* align-items: alinea elementos verticalmente y acepta los siguientes valores:
    
    - flex-start: Alinea elementos a la parte superior del contenedor.
    - flex-end: Alinea elementos a la parte inferior del contenedor.
    - center: Alinea elementos en el centro (verticalmente hablando) del contenedor.
    - baseline: Muestra elementos en la línea base del contenedor.
    - stretch: Elementos se estiran para ajustarse al contenedor.
 
* flex-direction: define la dirección de los elementos en el contenedor, y acepta los siguientes valores:

    - row: Elementos son colocados en la misma dirección del texto.
    - row-reverse: Elementos son colocados en la dirección opuesta al texto.
    - column: Elementos se colocan de arriba hacia abajo.
    - column-reverse: Elementos se colocan de abajo hacia arriba.
    
 Al usar flex-direction: column; --> justify-content cambia a vertical y align-items a horizontal.
 
 * flex-wrap:
 
 default-value: no-wrap --> no permite el salto de linea.
 
    - flex-wrap: wrap; Permite que los elementos hijos de un contenedor flex pasen a la siguiente línea si no caben en la primera. Si los elementos no caben en una sola línea, 
    se apilan en varias líneas.
    - flex-wrap: nowrap: Los elementos intentan mantenerse en una sola línea, contrayéndose si es necesario para no desbordar. Este es el comportamiento predeterminado 
    en un contenedor flex.
    - flex-wrap: wrap-reverse: Similar a wrap, pero las líneas se apilan de abajo hacia arriba en lugar de hacerlo de arriba hacia abajo. 

 ** PORPIEDADES PARA ELEMENTOS INDIVIDUALES **
 
 * Propiedad order: A veces, invertir el orden de una fila o columna de un contenedor no es suficiente. En esos casos, nosotros podemos aplicar la propiedad order a elementos individuales. Por defecto, los elementos tienen un valor 0, pero nosotros podemos usar esta propiedad para establecerlo a un número entero positivo o negativo.
 
 * Propiedad align-self: Esta propiedad acepta los mismos valores de align-items y sus valores son usados para un elemento específico
 
 flex --> propiedad hijo
 
 * flex-basis:
 
    - Con flex-direction: column, el eje principal (main-axis) es el eje vertical --> flex-basis controla entonces la altura de los contenedores hijos, NO el ancho.
    - Con flex-direction: row, el eje principal es el horizontal --> flex-basis controla el ancho de los contenedores hijos.

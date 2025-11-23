window.addEventListener('load', function(){

  console.log("La página completa ha sido cargada");

  const formulario = this.document.querySelector('form');
  console.log({formulario});

  const boton = document.getElementById("crear");
  console.log({boton});
  
  boton.addEventListener('click', function(){

    console.log('Ejecutando evento onclick()');
    crearTabla();

  })

})


const crearTabla = () => {

  console.log('**Ejecutando crear tabla**');

  //Capturo los inputs en os que el usuario introducirá el numero de filas y de columnas que tendrá la tabla

  const inputFilas = document.getElementById('fila');
  const inputColumnas = document.getElementById('columna');
  
  console.log(inputFilas);
  console.log(inputColumnas);

  // Capturo el div donde se creará la tabla

  const divResultado = document.getElementById('resultado');

  // Creo la tabla

  const tabla = document.createElement('table');

  CrearFilasColumnas();

  // Creo un bucle anidado para:

  //  1er for: - Crear un número de filas igual al numero que haya introducido el usuario.
  //           - Dar un id a cada fila.
  //           - Gestionar los eventos de dobleclick y click derecho

  //  2º for: - Crear un numero de celdas igual al numero que haya introducido el usuario en el input columnas.
  //          - Añadir el contenido a cada celda --> Todas las celdas de cada fila tienen por contenido el numero de la fila, es decir,  i.
  //          - Añadir las celdas creadas a sus correspondientes filas, y estas a la tabla mediante appendChild();.
  //          - Dar estilos a las celdas --> Ponerles un borde azul y un pequeño padding
  //          - Gestionar el evento click sobre las celdas

  function CrearFilasColumnas(){

    let tableRow;

    for (let i = 0; i < inputFilas.value; i++) {

      tableRow = document.createElement('tr');

      tableRow.setAttribute("id", `tr${i}`);

      tableRow.addEventListener('dblclick', function eliminarFila(){

        this.remove();
        // this.style.display = "none";   // Oculta la fila en vez de eliminarla
      })

      tableRow.addEventListener('contextmenu', function(e){

        e.preventDefault();

        this.style.color = "green";
      })

      for (let j = 0; j < inputColumnas.value; j++) {

       const tableCell = document.createElement('td');

        tableCell.textContent = `${i}`;

        tableCell.style.border = "1px solid blue";
        tableCell.style.padding = "0.5em";
        tableCell.style.fontSize = "1.5em";

        tableRow.appendChild(tableCell);

        tableCell.addEventListener('click', function cambioBackgrund(){

          this.style.backgroundColor = "blue";

        })

      }

      tabla.appendChild(tableRow);

    }
  
    
  }

  // Añado la tabla creada al divResultado y le doy estilos:

  divResultado.appendChild(tabla);

  tabla.style.border ="solid 1px blue";
  console.log(tabla);
}
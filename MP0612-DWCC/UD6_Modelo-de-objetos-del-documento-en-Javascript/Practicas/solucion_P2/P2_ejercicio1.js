//El evento onload de Javascript 
//se activa cuando se termina de cargar la página.

window.addEventListener('load', function () {
    console.log('La página ha terminado de cargarse!!');

    const boton = document.getElementById('enviar');
    const form = this.document.querySelector('form');

    console.log(form);


    form.addEventListener('submit', (e) => {
        //Desactivar la funcionalidad por defecto de un botón de tipo Submit que es enviar los datos del formulario y recargar la pagina
        e.preventDefault();
        console.log("Elemento donde dispara el evento" + e.target);// elemento donde ocurrió el evento.
        console.log("Elemento donde ocurrió el evento" + this);// elemento donde ocurrió el evento.
        crearTexto();

    });
    /* boton.addEventListener('submit', (e) => {  
          //Desactivar la funcionalidad por defecto de un botón de tipo Submit que es enviar los datos del formulario y recargar la pagina
        e.preventDefault(); 
        console.log("Elemento donde dispara el evento" +e.target);// elemento donde ocurrió el evento.
        console.log("Elemento donde ocurrió el evento" +this);// elemento donde
        crearTexto(); 
    
    });  */
    //Asignar el foco al cuadro de texto
    const cuadroNombre = document.getElementById('nombre');
    cuadroNombre.focus();
});



const crearTexto = () => {
    //Obtengo el nombre del campo de texto
    const nombre = document.querySelector('#nombre').value;

    //Obtengo el color de la lista desplegable
    const colores = document.querySelector('select[name="color"]');;
    console.log(colores.options);

    let color = colores.options[colores.selectedIndex].value;
    //Tambiés sería válido, al menos en Chrome y Firefox, color = colores.value
    console.log(color);

    //Obtengo la fuente de los botones radio
    const fuentes = document.querySelectorAll('input[type="radio"][name="fuente"]');

    let fuente='serif'; //Le damos un valor inicial 

    for (let i = 0; i < fuentes.length; i++) {
        if (fuentes[i].checked) {
            fuente = fuentes[i].value;
            break; // Finaliza el bucle cuando lo encuentra
        }
    }

   
    console.log('La fuente elegida es', fuente);

    /*  const fuente = elegido ? elegido.value : 'serif'; */ // valor por defecto si no hay ninguno

    //Obtengo los efectos del checkbox
    const tachado = document.querySelector('input[type="checkbox"][name="tachado"]');
    const negrita = document.querySelector('input[type="checkbox"][name="negrita"]');
    const cursiva = document.querySelector('input[type="checkbox"][name="cursiva"]');
    const versalita = document.querySelector('input[type="checkbox"][name="versalita"]');
    const subrayado = document.querySelector('input[type="checkbox"][name="subrayado"]');

    //Ahora genero el texto
    const resultado = document.getElementById("resultado");
    //Escribo el texto
    resultado.innerHTML = nombre;

    //FALTA BORRAR EL ESTILO
    resultado.removeAttribute("style");
    resultado.style.textTransform = "capitalize"; //Esto serviría para poner las palabras con la primera letra en mayúscula si no se tuvieran en cuenta de, del o la

    //Aplico el color
    resultado.style.color = color;
    //Aplico la fuente
    resultado.style.fontFamily = fuente;
    resultado.style.fontSize = "40px"; //Pongo el texto mayor para que se vean los efectos

    //Aplico los efectos. En este caso no se utiliza un if anidado ya que las casillas de verificación permiten seleccionar varios estilos 
    if (tachado)
        resultado.style.textDecoration = "line-through";
    if (negrita)
        resultado.style.fontWeight = "bold";
    if (cursiva)
        resultado.style.fontStyle = "italic";
    if (versalita)
        resultado.style.fontVariant = "small-caps";
    if (subrayado)
        resultado.style.textDecoration = "underline";
    if ((subrayado) && (tachado))
        resultado.style.textDecoration = "line-through underline";

}
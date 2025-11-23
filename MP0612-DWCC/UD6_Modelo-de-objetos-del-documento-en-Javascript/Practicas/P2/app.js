/**
 * * Evento load & Diferencia con DOMContentLoaded:
 * 
 * El evento 'load' se dispara cuando la página completa ha sido cargada, incluyendo todos los recurso dependientes como hojas de estilo, scripts (incluyendo
 * async, deferred y module scripts]), iframes e imágenes, excepto aquellos que sean 'loaded lazyli'.
 * 
 * Esto contrasta con el evento DOMContentLoaded, que se dispara tan pronto como la página DOM ha sido cargada, sin esperar a que terminen de cargarse los
 * recursos.
 */

window.addEventListener('load', function (){
  
  console.log("La página se ha cargado");

  const btn = document.getElementById("enviar");
  const formulario = this.document.querySelector('form');
  /**
   * * querySelector():
   * 
   *  Método del Document (o de cualquier Element) que ACEPTA UN SELECTOR CSS y devuelve EL PRIMER ELEMENTO que coincide en el árbol DOM, o null 
   *  si no hay coincidencias.
   * 
   *  - "form" es un selector CSS tipo (tag selector) que busca la primera etiqueta <form>.
   *  - querySelector soporta cualquier selector válido de CSS: clases (.clase), id (#miId), selectores complejos form > input[name="email"], 
   *    pseudoclases, etc.
   *  - Retorna un objeto Element (ej. HTMLFormElement) o null.
   *    
   */

  console.log(formulario);
/**
 * ? const: 
 * 
 *  Declara una variable DE SÓLO LECTURA en el bloque actual. No significa que el valor sea inmutable, sino que LA VARIABLE 'formulario' NO PUEDE 
 *  VOLVER A ASIGNARSE. El objeto del DOM al que apunta puede modificarse (propiedades, métodos), pero no se puede reasignar 'formulario = otraCosa'.
 * 
 * * this: 
 * 
 *   Referencia al CONTEXTO DE EJECUCIÓN ACTUAL. Importante:
 * 
 *    - En un script global no modular, fuera de cualquier función, this === window en navegadores (non-strict). Por tanto this.document suele equivaler 
 *      a window.document.
 *    - En modo estricto ( 'use strict' ) en el contexto global dentro de módulos ES (<script type="module">) this es undefined. 
 *      En ese caso this.document lanzaría un TypeError porque intentas acceder a la propiedad document de undefined.
 *    - Dentro de funciones, this depende de cómo fue llamada la función (invocación directa, como método, ligada con .bind, arrow functions, etc.). 
 *      Por eso usar this.document es frágil salvo que sepas exactamente el contexto.
 **/

  formulario.addEventListener('submit', (e) => {

    e.preventDefault();
    //Desactiva la funcionalidad por defecto de un botón de tipo Submit que es enviar los datos del formulario y RECARGAR LA PÁGINA
    console.log("Elemento dónde se dispara el evento: " + e.target);
    // La propiedad 'target' de la interfaz del event.currentTarget es una referencia al objeto en el cual se lanzo el evento.
    console.log("Elemento al que el controlador del evento fue asociado: " + e.currentTargettarget);
    // currenrTarget hace referencia al elmento al cual el controlador del evento fue asociado, a diferencia de event.target, que identifica el elemento el el que se produjo el evento.
    console.log("Elemento donde ocurrió el evento" + this);// elemento donde ocurrió el evento.

    construirTextoSpan();

  })

  // Asignar el foco al cuadro de texto

    const inputNombre = document.getElementById('nombre');
    inputNombre.focus(console.log('Ejecutado focus')); // Fija el foco del cursor en el elemento indicado (es cómo si ya hubieramos hecho un click en él). Si éste puede ser enfocado.

})

const construirTextoSpan = () => {

  const nombre = document.querySelector('#nombre').value;
  
  const inputSelectColores = document.querySelector('select[name=color]');
  console.log({inputSelectColores});

  let color = inputSelectColores.options[inputSelectColores.selectedIndex].value; 
  //  let color = inputSelectColores.options.selectedIndex.value; 

  /**
   * ? El la etiqueta <select> (como todo en JavaScritp) es un objeto que tiene la propiedad 'options' (que es a su vez un objeto).
   *   inputSelectColores: select {  
   *     Options: HTMLOptionsCollection(4) 
   *        0: option
   *        1: option
   *        2: option
   *        3: option
   *        length: 4
   *        selectedIndex: 1
   *   }
   * ? Accedo mediante la notacion de puntos a la propiedad 'selectedIndex' del objeto options{}.
   */
  //También sería válido, al menos en Chrome y Firefox, color = colores.value
  
  console.log({color});

  const inputRadioFuentes = document.querySelectorAll('input[type="radio"][name="fuente"]');
  let fuente = 'serif';

  for (let i = 0; i < inputRadioFuentes.length; i++) {
    
    if(inputRadioFuentes[i].checked){
    
      fuente = inputRadioFuentes[i].value;
      break;
    } 

  }

  console.log({inputRadioFuentes});
  console.log('La fuente elegida es', fuente);

  const inputTachado = document.querySelector('input[type="checkbox"][name="tachado"]');
  const inputNegrita = document.querySelector('input[type="checkbox"][name="negrita"]');
  const inputCursiva = document.querySelector('input[type="checkbox"][name="cursiva"]');
  const inputVersalita = document.querySelector('input[type="checkbox"][name="versalita"]');
  const inputSubrayado = document.querySelector('input[type="checkbox"][name="subrayado"]');

  const spanResultado = document.getElementById('resultado');

  // Empezamos a modificar el <span id="resultado">

  // 1º Reseteamos los estilos que tenga
  spanResultado.removeAttribute("style");

  spanResultado.innerText = nombre;
  spanResultado.style.color = color;
  spanResultado.style.fontFamily = fuente;
  spanResultado.style.fontSize = "50px";

  if(inputTachado.checked){

    spanResultado.style.textDecoration = "line-through";

  }
  if (inputNegrita.checked) {

    spanResultado.style.fontWeight = "bold";

  }
  if (inputCursiva.checked) {

    spanResultado.style.fontStyle = "italic";

  }
  if (inputVersalita.checked){

    spanResultado.style.fontVariant = "small-caps";

  }
  if (inputSubrayado.checked) {

    spanResultado.textDecoration = "underline";

  }

}
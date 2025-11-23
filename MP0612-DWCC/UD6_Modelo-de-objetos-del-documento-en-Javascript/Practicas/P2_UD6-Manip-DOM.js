let formulario = document.getElementsByName("miFormulario")[0]; 

/* Aquí le tuve que poner el [0] (1º posición del array) porque al capturar el formulario con el método getElementByName() no devuelve un solo elemento, sino una NodeList (una especie 
de array con los nodos del DOM que tienen ese nombre).

Es decir, let formulario es algo como esto NodeList [form]

y las NodeList no tienen addEventListener() (porque NO SON UN UNICO NODO, SINO UNA COLECCIÓN).

*/
let inputName = document.getElementById("nombre");
let inputSelect = document.getElementById("selectorColores");
let spanResultado = document.getElementById("resultado");
const inputFuentes = document.querySelectorAll('input[type="radio"][name="fuente"]'); /* Devuelve todos los descendientes del nodo seleccionado (en este caso
el nodo seleccionado es document) que coincidan con el texto introducido entre comillas
*/


// let inputFuente = document.getElementsByName("fuente"); // Devuelve también una NodeList
// let [serif, sansSerif, cursive, fantasy, monospace] = inputFuente; 
// console.log(inputFuente[0]);
// console.log(cursive);
// console.log("inputSelect: " + inputSelect);
// let inputFuenteValue = inputFuente.value;

formulario.addEventListener("submit", function EjecutarScript(evitarRefresh){

  evitarRefresh.preventDefault(); // evita que se recargue la página cuando se entrega el formulario
    
  let inputNameValue = inputName.value;
  let inputSelectValue = inputSelect.value;

  spanResultado.innerText= inputNameValue;

  switch (inputSelectValue) {
    case "red":
        spanResultado.style.color = "red";
      break;
  
    case "green":
        spanResultado.style.color = "green";
      break;

    case "blue":
        spanResultado.style.color = "blue";
      break;

    case "black":
        spanResultado.style.color = "black";
      break;
  }

  let fuente = 'serif';

  for (let i = 0; i < inputFuentes.length; i++) {
    
    if(inputFuentes[i].checked){

      fuente = inputFuentes[i].value;
            
      break; // Finaliza el bucle cuando lo encuentra

    }
      spanResultado.style.fontFamily=fuente; //TODO La fuente no se aplica --> comprobar en hoja de estilos si estas fuentes esta o habria que cogerlas de googlefonts p.ej
    
  }
    console.log('La fuente elegida es', fuente);
    spanResultado.style.fontFamily=fuente; 
  // for (let i = 0; i < inputFuente.length; i++) {
    
  //   const element = inputFuente[i];
    
  //   return element;
  // }


  // console.log({element});



  // switch (inputFuenteValue) { 
  //   case "serif":
  //       spanResultado.style.fontFamily = "serif";
  //     break;

  //   case "sans-serif":
  //       spanResultado.style.fontFamily = "sans-serif";
      
  //     break;

  //   case "cursive":
  //       spanResultado.style.fontFamily = "cursive";
      
  //     break;

  //   case "fantasy":
  //       spanResultado.style.fontFamily = "fantasy";
      
  //     break;

  //   case "monospace":
  //       spanResultado.style.fontFamily = "monospace";
      
  //     break;
  // }
  
})
console.log(formulario);
console.log({inputName});
console.log("inputNameValue: " + inputNameValue);
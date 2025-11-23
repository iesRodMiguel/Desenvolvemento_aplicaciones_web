function createMultiElement (elemType, count){

  const elems = [];

  for (let i = 0; i < count; i++) {
    
    elems.push(document.createElement(elemType));

  }

  return elems;

}
function multiAppend(arrSonElem, father) {
  for (let i = 0; i < arrSonElem.length; i++) {
    father.appendChild(arrSonElem[i]);
    
  }
}


let btnCrear = document.getElementById("crear");
let btnDestruir = document.getElementById("destruir");

let listaDinamica = document.createElement("ul");


let ArrLis = createMultiElement("li", 3);
const [li1Ul, li2Ul, li3Ul] = ArrLis;

li1Ul.innerText= "1";
li2Ul.innerText= "2";
li3Ul.innerText= "3";

multiAppend(ArrLis, listaDinamica);

btnCrear.onclick = function CrearLista() {
  document.body.append(listaDinamica);
}
console.log(listaDinamica);

btnDestruir.onclick = function destruirLista(){
 document.body.removeChild(listaDinamica);
}


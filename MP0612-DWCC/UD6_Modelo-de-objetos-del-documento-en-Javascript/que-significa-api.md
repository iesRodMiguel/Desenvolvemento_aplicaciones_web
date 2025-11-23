API: Interfaz de Programación de Aplicaciones.

DOM: Document Object Model. Proporciona un conjunto estándar de objetos, para representar documentos HTML y XML, un modelo estándar sobre cómo pueden combinarse dichos objetos, y una interfaz estándar para acceder a ellos y manipularlos. A través del DOM los programas pueden acceder y modificar el contenido, estructura y estilo de los documentos HTML y XML, que es para lo que se diseñó principalmente. El responsable del DOM es el W3C.

El DOM está separado en 3 partes / niveles:

DOM Core – modelo estándar para cualquier documento estructurado.
DOM XML – modelo estándar para documentos XML.
DOM HTML – modelo estándar para documentos HTML.


TIPOS DE NODOS:

La especificación completa de DOM define 12 tipos de nodos, aunque las páginas XHTML
habituales se pueden manipular manejando solamente cuatro o cinco tipos de nodos:

●Document, nodo raíz del que derivan todos los demás nodos del árbol.
●Element, representa cada una de las etiquetas XHTML. Se trata del único nodo
que puede contener atributos y el único del que pueden derivar otros nodos.
●Attr, se define un nodo de este tipo para representar cada uno de los atributos
de las etiquetas XHTML, es decir, uno por cada par atributo=valor.
●Text, nodo que contiene el texto encerrado por una etiqueta XHTML.
●Comment, representa los comentarios incluidos en la página XHTML.


Diferencia entre append y appendChild: 

La principal diferencia es que appendChild
es una función DOM mientras que append es una función de JavaScript.


Eliminación de nodos:

Es necesario utilizar la función removeChild(): La función removeChild() requiere como parámetro el nodo que se va a eliminar.
Además, esta función debe ser invocada desde el elemento padre de ese nodo que se
quiere eliminar.


Append, prepend: 

Append() y prepend() son métodos prácticos para
manipular el DOM de manera eficiente y directa. Ambos métodos son ideales
para cuando se quiere agregar elementos sin sobrescribir o eliminar los
existentes.

append(): es útil cuando se desea mantener el contenido existente y
agregar algo al final (por ejemplo, cuando se muestran mensajes nuevos
en una lista o se añaden más resultados a una página).

Prepend(): es útil cuando quieres colocar algo al principio (como un
mensaje que debe aparecer primero o nuevos elementos en una lista que
deben mostrarse antes de los anteriores

NextSibling() previusSibling():

nextSibling: Gracias a nextSibling, lo que podemos seleccionar es el
siguiente hermano de un elemento. Se aplican las mismas limitaciones que
para las dos propiedades anteriores.

previousSibling : previousSibling funciona igual que nextSibling, pero
selecciona el hermano anterior de un elemento.



insertAfter: No hay un metodo que inserte un nodo detrás de otro.

replaceChild: Para reemplazar un nodo por otro contamos con replaceChild,
cuya sintaxis es:

elemento_padre.replaceChild(nuevo_nodo,nodo_a_reemplazar);

removeChild: Dado que podemos incluir nuevos hijos en un nodo, tiene
sentido que podamos eliminarlos. Para ello existe el método removeChild.

elemento_padre.removeChild(nodo_a_eliminar);

cloneNode: Por último, podemos crear un clon de un nodo por medio de elemento_a_clonar.cloneNode(booleano);

--------------------------------------------------------------------------------------------------------------

(method) ParentNode.querySelector(''):

Returns the first element that is a descendant of node that matches selectors. 
Devuelve el primer elemento que es descendiente del nodo que coincide con el texto introducido dentro del método.

p.ej:

    const form = this.document.querySelector('form'); <form name="miFormulario" >...</form>
    
    En lugar de devolernos una Nodelist como haría getElementByName('formulario'), de la cual tendriamos que 
    almacenar nosostros en una variable la posición que ocupe el form en esa NodeList,
    
    Nos devuelve directamente el primer elemento de esa Nodelist cuyo nombre coincida con 'form'.
    
    getElementByName('formulario') --> Devuelve un 'array' Nodelist
    querySelector('form') --> Devuelve un único elemento, la etiqueta <form>

--------------------------------------------------------------------------------------------------------------

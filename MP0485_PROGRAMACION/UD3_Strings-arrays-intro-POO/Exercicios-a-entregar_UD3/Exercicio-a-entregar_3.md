
A clase Cliente do exercicio anterior ten varios defectos que desexamos corrixir:

Queremos impedir a creación de obxectos Cliente con nif erróneos
Queremos impedir que se poñan numeros de teléfono erróneos a un cliente
Queremos impediir que se poñan email erróneos a un cliente
Para impedir isto, crearemos unha clase Valida no package com.iesrodeira.utils cos cos métodos estáticos necesarios para:

Validar un DNI
Validar o email. Consideramos un email válido si está composto dun String ou varios separados con puntos, unha @ e detrás como mínimo dous Strings separados por . O último soamente pode ter entre 2 e 3 letras.
Validar un teléfono. O teléfono pode empezar por + e un número de 2 díxitos, seguido de  9 díxitos, ou soamente 9 díxitos.
Unha vez feito isto se debe modificar a clase Cliente para que non permita nin a creación de clientes con información errónea nin poñer un dato erróneo no email ou teléfono.

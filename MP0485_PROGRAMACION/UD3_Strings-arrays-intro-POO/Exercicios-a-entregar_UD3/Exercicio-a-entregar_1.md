Se pide escribir unha clase denominada StringUtils no package com.iesrodeira.programacion.utils.  Dentro de esa clase se debe desenvolver os métodos estáticos públicos:

- public int vocals(String s); que nos retorna o número de vocais que ten a frase recibida como argumento (s) - ollo coas maiúsculas/minúsculas
- public String reverse(String s); que nos retorna a frase recibida como argumento (s) dada a volta ("proba ->  aborp")
- public boolean ePalindroma(String s); que nos indica si unha frase recibida como argumento (s) é palíndroma ou non.
- public String clean(String s);  que retorna a frase s sen espazos no inicio e no final e como máximo un único espazo de separación entre palabras  ( "   hola      que       tal " -->        "hola que tal",  o mellor é facelo con expresións regulares, mira  replaceAll  na clase String)
- public String[] getWords(String s, int min, int, max);  que retorna un array de String[] coas palabras da frase que teñen polo menos min caracteres e como moito max caracteres.  PISTA:      Podes dividir o String en palabras co método split() de String. Suxiro ir creando un novo String coas palabras elixidas e a continuación dividilas de novo co método split() da clase String)

Debes facer un programa dentro do package com.iesrodeira.probas que lle solicite ao usuario unha palabra e :

- Nos indique cantas vocais ten
- A visualice invertida
- Nos indique si é palíndroma
- A visualice sen espazos no inicio e no final e como moito un espazo entre palabras
- Visualice todas as palabras que teñan como mínimo 4 letras e como máximo 8 letras

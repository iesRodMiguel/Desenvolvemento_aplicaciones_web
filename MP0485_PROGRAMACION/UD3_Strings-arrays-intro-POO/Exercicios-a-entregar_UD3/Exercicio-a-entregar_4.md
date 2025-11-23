Exercicio a entregar IV
--------------------------------------------------------------------------------
Completion requirements
Opened: Monday, 20 October 2025, 12:00 AM
Due: Wednesday, 5 November 2025, 12:00 AM
--------------------------------------------------------------------------------
Imos desenvolver as nosas propias Exceptions para poder notificar situaciones "especiais" sen necesidade de elixir unha Exception da libraría de clases de Java, e poder deseñar unha ao noso gusto.

En primeiro lugar debes mirar a clase Throwable  ahí poderás observar que métodos teñen os obxectos que pertencen a Throwable. Como podes ver no encabezado de Throwable heredan dúas clases Exception e Error (que polo tanto dispoñen como mínimo de todos os atributos e métodos de Throwable que non sexan privados).

Error está pensado para notificar situacións que deberían dar lugar a finalización do programa, normalmente non deben ser capturados (usando catch). 

Podemos botar unha ollada a clase Exception. Ahí podes ver unha lista de todas as clases que herdan de Exception presentes na libraría de clases de Java.

Dentro de estas podemos observar RuntimeException  que tamén e (como os Error) unha excepción non vixiada. Se pode capturar, pero se pode ignorar completamente. Vemos tamén que existen numerosas clases na libraría de Java que herdan de RuntimeException.

Para deseñar a nosa propia "notificación de situación anómala" (throwable) podemos polo tanto:

Herdar de Error :  Crearemos unha nova sinal de tipo Error. Non vixiada e que non se debería capturar. Notificaría un erro irrecuperable
Herdar de Exception - Crearíamos unha sinal de excepción vixiada. Debemos capturala ou indicar no método que se lanza
Herdar de RuntimeException - Crearíamos unha sinal de excepción non vixiada. Non precisa ser capturada nin indicada no método (o que raras veces é conveniente).
Para herdar dunha clase, debemos poñer atención aos seus construtores, e ter en conta que herdaremos todos os atributos e metodos non privados da clase. Logo podemos crear novos métodos e atributos, ou modificar o comportamento de algún dos métodos escribindo a nosa propia versión.

Si a clase base (por exemplo Exception) non ten ningún construtor sin parámetros, temos a obriga de crear un construtor na nova clase herdada que chame a un construtor da clase base como primeira instrución usando "super". Si a clase base ten algún construtor sin argumentos (construtor por defecto) non e necesario, xa que a JVM chamará a ese construtor automáticamente.

Se pide crear a clase CancelException que é unha Exception. para crear unha CancelException podemos chamar a un construtor sen argumentos ou a un construtor que acepta un String que será o que retorne o método String getMessage() da clase Exception.

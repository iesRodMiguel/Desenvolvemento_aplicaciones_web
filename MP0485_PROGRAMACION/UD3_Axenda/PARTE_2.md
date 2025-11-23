Utilidades de Entrada e Visualización 
No package com.iesrodeira.utils imos desenvolver a clase Input que nos fornecerá dos seguintes métodos estáticos accesibles dende todas partes:

      - void testNif(String nif) throws IllegalArgumentException; 
         * Si o nif non é un nif válido lanza IllegalArgumentException

      - void testEmail(String email) throws IllegalArgumentException;
         * Si o email non é un email válido lanza IllegalArgumentException

      - void testPhone(String phone) throws IllegalArgumentException; 
         * Si o phone non é un teléfono válido lanza IllegalArgumentException

      - String readText(String title) throws CancelException;
         * Visualiza o texto title (* para cancelar) e retorna o texto introducido polo usuario
            Si o usuario escribe * que lanza unha CancelException (que debes crear) cunha mensaxe axeitada.

      - String readText(String title,String default) throws CancelException;
         * Visualiza o texto title (* para cancelar) e retorna o texto introducido polo usuario
            Si o usuario escribe * que lanza unha CancelException (que debes crear) cunha mensaxe axeitada.
            Si o usuario simplemente pulsa Enter, retornará o valor especificado en default

      - String readPhone(String title) throws CancelException;
         * Visualiza o texto title (* para cancelar) e retorna o teléfono introducido polo usuario
            Debe insistir ata que o introducido sexa un teléfono correcto ou o usuario cancele a entrada con *, que lanzará unha CancelException cunha mensaxe axeitada

      - String readPhone(String title,String default) throws CancelException;
         * Visualiza o texto title (* para cancelar) e retorna o teléfono introducido polo usuario
            Debe insistir ata que o introducido sexa un teléfono correcto ou o usuario cancele a entrada con *, que lanzará unha CancelException cunha mensaxe axeitada
            Si o usuario simplemente pulsa Enter, retornará o valor especificado en default
            
      - String readEmail(String title) throws CancelException;
         * Visualiza o texto title (* para cancelar) e retorna o email introducido polo usuario
            Debe insistir ata que o introducido sexa un email correcto ou o usuario cancele a entrada con *, que lanzará unha CancelException cunha mensaxe axeitada
           
      - String readEmail(String title,String default) throws CancelException;
         * Visualiza o texto title (* para cancelar) e retorna o email introducido polo usuario
            Debe insistir ata que o introducido sexa un email correcto ou o usuario cancele a entrada con *, que lanzará unha CancelException cunha mensaxe axeitada
            Si o usuario simplemente pulsa Enter, retornará o valor especificado en default
                       
      - String option(String title,String validos) throws CancelException;
         * Visualiza o texto title (* para cancelar) e retorna a letra introducida polo usuario que coincida con algunha daas especificadas no String validos. 
            Si non coincide con ningunha, se debe insistir a non ser que o usuario cancele con *, que lanzará unha CancelException cunha mensaxe axeitada
            
      - boolean areYouSure() throws CancelException;
         * Visualiza a mensaxe "Está vostede seguro? (S/N) (* para cancelar):" e retorna true si o usuario escribe s ou S e false si escribe n ou N
            En outro caso insiste, a non ser que o usuario cancele con *, que lanzará unha CancelException cunha mensaxe axeitada.
            
      - boolean waitEnter(String message);
         * Visualiza unha mensaxe e se queda esperando a que o usuario pulse enter, logo remata o método.

       - boolean waitEnter();
         * Visualiza a mensaxe "Para continuar pulsa Enter", e se queda esperando a que o usuario pulse enter, logo remata o método.
            
--> Podes facer un main para comprobar o seu funcionamento, pero ese main non será o da aplicación 
--> CancelException estará no package com.iesrodeira.utils

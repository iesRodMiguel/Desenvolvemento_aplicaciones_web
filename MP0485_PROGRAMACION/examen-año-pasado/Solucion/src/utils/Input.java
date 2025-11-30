
package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

/**

 */
public class Input {
    private static Scanner scn=new Scanner(System.in);
    private static final String CANCELSTR="*";
   
    /**
     * Para poder reutilizar esta operación en posibles diferentes entradas de datos...
     * ( string, double, dni, email, diasemana, date, time .... )
     * aforrando código
     * 
     * @param msg
     * @return
     * @throws CancelException 
     */
    public static String getStr(String msg) throws CancelException {
        System.out.print(msg+" ("+CANCELSTR+" para cancelar): ");
        String input=scn.nextLine();
        if (input.equals(CANCELSTR)) throw new CancelException();
        return input;
    }
    
      
    public static String validString(String msg,Validator validator) throws CancelException {
        boolean ok=false;
        String str;
        
        do {
            str=getStr(msg);
            if (!validator.isValid(str)) System.out.println("\t"+validator.message());
            else                         ok=true;
        } while(!ok);
        return str;
    }
    
    public static String getDni(String msg) throws CancelException {
        return validString(msg,new DniValidator());
    }
    
  
    public static LocalDate getDate(String msg) throws CancelException {
        DateValidator validator=new DateValidator();
        validString(msg,validator);
        return validator.getDate();
    }
    
    public static LocalDate getFutureDate(String msg) throws CancelException {
        DateValidator validator=new FutureDateValidator();
        validString(msg,validator);
        return validator.getDate();
    }
    
    public static LocalDate getFutureDate(String msg,LocalDateTime future) throws CancelException {
        DateValidator validator=new FutureDateValidator(future);
        validString(msg,validator);
        return validator.getDate();
    }
    
    public static int getInt(String msg,int min, int max) throws CancelException {
        boolean ok=false;
        int num=0;
        
        do {
            try {
                String strnum=getStr(msg);
                num=Integer.parseInt(strnum);
                if ((num<min) || (num>max)) {
                    System.out.println("\t--> O valor debe estar entre "+min+" e "+max+" (incluídos)");
                } else {
                    ok=true;
                }
            } catch(NumberFormatException e) {
                System.out.println("\t--> Debes introducir un valor numérico enteiro");
            }
        } while(!ok);
        return num;
    }
    
    public static int getInt(String msg) throws CancelException {
        return Input.getInt(msg,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    
    public static boolean question(String msg) throws CancelException {
        String str=validString(msg,new YesNoValidator());
        return str.equals("s") || str.equals("S") || str.equals("y") || str.equals("Y");
    }

    public static void pause(String msg) {
        System.out.print(msg);
        scn.nextLine();
    }

    public static Integer chooser(String msg, Object[] objects) throws CancelException {
        Integer num=null;
        System.out.println(msg);
        for(int idx=0;idx<objects.length;idx++) System.out.println((idx+1)+".-"+objects[idx]);
        num=Input.getInt("Selecciona Elemento",1,objects.length);
        return num-1;
    }
    
}

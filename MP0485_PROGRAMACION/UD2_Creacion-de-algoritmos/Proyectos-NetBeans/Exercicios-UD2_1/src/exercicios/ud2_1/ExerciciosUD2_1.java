/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicios.ud2_1;

/**
 *
 * @author miguel
 */

import java.util.Scanner; 

public class ExerciciosUD2_1 {

    /**
     * @param a
     * @param b
     * @param c
     * @return 
     */
    public int sumar(int a, int b) {
        return a + b;
    }
    
    public String parImpar (int c){
    
        if (c%2 == 0){
            return "El número es par.";
        } else {
            return "El número es impar.";
        }
    }
    
    public String evaluacionMayor (int d, int f, int g){
    
        if (d > f && d >g){
            return "El número mayor es " + d;
        } else if (f > d && f > g){
            return "El número mayor es " + f;

        }else if (g > d && g > f){
            return "El número mayor es " + g;

        }
        return null;
    
    }
    
    public int tablaMultiplicar (int x) {
        int i;
        for (i = 0; i <11; i ++) {
            System.out.println(x*i);
        }
        return x;
        
    }
    
    public int sumatorio (int a) {
        int i;
        for (i = 0; i < a; i++){
            System.out.println(a + i);
        }
        return a;
    }
    
    public int factorial (int a) {
        int i;
        for (i = 0; i < a; i++){
            System.out.println(a * i);
        }
        return a;
    }
    
    public String evalPrimo (int a) {
        int i = 2;
        
        do {
            int evaluacion = a % i;
            i++;
        } while (i <= a);
        
        if (a % i == 0){
             System.out.println("El número " + a + " no es primo");
         } else {
             System.out.println("El número " + a + " es primo");
         }
        
        return "FIN";
    }
    
    public static void main(String[] args) {
        
        String sep = " ";

        //1. Saída de texto: Escribe un programa que imprima o teu nome na pantalla
        
        System.out.println("Miguel");
        System.out.println(sep);
        
        //2. Suma de dous números: Pide ao usuario dous números e mostra a súa suma.
        
        Scanner scn = new Scanner(System.in);
        
        System.out.print("Introduce dous números e os sumaremos: ");
        
        int sumando1 = scn.nextInt();
        int sumando2 = scn.nextInt();

        ExerciciosUD2_1 objSuma = new ExerciciosUD2_1();
        
        int r =objSuma.sumar(sumando1, sumando2);

        System.out.print("Resultadoda da suma: " + r);
        System.out.println(sep);
        System.out.println(sep);


        // 3. Par ou impar: Pide un número ao usuario e indica se é par ou impar.

        System.out.print("Introduce un número e evaluaremos se é par ou impar: ");

        int n1 = scn.nextInt();
        
        ExerciciosUD2_1 evaluacionParImpar = new ExerciciosUD2_1();
        
        String ej3 = evaluacionParImpar.parImpar(n1);
        System.out.print(ej3);
        System.out.println(sep);
        System.out.println(sep);

        
        //4. Maior de tres números: Pide tres números e mostra cal é o maior.

        System.out.print("Introduce tres números. Te indicaremos cúal es el mayor de ellos: ");
        
        int n2 = scn.nextInt();
        int n3 = scn.nextInt();
        int n4 = scn.nextInt();
        
        ExerciciosUD2_1 numMayor = new ExerciciosUD2_1();

        String ej4 = numMayor.evaluacionMayor(n2, n3, n4);
        System.out.print(ej4);
        System.out.println(sep);
        System.out.println(sep);

        // 5. Tabela de multiplicar: Pide un número e imprime a súa táboa de multiplicar do 1 ao 10.
        
        System.out.print("Introduce un número. Se creará su tabla de multiplicar: ");

        int x = scn.nextInt();
        
        ExerciciosUD2_1 objTablaMult = new ExerciciosUD2_1();
        
        int ej5 = objTablaMult.tablaMultiplicar(x);
        
        System.out.print(ej5);
        System.out.println(sep);
        System.out.println(sep);

        // 6. Suma dos primeiros N números: Pide un número N e calcula a suma de todos os númernos enteiros dende 1 ata N.
        
        System.out.print("Introduce un número. Se creará el sumatorio de todos los número comprendidos entre 0 y el número proporcionado: ");
        
        int N = scn.nextInt();
        
        ExerciciosUD2_1 objSumatorio = new ExerciciosUD2_1();
        
        int ej6 = objSumatorio.sumatorio(N);
        
        System.out.print(ej6);
        System.out.println(sep);
        System.out.println(sep);
        
        /* 7.Factorial dun número: Pide un número e calcula o seu factorial. O factorial dun número enteiro positivo N e N
        multiplicado por todos os números anteriores maiores ca 1-*/
        
        System.out.print("Introduce un número. Se creará su factorial: ");

        int M = scn.nextInt();

        ExerciciosUD2_1 objFactorial = new ExerciciosUD2_1();
        
        int ej7 = objFactorial.factorial(M);
        
        System.out.print(ej7);
        System.out.println(sep);
        System.out.println(sep);

        // 8. Número primo: Pide un número e indica se é primo ou non. 
        
        System.out.print("Introduce un número. Se evaluará si es primo: ");
        
        int y = scn.nextInt();
        
        ExerciciosUD2_1 objPrimo = new ExerciciosUD2_1();
        
        String ej8 = objPrimo.evalPrimo(y);
        
        System.out.print(ej8);
        System.out.println(sep);
        System.out.println(sep);


    }
    
    
    
}

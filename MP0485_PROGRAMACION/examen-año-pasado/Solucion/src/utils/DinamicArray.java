/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 * A clase DinamicArray implementa unha estrutura de datos que emula un array dinámico.
 * Permite almacenar obxectos e realizar operacións como engadir, obter, modificar, eliminar elementos, 
 * así como cambiar o tamaño do array de forma automática cando se engaden novos elementos.
 * 
 */
public class DinamicArray {
    // Tamaño de incremento para o array cando se sobrepasa a súa capacidade.
    private static final int CHUNK=10;

    // Número de elementos actualmente almacenados no array.
    private int number;

    // Array subxacente que almacena os obxectos.
    private Object[] array;
    
    /**
     * Construtor que inicializa o array cun tamaño inicial especificado.
     * 
     * @param initialcap Capacidade inicial do array.
     * @throws IllegalArgumentException Se o tamaño inicial é menor ou igual a 0.
     */
    public DinamicArray(int initialcap) {
        if (initialcap<=0) throw new IllegalArgumentException("O tamaño mínimo é 1");
        array=new Object[initialcap];
        number=0;
    }

    /**
     * Devólve o número de elementos actualmente no array.
     * 
     * @return O número de elementos almacenados.
     */
    public int length() {
        return number;
    }
    
    /**
     * Devólve a capacidade actual do array (tamano físico do array subxacente).
     * 
     * @return A capacidade do array.
     */
    public int size() {
        return array.length;
    }
    
    /**
     * Convierte o array actual en un array novo, copiando todos os seus elementos.
     * Se o array está vacío, retorna un array vacío.
     * 
     * @return Un novo array coas copias dos elementos actuais.
     */
    public Object[] toArray() {
        if (number==0) return new Object[0];
        Object[] data=new Object[number];
        System.arraycopy(array,0,data,0,number);
        return data;
    }
    
    /**
     * Engade os elementos dun array de obxectos ao array actual.
     * 
     * @param array O array de obxectos que se vai engadir.
     */
    public void append(Object[] array) {
        if (array!=null) {
            Object[] newarray=new Object[this.array.length+array.length];
            System.arraycopy(this.array,0,newarray,0,this.array.length);
            System.arraycopy(array,0,newarray,this.array.length,array.length);
            this.array=newarray;
        }
    }

    /**
     * Engade os elementos dun outro DinamicArray ao array actual.
     * 
     * @param da O DinamicArray que se vai engadir.
     */
    public void append(DinamicArray da) {
        if (da!=null) {
            append(da.array);
        }
    }
    
    /**
     * Engade un obxecto ao final do array. Se o array está cheo, incrementa o seu tamaño automaticamente.
     * 
     * @param obj O obxecto a engadir.
     */
    public void add(Object obj) {
        if (number==array.length) {
            Object[] newarray=new Object[array.length+CHUNK];
            System.arraycopy(array,0,newarray,0,array.length);
            array=newarray;
        }
        array[number]=obj;
        number++;
    }
    
    /**
     * Obtén o obxecto no índice especificado.
     * 
     * @param idx O índice do obxecto a obter.
     * @return O obxecto no índice especificado.
     * @throws IndexOutOfBoundsException Se o índice está fóra de rango.
     */
    public Object get(int idx) throws IndexOutOfBoundsException {
        if (idx<0 || idx>=number) throw new IndexOutOfBoundsException("Index "+idx+": Array has ["+number+"] elements");
        return array[idx];
    }
    
    /**
     * Substitúe o obxecto no índice especificado e devolve o valor antigo.
     * 
     * @param idx O índice do obxecto a modificar.
     * @param object O novo obxecto que se gardará no índice.
     * @return O obxecto antigo no índice especificado.
     * @throws IndexOutOfBoundsException Se o índice está fóra de rango.
     */
    public Object put(int idx,Object object) throws IndexOutOfBoundsException {
        if (idx<0 || idx>=number) throw new IndexOutOfBoundsException("Index "+idx+": Array has ["+number+"] elements");
        Object old=array[idx];
        array[idx]=object;
        return old;
    }
    
     /**
     * Elimina o obxecto no índice especificado e despraza os elementos seguintes.
     * 
     * @param idx O índice do obxecto a eliminar.
     * @return O obxecto eliminado.
     * @throws IndexOutOfBoundsException Se o índice está fóra de rango.
     */
    public Object remove(int idx) throws IndexOutOfBoundsException {
        if (idx<0 || idx>=number) throw new IndexOutOfBoundsException("Index "+idx+": Array has ["+number+"] elements");
        Object old=array[idx];
        System.arraycopy(array,idx+1, array, idx, number-idx);
        number--;
        for(int i=0;i<number;i++) System.out.println("--->"+array[i]);
        return old;
    }
    
    /**
     * Comproba se un obxecto dado está presente na lista.
     * Este método recorre a lista e devolve o índice do primeiro elemento que coincide co obxecto fornecido.
     * Se o obxecto non se atopa na lista, devolve null.
     *
     * @param obj O obxecto que se quere buscar na lista.
     * @return O índice do obxecto na lista se se atopa, ou null se non se atopa o obxecto.
     */
    public Integer position(Object obj) {
        for(int idx=0;idx<this.number;idx++) {
            if (obj.equals(array[idx])) return idx;
        }
        return null;
    }
}

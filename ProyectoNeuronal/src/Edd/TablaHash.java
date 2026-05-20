/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Edd;

/**
 *
 * @author ischl
 * @param <K>
 * @param <V>
 */
public class TablaHash<K, V> {
    private NodoHash<K, V>[] tabla;
    private int capacidad;
    private int size; 
    
    /** 
     * constructor. la capacidad debe ser un número primo para mejor distribución.
     * @param capacidad tamaño inicial del arreglo
     */
    public TablaHash(int capacidad){
        this.capacidad = capacidad;
        this.size = 0;
        this.tabla = new NodoHash[capacidad];
    }    
    
    /**
     * Calcula el indice del arreglo para una clave dada.
     * usa el método de división: hashCode % capacidad
     * complejidad: O(1).
     * @param clave
     * @return 
     */
    private int getIndice(K clave){
        int hash = Math.abs(clave.hashCode());
        return hash % capacidad;
    }    
    
    /**
     * Inserta un par clave-valor. Si la clave ya existe, actualiza el valor.
     * Complejidad: O(1) promedio.
     * @param clave Identificador único.
     * @param valor Objeto asociado.
     */
    public void insertar(K clave, V valor){
        int indice = getIndice(clave);
        NodoHash<K, V> actual = tabla[indice];
        
        while (actual != null){
            if (actual.getDato().getClave().equals(clave)){
                actual.getDato().setValor(valor);
                return;
            }
            actual = actual.getSiguiente();
        }
        
        ParClaveValor<K, V> par = new ParClaveValor<>(clave, valor);
        NodoHash<K, V> nuevo = new NodoHash<>(par);
        nuevo.setSiguiente(tabla[indice]);
        tabla[indice] = nuevo;
        size++;
    }
    
    /**
     * Busca un valor por su clave.
     * Complejidad: o(1) promedio.
     * @param clave Identificador a buscar.
     * @return El valor asociado, o null si no existe.
     */
    public V buscar(K clave){
        int indice = getIndice(clave);
        NodoHash<K, V> actual = tabla[indice];
        
        while (actual != null){
            if (actual.getDato().getClave().equals(clave)){
                return actual.getDato().getValor();
            }
            actual = actual.getSiguiente();           
        }
        return null;
    }
    
    /**
     * Elimina un par clave-valor.
     * Complejidad: O(1) promedio.
     * @param clave Identificador a eliminar.
     * @return true si se eliminó, false si no existía.
     */
    public boolean eliminar(K clave){
        int indice = getIndice(clave);
        NodoHash<K, V> actual = tabla[indice];
        NodoHash<K, V> anterior = null;
        
        while (actual != null){
            if (actual.getDato().getClave().equals(clave)){
                if (anterior == null){
                    tabla[indice] = actual.getSiguiente();
                } else{
                    anterior.setSiguiente(actual.getSiguiente());
                }
                size --;
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        return false;
    }
    
    /**
     * Verifica si una clave existe en la tabla.
     * Complejidad: O(1) promedio
     * @param clave
     * @return 
     */
    public boolean contiene(K clave){
        return buscar(clave) != null;
    }
    
    /**
     * @return Cantidad de elementos guardados.
     */
    public int getSize(){
        return size;
    }
    
    /**     * 
     * @return true si no hay elementos.
     */
    public boolean estaVacia(){
        return size == 0;
    }
}

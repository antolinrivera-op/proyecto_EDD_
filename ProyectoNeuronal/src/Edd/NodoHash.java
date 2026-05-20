/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Edd;

/**
 * Nodo para la lista enlazada interna de la tabla hash.
 * Cada nodo guarda un ParClaveValor y apunta al siguiente.
 * Se usa cuando dos claves caen en un mismo indice, cuando colisionan.
 * @author ischl
 * @param <K>
 * @param <V>
 */
public class NodoHash<K, V>{
    private final ParClaveValor<K, V> dato;
    private NodoHash<K, V> siguiente;
    
    public NodoHash(ParClaveValor<K, V> dato){
        this.dato = dato;
        this.siguiente = null;
    }
    
    public ParClaveValor<K, V> getDato(){
        return dato;
    }
    
    public NodoHash<K, V> getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(NodoHash<K, V> siguiente){
        this.siguiente = siguiente;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Edd;

/**
 *
 * @author chris
 */

   
public class Pila<T> {
    private Nodo<T> tope;

    public void apilar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        tope = nuevo.getSiguiente();
        tope = nuevo;
    }

    public T desapilar() {
        if (tope == null) return null;
        T dato = tope.getDato();
        tope = tope.getSiguiente();
        return dato;
    }

    public boolean estaVacia() { return tope == null; }
}

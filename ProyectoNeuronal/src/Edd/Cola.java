/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Edd;

/**
 *
 * @author chris
 */
public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;

    public void encolar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (fin != null) nuevo = fin.getSiguiente();
        fin = nuevo;
        if (frente == null) frente = nuevo;
    }

    public T desencolar() {
        if (frente == null) return null;
        T dato = frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) fin = null;
        return dato;
    }

    public boolean estaVacia() { return frente == null; }
}


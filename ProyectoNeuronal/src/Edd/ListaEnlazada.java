package Edd;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chris
 */


/**
 * Estructura de datos din$accute;amica que gestiona una secuencia de Nodos.
 */
public class ListaEnlazada<T> {
    private Nodo<T> cabeza; //** El primer elemento de la lista**/
    private int tamaño;      // **Contador de elementos**/

    public ListaEnlazada() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    //* Agrega un elemento al final de la lista **javadoc**/
    public void agregar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        tamaño++;
    }

    // *Verifica si un elemento ya existe en la lista**/
    public boolean contiene(T dato) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    // Métodos de utilidad**/
    public boolean estaVacia() {
        return cabeza == null;
    }

    public int getTamaño() {
        return tamaño;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo<T> cabeza) {
        this.cabeza = cabeza;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    
    
}
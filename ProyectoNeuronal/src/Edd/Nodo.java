package Edd;

/**
 * Nodo gen&eacute;rico para estructuras enlazadas (listas, pilas, colas).
 *
 * @param <T> Tipo de dato almacenado.
 * @author chris
 */
public class Nodo<T> {
    private T dato;
    private Nodo<T> siguiente;

    /**
     * Constructor.
     *
     * @param dato Dato a almacenar.
     */
    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    /**
     * @return El dato almacenado.
     */
    public T getDato() {
        return dato;
    }

    /**
     * Actualiza el dato.
     *
     * @param dato Nuevo valor.
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * @return El siguiente nodo.
     */
    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    /**
     * Asigna el siguiente nodo.
     *
     * @param siguiente Nodo a enlazar.
     */
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}

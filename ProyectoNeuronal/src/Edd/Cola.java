package Edd;

/**
 * Implementación de una cola (FIFO) con lista enlazada.
 * Utilizada en el algoritmo BFS.
 *
 * @param <T> Tipo de dato.
 * @author chris
 */
public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;

    /**
     * Encola un elemento al final.
     *
     * @param dato Elemento a encolar.
     */
    public void encolar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (fin != null) {
            fin.setSiguiente(nuevo);
        }
        fin = nuevo;
        if (frente == null) {
            frente = nuevo;
        }
    }

    /**
     * Desencola el elemento del frente.
     *
     * @return El elemento desencolado, o {@code null} si la cola est&aacute vac&iacute;a.
     */
    public T desencolar() {
        if (frente == null) return null;
        T dato = frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) fin = null;
        return dato;
    }

    /**
     * Verifica si la cola está vac&iacute;a.
     *
     * @return {@code true} si no hay elementos.
     */
    public boolean estaVacia() {
        return frente == null;
    }
}

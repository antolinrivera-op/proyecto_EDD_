package Edd;

/**
 * Lista enlazada gen&eacute;rica simple.
 * Permite agregar al final, verificar existencia y recorrer desde la cabeza.
 *
 * @param <T> Tipo de dato almacenado.
 * @author chris
 */
public class ListaEnlazada<T> {
    private Nodo<T> cabeza;
    private int tamaño;

    /**
     * Constructor. Crea una lista vac&iacute;a.
     */
    public ListaEnlazada() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    /**
     * Agrega un elemento al final de la lista.
     * Complejidad: O(n).
     *
     * @param dato Elemento a agregar.
     */
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

    /**
     * Verifica si un elemento está en la lista (usando equals).
     *
     * @param dato Elemento a buscar.
     * @return {@code true} si existe, {@code false} en caso contrario.
     */
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

    /**
     * @return {@code true} si la lista no tiene elementos.
     */
    public boolean estaVacia() {
        return cabeza == null;
    }

    /**
     * @return N&uacute;mero de elementos en la lista.
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * @return El primer nodo de la lista.
     */
    public Nodo<T> getCabeza() {
        return cabeza;
    }

    /**
     * Establece la cabeza de la lista (solo para uso interno de estructuras como redNeuronal).
     *
     * @param cabeza Nuevo primer nodo.
     */
    public void setCabeza(Nodo<T> cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * Establece el tamaño de la lista (solo para uso interno).
     *
     * @param tamaño Nuevo tamaño.
     */
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
}

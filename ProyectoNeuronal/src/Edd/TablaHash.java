package Edd;

/**
 * Implementación propia de una tabla hash genérica con resolución de colisiones por encadenamiento.
 * Las operaciones de inserción, búsqueda y eliminación tienen complejidad O(1) promedio.
 *
 * @param <K> Tipo de la clave.
 * @param <V> Tipo del valor.
 * @author ischl
 */
public class TablaHash<K, V> {
    private NodoHash<K, V>[] tabla;
    private int capacidad;
    private int size;

    /**
     * Constructor. La capacidad debería ser un número primo para mejorar la distribución.
     *
     * @param capacidad Tamaño inicial del arreglo.
     */
    public TablaHash(int capacidad) {
        this.capacidad = capacidad;
        this.size = 0;
        this.tabla = new NodoHash[capacidad];
    }

    /**
     * Calcula el índice a partir del código hash de la clave.
     *
     * @param clave Clave a indexar.
     * @return Índice en el rango [0, capacidad-1].
     */
    private int getIndice(K clave) {
        int hash = Math.abs(clave.hashCode());
        return hash % capacidad;
    }

    /**
     * Inserta un par clave-valor. Si la clave ya existe, actualiza el valor.
     *
     * @param clave Identificador único.
     * @param valor Objeto asociado.
     */
    public void insertar(K clave, V valor) {
        int indice = getIndice(clave);
        NodoHash<K, V> actual = tabla[indice];
        while (actual != null) {
            if (actual.getDato().getClave().equals(clave)) {
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
     * Busca un valor asociado a una clave.
     *
     * @param clave Clave a buscar.
     * @return El valor encontrado o {@code null} si no existe.
     */
    public V buscar(K clave) {
        int indice = getIndice(clave);
        NodoHash<K, V> actual = tabla[indice];
        while (actual != null) {
            if (actual.getDato().getClave().equals(clave)) {
                return actual.getDato().getValor();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    /**
     * Elimina el par clave-valor correspondiente a la clave.
     *
     * @param clave Clave a eliminar.
     * @return {@code true} si se eliminó, {@code false} si no existía.
     */
    public boolean eliminar(K clave) {
        int indice = getIndice(clave);
        NodoHash<K, V> actual = tabla[indice];
        NodoHash<K, V> anterior = null;
        while (actual != null) {
            if (actual.getDato().getClave().equals(clave)) {
                if (anterior == null) {
                    tabla[indice] = actual.getSiguiente();
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
                size--;
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        return false;
    }

    /**
     * Verifica si una clave existe en la tabla.
     *
     * @param clave Clave a consultar.
     * @return {@code true} si existe, {@code false} en caso contrario.
     */
    public boolean contiene(K clave) {
        return buscar(clave) != null;
    }

    /**
     * Retorna la cantidad de elementos almacenados.
     *
     * @return Número de pares clave-valor.
     */
    public int getSize() {
        return size;
    }

    /**
     * Indica si la tabla está vacía.
     *
     * @return {@code true} si no hay elementos.
     */
    public boolean estaVacia() {
        return size == 0;
    }
}

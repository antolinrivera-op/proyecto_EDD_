package Edd;

/**
 * Almacena un par clave-valor inmutable en la clave, mutable en el valor.
 *
 * @param <K> Tipo de la clave.
 * @param <V> Tipo del valor.
 * @author ischl
 */
public class ParClaveValor<K, V> {
    private final K clave;
    private V valor;

    /**
     * Constructor.
     *
     * @param clave Clave (no puede cambiar).
     * @param valor Valor inicial.
     */
    public ParClaveValor(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    /**
     * @return La clave.
     */
    public K getClave() {
        return clave;
    }

    /**
     * @return El valor actual.
     */
    public V getValor() {
        return valor;
    }

    /**
     * Actualiza el valor.
     *
     * @param valor Nuevo valor.
     */
    public void setValor(V valor) {
        this.valor = valor;
    }
}

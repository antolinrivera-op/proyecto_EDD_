package Clases;

import Edd.ListaEnlazada;

/**
 * Representa una neurona dentro de la red neuronal.
 * Cada neurona tiene un identificador &uacute;nico y una lista de conexiones sin&aacute;pticas salientes.
 */
public class Neurona {
    private String id;
    private final ListaEnlazada<ConexionSinaptica> conexionesSalientes;

    /**
     * Flag público utilizado por los algoritmos de recorrido (BFS/DFS) para marcar visitados.
     * No se recomienda su uso externo, pero se mantiene por compatibilidad.
     */
    public boolean visitado = false;

    /**
     * Constructor.
     *
     * @param id Identificador único de la neurona.
     */
    public Neurona(String id) {
        this.id = id;
        this.conexionesSalientes = new ListaEnlazada<>();
    }

    /**
     * @return El identificador de la neurona.
     */
    public String getId() {
        return id;
    }

    /**
     * @return La lista de conexiones sin&aacute;pticas que salen de esta neurona.
     */
    public ListaEnlazada<ConexionSinaptica> getConexionesSalientes() {
        return conexionesSalientes;
    }

    /**
     * Agrega una conexi&oacute;n sin&aacute;ptica a la lista de salientes.
     *
     * @param conexion La conexi&oacute;n a agregar (debe tener como origen esta neurona).
     */
    public void agregarConexion(ConexionSinaptica conexion) {
        this.conexionesSalientes.agregar(conexion);
    }
}

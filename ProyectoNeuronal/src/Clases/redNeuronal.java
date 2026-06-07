package clases;

import Edd.ListaEnlazada;
import Edd.Nodo;

/**
 * Representa la red neuronal completa.
 *
 * @author ischl
 */
public class redNeuronal {
    private ListaEnlazada<Neurona> todasLasNeuronas;
    private ListaEnlazada<ConexionSinaptica> todasLasConexiones;
    private DiccionarioNeurotransmisores diccionario;

    /**
     * Constructor que recibe un diccionario de neurotransmisores.
     *
     * @param dicc Diccionario ya cargado.
     */
    public redNeuronal(DiccionarioNeurotransmisores dicc) {
        this.todasLasNeuronas = new ListaEnlazada<>();
        this.todasLasConexiones = new ListaEnlazada<>();
        this.diccionario = dicc;
    }

    /**
     * Constructor por defecto que crea un diccionario con los 50 neurotransmisores.
     */
    public redNeuronal() {
        this(new DiccionarioNeurotransmisores());
    }

    /**
     * Busca una neurona por su identificador (búsqueda secuencial O(n)).
     *
     * @param id Identificador de la neurona.
     * @return La neurona encontrada o {@code null} si no existe.
     */
    public Neurona buscarNeurona(String id) {
        Nodo<Neurona> temp = todasLasNeuronas.getCabeza();
        while (temp != null) {
            if (temp.getDato().getId().equals(id)) {
                return temp.getDato();
            }
            temp = temp.getSiguiente();
        }
        return null;
    }

    /**
     * Agrega una neurona a la red si no existe ya.
     *
     * @param n Neurona a agregar.
     */
    public void agregarNeurona(Neurona n) {
        if (buscarNeurona(n.getId()) == null) {
            todasLasNeuronas.agregar(n);
        }
    }

    /**
     * Elimina una neurona y todas las conexiones que la involucran (como origen o destino).
     *
     * @param id Identificador de la neurona a eliminar.
     * @return {@code true} si se eliminó correctamente, {@code false} si no existía.
     */
    public boolean eliminarNeurona(String id) {
        Neurona aEliminar = buscarNeurona(id);
        if (aEliminar == null) return false;

        Nodo<ConexionSinaptica> actual = todasLasConexiones.getCabeza();
        Nodo<ConexionSinaptica> anterior = null;
        while (actual != null) {
            ConexionSinaptica cs = actual.getDato();
            if (cs.getOrigen() == aEliminar || cs.getDestino() == aEliminar) {
                if (anterior == null) {
                    todasLasConexiones.setCabeza(actual.getSiguiente());
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
                todasLasConexiones.setTamaño(todasLasConexiones.getTamaño() - 1);
                actual = (anterior == null) ? todasLasConexiones.getCabeza() : anterior.getSiguiente();
            } else {
                anterior = actual;
                actual = actual.getSiguiente();
            }
        }
        
        Nodo<Neurona> nActual = todasLasNeuronas.getCabeza();
        Nodo<Neurona> nAnterior = null;
        while (nActual != null) {
            if (nActual.getDato().getId().equals(id)) {
                if (nAnterior == null) {
                    todasLasNeuronas.setCabeza(nActual.getSiguiente());
                } else {
                    nAnterior.setSiguiente(nActual.getSiguiente());
                }
                todasLasNeuronas.setTamaño(todasLasNeuronas.getTamaño() - 1);
                return true;
            }
            nAnterior = nActual;
            nActual = nActual.getSiguiente();
        }
        return false;
    }

    /**
     * Agrega una conexión sináptica a la red. Actualiza la lista de salientes de la neurona origen
     * y almacena la conexión globalmente.
     *
     * @param cs Conexión a agregar.
     */
    public void agregarConexion(ConexionSinaptica cs) {
        cs.getOrigen().agregarConexion(cs);
        todasLasConexiones.agregar(cs);
    }

    /**
     * Retorna la lista de todas las conexiones de la red.
     *
     * @return Lista enlazada de {@link ConexionSinaptica}.
     */
    public ListaEnlazada<ConexionSinaptica> getTodasLasConexiones() {
        return todasLasConexiones;
    }

    /**
     * Reinicia el flag de visitado de todas las neuronas a {@code false}.
     * Se utiliza antes de ejecutar BFS o DFS.
     */
    public void reiniciarVisitados() {
        Nodo<Neurona> temp = todasLasNeuronas.getCabeza();
        while (temp != null) {
            temp.getDato().visitado = false;
            temp = temp.getSiguiente();
        }
    }

    /**
     * Obtiene la lista de todas las neuronas de la red.
     *
     * @return Lista enlazada de {@link Neurona}.
     */
    public ListaEnlazada<Neurona> getListaTodasLasNeuronas() {
        return todasLasNeuronas;
    }

    /**
     * Retorna la cantidad de neuronas actualmente en la red.
     *
     * @return Número de neuronas.
     */
    public int getCantidadNeuronas() {
        return todasLasNeuronas.getTamaño();
    }

    /**
     * Vacía completamente la red, eliminando todas las neuronas y conexiones.
     */
    public void limpiar() {
        this.todasLasNeuronas = new ListaEnlazada<>();
        this.todasLasConexiones = new ListaEnlazada<>();
    }

    /**
     * Indica si la red no contiene neuronas.
     *
     * @return {@code true} si está vacía, {@code false} en caso contrario.
     */
    public boolean estaVacia() {
        return todasLasNeuronas.estaVacia();
    }

    /**
     * Obtiene el diccionario de neurotransmisores asociado a la red.
     *
     * @return El diccionario actual.
     */
    public DiccionarioNeurotransmisores getDiccionario() {
        return diccionario;
    }

    /**
     * Reemplaza el diccionario de neurotransmisores de la red.
     *
     * @param diccionario Nuevo diccionario.
     */
    public void setDiccionario(DiccionarioNeurotransmisores diccionario) {
        this.diccionario = diccionario;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import Edd.ListaEnlazada;
import Edd.Nodo;
import BfsDfs.BFS;
import BfsDfs.DFS;

/**
 * Clase encargada de analizar la conectividad de la red neuronal.
 * Proporciona métodos para detectar zonas aisladas, obtener componentes alcanzables
 * y determinar si el grafo es fuertemente conexo.
 * 
 * @author ischl
 */
public class AnalizadorConectividad {

    private BFS bfs;
    private DFS dfs;

    /**
     * Constructor. Inicializa los algoritmos de búsqueda.
     */
    public AnalizadorConectividad() {
        this.bfs = new BFS();
        this.dfs = new DFS();
    }

    /**
     * Obtiene las neuronas alcanzables desde una fuente usando BFS.
     *
     * @param red  Red neuronal.
     * @param idFuente Identificador de la neurona de inicio.
     * @return Lista enlazada con las neuronas alcanzables (incluye la fuente).
     */
    public ListaEnlazada<Neurona> obtenerAlcanzablesBFS(redNeuronal red, String idFuente) {
        return bfs.BFS(red, idFuente);
    }

    /**
     * Obtiene las neuronas alcanzables desde una fuente usando DFS.
     *
     * @param red  Red neuronal.
     * @param idFuente Identificador de la neurona de inicio.
     * @return Lista enlazada con las neuronas alcanzables (incluye la fuente).
     */
    public ListaEnlazada<Neurona> obtenerAlcanzablesDFS(redNeuronal red, String idFuente) {
        return dfs.DFS(red, idFuente);
    }

    /**
     * Determina las zonas aisladas (neuronas no alcanzables) desde una neurona fuente.
     *
     * @param red        Red neuronal.
     * @param idFuente   Identificador de la neurona fuente.
     * @return Lista enlazada con las neuronas que NO son alcanzables desde la fuente.
     */
    public ListaEnlazada<Neurona> obtenerZonasAisladas(redNeuronal red, String idFuente) {
        ListaEnlazada<Neurona> alcanzables = obtenerAlcanzablesBFS(red, idFuente);
        ListaEnlazada<Neurona> aisladas = new ListaEnlazada<>();
        Nodo<Neurona> todas = red.getListaTodasLasNeuronas().getCabeza();
        while (todas != null) {
            Neurona n = todas.getDato();
            if (!contiene(alcanzables, n)) {
                aisladas.agregar(n);
            }
            todas = todas.getSiguiente();
        }
        return aisladas;
    }

    /**
     * Verifica si la red neuronal es fuertemente conexa.
     * Es decir, desde cualquier neurona se puede alcanzar cualquier otra.
     * Para ello, ejecuta BFS desde cada nodo y comprueba que se alcancen todos.
     * Complejidad: O(n * (n + m)) donde n = número de neuronas, m = número de conexiones.
     *
     * @param red Red neuronal.
     * @return {@code true} si es fuertemente conexa, {@code false} en caso contrario.
     */
    public boolean esFuertementeConexo(redNeuronal red) {
        ListaEnlazada<Neurona> todas = red.getListaTodasLasNeuronas();
        if (todas.estaVacia()) {
            return false;
        }

        ListaEnlazada<Neurona> listaCompleta = new ListaEnlazada<>();
        Nodo<Neurona> temp = todas.getCabeza();
        while (temp != null) {
            listaCompleta.agregar(temp.getDato());
            temp = temp.getSiguiente();
        }
        int totalNeuronas = listaCompleta.getTamaño();


        Nodo<Neurona> actual = todas.getCabeza();
        while (actual != null) {
            String idFuente = actual.getDato().getId();
            ListaEnlazada<Neurona> alcanzables = bfs.BFS(red, idFuente);
            if (alcanzables.getTamaño() != totalNeuronas) {
                return false;
            }
            actual = actual.getSiguiente();
        }
        return true;
    }

    /**
     * Método auxiliar para verificar si una lista contiene una neurona (por ID, no por referencia).
     *
     * @param lista Lista de neuronas.
     * @param n     Neurona a buscar.
     * @return {@code true} si existe, {@code false} en caso contrario.
     */
    private boolean contiene(ListaEnlazada<Neurona> lista, Neurona n) {
        Nodo<Neurona> actual = lista.getCabeza();
        while (actual != null) {
            if (actual.getDato().getId().equals(n.getId())) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
}
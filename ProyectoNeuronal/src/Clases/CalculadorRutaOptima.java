/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Edd.ListaEnlazada;
import Edd.Nodo;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementa el algoritmo de Dijkstra para encontrar la ruta de menor tiempo
 * de transmisión entre dos neuronas en un grafo dirigido.
 * El peso de cada arista se calcula mediante {@link ConexionSinaptica#getTiempoTransmision(double)},
 * utilizando la velocidad del neurotransmisor obtenida del diccionario.
 * 
 * @author ischl
 */
public class CalculadorRutaOptima {

    /**
     * Calcula la ruta más rápida (menor tiempo) entre dos neuronas.
     *
     * @param red        Red neuronal que contiene todas las neuronas y conexiones.
     * @param idOrigen   Identificador de la neurona de inicio.
     * @param idDestino  Identificador de la neurona de destino.
     * @return Lista enlazada con las neuronas en orden (desde origen hasta destino),
     *         o {@code null} si no existe ruta o alguna de las neuronas no se encuentra.
     */
    public ListaEnlazada<Neurona> calcularRuta(redNeuronal red, String idOrigen, String idDestino) {
        Neurona origen = red.buscarNeurona(idOrigen);
        Neurona destino = red.buscarNeurona(idDestino);
        if (origen == null || destino == null) {
            return null;
        }


        Map<Neurona, Double> distancia = new HashMap<>();
        Map<Neurona, Neurona> anterior = new HashMap<>();
        ListaEnlazada<Neurona> noVisitados = new ListaEnlazada<>();


        Nodo<Neurona> nodoNeurona = red.getListaTodasLasNeuronas().getCabeza();
        while (nodoNeurona != null) {
            Neurona n = nodoNeurona.getDato();
            distancia.put(n, Double.MAX_VALUE);
            anterior.put(n, null);
            noVisitados.agregar(n);
            nodoNeurona = nodoNeurona.getSiguiente();
        }
        distancia.put(origen, 0.0);

        while (!noVisitados.estaVacia()) {

            Neurona actual = null;
            double minDist = Double.MAX_VALUE;
            Nodo<Neurona> temp = noVisitados.getCabeza();
            while (temp != null) {
                Neurona n = temp.getDato();
                double d = distancia.get(n);
                if (d < minDist) {
                    minDist = d;
                    actual = n;
                }
                temp = temp.getSiguiente();
            }

            if (actual == null || actual == destino) {
                break; 
            }


            noVisitados = eliminarNodo(noVisitados, actual);


            Nodo<ConexionSinaptica> arista = actual.getConexionesSalientes().getCabeza();
            while (arista != null) {
                ConexionSinaptica cs = arista.getDato();
                Neurona vecino = cs.getDestino();
                if (contiene(noVisitados, vecino)) {

                    Neurotransmisor nt = red.getDiccionario().buscar(cs.getIdNeurotransmisor());
                    double velocidad = (nt != null) ? nt.getVelocidad() : 1.0;
                    double peso = cs.getTiempoTransmision(velocidad);
                    double nuevaDist = distancia.get(actual) + peso;
                    if (nuevaDist < distancia.get(vecino)) {
                        distancia.put(vecino, nuevaDist);
                        anterior.put(vecino, actual);
                    }
                }
                arista = arista.getSiguiente();
            }
        }


        if (distancia.get(destino) == Double.MAX_VALUE) {
            return null;
        }
        ListaEnlazada<Neurona> rutaInversa = new ListaEnlazada<>();
        Neurona paso = destino;
        while (paso != null) {
            rutaInversa.agregar(paso);
            paso = anterior.get(paso);
        }

        return invertirLista(rutaInversa);
    }

    /**
     * Elimina un nodo específico de una lista enlazada y devuelve la nueva lista.
     * @param lista Lista original.
     * @param n Nodo a eliminar.
     * @return Nueva lista sin el nodo.
     */
    private ListaEnlazada<Neurona> eliminarNodo(ListaEnlazada<Neurona> lista, Neurona n) {
        ListaEnlazada<Neurona> nueva = new ListaEnlazada<>();
        Nodo<Neurona> actual = lista.getCabeza();
        while (actual != null) {
            if (actual.getDato() != n) {
                nueva.agregar(actual.getDato());
            }
            actual = actual.getSiguiente();
        }
        return nueva;
    }

    /**
     * Verifica si una neurona está contenida en una lista enlazada (comparación por referencia).
     * @param lista Lista de neuronas.
     * @param n Neurona a buscar.
     * @return true si existe.
     */
    private boolean contiene(ListaEnlazada<Neurona> lista, Neurona n) {
        Nodo<Neurona> actual = lista.getCabeza();
        while (actual != null) {
            if (actual.getDato() == n) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    /**
     * Invierte una lista enlazada.
     * @param lista Lista original.
     * @return Lista invertida.
     */
    private ListaEnlazada<Neurona> invertirLista(ListaEnlazada<Neurona> lista) {
        ListaEnlazada<Neurona> invertida = new ListaEnlazada<>();
        Nodo<Neurona> actual = lista.getCabeza();
        // Recorremos la original y vamos agregando al inicio de la nueva
        while (actual != null) {
            Neurona n = actual.getDato();
            // Insertar al principio: crear una nueva lista temporal
            ListaEnlazada<Neurona> temp = new ListaEnlazada<>();
            temp.agregar(n);
            Nodo<Neurona> resto = invertida.getCabeza();
            while (resto != null) {
                temp.agregar(resto.getDato());
                resto = resto.getSiguiente();
            }
            invertida = temp;
            actual = actual.getSiguiente();
        }
        return invertida;
    }
}
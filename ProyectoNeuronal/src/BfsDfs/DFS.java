/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BfsDfs;

import Clases.ConexionSinaptica;
import Clases.Neurona;
import Clases.redNeuronal;
import Edd.ListaEnlazada;
import Edd.Nodo;
import Edd.Pila;

/**
 *
 * @author chris
 */
public class DFS {
    public ListaEnlazada<Neurona> DFS(redNeuronal red, String idInicio) {
        ListaEnlazada<Neurona> visitados = new ListaEnlazada<>();
        Neurona inicio = red.buscarNeurona(idInicio);
        
        if (inicio == null) return visitados;

        Pila<Neurona> pila = new Pila<>();
        pila.apilar(inicio);

        while (!pila.estaVacia()) {
            Neurona actual = pila.desapilar();

            if (!visitados.contiene(actual)) {
                visitados.agregar(actual);
                
                Nodo<ConexionSinaptica> temp = actual.getConexionesSalientes().getCabeza();
                while (temp != null) {
                    Neurona vecino = temp.getDato().getDestino();
                    if (!visitados.contiene(vecino)) {
                        pila.apilar(vecino);
                    }
                    temp = temp.getSiguiente();
                }
            }
        }
        return visitados;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BfsDfs;

import Clases.ConexionSinaptica;
import Clases.Neurona;
import Clases.redNeuronal;
import Edd.ListaEnlazada;
import Edd.Cola;
import Edd.Nodo;

/**
 *
 * @author chris
 */
public class BFS {
    public ListaEnlazada<Neurona> BFS(redNeuronal red, String idInicio) {
        ListaEnlazada<Neurona> visitados = new ListaEnlazada<>();
        Neurona inicio = red.buscarNeurona(idInicio);
        
        if (inicio == null) return visitados;

        Cola<Neurona> cola = new Cola<>();
        cola.encolar(inicio);
        visitados.agregar(inicio);

        while (!cola.estaVacia()) {
            Neurona actual = cola.desencolar();

            //** se usa la lista de conexiones de la neurona**/ 
            Nodo<ConexionSinaptica> temp = actual.getConexionesSalientes().getCabeza();
            while (temp != null) {
                Neurona vecino = temp.getDato().getDestino();
                if (!visitados.contiene(vecino)) {
                    visitados.agregar(vecino);
                    cola.encolar(vecino);
                }
                temp = temp.getSiguiente();
            }
        }
        return visitados;
    }
    
    
}

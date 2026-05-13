/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Edd.ListaEnlazada;
import Edd.Nodo;

/**
 *
 * @author chris
 */
public class redNeuronal {
    // Lista de todas las neuronas que existen en el cerebro**/
    private ListaEnlazada<Neurona> todasLasNeuronas;

    public redNeuronal() {
        this.todasLasNeuronas = new ListaEnlazada<>();
    }

    // metodo para utilizar el BFS yDFS**/
    public Neurona buscarNeurona(String id) {
        Nodo<Neurona> temp = todasLasNeuronas.getCabeza();
        while (temp != null) {
            if (temp.getDato().getId().equals(id)) {
                return temp.getDato();
            }
            temp = temp.getSiguiente();
        }
        return null; //** Si no la encuentra**/
    }

    public void agregarNeurona(Neurona n) {
        this.todasLasNeuronas.agregar(n);
    }
    
    public ListaEnlazada<Neurona> getListaTodasLasNeuronas() {
        return todasLasNeuronas;
    }
}


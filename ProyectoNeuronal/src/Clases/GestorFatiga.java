/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Edd.Nodo;
        
/**
 *
 * @author ischl
 */
public class GestorFatiga {

    /**
     * Aplica fatiga a toda la red neuronal: cada conexión ve su coeficiente k multiplicado por 1.2.
     *
     * @param red Red neuronal cuyas conexiones se modificarán.
     */
    public void aplicarFatiga(redNeuronal red) {
        Nodo<ConexionSinaptica> actual = red.getTodasLasConexiones().getCabeza();
        while (actual != null) {
            double nuevoK = actual.getDato().getCoeficienteEficiencia() * 1.2;
            actual.getDato().setCoeficienteEficiencia(nuevoK);
            actual = actual.getSiguiente();
        }
    }
}


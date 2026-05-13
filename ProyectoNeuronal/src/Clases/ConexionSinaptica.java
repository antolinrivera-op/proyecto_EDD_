/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author chris
 */
public class ConexionSinaptica {
    private Neurona origen;
    private Neurona destino;
    private double distancia;

    public ConexionSinaptica(Neurona origen, Neurona destino, double distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }

    public Neurona getDestino() {
        return destino;
    }

    public Neurona getOrigen() {
        return origen;
    }

    public void setOrigen(Neurona origen) {
        this.origen = origen;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
    
}


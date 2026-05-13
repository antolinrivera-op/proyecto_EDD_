/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Edd.ListaEnlazada;

/**
 *
 * @author chris
 */
public class Neurona {
    private String id;
   
    private ListaEnlazada<ConexionSinaptica> conexionesSalientes;

    public Neurona(String id) {
        this.id = id;
        this.conexionesSalientes = new ListaEnlazada<>();
    }

    public String getId() {
        return id;
    }

    public ListaEnlazada<ConexionSinaptica> getConexionesSalientes() {
        return conexionesSalientes;
    }
    
    // Método para agregar una conexión a esta neurona *pasar a javadoc*
    public void agregarConexion(ConexionSinaptica conexion) {
        this.conexionesSalientes.agregar(conexion);
    }
    
    
    
}

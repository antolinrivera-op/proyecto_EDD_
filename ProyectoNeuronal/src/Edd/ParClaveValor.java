/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Edd;

/**
 * Almacena un par clave-valor para la tabla hash.
 * Clave: identifica el elemento.
 * Valor: el objeto asociado. 2.
 * @author ischl
 * @param <K> tipo de la clave
 * @param <V> tipo del valor
 */
public class ParClaveValor<K, V> {
    private final K clave;
    private V valor;
    
    public ParClaveValor(K clave, V valor){
        this.clave = clave;
        this.valor = valor;  
    }
    
    public K getClave() {
        return clave;
    }
    
    public V getValor() {
        return valor;
    }
    
    public void setValor(V valor){
        this.valor = valor;
    }
    
}

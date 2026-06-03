package clases;

/**
 * Representa una conexión sináptica entre dos neuronas.
 * Contiene la información necesaria para calcular el tiempo de transmisión
 * según la fórmula: tiempo = distancia / (velocidad * k).
 * 
 * <p>Atributos según requerimiento A del proyecto:
 * ID_Neurona_Origen, ID_Neurona_Destino, distancia_sináptica,
 * ID_Neurotransmisor, coeficiente_eficiencia_sináptica.</p>
 */
public class ConexionSinaptica {
    private Neurona origen;
    private Neurona destino;
    private double distancia;
    private String idNeurotransmisor;      
    private double coeficienteEficiencia;  

    /**
     * Constructor completo usado por CargadorArchivo.
     * 
     * @param origen                Neurona presináptica.
     * @param destino               Neurona postsináptica.
     * @param distancia             Distancia sináptica (0.0 a 1.0).
     * @param idNeurotransmisor     ID del neurotransmisor 
     * @param coeficienteEficiencia Factor k inicial (valor entre 0 y 1).
     */
    public ConexionSinaptica(Neurona origen, Neurona destino, double distancia,
                              String idNeurotransmisor, double coeficienteEficiencia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.idNeurotransmisor = idNeurotransmisor;
        this.coeficienteEficiencia = coeficienteEficiencia;
    }


    /**
     * @return La neurona de destino de la sinapsis.
     */
    public Neurona getDestino() {
        return destino;
    }

    /**
     * @return La neurona de origen de la sinapsis.
     */
    public Neurona getOrigen() {
        return origen;
    }

    /**
     * @return La distancia sináptica.
     */
    public double getDistancia() {
        return distancia;
    }


    /**
     * @return El código del neurotransmisor asociado a esta conexión.
     */
    public String getIdNeurotransmisor() {
        return idNeurotransmisor;
    }

    /**
     * @return El coeficiente de eficiencia sináptica actual (k).
     */
    public double getCoeficienteEficiencia() {
        return coeficienteEficiencia;
    }

    /**
     * Actualiza el coeficiente de eficiencia sináptica.
     * Usado por GestorFatiga para multiplicar k por 1.2.
     * 
     * @param k El nuevo valor del coeficiente.
     */
    public void setCoeficienteEficiencia(double k) {
        this.coeficienteEficiencia = k;
    }

    /**
     * Calcula el tiempo de transmisión del impulso nervioso según la fórmula:
     * tiempo = distancia / (velocidad * k)
     * 
     * @param velocidadNeurotransmisor La velocidad (v) obtenida de la Hash Table.
     * @return El tiempo de transmisión. Si la velocidad es 0, retorna Double.MAX_VALUE.
     */
    public double getTiempoTransmision(double velocidadNeurotransmisor) {
        if (velocidadNeurotransmisor == 0) {
            return Double.MAX_VALUE;
        }
        return distancia / (velocidadNeurotransmisor * coeficienteEficiencia);
    }
}

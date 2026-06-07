package clases;

/**
 * Representa una conexión sináptica dirigida entre dos neuronas.
 * Contiene la información necesaria para calcular el tiempo de transmisión
 * según la fórmula: tiempo = distancia / (velocidad * k).
 *
 * @author ischl
 */
public class ConexionSinaptica {
    private Neurona origen;
    private Neurona destino;
    private double distancia;
    private String idNeurotransmisor;
    private double coeficienteEficiencia;  // k

    /**
     * Constructor completo.
     *
     * @param origen Neurona presináptica.
     * @param destino Neurona postsináptica.
     * @param distancia Distancia sináptica (generalmente entre 0 y 1).
     * @param idNeurotransmisor Identificador del neurotransmisor.
     * @param coeficienteEficiencia Factor k (valor entre 0 y 1).
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
     * @return La neurona destino.
     */
    public Neurona getDestino() {
        return destino;
    }

    /**
     * @return La neurona origen.
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
     * @return El código del neurotransmisor.
     */
    public String getIdNeurotransmisor() {
        return idNeurotransmisor;
    }

    /**
     * @return El coeficiente de eficiencia actual (k).
     */
    public double getCoeficienteEficiencia() {
        return coeficienteEficiencia;
    }

    /**
     * Actualiza el coeficiente de eficiencia (usado por fatiga).
     *
     * @param k Nuevo valor de k.
     */
    public void setCoeficienteEficiencia(double k) {
        this.coeficienteEficiencia = k;
    }

    /**
     * Calcula el tiempo de transmisión según la fórmula:
     * tiempo = distancia / (velocidad * k)
     *
     * @param velocidadNeurotransmisor Velocidad (v) obtenida del diccionario.
     * @return Tiempo de transmisión. Si la velocidad es 0, retorna {@code Double.MAX_VALUE}.
     */
    public double getTiempoTransmision(double velocidadNeurotransmisor) {
        if (velocidadNeurotransmisor == 0) {
            return Double.MAX_VALUE;
        }
        return distancia / (velocidadNeurotransmisor * coeficienteEficiencia);
    }
}

package clases;

/**
 * Representa un neurotransmisor con sus propiedades químicas.
 * Sus atributos son inmutables una vez creado.
 *
 * @author ischl
 */
public class Neurotransmisor {
    private final String id;
    private final String nombre;
    private final String efecto;
    private final double velocidad;
    private final String descripcion;

    /**
     * Constructor.
     *
     * @param id          Código único.
     * @param nombre      Nombre completo.
     * @param efecto      Tipo de efecto.
     * @param velocidad   Factor de velocidad (v) para la fórmula del tiempo.
     * @param descripcion Descripción breve.
     */
    public Neurotransmisor(String id, String nombre, String efecto, double velocidad, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.efecto = efecto;
        this.velocidad = velocidad;
        this.descripcion = descripcion;
    }

    /**
     * @return ID del neurotransmisor.
     */
    public String getId() {
        return id;
    }

    /**
     * @return Nombre completo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return Efecto.
     */
    public String getEfecto() {
        return efecto;
    }

    /**
     * @return Velocidad de transmisión.
     */
    public double getVelocidad() {
        return velocidad;
    }

    /**
     * @return Descripción.
     */
    public String getDescripcion() {
        return descripcion;
    }
}

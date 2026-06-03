package clases;

import Edd.TablaHash;

/**
 * Diccionario de neurotransmisores basado en una Tabla Hash propia.
 * Contiene los 50 neurotransmisores del dataset oficial del proyecto.
 * Permite guardar y consultar neurotransmisores por su ID en tiempo O(1) promedio.
 * <p>Cumple el requerimiento D del proyecto: inserción y búsqueda O(1).</p>
 *
 * @author ischl
 */
public class DiccionarioNeurotransmisores {

    private TablaHash<String, Neurotransmisor> tabla;

    /**
     * Constructor. Crea la tabla hash y carga automáticamente
     * los 50 neurotransmisores del dataset del proyecto.
     */
    public DiccionarioNeurotransmisores() {
        this.tabla = new TablaHash<>(53);
        cargarDiccionarioPorDefecto();
    }

    /**
     * Carga los 50 neurotransmisores del proyecto.
     */
    private void cargarDiccionarioPorDefecto() {
        insertar(new Neurotransmisor("GLU", "Glutamato", "Excitatorio", 2.5, "Principal mediador de información sensorial y motora."));
        insertar(new Neurotransmisor("GABA", "Ácido Gamma-aminobutírico", "Inhibitorio", 1.2, "Reduce la actividad neuronal; control del estrés."));
        insertar(new Neurotransmisor("ACH", "Acetilcolina", "Excitatorio", 2.0, "Fundamental para la memoria y activación muscular."));
        insertar(new Neurotransmisor("DA", "Dopamina", "Modulador", 1.5, "Regula el placer, recompensa y la motivación."));
        insertar(new Neurotransmisor("5HT", "Serotonina", "Modulador", 1.0, "Influye en el estado de ánimo y ciclo del sueño."));
        insertar(new Neurotransmisor("NE", "Norepinefrina", "Excitatorio", 1.8, "Relacionado con la atención y respuesta de alerta."));
        insertar(new Neurotransmisor("GLY", "Glicina", "Inhibitorio", 1.1, "Principal inhibidor en la médula espinal."));
        insertar(new Neurotransmisor("HIS", "Histamina", "Excitatorio", 1.4, "Regula el despertar y la atención."));
        insertar(new Neurotransmisor("ASP", "Aspartato", "Excitatorio", 2.3, "Estimulante cerebral similar al glutamato."));
        insertar(new Neurotransmisor("EPI", "Epinefrina", "Excitatorio", 2.0, "Respuesta de estrés agudo (adrenalina)."));
        insertar(new Neurotransmisor("OX", "Oxitocina", "Modulador", 0.8, "Vinculación social y confianza."));
        insertar(new Neurotransmisor("VAS", "Vasopresina", "Modulador", 0.9, "Regula la homeostasis y el comportamiento social."));
        insertar(new Neurotransmisor("SUBP", "Sustancia P", "Excitatorio", 0.7, "Transmisión de señales de dolor."));
        insertar(new Neurotransmisor("MET", "Met-encefalina", "Inhibitorio", 0.6, "Opioide endógeno que reduce el dolor."));
        insertar(new Neurotransmisor("LEU", "Leu-encefalina", "Inhibitorio", 0.6, "Regulación de la respuesta al dolor."));
        insertar(new Neurotransmisor("B-END", "Beta-endorfina", "Inhibitorio", 0.5, "Produce euforia y analgesia natural."));
        insertar(new Neurotransmisor("SOM", "Somatostatina", "Modulador", 0.7, "Inhibe la secreción de hormonas y modula neuronas."));
        insertar(new Neurotransmisor("CCK", "Colecistoquinina", "Modulador", 0.9, "Relacionado con la saciedad y ansiedad."));
        insertar(new Neurotransmisor("NPY", "Neuropéptido Y", "Modulador", 1.0, "Estimula el apetito y reduce la ansiedad."));
        insertar(new Neurotransmisor("GAL", "Galanina", "Modulador", 0.8, "Implicado en el aprendizaje y el sueño."));
        insertar(new Neurotransmisor("VIP", "Péptido Vasoactivo Int.", "Modulador", 1.1, "Regula ritmos circadianos."));
        insertar(new Neurotransmisor("TRH", "Hormona Liberadora Tir.", "Excitatorio", 1.3, "Estimula el metabolismo neuronal."));
        insertar(new Neurotransmisor("CRH", "Hormona Lib. Cortico.", "Excitatorio", 1.2, "Coordinador central de la respuesta al estrés."));
        insertar(new Neurotransmisor("GNRH", "Hormona Lib. Gonado.", "Modulador", 0.7, "Regulación del comportamiento reproductivo."));
        insertar(new Neurotransmisor("ADEN", "Adenosina", "Inhibitorio", 0.4, "Induce el sueño y suprime el despertar."));
        insertar(new Neurotransmisor("ATP", "Adenosín trifosfato", "Excitatorio", 2.2, "Co-transmisor en sinapsis rápidas."));
        insertar(new Neurotransmisor("NO", "Óxido Nítrico", "Modulador", 3.0, "Gas que difunde libremente (retroalimentación)."));
        insertar(new Neurotransmisor("CO", "Monóxido de Carbono", "Modulador", 2.8, "Mensajero gaseoso de larga distancia."));
        insertar(new Neurotransmisor("AEA", "Anandamida", "Modulador", 0.6, "Cannabinoide endógeno; regula el apetito y ánimo."));
        insertar(new Neurotransmisor("2-AG", "2-araquidonoilglicerol", "Modulador", 0.6, "Principal cannabinoide del sistema nervioso."));
        insertar(new Neurotransmisor("MEL", "Melatonina", "Inhibitorio", 0.5, "Regula el ciclo circadiano sueño-vigilia."));
        insertar(new Neurotransmisor("ANGII", "Angiotensina II", "Excitatorio", 1.5, "Estimula la sed y la presión arterial."));
        insertar(new Neurotransmisor("BOMB", "Bombesina", "Modulador", 0.9, "Regula la termorregulación."));
        insertar(new Neurotransmisor("D-SER", "D-Serina", "Excitatorio", 2.1, "Co-agonista del receptor NMDA."));
        insertar(new Neurotransmisor("TAUR", "Taurina", "Inhibitorio", 1.3, "Protege contra la excitotoxicidad."));
        insertar(new Neurotransmisor("AGRP", "Proteína Agouti", "Modulador", 0.7, "Aumenta la ingesta de alimentos."));
        insertar(new Neurotransmisor("CART", "Transcrito Reg. Cocaina", "Modulador", 1.1, "Suprime el apetito y modula el estrés."));
        insertar(new Neurotransmisor("DYN", "Dinorfina", "Inhibitorio", 0.5, "Opioide relacionado con el estrés negativo."));
        insertar(new Neurotransmisor("NOS", "Nociceptina", "Inhibitorio", 0.6, "Antagonista de la analgesia."));
        insertar(new Neurotransmisor("NPW", "Neuropéptido W", "Modulador", 0.8, "Regula el eje del estrés y la energía."));
        insertar(new Neurotransmisor("NPS", "Neuropéptido S", "Excitatorio", 1.6, "Aumenta el estado de alerta y reduce el miedo."));
        insertar(new Neurotransmisor("QRFP", "Piroglutamil RF-amida", "Modulador", 0.9, "Implicado en la conducta alimentaria."));
        insertar(new Neurotransmisor("OREX", "Orexina (Hipocretina)", "Excitatorio", 1.9, "Mantiene el estado de vigilia."));
        insertar(new Neurotransmisor("MCH", "Hormona Conc. Melanina", "Modulador", 0.7, "Regula el sueño REM y el balance energético."));
        insertar(new Neurotransmisor("GHRH", "Hormona Lib. Somat.", "Modulador", 0.9, "Relacionado con el crecimiento y reparación celular."));
        insertar(new Neurotransmisor("PRRP", "Péptido Lib. Prolactina", "Modulador", 0.8, "Respuesta al estrés y balance de fluidos."));
        insertar(new Neurotransmisor("PACAP", "Péptido Act. Adenilato", "Excitatorio", 1.4, "Neuroprotector y modulador sináptico."));
        insertar(new Neurotransmisor("NKA", "Neuroquinina A", "Excitatorio", 1.2, "Mediador de la inflamación neurogénica."));
        insertar(new Neurotransmisor("NKB", "Neuroquinina B", "Modulador", 1.1, "Regulación de la función reproductiva."));
        insertar(new Neurotransmisor("MOT", "Motilina", "Modulador", 0.8, "Comunicación intestino-cerebro."));
    }



    /**
     * Inserta un neurotransmisor en el diccionario.
     * Si ya existe uno con el mismo ID, se sobrescribe.
     * Complejidad: O(1) promedio.
     *
     * @param nt El neurotransmisor a guardar.
     */
    public void insertar(Neurotransmisor nt) {
        tabla.insertar(nt.getId(), nt);
    }

    /**
     * Busca un neurotransmisor por su ID.
     * Complejidad: O(1) promedio.
     *
     * @param id El código del neurotransmisor (ej. "GLU", "GABA").
     * @return El neurotransmisor encontrado, o null si no existe.
     */
    public Neurotransmisor buscar(String id) {
        return tabla.buscar(id);
    }

    /**
     * Verifica si un neurotransmisor existe en el diccionario.
     * Complejidad: O(1) promedio.
     *
     * @param id El código a verificar.
     * @return true si existe, false en caso contrario.
     */
    public boolean contiene(String id) {
        return tabla.contiene(id);
    }

    /**
     * Elimina un neurotransmisor del diccionario.
     * Complejidad: O(1) promedio.
     *
     * @param id El código del neurotransmisor a eliminar.
     * @return true si se eliminó, false si no existía.
     */
    public boolean eliminar(String id) {
        return tabla.eliminar(id);
    }

    /**
     * Reemplaza el diccionario actual por uno nuevo vacío.
     * Útil cuando el usuario carga un archivo de diccionario distinto.
     * Complejidad: O(1).
     */
    public void vaciar() {
        this.tabla = new TablaHash<>(53);
    }

    /**
     * @return Cantidad de neurotransmisores almacenados.
     */
    public int getCantidad() {
        return tabla.getSize();
    }

    /**
     * @return true si el diccionario está vacío.
     */
    public boolean estaVacio() {
        return tabla.estaVacia();
    }
}

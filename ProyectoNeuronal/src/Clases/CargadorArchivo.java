package clases;

import javax.swing.*;
import java.io.*;
import Edd.Nodo;

/**
 * Clase encargada de las operaciones de entrada/salida de archivos CSV.
 * Permite cargar la red neuronal y el diccionario de neurotransmisores,
 * así como guardar la red modificada.
 * Utiliza JFileChooser y muestra alertas con JOptionPane.
 *
 */
public class CargadorArchivo {

    /**
     * Carga una red neuronal desde un archivo CSV seleccionado por el usuario.
     * Formato: origen, destino, distancia, ID_Neurotransmisor, coheficiente_eficiencia_sináptica.
     * Si ya hay datos, pregunta si sobrescribir.
     *
     * @param red  Red neuronal donde se almacenarán los datos.
     * @param dicc Diccionario de neurotransmisores (para validar).
     */
    public void cargarRedNeuronal(redNeuronal red, DiccionarioNeurotransmisores dicc) {
        if (!red.estaVacia()) {
            int opcion = JOptionPane.showConfirmDialog(null,
                    "Hay una red cargada en memoria. ¿Desea sobrescribirla? (Los cambios no guardados se perderán)",
                    "Red existente",
                    JOptionPane.YES_NO_OPTION);
            if (opcion != JOptionPane.YES_OPTION) {
                return;
            }
            red.limpiar();
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar archivo de red neuronal");
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion != JFileChooser.APPROVE_OPTION) return;

        File archivo = fileChooser.getSelectedFile();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine(); 
            int conexionesCargadas = 0;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length < 5) continue;

                String idOrigen = datos[0].trim();
                String idDestino = datos[1].trim();
                double distancia = Double.parseDouble(datos[2].trim());
                String idNeurotransmisor = datos[3].trim();
                double k = Double.parseDouble(datos[4].trim());

                if (!dicc.contiene(idNeurotransmisor)) {
                    JOptionPane.showMessageDialog(null,
                        "Neurotransmisor desconocido: " + idNeurotransmisor + ". Se omitirá la conexión.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                    continue;
                }

                Neurona origen = obtenerOCrearNeurona(red, idOrigen);
                Neurona destino = obtenerOCrearNeurona(red, idDestino);
                ConexionSinaptica conexion = new ConexionSinaptica(origen, destino, distancia, idNeurotransmisor, k);
                red.agregarConexion(conexion);
                conexionesCargadas++;
            }

            JOptionPane.showMessageDialog(null,
                    "Red cargada exitosamente.\nNeuronas: " + red.getCantidadNeuronas() +
                    "\nConexiones: " + conexionesCargadas);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo:\n" + e.getMessage(),
                    "Error de carga", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El archivo contiene valores numéricos no válidos.",
                    "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Carga un diccionario de neurotransmisores desde un archivo CSV.
     * Formato: id, nombre, efecto, velocidad, descripcion.
     *
     * @param dicc Diccionario a actualizar.
     */
    public void cargarDiccionario(DiccionarioNeurotransmisores dicc) {
        if (!dicc.estaVacio()) {
            int opcion = JOptionPane.showConfirmDialog(null,
                    "Ya hay un diccionario cargado. ¿Desea reemplazarlo?",
                    "Diccionario existente",
                    JOptionPane.YES_NO_OPTION);
            if (opcion != JOptionPane.YES_OPTION) return;
            dicc.vaciar();
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar archivo de diccionario de neurotransmisores");
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion != JFileChooser.APPROVE_OPTION) return;

        File archivo = fileChooser.getSelectedFile();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine(); 
            int cargados = 0;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",", 5);
                if (datos.length < 5) continue;
                String id = datos[0].trim();
                String nombre = datos[1].trim();
                String efecto = datos[2].trim();
                double velocidad = Double.parseDouble(datos[3].trim());
                String descripcion = datos[4].trim().replace("\"", "");
                Neurotransmisor nt = new Neurotransmisor(id, nombre, efecto, velocidad, descripcion);
                dicc.insertar(nt);
                cargados++;
            }
            JOptionPane.showMessageDialog(null, "Diccionario cargado exitosamente.\nNeurotransmisores: " + cargados);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el diccionario:\n" + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Velocidad no válida en el diccionario.",
                    "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Guarda la red neuronal actual en un archivo CSV.
     * Formato de salida idéntico al de entrada.
     *
     * @param red Red neuronal a guardar.
     */
    public void guardarRedNeuronal(redNeuronal red) {
        if (red.estaVacia() || red.getTodasLasConexiones().estaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay datos para guardar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar red neuronal como...");
        fileChooser.setSelectedFile(new File("red_neuronal.csv"));
        int seleccion = fileChooser.showSaveDialog(null);
        if (seleccion != JFileChooser.APPROVE_OPTION) return;

        File archivo = fileChooser.getSelectedFile();
        if (!archivo.getName().toLowerCase().endsWith(".csv")) {
            archivo = new File(archivo.getAbsolutePath() + ".csv");
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            pw.println("origen,destino,distancia,ID_Neurotransmisor,coheficiente_eficiencia_sináptica");
            Nodo<ConexionSinaptica> actual = red.getTodasLasConexiones().getCabeza();
            int cont = 0;
            while (actual != null) {
                ConexionSinaptica c = actual.getDato();
                pw.printf("%s,%s,%.4f,%s,%.4f%n",
                        c.getOrigen().getId(), c.getDestino().getId(),
                        c.getDistancia(), c.getIdNeurotransmisor(), c.getCoeficienteEficiencia());
                cont++;
                actual = actual.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "Red guardada exitosamente.\nConexiones: " + cont);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Neurona obtenerOCrearNeurona(redNeuronal red, String id) {
        Neurona n = red.buscarNeurona(id);
        if (n == null) {
            n = new Neurona(id);
            red.agregarNeurona(n);
        }
        return n;
    }
}

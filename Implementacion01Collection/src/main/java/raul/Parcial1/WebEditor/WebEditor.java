package raul.Parcial1.WebEditor;

import raul.Model.Stack.list.Stack;
import raul.Model.linkedlist.singly.LinkedList;
import raul.Model.util.Iterator.Iterator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebEditor {

    private Stack<String> pilaEtiquetas;
    private LinkedList<String> errores;

    public WebEditor() {
        pilaEtiquetas = new Stack<>();
        errores = new LinkedList<>();
    }

    /**
     * Valida un archivo HTML en busca de errores de etiquetas.
     * Este método lee el archivo línea por línea y busca etiquetas HTML.
     * @param archivo Ruta del archivo HTML a validar.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public void validarHTML(String archivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            procesarLinea(linea);
        }
        br.close();

        if (pilaEtiquetas.isEmpty() && errores.isEmpty()) {
            System.out.println("OK");
        } else {
            mostrarErrores();
        }
    }

    /**
     * Procesa una línea de texto en busca de etiquetas HTML.
     * Este método busca todas las etiquetas HTML en una línea y las agrega a la pila de etiquetas.
     * @param linea Línea de texto a procesar.
     */
    private void procesarLinea(String linea) {
        LinkedList<String> etiquetas = buscarEtiquetas(linea);
        Iterator<String> iter = etiquetas.iterator();
        while (iter.hasNext()) {
            String etiqueta = iter.next();
            if (etiqueta.startsWith("</")) {
                if (!pilaEtiquetas.isEmpty() && pilaEtiquetas.peek().equals(etiqueta.substring(2, etiqueta.length() - 1))) {
                    pilaEtiquetas.pop();
                } else {
                    errores.add("Error: " + etiqueta + " no tiene una etiqueta de apertura.");
                    errores.add("Error: " + pilaEtiquetas.pop() + " no tiene una etiqueta de cierre.");
                }
            } else {
                pilaEtiquetas.push(etiqueta.substring(1, etiqueta.length() - 1));
            }
        }
    }

    /**
     * Muestra los errores encontrados en el archivo HTML.
     */
    private void mostrarErrores() {
        while (!pilaEtiquetas.isEmpty()) {
            errores.add("Error: <" + pilaEtiquetas.pop() + "> no tiene una etiqueta de cierre.");
        }
        Iterator<String> iter = errores.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    /**
     * Busca todas las etiquetas HTML en una línea de texto.
     * @param linea Línea de texto a buscar etiquetas.
     * @return Lista enlazada con todas las etiquetas encontradas.
     */
    private LinkedList<String> buscarEtiquetas(String linea) {
        LinkedList<String> etiquetas = new LinkedList<>();
        Pattern pattern = Pattern.compile("<[^>]*>");
        Matcher matcher = pattern.matcher(linea);
        while (matcher.find()) {
            String tag = matcher.group();
            etiquetas.add(tag);
        }
        return etiquetas;
    }

    public static void main(String[] args) {
        WebEditor editor = new WebEditor();
        String archivo = "src/main/java/raul/Parcial1/WebEditor/input.html";
        try {
            editor.validarHTML(archivo);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

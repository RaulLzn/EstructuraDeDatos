package DocumentacionPersonal.ArchivosDeTexto;

import java.io.*;

public class OperacionesSobreArchivosDeTexto {

    /*
    Crear un archivo de texto
    Para crear un archivo de texto en Java, puedes utilizar la clase FileWriter junto con BufferedWriter para
    escribir texto en el archivo. Aquí tienes un ejemplo:
     */

    public class CrearArchivoTexto {
        public static void main(String[] args) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("archivo.txt"));
                writer.write("Este es un archivo de texto creado desde Java.");
                writer.close();
                System.out.println("Archivo creado correctamente.");
            } catch (IOException e) {
                System.err.println("Error al crear el archivo: " + e.getMessage());
            }
        }
    }

    /*
    Leer un archivo de texto
    Para leer un archivo de texto en Java, puedes utilizar BufferedReader. Aquí tienes un ejemplo:
     */
    public class LeerArchivoTexto {
        public static void main(String[] args) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("archivo.txt"));
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                }
                reader.close();
            } catch (IOException e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }
        }
    }

    /*
    Editar un archivo de texto
    Para editar un archivo de texto en Java, puedes leer el archivo, hacer los cambios necesarios en la memoria
    y luego escribir los cambios de vuelta al archivo. Aquí hay un ejemplo simple:
     */

    public class EditarArchivoTexto {
        public static void main(String[] args) {
            try {
                File archivo = new File("archivo.txt");
                BufferedReader reader = new BufferedReader(new FileReader(archivo));
                String linea;
                StringBuilder contenido = new StringBuilder();
                while ((linea = reader.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }
                reader.close();

                // Edita el contenido (por ejemplo, agregando una línea)
                contenido.append("Esta es una nueva línea agregada.");

                BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
                writer.write(contenido.toString());
                writer.close();
                System.out.println("Archivo editado correctamente.");
            } catch (IOException e) {
                System.err.println("Error al editar el archivo: " + e.getMessage());
            }
        }
    }

    /*
    Eliminar un archivo de texto
    Puedes eliminar un archivo de texto utilizando el método delete() de la clase File. Aquí tienes un ejemplo:
     */
    public class EliminarArchivoTexto {
        public static void main(String[] args) {
            File archivo = new File("archivo.txt");
            if (archivo.delete()) {
                System.out.println("Archivo eliminado correctamente.");
            } else {
                System.err.println("No se pudo eliminar el archivo.");
            }
        }
    }

    /*
    Verificar la existencia de un archivo de texto
    Puedes verificar si un archivo de texto existe utilizando el método exists() de la clase File. Aquí tienes un ejemplo:
     */
    public class VerificarExistenciaArchivo {
        public static void main(String[] args) {
            File archivo = new File("archivo.txt");
            if (archivo.exists()) {
                System.out.println("El archivo existe.");
            } else {
                System.out.println("El archivo no existe.");
            }
        }
    }

    /*
    Renombrar un archivo de texto
    Puedes renombrar un archivo de texto utilizando el método renameTo() de la clase File. Aquí tienes un ejemplo:
     */
    public class RenombrarArchivoTexto {
        public static void main(String[] args) {
            File archivoAntiguo = new File("archivo.txt");
            File archivoNuevo = new File("nuevo_nombre.txt");
            if (archivoAntiguo.renameTo(archivoNuevo)) {
                System.out.println("Archivo renombrado correctamente.");
            } else {
                System.err.println("No se pudo renombrar el archivo.");
            }
        }
    }

    /*
    Obtener información sobre un archivo de texto
    Puedes obtener información sobre un archivo de texto, como su tamaño, ruta absoluta, etc.,
    utilizando varios métodos de la clase File. Aquí hay un ejemplo:
     */
    public class InformacionArchivoTexto {
        public static void main(String[] args) {
            File archivo = new File("archivo.txt");
            System.out.println("Nombre del archivo: " + archivo.getName());
            System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
            System.out.println("Tamaño del archivo (en bytes): " + archivo.length());
            System.out.println("Es un directorio: " + archivo.isDirectory());
            System.out.println("Es un archivo: " + archivo.isFile());
        }
    }

    /*
    Leer y escribir archivos grandes
    Cuando trabajas con archivos grandes, puede ser más eficiente leer y
    escribir en bloques o líneas en lugar de cargar todo el contenido en memoria de una vez.
    Aquí tienes un ejemplo de cómo leer y escribir archivos grandes línea por línea:
     */
    public class LeerEscribirArchivoGrande {
        public static void main(String[] args) {
            try {
                // Leer archivo grande
                BufferedReader reader = new BufferedReader(new FileReader("archivo_grande.txt"));
                BufferedWriter writer = new BufferedWriter(new FileWriter("copia_archivo_grande.txt"));

                String linea;
                while ((linea = reader.readLine()) != null) {
                    // Procesar la línea si es necesario
                    // Aquí puedes hacer manipulaciones con la línea antes de escribirla en el archivo de salida
                    writer.write(linea);
                    writer.newLine(); // Agregar salto de línea
                }

                reader.close();
                writer.close();
                System.out.println("Archivo grande leído y copiado correctamente.");
            } catch (IOException e) {
                System.err.println("Error al leer o escribir el archivo grande: " + e.getMessage());
            }
        }
    }

    /*
    Leer y escribir archivos en diferentes codificaciones
    Puedes especificar la codificación al leer o escribir archivos para manejar
    diferentes juegos de caracteres. Aquí tienes un ejemplo:
     */
    public class LeerEscribirCodificacion {
        public static void main(String[] args) {
            try {
                // Leer archivo con codificación UTF-8
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("archivo_utf8.txt"), "UTF-8"));

                // Escribir archivo con codificación ISO-8859-1
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("archivo_iso.txt"), "ISO-8859-1"));

                // Operaciones de lectura y escritura...

                reader.close();
                writer.close();
                System.out.println("Archivos leídos y escritos con diferentes codificaciones.");
            } catch (IOException e) {
                System.err.println("Error al leer o escribir archivos con diferentes codificaciones: " + e.getMessage());
            }
        }
    }

    /*
    Operaciones avanzadas: Serialización de objetos
    Además de trabajar con archivos de texto, puedes serializar objetos Java y guardarlos en archivos.
    Aquí tienes un ejemplo básico de serialización y deserialización:
     */
    public class MiObjeto implements Serializable {
        // Atributos y métodos de la clase
    }

    public class SerializacionObjetos {
        public void main(String[] args) {
            try {
                // Serialización
                ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("objeto_serializado.ser"));
                MiObjeto objeto = new MiObjeto(); // Supongamos que tenemos una clase llamada MiObjeto
                salida.writeObject(objeto);
                salida.close();

                // Deserialización
                ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("objeto_serializado.ser"));
                MiObjeto objetoDeserializado = (MiObjeto) entrada.readObject();
                entrada.close();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error al serializar o deserializar objeto: " + e.getMessage());
            }
        }
    }
}

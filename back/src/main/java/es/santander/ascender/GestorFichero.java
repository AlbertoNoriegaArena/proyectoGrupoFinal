package es.santander.ascender;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorFichero {
    private String rutaFichero;

    public GestorFichero(String rutaFichero) {
        this.rutaFichero = rutaFichero;
    }

    /*
     * FileWriter("nombre_del_archivo.txt", true/false) 
     * false => indica si se debe sobrescribir el archivo 
     * true => agrega (append) al final del archivo 
     */

    // Guardar la lista completa de jugadores 
    public void guardarJugadores(List<Jugador> jugadores) {
        //ponemos true para añadir
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaFichero, true))) {
            for (Jugador jugador : jugadores) {
                // Guardar el nombre y los intentos del jugador, separados por coma
                writer.write(jugador.getNombre() + "," + jugador.getNumeroDeIntentos());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar la lista de jugadores: " + e.getMessage());
        }
    }

    // Método para guardar el Top 5 de jugadores en un archivo
    public void guardarTop5(List<Jugador> top5) {
        //ponemos false para que sobreescriba
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaFichero,false))) {  
            // Iterar a través de la lista de jugadores Top 5
            for (Jugador jugador : top5) {
                // Escribir el nombre del jugador y el número de intentos separados por una coma
                writer.write(jugador.getNombre() + "," + jugador.getNumeroDeIntentos());
                writer.newLine();  // Salto de línea después de cada jugador
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el Top 5 de jugadores: " + e.getMessage());
        }
    }

    public List<Jugador> cargarJugadores() {
        List<Jugador> jugadores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Verificar si la línea no está vacía y tiene la coma para separar los datos
                if (!linea.trim().isEmpty() && linea.contains(",")) {
                    String[] datos = linea.split(",");
                    // Verificar que el array tiene exactamente dos elementos
                    if (datos.length == 2) {
                        try {
                            String nombre = datos[0].trim();  // Eliminar espacios adicionales
                            int intentos = Integer.parseInt(datos[1].trim());  // Convertir a número
                            jugadores.add(new Jugador(nombre, intentos));
                        } catch (NumberFormatException e) {
                            System.err.println("Error al convertir el número de intentos para el jugador: " + linea);
                        }
                    } else {
                        System.err.println("Línea mal formateada (debe tener nombre e intentos separados por coma): " + linea);
                    }
                } else {
                    System.err.println("Línea vacía o mal formateada: " + linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar jugadores: " + e.getMessage());
        }
        return jugadores;
    }
}

package es.santander.ascender;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorFichero {
    private String rutaFichero;

    public GestorFichero(String rutaFichero) {
        this.rutaFichero = rutaFichero;
    }

    // Guardar jugador en el fichero
    public void guardarJugador(Jugador jugador) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaFichero, true))) {
            writer.write(jugador.getNombre() + "," + jugador.getNumeroDeIntentos());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar el jugador: " + e.getMessage());
        }
    }

    // Cargar jugadores desde el fichero
    public List<Jugador> cargarJugadores() {
        List<Jugador> jugadores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                int intentos = Integer.parseInt(datos[1]);
                jugadores.add(new Jugador(nombre, intentos));
            }
        } catch (IOException e) {
            System.err.println("Error al cargar jugadores: " + e.getMessage());
        }
        return jugadores;
    }
}

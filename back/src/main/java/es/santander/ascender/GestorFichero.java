package es.santander.ascender;

import java.io.*;
import java.util.*;

public class GestorFichero {
    private String rutaFichero = "src/main/java/es/santander/ascender/jugadores.txt";


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

    // Ordenar jugadores por número de intentos
    public void mostrarRanking() {
        List<Jugador> jugadores = cargarJugadores();
        jugadores.sort(Comparator.comparingInt(Jugador::getNumeroDeIntentos));

        System.out.println("Ranking de jugadores:");
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador jugador = jugadores.get(i);
            System.out.println((i + 1) + ". " + jugador.getNombre() + " - " + jugador.getNumeroDeIntentos() + " intentos");
        }
    }
}

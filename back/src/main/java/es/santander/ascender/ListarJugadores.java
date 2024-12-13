package es.santander.ascender;

import java.util.*;
import java.util.stream.Collectors;

public class ListarJugadores {
    private List<Jugador> jugadores;

    // Constructor
    public ListarJugadores() {
        this.jugadores = new ArrayList<>();
    }

    // Cargar jugadores desde el fichero y añadirlos a la lista
    public void cargarJugadoresDesdeFichero(GestorFichero gestorFichero) {
        this.jugadores = gestorFichero.cargarJugadores();
    }

    // Añadir un jugador a la lista
    public void agregarJugador(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    // Obtener el ranking de jugadores ordenado por número de intentos (de menor a mayor)
    public List<Jugador> obtenerRanking() {
        return jugadores.stream()
                .sorted(Comparator.comparingInt(Jugador::getNumeroDeIntentos))
                .collect(Collectors.toList());
    }

    // Obtener los 5 mejores jugadores (menos intentos)
    public List<Jugador> obtenerTop5() {
        return obtenerRanking().stream()
                .limit(5)
                .collect(Collectors.toList());
    }

    // Mostrar todos los jugadores
    public void mostrarJugadores() {
        jugadores.forEach(jugador -> System.out.println("Nombre: " + jugador.getNombre() + ", número de intentos: " + jugador.getNumeroDeIntentos()));
    }

    // Mostrar el ranking de los 5 mejores jugadores
    public void mostrarTop5() {
        obtenerTop5().forEach(jugador -> System.out.println("Nombre: " + jugador.getNombre() + ", número de intentos: " + jugador.getNumeroDeIntentos()));
    }
}

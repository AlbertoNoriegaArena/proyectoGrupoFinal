package es.santander.ascender;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // Crear una instancia de GestorFichero para jugadores y Top 5
        GestorFichero FicheroTodosLosJugadores = new GestorFichero("jugadores.txt");
        GestorFichero Ficherotop5jugadores = new GestorFichero("top5jugadores.txt");

        // Crear una instancia de ListaJugadores
        ListarJugadores listaJugadores = new ListarJugadores();

        // Crear partida
        Partida partida = new Partida();

        // Crear lista de jugadores
        List<Jugador> jugadores = partida.jugar();

        // Bucle para agregar cada jugador a la lista de jugadores
        for (Jugador jugador : jugadores) {
            listaJugadores.agregarJugador(jugador); // Agregar a la lista de jugadores
        }

        // Guardar TODOS los jugadores en el archivo
        FicheroTodosLosJugadores.guardarJugadores(jugadores);
        
         // Cargar jugadores desde el fichero y actualizar la lista
         listaJugadores.cargarJugadoresDesdeFichero(FicheroTodosLosJugadores);

        // Guardar el Top 5 de jugadores en un archivo
        Ficherotop5jugadores.guardarTop5(listaJugadores.obtenerTop5());

        
        // Mostrar todos los jugadores
        System.out.println("Lista de todos los jugadores:");
        listaJugadores.mostrarJugadores();

        // Mostrar el ranking de los 5 mejores jugadores
        System.out.println("\nRanking de los 5 mejores jugadores:");
        listaJugadores.mostrarTop5();
    }
}

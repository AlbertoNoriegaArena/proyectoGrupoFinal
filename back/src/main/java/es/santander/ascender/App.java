package es.santander.ascender;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        
        Partida partida = new Partida();
        GestorFichero gestorFichero = new GestorFichero("jugadores.txt");

        // Jugar una partida y obtener al jugador
        Jugador jugador = partida.jugar();

        // Guardar el jugador en el fichero
        gestorFichero.guardarJugador(jugador);

        // Mostrar el ranking
        gestorFichero.mostrarRanking();
    }
}

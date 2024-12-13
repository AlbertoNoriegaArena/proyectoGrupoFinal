package es.santander.ascender;

public class App {
    public static void main(String[] args) {
        // Crear una instancia de GestorFichero
        GestorFichero gestorFichero = new GestorFichero("jugadores.txt");

        // Crear una instancia de ListaJugadores
        ListarJugadores listaJugadores = new ListarJugadores();

        // Crear un jugador (por ejemplo, obteniéndolo de una partida)
        Partida partida = new Partida();
        Jugador jugador = partida.jugar();  // Suponiendo que esta línea te da un jugador

        // Agregar el jugador a la lista de jugadores
        listaJugadores.agregarJugador(jugador);

        // Guardar el jugador en el archivo
        gestorFichero.guardarJugador(jugador);
        
        // Cargar jugadores desde el fichero y actualizar la lista
        listaJugadores.cargarJugadoresDesdeFichero(gestorFichero);

        // Mostrar todos los jugadores
        System.out.println("Lista de todos los jugadores:");
        listaJugadores.mostrarJugadores();

        // Mostrar el ranking de los 5 mejores jugadores
        System.out.println("\nRanking de los 5 mejores jugadores:");
        listaJugadores.mostrarTop5();
    }
}

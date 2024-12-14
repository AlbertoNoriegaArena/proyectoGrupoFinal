package es.santander.ascender;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class ListarJugadoresTest {

    @Test
    public void testAgregarJugador() {
        ListarJugadores listarJugadores = new ListarJugadores();
        Jugador jugador = new Jugador("Juan", 5);
        
        listarJugadores.agregarJugador(jugador);
        
        List<Jugador> jugadores = listarJugadores.obtenerRanking();
        assertEquals(1, jugadores.size());
        assertEquals("Juan", jugadores.get(0).getNombre());
        assertEquals(5, jugadores.get(0).getNumeroDeIntentos());
    }

    @Test
    public void testObtenerRanking() {
        ListarJugadores listarJugadores = new ListarJugadores();
        listarJugadores.agregarJugador(new Jugador("Juan", 5));
        listarJugadores.agregarJugador(new Jugador("Ana", 2));
        listarJugadores.agregarJugador(new Jugador("Luis", 3));

        List<Jugador> ranking = listarJugadores.obtenerRanking();
        
        assertEquals(3, ranking.size());
        assertEquals("Ana", ranking.get(0).getNombre());  // Menor intentos primero
        assertEquals(2, ranking.get(0).getNumeroDeIntentos());
        assertEquals("Luis", ranking.get(1).getNombre());
        assertEquals(3, ranking.get(1).getNumeroDeIntentos());
        assertEquals("Juan", ranking.get(2).getNombre());
        assertEquals(5, ranking.get(2).getNumeroDeIntentos());
    }

    @Test
    public void testObtenerTop5() {
        ListarJugadores listarJugadores = new ListarJugadores();
        listarJugadores.agregarJugador(new Jugador("Juan", 5));
        listarJugadores.agregarJugador(new Jugador("Ana", 2));
        listarJugadores.agregarJugador(new Jugador("Luis", 3));
        listarJugadores.agregarJugador(new Jugador("Maria", 7));
        listarJugadores.agregarJugador(new Jugador("Pedro", 1));
        listarJugadores.agregarJugador(new Jugador("Julian", 4));

        List<Jugador> top5 = listarJugadores.obtenerTop5();
        
        assertEquals(5, top5.size());
        assertEquals("Pedro", top5.get(0).getNombre());  // Menor intentos
        assertEquals(1, top5.get(0).getNumeroDeIntentos());
        assertEquals("Ana", top5.get(1).getNombre());
        assertEquals(2, top5.get(1).getNumeroDeIntentos());
        assertEquals("Luis", top5.get(2).getNombre());
        assertEquals(3, top5.get(2).getNumeroDeIntentos());
        assertEquals("Julian", top5.get(3).getNombre());
        assertEquals(4, top5.get(3).getNumeroDeIntentos());
        assertEquals("Juan", top5.get(4).getNombre());
        assertEquals(5, top5.get(4).getNumeroDeIntentos());
    }

    
}

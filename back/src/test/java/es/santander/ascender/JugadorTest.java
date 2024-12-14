package es.santander.ascender;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JugadorTest {

    @Test
    public void testConstructor() {
        // Crear un jugador con nombre "Juan" y 3 intentos
        Jugador jugador = new Jugador("Juan", 3);

        // Verificar que el nombre es correcto
        assertEquals("Juan", jugador.getNombre());

        // Verificar que el número de intentos es correcto
        assertEquals(3, jugador.getNumeroDeIntentos());
    }

    @Test
    public void testIncrementarIntentos() {
        // Crear un jugador con nombre "Ana" y 0 intentos
        Jugador jugador = new Jugador("Ana", 0);

        // Verificar que el número de intentos inicial es 0
        assertEquals(0, jugador.getNumeroDeIntentos());

        // Incrementar los intentos
        jugador.incrementarIntentos();

        // Verificar que el número de intentos ha aumentado a 1
        assertEquals(1, jugador.getNumeroDeIntentos());

        // Incrementar nuevamente
        jugador.incrementarIntentos();

        // Verificar que el número de intentos ha aumentado a 2
        assertEquals(2, jugador.getNumeroDeIntentos());
    }

    @Test
    public void testIncrementarIntentosMultiple() {
        // Crear un jugador con 0 intentos
        Jugador jugador = new Jugador("Javier", 0);

        // Incrementar varias veces
        jugador.incrementarIntentos();
        jugador.incrementarIntentos();
        jugador.incrementarIntentos();

        // Verificar que el número de intentos es 3
        assertEquals(3, jugador.getNumeroDeIntentos());
    }

   

    @Test
    public void testGetNombre() {
        // Crear un jugador con nombre "Carlos" y 5 intentos
        Jugador jugador = new Jugador("Carlos", 5);

        // Verificar que el nombre es "Carlos"
        assertEquals("Carlos", jugador.getNombre());
    }

    @Test
    public void testNombreVacio() {
        // Crear un jugador con un nombre vacío y 0 intentos
        Jugador jugador = new Jugador("", 0);

        // Verificar que el nombre sea vacío
        assertEquals("", jugador.getNombre());
    }

    @Test
    public void testNombreNulo() {
        // Crear un jugador con nombre nulo y 0 intentos
        Jugador jugador = new Jugador(null, 0);

        // Verificar que el nombre sea nulo
        assertNull(jugador.getNombre());
    }

    @Test
    public void testGetNumeroDeIntentos() {
        // Crear un jugador con nombre "Maria" y 10 intentos
        Jugador jugador = new Jugador("Maria", 10);

        // Verificar que el número de intentos es 10
        assertEquals(10, jugador.getNumeroDeIntentos());
    }
}

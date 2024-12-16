package es.santander.ascender;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.List;

public class GestorFicheroTest {

    // Ruta temporal para archivos de prueba
    private final String rutaFichero = "test_jugadores.txt";
    private final String rutaFicheroTop5 = "test_top5jugadores.txt";


    @BeforeEach
    public void limpiarFichero() {
        // Eliminar los archivos de prueba antes de cada ejecución del test
        File archivoJugadores = new File(rutaFichero);
        if (archivoJugadores.exists()) {
            archivoJugadores.delete();
        }
        
        File archivoTop5 = new File(rutaFicheroTop5);
        if (archivoTop5.exists()) {
            archivoTop5.delete();
        }
    }

    @Test
    public void testGuardarJugadores() {
        // Crear un gestor de fichero
        GestorFichero gestorFichero = new GestorFichero(rutaFichero);

        // Lista de jugadores
        List<Jugador> jugadores = List.of(
                new Jugador("Juan", 98),
                new Jugador("Ana", 97),
                new Jugador("Luis", 96)
        );

        // Guardar jugadores
        gestorFichero.guardarJugadores(jugadores);

        // Leer el fichero y verificar que los datos se han guardado correctamente
        List<Jugador> jugadoresCargados = gestorFichero.cargarJugadores();

        assertEquals(3, jugadoresCargados.size());
        assertEquals("Juan", jugadoresCargados.get(0).getNombre());
        assertEquals(98, jugadoresCargados.get(0).getNumeroDeIntentos());
        assertEquals("Ana", jugadoresCargados.get(1).getNombre());
        assertEquals(97, jugadoresCargados.get(1).getNumeroDeIntentos());
        assertEquals("Luis", jugadoresCargados.get(2).getNombre());
        assertEquals(96, jugadoresCargados.get(2).getNumeroDeIntentos());
    }

    @Test
public void testGuardarTop5() {
    // Crear un gestor de fichero para el top 5
    GestorFichero gestorFicheroTop5 = new GestorFichero(rutaFicheroTop5);

    // Top 5 jugadores
    List<Jugador> top5Jugadores = List.of(
        new Jugador("Luis", 3),
        new Jugador("Juan", 5),
        new Jugador("Pepita", 1),
        new Jugador("Ana", 8),
        new Jugador("Juliana", 2),
        new Jugador("Cándido", 98),
        new Jugador("Feliciana", 52)
        
    );

    // Guardar el top 5 de jugadores
    gestorFicheroTop5.guardarTop5(top5Jugadores);

    // Leer el fichero de top 5 y verificar. 
    List<Jugador> jugadoresCargadosTop5 = gestorFicheroTop5.cargarJugadores();

    assertEquals(7, jugadoresCargadosTop5.size());
    assertEquals("Luis", jugadoresCargadosTop5.get(0).getNombre());
    assertEquals(3, jugadoresCargadosTop5.get(0).getNumeroDeIntentos());
    assertEquals("Juan", jugadoresCargadosTop5.get(1).getNombre());
    assertEquals(5, jugadoresCargadosTop5.get(1).getNumeroDeIntentos());
    assertEquals("Pepita", jugadoresCargadosTop5.get(2).getNombre());
    assertEquals(1, jugadoresCargadosTop5.get(2).getNumeroDeIntentos());
    assertEquals("Ana", jugadoresCargadosTop5.get(3).getNombre());
    assertEquals(8, jugadoresCargadosTop5.get(3).getNumeroDeIntentos());
    assertEquals("Juliana", jugadoresCargadosTop5.get(4).getNombre());
    assertEquals(2, jugadoresCargadosTop5.get(4).getNumeroDeIntentos());
    assertEquals("Cándido", jugadoresCargadosTop5.get(5).getNombre());
    assertEquals(98, jugadoresCargadosTop5.get(5).getNumeroDeIntentos());
    assertEquals("Feliciana", jugadoresCargadosTop5.get(6).getNombre());
    assertEquals(52, jugadoresCargadosTop5.get(6).getNumeroDeIntentos());
}

    @Test
    public void testCargarJugadores() throws IOException {
        // Inicializar el fichero con datos conocidos
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaFichero))) {
            writer.write("Juan,3");
            writer.newLine();
            writer.write("Ana,5");
            writer.newLine();
            writer.write("Luis,7");
            writer.newLine();
        }

        // Crear un gestor de fichero y cargar los jugadores
        GestorFichero gestorFichero = new GestorFichero(rutaFichero);
        List<Jugador> jugadoresCargados = gestorFichero.cargarJugadores();

        // Verificar los datos cargados
        assertEquals(3, jugadoresCargados.size());
        assertEquals("Juan", jugadoresCargados.get(0).getNombre());
        assertEquals(3, jugadoresCargados.get(0).getNumeroDeIntentos());
        assertEquals("Ana", jugadoresCargados.get(1).getNombre());
        assertEquals(5, jugadoresCargados.get(1).getNumeroDeIntentos());
        assertEquals("Luis", jugadoresCargados.get(2).getNombre());
        assertEquals(7, jugadoresCargados.get(2).getNumeroDeIntentos());
    }

    @Test
    public void testCargarTop5Jugadores() throws IOException {
        // Inicializar el fichero con datos conocidos para el top 5
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaFicheroTop5))) {
            writer.write("Luis,3");
            writer.newLine();
            writer.write("Juan,5");
            writer.newLine();
            writer.write("Ana,8");
        }

        // Crear un gestor de fichero para el top 5 y cargar los jugadores
        GestorFichero gestorFicheroTop5 = new GestorFichero(rutaFicheroTop5);
        List<Jugador> jugadoresCargadosTop5 = gestorFicheroTop5.cargarJugadores();

        // Verificar los datos cargados
        assertEquals(3, jugadoresCargadosTop5.size());
        assertEquals("Luis", jugadoresCargadosTop5.get(0).getNombre());
        assertEquals(3, jugadoresCargadosTop5.get(0).getNumeroDeIntentos());
        assertEquals("Juan", jugadoresCargadosTop5.get(1).getNombre());
        assertEquals(5, jugadoresCargadosTop5.get(1).getNumeroDeIntentos());
        assertEquals("Ana", jugadoresCargadosTop5.get(2).getNombre());
        assertEquals(8, jugadoresCargadosTop5.get(2).getNumeroDeIntentos());
    }

    @Test
    public void testGuardarTop5Sobreescribiendo() {
        // Crear el fichero con datos iniciales
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaFicheroTop5))) {
            writer.write("Luis,10");
            writer.newLine();
            writer.write("Juan,15");
            writer.newLine();
        } catch (IOException e) {
            fail("No debería fallar la escritura inicial.");
        }

        // Nuevo top 5 jugadores
        List<Jugador> top5Jugadores = List.of(
                new Jugador("Luis", 3),
                new Jugador("Juan", 5),
                new Jugador("Ana", 8)
        );

        GestorFichero gestorFicheroTop5 = new GestorFichero(rutaFicheroTop5);
        gestorFicheroTop5.guardarTop5(top5Jugadores);

        // Leer el fichero de top 5 y verificar
        List<Jugador> jugadoresCargadosTop5 = gestorFicheroTop5.cargarJugadores();

        assertEquals(3, jugadoresCargadosTop5.size());
        assertEquals("Luis", jugadoresCargadosTop5.get(0).getNombre());
        assertEquals(3, jugadoresCargadosTop5.get(0).getNumeroDeIntentos());
        assertEquals("Juan", jugadoresCargadosTop5.get(1).getNombre());
        assertEquals(5, jugadoresCargadosTop5.get(1).getNumeroDeIntentos());
        assertEquals("Ana", jugadoresCargadosTop5.get(2).getNombre());
        assertEquals(8, jugadoresCargadosTop5.get(2).getNumeroDeIntentos());
    }
}

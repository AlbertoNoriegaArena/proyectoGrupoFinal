package es.santander.ascender;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class Partida {
    private int numeroSecreto;

    private int generarNumeroSecreto() {
        //TODO cambiar a 100 el random de numero secreto para la entrega final
        numeroSecreto = new Random().nextInt(10); 
        return numeroSecreto;
    }

    public List<Jugador> jugar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Introduce el número de jugadores! Mínimo 1 y máximo de 5");
        int numeroDeJugadores = 0;
    
        // Validaciones número de jugadores
        while (true) {
            try {
                numeroDeJugadores = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                // Comprobamos que el número de jugadores sea mayor que 0
                if (numeroDeJugadores <= 0) {
                    System.out.println("Debe haber al menos un jugador. Inténtalo de nuevo.");
                } else if (numeroDeJugadores > 5) {
                    System.out.println("No se permiten más de 5 jugadores. Inténtalo de nuevo.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                // Excepción si no se introduce un número entero
                System.out.println("Debes introducir un número entero.");
                scanner.nextLine(); // Limpiar buffer
            }
        }
    
        List<Jugador> jugadores = new ArrayList<>();
    
        // Jugar para cada jugador
        for (int i = 1; i <= numeroDeJugadores; i++) {
            System.out.println("\nTurno del jugador " + i + ":");
    
            // Generar un número secreto diferente para cada jugador
            int numeroSecreto = generarNumeroSecreto();

            int contadorIntentos = 0;
            boolean adivinado = false;
            String nombre = "";
    
            while (!adivinado) {
                System.out.print("Introduce tu número: ");
                int intento = -1;
    
                // Validar entrada del intento
                while (true) {
                    try {
                        intento = scanner.nextInt();
                        scanner.nextLine(); 
                        
                        //comprobamos que el número introducido este en el rango valido
                        if (intento < 0 || intento > 100) {
                            System.out.println("Número no válido. El número debe estar entre 0 y 100.");
                            System.out.print("Introduce tu número: ");
                        } else {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        // Excepción si no se introduce un número entero
                        System.out.println("Debes introducir un número entero.");
                        scanner.nextLine(); 
                    }
                }
    
                contadorIntentos++;
    
                if (intento < numeroSecreto) {
                    System.out.println("El número es mayor que " + intento);
                } else if (intento > numeroSecreto) {
                    System.out.println("El número es menor que " + intento);
                } else {
                    System.out.println("¡Felicidades! Has adivinado el número en " + contadorIntentos + " intentos.");
    
                    // Pedir el nombre después de adivinar
                    do {
                        System.out.print("Introduce tu nombre: ");
                        nombre = scanner.nextLine();
    
                        if (nombre.length() == 0) {
                            System.out.println("El nombre no puede estar vacío. Por favor, introduce un nombre válido.");
                        }
                    } while (nombre.length() == 0);
    
                    adivinado = true;
                }
            }
    
            // Crear un nuevo jugador y agregarlo a la lista
            jugadores.add(new Jugador(nombre, contadorIntentos));
        }
    
        scanner.close(); // Cerrar el Scanner para liberar recursos

        return jugadores;
    }
}
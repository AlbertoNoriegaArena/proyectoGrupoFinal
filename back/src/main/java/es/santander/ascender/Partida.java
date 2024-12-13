package es.santander.ascender;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class Partida {
    private int numeroSecreto;

    public Partida() {
        generarNumeroSecreto();
    }

    private void generarNumeroSecreto() {
        this.numeroSecreto = new Random().nextInt(101); // Número entre 0 y 100
    }

    public Jugador jugar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Adivina el número entre 0 y 100!");

        int contadorIntentos = 0;
        boolean adivinado = false;
        String nombre = "";

        while (!adivinado) {
            System.out.print("Introduce tu número: ");
            int intento = -1;

            // Validación de la entrada: asegurarse de que el usuario introduzca un número
            while (true) {
                try {
                    intento = scanner.nextInt();

                    if (intento < 0 || intento > 100) {
                        System.out.println("Número no valido. El número debe estar comprendido entre 1 y 100.");
                        scanner.nextLine(); // Limpiar el buffer del scanner
                        System.out.print("Introduce tu número: ");
                    } else {
                        break; // Salir del ciclo si la entrada es válida y dentro del rango
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Tienes que  introducir un número entero");
                    scanner.nextLine(); // Limpiar el buffer del scanner
                    System.out.print("Introduce tu número: ");
                }
            }

            contadorIntentos++;

            if (intento < numeroSecreto) {
                System.out.println("El número es mayor que " + intento);
            } else if (intento > numeroSecreto) {
                System.out.println("El número es menor que " + intento);
            } else {
                System.out.println("¡Felicidades! Has adivinado el número en " + contadorIntentos + " intentos.");

                // Pedir el nombre después de adivinar el número
                do {
                    System.out.print("Introduce tu nombre: ");
                    nombre = scanner.nextLine(); // Leer el nombre

                    if (nombre.length() == 0) {
                        System.out.println("El nombre no puede estar vacío. Por favor, introduce un nombre válido");
                    }
                } while (nombre.length() == 0);
                adivinado = true;
            }
        }
        scanner.close();

        return new Jugador(nombre, contadorIntentos);
    }
}
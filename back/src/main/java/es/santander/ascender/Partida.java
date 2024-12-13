package es.santander.ascender;

import java.util.Scanner;
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
        generarNumeroSecreto();
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Adivina el número entre 0 y 100!");

        int contadorIntentos = 0;
        boolean adivinado = false;
        String nombre = "";

        while (!adivinado) {
            System.out.print("Introduce tu número: ");
            int intento = scanner.nextInt();
            contadorIntentos++;

            if (intento < numeroSecreto) {
                System.out.println("El número es mayor de " + intento);
            } else if (intento > numeroSecreto) {
                System.out.println("El número es menor de " + intento);
            } else {
                System.out.println("¡Felicidades! Has adivinado el número en " + contadorIntentos + " intentos.");
                System.out.print("Introduce tu nombre para guardar tu puntuación: ");

                do {
                    nombre = scanner.nextLine();
            
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

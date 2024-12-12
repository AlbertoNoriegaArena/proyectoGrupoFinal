package es.santander.ascender;

import java.util.Scanner;
import java.util.Random;

public class Partida {
    private int numeroSecreto;

    public Partida() {
        this.numeroSecreto = new Random().nextInt(101); // Número entre 0 y 100
    }

    public Jugador jugar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Adivina el número entre 0 y 100!");
        
        int intentos = 0;
        boolean adivinado = false;
        String nombre = "";

        while (!adivinado) {
            System.out.print("Introduce tu intento: ");
            int intento = scanner.nextInt();
            intentos++;

            if (intento < numeroSecreto) {
                System.out.println("El número es mayor.");
            } else if (intento > numeroSecreto) {
                System.out.println("El número es menor.");
            } else {
                System.out.println("¡Felicidades! Has adivinado el número en " + intentos + " intentos.");
                System.out.print("Introduce tu nombre para guardar tu puntuación: ");
                scanner.nextLine(); 
                nombre = scanner.nextLine();
                adivinado = true;
            }
        }
        scanner.close();

       
        return new Jugador(nombre, intentos);
    }
}

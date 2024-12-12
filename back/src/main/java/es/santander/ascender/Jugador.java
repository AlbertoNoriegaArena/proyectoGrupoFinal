package es.santander.ascender;

public class Jugador {
    private String nombre;
    private int numeroDeIntentos;

    public Jugador(String nombre, int numeroDeIntentos) {
        this.nombre = nombre;
        this.numeroDeIntentos = numeroDeIntentos;
    }

    public String getNombre() {
        return nombre;
    }
  

    public int getNumeroDeIntentos() {
        return numeroDeIntentos;
    }

    public void incrementarIntentos() {
        this.numeroDeIntentos++;
    }
}

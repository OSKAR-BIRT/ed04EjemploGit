package birtlh.centromain;

import java.util.Arrays;

public class Curso {
    private String nombre;
    private int identificador;
    private int horas;
    private String[] arTemas;

    public Curso(String nombre, int identificador, int horas, String[] temas) {
        if (temas == null || temas.length == 0) {
            throw new IllegalArgumentException ("Este array no tiene elementos");
        }
        this.arTemas = Arrays.copyOf(temas, temas.length);
        this.nombre = nombre;
        this.identificador = identificador;
        this.horas = horas;
        int a = 4;
    }

    // Getters y Setters de la clase Curso

    public String[] getArTemas() {
        return arTemas;
    }

    public void setArTemas(String[] arTemas) {
        this.arTemas = arTemas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdentificador() {
        return identificador;
    }

    public int getHoras() {
        return horas;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Curso: " + nombre + " (ID: " + identificador + ") - " + horas + " horas. Temas a tratar: " + Arrays.toString(arTemas);
    }
}
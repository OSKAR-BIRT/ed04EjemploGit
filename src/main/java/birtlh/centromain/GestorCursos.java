package birtlh.centromain;

import java.util.ArrayList;
import java.util.Iterator;

public class GestorCursos {
    private String nombreCentro;
    public ArrayList<Curso> cursos;

    public GestorCursos() {
        this.nombreCentro = "Centro de Formación Profesional";
        this.cursos = new ArrayList<>();
    }

    public void añadirCurso(Curso curso) {
        cursos.add(curso);
        System.out.println("Curso añadido con éxito: " + curso.toString());
    }

    public void eliminarCurso(int identificador) {
        Iterator<Curso> iter = cursos.iterator();
        boolean encontrado = false;
        while (iter.hasNext()) {
            Curso curso = iter.next();
            if (curso.getIdentificador() == identificador) {
                iter.remove();
                encontrado=true;
            }
        }
        if (encontrado) {
            System.out.println("Curso(s) eliminado(s) con éxito.");
        } else {
            System.out.println("No se encontró ningún curso con el identificador proporcionado.");
        }
    }

    public void editarCurso(int identificador, String nombre, int horas) {
        for (Curso curso : cursos) {
            if (curso.getIdentificador() == identificador) {
                curso.setNombre(nombre);
                curso.setHoras(horas);
                System.out.println("Curso editado con éxito.");
                return;
            }
        }
        System.out.println("No se encontró ningún curso con el identificador proporcionado.");
    }

    public void imprimirCursos() {
        System.out.println("Listado de cursos ofrecidos por " + nombreCentro + ":");
        for (Curso curso : cursos) {
            System.out.println(curso.toString());
        }
    }

    public int calcularTotalHoras() {
        int totalHoras = 0;
        for (Curso curso : cursos) {
            totalHoras += curso.getHoras();
        }
        return totalHoras;
    }
    
    /**
     * Esta función te devuelve el curso con las horas más cercanas a las horas que se le pasa, tanto por arriba como por abajo.
     */
    public int cursoMasCercano(int numHorasRef) {
        int id = 0;
        Curso cursoMasCercanoUmbral = null;
        int diferenciaMinima = Integer.MAX_VALUE;

        for (Curso curso : cursos) {
            int diferencia = Math.abs(curso.getHoras() - numHorasRef);

            if (diferencia < diferenciaMinima) {
                cursoMasCercanoUmbral = curso;
                diferenciaMinima = diferencia;
                id = cursoMasCercanoUmbral.getIdentificador();
            }
        }
        
        return id;
    }
    
    
}

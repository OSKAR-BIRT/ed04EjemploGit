package birtlh.centromain;

public class CentroMain {
    public static void main(String[] args) {
        // Crear una instancia de GestorCursos
        GestorCursos gestor = new GestorCursos();
        String [] arTemas1 = {"Tema1", "Tema2"};
        String [] arTemas2 = {"Tema3", "Tema4"};
        String [] arTemas3 = {"Tema5", "Tema6"};
        String [] arTemas4 = {"Tema7", "Tema8"};
        // Añadir algunos cursos
        gestor.añadirCurso(new Curso("Desarrollo de Aplicaciones Web", 101, 200, arTemas1));
        gestor.añadirCurso(new Curso("Administración de Sistemas Informáticos en Red", 102, 180,arTemas2));
        gestor.añadirCurso(new Curso("Automatización y Robótica Industrial", 103, 220, arTemas3));
        gestor.añadirCurso(new Curso("Master en industrialización 4.0", 104, 150, arTemas4));

        // Imprimir cursos dados de alta
        gestor.imprimirCursos();

        // Calcular total de horas de todos los cursos
        System.out.println("Total de horas de todos los cursos: " + gestor.calcularTotalHoras());

        // Editar un curso en concreto
        gestor.editarCurso(102, "Administración de Redes", 190);
        gestor.imprimirCursos();
        gestor.imprimirCursos();

        // Eliminar un curso en concreto
        gestor.eliminarCurso(101);
        gestor.imprimirCursos();
    }
}


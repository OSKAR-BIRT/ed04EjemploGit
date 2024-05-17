/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package birtlh.centromain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author OSKAR
 */
public class GestorCursosTest {
    
    static GestorCursos gestorañadir = new GestorCursos();
    static GestorCursos gestorCalcular = new GestorCursos();
    static GestorCursos gestorHoras = new GestorCursos();

            
    public GestorCursosTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        //Crear array temas
        String [] arTemas1 = {"Tema1", "Tema2"};
        String [] arTemas2 = {"Tema3", "Tema4"};
        String [] arTemas3 = {"Tema5", "Tema6"};
        
        //Crear cursos
        Curso curso1 = new Curso("Curso 1", 1, 100, arTemas1);
        Curso curso2 = new Curso("Curso 2", 2, 95, arTemas2);
        Curso curso3 = new Curso("Curso 3", 3, 115, arTemas3);
        
        //Añadir cursos
        gestorHoras.añadirCurso(curso1);
        gestorHoras.añadirCurso(curso2);
        gestorHoras.añadirCurso(curso3);

     }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of añadirCurso method, of class GestorCursos.
     */
    @Test
    public void testAñadirCurso() {
        System.out.println("a\u00f1adirCurso");
        String [] arTemas = {"Tema1", "Tema2"};
        String nombre = "Curso de prueba";
        int identificador = 1;
        int horas = 100;
        
        // Instancio dos objetos de la clase Curso con los mismos datos
        Curso testCurso = new Curso(nombre, identificador, horas, arTemas);
        Curso otroCurso = new Curso(nombre, identificador, horas, arTemas);
        
        gestorañadir.añadirCurso(testCurso);
        int numeroCursos = gestorañadir.cursos.size();
        
        assertEquals(testCurso, gestorañadir.cursos.get(numeroCursos-1));
        assertNotSame(otroCurso, gestorañadir.cursos.get(numeroCursos-1));
    }

    /**
     * Test of calcularTotalHoras method, of class GestorCursos.
     */
    @DisplayName("calcularTotalHoras parametrizada")
    @ParameterizedTest
    @CsvFileSource(resources = "/datos.csv")
    /* El fichero datdos.csv tiene el siguiente contenido:
        CURSO1, 1, 50, 50,
        CURSO2, 2, 100, 150,
        CURSO3, 3, 75, 225,
        CURSO4, 4, 80, 305,
        CURSO5, 5, 120, 425        
    */
    public void testCalcularTotalHoras(String nombre, int id, int horas, int expTotal) {
        System.out.println("calcularTotalHoras");
        int expResult = expTotal;
        // Para inicializar el arraylist de cursos, si el curso que estamos tratando
        // es el que tiene id 1, borramos todos los posibles cursos del array
        if (id==1){
            while (!gestorCalcular.cursos.isEmpty()) {
                gestorCalcular.cursos.remove(0);
            }
        }
        String [] arTemas = {"Tema1", "Tema2"};
        Curso testCurso = new Curso(nombre, id, horas, arTemas);
        gestorCalcular.añadirCurso(testCurso);
        int result = gestorCalcular.calcularTotalHoras();
        assertEquals(expResult, result);
    }

    /**
     * Test of cursoMasCercano method, of class GestorCursos.
    */ 
    @ParameterizedTest
    @CsvSource({
        "50, 2",
        "97, 2",
        "98, 1",
        "101, 1",
        "107, 1",
        "108, 3",
        "500, 3",
        })
        public void testCursoMasCercano(int horas, int expCurso) {
        System.out.println("cursoMasCercano");
        int numHorasRef = horas;
        int expResult = expCurso;
        int result = gestorHoras.cursoMasCercano(numHorasRef);
        assertEquals(expResult, result);
    }
    
}

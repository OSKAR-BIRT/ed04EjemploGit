/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package birtlh.centromain;

import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author OSKAR
 */
public class CursoTest {
    

    public CursoTest() {
    }
    

    @BeforeAll
    public static void setUpClass() {
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
     * Test of Curso method, of class Curso (exception).
     */
    @Test
    public void testExcepcionCurso() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            System.out.println("Curso - Test de excepcion");
            String [] arTemas = null;
            // Creamos un curso con un array vacio (generará IllegalArgumentException)
            Curso curso = new Curso("Curso 1", 1, 100, arTemas);
        });    
    }
    
        /**
     * Test of Curso method, of class Curso.
     */
    @Test
    public void testCurso() {
        System.out.println("Curso");
        
        // Testeamos si los datos que usamos para crear el objeto Curso son los mismos
        // que nos devuelve con los métodos getters
        String [] arTemas1 = {"Tema1", "Tema2"};
        String nombre = "Curso de prueba";
        int identificador = 1;
        int horas = 100;
        Curso testCurso = new Curso(nombre, identificador, horas, arTemas1);
        assertEquals(testCurso.getNombre(), nombre);
        assertTrue(testCurso.getIdentificador()==identificador);
        assertEquals(testCurso.getHoras(), horas);
        assertArrayEquals(testCurso.getArTemas(), arTemas1);
        
        // Testeamos que el método toString devuelva el valor esperado
        String cursoEnTexto = "Curso: Curso de prueba (ID: 1) - 100 horas. Temas a tratar: [Tema1, Tema2]";
        assertEquals(testCurso.toString(), cursoEnTexto);
    }  
    
    
}

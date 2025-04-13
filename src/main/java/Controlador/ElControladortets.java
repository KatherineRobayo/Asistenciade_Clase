package Controlador;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Modelo.Estudiante;

public class ElControladortets {

    @Test
    public void testAdicionarAsignatura() {
        El_Controlador controlador = new El_Controlador();
        // Como el metodo no retorna nada, solo verificamos que no lance errores
        controlador.adicionarAsignatura("Matemáticas", "MAT401", 4, "A", "2025-1");
        assertTrue(controlador.existeAsignatura("MAT401", "2025-1", "A"));
    }

    @Test
    public void testExisteAsignatura() {
        El_Controlador controlador = new El_Controlador();
        controlador.adicionarAsignatura("Matemáticas", "MAT401", 4, "A", "2025-1");
        boolean existe = controlador.existeAsignatura("MAT401", "2025-1", "A");
        assertTrue(existe);
    }

    @Test
    public void testModificarAsignatura() {
        El_Controlador controlador = new El_Controlador();
        controlador.adicionarAsignatura("Matemáticas", "MAT401", 4, "A", "2025-1");

        boolean resultado = controlador.modificarAsignatura("MAT401", "2025-1", "A", "Matemáticas Avanzadas", 5);

        assertTrue(resultado); // Verifica que se haya modificado correctamente
    }

    @Test
    public void testRegistrarYConsultarEstudiante() {
        El_Controlador controlador = new El_Controlador();
        controlador.registrarEstudiante("Luis Pérez", "CC", "101010");

        Estudiante resultado = controlador.consultarEstudiante("CC", "101010");

        assertNotNull(resultado); // Verifica que el estudiante exista
        assertEquals("Luis Pérez", resultado.getNombre_completo());
    }

    @Test
    public void testModificarEstudiante() {
        El_Controlador controlador = new El_Controlador();
        controlador.registrarEstudiante("Luis Pérez", "CC", "101010");

        boolean resultado = controlador.modificarEstudiante("CC", "101010", "Luis P.", "TI");

        assertTrue(resultado); // Verifica que se modificó correctamente

        Estudiante actualizado = controlador.consultarEstudiante("TI", "101010");
        assertEquals("Luis P.", actualizado.getNombre_completo());
        assertEquals("TI", actualizado.getTipo_de_documento());
    }

    @Test
    public void testRegistrarEstudianteEnAsignatura() {
        El_Controlador controlador = new El_Controlador();
        controlador.registrarEstudiante("Laura Ruiz", "CC", "202020");
        controlador.adicionarAsignatura("Física", "FIS101", 3, "B", "2025-1");
        boolean registrado = controlador.registrarEstudianteEnAsignatura("CC", "202020", "FIS101", "2025-1", "B");
        assertTrue(registrado);
    }

    @Test
    public void testCrearYLlenarAsistencia() {
        El_Controlador controlador = new El_Controlador();
        controlador.registrarEstudiante("Carlos", "CC", "303030");
        controlador.adicionarAsignatura("Química", "QUI202", 3, "C", "2025-1");
        controlador.registrarEstudianteEnAsignatura("CC", "303030", "QUI202", "2025-1", "C");
        controlador.crearAsistencia("QUI202", "2025-1", "C", "2025-04-12", "10:00");
        boolean resultado = controlador.llenarAsistencia("QUI202", "2025-1", "C", "2025-04-12", "10:00", "CC", "303030", "asistió");
        assertTrue(resultado);
    }

    @Test
    public void testModificarAsistencia() {
        El_Controlador controlador = new El_Controlador();
        controlador.registrarEstudiante("Daniela", "CC", "404040");
        controlador.adicionarAsignatura("Biología", "BIO303", 3, "D", "2025-1");
        controlador.registrarEstudianteEnAsignatura("CC", "404040", "BIO303", "2025-1", "D");
        controlador.crearAsistencia("BIO303", "2025-1", "D", "2025-04-12", "11:00");
        controlador.llenarAsistencia("BIO303", "2025-1", "D", "2025-04-12", "11:00", "CC", "404040", "asistió");
        boolean resultado = controlador.modificarAsistencia("BIO303", "2025-1", "D", "2025-04-12", "11:00", "CC", "404040");
        assertTrue(resultado);
    }
}



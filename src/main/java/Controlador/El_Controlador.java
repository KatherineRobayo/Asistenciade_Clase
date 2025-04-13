package Controlador;

import Modelo.Departamento;
import Modelo.Estudiante;

import java.util.ArrayList;

public class El_Controlador {

    private Departamento departamento;

    public El_Controlador() {
        departamento = Departamento.singleton();
    }

    public String consultarNombreDepartamento() {
        return departamento.consultarNombreDepartamento();
    }

    public void modificarNombreDepartamento(String nuevoNombre) {
        departamento.modificarNombreDepartamento(nuevoNombre);
    }

    public void registrarEstudiante(String nombre, String tipoDoc, String numDoc) {
        departamento.registrarEstudiante(nombre, tipoDoc, numDoc);
    }

    public Estudiante consultarEstudiante(String tipoDoc, String numDoc) {
        return departamento.consultarEstudiante(tipoDoc, numDoc);
    }

    public boolean modificarEstudiante(String tipoDoc, String numDoc, String nuevoNombre, String nuevoTipoDoc) {
        return departamento.modificarEstudiante(tipoDoc, numDoc, nuevoNombre, nuevoTipoDoc);
    }

    public void adicionarAsignatura(String nombre, String codigo, int creditos, String seccion, String semestre) {
        departamento.adicionarAsignatura(nombre, codigo, creditos, seccion, semestre);
    }

    public boolean existeAsignatura(String codigo, String semestre, String seccion) {
        return departamento.consultarAsignatura(codigo, semestre, seccion) != null;
    }

    public boolean modificarAsignatura(String codigo, String semestre, String seccion, String nuevoNombre, int nuevosCreditos) {
        return departamento.modificarAsignatura(codigo, semestre, seccion, nuevoNombre, nuevosCreditos);
    }

    public boolean registrarEstudianteEnAsignatura(String tipoDoc, String numDoc, String codigo, String semestre, String seccion) {
        return departamento.registrarEstudianteEnAsignatura(tipoDoc, numDoc, codigo, semestre, seccion);
    }

    public ArrayList<String> consultarEstudiantesAsignatura(String codigo, String semestre, String seccion) {
        return departamento.consultarEstudiantesAsignatura(codigo, semestre, seccion);
    }

    public boolean crearAsistencia(String codigo, String semestre, String seccion, String fecha, String horaInicio) {
        return departamento.crearAsistencia(codigo, semestre, seccion, fecha, horaInicio);
    }

    public boolean llenarAsistencia(String codigo, String semestre, String seccion, String fecha, String horaInicio, String tipoDoc, String numDoc, String estado) {
        return departamento.llenarAsistencia(codigo, semestre, seccion, fecha, horaInicio, tipoDoc, numDoc, estado);
    }

    public boolean modificarAsistencia(String codigo, String semestre, String seccion, String fecha, String horaInicio, String tipoDoc, String numDoc) {
        return departamento.modificarAsistencia(codigo, semestre, seccion, fecha, horaInicio, tipoDoc, numDoc);
    }

    public ArrayList<String> listarAsistenciasDetalladas() {
        return departamento.listarAsistenciasDetalladas();
    }


    public void opcion15() {

    }
}



/**
 *
 * @param nombre
 * @param creditos
 * @param codigo
 * @param seccion
 * @param semestre
 * @return
 */
/*
public boolean adicionarAsignatura(String nombre, int creditos, String codigo, String seccion, String semestre) {
        Departamento departamento = Departamento.singleton();
        departamento.adicionarAsignatura(nombre, creditos, codigo, seccion, semestre);
        return true;
    }

    public boolean consultarAsignatura(String codigo, String seccion, String semestre) {
        Departamento departamento = Departamento.singleton();
        departamento.consultarAsignatura(codigo, seccion, semestre);
        return true;
    }

    public boolean actualizarAsignatura(String codigo, String seccion, String semestre, String nombre, int creditos) {
        Departamento departamento = Departamento.singleton();
        departamento.actualizarAsignatura(codigo, seccion, semestre, nombre, creditos);
        return true;
    }

    public boolean borrarAsignatura(String codigo, String seccion, String semestre) {
        Departamento departamento = Departamento.singleton();
        departamento.borrarAsignatura(codigo, seccion, semestre);
        return true;
    }
    // CRUD Asistencia

    public boolean adicionarAsistencia(String codigo, String estado) {
        Asistencia asistencia = Asistencia.singleton();
        asistencia.adicionarAsistencia(codigo, estado);
        return true;
    }

    public boolean consultarAsistencia(String codigo) {
        Asistencia asistencia = Asistencia.singleton();
        asistencia.consultarAsistencia(codigo);
        return true;
    }
    public boolean modificarAsistencia (String codigo, String estado) {
        Asistencia asistencia = Asistencia.singleton();
        asistencia.modificarAsistencia(codigo, estado);
        return  true;
    }
    // CRUD de Estudiante

    public boolean adicionarEstudiante(String nombre, String numeroId, String tipoDocumento) {
        Departamento departamento = Departamento.singleton();
        return departamento.adicionarEstudiante(nombre, numeroId, tipoDocumento);
    }

    public boolean consultarEstudiante(String numeroId) {
        Departamento departamento = Departamento.singleton();
        return departamento.consultarEstudiante(numeroId) != null;
    }

    public boolean actualizarEstudiante(String numeroId, String nuevoNombre, String nuevoTipoDocumento) {
        Departamento departamento = Departamento.singleton();
        return departamento.actualizarEstudiante(numeroId, nuevoNombre, nuevoTipoDocumento);
    }

    public boolean borrarEstudiante(String numeroId) {
        Departamento departamento = Departamento.singleton();
        return departamento.borrarEstudiante(numeroId);
    }

    // CRUD Departamento

    public boolean adicionarDepartamento(String nombre) {
        Departamento departamento = Departamento.singleton();
        departamento.setNombre(nombre);
        return true;
    }

    public boolean consultarDepartamento() {
        Departamento departamento = Departamento.singleton();
        return departamento.getNombre() != null && !departamento.getNombre().isEmpty();
    }

    public boolean actualizarDepartamento(String nombre) {
        Departamento departamento = Departamento.singleton();
        departamento.setNombre(nombre);
        return true;
    }

    public boolean borrarDepartamento() {
        Departamento departamento = Departamento.singleton();
        departamento.setNombre("");
        return true;
    }
}
*/




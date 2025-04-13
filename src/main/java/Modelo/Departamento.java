package Modelo;

import java.util.ArrayList;

public class Departamento {
    private static Departamento instancia = null;
    private String nombre = "";
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Asignatura> asignaturas;

    private Departamento() {
        estudiantes = new ArrayList<>();
        asignaturas = new ArrayList<>();
    }
    public static Departamento singleton() {
        if (instancia == null) {
            instancia = new Departamento();
        }
        return instancia;
    }

    public String consultarNombreDepartamento() {
        return nombre;
    }
    public void modificarNombreDepartamento(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
    public void registrarEstudiante(String nombre, String tipoDoc, String numDoc) {
        estudiantes.add(new Estudiante(nombre, tipoDoc, numDoc));
    }

    public Estudiante consultarEstudiante(String tipoDoc, String numDoc) {
        for (Estudiante e : estudiantes) {
            if (e.getTipo_de_documento().equals(tipoDoc) && e.getNumeroDoc().equals(numDoc)) {
                return e;
            }
        }
        return null;
    }

    public boolean modificarEstudiante(String tipoDoc, String numDoc, String nuevoNombre, String nuevoTipoDoc) {
        Estudiante e = consultarEstudiante(tipoDoc, numDoc);
        if (e != null) {
            e.modificarDatos(nuevoNombre, nuevoTipoDoc);
            return true;
        }
        return false;
    }

    public void adicionarAsignatura(String nombre, String codigo, int creditos, String seccion, String semestre) {
        asignaturas.add(new Asignatura(nombre, codigo, creditos, seccion, semestre));
    }

    public Asignatura consultarAsignatura(String codigo, String semestre, String seccion) {
        for (Asignatura a : asignaturas) {
            if (a.getCodigo().equals(codigo) && a.getSemestre().equals(semestre) && a.getSeccion().equals(seccion)) {
                return a;
            }
        }
        return null;
    }

    public boolean modificarAsignatura(String codigo, String semestre, String seccion, String nuevoNombre, int nuevosCreditos) {
        Asignatura a = consultarAsignatura(codigo, semestre, seccion);
        if (a != null) {
            a.setNombre(nuevoNombre);
            a.setCreditos(nuevosCreditos);
            return true;
        }
        return false;
    }

    public boolean registrarEstudianteEnAsignatura(String tipoDoc, String numDoc, String codigo, String semestre, String seccion) {
        Asignatura a = consultarAsignatura(codigo, semestre, seccion);
        if (a != null) {
            a.getTiposDoc().add(tipoDoc);
            a.getNumerosDoc().add(numDoc);
            return true;
        }
        return false;
    }

    public ArrayList<String> consultarEstudiantesAsignatura(String codigo, String semestre, String seccion) {
        Asignatura a = consultarAsignatura(codigo, semestre, seccion);
        ArrayList<String> resultado = new ArrayList<>();
        if (a != null) {
            for (int i = 0; i < a.getTiposDoc().size(); i++) {
                resultado.add(a.getTiposDoc().get(i) + " - " + a.getNumerosDoc().get(i));
            }
        }
        return resultado;
    }

    public boolean crearAsistencia(String codigo, String semestre, String seccion, String fecha, String horaInicio) {
        Asignatura a = consultarAsignatura(codigo, semestre, seccion);
        if (a != null) {
            a.crearAsistencia(fecha, horaInicio);
            return true;
        }
        return false;
    }

    public boolean llenarAsistencia(String codigo, String semestre, String seccion, String fecha, String horaInicio, String tipoDoc, String numDoc, String estado) {
        Asignatura a = consultarAsignatura(codigo, semestre, seccion);
        if (a != null) {
            Asistencia asistencia = a.consultarAsistencia(fecha, horaInicio);
            if (asistencia != null) {
                return asistencia.marcarAsistencia(tipoDoc, numDoc, estado);
            }
        }
        return false;
    }

    public boolean modificarAsistencia(String codigo, String semestre, String seccion, String fecha, String horaInicio, String tipoDoc, String numDoc) {
        return llenarAsistencia(codigo, semestre, seccion, fecha, horaInicio, tipoDoc, numDoc, "llegó tarde");
    }

    public ArrayList<String> listarAsistenciasDetalladas() {
        ArrayList<String> detalles = new ArrayList<>();
        for (Asignatura a : asignaturas) {
            ArrayList<Asistencia> asistencias = a.getAsistencias();
            for (Asistencia asis : asistencias) {
                detalles.addAll(asis.obtenerDetalles());
            }
        }
        return detalles;
    }
}





/**
 public boolean registrarEstudianteEnAsignatura(String tipoDoc, String numDoc, String semestre, String codigo, String seccion) {
 Asignatura asignatura = consultarAsignatura(codigo, semestre, seccion);
 if (asignatura != null) {
 asignatura.adicionarEstudiante(tipoDoc, numDoc);
 return true;
 }
 return false;
 }
 public ArrayList<String> consultarEstudiantesEnAsignatura(String codigo, String semestre, String seccion) {
 Asignatura asignatura = consultarAsignatura(codigo, semestre, seccion);
 if (asignatura != null) {
 return asignatura.obtenerEstudiantesRegistrados();
 }
 return new ArrayList<>();
 }
 *
 * @param codigo
 * @param seccion
 * @param semestre
 * @param fecha
 * @param horaInicio
 * @param tipoDoc
 * @param numDoc
 * @param nuevoEstado
 * @return

public boolean modificarAsistencia(String codigo, String seccion, String semestre,String fecha, String horaInicio, String tipoDoc, String numDoc, String nuevoEstado) {
    Asignatura asignatura = consultarAsignatura(codigo, seccion,semestre);
    if (asignatura != null) {
        return asignatura.modificarAsistencia(fecha, horaInicio, tipoDoc, numDoc, nuevoEstado);
    }
    return false;
}

public ArrayList<String> listarAsistencias(String codigo, String semestre, String seccion, String fecha, String horaInicio) {
    Asignatura asignatura = consultarAsignatura(codigo, semestre, seccion);
    if (asignatura != null) {
        return asignatura.listarAsistencias(fecha, horaInicio);
    }
    return new ArrayList<>();
}
 */






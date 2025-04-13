package Modelo;

import java.util.ArrayList;

public class Asignatura {
    private String nombre = "";
    private String codigo = "";
    private int creditos;
    private String seccion = "";
    private String semestre = "";

    private ArrayList<String> tipoDocumento;
    private ArrayList<String> numeroDocumento;
    private ArrayList<Asistencia> asistencias;

    public Asignatura(String nombre, String codigo, int creditos, String seccion, String semestre) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.seccion = seccion;
        this.semestre = semestre;
        this.tipoDocumento = new ArrayList<>();
        this.numeroDocumento = new ArrayList<>();
        this.asistencias = new ArrayList<>();
    }

    // Getters y setters básicos

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public String getSeccion() {
        return seccion;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    // Métodos requeridos por Departamento:

    public ArrayList<String> getTiposDoc() {
        return tipoDocumento;
    }

    public ArrayList<String> getNumerosDoc() {
        return numeroDocumento;
    }

    public ArrayList<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void crearAsistencia(String fecha, String horaInicio) {
        Asistencia nueva = new Asistencia(codigo, semestre, seccion, fecha, horaInicio, "");
        for (int i = 0; i < numeroDocumento.size(); i++) {
            nueva.adicionarAsistencia(tipoDocumento.get(i), numeroDocumento.get(i), "no asistió");
        }
        asistencias.add(nueva);
    }

    public Asistencia consultarAsistencia(String fecha, String horaInicio) {
        for (Asistencia a : asistencias) {
            if (a.getFecha().equals(fecha) && a.getHora_inicio().equals(horaInicio)) {
                return a;
            }
        }
        return null;
    }
}


/**
 *
 //Adicionar estudiante nuevo
 public boolean adicionarEstudiante(String tipoDoc, String numeroDoc) {
 for (int i = 0; i < tipoDocumento.size(); i++) {
 if (tipoDocumento.get(i).equalsIgnoreCase(tipoDoc) &&
 numeroDocumento.get(i).equalsIgnoreCase(numeroDoc)) {
 return false; // ya existe
 }
 }
 tipoDocumento.add(tipoDoc);
 numeroDocumento.add(numeroDoc);
 return true;
 }
 *
 public boolean adicionarAsistencia(String fecha, String horaInicio, String tipoDoc, String numDoc, int estado) {
 // Este ejemplo solo simula agregar la asistencia a una lista (puedes ajustar según tu lógica)
 String registro = fecha + " " + horaInicio + " - " + tipoDoc + ": " + numDoc + " Estado: " + estado;
 ArrayList<String> nuevaAsistencia = new ArrayList<>();
 nuevaAsistencia.add(registro);
 listaFechas.add(fecha);
 listaAsistencias.add(nuevaAsistencia);
 return true;
 }
 public boolean llenarAsistencia(String fecha, String horaInicio, String tipoDoc, String numeroDoc, int estado) {
 String fechaHora = fecha + " - " + horaInicio;

 int posicionAsistencia = fechas.indexOf(fechaHora);
 if (posicionAsistencia == -1) {
 return false; // No existe esa fecha/hora de asistencia
 }
 // Buscar posición del estudiante
 for (int i = 0; i < tiposDocumento.size(); i++) {
 if (tiposDocumento.get(i).equalsIgnoreCase(tipoDoc) &&
 numerosDocumento.get(i).equalsIgnoreCase(numeroDoc)) {

 asistencias.get(posicionAsistencia).set(i, String.valueOf(estado));
 return true;
 }
 }
 return false; // Estudiante no encontrado
 }
 public boolean modificarAsistencia(String fecha, String horaInicio, String tipoDoc, String numeroDoc) {
 int posicionAsistencia = buscarIndiceAsistencia(fecha, horaInicio);
 if (posicionAsistencia == -1) return false;

 for (int i = 0; i < tiposDocumento.size(); i++) {
 if (tiposDocumento.get(i).equalsIgnoreCase(tipoDoc) &&
 numerosDocumento.get(i).equalsIgnoreCase(numeroDoc)) {
 asistencias.get(posicionAsistencia).set(i, "2"); // llegó tarde
 return true;
 }
 }

 return false;
 }
 //Modificar fecha y hora


 public boolean adicionarAsistencia (String fecha, String hora_inicio, String hora_final, ArrayList<String> codigos,ArrayList<String> estados) {
 Asistencia asistencia = new Asistencia(fecha, hora_inicio, hora_final);
 for (int vc=0; vc <codigos.size(); vc++){
 String codigo = codigos.get(vc);
 String estado = estados.get(vc);
 asistencia.adicionarAsistencia(codigo, estado);
 }
 asistencias.add(asistencia);
 return true;
 }

 public Asistencia consultarAsistencia (String fecha, String hora_inicio, String hora_final) {
 for (int vc=0; vc < asistencias.size(); vc++) {
 if (asistencias.get(vc).getFecha().equalsIgnoreCase(fecha) &&
 asistencias.get(vc).getHora_inicio().equalsIgnoreCase(hora_inicio) &&
 asistencias.get(vc).getHora_final().equalsIgnoreCase(hora_final)) {
 return  asistencias.get(vc);
 }
 }
 return null;
 }
 public  boolean modificarAsistencia (String fecha, String hora_inicio, String hora_final, String fechan, String hora_inicion, String hora_finaln, ArrayList<String> codigos, ArrayList<String> estados) {

 Asistencia laasistencia = this.consultarAsistencia(fecha, hora_inicio, hora_final);
 if (laasistencia != null) {
 laasistencia.setFecha(fechan);
 laasistencia.setHora_inicio(hora_inicion);
 laasistencia.setHora_final(hora_finaln);
 laasistencia.setCodigos(codigos);
 laasistencia.setEstados(estados);
 return true;
 }
 return  false;
 }

 public boolean modificarAsistencia(String fecha, String horaInicio, String tipoDoc, String numeroDoc) {
 String fechaHora = fecha + " - " + horaInicio;
 int indexFecha = fechas.indexOf(fechaHora);

 if (indexFecha == -1) {
 return false;
 }

 for (int i = 0; i < tiposDocumento.size(); i++) {
 if (tiposDocumento.get(i).equalsIgnoreCase(tipoDoc) &&
 numerosDocumento.get(i).equalsIgnoreCase(numeroDoc)) {

 asistencias.get(indexFecha).set(i, "2"); // "2" representa 'Llegó tarde'
 return true;
 }
 }

 return false;
 }

 public boolean adicionarEstudiante(String tipoDoc, String numeroDoc) {
 tiposDocumento.add(tipoDoc);
 numerosDocumento.add(numeroDoc);
 return true;
 }
 public ArrayList<String> obtenerEstudiantesRegistrados() {
 ArrayList<String> lista = new ArrayList<>();
 for (int i = 0; i < tiposDocumento.size(); i++) {
 String info = tiposDocumento.get(i) + " - " + numerosDocumento.get(i);
 lista.add(info);
 }
 return lista;
 }
 public boolean crearAsistenciaVacia(String fecha, String horaInicio) {
 if (tiposDocumento.size() == 0 || numerosDocumento.size() == 0) {
 return false; // No hay estudiantes registrados
 }

 ArrayList<String> nuevaLista = new ArrayList<>();
 for (int i = 0; i < tiposDocumento.size(); i++) {
 nuevaLista.add("no asistió");
 }

 this.fechas.add(fecha + " - " + horaInicio);
 this.asistencias.add(nuevaLista);
 return true;
 }
 public boolean llenarAsistencia(String fecha, String horaInicio, String tipoDoc, String numeroDoc, int estado) {
 String fechaHora = fecha + " - " + horaInicio;

 int indexAsistencia = fechas.indexOf(fechaHora);
 if (indexAsistencia == -1) {
 return false; // No existe esa fecha/hora de asistencia
 }
 // Buscar posición del estudiante
 for (int i = 0; i < tiposDocumento.size(); i++) {
 if (tiposDocumento.get(i).equalsIgnoreCase(tipoDoc) &&
 numerosDocumento.get(i).equalsIgnoreCase(numeroDoc)) {

 asistencias.get(indexAsistencia).set(i, String.valueOf(estado));
 return true;
 }
 }
 return false; // Estudiante no encontrado
 }
 public String listarAsistencias() {
 String resultado = "";

 for (int i = 0; i < fechasAsistencia.size(); i++) {
 String fecha = fechasAsistencia.get(i);
 String hora = horasAsistencia.get(i);

 resultado += "Fecha: " + fecha +
 " | Hora: " + hora +
 " | Código: " + codigo +
 " | Semestre: " + semestre +
 " | Sección: " + seccion + "\n";
 resultado += "Estudiantes:\n";

 ArrayList<String> tipoEstudiante = tipoDocumentoEstudiantes;
 ArrayList<String> docEstudiante = numeroDocumentoEstudiantes;
 ArrayList<String> asistenciasEnEstaFecha = asistencias.get(i);

 for (int j = 0; j < docEstudiante.size(); j++) {
 resultado += "Tipo: " + tipoEstudiante.get(j) +
 " | Documento: " + docEstudiante.get(j) +
 " | Estado: " + asistenciasEnEstaFecha.get(j) + "\n";
 }


 */

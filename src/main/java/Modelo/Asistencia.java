package Modelo;

import java.util.ArrayList;

public class Asistencia {
    private String codigo;
    private String semestre;
    private String seccion;
    private String fecha;
    private String hora_inicio;

    private ArrayList<String> tipoDocumento;
    private ArrayList<String> numeroDocumento;
    private ArrayList<String> estado;

    public Asistencia(String codigo, String semestre, String seccion, String fecha, String hora_inicio, String observacion) {
        this.codigo = codigo;
        this.semestre = semestre;
        this.seccion = seccion;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.tipoDocumento = new ArrayList<>();
        this.numeroDocumento = new ArrayList<>();
        this.estado = new ArrayList<>();
    }

    // Adicionar asistencia por estudiante
    public void adicionarAsistencia(String tipo, String numero, String estado) {
        this.tipoDocumento.add(tipo);
        this.numeroDocumento.add(numero);
        this.estado.add(estado);
    }

    // Modificar asistencia por tipo y número de documento
    public boolean marcarAsistencia(String tipoDoc, String numDoc, String nuevoEstado) {
        for (int i = 0; i < tipoDocumento.size(); i++) {
            if (tipoDocumento.get(i).equals(tipoDoc) && numeroDocumento.get(i).equals(numDoc)) {
                this.estado.set( i, nuevoEstado);
                return true;
            }
        }
        return false;
    }

    // Obtener detalles para mostrar
    public ArrayList<String> obtenerDetalles() {
        ArrayList<String> detalles = new ArrayList<>();
        for (int i = 0; i < numeroDocumento.size(); i++) {
            String linea = "Código: " + codigo +
                    " | Semestre: " + semestre +
                    " | Sección: " + seccion +
                    " | Fecha: " + fecha +
                    " | Hora: " + hora_inicio +
                    " | Tipo: " + tipoDocumento.get(i) +
                    " | Número: " + numeroDocumento.get(i) +
                    " | Estado: " + estado.get(i);
            detalles.add(linea);
        }
        return detalles;
    }

    // Getters
    public String getFecha() {
        return fecha;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getSeccion() {
        return seccion;
    }
}





package Modelo;

public class Estudiante {

    private String nombre_completo = "";
    private String numeroDoc = "";
    private String tipo_de_documento = "";

    public Estudiante() {
    }

    public Estudiante(String nombre_completo, String tipo_de_documento, String numeroDoc) {
        this.nombre_completo = nombre_completo;
        this.tipo_de_documento = tipo_de_documento;
        this.numeroDoc = numeroDoc;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getTipo_de_documento() {
        return tipo_de_documento;
    }

    public void setTipo_de_documento(String tipo_de_documento) {
        this.tipo_de_documento = tipo_de_documento;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public void modificarDatos(String nuevoNombre, String nuevoTipoDoc) {
        this.nombre_completo = nuevoNombre;
        this.tipo_de_documento = nuevoTipoDoc;
    }
}


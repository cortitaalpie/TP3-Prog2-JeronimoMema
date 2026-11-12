package ej4;

public class contacto {

    private String nombre;
    private int telef;
    private String apellido;
    private int telfonolinea;
    private int telfonotrabajo;
    private String mail;
    private String relacion;

    public contacto(String nombre, int telef, String apellido, int telfonolinea, int telfonotrabajo, String mail, String relacion) {
        this.nombre = nombre;
        this.telef = telef;
        this.apellido = apellido;
        this.telfonolinea = telfonolinea;
        this.telfonotrabajo = telfonotrabajo;
        this.mail = mail;
        this.relacion = relacion;
    }

    public contacto() {
        this.nombre = "";
        this.nombre = "";
        this.telef = 0;
        this.apellido = "";
        this.telfonolinea = 0;
        this.telfonotrabajo = 0;
        this.mail = "";
        this.relacion = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelef() {
        return telef;
    }

    public void setTelef(int telef) {
        this.telef = telef;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelfonolinea() {
        return telfonolinea;
    }

    public void setTelfonolinea(int telfonolinea) {
        this.telfonolinea = telfonolinea;
    }

    public int getTelfonotrabajo() {
        return telfonotrabajo;
    }

    public void setTelfonotrabajo(int telfonotrabajo) {
        this.telfonotrabajo = telfonotrabajo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }
}

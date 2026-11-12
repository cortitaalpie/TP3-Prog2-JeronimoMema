package ej5;

import java.io.Serializable;

public class Cliente implements Serializable {

    private int codigo;
    private int dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;

    public Cliente(int codigo, int dni, String nombre, String apellido, String direccion, String telefono) {
        this.codigo = codigo;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Cliente() {
        this.codigo = 0;
        this.dni = 0;
        this.nombre = "";
        this.apellido = "";
        this.direccion = "";
        this.telefono = "";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

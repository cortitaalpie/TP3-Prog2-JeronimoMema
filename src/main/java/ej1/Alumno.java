package ej1;

public class Alumno {

    private String nombre;
    private double nota;

    public Alumno(String nombre, double nota){
        this.nota = nota;
        this.nombre = nombre;
    }

    public Alumno(){
        this.nombre = "";
        this.nota = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}

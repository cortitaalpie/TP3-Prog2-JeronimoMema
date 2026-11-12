package ej5;

import java.io.Serializable;

public class Auto implements Serializable {

    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private int plazas;

    public Auto(String matricula, String marca, String modelo, String color, int plazas) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.plazas = plazas;
    }

    public Auto() {
        this.matricula = "";
        this.marca = "";
        this.modelo = "";
        this.color = "";
        this.plazas = 0;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }
}

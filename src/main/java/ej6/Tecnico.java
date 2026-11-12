package ej6;

import java.util.ArrayList;

public class Tecnico extends Libro {

    private String area;

    public Tecnico(String titulo, ArrayList<String> autores, String editorial, int anioEdicion, String formato, String isbn, int stock, String area) {
        super(titulo, autores, editorial, anioEdicion, formato, isbn, stock);
        this.area = area;
    }

    public Tecnico() {
        super();
        this.area = "";
    }

    @Override
    public String getClasificacion() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}

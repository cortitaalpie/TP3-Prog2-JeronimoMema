package ej6;

import java.util.ArrayList;

public class Novela extends Libro {

    private String clasificacion;

    public Novela(String titulo, ArrayList<String> autores, String editorial, int anioEdicion, String formato, String isbn, int stock, String clasificacion) {
        super(titulo, autores, editorial, anioEdicion, formato, isbn, stock);
        this.clasificacion = clasificacion;
    }

    public Novela() {
        super();
        this.clasificacion = "";
    }

    @Override
    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
}

package ej6;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Libro implements Serializable {

    private String titulo;
    private ArrayList<String> autores;
    private String editorial;
    private int anioEdicion;
    private String formato;
    private String isbn;
    private ArrayList<String> capitulos;
    private int stock;

    public Libro(String titulo, ArrayList<String> autores, String editorial, int anioEdicion, String formato, String isbn, int stock) {
        this.titulo = titulo;
        this.autores = autores;
        this.editorial = editorial;
        this.anioEdicion = anioEdicion;
        this.formato = formato;
        this.isbn = isbn;
        this.capitulos = new ArrayList<>();
        this.stock = stock;
    }

    public Libro() {
        this.titulo = "";
        this.autores = new ArrayList<>();
        this.editorial = "";
        this.anioEdicion = 0;
        this.formato = "";
        this.isbn = "";
        this.capitulos = new ArrayList<>();
        this.stock = 0;
    }

    public void agregarCapitulo(String capitulo) {
        this.capitulos.add(capitulo);
    }

    public boolean vender() {
        if (stock > 0) {
            stock--;
            return true;
        }
        return false;
    }

    public abstract String getClasificacion();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnioEdicion() {
        return anioEdicion;
    }

    public void setAnioEdicion(int anioEdicion) {
        this.anioEdicion = anioEdicion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public ArrayList<String> getCapitulos() {
        return capitulos;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

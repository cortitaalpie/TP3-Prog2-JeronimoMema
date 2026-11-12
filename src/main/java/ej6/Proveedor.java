package ej6;

import java.io.Serializable;
import java.util.ArrayList;

public class Proveedor implements Serializable {

    private String nombre;
    private ArrayList<String> editoriales;

    public Proveedor(String nombre, ArrayList<String> editoriales) {
        this.nombre = nombre;
        this.editoriales = editoriales;
    }

    public Proveedor() {
        this.nombre = "";
        this.editoriales = new ArrayList<>();
    }

    public boolean representaEditorial(String editorial) {
        for (String e : editoriales) {
            if (e.equalsIgnoreCase(editorial)) {
                return true;
            }
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getEditoriales() {
        return editoriales;
    }

    public void setEditoriales(ArrayList<String> editoriales) {
        this.editoriales = editoriales;
    }
}

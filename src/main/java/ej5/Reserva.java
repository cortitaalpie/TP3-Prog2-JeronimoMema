package ej5;

import java.io.Serializable;
import java.util.ArrayList;

public class Reserva implements Serializable {

    private Cliente cliente;
    private ArrayList<Auto> autos;
    private ArrayList<Double> precios;
    private String fechaInicio;
    private String fechaFin;
    private boolean entregado;

    public Reserva(Cliente cliente, String fechaInicio, String fechaFin) {
        this.cliente = cliente;
        this.autos = new ArrayList<>();
        this.precios = new ArrayList<>();
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.entregado = false;
    }

    public Reserva() {
        this.cliente = null;
        this.autos = new ArrayList<>();
        this.precios = new ArrayList<>();
        this.fechaInicio = "";
        this.fechaFin = "";
        this.entregado = false;
    }

    public void agregarAuto(Auto auto, double precio) {
        this.autos.add(auto);
        this.precios.add(precio);
    }

    public double getPrecioTotal() {
        double total = 0;
        for (Double precio : precios) {
            total += precio;
        }
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Auto> getAutos() {
        return autos;
    }

    public ArrayList<Double> getPrecios() {
        return precios;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }
}

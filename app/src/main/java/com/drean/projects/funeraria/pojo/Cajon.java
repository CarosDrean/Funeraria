package com.drean.projects.funeraria.pojo;

public class Cajon {
    private String cajon;
    private int fondo;
    private double precio;
    private String descripcion;

    public Cajon(String cajon, int fondo, double precio, String descripcion) {
        this.cajon = cajon;
        this.fondo = fondo;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getCajon() {
        return cajon;
    }

    public void setCajon(String cajon) {
        this.cajon = cajon;
    }

    public int getFondo() {
        return fondo;
    }

    public void setFondo(int fondo) {
        this.fondo = fondo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

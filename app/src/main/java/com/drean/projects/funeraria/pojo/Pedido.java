package com.drean.projects.funeraria.pojo;

public class Pedido {
    private int id;
    private String cajon;
    private String cajonimg;
    private String nombre;
    private int dni;
    private int celular;
    private String email;
    private int cantidad;
    private double precioUnidad;
    private double igv;
    private String fecha;
    private String hora;
    private double total;

    public Pedido() {
    }

    public Pedido(int id, String cajon, String cajonimg, String nombre, int dni, int celular, String email, int cantidad, double precioUnidad, double igv, String fecha, String hora, double total) {
        this.id = id;
        this.cajon = cajon;
        this.cajonimg = cajonimg;
        this.nombre = nombre;
        this.dni = dni;
        this.celular = celular;
        this.email = email;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.igv = igv;
        this.fecha = fecha;
        this.hora = hora;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCajon() {
        return cajon;
    }

    public void setCajon(String cajon) {
        this.cajon = cajon;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCajonimg() {
        return cajonimg;
    }

    public void setCajonimg(String cajonimg) {
        this.cajonimg = cajonimg;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

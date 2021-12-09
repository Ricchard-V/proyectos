package com.cuenta.conmigo;

public class GastosVo {
    private String id;
    private String nombre;
    private String descripcion;
    private String fecha;
    private  int foto;
    private double valor;

    public GastosVo(String id, String nombre, String descripcion, String fecha, int foto, double valor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.foto = foto;
        this.valor = valor;
    }

    public GastosVo(){

    }
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getValor() {
        return Double.toString(valor);
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

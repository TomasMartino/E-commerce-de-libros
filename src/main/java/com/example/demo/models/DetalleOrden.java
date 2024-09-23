package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "detalles")
public class DetalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private double cantidad;
    private double precio;
    private double total;

    /*relacion con Orden*/
    @OneToOne
    private Orden orden;
    /*relacion con Producto-en producto no hace falta hacer la relacion porque no es nesesario saber el detalle de la orden, por eso no se hace un capo de eso */
    @ManyToOne
    private Producto producto;

    public DetalleOrden() {
    }

    public DetalleOrden(long id, String nombre, double cantidad, double precio, double total, Orden orden, Producto producto) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.orden = orden;
        this.producto = producto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}

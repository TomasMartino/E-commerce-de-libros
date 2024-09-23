package com.example.demo.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ordenes")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;
    private double total;
    /*relacion con usuario*/
    @ManyToOne
    private UserEntity usuario;
    /*relacion con DetalleOrden*/
    @OneToOne(mappedBy = "orden")
    private DetalleOrden detalle;

    public Orden() {
    }

    public Orden(long id, String numero, Date fechaCreacion, Date fechaRecibida, double total, UserEntity usuario, DetalleOrden detalle) {
        Id = id;
        this.numero = numero;
        this.fechaCreacion = fechaCreacion;
        this.fechaRecibida = fechaRecibida;
        this.total = total;
        this.usuario = usuario;
        this.detalle = detalle;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaRecibida() {
        return fechaRecibida;
    }

    public void setFechaRecibida(Date fechaRecibida) {
        this.fechaRecibida = fechaRecibida;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public UserEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UserEntity usuario) {
        this.usuario = usuario;
    }

    public DetalleOrden getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleOrden detalle) {
        this.detalle = detalle;
    }
}

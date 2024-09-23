package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String autor;
    private String publicacion;
    private String genero;
    private String sinopsis;
    private String imagen;
    private String precio;
    private String cantidad;

    /*relacion con usuario*/
    @ManyToOne
    private UserEntity usuario;

    public Producto() {
    }

    public Producto(long id, String titulo, String autor, String publicacion, String genero, String sinopsis, String imagen, String precio, String cantidad, UserEntity usuario) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.publicacion = publicacion;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.imagen = imagen;
        this.precio = precio;
        this.cantidad = cantidad;
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public UserEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UserEntity usuario) {
        this.usuario = usuario;
    }
}

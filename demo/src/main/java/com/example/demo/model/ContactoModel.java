package com.example.demo.model;

public class ContactoModel {
    private String nombre;
    private String correo;
    private String numero;
    private String comentario;

    public ContactoModel(String nombre, String correo, String numero, String comentario) {
        this.nombre = nombre;
        this.correo = correo;
        this.numero = numero;
        this.comentario = comentario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}

package com.example.projecttesisii;

public class Producto {
    private String nombre;
    private String precio;
    private String precioOferta;
    private String url;
    private String categoriaId;

    public Producto(){
    }

    public Producto(String nombre, String precio, String precioOferta, String url, String categoriaId) {
        this.nombre = nombre;
        this.precio = precio;
        this.precioOferta = precioOferta;
        this.url = url;
        this.categoriaId = categoriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public String getPrecioOferta() {
        return precioOferta;
    }

    public String getUrl() {
        return url;
    }

    public String getCategoriaId() {
        return categoriaId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setPrecioOferta(String precioOferta) {
        this.precioOferta = precioOferta;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCategoriaId(String categoriaId) {
        this.categoriaId = categoriaId;
    }
}

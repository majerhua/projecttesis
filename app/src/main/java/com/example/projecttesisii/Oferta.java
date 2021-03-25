package com.example.projecttesisii;

import java.util.List;

public class Oferta {
    private List<Categoria> listCategoria;

    public Oferta(List<Categoria> listCategoria){
        this.listCategoria = listCategoria;
    }

    public void setListCategoria(List<Categoria> listCategoria) {
        this.listCategoria = listCategoria;
    }

    public List<Categoria> getListCategoria() {
        return listCategoria;
    }
}


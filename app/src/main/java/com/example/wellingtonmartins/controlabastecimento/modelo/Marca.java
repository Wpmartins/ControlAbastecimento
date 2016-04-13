package com.example.wellingtonmartins.controlabastecimento.modelo;

import java.io.Serializable;

/**
 * Created by Wellington Martins on 04/04/2016.
 */
public class Marca implements Serializable{
    private int idMarca;
    private String dsMarca;

    public int Marca() {
        return idMarca;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getDsMarca() {
        return dsMarca;
    }

    public void setDsMarca(String dsMarca) {
        this.dsMarca = dsMarca;
    }

    @Override
    public String toString() {
        return "{"+getIdMarca()+"} "+getDsMarca();
    }
}

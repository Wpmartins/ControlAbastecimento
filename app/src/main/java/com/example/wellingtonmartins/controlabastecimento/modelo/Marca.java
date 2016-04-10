package com.example.wellingtonmartins.controlabastecimento.modelo;

/**
 * Created by Wellington Martins on 04/04/2016.
 */
public class Marca {
    private static int id;
    private static String marca;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Marca.id = id;
    }

    public static String getMarca() {
        return marca;
    }

    public static void setMarca(String marca) {
        Marca.marca = marca;
    }

    @Override
    public String toString() {
        return this.getMarca();
    }
}

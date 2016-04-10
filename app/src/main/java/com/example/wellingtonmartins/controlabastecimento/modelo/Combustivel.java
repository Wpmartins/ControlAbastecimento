package com.example.wellingtonmartins.controlabastecimento.modelo;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Wellington Martins on 04/04/2016.
 */
public enum Combustivel {

    GASOLINA(1), ETANOL(2), DIESEL(3);

    private int id;
    private static Map<Integer, Combustivel> combustiveis;

    static {
        combustiveis = new TreeMap<>();
        for (Combustivel comb : Combustivel.values())combustiveis.put(comb.getId(), comb);
    }

    private Combustivel(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Map<Integer, Combustivel> getCombustiveis(){
        return combustiveis;
    }
}

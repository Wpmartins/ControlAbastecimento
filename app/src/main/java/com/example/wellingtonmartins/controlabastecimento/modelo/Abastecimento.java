package com.example.wellingtonmartins.controlabastecimento.modelo;

import java.util.Date;

/**
 * Created by Wellington Martins on 04/04/2016.
 */
public class Abastecimento {

    private static int id;
    private static int idVeiculo;
    private static String veiculo;
    private static Date data;
    private static double qtde;
    private static double valorTotal;
    private static double kmAtual;
    private Combustivel combustivel;
    private static String posto;

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Abastecimento.id = id;
    }

    public static Date getData() {
        return data;
    }

    public static void setData(Date data) {
        Abastecimento.data = data;
    }

    public static double getQtde() {
        return qtde;
    }

    public static void setQtde(double qtde) {
        Abastecimento.qtde = qtde;
    }

    public static double getValorTotal() {
        return valorTotal;
    }

    public static void setValorTotal(double valorTotal) {
        Abastecimento.valorTotal = valorTotal;
    }

    public static double getKmAtual() {
        return kmAtual;
    }

    public static void setKmAtual(double kmAtual) {
        Abastecimento.kmAtual = kmAtual;
    }

    public static String getPosto() {
        return posto;
    }

    public static void setPosto(String posto) {
        Abastecimento.posto = posto;
    }

    public static int getIdVeiculo() {
        return idVeiculo;
    }

    public static void setIdVeiculo(int idVeiculo) {
        Abastecimento.idVeiculo = idVeiculo;
    }

    public static String getVeiculo() {
        return veiculo;
    }

    public static void setVeiculo(String veiculo) {
        Abastecimento.veiculo = veiculo;
    }
}

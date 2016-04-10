package com.example.wellingtonmartins.controlabastecimento.modelo;

/**
 * Created by Wellington Martins on 04/04/2016.
 */
public class Veiculo {

    private static int id;
    private static String descricao;
    private static String modelo;
    private static int idmarca;
    private static String marca;
    private static String placa;
    private static double kmInicial;
    private static int capacidade;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Veiculo.id = id;
    }

    public static String getDescricao() {
        return descricao;
    }

    public static void setDescricao(String descricao) {
        Veiculo.descricao = descricao;
    }

    public static String getModelo() {
        return modelo;
    }

    public static void setModelo(String modelo) {
        Veiculo.modelo = modelo;
    }

    public static int getIdmarca() {
        return idmarca;
    }

    public static void setIdmarca(int idmarca) {
        Veiculo.idmarca = idmarca;
    }

    public static String getMarca() {
        return marca;
    }

    public static void setMarca(String marca) {
        Veiculo.marca = marca;
    }

    public static String getPlaca() {
        return placa;
    }

    public static void setPlaca(String placa) {
        Veiculo.placa = placa;
    }

    public static Double getKmInicial() {
        return kmInicial;
    }

    public static void setKmInicial(Double kmInicial) {
        Veiculo.kmInicial = kmInicial;
    }

    public static int getCapacidade() {
        return capacidade;
    }

    public static void setCapacidade(int capacidade) {
        Veiculo.capacidade = capacidade;
    }
}

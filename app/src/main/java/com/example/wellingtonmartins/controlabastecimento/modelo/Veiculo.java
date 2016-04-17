package com.example.wellingtonmartins.controlabastecimento.modelo;

import java.io.Serializable;

/**
 * Created by Wellington Martins on 04/04/2016.
 */
public class Veiculo implements Serializable{

    private int idVeiculo;
    private String descricao;
    private String modelo;
    private int idmarca;
    private String marca;
    private String placa;
    private double kmInicial;
    private int capacidade;
    private Boolean insert;

    public int Veiculo() {
        return idVeiculo;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(double kmInicial) {
        this.kmInicial = kmInicial;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Boolean getInsert() {
        return insert;
    }

    public void setInsert(Boolean insert) {
        this.insert = insert;
    }

    @Override
    public String toString() {
        return "{"+getIdVeiculo()+"} "+getDescricao()+" Código Marca:"+getIdmarca()+" " +
                "Modelo:"+getModelo()+" Placa:"+getPlaca()+" Km:"+getKmInicial()+" Capacidade:"+getCapacidade();
    }
}

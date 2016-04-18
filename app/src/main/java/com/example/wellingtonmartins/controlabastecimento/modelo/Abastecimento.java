package com.example.wellingtonmartins.controlabastecimento.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Wellington Martins on 04/04/2016.
 */
public class Abastecimento implements Serializable {

    private int idAbastecimento;
    private int idVeiculo;
    private String veiculo;
    private String data;
    private double qtde;
    private double valorTotal;
    private double kmAtual;
    private String combustivel;
    private String posto;

    private double valorLitro;
    private double media;

    public int Abastecimento() {
        return idAbastecimento;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public int getIdAbastecimento() {
        return idAbastecimento;
    }

    public void setIdAbastecimento(int idAbastecimento) {
        this.idAbastecimento = idAbastecimento;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getQtde() {
        return qtde;
    }

    public void setQtde(double qtde) {
        this.qtde = qtde;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getKmAtual() {
        return kmAtual;
    }

    public void setKmAtual(double kmAtual) {
        this.kmAtual = kmAtual;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public double getValorLitro() {
        return valorLitro;
    }

    public void setValorLitro(double valorLitro) {
        this.valorLitro = valorLitro;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "Código Abastecimento: "+getIdAbastecimento()
                +"\nVeículo: "+getVeiculo()
                +"\nData: "+getData()
                +"\nCombustivel: "+getCombustivel()
                +"\nQtde: "+getQtde()
                +"\nValor Abastecido: "+getValorTotal()
                +"\nValor do Litro: "+getValorLitro()
                +"\nMédia: "+getMedia();
    }
}

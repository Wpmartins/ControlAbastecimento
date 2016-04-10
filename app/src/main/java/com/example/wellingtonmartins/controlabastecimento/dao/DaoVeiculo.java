package com.example.wellingtonmartins.controlabastecimento.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.wellingtonmartins.controlabastecimento.banco.CriarBanco;
import com.example.wellingtonmartins.controlabastecimento.modelo.Veiculo;

/**
 * Created by Wellington Martins on 04/04/2016.
 */
public class DaoVeiculo {
    private SQLiteDatabase db;
    private CriarBanco banco;

    public DaoVeiculo(Context baseContext){banco = new CriarBanco(baseContext);}

    public void inserir(Veiculo obj){

        ContentValues valores;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarBanco.DESCRICAO, obj.getDescricao());
        valores.put(CriarBanco.MARCA, obj.getMarca());
        valores.put(CriarBanco.MODELO, obj.getModelo());
        valores.put(CriarBanco.PLACA, obj.getPlaca());
        valores.put(CriarBanco.KMINICIAL, obj.getKmInicial());
        valores.put(CriarBanco.CAPACIDADE, obj.getCapacidade());

        db.insert(CriarBanco.TABELAVEICULO, null, valores);
        db.close();

    }
}

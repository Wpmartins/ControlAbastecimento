package com.example.wellingtonmartins.controlabastecimento.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.wellingtonmartins.controlabastecimento.banco.CriarBanco;
import com.example.wellingtonmartins.controlabastecimento.modelo.Abastecimento;

/**
 * Created by Wellington Martins on 04/04/2016.
 */
public class DaoMovAbastecimento {
    private SQLiteDatabase db;
    private CriarBanco banco;

    public DaoMovAbastecimento(Context baseContext) {
        banco = new CriarBanco(baseContext);
    }

    public void inserir(Abastecimento obj){
        ContentValues valores;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarBanco.DATA, obj.getData().getDate());
        valores.put(CriarBanco.QTDE, obj.getQtde());
        valores.put(CriarBanco.VALORTOTAL, obj.getValorTotal());
        valores.put(CriarBanco.KMATUAL, obj.getKmAtual());
        valores.put(CriarBanco.TIPOCOMBUSTIVEL, obj.getCombustivel().getId());
        valores.put(CriarBanco.POSTO, obj.getPosto());

        db.insert(CriarBanco.CONTROLE_ABASTECIMENTO, null, valores);
        db.close();
    }
}

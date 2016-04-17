package com.example.wellingtonmartins.controlabastecimento.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.wellingtonmartins.controlabastecimento.banco.CriarBanco;
import com.example.wellingtonmartins.controlabastecimento.modelo.Abastecimento;
import com.example.wellingtonmartins.controlabastecimento.modelo.Combustivel;

/**
 * Created by Wellington Martins on 04/04/2016.
 */
public class DaoMovAbastecimento {
    private SQLiteDatabase db;
    private CriarBanco banco;

    public DaoMovAbastecimento(Context baseContext) {
        banco = new CriarBanco(baseContext);
    }

    public String inserir(Abastecimento obj){
        ContentValues valores;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarBanco.DATA, obj.getData());
        valores.put(CriarBanco.QTDE, obj.getQtde());
        valores.put(CriarBanco.VALORTOTAL, obj.getValorTotal());
        valores.put(CriarBanco.KMATUAL, obj.getKmAtual());
        valores.put(CriarBanco.TIPOCOMBUSTIVEL, obj.getCombustivel());
        valores.put(CriarBanco.POSTO, obj.getPosto());

        db.insert(CriarBanco.CONTROLE_ABASTECIMENTO, null, valores);
        db.close();

        return "Registro Salvo  "+obj.getCombustivel();
    }
}

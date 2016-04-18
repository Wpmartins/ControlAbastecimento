package com.example.wellingtonmartins.controlabastecimento.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.wellingtonmartins.controlabastecimento.banco.CriarBanco;
import com.example.wellingtonmartins.controlabastecimento.modelo.Abastecimento;
import com.example.wellingtonmartins.controlabastecimento.modelo.Combustivel;
import com.example.wellingtonmartins.controlabastecimento.modelo.Veiculo;

import java.util.ArrayList;
import java.util.List;

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
        valores.put(CriarBanco.IDVEICULO, obj.getIdVeiculo());
        valores.put(CriarBanco.DATA, obj.getData());
        valores.put(CriarBanco.QTDE, obj.getQtde());
        valores.put(CriarBanco.VALORTOTAL, obj.getValorTotal());
        valores.put(CriarBanco.KMATUAL, obj.getKmAtual());
        valores.put(CriarBanco.TIPOCOMBUSTIVEL, obj.getCombustivel());
        valores.put(CriarBanco.POSTO, obj.getPosto());

        db.insert(CriarBanco.TABELAABASTECIMENTO, null, valores);
        db.close();

        return "Registro Salvo  "+obj.getCombustivel();
    }

    public List<Abastecimento> listarAbastecimentos(int codigo) {
        Cursor cursor;

        String[] campos = {"idabastecimento","abastecimentos.idveiculo","dsveiculo", "data", "qtde","valortotal","kmatual","tipocombustivel"};
        db = banco.getReadableDatabase();
        cursor = db.query("abastecimentos inner join veiculos on veiculos.idveiculo = abastecimentos.idveiculo",
                campos,"abastecimentos.idveiculo = "+codigo,null, null, null, "data");


        List<Abastecimento> abastecimentos = new ArrayList<>();
        while (cursor.moveToNext()){

            Abastecimento obj = new Abastecimento();
            obj.setIdAbastecimento(cursor.getInt(0));
            obj.setVeiculo(cursor.getString(2));
            obj.setData(cursor.getString(3));
            obj.setQtde(cursor.getDouble(4));
            obj.setValorTotal(cursor.getDouble(5));
            obj.setKmAtual(cursor.getDouble(6));
            obj.setCombustivel(cursor.getString(7));

            abastecimentos.add(obj);
        }
        db.close();

        return abastecimentos;
    }
}

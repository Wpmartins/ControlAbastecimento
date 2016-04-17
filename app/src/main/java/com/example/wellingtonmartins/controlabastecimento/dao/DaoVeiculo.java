package com.example.wellingtonmartins.controlabastecimento.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.wellingtonmartins.controlabastecimento.banco.CriarBanco;
import com.example.wellingtonmartins.controlabastecimento.modelo.Veiculo;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_LONG;

/**
 * Created by Wellington Martins on 04/04/2016.
 */
public class DaoVeiculo {
    private SQLiteDatabase db;
    private CriarBanco banco;

    public DaoVeiculo(Context baseContext){banco = new CriarBanco(baseContext);}

    public String inserir(Veiculo obj){

        ContentValues valores;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarBanco.DESCRICAO, obj.getDescricao());
        valores.put(CriarBanco.IDMARCA, obj.getIdmarca());
        valores.put(CriarBanco.MODELO, obj.getModelo());
        valores.put(CriarBanco.PLACA, obj.getPlaca());
        valores.put(CriarBanco.KMINICIAL, obj.getKmInicial());
        valores.put(CriarBanco.CAPACIDADE, obj.getCapacidade());

        db.insert(CriarBanco.TABELAVEICULO, null, valores);

        db.close();
        return "Veículo salvo com sucesso!";
    }

    public String alterar(Veiculo obj) {
        ContentValues valores;

        db = banco.getWritableDatabase();
        valores = new ContentValues();

        valores.put(CriarBanco.DESCRICAO, obj.getDescricao());
        valores.put(CriarBanco.IDMARCA, obj.getIdmarca());
        valores.put(CriarBanco.MODELO, obj.getModelo());
        valores.put(CriarBanco.PLACA, obj.getPlaca());
        valores.put(CriarBanco.KMINICIAL, obj.getKmInicial());
        valores.put(CriarBanco.CAPACIDADE, obj.getCapacidade());

        db.update(CriarBanco.TABELAVEICULO, valores, CriarBanco.IDVEICULO + "=" + obj.getIdVeiculo(), null);

        db.close();

        return "Veículo alterado!";
    }

    public String excluir(Veiculo obj){

        db = banco.getWritableDatabase();
        db.delete(CriarBanco.TABELAVEICULO, CriarBanco.IDVEICULO + "=" + obj.getIdVeiculo(), null);

        return "Veículo excluido!";

    }

    public List<Veiculo> listarVeiculos() {
        Cursor cursor;

        String[] campos = {"idveiculo", "dsveiculo","idmarca","modelo","placa","kminicial","capacidade"};
        db = banco.getReadableDatabase();
        cursor = db.query("veiculos", campos, null, null, null, null, null);


        List<Veiculo> veiculos = new ArrayList<>();
        while (cursor.moveToNext()){
            Veiculo obj = new Veiculo();

            obj.setIdVeiculo(cursor.getInt(0));
            obj.setDescricao(cursor.getString(1));
            obj.setIdmarca(cursor.getInt(2));
            obj.setModelo(cursor.getString(3));
            obj.setPlaca(cursor.getString(4));
            obj.setKmInicial(cursor.getDouble(5));
            obj.setCapacidade(cursor.getInt(6));

            veiculos.add(obj);
        }
        db.close();

        return veiculos;
    }

    public List<Veiculo> listarInformacoes() {
        Cursor cursor;

        String sql = "SELECT ";
        String[] campos = {"idveiculo", "dsveiculo","idmarca","modelo","placa","kminicial","capacidade"};
        db = banco.getReadableDatabase();
        cursor = db.query("veiculos", campos, null, null, null, null, null);


        List<Veiculo> veiculos = new ArrayList<>();
        while (cursor.moveToNext()){
            Veiculo obj = new Veiculo();

            obj.setIdVeiculo(cursor.getInt(0));
            obj.setDescricao(cursor.getString(1));
            obj.setIdmarca(cursor.getInt(2));
            obj.setModelo(cursor.getString(3));
            obj.setPlaca(cursor.getString(4));
            obj.setKmInicial(cursor.getDouble(5));
            obj.setCapacidade(cursor.getInt(6));

            veiculos.add(obj);
        }
        db.close();

        return veiculos;
    }

}

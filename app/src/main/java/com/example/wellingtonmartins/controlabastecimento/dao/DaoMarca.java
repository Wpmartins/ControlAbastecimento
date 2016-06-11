package com.example.wellingtonmartins.controlabastecimento.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wellingtonmartins.controlabastecimento.banco.CriarBanco;
import com.example.wellingtonmartins.controlabastecimento.modelo.Marca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wellington Martins on 06/04/2016.
 */
public class DaoMarca {

    private SQLiteDatabase db;
    private CriarBanco banco;

    public DaoMarca(Context baseContext){
        banco = new CriarBanco(baseContext);
    }

    public List<Marca> listar(Marca obj){
        Cursor cursor;

        String[] campos = {"idmarca", "dsmarca"};
        db = banco.getReadableDatabase();

        cursor = db.query("marcas", campos, null, null, null, null, null);

        List<Marca> listaMarca = new ArrayList<>();
        while (cursor.moveToNext()) {

            obj.setIdMarca(cursor.getInt(0));
            obj.setDsMarca(cursor.getString(1));

            listaMarca.add(obj);
        }
        cursor.close();

        return listaMarca;
    }
}

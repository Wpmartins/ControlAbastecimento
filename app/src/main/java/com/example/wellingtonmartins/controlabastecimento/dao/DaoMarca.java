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

    public List<Marca> listar(){
        Cursor cursor;

        String[] campos = {"id", "marca"};
        db = banco.getReadableDatabase();

        cursor = db.query("marcas", campos, null, null, null, null, null);

        List<Marca> listaMarca = new ArrayList<>();
        while (cursor.moveToNext()) {

            Marca marca = new Marca();

            marca.setId(cursor.getInt(0));
            marca.setMarca(cursor.getString(1));

            listaMarca.add(marca);
        }
        cursor.close();

        return listaMarca;
    }
}

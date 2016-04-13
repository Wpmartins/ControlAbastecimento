package com.example.wellingtonmartins.controlabastecimento.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wellington Martins on 04/04/2016.
 */
public class CriarBanco extends SQLiteOpenHelper {

    public static final String CONTROLE_ABASTECIMENTO = "banco.db";

    public static final String TABELAVEICULO = "veiculos";
    public static final String IDVEICULO = "idveiculo";
    public static final String DESCRICAO = "dsveiculo";
    public static final String MODELO = "modelo";
    public static final String PLACA = "placa";
    public static final String KMINICIAL = "kminicial";
    public static final String CAPACIDADE = "capacidade";

    public static final String TABELAMARCA = "marcas";
    public static final String IDMARCA = "idmarca";
    public static final String MARCA = "dsmarca";

    public static final String TABELAABASTECIMENTO = "abastecimentos";
    public static final String IDABASTECIMENTO = "idabastecimento";
    public static final String DATA = "data";
    public static final String QTDE = "qtde";
    public static final String VALORTOTAL = "valortotal";
    public static final String KMATUAL = "kmatual";
    public static final String TIPOCOMBUSTIVEL  = "tipocombustivel";
    public static final String POSTO = "posto";

    public static final int VERSAO = 1;

    public CriarBanco(Context context) {super(context, CONTROLE_ABASTECIMENTO, null, VERSAO);}


    @Override
    public void onCreate(SQLiteDatabase db) {
        String marca =
                "CREATE TABLE "+TABELAMARCA+"(" +
                        IDMARCA +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                        MARCA +" TEXT" +
                        ")";
        db.execSQL(marca);

        String veiculo =
                "CREATE TABLE "+TABELAVEICULO+"(" +
                        IDVEICULO +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                        DESCRICAO +" TEXT," +
                        IDMARCA +" INTEGER, " +
                        MODELO +" TEXT," +
                        PLACA +" TEXT," +
                        KMINICIAL +" NUMERIC," +
                        CAPACIDADE +" INICIAL," +
                        "FOREIGN KEY ("+IDMARCA+") REFERENCES "+TABELAMARCA+"("+IDMARCA+")" +
                        ")";
        db.execSQL(veiculo);

        String abastecimento =
                "CREATE TABLE "+TABELAABASTECIMENTO+"(" +
                        IDABASTECIMENTO +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        IDVEICULO +" INTEGER, " +
                        DATA +" DATE, " +
                        QTDE +" NUMERIC, " +
                        VALORTOTAL +" NUMERIC, " +
                        KMATUAL +" NUMERIC," +
                        TIPOCOMBUSTIVEL +" TEXT, " +
                        POSTO +" TEXT, " +
                        "FOREIGN KEY ("+ IDVEICULO+") REFERENCES "+TABELAVEICULO+"("+IDVEICULO+")"+
                        ") ";
        db.execSQL(abastecimento);

        String insert1 = "INSERT INTO "+TABELAMARCA+" ("+MARCA+") VALUES ('FIAT')";
        db.execSQL(insert1);

        String insert2 = "INSERT INTO "+TABELAMARCA+" ("+MARCA+") VALUES('FORD')";
        db.execSQL(insert2);

        String insert3 = "INSERT INTO "+TABELAMARCA+" ("+MARCA+") VALUES('GM')";
        db.execSQL(insert3);

        String insert4 = "INSERT INTO "+TABELAMARCA+" ("+MARCA+") VALUES('VW')";
        db.execSQL(insert4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABELAABASTECIMENTO );
        db.execSQL("DROP TABLE IF EXISTS "+ TABELAVEICULO );
        db.execSQL("DROP TABLE IF EXISTS "+ TABELAMARCA );
        onCreate(db);
    }
}

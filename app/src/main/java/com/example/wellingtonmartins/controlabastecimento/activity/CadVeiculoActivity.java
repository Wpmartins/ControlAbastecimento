package com.example.wellingtonmartins.controlabastecimento.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.wellingtonmartins.controlabastecimento.R;
import com.example.wellingtonmartins.controlabastecimento.dao.DaoMarca;
import com.example.wellingtonmartins.controlabastecimento.dao.DaoVeiculo;
import com.example.wellingtonmartins.controlabastecimento.modelo.Marca;
import com.example.wellingtonmartins.controlabastecimento.modelo.Veiculo;

import java.util.List;

public class CadVeiculoActivity extends AppCompatActivity {

    private EditText edtId;
    private EditText edtDescricao;
    private Spinner spnMarca;
    private EditText edtModelo;
    private EditText edtPlaca;
    private EditText edtKmInicial;
    private EditText edtCapTanque;
    private DaoVeiculo daoVeiculo;
    private Veiculo veiculo;
    private DaoMarca daoMarca;
    private Marca marca;
    private boolean insert = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_veiculo);

        daoVeiculo = new DaoVeiculo(this);
        daoMarca = new DaoMarca(this);

        edtId = (EditText) findViewById(R.id.edtId);
        edtDescricao = (EditText) findViewById(R.id.edtDescricao);
        edtModelo = (EditText) findViewById(R.id.edtModelo);
        edtPlaca = (EditText) findViewById(R.id.edtPlaca);
        edtKmInicial = (EditText) findViewById(R.id.edtKmInicial);
        edtCapTanque = (EditText) findViewById(R.id.edtCapTanque);

        List<Marca> listarMarca = daoMarca.listar();
        ArrayAdapter<Marca> adapterTpProduto =
                new ArrayAdapter<Marca>(this, android.R.layout.simple_dropdown_item_1line, listarMarca);


        spnMarca = (Spinner) findViewById(R.id.spnMarca);
        spnMarca.setAdapter(adapterTpProduto);

        edtId.setEnabled(false);

        try {
            veiculo = (Veiculo) getIntent().getSerializableExtra("veiculos");
            setVeiculo(veiculo, spnMarca);
            insert = false;
        } catch (NullPointerException e) {
            Log.e("MSG", "Não veio Veiculo");
        }
    }

    public void setVeiculo(Veiculo obj, Spinner spnMarca){
        edtId.setText(String.valueOf(obj.getId()));
        edtDescricao.setText(obj.getDescricao());
        spnMarca.setAdapter(spnMarca.getAdapter());
    }

}


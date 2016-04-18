package com.example.wellingtonmartins.controlabastecimento.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.wellingtonmartins.controlabastecimento.R;
import com.example.wellingtonmartins.controlabastecimento.dao.DaoMovAbastecimento;
import com.example.wellingtonmartins.controlabastecimento.modelo.Abastecimento;
import com.example.wellingtonmartins.controlabastecimento.modelo.Combustivel;
import com.example.wellingtonmartins.controlabastecimento.modelo.Veiculo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AbastecimentoActivity extends AppCompatActivity {

    private EditText edtIdVeiculo;
    private EditText edtDsVeiculo;
    private EditText edtIdAbastecimento;
    private EditText edtPosto;
    private Spinner spnCombustivel;
    private EditText edtQtde;
    private EditText edtValorTotal;
    private EditText edtData;
    private EditText edtKmAtual;
    private Date data = new Date();
    private Abastecimento abastecimento;
    private DaoMovAbastecimento daoAbastecimento;
    private ArrayAdapter arrayCombustivel;



    Veiculo veiculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abastecimento);

        edtIdVeiculo = (EditText) findViewById(R.id.edtIdVeiculo);
        edtIdAbastecimento = (EditText) findViewById(R.id.edtIdAbastecimento);
        edtDsVeiculo = (EditText) findViewById(R.id.edtDsVeiculo);
        edtPosto = (EditText) findViewById(R.id.edtPosto);
        spnCombustivel = (Spinner) findViewById(R.id.spnTipoCombustivel);

        spnCombustivel.setAdapter(new ArrayAdapter<Combustivel>(this, android.R.layout.simple_spinner_item, Combustivel.values()));
        edtQtde = (EditText) findViewById(R.id.edtQtde);
        edtValorTotal = (EditText) findViewById(R.id.edtValorTotal);
        edtData = (EditText) findViewById(R.id.edtData);
        edtKmAtual = (EditText) findViewById(R.id.edtKmAtual);

        edtDsVeiculo.setEnabled(false);
        edtIdVeiculo.setEnabled(false);
        edtIdVeiculo.setText("");
        edtIdAbastecimento.setEnabled(false);
        edtIdAbastecimento.setText("");

        edtData.setEnabled(false);
        String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(data);
        edtData.setText(dataFormatada);

        try {

            Intent i = getIntent();
            veiculo = new Veiculo();
            veiculo.setIdVeiculo(i.getIntExtra("idVeiculo", -0));
            veiculo.setDescricao(i.getStringExtra("dsVeiculo"));

            setVeiculo(veiculo);

        } catch (NullPointerException e){
            Log.e("MSG", "Não veio Veículo");
        }

    }

    public void setVeiculo(Veiculo obj){
        String codigo = String.valueOf(obj.getIdVeiculo());
        try {
            edtIdVeiculo.setText(codigo);
            edtDsVeiculo.setText(obj.getDescricao());
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "deu erro", Toast.LENGTH_LONG).show();
        }
    }

    public Abastecimento getAbastecimento(){
        abastecimento = new Abastecimento();

        abastecimento.setIdVeiculo(Integer.parseInt(edtIdVeiculo.getText().toString()));
        abastecimento.setPosto(edtPosto.getText().toString());
        //int posicao = spnCombustivel.getSelectedItemPosition();
        abastecimento.setCombustivel(spnCombustivel.getSelectedItem().toString());
        abastecimento.setQtde(Integer.parseInt(edtQtde.getText().toString()));
        abastecimento.setValorTotal(Double.parseDouble(edtValorTotal.getText().toString()));
        abastecimento.setData(edtData.getText().toString());
        abastecimento.setKmAtual(Double.parseDouble(edtKmAtual.getText().toString()));

        return abastecimento;
    }

    public void btnSalvarAbastecimentoClick(View v){
        String retorno;
        daoAbastecimento = new DaoMovAbastecimento(this);

        retorno = daoAbastecimento.inserir(getAbastecimento());

        Toast.makeText(this, retorno, Toast.LENGTH_LONG).show();

        startActivity(new Intent(this,ListarVeiculoActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.listar_veiculo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.nmCadastrarVeiculo:
                startActivity(new Intent(this, CadVeiculoActivity.class));
            break;

            case R.id.nmListarVeiculos:
                startActivity(new Intent(this, ListarVeiculoActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}

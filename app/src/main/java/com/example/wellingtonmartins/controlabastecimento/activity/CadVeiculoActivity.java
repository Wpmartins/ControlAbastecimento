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
import com.example.wellingtonmartins.controlabastecimento.dao.DaoMarca;
import com.example.wellingtonmartins.controlabastecimento.dao.DaoVeiculo;
import com.example.wellingtonmartins.controlabastecimento.modelo.Marca;
import com.example.wellingtonmartins.controlabastecimento.modelo.Veiculo;

import java.util.List;

public class CadVeiculoActivity extends AppCompatActivity {

    private EditText edtId;
    private EditText edtDescricao;
    private EditText edtMarca;
    private Spinner spnMarca;
    private EditText edtModelo;
    private EditText edtPlaca;
    private EditText edtKmInicial;
    private EditText edtCapTanque;
    private DaoVeiculo daoVeiculo;
    private Veiculo veiculo;
    private Marca marca;
    private DaoMarca daoMarca = new DaoMarca(this);

    private Boolean insert = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_veiculo);



        edtId = (EditText) findViewById(R.id.edtId);
        edtDescricao = (EditText) findViewById(R.id.edtDescricao);
        spnMarca = (Spinner) findViewById(R.id.spnMarca);

        List<Marca> listarMarca = daoMarca.listar();
        ArrayAdapter<Marca> adapterMarca =
                new ArrayAdapter<Marca>(this, android.R.layout.simple_dropdown_item_1line, listarMarca);
        spnMarca.setAdapter(adapterMarca);


        edtModelo = (EditText) findViewById(R.id.edtModelo);
        edtPlaca = (EditText) findViewById(R.id.edtPlaca);
        edtKmInicial = (EditText) findViewById(R.id.edtKmInicial);
        edtCapTanque = (EditText) findViewById(R.id.edtCapTanque);
        edtId.setText("");
        edtId.setEnabled(false);

        try {

            Intent i = getIntent();
            veiculo = new Veiculo();
            veiculo.setIdVeiculo(i.getIntExtra("idVeiculo", -0));
            veiculo.setDescricao(i.getStringExtra("dsVeiculo"));
            veiculo.setIdmarca(i.getIntExtra("idMarca", -0));
            veiculo.setModelo(i.getStringExtra("modelo"));
            veiculo.setPlaca(i.getStringExtra("placa"));
            veiculo.setKmInicial(i.getDoubleExtra("kmInicial", -0));
            veiculo.setCapacidade(i.getIntExtra("capacidade", -0));

            if (veiculo.getIdVeiculo() > 0)
            setVeiculo(veiculo);

        } catch (NullPointerException e){
            Log.e("MSG", "Não veio Veículo");
        }
    }

    public void setVeiculo(Veiculo obj){

        String codigo = String.valueOf(obj.getIdVeiculo());
        String km = String.valueOf(obj.getKmInicial());
        String capacidade = String.valueOf(obj.getCapacidade());

        try {
            edtId.setText(codigo);
            edtDescricao.setText(obj.getDescricao());
            spnMarca.setSelection(obj.getIdmarca());
            edtModelo.setText(obj.getModelo());
            edtPlaca.setText(obj.getPlaca());
            edtKmInicial.setText(km);
            edtCapTanque.setText(capacidade);

            insert = false;

        }catch (Exception ex){
            Toast.makeText(getApplicationContext(), "deu erro", Toast.LENGTH_LONG).show();
        }

    }

    public Veiculo getVeiculo(){

        veiculo = new Veiculo();


        if(!edtId.getText().toString().equals("")){
            veiculo.setIdVeiculo(Integer.parseInt(edtId.getText().toString()));
            Toast.makeText(this, ""+veiculo.getIdVeiculo()+"", Toast.LENGTH_LONG).show();

        }
        veiculo.setDescricao(edtDescricao.getText().toString());
        veiculo.setIdmarca(spnMarca.getSelectedItemPosition() + 1);
        veiculo.setModelo(edtModelo.getText().toString());
        veiculo.setPlaca(edtPlaca.getText().toString());
        veiculo.setKmInicial(Double.parseDouble(edtKmInicial.getText().toString()));
        veiculo.setCapacidade(Integer.parseInt(edtCapTanque.getText().toString()));


        return veiculo;
    }

    public void limparCampos(){
        edtId.setText("");
        edtDescricao.setText("");
        edtModelo.setText("");
        edtPlaca.setText("");
        edtKmInicial.setText("");
        edtCapTanque.setText("");
    }
    public void btnSalvarClick(View v){
        String retorno;
        daoVeiculo = new DaoVeiculo(getBaseContext());


        if (insert == true) {
            retorno = daoVeiculo.inserir(getVeiculo());
            limparCampos();
        } else {
            retorno = daoVeiculo.alterar(getVeiculo());
            startActivity(new Intent(this,ListarAbastecimentoActivity.class));
        }

        Toast.makeText(this, retorno, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cadastro_veiculo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nmExcluir:
                daoVeiculo = new DaoVeiculo(this);
                if (!edtId.getText().toString().equals("")) {
                    String retorno = daoVeiculo.excluir(getVeiculo());
                    Toast.makeText(this, retorno, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Selecione um veículo para Excluir!", Toast.LENGTH_LONG).show();
                }
                startActivity(new Intent(this,ListarVeiculoActivity.class));
                break;

            case R.id.nmListarVeiculos:
                startActivity(new Intent(this, ListarVeiculoActivity.class));
                break;
            case R.id.nmListarAbastecimentos:
                Intent i = new Intent(getBaseContext(), ListarAbastecimentoActivity.class);
                i.putExtra("idveiculo", veiculo.getIdVeiculo());
                startActivity(i);

        }
        return super.onOptionsItemSelected(item);
    }
}



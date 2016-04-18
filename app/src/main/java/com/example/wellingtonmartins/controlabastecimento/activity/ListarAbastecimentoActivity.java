package com.example.wellingtonmartins.controlabastecimento.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.wellingtonmartins.controlabastecimento.R;
import com.example.wellingtonmartins.controlabastecimento.dao.DaoMovAbastecimento;
import com.example.wellingtonmartins.controlabastecimento.dao.DaoVeiculo;
import com.example.wellingtonmartins.controlabastecimento.modelo.Abastecimento;
import com.example.wellingtonmartins.controlabastecimento.modelo.Veiculo;

import java.util.List;

public class ListarAbastecimentoActivity extends AppCompatActivity {
    private DaoMovAbastecimento daoAbastecimento;
    private Abastecimento abastecimento;
    private ListView lvAbastecimentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_abastecimento);

        lvAbastecimentos = (ListView) findViewById(R.id.lvAbastecimento);
        daoAbastecimento = new DaoMovAbastecimento(this);

        try{
            Intent i = getIntent();
            abastecimento = new Abastecimento();
            abastecimento.setIdVeiculo(i.getIntExtra("idveiculo", -0));


        } catch (NullPointerException e){
            Log.e("MSG", "Não veio Veículo");
        }
        final List<Abastecimento> abastecimentosList = daoAbastecimento.listarAbastecimentos(abastecimento.getIdVeiculo());

        final ArrayAdapter<Abastecimento> adapterAbastecimentos = new ArrayAdapter<Abastecimento>(this,android.R.layout.simple_list_item_1, abastecimentosList);
        lvAbastecimentos.setAdapter(adapterAbastecimentos);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.listar_abastecimento, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nmListarVeiculos:
                startActivity(new Intent(this, ListarVeiculoActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }
}

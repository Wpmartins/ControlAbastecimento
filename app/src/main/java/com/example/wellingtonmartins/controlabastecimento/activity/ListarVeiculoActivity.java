package com.example.wellingtonmartins.controlabastecimento.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.wellingtonmartins.controlabastecimento.R;
import com.example.wellingtonmartins.controlabastecimento.dao.DaoVeiculo;
import com.example.wellingtonmartins.controlabastecimento.modelo.Veiculo;

import java.util.List;

public class ListarVeiculoActivity extends AppCompatActivity {

    private DaoVeiculo daoVeiculo;
    private ListView lvVeiculo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_veiculo);

        lvVeiculo = (ListView) findViewById(R.id.lvVeiculo);

        daoVeiculo = new DaoVeiculo(this);

        final List<Veiculo> veiculosList = daoVeiculo.listarVeiculos();

        final ArrayAdapter<Veiculo> adapterVeiculos = new ArrayAdapter<Veiculo>(this,android.R.layout.simple_list_item_1, veiculosList);
        lvVeiculo.setAdapter(adapterVeiculos);

        lvVeiculo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


                Intent i = new Intent(getBaseContext(), CadVeiculoActivity.class);

                i.putExtra("idVeiculo", veiculosList.get(position).getIdVeiculo());
                i.putExtra("dsVeiculo", veiculosList.get(position).getDescricao());
                i.putExtra("idmarca", veiculosList.get(position).getIdmarca());
                i.putExtra("modelo", veiculosList.get(position).getModelo());
                i.putExtra("placa", veiculosList.get(position).getPlaca());
                i.putExtra("kmInicial", veiculosList.get(position).getKmInicial());
                i.putExtra("capacidade", veiculosList.get(position).getCapacidade());

                startActivity(i);

                return false;
            }
        });

        lvVeiculo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(getBaseContext(), AbastecimentoActivity.class);

                it.putExtra("idVeiculo", veiculosList.get(position).getIdVeiculo());
                it.putExtra("dsVeiculo", veiculosList.get(position).getDescricao());

                startActivity(it);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menugeral, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nmCadastrarVeiculo:
                startActivity(new Intent(this, CadVeiculoActivity.class));
                break;

            case R.id.nmLancarAbastecimento:
                startActivity(new Intent(this, AbastecimentoActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.example.wellingtonmartins.controlabastecimento.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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

        //lvAbastecimentos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        //
        //    @Override
        //    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        //
        //
        //        Intent i = new Intent(getBaseContext(), CadVeiculoActivity.class);
        //
        //      // i.putExtra("idVeiculo", veiculosList.get(position).getIdVeiculo());
        //      // i.putExtra("dsVeiculo", veiculosList.get(position).getDescricao());
        //      // i.putExtra("idmarca", veiculosList.get(position).getIdmarca());
        //      // i.putExtra("modelo", veiculosList.get(position).getModelo());
        //      // i.putExtra("placa", veiculosList.get(position).getPlaca());
        //      // i.putExtra("kmInicial", veiculosList.get(position).getKmInicial());
        //      // i.putExtra("capacidade", veiculosList.get(position).getCapacidade());
        //
        //        startActivity(i);
        //
        //        return false;
        //    }
        //});
    }

}

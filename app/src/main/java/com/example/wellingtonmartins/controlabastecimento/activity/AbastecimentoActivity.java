package com.example.wellingtonmartins.controlabastecimento.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import com.example.wellingtonmartins.controlabastecimento.R;

public class AbastecimentoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abastecimento);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.listarveiculo, menu);
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

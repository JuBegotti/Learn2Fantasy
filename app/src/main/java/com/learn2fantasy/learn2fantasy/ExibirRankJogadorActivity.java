package com.learn2fantasy.learn2fantasy;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.learn2fantasy.learn2fantasy.bd.BD;
import com.learn2fantasy.learn2fantasy.bd.Jogador;
import com.learn2fantasy.learn2fantasy.listView.ListViewTimePts;

import java.util.List;

public class ExibirRankJogadorActivity extends AppCompatActivity {

    private TextView pos;
    List<Jogador> jogadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_rank_jogador);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.ranking_jogador_string));

        initViews();
        getValues();

        ListView lista = findViewById(R.id.exiRankJog_list);
        List<Jogador> jogadores = BD.buscaJogadores(pos.getText().toString(),this);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("Erro");
        dlg.setMessage("tam "+jogadores.size());
        dlg.setNeutralButton("ok",null);
        dlg.show();
        //ListViewTimePts adapter = new ListViewTimePts(null, jogadores, this, 0);
        //lista.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, RankJogadorActivity.class));
                break;
            default:break;
        }
        return true;
    }

    private void initViews(){
        pos = (TextView) findViewById(R.id.exiRankJog_pos);
    }

    private void getValues(){
        pos.setText(getIntent().getStringExtra("posicao"));
    }
}

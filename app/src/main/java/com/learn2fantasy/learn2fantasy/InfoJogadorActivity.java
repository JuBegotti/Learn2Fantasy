package com.learn2fantasy.learn2fantasy;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.learn2fantasy.learn2fantasy.bd.BD;
import com.learn2fantasy.learn2fantasy.bd.BDContract;
import com.learn2fantasy.learn2fantasy.bd.Jogador;
import com.learn2fantasy.learn2fantasy.bd.Time;
import com.learn2fantasy.learn2fantasy.listView.ListViewTimePts;

import java.util.List;

public class InfoJogadorActivity extends AppCompatActivity {

    List<Jogador> jogadoresPos;
    List<Jogador> jogadoresTime;
    List<Jogador> jogadoresNome;
    ListView lista;
    ListViewTimePts adapter2;
    ListViewTimePts adapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_jogador);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.info_jogador_string));

        jogadoresPos = BD.buscaTodosJogadoresOrdenado(BDContract.BDJogador.JOGADOR_POS,this);
        jogadoresTime = BD.buscaTodosJogadoresOrdenado(BDContract.BDJogador.JOGADOR_TIME,this);
        jogadoresNome = BD.buscaTodosJogadoresOrdenado(BDContract.BDJogador.JOGADOR_NOME,this);

        lista = findViewById(R.id.infoJog_lisView);
        ListViewTimePts adapter1 = new ListViewTimePts(null, jogadoresNome, this, 1);
        adapter2 = new ListViewTimePts(null, jogadoresTime, this, 1);
        adapter3 = new ListViewTimePts(null, jogadoresPos, this, 1);
        lista.setAdapter(adapter1);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Jogador jogador = (Jogador) lista.getItemAtPosition(position);
                Intent intent = new Intent(lista.getContext(), ExibirInfoJogadorActivity.class);
                putIntents(intent, jogador);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, MenuActivity.class));
                break;
            default:break;
        }
        return true;
    }

    public void escolherOrdenacao(View view) {
        if(view.getId()==R.id.infoJog_buscTime) {
            lista.setAdapter(adapter2);
        }
        if(view.getId()==R.id.infoJog_buscPos) {
            lista.setAdapter(adapter3);
        }
    }

    public void putIntents(Intent intent, Jogador jogador){
        intent.putExtra(BDContract.BDJogador.JOGADOR_NOME, jogador.getNome());
        intent.putExtra(BDContract.BDJogador.JOGADOR_POS, jogador.getpPosicao());
        intent.putExtra(BDContract.BDJogador.JOGADOR_TIME, jogador.getTime());
        intent.putExtra(BDContract.BDJogador.JOGADOR_COL, jogador.getCol());
        intent.putExtra(BDContract.BDJogador.JOGADOR_PTS, jogador.getPts());
        intent.putExtra(BDContract.BDJogador.JOGADOR_JOGOS, jogador.getJogos());
        intent.putExtra(BDContract.BDJogador.JOGADOR_GOLS, jogador.getGols());
        intent.putExtra(BDContract.BDJogador.JOGADOR_MIN, jogador.getMinutos());
    }

    public void botBusca(View view) {
        android.widget.SearchView searchView = (android.widget.SearchView) findViewById(R.id.infoJog_search);
        String jogadorNome = searchView.getQuery().toString().trim();;
        Jogador jogador = BD.buscaJogador(jogadorNome,this);
        if(jogador==null){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Erro");
            dlg.setMessage("Jogador não encontrado, tente novamente.");
            dlg.setNeutralButton("ok",null);
            dlg.show();
        }
        else{
            Intent intent = new Intent(this, ExibirInfoJogadorActivity.class);
            putIntents(intent, jogador);
            startActivity(intent);
        }
    }
}

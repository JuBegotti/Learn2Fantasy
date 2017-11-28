package com.learn2fantasy.learn2fantasy;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.learn2fantasy.learn2fantasy.bd.BD;
import com.learn2fantasy.learn2fantasy.bd.Jogador;
import com.learn2fantasy.learn2fantasy.bd.Time;
import com.learn2fantasy.learn2fantasy.listView.ListViewTimePts;

import java.util.List;

public class EscolherJogadorCompararActivity extends AppCompatActivity {

    List<Jogador> jogadores = null;
    Jogador jogador1 = null;
    Jogador jogador2 = null;
    ListView lista;
    TextView jogador1TextView;
    TextView jogador2TextView;
    String jogador1string = null;
    String jogador2string = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_jogador_comparar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.comparar_time_string));

        jogador1TextView = (TextView) findViewById(R.id.escJogComp_jogador1);
        jogador2TextView = (TextView) findViewById(R.id.escJogComp_jogador2);

        jogadores = BD.buscaJogadores(getIntent().getStringExtra("posicao"), this);
        lista = findViewById(R.id.escJogComp_listView);
        ListViewTimePts adapter = new ListViewTimePts(null, jogadores, this, 2);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(jogador1==null && jogador2!=(Jogador) lista.getItemAtPosition(position)){
                    jogador1 = (Jogador) lista.getItemAtPosition(position);
                    jogador1TextView.setText(jogador1.getNome());
                    jogador1string = jogador1.getNome();
                    return;
                }
                if(jogador2==null && jogador1!=(Jogador) lista.getItemAtPosition(position)){
                    jogador2 = (Jogador) lista.getItemAtPosition(position);
                    jogador2TextView.setText(jogador2.getNome());
                    jogador2string = jogador2.getNome();
                    return;
                }
                if(jogador1==(Jogador) lista.getItemAtPosition(position)) {
                    jogador1 = null;
                    jogador1TextView.setText(getResources().getString(R.string.selecione_string));
                    jogador1string = null;
                    return;
                }
                if(jogador2==(Jogador) lista.getItemAtPosition(position)) {
                    jogador2 = null;
                    jogador2TextView.setText(getResources().getString(R.string.selecione_string));
                    jogador2string = null;
                    return;
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, CompararJogadoresActivity.class));
                break;
            default:break;
        }
        return true;
    }

    public void irCompJog(View view) {
        if(jogador1string==null || jogador2string==null) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Erro");
            dlg.setMessage("Escolha os jogadores a serem comparados!");
            dlg.setNeutralButton("ok",null);
            dlg.show();
            return;
        }
        Intent intent = new Intent(this, ExibirCompararJogadoresActivity.class);
        intent.putExtra("jogador1",jogador1string);
        intent.putExtra("jogador2",jogador2string);
        startActivity(intent);
    }
}

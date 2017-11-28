package com.learn2fantasy.learn2fantasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.learn2fantasy.learn2fantasy.bd.BD;
import com.learn2fantasy.learn2fantasy.bd.Jogador;

public class ExibirCompararJogadoresActivity extends AppCompatActivity {

    private TextView nome1;
    private TextView nome2;
    private TextView time1;
    private TextView time2;
    private TextView colpts1;
    private TextView colpts2;
    private TextView pts1;
    private TextView pts2;
    private TextView jogos1;
    private TextView jogos2;
    private TextView gols1;
    private TextView gols2;
    private TextView min1;
    private TextView min2;
    Jogador jogador1;
    Jogador jogador2;
    String jogador1string;
    String jogador2string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_comparar_jogadores);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.comparar_jogador_string));

        jogador1string = getIntent().getStringExtra("jogador1");
        jogador2string = getIntent().getStringExtra("jogador2");
        jogador1 = BD.buscaJogador(jogador1string,this);
        jogador2 = BD.buscaJogador(jogador2string,this);

        initViews();
        getValues();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, EscolherJogadorCompararActivity.class);
                intent.putExtra("posicao",jogador1.getpPosicao());
                startActivity(intent);
                break;
            default:break;
        }
        return true;
    }

    private void initViews(){
        nome1 = (TextView) findViewById(R.id.exibCompJog_time1);
        nome2 = (TextView) findViewById(R.id.exibCompJog_time2);
        time1 = (TextView) findViewById(R.id.exibCompJog_jog1Time);
        time2 = (TextView) findViewById(R.id.exibCompJog_jog2Time);
        colpts1 = (TextView) findViewById(R.id.exibCompJog_jog1ColPts);
        colpts2 = (TextView) findViewById(R.id.exibCompJog_jog2ColPts);
        pts1 = (TextView) findViewById(R.id.exibCompJog_jog1Pts);
        pts2 = (TextView) findViewById(R.id.exibCompJog_jog2Pts);
        jogos1 = (TextView) findViewById(R.id.exibCompJog_jog1Jogos);
        jogos2 = (TextView) findViewById(R.id.exibCompJog_jog2Jogos);
        gols1 = (TextView) findViewById(R.id.exibCompJog_jog1Gols);
        gols2 = (TextView) findViewById(R.id.exibCompJog_jog2Gols);
        min1 = (TextView) findViewById(R.id.exibCompJog_jog1Min);
        min2 = (TextView) findViewById(R.id.exibCompJog_jog2Min);
    }

    private void getValues(){
        nome1.setText(jogador1.getNome());
        nome2.setText(jogador2.getNome());
        time1.setText(jogador1.getTime());
        time2.setText(jogador2.getTime());
        colpts1.setText(Integer.toString(jogador1.getCol()));
        colpts2.setText(Integer.toString(jogador2.getCol()));
        pts1.setText(Float.toString(jogador1.getPts()));
        pts2.setText(Float.toString(jogador2.getPts()));
        jogos1.setText(Integer.toString(jogador1.getJogos()));
        jogos2.setText(Integer.toString(jogador2.getJogos()));
        gols1.setText(Integer.toString(jogador1.getGols()));
        gols2.setText(Integer.toString(jogador2.getGols()));
        min1.setText(Integer.toString(jogador1.getMinutos()));
        min2.setText(Integer.toString(jogador2.getMinutos()));
    }
}

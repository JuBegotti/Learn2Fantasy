package com.learn2fantasy.learn2fantasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

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

//    ExibirCompararJogadoresActivity(Jogador jogador1, Jogador jogador2){
//        this.jogador1 = jogador1;
//        this.jogador2 = jogador2;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_comparar_jogadores);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.comparar_jogador_string));

        initViews();
        getValues();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, EscolherJogadorCompararActivity.class));
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
        time1.setText(jogador1.getNome());
        time2.setText(jogador2.getTime());
        colpts1.setText(jogador1.getCol());
        colpts2.setText(jogador2.getCol());
        pts1.setText(Float.toString(jogador1.getPts()));
        pts2.setText(Float.toString(jogador2.getPts()));
        jogos1.setText(jogador1.getJogos());
        jogos2.setText(jogador2.getJogos());
        gols1.setText(jogador1.getGols());
        gols2.setText(jogador2.getGols());
        min1.setText(jogador1.getMinutos());
        min2.setText(jogador2.getMinutos());
    }
}

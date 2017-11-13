package com.learn2fantasy.learn2fantasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.learn2fantasy.learn2fantasy.bd.BDContract;

public class ExibirInfoJogadorActivity extends AppCompatActivity {

    private TextView nome;
    private TextView posicao;
    private TextView time;
    private TextView colocacao;
    private TextView pontos;
    private TextView jogos;
    private TextView gols;
    private TextView minutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_info_jogador);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.info_jogador_string));

        initViews();
        getValues();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, InfoJogadorActivity.class));
                break;
            default:break;
        }
        return true;
    }

    private void initViews(){
        nome = (TextView) findViewById(R.id.exibirInfoJog_nomeJog);
        posicao = (TextView) findViewById(R.id.exibirInfoJog_posicaoJog);
        time = (TextView) findViewById(R.id.exibirInfoJog_timeJog);
        colocacao = (TextView) findViewById(R.id.exibirInfoJog_posCont);
        pontos = (TextView) findViewById(R.id.exibirInfoJog_ptsCont);
        jogos = (TextView) findViewById(R.id.exibirInfoJog_jogosCont);
        gols = (TextView) findViewById(R.id.exibirInfoJog_golsCont);
        minutos = (TextView) findViewById(R.id.exibirInfoJog_minCont);
    }

    private void getValues(){
        nome.setText(getIntent().getStringExtra(BDContract.BDJogador.JOGADOR_NOME));
        posicao.setText(getIntent().getStringExtra(BDContract.BDJogador.JOGADOR_POS));
        time.setText(getIntent().getStringExtra(BDContract.BDJogador.JOGADOR_TIME));
        colocacao.setText(Integer.toString(getIntent().getIntExtra(BDContract.BDJogador.JOGADOR_COL, 0)));
        pontos.setText(Float.toString(getIntent().getFloatExtra(BDContract.BDJogador.JOGADOR_PTS, 0)));
        jogos.setText(Integer.toString(getIntent().getIntExtra(BDContract.BDJogador.JOGADOR_JOGOS, 0)));
        gols.setText(Integer.toString(getIntent().getIntExtra(BDContract.BDJogador.JOGADOR_GOLS, 0)));
        minutos.setText(Integer.toString(getIntent().getIntExtra(BDContract.BDJogador.JOGADOR_MIN, 0)));
    }
}

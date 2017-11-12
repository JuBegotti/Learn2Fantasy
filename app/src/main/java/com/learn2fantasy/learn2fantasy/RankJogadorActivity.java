package com.learn2fantasy.learn2fantasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.learn2fantasy.learn2fantasy.bd.BDContract;

public class RankJogadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank_jogador);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.ranking_jogador_string));
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

    public void escolherRank(View view){
        String pos;
        switch(view.getId()) {
            case R.id.rankJog_cent : pos = getString(R.string.centroavante_string); break;
            case R.id.rankJog_2at : pos = getString(R.string.seg_ata_string); break;
            case R.id.rankJog_gol : pos = getString(R.string.gol_string); break;
            case R.id.rankJog_lae : pos = getString(R.string.lat_esq_string); break;
            case R.id.rankJog_lad : pos = getString(R.string.lat_dir_string); break;
            case R.id.rankJog_meia : pos = getString(R.string.meia_string); break;
            case R.id.rankJog_vol : pos = getString(R.string.voltante_string); break;
            case R.id.rankJog_2vol : pos = getString(R.string.seg_vol_string); break;
            case R.id.rankJog_zag : pos = getString(R.string.zagueiro_string); break;
            default : pos = "null"; break;
        }
        Intent intent = new Intent(this, ExibirRankJogadorActivity.class);
        intent.putExtra("posicao", pos);
        startActivity(intent);
    }
}

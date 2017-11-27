package com.learn2fantasy.learn2fantasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class CompararJogadoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparar_jogadores);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.comparar_jogador_string));
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

    public void escolherPos(View view){
        String pos;
        switch(view.getId()) {
            case R.id.compJog_cent : pos = getString(R.string.centroavante_string); break;
            case R.id.compJog_2at : pos = getString(R.string.seg_ata_string); break;
            case R.id.compJog_gol : pos = getString(R.string.gol_string); break;
            case R.id.compJog_lae : pos = getString(R.string.lat_esq_string); break;
            case R.id.compJog_lad : pos = getString(R.string.lat_dir_string); break;
            case R.id.compJog_meia : pos = getString(R.string.meia_string); break;
            case R.id.compJog_vol : pos = getString(R.string.voltante_string); break;
            case R.id.compJog_2vol : pos = getString(R.string.seg_vol_string); break;
            case R.id.compJog_zag : pos = getString(R.string.zagueiro_string); break;
            default : return;
        }
        Intent intent = new Intent(this, EscolherJogadorCompararActivity.class);
        intent.putExtra("posicao", pos);
        startActivity(intent);
    }
}

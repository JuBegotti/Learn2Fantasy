package com.learn2fantasy.learn2fantasy;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.learn2fantasy.learn2fantasy.bd.BD;
import com.learn2fantasy.learn2fantasy.bd.BDContract;
import com.learn2fantasy.learn2fantasy.bd.Time;

public class InfoTimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_time);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.info_time_string));
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

    public void irExibirTime(View view) {
        String nome;
        switch(view.getId()) {
            case R.id.infoTime_aGO : nome = getString(R.string.aGO_string); break;
            case R.id.infoTime_aMG : nome = getString(R.string.aMG_string); break;
            case R.id.infoTime_aPR : nome = getString(R.string.aPR_string); break;
            case R.id.infoTime_avai : nome = getString(R.string.avai_string); break;
            case R.id.infoTime_bahia : nome = getString(R.string.bahia_string); break;
            case R.id.infoTime_botafogo : nome = getString(R.string.botafogo_string); break;
            case R.id.infoTime_chapeco : nome = getString(R.string.chapocoense_string); break;
            case R.id.infoTime_corinthians : nome = getString(R.string.corinthians_string); break;
            case R.id.infoTime_coritiba : nome = getString(R.string.coritiba_string); break;
            case R.id.infoTime_cruzeiro : nome = getString(R.string.cruzeiro_string); break;
            case R.id.infoTime_flamengo : nome = getString(R.string.flamengo_string); break;
            case R.id.infoTime_fluminense : nome = getString(R.string.fluminense_string); break;
            case R.id.infoTime_gremio : nome = getString(R.string.gremio_string); break;
            case R.id.infoTime_palmeiras : nome = getString(R.string.palmeiras_string); break;
            case R.id.infoTime_ptpreta : nome = getString(R.string.pontePreta_string); break;
            case R.id.infoTime_santos : nome = getString(R.string.santos_string); break;
            case R.id.infoTime_sp : nome = getString(R.string.sp_string); break;
            case R.id.infoTime_sport : nome = getString(R.string.sport_string); break;
            case R.id.infoTime_vitoria : nome = getString(R.string.vitoria_string); break;
            case R.id.infoTime_vasco : nome = getString(R.string.vasco_string); break;
            default : nome = "null"; break;
        }
        Time time = BD.buscaTime(nome,this);
        if(time==null) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Erro");
            dlg.setMessage("Erro ao selecinar o time, tente novamente.");
            dlg.setNeutralButton("ok",null);
            dlg.show();
            return;
        }
        Intent intent = new Intent(this, ExibirTimeActivity.class);
        intent.putExtra(BDContract.BDTime.TIME_NOME, time.getNome());
        intent.putExtra(BDContract.BDTime.TIME_GOLS, time.getGols());
        intent.putExtra(BDContract.BDTime.TIME_PTS, time.getPts());
        intent.putExtra(BDContract.BDTime.TIME_COL_PTS, time.getCol_pts());
        intent.putExtra(BDContract.BDTime.TIME_COL_GOLS, time.getCol_gols());
        startActivity(intent);
    }
}

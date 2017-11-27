package com.learn2fantasy.learn2fantasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.learn2fantasy.learn2fantasy.bd.BDContract;
import com.learn2fantasy.learn2fantasy.bd.Time;

public class ExibirComparacaoTimeActivity extends AppCompatActivity {

    private TextView nome1;
    private TextView nome2;
    private TextView colpts1;
    private TextView colpts2;
    private TextView pts1;
    private TextView pts2;
    private TextView colgols1;
    private TextView colgols2;
    private TextView gols1;
    private TextView gols2;
    Time time1;
    Time time2;

//    ExibirComparacaoTimeActivity(Time time1, Time time2){
//        this.time1 = time1;
//        this.time2 = time2;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_comparacao_time);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.comparar_time_string));

        initViews();
        getValues();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, CompararTimesActivity.class));
                break;
            default:break;
        }
        return true;
    }

    private void initViews(){
        nome1 = (TextView) findViewById(R.id.exibCompTime_time1);
        nome2 = (TextView) findViewById(R.id.exibCompTime_time2);
        colpts1 = (TextView) findViewById(R.id.exibCompTime_time1ColPts);
        colpts2 = (TextView) findViewById(R.id.exibCompTime_time2ColPts);
        pts1 = (TextView) findViewById(R.id.exibCompTime_time1Pts);
        pts2 = (TextView) findViewById(R.id.exibCompTime_time2Pts);
        colgols1 = (TextView) findViewById(R.id.exibCompTime_time1ColGols);
        colgols2 = (TextView) findViewById(R.id.exibCompTime_time2ColGols);
        gols1 = (TextView) findViewById(R.id.exibCompTime_time1Gols);
        gols2 = (TextView) findViewById(R.id.exibCompTime_time2Gols);
    }

    private void getValues(){
        nome1.setText(time1.getNome());
        nome2.setText(time2.getNome());
        colpts1.setText(time1.getCol_pts());
        colpts2.setText(time2.getCol_pts());
        pts1.setText(Float.toString(time1.getPts()));
        pts2.setText(Float.toString(time2.getPts()));
        gols1.setText(time1.getGols());
        gols2.setText(time2.getGols());
        colgols1.setText(time1.getCol_gols());
        colgols2.setText(time2.getCol_gols());
    }
}

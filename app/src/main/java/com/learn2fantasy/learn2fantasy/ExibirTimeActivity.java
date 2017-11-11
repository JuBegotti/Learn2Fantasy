package com.learn2fantasy.learn2fantasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.learn2fantasy.learn2fantasy.bd.BDContract;

public class ExibirTimeActivity extends AppCompatActivity {

    private TextView nome_time;
    private TextView gols_time;
    private TextView pts_time;
    private TextView col_gols_time;
    private TextView col_pts_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_time);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.info_time_string));

        initViews();
        getValues();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, InfoTimeActivity.class));
                break;
            default:break;
        }
        return true;
    }

    private void initViews(){
        nome_time = (TextView) findViewById(R.id.verTime_nomeTime);
        gols_time = (TextView) findViewById(R.id.vertime_golsCont);
        pts_time = (TextView) findViewById(R.id.verTime_ptsCont);
        col_gols_time = (TextView) findViewById(R.id.verTime_colGolsCont);
        col_pts_time = (TextView) findViewById(R.id.verTime_colPtsCont);
    }

    private void getValues(){
        nome_time.setText(getIntent().getStringExtra(BDContract.BDTime.TIME_NOME));
        gols_time.setText(Integer.toString(getIntent().getIntExtra(BDContract.BDTime.TIME_GOLS, 0)));
        pts_time.setText(Float.toString(getIntent().getFloatExtra(BDContract.BDTime.TIME_PTS, 0)));
        col_gols_time.setText(Integer.toString(getIntent().getIntExtra(BDContract.BDTime.TIME_COL_GOLS, 0)));
        col_pts_time.setText(Integer.toString(getIntent().getIntExtra(BDContract.BDTime.TIME_COL_PTS, 0)));
    }
}

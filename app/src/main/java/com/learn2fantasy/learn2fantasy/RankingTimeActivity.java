package com.learn2fantasy.learn2fantasy;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.learn2fantasy.learn2fantasy.bd.BD;
import com.learn2fantasy.learn2fantasy.bd.Time;
import com.learn2fantasy.learn2fantasy.listView.ListViewTimePts;

import java.util.List;

public class RankingTimeActivity extends AppCompatActivity {

    List<Time> timesColPts;
    List<Time> timesColGols;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_time);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.ranking_time_string));


        timesColPts = BD.listaTimes(this,1);
        timesColGols = BD.listaTimes(this,2);
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

    public void escolherRank(View view) {
        ListView lista = findViewById(R.id.rankTime_lista);
        if(view.getId()==R.id.RankTime_pts) {
            ListViewTimePts adapter = new ListViewTimePts(timesColPts, null, this, 1);
            lista.setAdapter(adapter);
        }
        if(view.getId()==R.id.RankTime_gols) {
            ListViewTimePts adapter = new ListViewTimePts(timesColGols, null, this, 2);
            lista.setAdapter(adapter);
        }
    }
}

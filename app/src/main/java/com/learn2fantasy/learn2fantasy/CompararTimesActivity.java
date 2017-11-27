package com.learn2fantasy.learn2fantasy;

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

public class CompararTimesActivity extends AppCompatActivity {

    List<Time> times = null;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparar_times);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.comparar_time_string));

        times = BD.listaTimes(this,0);
        if(times!=null) {
            lista = findViewById(R.id.compTimes_listView);
            ListViewTimePts adapter1 = new ListViewTimePts(times,null,this, 0);
            lista.setAdapter(adapter1);
        }
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

    public void irCompTime(View view) {
        startActivity(new Intent(this, ExibirComparacaoTimeActivity.class));
    }
}

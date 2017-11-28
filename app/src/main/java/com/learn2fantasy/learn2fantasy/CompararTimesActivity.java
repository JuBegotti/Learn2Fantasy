package com.learn2fantasy.learn2fantasy;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.learn2fantasy.learn2fantasy.bd.BD;
import com.learn2fantasy.learn2fantasy.bd.Jogador;
import com.learn2fantasy.learn2fantasy.bd.Time;
import com.learn2fantasy.learn2fantasy.listView.ListViewTimePts;

import java.util.List;

public class CompararTimesActivity extends AppCompatActivity {

    List<Time> times = null;
    Time time1 = null;
    Time time2 = null;
    ListView lista;
    TextView time1TextView;
    TextView time2TextView;
    String time1string = null;
    String time2string = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparar_times);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.comparar_time_string));

        time1TextView = (TextView) findViewById(R.id.compTimes_time1);
        time2TextView = (TextView) findViewById(R.id.compTimes_time2);

        times = BD.listaTimes(this,0);
        lista = findViewById(R.id.compTimes_listView);
        ListViewTimePts adapter1 = new ListViewTimePts(times,null,this, 0);
        lista.setAdapter(adapter1);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(time1==null && time2!=(Time) lista.getItemAtPosition(position)){
                    time1 = (Time) lista.getItemAtPosition(position);
                    time1TextView.setText(time1.getNome());
                    time1string = time1.getNome();
                    return;
                }
                if(time2==null && time1!=(Time) lista.getItemAtPosition(position)){
                    time2 = (Time) lista.getItemAtPosition(position);
                    time2TextView.setText(time2.getNome());
                    time2string = time2.getNome();
                    return;
                }
                if(time1==(Time) lista.getItemAtPosition(position)) {
                    time1 = null;
                    time1TextView.setText(getResources().getString(R.string.selecione_string));
                    time1string = null;
                    return;
                }
                if(time2==(Time) lista.getItemAtPosition(position)) {
                    time2 = null;
                    time2TextView.setText(getResources().getString(R.string.selecione_string));
                    time2string = null;
                    return;
                }
            }
        });
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
        if(time1string==null || time2string==null) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Erro");
            dlg.setMessage("Escolha os times a serem comparados!");
            dlg.setNeutralButton("ok",null);
            dlg.show();
            return;
        }
        Intent intent = new Intent(this, ExibirComparacaoTimeActivity.class);
        intent.putExtra("time1",time1string);
        intent.putExtra("time2",time2string);
        startActivity(intent);
    }
}

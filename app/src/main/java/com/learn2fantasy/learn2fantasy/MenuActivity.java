package com.learn2fantasy.learn2fantasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();
    }

    public void menuIr(View view) {
        Intent intent;
        switch(view.getId()) {
            case R.id.menu_infoTimes : intent = new Intent(this, InfoTimeActivity.class); break;
            case R.id.menu_infoJog : intent = new Intent(this, InfoJogadorActivity.class); break;
            case R.id.menu_rankTimes : intent = new Intent(this, RankingTimeActivity.class); break;
            case R.id.menu_rankJog : intent = new Intent(this, RankJogadorActivity.class); break;
            case R.id.menu_compTimes : return;
            case R.id.menu_compJog : return;
            default : intent = null; break;
        }
        startActivity(intent);
    }
}

package com.learn2fantasy.learn2fantasy;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.learn2fantasy.learn2fantasy.bd.BD;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        BD.testaBD(this);

        final int MILISEGUNDOS = 3000;
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(i);
            }
        }, MILISEGUNDOS);
    }

    public void irMenu(View view) {
        startActivity(new Intent(this, MenuActivity.class));
    }
}

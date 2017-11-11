package com.learn2fantasy.learn2fantasy.bd;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.learn2fantasy.learn2fantasy.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BDHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "L2F_BD.db";
    private Context context;

    private static final String CRIA_TABELA_TIME =
            "CREATE TABLE " + BDContract.BDTime.TIME + " (" +
                    BDContract.BDTime._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    BDContract.BDTime.TIME_NOME + " TEXT, " +
                    BDContract.BDTime.TIME_GOLS + " INTEGER, " +
                    BDContract.BDTime.TIME_PTS + " FLOAT, " +
                    BDContract.BDTime.TIME_COL_PTS + " INTEGER, " +
                    BDContract.BDTime.TIME_COL_GOLS + " INTEGER " +
                    " )";

    private static final String CRIA_TABELA_JOGADOR =
            "CREATE TABLE " + BDContract.BDJogador.JOGADOR + " (" +
                    BDContract.BDJogador._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    BDContract.BDJogador.JOGADOR_NOME + " TEXT, " +
                    BDContract.BDJogador.JOGADOR_TIME + " TEXT, " +
                    BDContract.BDJogador.JOGADOR_POS + " TEXT, " +
                    BDContract.BDJogador.JOGADOR_JOGOS + " INTEGER, " +
                    BDContract.BDJogador.JOGADOR_GOLS + " INTEGER, " +
                    BDContract.BDJogador.JOGADOR_MIN + " INTEGER, " +
                    BDContract.BDJogador.JOGADOR_PTS + " FLOAT, " +
                    BDContract.BDJogador.JOGADOR_COL + " INTEGER " +
                    " )";

    private static final String DELETA_TABELA_TIME =
            "DROP TABLE IF EXISTS " + BDContract.BDTime.TIME;

    private static final String DELETA_TABELA_JOGADOR =
            "DROP TABLE IF EXISTS " + BDContract.BDJogador.JOGADOR;

    public BDHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(CRIA_TABELA_TIME);
        bd.execSQL(CRIA_TABELA_JOGADOR);
        try {
            BD.carregaDados(bd, context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETA_TABELA_TIME);
        db.execSQL(DELETA_TABELA_JOGADOR);
        onCreate(db);
    }
}

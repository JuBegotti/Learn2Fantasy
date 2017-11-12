package com.learn2fantasy.learn2fantasy.bd;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.learn2fantasy.learn2fantasy.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BD {

    public static void testaBD(Context contexto){
        try {
            BDHelper bd = new BDHelper(contexto);
            SQLiteDatabase conexao = bd.getReadableDatabase();
        }catch (SQLException ex){
            AlertDialog.Builder dlg = new AlertDialog.Builder(contexto);
            dlg.setTitle("Erro");
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton("ok",null);
            dlg.show();
        }
    }

    public static void carregaDados(SQLiteDatabase bd, Context context) throws IOException {
        final Resources resources = context.getResources();
        InputStream inTime = resources.openRawResource(R.raw.times);
        BufferedReader readerTime = new BufferedReader(new InputStreamReader(inTime));
        InputStream inJogador = resources.openRawResource(R.raw.jogadores);
        BufferedReader readerJogador = new BufferedReader(new InputStreamReader(inJogador));
        String lineTime;
        String lineJogador;
        while ((lineTime = readerTime.readLine()) != null) {
            String[] RowData = lineTime.split(",");
            String nome_time = RowData[0];
            String gols = RowData[1];
            String pts = RowData[2];
            String col_pts = RowData[3];
            String col_gols = RowData[4];
            ContentValues initialValues = new ContentValues();
            initialValues.put(BDContract.BDTime.TIME_NOME, nome_time);
            initialValues.put(BDContract.BDTime.TIME_GOLS, Integer.parseInt(gols));
            initialValues.put(BDContract.BDTime.TIME_PTS, Float.parseFloat(pts));
            initialValues.put(BDContract.BDTime.TIME_COL_PTS, Integer.parseInt(col_pts));
            initialValues.put(BDContract.BDTime.TIME_COL_GOLS, Integer.parseInt(col_gols));
            bd.insert(BDContract.BDTime.TIME, null, initialValues);
        }
        while ((lineJogador = readerJogador.readLine()) != null) {
            String[] RowData = lineJogador.split(",");
            String nome = RowData[0];
            String time = RowData[1];
            String posicao = RowData[2];
            String jogos = RowData[3];
            String gols = RowData[4];
            String minutos = RowData[5];
            String pts = RowData[6];
            String col = RowData[7];
            ContentValues initialValues = new ContentValues();
            initialValues.put(BDContract.BDJogador.JOGADOR_NOME , nome);
            initialValues.put(BDContract.BDJogador.JOGADOR_TIME, time);
            initialValues.put(BDContract.BDJogador.JOGADOR_POS, posicao);
            initialValues.put(BDContract.BDJogador.JOGADOR_JOGOS, Integer.parseInt(jogos));
            initialValues.put(BDContract.BDJogador.JOGADOR_GOLS, Integer.parseInt(gols));
            initialValues.put(BDContract.BDJogador.JOGADOR_MIN, Integer.parseInt(minutos));
            initialValues.put(BDContract.BDJogador.JOGADOR_PTS, Float.parseFloat(pts));
            initialValues.put(BDContract.BDJogador.JOGADOR_COL, Integer.parseInt(col));
            bd.insert(BDContract.BDJogador.JOGADOR, null, initialValues);
        }
        inTime.close();
        inJogador.close();
        readerTime.close();
        readerJogador.close();
    }

    public static Time buscaTime(String time, Context context){
        Time resp = null;
        BDHelper bdHelper = new BDHelper(context);
        SQLiteDatabase bd = bdHelper.getReadableDatabase();

        String[] projection = {
                BDContract.BDTime._ID,
                BDContract.BDTime.TIME_NOME,
                BDContract.BDTime.TIME_GOLS,
                BDContract.BDTime.TIME_PTS,
                BDContract.BDTime.TIME_COL_PTS,
                BDContract.BDTime.TIME_COL_GOLS,
        };

        String selection = BDContract.BDTime.TIME_NOME + " = ?";
        String[] selectionArgs = { time };

        Cursor cursor = bd.query(
                BDContract.BDTime.TIME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            resp = new Time(cursor.getInt(cursor.getColumnIndexOrThrow(BDContract.BDTime._ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDContract.BDTime.TIME_NOME)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BDContract.BDTime.TIME_GOLS)),
                    cursor.getFloat(cursor.getColumnIndexOrThrow(BDContract.BDTime.TIME_PTS)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BDContract.BDTime.TIME_COL_PTS)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BDContract.BDTime.TIME_COL_GOLS)));
            cursor.close();
        }
        return resp;
    }

    public static List<Time> listaTimes(Context context, int col){
        BDHelper bdHelper = new BDHelper(context);
        SQLiteDatabase bd = bdHelper.getReadableDatabase();
        List<Time> listaTimes = null;

        Cursor cursor;
        if(col==1) cursor = bd.rawQuery("SELECT * FROM TIME ORDER BY "+BDContract.BDTime.TIME_COL_PTS, null);
        else cursor = bd.rawQuery("SELECT * FROM TIME ORDER BY "+BDContract.BDTime.TIME_COL_GOLS, null);

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            listaTimes = new ArrayList<>();
            do {
                Time time = new Time(cursor.getInt(cursor.getColumnIndexOrThrow(BDContract.BDTime._ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BDContract.BDTime.TIME_NOME)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(BDContract.BDTime.TIME_GOLS)),
                        cursor.getFloat(cursor.getColumnIndexOrThrow(BDContract.BDTime.TIME_PTS)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(BDContract.BDTime.TIME_COL_PTS)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(BDContract.BDTime.TIME_COL_GOLS)));
                listaTimes.add(time);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return listaTimes;
    }

    public static Jogador buscaJogador(String jogador, Context context){
        Jogador resp = null;
        BDHelper bdHelper = new BDHelper(context);
        SQLiteDatabase bd = bdHelper.getReadableDatabase();

        Cursor cursor = bd.rawQuery(
                "SELECT * FROM "+ BDContract.BDJogador.JOGADOR + " WHERE " + BDContract.BDJogador.JOGADOR + " = '" + jogador +"'", null);

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            resp = new Jogador(cursor.getInt(cursor.getColumnIndexOrThrow(BDContract.BDJogador._ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDContract.BDJogador.JOGADOR_NOME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDContract.BDJogador.JOGADOR_TIME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDContract.BDJogador.JOGADOR_POS)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BDContract.BDJogador.JOGADOR_JOGOS)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BDContract.BDJogador.JOGADOR_GOLS)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BDContract.BDJogador.JOGADOR_MIN)),
                    cursor.getFloat(cursor.getColumnIndexOrThrow(BDContract.BDJogador.JOGADOR_PTS)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BDContract.BDJogador.JOGADOR_COL)));
            cursor.close();
        }
        return resp;
    }

    public static List<Jogador> buscaJogadores(String posicao, Context context){
        List<Jogador> jogadores = null;
        BDHelper bdHelper = new BDHelper(context);
        SQLiteDatabase bd = bdHelper.getReadableDatabase();

        String selection = BDContract.BDJogador.JOGADOR_POS + " = ?";
        String[] projection = {
                BDContract.BDJogador._ID,
                BDContract.BDJogador.JOGADOR_NOME,
                BDContract.BDJogador.JOGADOR_TIME,
                BDContract.BDJogador.JOGADOR_POS,
                BDContract.BDJogador.JOGADOR_JOGOS,
                BDContract.BDJogador.JOGADOR_GOLS,
                BDContract.BDJogador.JOGADOR_MIN,
                BDContract.BDJogador.JOGADOR_PTS,
                BDContract.BDJogador.JOGADOR_COL
        };
        //Cursor cursor = bd.query(BDContract.BDJogador.JOGADOR, projection, selection, null, null, BDContract.BDJogador.JOGADOR_COL);
        Cursor cursor = bd.rawQuery(
                "SELECT * FROM "+ BDContract.BDJogador.JOGADOR + " WHERE " + BDContract.BDJogador.JOGADOR_POS + " = '" + posicao + "'", null);


        if(cursor.getCount()>0){
            cursor.moveToFirst();
            jogadores = new ArrayList<>();
            do {
                Jogador jogador = new Jogador(cursor.getInt(cursor.getColumnIndexOrThrow(BDContract.BDJogador._ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BDContract.BDJogador.JOGADOR_NOME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BDContract.BDJogador.JOGADOR_TIME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BDContract.BDJogador.JOGADOR_POS)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(BDContract.BDJogador.JOGADOR_JOGOS)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(BDContract.BDJogador.JOGADOR_GOLS)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(BDContract.BDJogador.JOGADOR_MIN)),
                        cursor.getFloat(cursor.getColumnIndexOrThrow(BDContract.BDJogador.JOGADOR_PTS)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(BDContract.BDJogador.JOGADOR_COL)));
                jogadores.add(jogador);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return jogadores;
    }
}

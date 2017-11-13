package com.learn2fantasy.learn2fantasy.listView;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.learn2fantasy.learn2fantasy.R;
import com.learn2fantasy.learn2fantasy.bd.Jogador;
import com.learn2fantasy.learn2fantasy.bd.Time;
import java.util.List;

public class ListViewTimePts extends BaseAdapter {

    private final List<Time> times;
    private final List<Jogador> jogadores;
    private final Activity act;
    private final int cool;

    public ListViewTimePts(List<Time> times, List<Jogador> jogadores, Activity act, int cool) {
        this.times = times;
        this.jogadores = jogadores;
        this.act = act;
        this.cool = cool;
    }

    @Override
    public int getCount() {
        if(jogadores==null) return times.size();
        else return jogadores.size();
    }

    @Override
    public Object getItem(int position) {
        if(jogadores==null) return times.get(position);
        else return jogadores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(jogadores==null){
            view = act.getLayoutInflater().inflate(R.layout.list_view_time_pts_cont, parent, false);
            Time time = times.get(position);

            if(cool==1){
                TextView col = (TextView) view.findViewById(R.id.listViewPtsCont_pos);
                TextView nome = (TextView) view.findViewById(R.id.listViewPtsCont_nome);
                TextView pts = (TextView) view.findViewById(R.id.listViewPtsCont_pts);

                col.setText(Integer.toString(time.getCol_pts()));
                nome.setText(time.getNome());
                pts.setText(Float.toString(time.getPts()));
            }
            else{
                TextView col = (TextView) view.findViewById(R.id.listViewPtsCont_pos);
                TextView nome = (TextView) view.findViewById(R.id.listViewPtsCont_nome);
                TextView gols = (TextView) view.findViewById(R.id.listViewPtsCont_pts);

                col.setText(Integer.toString(time.getCol_gols()));
                nome.setText(time.getNome());
                gols.setText(Integer.toString(time.getGols()));
            }
        }
        else{
            if(cool==0){
                view = act.getLayoutInflater().inflate(R.layout.list_view_jogador_ranking_cont, parent, false);
                Jogador jogador = jogadores.get(position);
                TextView col = (TextView) view.findViewById(R.id.list_exiRankJog_col);
                TextView nome = (TextView) view.findViewById(R.id.list_exiRankJog_nome);
                TextView time = (TextView) view.findViewById(R.id.list_exiRankJog_time);
                TextView pts = (TextView) view.findViewById(R.id.list_exiRankJog_pts);

                col.setText(Integer.toString(jogador.getCol()));
                nome.setText(jogador.getNome());
                time.setText(jogador.getTime());
                pts.setText(Float.toString(jogador.getPts()));
            }
            else{
                view = act.getLayoutInflater().inflate(R.layout.list_view_escolher_jogadores_ordenado, parent, false);
                Jogador jogador = jogadores.get(position);
                TextView nome = (TextView) view.findViewById(R.id.listViewJogOrd_nome);
                TextView time = (TextView) view.findViewById(R.id.listViewJogOrd_time);
                TextView pos = (TextView) view.findViewById(R.id.listViewJogOrd_pos);

                nome.setText(jogador.getNome());
                time.setText(jogador.getTime());
                pos.setText(jogador.getpPosicao());
            }
        }
        return view;
    }
}

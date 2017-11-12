package com.learn2fantasy.learn2fantasy.bd;

public class Time {
    private int id;
    private  String nome;
    private int gols;
    private float pts;
    private int col_gols;
    private int col_pts;

    Time(int id, String nome, int gols, float pts, int col_pts, int col_gols){
        this.id = id;
        this.nome = nome;
        this.gols = gols;
        this.pts = pts;
        this.col_pts = col_pts;
        this.col_gols = col_gols;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getGols() {
        return gols;
    }

    public float getPts() {
        return pts;
    }

    public int getCol_gols() {
        return col_gols;
    }

    public int getCol_pts() { return col_pts; }

}

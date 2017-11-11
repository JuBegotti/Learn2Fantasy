package com.learn2fantasy.learn2fantasy.bd;

public class Time {
    private int id;
    private  String nome;
    private int gols;
    private float pts;
    private int col_gols;
    private int col_pts;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getGols() {
        return gols;
    }
    public void setGols(int gols) {
        this.gols = gols;
    }

    public float getPts() {
        return pts;
    }
    public void setPts(float pts) {
        this.pts = pts;
    }

    public int getCol_gols() {
        return col_gols;
    }
    public void setCol_gols(int col_gols) {
        this.col_gols = col_gols;
    }

    public int getCol_pts() {
        return col_pts;
    }
    public void setCol_pts(int col_pts) {
        this.col_pts = col_pts;
    }

}

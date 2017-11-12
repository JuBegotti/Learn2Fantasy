package com.learn2fantasy.learn2fantasy.bd;

public class Jogador {
    private int id;
    private String nome;
    private String time;
    private String posicao;
    private int jogos;
    private int gols;
    private int minutos;
    private float pts;
    private int col;

    Jogador(int id, String nome, String time, String posicao, int jogos, int gols, int minutos, float pts, int col){
        this.id = id;
        this.nome = nome;
        this.time = time;
        this.posicao = posicao;
        this.jogos = jogos;
        this.gols = gols;
        this.minutos = minutos;
        this.pts = pts;
        this.col = col;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTime() {
        return time;
    }

    public String getpPosicao() {
        return posicao;
    }

    public int getJogos() {
        return jogos;
    }

    public int getGols() {
        return gols;
    }

    public int getMinutos() {
        return minutos;
    }

    public float getPts() {
        return pts;
    }

    public int getCol() {
        return col;
    }
}

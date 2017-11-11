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

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public String getpPosicao() {
        return posicao;
    }
    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getJogos() {
        return jogos;
    }
    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

    public int getGols() {
        return gols;
    }
    public void setGols(int gols) {
        this.gols = gols;
    }

    public int getMinutos() {
        return minutos;
    }
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public float getPts() {
        return pts;
    }
    public void setPts(float pts) {
        this.pts = pts;
    }

    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
}

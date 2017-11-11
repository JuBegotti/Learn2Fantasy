package com.learn2fantasy.learn2fantasy.bd;

import android.provider.BaseColumns;

public class BDContract {

    private BDContract() {}

    public static class BDTime implements BaseColumns {

        public static final String TIME = "time";
        public static final String TIME_NOME = "time_nome";
        public static final String TIME_GOLS = "time_gols";
        public static final String TIME_PTS = "time_pts";
        public static final String TIME_COL_PTS = "time_col_pts";
        public static final String TIME_COL_GOLS = "time_col_gols";
    }

    public static class BDJogador implements BaseColumns {

        public static final String JOGADOR = "jogador";
        public static final String JOGADOR_NOME = "jogador_nome";
        public static final String JOGADOR_TIME = "jogador_time";
        public static final String JOGADOR_POS = "jogador_pos";
        public static final String JOGADOR_JOGOS = "jogador_jogos";
        public static final String JOGADOR_GOLS = "jogador_gols";
        public static final String JOGADOR_MIN = "jogador_min";
        public static final String JOGADOR_PTS = "jogador_pts";
        public static final String JOGADOR_COL = "jogador_col";

    }
}

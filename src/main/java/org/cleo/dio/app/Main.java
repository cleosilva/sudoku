package org.cleo.dio.app;


import org.cleo.dio.core.SudokuGame;
import org.cleo.dio.ui.SudokuGUI;

public class Main {
    public static void main(String[] args) {
        int[][] iniciais = {
                {0, 0, 5}, {0, 1, 3}, {1, 0, 6}, {1, 4, 7}, {2, 1, 9}, {2, 2, 8}
        };

        SudokuGame jogo = new SudokuGame();
        jogo.iniciarNovoJogo(iniciais);
        new SudokuGUI(jogo);
    }
}

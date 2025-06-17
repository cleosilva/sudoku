package org.cleo.dio.app;


import org.cleo.dio.core.SudokuGame;

public class Main {
    public static void main(String[] args) {
        SudokuGame jogo = new SudokuGame();

        int[][] iniciais = {
                {0, 0, 5},
                {0, 1, 3},
                {1, 0, 6}
        };

        jogo.iniciarNovoJogo(iniciais);
        System.out.println("Status: " + jogo.getStatus());

        jogo.inserirNumero(0, 2, 5); // inválido
        jogo.inserirNumero(0, 2, 4); // válido
        jogo.removerNumero(0, 2);
        jogo.limparTabuleiro();
    }
}

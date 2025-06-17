package org.cleo.dio.utils;

import org.cleo.dio.model.SudokuCell;

public class Validator {

    public static boolean ehValido(SudokuCell[][] board, int x, int y, int valor){
        for (int i = 0; i < 9; i++){
            if (i != x && board[i][y].getValor() == valor) return false;
            if (i != y && board[x][i].getValor() == valor) return false;
        }
        int blocoLinha = (x / 3) * 3;
        int blocoColuna = (y / 3) * 3;
        for(int i = blocoLinha; i < blocoLinha + 3; i++){
            for (int j = blocoColuna; j < blocoColuna + 3; j++){
                if ((i != x || j != y) && board[i][j].getValor() == valor){
                    return false;
                }
            }
        }
        return true;
    }
}

package org.cleo.dio.core;

import org.cleo.dio.enums.GameStatus;
import org.cleo.dio.model.SudokuCell;
import org.cleo.dio.utils.Validator;

public class SudokuGame {
    private SudokuCell[][] board;
    private GameStatus status;
    private boolean iniciado;

    public SudokuGame() {
        board = new SudokuCell[9][9];
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                board[i][j] = new SudokuCell();
            }
        }
        this.status = GameStatus.NAO_INICIADO;
        this.iniciado = false;
    }

    public void iniciarNovoJogo(int[][] numerosIniciais){
        for (int[] posicao : numerosIniciais){
            int x = posicao[0];
            int y = posicao[1];
            int valor = posicao[2];

            SudokuCell cell = board[x][y];
            cell.setValor(valor);
            cell.setFixo(true);
        }
        this.iniciado = true;
        atualizarStatus();
    }

    public boolean inserirNumero(int x, int y, int valor) {
        SudokuCell cell = board[x][y];

        if (cell.isFixo() || cell.getValor() != 0){
            return false;
        }

        cell.setValor(valor);
        cell.limparRascunho();
        atualizarStatus();
        return true;
    }

    public boolean removerNumero(int x, int y){
        SudokuCell cell = board[x][y];
        if (cell.isFixo()){
            return false;
        }

        cell.setValor(0);
        cell.limparRascunho();
        atualizarStatus();
        return true;
    }

    public void limparTabuleiro(){
        for (SudokuCell[] row : board){
            for (SudokuCell cell : row){
                if(!cell.isFixo()){
                    cell.setValor(0);
                    cell.limparRascunho();
                }
            }
        }
        atualizarStatus();
    }

    public SudokuCell[][] getBoard() {
        return board;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void atualizarStatus(){
        if(!iniciado){
            status = GameStatus.NAO_INICIADO;
            return;
        }
        boolean completo = true;
        boolean temErro = false;

        for (int i = 0; i < 9 && !temErro; i++){
            for (int j = 0; j < 9; j++){
                int valor = board[i][j].getValor();
                if(valor == 0){
                    completo = false;
                } else if (!Validator.ehValido(board, i, j, valor)) {
                    temErro = true;
                    break;
                }
            }
        }
        if(completo && !temErro){
            status = GameStatus.COMPLETO_SEM_ERROS;
        } else if (completo && temErro) {
            status = GameStatus.COMPLETO_COM_ERROS;
        } else if (!completo && temErro) {
            status = GameStatus.INCOMPLETO_COM_ERROS;
        } else {
            status = GameStatus.INCOMPLETO_SEM_ERROS;
        }
    }
}

package org.cleo.dio.model;

import java.util.HashSet;
import java.util.Set;

public class SudokuCell {
    private int valor;
    private boolean isFixo;
    private Set<Integer> rascunhos;

    public SudokuCell() {
        this.valor = 0;
        this.isFixo = false;
        this.rascunhos = new HashSet<>();
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isFixo() {
        return isFixo;
    }

    public void setFixo(boolean fixo) {
        isFixo = fixo;
    }

    public Set<Integer> getRascunhos() {
        return rascunhos;
    }

    public void adicionarRascunho(int numero){
        rascunhos.add(numero);
    }

    public void removerRascunho(int numero){
        rascunhos.remove(numero);
    }

    public void limparRascunho(){
        rascunhos.clear();
    }
}

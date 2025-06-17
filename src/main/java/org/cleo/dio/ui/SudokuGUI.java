package org.cleo.dio.ui;

import org.cleo.dio.core.SudokuGame;
import org.cleo.dio.model.SudokuCell;

import javax.swing.*;
import java.awt.*;

public class SudokuGUI extends JFrame {
    private final SudokuGame jogo;
    private final JTextField[][] campos = new JTextField[9][9];

    public SudokuGUI(SudokuGame jogo){
        this.jogo = jogo;
        setTitle("Jogo Sudoku");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(criarPainelTabuleiro(), BorderLayout.CENTER);

        add(criarMenuLateral(), BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null); // centraliza na tela
        setVisible(true);
    }

    private JPanel criarPainelTabuleiro() {
        JPanel painel = new JPanel(new GridLayout(9, 9));

        SudokuCell[][] board = jogo.getBoard();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JTextField campo = new JTextField();
                campo.setHorizontalAlignment(JTextField.CENTER);
                campos[i][j] = campo;

                if (board[i][j].isFixo()) {
                    campo.setText(String.valueOf(board[i][j].getValor()));
                    campo.setEditable(false);
                    campo.setBackground(Color.LIGHT_GRAY);
                }

                painel.add(campo);
            }
        }

        return painel;
    }

    private JPanel criarMenuLateral() {
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));

        JButton inserir = new JButton("Inserir Número");
        JButton remover = new JButton("Remover Número");
        JButton limpar = new JButton("Limpar");
        JButton status = new JButton("Ver Status");
        JButton finalizar = new JButton("Finalizar");

        inserir.addActionListener(e -> inserirNumero());
        remover.addActionListener(e -> removerNumero());
        limpar.addActionListener(e -> {
            jogo.limparTabuleiro();
            atualizarTabuleiro();
        });
        status.addActionListener(e -> {
            jogo.atualizarStatus();
            JOptionPane.showMessageDialog(this, "Status: " + jogo.getStatus());
        });
        finalizar.addActionListener(e -> {
            jogo.atualizarStatus();
            if (jogo.getStatus().name().contains("COMPLETO_SEM_ERROS")) {
                JOptionPane.showMessageDialog(this, "Parabéns! Jogo completo e correto!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "O jogo ainda não está completo ou contém erros.");
            }
        });

        menu.add(Box.createVerticalStrut(20));
        menu.add(inserir);
        menu.add(Box.createVerticalStrut(10));
        menu.add(remover);
        menu.add(Box.createVerticalStrut(10));
        menu.add(limpar);
        menu.add(Box.createVerticalStrut(10));
        menu.add(status);
        menu.add(Box.createVerticalStrut(10));
        menu.add(finalizar);

        return menu;
    }

    private void atualizarTabuleiro() {
        SudokuCell[][] board = jogo.getBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JTextField campo = campos[i][j];
                int valor = board[i][j].getValor();
                campo.setText(valor == 0 ? "" : String.valueOf(valor));

                if (!board[i][j].isFixo()) {
                    campo.setEditable(true);
                    campo.setBackground(Color.WHITE);
                } else {
                    campo.setEditable(false);
                    campo.setBackground(Color.LIGHT_GRAY);
                }
            }
        }
    }

    private void inserirNumero() {
        try {
            int x = Integer.parseInt(JOptionPane.showInputDialog(this, "Linha (0-8):"));
            int y = Integer.parseInt(JOptionPane.showInputDialog(this, "Coluna (0-8):"));
            int valor = Integer.parseInt(JOptionPane.showInputDialog(this, "Valor (1-9):"));

            boolean sucesso = jogo.inserirNumero(x, y, valor);
            if (!sucesso) {
                JOptionPane.showMessageDialog(this, "Posição inválida ou ocupada.");
            }
            atualizarTabuleiro();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Entrada inválida.");
        }
    }

    private void removerNumero() {
        try {
            int x = Integer.parseInt(JOptionPane.showInputDialog(this, "Linha (0-8):"));
            int y = Integer.parseInt(JOptionPane.showInputDialog(this, "Coluna (0-8):"));

            boolean sucesso = jogo.removerNumero(x, y);
            if (!sucesso) {
                JOptionPane.showMessageDialog(this, "Essa posição é fixa e não pode ser removida.");
            }
            atualizarTabuleiro();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Entrada inválida.");
        }
    }
}

# 🧩 Sudoku em Java (com Swing)

Este é um projeto de jogo de Sudoku desenvolvido em **Java** com **interface gráfica (Swing)**. O jogo permite ao jogador interagir com um tabuleiro 9x9, preencher os números, verificar o status e finalizar a partida. O projeto foi estruturado com boas práticas de orientação a objetos e separação de responsabilidades.

---

## 🎯 Funcionalidades

- ✅ Iniciar um novo jogo com números iniciais predefinidos
- 📝 Inserir número em células editáveis
- ❌ Remover número inserido pelo jogador
- 🔍 Verificar a situação atual do tabuleiro
- 📊 Verificar o status do jogo:
    - Não iniciado
    - Incompleto
    - Completo
    - Com ou sem erros (validação de regras do Sudoku)
- ♻️ Limpar o tabuleiro (mantém os números fixos)
- ✅ Finalizar o jogo (somente se estiver completo e válido)

---

## 🖼️ Interface Gráfica

- Desenvolvida com **Swing (JFrame, JPanel, JTextField, JButton)**.
- O tabuleiro é um grid 9x9 de campos de texto.
- Menu lateral com botões interativos.
- Células fixas (iniciais) são destacadas em cinza e não podem ser editadas.

---

## 🚀 Como executar o projeto

### 1. Requisitos

- Java 8 ou superior
- IDE (IntelliJ, Eclipse, VSCode) ou terminal com `javac`/`java`

### 2. Estrutura do projeto

````bash
sudoku-java/
├── app/
│ └── Main.java
├── core/
│ └── SudokuGame.java
├── model/
│ └── SudokuCell.java
├── ui/
│ └── SudokuGUI.java
├── utils/
│ └── Validator.java
└── README.md
````


### 3. Compilar e rodar via terminal (opcional)

```bash
javac app/Main.java
java app.Main
4. Via IDE
Importe o projeto em sua IDE Java favorita

Rode a classe Main.java

🧠 Conceitos aplicados
Programação Orientada a Objetos (POO)

Separação de responsabilidades: UI, lógica de jogo, validação

Interface gráfica com Swing

Validação de regras do Sudoku (linhas, colunas e subgrids 3x3)

🌱 Melhorias futuras
 Suporte a rascunho nas células

 Gerador automático de tabuleiros

 Validação visual (destacar erros no tabuleiro)

 Timer e placar

 Modo escuro

👩‍💻 Autoria
Desenvolvido por Cleo Silva como desafio prático de Java com foco em POO e interfaces gráficas Bootcamp Santander DIO.

📜 Licença
Este projeto é de uso livre para fins educacionais. Modifique à vontade!
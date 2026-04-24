import java.util.Random;
import java.util.Scanner;

class JogoDaVelha {

    private Jogador jogador1;
    private Jogador jogador2;
    private Tabuleiro tabuleiro;

    public JogoDaVelha(Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tabuleiro = tabuleiro;
    }

    public void iniciar() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scan.nextLine();
        System.out.print("\n");

        char simboloEscolhido = ' ';

        while (simboloEscolhido != 'X' && simboloEscolhido != 'O') {
            System.out.print("Digite qual simbolo ('X' ou 'O') quer usar: ");
            simboloEscolhido = scan.nextLine().charAt(0);

            if (simboloEscolhido != 'X' && simboloEscolhido != 'O') {
                System.out.println("Digite um simbolo válido");
            }

            System.out.print("\n");
        }

        char simboloNaoEscolhido;

        if (simboloEscolhido == 'X') {
            simboloNaoEscolhido = 'O';
        } else {
            simboloNaoEscolhido = 'X';
        }

        this.jogador1 = new Jogador(simboloEscolhido);
        this.jogador2 = new Jogador(simboloNaoEscolhido);

        int linha = -1;
        int coluna = -1;

        Random random = new Random();

        String jogadorAtual = "";

        int partida = 1;

        while (!tabuleiro.acabouOJogo()) {
            System.out.println("Partida " + partida);
            System.out.print("\n");

            do {
                linha = -1;
                coluna = -1;

                while (linha < 0 || linha > 2) {
                    System.out.print("Digite a linha (0,1,2): ");
                    linha = scan.nextInt();

                    if (linha < 0 || linha > 2) {
                        System.out.println("Digite um número válido");
                    }

                    System.out.print("\n");
                }

                while (coluna < 0 || coluna > 2) {
                    System.out.print("Digite a coluna (0,1,2): ");
                    coluna = scan.nextInt();

                    if (coluna < 0 || coluna > 2) {
                        System.out.println("Digite um número válido");
                    }

                    System.out.print("\n");
                }

                jogadorAtual = nome;

            } while (!tabuleiro.jogar(jogador1, linha, coluna, nome, true));

            System.out.print("\n");

            if (tabuleiro.acabouOJogo()) {
                break;
            }

            do {
                linha = random.nextInt(0, 3);
                coluna = random.nextInt(0, 3);

                jogadorAtual = "Bot";

            } while (!tabuleiro.jogar(jogador2, linha, coluna, "Bot", false));

            partida++;
        }

        if (tabuleiro.haUmVencedor()) {
            System.out.println(jogadorAtual + " ganhou!");
        } else {
            System.out.println("O jogo terminou empatado.");
        }
    }

    public static void main(String[] args) {
        Jogador jogador1 = new Jogador('X');
        Jogador jogador2 = new Jogador('O');
        Tabuleiro tabuleiro = new Tabuleiro();

        JogoDaVelha jogoDaVelha = new JogoDaVelha(jogador1, jogador2, tabuleiro);

        jogoDaVelha.iniciar();
    }
}
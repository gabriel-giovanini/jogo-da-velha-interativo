
import java.util.Random;
import java.util.Scanner;

class JogoDaVelha {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scan.nextLine();
        System.out.print("\n");

        char simboloEscolhido = ' ';

        while (simboloEscolhido != 'X' && simboloEscolhido != 'O') {
            System.out.print("Digite qual simbolo('X' ou 'O') quer usar: ");
            simboloEscolhido = scan.nextLine().charAt(0);

            if (simboloEscolhido != 'X' && simboloEscolhido != 'O') {
                System.out.println("Digite um simbolo válido");
            }

            System.out.print("\n");
        }

        char simboloNaoEscolhido = ' ';

        if (simboloEscolhido == 'X') {
            simboloNaoEscolhido = 'O';
        } else {
            simboloNaoEscolhido = 'X';
        }

        Jogador jogador1, jogador2;
        jogador1 = new Jogador(simboloEscolhido);
        jogador2 = new Jogador(simboloNaoEscolhido);

        Tabuleiro tabuleiro = new Tabuleiro();

        int linha = -1;
        int coluna = -1;

        Random random = new Random();

        String jogadorAtual = " ";

        // Enquanto não acabou o jogo
        int partida = 1;
        while (!tabuleiro.acabouOJogo()) {
            System.out.println("Partida " + partida);
            System.out.print("\n");
            
            do {
                linha = -1;
                coluna = -1; 

                while (linha < 0 || linha > 2) {
                    System.out.print("Digite o número da linha que você quer atribuir seu simbolo: ");
                    linha = scan.nextInt();
                    
                    if (linha != 0 && linha != 1 && linha !=2) {
                        System.out.println("Digite um número válido");
                       
                    }
                    System.out.print("\n");
                }

                while (coluna != 0 && coluna != 1 && coluna !=2) {
                    System.out.print("Digite o número da coluna que você quer atribuir seu simbolo: ");
                    coluna = scan.nextInt();
                    

                    if (coluna < 0 || coluna > 2) {
                        System.out.println("Digite um número válido");
                        System.out.print("\n");
                    }
                }

                jogadorAtual = "jogador 1";


            } while (!tabuleiro.jogar(jogador1, linha, coluna, nome));

            System.out.print("\n");

            if (tabuleiro.acabouOJogo()) {
                break;
            }

            do {
                linha = random.nextInt(0, 3);
                coluna = random.nextInt(0, 3);

                
                jogadorAtual = "jogador 2";  
            } while (!tabuleiro.jogar(jogador2, linha, coluna, "Bot"));

            partida++;                 
        }


        if (tabuleiro.haUmVencedor()) {
            System.out.println("O " + jogadorAtual + " ganhou");
        } else{
            System.out.println("O jogo terminou empatado.");
        }

        System.out.println("Gabriel Giovanini");
    }
}

public class Jogador {
    private char simbolo;

    private static int contador;

    private int ordem;

    public Jogador(char simbolo)
    {
        this.simbolo = simbolo;
        Jogador.contador++;
        this.ordem = Jogador.contador;
    }

    public char getSimbolo()
    {
        return this.simbolo;
    }    

    public int getOrdem(){
        return this.ordem;
    }
}
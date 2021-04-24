package apsv1;

public class Main {

    public static void main(String[] args) {
        Player jogador = new Player();
        PerguntaMultiplaEscolha p1 = new PerguntaMultiplaEscolha();

        p1.executarPergunta(1,jogador);
        jogador.defineResultado();
        System.out.println(jogador.getPontuacao());
    }

}

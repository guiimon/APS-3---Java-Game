package quiz_v3;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        System.out.println("Digite seu nome:");
        Scanner tecla = new Scanner(System.in);
        String nome = tecla.nextLine();
        System.out.println("");
        
        Player jogador = new Player(nome);
        PerguntaMultiplaEscolha pm = new PerguntaMultiplaEscolha();
        PerguntaComplexa pc = new PerguntaComplexa();
        PerguntaNumerica pn = new PerguntaNumerica();
        PerguntaSN psn = new PerguntaSN();

        psn.executarPergunta(0, jogador);
        //jogador.defineResultado();
        
        pn.executarPergunta(0, jogador);
        //jogador.defineResultado();

        pm.executarPergunta(0,jogador);
        //jogador.defineResultado();
        //System.out.println(jogador.getPontuacao());
        
        pc.executarPergunta(0, jogador);
        jogador.defineResultado();
        //System.out.println(jogador.getPontuacao());           
         
        //Gerenciador gen = new Gerenciador();
    }

}

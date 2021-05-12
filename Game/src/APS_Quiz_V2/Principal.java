
package APS_Quiz_V2;

import java.util.Scanner;
public class Principal {  
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Player jogador = new Player();
        PerguntaMultiplaEscolha p1 = new PerguntaMultiplaEscolha();
        //PerguntaComplexa p2 = new PerguntaComplexa();
        
        //p1.executarPergunta(0,jogador);
        //jogador.defineResultado();
        //System.out.println(jogador.getPontuacao());
        
        /*
        p2.executarPergunta(0, jogador);
        jogador.defineResultado();
        System.out.println(jogador.getPontuacao());           
        */
        
        Gerenciador gen = new Gerenciador();
        
    }
}

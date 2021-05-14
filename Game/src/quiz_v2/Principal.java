package quiz_v2;

public class Principal {

    public static void main(String[] args) {

        Player jogador = new Player();
        PerguntaMultiplaEscolha pm = new PerguntaMultiplaEscolha();
        PerguntaComplexa pc = new PerguntaComplexa();
        PerguntaNumerica pn = new PerguntaNumerica();
        PerguntaSN psn = new PerguntaSN();

        //psn.executarPergunta(0, jogador);
        //jogador.defineResultado();
        
        //pn.executarPergunta(0, jogador);
        //jogador.defineResultado();

        //pm.executarPergunta(0,jogador);
        //jogador.defineResultado();
        //System.out.println(jogador.getPontuacao());
        
        pc.executarPergunta(0, jogador);
        jogador.defineResultado();
        //System.out.println(jogador.getPontuacao());           
         
        //Gerenciador gen = new Gerenciador();
    }

}

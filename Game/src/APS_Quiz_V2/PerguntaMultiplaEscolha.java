
package  APS_Quiz_V2;

public class PerguntaMultiplaEscolha extends Pergunta {
    //Atributos:

    //Construtor:
    public PerguntaMultiplaEscolha() {
        super(numeroPerguntas);
        definirPerguntas(perguntas);
    }

    //Principal:
    @Override
    public void definirPerguntas(String[][] pergunta) {
        pergunta[0][0] = "Que cor as bananas tem quando madura?\n"
                       + "a) Verde\n"
                       + "b) Amarelo\n"
                       + "c) Rosa\n"
                       + "d) RGB\n";
        pergunta[0][1] = "b";

        pergunta[1][0] = "Qual a cor da laranja?\n"
                       + "a) verde\n"
                       + "b) azul\n"
                       + "c) amarelo\n"
                       + "d) laranja\n";
        pergunta[1][1] = "d";

    }
    
    @Override
    public void checarResposta(int numeroPergunta, String resposta, Player jogador) {
        if(getPerguntas()[numeroPergunta][2].equals(resposta.toLowerCase()) ) {
                jogador.adicionaPontos();
        }else {
                jogador.retiraPontos();
        }
    }

    public void executarPergunta(int numero, Player jogador) {
        System.out.println(getPerguntas()[numero][0]);
        System.out.println(getPerguntas()[numero][1]);
        String resposta = super.getTecla().nextLine();
        checarResposta(numero, resposta, jogador);
    }

}

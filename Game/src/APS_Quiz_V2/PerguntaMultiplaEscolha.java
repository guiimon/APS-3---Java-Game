
package  APS_Quiz_V2;

public class PerguntaMultiplaEscolha extends Pergunta {
//a classe precisa de um novo nome já que terá perguntas dissertativas além das de multipla escolha
    private static int numeroPerguntas = 5;
    private final String[][] perguntas = new String[getQtdPerguntas()][2];
    
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
        
        pergunta[2][0] = "O efeito estufa é um evento decorrente da quebra da camada de ozônio?\n"+
                         "Respondam com [s] para sim e [n] para não.\n";                      
        pergunta[2][1] = "não";
        
        pergunta[3][0] = "Devido as grandes queimadas que ocorreram na Amozônia um fenômeno não muito \n"+
                         "comum ocorreu em São Paulo, a chuva negra. Em que ano isso aconteceu?\n"+
                         "Digite o ano:";
        pergunta[3][1] = "2019";

    }
    
    @Override
    public void checarResposta(int numeroPergunta, String resposta, Player jogador) {
        if(getPerguntas()[numeroPergunta][1].equals(resposta.toLowerCase()) ) {
                jogador.adicionaPontos();
        } else {
                jogador.retiraPontos();
        }
    }
    
    @Override
    public void executarPergunta(int numero, Player jogador) {
        System.out.println(getPerguntas()[numero][0]);
        String resposta = super.getTecla().nextLine();
        verificar(resposta);
        checarResposta(numero, resposta, jogador);
    }

    public String[][] getPerguntas() {
        return perguntas;
    }
}


package APS_Quiz_V2;


public class PerguntaDissertativa extends Pergunta {
    
    //Construtor:
    public PerguntaDissertativa() {
        super(numeroPerguntas);
        definirPerguntas(perguntas);
    }
    
    //Principal:    
    @Override
    public void definirPerguntas(String[][] pergunta) {
        pergunta[2][0] = "O efeito estufa é um evento decorrente da quebra da camada de ozônio?\n"
                        + "sim\n"
                        + "não\n";
        pergunta[2][1] = "não";
        
        pergunta[3][0] = "Devido as grandes queimadas que ocorreram na Amozônia um fenômeno não muito \n"+
                         "comum ocorreu em São Paulo, a chuva negra. Em que ano isso aconteceu?\n";
        pergunta[3][1] = "2019";
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

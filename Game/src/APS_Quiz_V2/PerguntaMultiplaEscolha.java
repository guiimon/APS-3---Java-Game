
package  APS_Quiz_V2;

public class PerguntaMultiplaEscolha extends Pergunta {
//a classe precisa de um novo nome ja que tera perguntas dissertativas alem das de multipla escolha
    private static int numeroPerguntas = 10;
    private final String[][] perguntas = new String[getQtdPerguntas()][2];
    private final char[] respostas = new char[numeroPerguntas];
    
    //Construtor:
    public PerguntaMultiplaEscolha() {
        super(numeroPerguntas);
        definirPerguntas(perguntas);
    }
    
    //getter e setters
    public String[][] getPerguntas() {
        return perguntas;
    }
    
    //Principal:
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
        
        pergunta[2][0] = "O efeito estufa e um evento decorrente da quebra da camada de ozonio?\n"+
                         "Respondam com [s] para sim e [n] para nao.\n";                      
        pergunta[2][1] = "nao";
        
        pergunta[3][0] = "Devido as grandes queimadas que ocorreram na Amozonia um fenomeno nao muito \n"+
                         "comum ocorreu em Sao Paulo, a chuva negra. Em que ano isso aconteceu?\n"+
                         "Digite o ano:";
        pergunta[3][1] = "2019";

    }
    
    public void checarResposta(int numeroPergunta, String resposta, Player jogador) {
        if(getPerguntas()[numeroPergunta][1].equals(resposta.toLowerCase()) ) {
                jogador.adicionaPontos();
        } else {
                jogador.retiraPontos();
        }
    }
    
    public void executarPergunta(int numero, Player jogador) {
        System.out.println(getPerguntas()[numero][0]);
        String resposta = super.getTecla().nextLine();
        verificar(resposta);
        checarResposta(numero, resposta, jogador);
    }

}

package apsv1;

public class PerguntaMultiplaEscolha extends Pergunta{
    //Atributos:
    private final String[][] perguntas = new String[super.getQtdPerguntas()][3];
    private static int numeroPerguntas = 2;
	
    //Construtor:
    public PerguntaMultiplaEscolha() {
            super(numeroPerguntas);
            definirPerguntas(perguntas);
    }

    //Principal:
    public void checarResposta(int numeroPergunta, String resposta, Player jogador) {
            if(getPerguntas()[numeroPergunta][2].equals(resposta.toLowerCase()) ) {
                    jogador.adicionaPontos();
            }else {
                    jogador.retiraPontos();
            }
    }

    public void definirPerguntas(String[][] pergunta) {
            pergunta[0][0] = "Que cor as bananas tem quando madura?";
            pergunta[0][1] = "a) Verde\n"
                                       + "b) Amarelo\n"
                                       + "c) Rosa\n"
                                       + "d) RGB";
            pergunta[0][2] = "b";

            pergunta[1][0] = "Qual a cor da laranja?";
            pergunta[1][1] = "a) verde\n"
                                       + "b) azul\n"
                                       + "c) amarelo\n"
                                       + "d) laranja";
            pergunta[1][2] = "d";
    }

    public void executarPergunta(int numero, Player jogador) {
            System.out.println(getPerguntas()[numero][0]);
            System.out.println(getPerguntas()[numero][1]);
            String resposta = super.getTecla().nextLine();
            checarResposta(numero, resposta, jogador);
    }

    //Getter
    public String[][] getPerguntas() {
            return perguntas;
    }


}

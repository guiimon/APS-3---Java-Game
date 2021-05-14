package quiz_v2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PerguntaNumerica extends Pergunta {

    private static final int N_PERGUNTAS = 1;
    private String[] perguntas = new String[N_PERGUNTAS];
    private int[] respostas = new int[N_PERGUNTAS];
    private Scanner tecla = new Scanner(System.in);

    public PerguntaNumerica() {
        super(N_PERGUNTAS);
        definirPerguntas();
    }

    @Override
    public void definirPerguntas() {
        perguntas[0] = "Devido as grandes queimadas que ocorreram na Amozonia um fenomeno nao muito \n"
                + "comum ocorreu em Sao Paulo, a chuva negra. Em que ano isso aconteceu?\n"
                + "Digite o ano:";
        respostas[0] = 2019;

    }

    public void checarResposta(int numeroPergunta, int resposta, Player jogador) {                
            if (respostas[numeroPergunta] == resposta) {
                jogador.adicionaPontos();
            } else {
                jogador.retiraPontos();
            }      
    }    

    @Override
    public boolean verificar(String resposta) {
        return !(resposta != null && resposta.matches("[0-9]*") && resposta != "");
    }
    
    @Override
    public void executarPergunta(int numero, Player jogador) {
        int resposta = 0;
        System.out.println(getPerguntas()[numero]);
        String respostaS = tecla.nextLine().trim();
        while (verificar(respostaS)) {
            System.out.println("Resposta Invalida! Digite somente numeros positivos.");
            System.out.println(getPerguntas()[numero]);
            respostaS = tecla.nextLine().trim();           
        }
        
        resposta = Integer.parseInt(respostaS);      
        checarResposta(numero, resposta, jogador);
    }

    //getters
    public String[] getPerguntas() {
        return perguntas;
    }

    public int[] getRespostas() {
        return respostas;
    }

    @Override //como nesse tipo de pergunta o vetor de resposta é int, esse método fica sobrando.
    public void checarResposta(int numeroPergunta, String resposta, Player jogador) {}

}

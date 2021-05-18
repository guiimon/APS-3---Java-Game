package quiz_v3;

import java.util.Scanner;

public abstract class Pergunta {

    //Atributos:
    private static int qtdPerguntas;
    private Scanner tecla = new Scanner(System.in);

    //Construtor:
    public Pergunta(int quantidade) {
        setQtdPerguntas(quantidade);
    }

    //Getters & Setters:
    public Scanner getTecla() {
        return tecla;
    }

    public static int getQtdPerguntas() {
        return qtdPerguntas;
    }

    public static void setQtdPerguntas(int qtdPerguntas) {
        Pergunta.qtdPerguntas = qtdPerguntas;
    }

    //Principal:
    public final static void limpar() {
        //limpa a tela do console 
        
    }

    public abstract void definirPerguntas();

    public abstract void checarResposta(int numeroPergunta, String resposta, Player jogador);

    public abstract void executarPergunta(int numero, Player jogador);

    public boolean verificar(String resposta) {
        //return !"a".equals(resposta) && !"b".equals(resposta) && !"c".equals(resposta) && !"d".equals(resposta) && !"e".equals(resposta);
        return !(resposta != null && resposta.matches("a|b|c|d|e") && !"".equals(resposta));
    }
    
    public void verificarErro(String resposta, String tipo) throws RespostaInvalidaException {
        switch(tipo.toLowerCase().trim()) {
            case "sn":           
                if (verificar(resposta)) {
                    throw new RespostaInvalidaException("Resposta Invalida! Digite somente [s] ou [n].");
                }
                break;
            case "me":
                if (verificar(resposta)) {
                    throw new RespostaInvalidaException("Resposta Invalida! Digite somente umas das alternativas listadas.");
                }
                break;
            case "n":
                if (verificar(resposta)) {
                    throw new RespostaInvalidaException("Resposta Invalida! Digite somente números positivos.");
                }
        }
    }    


}

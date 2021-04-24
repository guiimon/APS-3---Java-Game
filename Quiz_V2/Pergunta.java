package apsv1;

import java.util.Scanner;

public abstract class Pergunta {
    //Atributos:
    private static int qtdPerguntas;
    private Scanner tecla = new Scanner(System.in);
    
    //Contrutor:
    public Pergunta(int quantidade) {
        setQtdPerguntas(quantidade);
    }
    
    //Principal:
    public abstract void checarResposta(int numeroPergunta, String resposta, Player jogador);

    //Getters e Setters
    public Scanner getTecla() {
        return tecla;
    }

    public static int getQtdPerguntas() {
        return qtdPerguntas;
    }

    public static void setQtdPerguntas(int qtdPerguntas) {
        Pergunta.qtdPerguntas = qtdPerguntas;
    }

}

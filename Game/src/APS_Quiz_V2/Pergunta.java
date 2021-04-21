
package  APS_Quiz_V2;

import java.util.Scanner;

public abstract class Pergunta {
    //Atributos:
    private static int qtdPerguntas;
    private Scanner tecla = new Scanner(System.in);
    protected static int numeroPerguntas = 3;
    protected final String[][] perguntas = new String[getQtdPerguntas()][2];


    //Construtor:
    public Pergunta(int quantidade) {
            setQtdPerguntas(quantidade);
    }
    
    //Principal:
    public abstract void definirPerguntas(String[][] pergunta);
    public abstract void checarResposta(int numeroPergunta, String resposta, Player jogador);
    public abstract void executarPergunta(int numero, Player jogador);

    //Geters e Seters:
    public Scanner getTecla() {
            return tecla;
    }

    public static int getQtdPerguntas() {
            return qtdPerguntas;
    }

    public static void setQtdPerguntas(int qtdPerguntas) {
            Pergunta.qtdPerguntas = qtdPerguntas;
    }
    
    public String[][] getPerguntas() {
        return perguntas;
    }

}

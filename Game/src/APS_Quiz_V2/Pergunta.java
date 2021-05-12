
package  APS_Quiz_V2;

import java.util.Scanner;

public abstract class Pergunta {
    //Atributos:
    private static int qtdPerguntas;
    private Scanner tecla = new Scanner(System.in);
    

    //Construtor:
    public Pergunta(int quantidade) {
            setQtdPerguntas(quantidade);
    }
    
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
    
    //Principal:
    public abstract void definirPerguntas(String[][] pergunta);
    public abstract void checarResposta(int numeroPergunta, String resposta, Player jogador);
    public abstract void executarPergunta(int numero, Player jogador);
    
    public void verificar(String resposta) {//verifica se a resposta foi valida a,b,c,d ou e 
        Scanner r  = new Scanner(System.in);
        //acho que pode ser melhorado
        while (!"a".equals(resposta) && !"b".equals(resposta) && !"c".equals(resposta) && !"d".equals(resposta) && !"e".equals(resposta)) {
            System.out.println("Resposta Invalida! Digite somente uma das opcoes acima."); 
            resposta = r.nextLine();        
        }
        r.close();
    }
}

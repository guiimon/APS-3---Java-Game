
package APS_Quiz_V2;

public class Player {
    //Atributos:
    private String nome;
    private int pontuacao;
    private String resultado;

    //Construtor:
    public Player() {
        setNome("Jogador(a)");
        setPontuacao(0);
        setResultado("normal");
    }

    public Player(String nome) {
        setNome(nome);
        setPontuacao(0);
        setResultado("normal");
    }

    //Principal:
    public void adicionaPontos() {
        setPontuacao(getPontuacao()+10);
    }

    public void retiraPontos() {
        setPontuacao(getPontuacao()-10);
    }

    public void defineResultado() {
        System.out.println("Sua pontuação foi de " + getPontuacao() + " pontos.");
        if(getPontuacao() < 0) {
                System.out.println("Seu resultado é pior do que jamais esperávamos, n�o ouse nem sair de casa voc� � um risco.");
        }
        else if(getPontuacao() >= 0 && getPontuacao() <=30) {
                System.out.println("Seu resultado foi mediano, ainda h� muitas coisas para aprender sobre a natureza.");
        }
        else if(getPontuacao() > 30 && getPontuacao() != 50) {
                System.out.println("Otimo resultado, cometeu alguns erros mas est� muito bem em seus conhecimetos sobre a natureza");
        }else {
                System.out.println("Coma nossos cus mestre, n�o h� nada para ser ensinado a voc� aqui.");
        }
    }

    //Geters e Seters 
    public String getNome() {
            return nome;
    }    
    public void setNome(String nome) {
            this.nome = nome;
    }
    public int getPontuacao() {
            return pontuacao;
    }
    public void setPontuacao(int pontuacao) {
            this.pontuacao = pontuacao;
    }
    public String getResultado() {
            return resultado;
    }
    public void setResultado(String resultado) {
            this.resultado = resultado;
    }
}

package quiz_v3;

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
        setPontuacao(getPontuacao() + 10);
    }

    public void retiraPontos() {
        setPontuacao(getPontuacao() - 10);
    }

    public void defineResultado() {
        System.out.println("Sua pontuacao foi de " + getPontuacao() + " pontos.");
        if (getPontuacao() < 0) {
            System.out.println(nome + ", seu resultado e pior do que jamais esperavamos, nao ouse nem sair de casa voce e um risco.");
        } else if (getPontuacao() >= 0 && getPontuacao() <= 30) {
            System.out.println("Seu resultado foi mediano " + nome + ", ainda ha muitas coisas para aprender sobre a natureza.");
        } else if (getPontuacao() > 30 && getPontuacao() != 50) {
            System.out.println("Otimo resultado " + nome + ", cometeu alguns erros mas esta muito bem em seus conhecimetos sobre a natureza");
        } else {                
            System.out.println("Muito bem, meus parabens, " + nome + ", voce e incrivel nao ha nada para ser ensinado a voce aqui.");
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

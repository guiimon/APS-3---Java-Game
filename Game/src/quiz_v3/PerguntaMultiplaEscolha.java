package quiz_v3;

public class PerguntaMultiplaEscolha extends Pergunta {

    private static final int N_PERGUNTAS = 3;
    private final String[] perguntas = new String[getQtdPerguntas()];
    private final String[] respostas = new String[N_PERGUNTAS];

    //Construtor:
    public PerguntaMultiplaEscolha() {
        super(N_PERGUNTAS);
        definirPerguntas();
    }

    //getter
    public String[] getPerguntas() {
        return perguntas;
    }

    public String[] getRespostas() {
        return respostas;
    }

    //Principal:
    @Override
    public void definirPerguntas() {       
        perguntas[0] = "O meio ambiente é o conjunto de que influencia na vida dos seres vivos relacionados com a vida na terra \n"
        		+ "a)fauna e flora\n"
        		+ "b)fatores fisicos, biológicos e químicos\n"
        		+ "c)biomassa e biomas\n"
        		+ "d)regiões afetadas \n"
        		+ "e)animais \n";
        respostas[0] = "b";
        
        perguntas[1] = "Opções\n"
        		+ "a) \n"
        		+ "b) \n"
        		+ "c) \n"
        		+ "d) \n"
        		+ "e) \n";
        respostas[1] = "a";
        
        perguntas[2] = "Opções\n"
        		+ "a) \n"
        		+ "b) \n"
        		+ "c) \n"
        		+ "d) \n"
        		+ "e) \n";
        respostas[2] = "a";
    }

    @Override
    public void checarResposta(int numeroPergunta, String resposta, Player jogador) {
        if (respostas[numeroPergunta].equals(resposta.toLowerCase().trim())) {
            jogador.adicionaPontos();
        } else {
            jogador.retiraPontos();
        }
    }

    @Override
    public void executarPergunta(int numero, Player jogador) {

        System.out.print(getPerguntas()[numero]);
        String resposta = super.getTecla().nextLine().toLowerCase().trim();
        while (verificar(resposta)) {
            System.out.println("");
            System.out.println("Resposta Invalida! Digite somente uma das alternativas listada.");
            System.out.println(getPerguntas()[numero]);
            resposta = super.getTecla().nextLine().toLowerCase().trim();
        }
        System.out.println("");

        checarResposta(numero, resposta, jogador);
    }

}

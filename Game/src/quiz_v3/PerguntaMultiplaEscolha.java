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
        perguntas[0] = "O meio ambiente é o conjunto de que fatores que influenciam a vida dos seres vivos na terra?\n"
        		+ "a)fauna e flora.\n"
        		+ "b)fatores fisicos, biológicos e químicos.\n"
        		+ "c)biomassa e biomas.\n"
        		+ "d)regiões afetadas.\n"
        		+ "e)animais.\n";
        respostas[0] = "b";
        
        perguntas[1] = "Qual o principal gás responsavel pelo efeito estufa? \n"
        		+ "a)Dióxido de Enxofre.\n"
        		+ "b)Gás lacrimogêneo.\n"
        		+ "c)Dióxido de cargono.\n"
        		+ "d)Gás Carbônico.\n"
        		+ "e)Óxido de nitrogênio.\n";
        respostas[1] = "c";
        
        perguntas[2] = "Através da fotossintese as plantas produzem e armazenam seu próprio alimento, a ...\n"
        		+ "Complete a frase:\n"
        		+ "a)Sacarose\n"
        		+ "b)Glicose\n"
        		+ "c)Sucralose\n"
        		+ "d)Sacarine\n"
        		+ "e)Mudilose\n";
        respostas[2] = "b";
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

package quiz_v3;

public class PerguntaNumerica extends Pergunta {

    private static final int N_PERGUNTAS = 1;
    private String[] perguntas = new String[N_PERGUNTAS];
    private int[] respostas = new int[N_PERGUNTAS];

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

    @Override
    public boolean verificar(String resposta) {
        return !(resposta != null && resposta.matches("[0-9]*") && resposta != "");
    }
    
    @Override
    public void executarPergunta(int numero, Player jogador) {
        System.out.println(getPerguntas()[numero]);
        String respostaS = super.getTecla().nextLine().trim();
        while (verificar(respostaS)) {
            System.out.println("");
            System.out.println("Resposta Invalida! Digite somente numeros positivos.");
            System.out.println(getPerguntas()[numero]);
            respostaS = super.getTecla().nextLine().trim();           
        }
        System.out.println("");
        checarResposta(numero, respostaS, jogador);
    }

    //getters
    public String[] getPerguntas() {
        return perguntas;
    }

    public int[] getRespostas() {
        return respostas;
    }

    @Override //como nesse tipo de pergunta o vetor de resposta È int, esse m√©todo fica sobrando.
    public void checarResposta(int numeroPergunta, String resposta, Player jogador) {
    	int respostaInt = Integer.parseInt(resposta);
    	if (respostas[numeroPergunta] == (respostaInt)) {
            jogador.adicionaPontos();
        } else {
            jogador.retiraPontos();
        }		
    }

}

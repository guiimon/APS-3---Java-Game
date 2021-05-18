package quiz_v3;

public class PerguntaNumerica extends Pergunta {

    private static final int N_PERGUNTAS = 5;
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
                + "Digite o ano: ";
        respostas[0] = 2019;
        
        perguntas[1] = "Um dos primeiros atos dos portugueses que por aqui chegaram foi abater uma árvore para montar \n"
                + "a cruz, gesto premonitório do resultado da ocupação européia na Mata Atlântica, afinal, já fazia sua \n"
                + "primeira vítima há muitos anos. Nos cinco séculos que se seguiram, cada novo ciclo econômico de \n"
                + "desenvolvimento do país significou mais um passo na destruição de uma floresta de um milhão de quilô-\n"
                + "metros quadrados, hoje reduzida a vestígios. Em que ano os portiguese chegaram aqui no Brasil?\n"
                + "Digite o ano: ";
        respostas[1] = 1500;
        
        perguntas[2] = "Os incêndios florestais na Austrália são recorrentes. Eles acontecem todos os anos no final do \n"
                + "inverno austral na ilha continente, mas nesse ano foram particularmente intensos e duraram vários meses.\n"
                + "A que ano o texto acima se refere?\n"
                + "Digite o  ano: ";
        respostas[2] = 2019;
        
        perguntas[3] = "A Primeira Revolução Industrial foi o ponto de partida para grandes mudanças/n"
                + " no planeta, como o aumento da poluição do ar, devido a queima do carvão mineral para gerar\n "
                + "energia para as máquinas, o aumento das doenças e acidentes de trabalhos por função das péssimas \n"
                + "condições de trabalho e ainda, o uso da mão de obra infantil.\n"
                + "Em que século inicio-se a primeira revolução industrial.\n"
                + "Digite o século em formato númerico: ";
        respostas[3] = 18;
        
        perguntas[4] = "(...)Foi então que a ONU decidiu inaugurar a primeira grande conferência mundial sobre o meio ambiente\n"
                + "que foi o grande marco para a questão ambiental, a chamada Conferência das Nações Unidas Sobre o  Ambiente "
                + "Humano, que se realizou em Estocolmo, na Suécia. Também conhecido como Conferência de Estocolmo,\n"
                + "Quando aconteceu essa conferência?\n"
                + "Digite o ano: ";
        respostas[4] = 1972;
    }

    @Override
    public boolean verificar(String resposta) {
        return !(resposta != null && resposta.matches("[0-9]*") && !"".equals(resposta));
    }

    @Override
    public void checarResposta(int numeroPergunta, String resposta, Player jogador) {
        int respostaInt = Integer.parseInt(resposta);
        if (respostas[numeroPergunta] == (respostaInt)) {
            jogador.adicionaPontos();
        } else {
            jogador.retiraPontos();
        }
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

}

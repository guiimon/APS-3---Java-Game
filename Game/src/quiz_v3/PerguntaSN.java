package quiz_v3;

public class PerguntaSN extends Pergunta {

    //atributos
    private static final int N_PERGUNTAS = 1;
    private final String[] perguntas = new String[N_PERGUNTAS];
    private String[] respostas = new String[N_PERGUNTAS];

    public PerguntaSN() {
        super(N_PERGUNTAS);
        definirPerguntas();
    }

    //metodos principais
    public void definirPerguntas() {
        perguntas[0] = "O efeito estufa e um evento decorrente da quebra da camada de ozonio?";                
        respostas[0] = "n";
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
    public boolean verificar(String resposta) {
        //return !"s".equals(resposta) && !"n".equals(resposta);
        return !(resposta != null && resposta.matches("s|n") && resposta != "");
    }

    public void executarPergunta(int numero, Player jogador) {       
            System.out.println(getPerguntas()[numero]);
            System.out.println("Responda com [s] para sim e [n] para não.");
            System.out.print("Resposta: ");
            String resposta = super.getTecla().nextLine().toLowerCase().trim();            
            while (verificar(resposta)) {
                System.out.println("");
                System.out.println("Resposta Invalida! Digite somente [s] ou [n].");
                System.out.println(getPerguntas()[numero]);
                System.out.println("Responda com [s] para sim e [n] para não.");
                resposta = super.getTecla().nextLine().toLowerCase().trim();
            }            
            System.out.println("");

            checarResposta(numero, resposta, jogador);
            limpar();           
    }

    //getters e setters

    public String[] getPerguntas() {
        return perguntas;
    }

    public String[] getRespostas() {
        return respostas;
    }

}

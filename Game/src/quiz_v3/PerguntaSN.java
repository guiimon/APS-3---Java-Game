package quiz_v3;

public class PerguntaSN extends Pergunta {

    //atributos
    private static final int N_PERGUNTAS = 3;
    private final String[] perguntas = new String[N_PERGUNTAS];
    private String[] respostas = new String[N_PERGUNTAS];

    public PerguntaSN() {
        super(N_PERGUNTAS);
        definirPerguntas();
    }

    //metodos principais
    public void definirPerguntas() {
        perguntas[0] = "O efeito estufa é um evento decorrente da quebra da camada de ozônio?";
        respostas[0] = "n";
        
        perguntas[1] = "A partir do lixo orgânico é possivel produzir energia elétrica?";
        respostas[1] = "s";
        
        perguntas[2] = "A floresta amazônica, a maior floresta tropical do mundo, nunca sofreu queimadas e quase não sofre com desmatamento ilegal.\n"
        		+ "essa frase está correta?";
        respostas[2] = "n";
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
       String resposta = null;
        do {            
            try {
                System.out.println(getPerguntas()[numero]);
                System.out.println("Responda com [s] para sim e [n] para não.");
                System.out.print("Resposta: ");
                resposta = super.getTecla().nextLine().toLowerCase().trim();
                verificar(resposta);
                verificarErro(resposta, "sn");
                System.out.println("");
            } catch (RespostaInvalidaException ex) {
                System.out.println(ex.getMessage());
                executarPergunta(numero, jogador);
            }  

        } while (verificar(resposta));
    }

    /*
    @Override
    public void executarPergunta(int numero, Player jogador) {                   
        try {
            System.out.println(getPerguntas()[numero]);
            System.out.println("Responda com [s] para sim e [n] para não.");
            String resposta = super.getTecla().nextLine().toLowerCase().trim();
            verificarErro(resposta, "sn");                        
            System.out.println("");

            checarResposta(numero, resposta, jogador);
            limpar();
        } catch (RespostaInvalidaException ex) {
            String resposta = null;
            Logger.getLogger(PerguntaSN.class.getName()).log(Level.SEVERE, null, ex);
            while (verificar(resposta)) {
                System.out.println("");
                resposta = super.getTecla().nextLine().toLowerCase().trim();
                //verificarErro(resposta, "sn");
                System.out.println(getPerguntas()[numero]);
                System.out.println("Responda com [s] para sim e [n] para não.");
                resposta = super.getTecla().nextLine().toLowerCase().trim();
            }
        }           
    }
     */
    //getters e setters
    public static int getNumeroPerguntas() {
        return N_PERGUNTAS;
    }

    public String[] getPerguntas() {
        return perguntas;
    }

    public String[] getRespostas() {
        return respostas;
    }

}

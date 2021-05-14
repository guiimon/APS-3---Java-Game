package quiz_v2;

import java.util.Scanner;

public class PerguntaSN extends Pergunta {

    //atributos
    private static final int N_PERGUNTAS = 1;
    private final String[] perguntas = new String[N_PERGUNTAS];
    private String[] respostas = new String[N_PERGUNTAS];
    private Scanner tecla = new Scanner(System.in);

    public PerguntaSN() {
        super(N_PERGUNTAS);
        definirPerguntas();
    }

    //metodos principais
    public void definirPerguntas() {
        perguntas[0] = "O efeito estufa é um evento decorrente da quebra da camada de ozônio?\n"
                + "Responda com [s] para sim e [n] para não.\n";
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

    //return resposta != null && resposta.matches("[0-9]*") && resposta != "";
    @Override
    public boolean verificar(String resposta) {
        return !"s".equals(resposta) && !"n".equals(resposta);

    }

    @Override
    public void executarPergunta(int numero, Player jogador) {
        System.out.println(getPerguntas()[numero]);
        String resposta = super.getTecla().nextLine().toLowerCase().trim();
        while (verificar(resposta)) {
            System.out.println("Resposta Invalida! Digite somente numeros.");
            System.out.println(getPerguntas()[numero]);
            resposta = super.getTecla().nextLine().toLowerCase().trim();
        }

        checarResposta(numero, resposta, jogador);
    }

    //gtetters e setters
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

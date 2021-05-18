package quiz_v3;

public class PerguntaComplexa extends Pergunta {

    //atributos
    private static final int N_PERGUNTAS = 3;
    private final String[][] perguntaIni = new String[super.getQtdPerguntas()][6];
    private final String[][] perguntaMeio = new String[super.getQtdPerguntas()][6];
    private final String[][] perguntaFim = new String[super.getQtdPerguntas()][6];
    private final String[] respostas = new String[super.getQtdPerguntas()];

    //construtor
    public PerguntaComplexa() {
        super(N_PERGUNTAS);
        definirPerguntas();
    }

    //getters & setters
    public String[][] getPerguntaIni() {
        return perguntaIni;
    }

    public String[][] getPerguntaMeio() {
        return perguntaMeio;
    }

    public String[][] getPerguntaFim() {
        return perguntaFim;
    }

    //metodos pricipais
    public void checarResposta(int numeroPergunta, String resposta, Player jogador) {
        if (respostas[numeroPergunta].equals(resposta.toLowerCase().trim())) {
            jogador.adicionaPontos();
        } else {
            jogador.retiraPontos();
        }
    }

    public void executarPergunta(int numero, Player jogador) {
        //"respostaF" vai guardar os valores de resposta de cada pergunta juntos, "respostaA" vai guardar os valores individuais por um momento
        //"texto" vai ser utilizado para mostrar o texto das perguntas preenchido com as opcoes que o usuario escolher
        String respostaF = "", respostaA, texto;

        //Primeira Pergunta
        System.out.println(getPerguntaIni()[numero][0]);
        System.out.println("Escolha a alternativa que completa o texto acima: ");
        System.out.println(escreveOpcoes(numero, getPerguntaIni()));
        System.out.print("Resposta: ");
        respostaA = super.getTecla().nextLine().toLowerCase().trim();

        while (verificar(respostaA)) {
            System.out.println("");
            System.out.println("Resposta Invalida! Digite somente uma das alternativas listada.");
            System.out.println(getPerguntaIni()[numero][0]);
            System.out.println("Escolha a alternativa que completa o texto acima: ");
            System.out.println(escreveOpcoes(numero, getPerguntaIni()));
            System.out.print("Resposta: ");
            respostaA = super.getTecla().nextLine().toLowerCase().trim();
        }
        respostaF += respostaA;

        //Segunda Pergunta
        System.out.println("");
        texto = completarTexto(getPerguntaIni(), respostaA, numero);
        texto += getPerguntaMeio()[numero][0];
        System.out.println(texto); //exibe pergunta inicial completada pela resposta e pegunta meio
        System.out.println("Escolha a alternativa que completa o texto acima: ");
        System.out.println(escreveOpcoes(numero, getPerguntaMeio()));
        System.out.print("Resposta: ");
        respostaA = super.getTecla().nextLine().toLowerCase().trim();

        while (verificar(respostaA)) {
            System.out.println("");
            System.out.println("Resposta Invalida! Digite somente uma das alternativas listada.");
            System.out.println(texto);
            System.out.println("Escolha a alternativa que completa o texto acima: ");
            System.out.println(escreveOpcoes(numero, getPerguntaMeio()));
            System.out.print("Resposta: ");

            respostaA = super.getTecla().nextLine().toLowerCase().trim();
        }
        respostaF += respostaA;

        //Terceira Pergunta
        System.out.println("");
        texto = completarTexto(texto, getPerguntaMeio(), respostaA, numero);
        texto += getPerguntaFim()[numero][0];
        System.out.println(texto); //exibe pergunta inicial e meio completa e a pergunta fim
        System.out.println("Escolha a alternativa que completa o texto acima: ");
        System.out.println(escreveOpcoes(numero, getPerguntaFim()));
        System.out.print("Resposta: ");
        respostaA = super.getTecla().nextLine().toLowerCase().trim();

        while (verificar(respostaA)) {
            System.out.println("");
            System.out.println("Resposta Invalida! Digite somente uma das alternativas listada.");
            System.out.println(texto);
            System.out.println("Escolha a alternativa que completa o texto acima: ");
            System.out.println(escreveOpcoes(numero, getPerguntaFim()));
            System.out.print("Resposta: ");
            respostaA = super.getTecla().nextLine().toLowerCase().trim();
        }
        respostaF += respostaA;

        texto = completarTexto(texto, getPerguntaFim(), respostaA, numero);
        System.out.println("--Resultado das respostas--");
        System.out.println(texto);
        System.out.println("");
        checarResposta(numero, respostaF, jogador);
    }

    public String completarTexto(String[][] pergunta, String resposta, int numero) {
        //
        String resultado = "";
        switch (resposta.toLowerCase()) {
            case "a"://pega a string da alternativa escolhida e a coloca no lugar dos '_' na proxima pergunta
                resultado = pergunta[numero][0].replaceAll("_____", pergunta[numero][1].substring(pergunta[numero][1].indexOf(")") + 1, pergunta[numero][1].indexOf(".")).toLowerCase());
                break;
            case "b":
                resultado = pergunta[numero][0].replaceAll("_____", pergunta[numero][2].substring(pergunta[numero][2].indexOf(")") + 1, pergunta[numero][2].indexOf(".")).toLowerCase());
                break;
            case "c":
                resultado = pergunta[numero][0].replaceAll("_____", pergunta[numero][3].substring(pergunta[numero][3].indexOf(")") + 1, pergunta[numero][3].indexOf(".")).toLowerCase());
                break;
            case "d":
                resultado = pergunta[numero][0].replaceAll("_____", pergunta[numero][4].substring(pergunta[numero][4].indexOf(")") + 1, pergunta[numero][4].indexOf(".")).toLowerCase());
                break;
            case "e":
                resultado = pergunta[numero][0].replaceAll("_____", pergunta[numero][5].substring(pergunta[numero][5].indexOf(")") + 1, pergunta[numero][5].indexOf(".")).toLowerCase());
                break;
        }
        return resultado;
    }

    public String completarTexto(String texto, String[][] pergunta, String resposta, int numero) {
        //retorna o valor do texto implementando o espaco em branco depois que o primeiro texto foi aplicado em uma variavel;
        String resultado = "";
        switch (resposta.toLowerCase()) {
            case "a":
                resultado = texto.replaceAll("_____", pergunta[numero][1].substring(pergunta[numero][1].indexOf(")") + 1, pergunta[numero][1].indexOf(".")).toLowerCase());
                break;
            case "b":
                resultado = texto.replaceAll("_____", pergunta[numero][2].substring(pergunta[numero][2].indexOf(")") + 1, pergunta[numero][2].indexOf(".")).toLowerCase());
                break;
            case "c":
                resultado = texto.replaceAll("_____", pergunta[numero][3].substring(pergunta[numero][3].indexOf(")") + 1, pergunta[numero][3].indexOf(".")).toLowerCase());
                break;
            case "d":
                resultado = texto.replaceAll("_____", pergunta[numero][4].substring(pergunta[numero][4].indexOf(")") + 1, pergunta[numero][4].indexOf(".")).toLowerCase());
                break;
            case "e":
                resultado = texto.replaceAll("_____", pergunta[numero][5].substring(pergunta[numero][5].indexOf(")") + 1, pergunta[numero][5].indexOf(".")).toLowerCase());
                break;
        }
        return resultado;
    }

    public String escreveOpcoes(int numeroPergunta, String[][] pergunta) {
        //retorna os valores de respostas para serem escritos na tela dada a matriz da pergunta e o numero correspondente da mesma
        String resultado = pergunta[numeroPergunta][1] + "\n" + pergunta[numeroPergunta][2] + "\n" + pergunta[numeroPergunta][3] + "\n" + pergunta[numeroPergunta][4] + "\n" + pergunta[numeroPergunta][5];
        return resultado;
    }

    public void definirPerguntas() {
        /*
        //Molde de como criar uma pergunta composta
        //Cada pergunta deve conter um campo de 5 underlines "_" para que seja substituida pela opcao de resposta do usuario.
        //o valor da primeria cordenada dos vetores deve ser o mesmo em todas as partes da mesma pergunta.
        //-Primeiro enunciado-
        perguntaIni[][0] = "";
        //-opçoes-
        perguntaIni[][1] = "a) .";
        perguntaIni[][2] = "b) .";
        perguntaIni[][3] = "c) .";
        perguntaIni[][4] = "d) .";
        perguntaIni[][5] = "e) .";
        //-Segundo Enunciado-
        perguntaMeio[][0] = "";
        //-opções do segundo-
        perguntaMeio[][1] = "a) .";
        perguntaMeio[][2] = "b) .";
        perguntaMeio[][3] = "c) .";
        perguntaMeio[][4] = "d) .";
        perguntaMeio[][5] = "e) .";
        //-terceiro Enunciado-
        perguntaFim[][0] = "";
        //-opcoes do terceiro-
        perguntaFim[][1] = "a) .";
        perguntaFim[][2] = "b) .";
        perguntaFim[][3] = "c) .";
        perguntaFim[][4] = "d) .";
        perguntaFim[][5] = "e) .";
        //-resposta composta da juncao das 3 letras corretas-
        respostas[] = "";
         */

        //-Primeiro enunciado-
        perguntaIni[0][0] = "Voce entra em uma floresta e se encontra com um urso, ao perceber que ele te viu voce _____.";
        //-opcoes-
        perguntaIni[0][1] = "a)Corre.";
        perguntaIni[0][2] = "b)Chama a policia.";
        perguntaIni[0][3] = "c)Brinca com ele.";
        perguntaIni[0][4] = "d)Chama de toto.";
        perguntaIni[0][5] = "e)O pede para respeitar seu espaco pessoal.";
        //-Segundo Enunciado-
        perguntaMeio[0][0] = " \nApos isso e necessario tomar mais uma acao: _____.";
        //-opcoes do segundo-
        perguntaMeio[0][1] = "a)Fugir de casa.";
        perguntaMeio[0][2] = "b)Dancar com o Urso.";
        perguntaMeio[0][3] = "c)Chamar ele de gostosa.";
        perguntaMeio[0][4] = "d)Manter a calma para nao assusta-lo.";
        perguntaMeio[0][5] = "e)Sobir uma arvore.";
        //-terceiro Enunciado-
        perguntaFim[0][0] = " E para garantir que voce saia dessa situacao com seguranca e necessario por fim _____.";
        //-opcoes do terceiro-
        perguntaFim[0][1] = "a)Rezar por um milagre.";
        perguntaFim[0][2] = "b)Se afastar do urso sem virar suas costas para ele.";
        perguntaFim[0][3] = "c)Fingir estar morto.";
        perguntaFim[0][4] = "d)Confundir ele com fotos de animais.";
        perguntaFim[0][5] = "e)Abraca-lo e pedir desculpas por incomodar.";
        //-resposta composta da juncao das 3 letras corretas-
        respostas[0] = "bdb";
        
        //-Primeiro enunciado-
        perguntaIni[1][0] = "O fenomeno anormal do aumento de temperatura da terra refere-se a _____.";
        //-opçoes-
        perguntaIni[1][1] = "a)a.";
        perguntaIni[1][2] = "b)b.";
        perguntaIni[1][3] = "c)c.";
        perguntaIni[1][4] = "d)d.";
        perguntaIni[1][5] = "e)e.";
        //-Segundo Enunciado-
        perguntaMeio[1][0] = "Este fenomeno ocorre devido a _____.";
        //-opções do segundo-
        perguntaMeio[1][1] = "a)a.";
        perguntaMeio[1][2] = "b)b.";
        perguntaMeio[1][3] = "c)c.";
        perguntaMeio[1][4] = "d)d.";
        perguntaMeio[1][5] = "e)e.";
        //-terceiro Enunciado-
        perguntaFim[1][0] = "O principal gás resposável por esse fenômeno é o _____.";
        //-opcoes do terceiro-
        perguntaFim[1][1] = "a)a.";
        perguntaFim[1][2] = "b)b.";
        perguntaFim[1][3] = "c)c.";
        perguntaFim[1][4] = "d)d.";
        perguntaFim[1][5] = "e)e.";
        //-resposta composta da juncao das 3 letras corretas-
        respostas[1] = "abc";
        
      //-Primeiro enunciado-
        perguntaIni[2][0] = "a _____.";
        //-opçoes-
        perguntaIni[2][1] = "a)a.";
        perguntaIni[2][2] = "b)b.";
        perguntaIni[2][3] = "c)c.";
        perguntaIni[2][4] = "d)d.";
        perguntaIni[2][5] = "e)e.";
        //-Segundo Enunciado-
        perguntaMeio[2][0] = "b _____.";
        //-opções do segundo-
        perguntaMeio[2][1] = "a)a.";
        perguntaMeio[2][2] = "b)b.";
        perguntaMeio[2][3] = "c)c.";
        perguntaMeio[2][4] = "d)d.";
        perguntaMeio[2][5] = "e)e.";
        //-terceiro Enunciado-
        perguntaFim[2][0] = "c _____.";
        //-opcoes do terceiro-
        perguntaFim[2][1] = "a)a.";
        perguntaFim[2][2] = "b)b.";
        perguntaFim[2][3] = "c)c.";
        perguntaFim[2][4] = "d)d.";
        perguntaFim[2][5] = "e)e.";
        //-resposta composta da juncao das 3 letras corretas-
        respostas[2] = "abc";
    }

}

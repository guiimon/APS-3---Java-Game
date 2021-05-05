package APS_Quiz_V2;

public class PerguntaComplexa extends Pergunta{
    //atributos
    private static final int numeroPerguntas = 1;
    private final String[][] perguntaIni = new String[super.getQtdPerguntas()][6];
    private final String[][] perguntaMeio = new String[super.getQtdPerguntas()][6];
    private final String[][] perguntaFim = new String[super.getQtdPerguntas()][7];  
    
    //getters
    public String[][] getPerguntaIni() {
        return perguntaIni;
    }

    public String[][] getPerguntaMeio() {
        return perguntaMeio;
    }

    public String[][] getPerguntaFim() {
        return perguntaFim;
    }

    //construtor
     public PerguntaComplexa() {
        super(numeroPerguntas);
        definirPerguntas(getPerguntaIni(), getPerguntaMeio(), getPerguntaFim());
    }
   
    //metodos pricipais
    public void checarResposta(int numeroPergunta, String resposta, Player jogador){
        if (getPerguntaFim()[numeroPergunta][6].equals(resposta.toLowerCase()) ) {
            jogador.adicionaPontos();
        } else {
            jogador.retiraPontos();
        }
    }

    public void executarPergunta(int numero, Player jogador) {
        //"respostaF" vai guardar os valores de resposta de cada pergunta juntos, "respostaA" vai guardar os valores individuais por um momento
        //"texto" vai ser utilizado para mostrar o texto das perguntas preenchido com as opções que o usuário escolher
        String respostaF = "", respostaA, texto;
        
        System.out.println(getPerguntaIni()[numero][0]);
        System.out.println("Escolha a alternativa que completa o texto acima: ");
        System.out.println(escreveOpcoes(numero, getPerguntaIni()));
        respostaA = super.getTecla().nextLine();
        verificar(respostaA);
        respostaF+= respostaA;
        
        texto = completarTexto(getPerguntaIni(), respostaA, numero);
        texto+= getPerguntaMeio()[numero][0];
        System.out.println(texto); //exibe pergunta inicial completada pela resposta e pegunta meio
        System.out.println("Escolha a alternativa que completa o texto acima: ");
        System.out.println(escreveOpcoes(numero,getPerguntaMeio()));
        respostaA = super.getTecla().nextLine();
        verificar(respostaA);
        respostaF+= respostaA;
        
        texto = completarTexto(texto, getPerguntaMeio(), respostaA, numero);
        texto += getPerguntaFim()[numero][0];
        System.out.println(texto); //exibe pergunta inicial e meio completa e a pergunta fim
        System.out.println("Escolha a alternativa que completa o texto acima: ");
        System.out.println(escreveOpcoes(numero,getPerguntaFim()));
        respostaA = super.getTecla().nextLine();
        verificar(respostaA);
        respostaF+= respostaA;
        
        checarResposta(numero, respostaF, jogador);
    }

    public String completarTexto(String[][] pergunta, String resposta, int numero) {
        //
        String resultado = "";
        switch(resposta.toLowerCase()) {
        case "a"://pega a string da alternativa escolhida e a coloca no lugar dos '_' na proxima pergunta
            resultado = pergunta[numero][0].replaceAll("_____", pergunta[numero][1].substring(pergunta[numero][1].indexOf(")")+1,pergunta[numero][1].indexOf(".")).toLowerCase());
            break;
        case "b":
            resultado = pergunta[numero][0].replaceAll("_____", pergunta[numero][2].substring(pergunta[numero][2].indexOf(")")+1,pergunta[numero][2].indexOf(".")).toLowerCase());
            break;
        case "c":
            resultado = pergunta[numero][0].replaceAll("_____", pergunta[numero][3].substring(pergunta[numero][3].indexOf(")")+1,pergunta[numero][3].indexOf(".")).toLowerCase());
            break;
        case "d":
            resultado = pergunta[numero][0].replaceAll("_____", pergunta[numero][4].substring(pergunta[numero][4].indexOf(")")+1,pergunta[numero][4].indexOf(".")).toLowerCase());
            break;
        case "e":
            resultado = pergunta[numero][0].replaceAll("_____", pergunta[numero][5].substring(pergunta[numero][5].indexOf(")")+1,pergunta[numero][5].indexOf(".")).toLowerCase());
            break;
        }
        return resultado;
    }

    public String completarTexto(String texto,String [][] pergunta, String resposta, int numero) {
        //retorna o valor do texto implementando o espaço em branco depois que o primeiro texto foi aplicado em uma variavel;
        String resultado = "";
        switch (resposta.toLowerCase()) {
        case "a":
            resultado = texto.replaceAll("_____", pergunta[numero][1].substring(pergunta[numero][1].indexOf(")")+1,pergunta[numero][1].indexOf(".")).toLowerCase());
            break;
        case "b":
            resultado = texto.replaceAll("_____", pergunta[numero][2].substring(pergunta[numero][2].indexOf(")")+1,pergunta[numero][2].indexOf(".")).toLowerCase());
            break;
        case "c":
            resultado = texto.replaceAll("_____", pergunta[numero][3].substring(pergunta[numero][3].indexOf(")")+1,pergunta[numero][3].indexOf(".")).toLowerCase());
            break;
        case "d":
            resultado = texto.replaceAll("_____", pergunta[numero][4].substring(pergunta[numero][4].indexOf(")")+1,pergunta[numero][4].indexOf(".")).toLowerCase());
            break;
        case "e":
            resultado = texto.replaceAll("_____", pergunta[numero][5].substring(pergunta[numero][5].indexOf(")")+1,pergunta[numero][5].indexOf(".")).toLowerCase());
            break;
        }
        return resultado;
    }
    
    public String escreveOpcoes(int numeroPergunta, String[][] pergunta) {
        //retorna os valores de respostas para serem escritos na tela dada a matriz da pergunta e o numero correspondente da mesma
        String resultado = pergunta[numeroPergunta][1] + "\n" + pergunta[numeroPergunta][2] + "\n" + pergunta[numeroPergunta][3] + "\n" + pergunta[numeroPergunta][4] + "\n" + pergunta[numeroPergunta][5];
        return resultado;
    }

    public void definirPerguntas(String[][] p1, String[][] p2, String[][] p3) {
        /*
        //Molde de como criar uma pergunta composta
        //Cada pergunta deve conter um campo de 5 underlines "_" para que seja substituida pela opção de resposta do usuário.
        //o valor da primeria cordenada dos vetores deve ser o mesmo em todas as partes da mesma pergunta.
        //-Primeiro enunciado-
        p1[0][0] = "";
        //-opçoes-
        p1[][1] = "a) .";
        p1[][2] = "b) .";
        p1[][3] = "c) .";
        p1[][4] = "d) .";
        p1[][5] = "e) .";
        //-Segundo Enunciado-
        p2[][0] = "";
        //-opções do segundo-
        p2[][1] = "a) .";
        p2[][2] = "b) .";
        p2[][3] = "c) .";
        p2[][4] = "d) .";
        p2[][5] = "e) .";
        //-terceiro Enunciado-
        p3[][0] = "";
        //-opcoes do terceiro-
        p3[][1] = "a) .";
        p3[][2] = "b) .";
        p3[][3] = "c) .";
        p3[][4] = "d) .";
        p3[][5] = "e) .";
        //-resposta composta da junção das 3 letras corretas-
        p3[][6] = "";
        */

        //-Primeiro enunciado-
        p1[0][0] = "Você entra em uma floresta e se encontra com um urso, ao perceber que ele te viu você _____.";
        //-opções-
        p1[0][1] = "a)Corre.";
        p1[0][2] = "b)Chama a polícia.";
        p1[0][3] = "c)Brinca com ele.";
        p1[0][4] = "d)Chama de totó.";
        p1[0][5] = "e)O pede para respeitar seu espaço pessoal.";
        //-Segundo Enunciado-
        p2[0][0] = " \nApós isso é necessario tomar mais uma ação: _____.";
        //-opções do segundo-
        p2[0][1] = "a)Fugir de casa.";
        p2[0][2] = "b)Dan�ar com o Urso.";
        p2[0][3] = "c)Chamar ele de gostosa.";
        p2[0][4] = "d)Manter a calma para não assustá-lo.";
        p2[0][5] = "e)Sobir uma arvore.";
        //-terceiro Enunciado-
        p3[0][0] = " E para garantir que você saia dessa situação com segurança é necessario por fim _____.";
        //-opcoes do terceiro-
        p3[0][1] = "a)Rezar por um milagre.";
        p3[0][2] = "b)Se afastar do urso sem virar suas costas para ele.";
        p3[0][3] = "c)Fingir estar morto.";
        p3[0][4] = "d)Confundir ele com fotos de animais.";
        p3[0][5] = "e)Abraça-lo e pedir desculpas por incomodar.";
        //-resposta composta da junção das 3 letras corretas-
        p3[0][6] = "bdb";

    }

    @Override
    public void definirPerguntas(String[][] pergunta) {
    }
    
}

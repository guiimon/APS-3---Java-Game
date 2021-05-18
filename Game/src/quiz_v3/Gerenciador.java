package quiz_v3;

import java.util.Random;
import java.util.Scanner;

public class Gerenciador {

    private int Sn1, Sn2, Sn3, Num1, Num2, Num3, Mult1, Mult2, Comp1, Comp2;

    public Gerenciador() {
        Scanner tecla = new Scanner(System.in);
        menuInicial(tecla);
    }

    public void menuInicial(Scanner tecla) {
        System.out.println("Bem vindo ao (insira aqui o nome do jogo)!!!\n"
                + "\n-Regras-\n"
                + "Voce respondera 10 perguntas aletorias dos diferentes tipos de pergunta existentes\n"
                + "para cada acerto 10 pontos serao adicionados ao seu score, a cada erro 10 pontos serao retirados\n"
                + "apos as 10 pertuntas o seu resultado sera apresentado na tela.\n\n"
                + "Digite [s] para prosseguir ou [n] para fechar o jogo.");
        String resposta = tecla.nextLine();
        if (resposta.toLowerCase().trim().equals("s")) {
            Iniciar(tecla);
        } else if (resposta.toLowerCase().trim().equals("n")) {
            tecla.close();
            fecharJogo();
        } else {
            System.out.println("***Resposta Invalida***".toUpperCase());
            menuInicial(tecla);
        }
    }

    public void Iniciar(Scanner tecla) {
        //gera 10 numeros aleatorios de 0 a 9 em 3 conjuntos, 2 de 4 valores e 1 de 2 valores
        //o metodo faz com que os numeros aletorios nao se repitam dentro de seus conjuntos
        //apos a geracao o metodo vai executar as perguntas de acordo com os numeros gerados
    	System.out.print("Digite o nome do(a) Jogador(a) nome: ");
    	String nome = tecla.nextLine();
        Player p1 = new Player(nome);
        PerguntaSN psn = new PerguntaSN();
        PerguntaNumerica pn = new PerguntaNumerica();
        PerguntaMultiplaEscolha pm = new PerguntaMultiplaEscolha();
        PerguntaComplexa pc = new PerguntaComplexa();
        //metodo só vai funcionar se tiver ao menos 3 PerguntaSN, 3 PerguntaNumerica, 2 PerguntaMultiplaEscolha e 2 PerguntaComplexa
        gerarNumeros(psn, pn, pm, pc);
        
        System.out.println("-Primeira Pergunta-");
        psn.executarPergunta(Sn1, p1);
        System.out.println("-Segunda Pergunta-");
        psn.executarPergunta(Sn2, p1);
        System.out.println("-Terceira Pergunta-");
        psn.executarPergunta(Sn3, p1);
        System.out.println("-Quarta Pergunta-");
        pc.executarPergunta(Comp1, p1);
        System.out.println("-Quinta Pergunta-");
        pm.executarPergunta(Mult1, p1);
        System.out.println("-Sexta Pergunta-");
        pn.executarPergunta(Num1, p1);
        System.out.println("-Setima Pergunta-");
        pn.executarPergunta(Num2, p1);
        System.out.println("-Oitava Pergunta-");
        pn.executarPergunta(Num3, p1);
        System.out.println("-Nona Pergunta-");
        pm.executarPergunta(Mult2, p1);
        System.out.println("-Ultima Pergunta-");
        pc.executarPergunta(Comp2, p1);
        p1.defineResultado();

        String resposta;
        do {
            System.out.println("Jogar novamente?\n[s] para sim [n] para não");
            System.out.print("Resposta: ");
            resposta = tecla.nextLine().toLowerCase().trim();
            if (resposta.equals("s")) {
                Iniciar(tecla);
            } else if (resposta.toLowerCase().equals("n")) {
                tecla.close();
                fecharJogo();
            } else {
                System.out.println("Comando não reconhecido");
            }
        } while (!resposta.matches("s|n"));
    }

    @SuppressWarnings("static-access")
	public void gerarNumeros(PerguntaSN psn, PerguntaNumerica pn, PerguntaMultiplaEscolha pm, PerguntaComplexa pc) {
        //Gera os numeros para serem utilizados nas perguntas nao repetindo dentro de seus conjuntos
        Random gerador = new Random();
        //Conjunto das variaveis das perguntas de Sim ou Não
        Sn1 = gerador.nextInt(psn.getNumeroPerguntas());
        Sn2 = verifica(Sn1, gerador, psn.getNumeroPerguntas());
        Sn3 = verifica(Sn1, Sn2, gerador, psn.getNumeroPerguntas());
        //Conjunto das variaveis das perguntas Numericas
        Num1 = gerador.nextInt(pn.getQtdPerguntas());
        Num2 = verifica(Num1, gerador, pn.getQtdPerguntas());
        Num3 = verifica(Num1, Num2, gerador, pn.getQtdPerguntas());
        //Conjunto das variaveis das perguntas de Multipla escolha
        Mult1 = gerador.nextInt(pm.getQtdPerguntas());
        Mult2 = verifica(Mult1, gerador, pm.getQtdPerguntas());
        //Conjunto das variaveis das perguntas Complexas.
        Comp1 = gerador.nextInt(pc.getQtdPerguntas());
        Comp2 = verifica(Comp1, gerador, pc.getQtdPerguntas());

        //demonstra os numeros criados, somente para visualizaçao em testes, deve estar comentado no codigo final.
        System.out.println("Sn1 :"+Sn1);
        System.out.println("Sn2 :"+Sn2);
        System.out.println("Sn3 :"+Sn3);
        System.out.println("Num1 :"+Num1);
        System.out.println("Num2 :"+Num2);
        System.out.println("Num3 :"+Num3);
        System.out.println("Mult1 :"+Mult1);
        System.out.println("Mult2 :"+Mult2);
        System.out.println("Comp1 :"+Comp1);
        System.out.println("Comp2 :"+Comp2);
    }

    public int verifica(int comparador, Random gerador, int numero) {
        int novo = 0;
        do {
            novo = gerador.nextInt(numero);
        } while (novo == comparador);
        return novo;
    }

    public int verifica(int compara1, int compara2, Random gerador, int numero) {
        int novo = 0;
        do {
            novo = gerador.nextInt(numero);
        } while (novo == compara1 || novo == compara2);
        return novo;
    }
    
    //Codigo inutilizado pois não há necessidade de comparar 4 numeros.
    /*
    public int verifica(int compara1, int compara2, int compara3, Random gerador, int numero) {
        int novo = 0;
        do {
            novo = gerador.nextInt(numero);
        } while (novo == compara1 || novo == compara2 || novo == compara3);
        return novo;
    }
	*/
    
    public void fecharJogo() {
        System.out.println("Obrigado por jogar!");
        System.exit(0);
    }

}

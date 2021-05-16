package quiz_v3;

import java.util.Random;
import java.util.Scanner;

public class Gerenciador {

    private int primeiro, segundo, terceiro, quarto, quinto, sexto, setimo, oitavo, nono, decimo;
    private static int qtd = 10;

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
        if (resposta.toLowerCase().equals("s")) {
            Iniciar(tecla);
        } else if (resposta.toLowerCase().equals("n")) {
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
        System.out.print("Digite o nome do(a) jogador(a): ");
        String nome = tecla.nextLine();
        Player p1 = new Player(nome);
        PerguntaComplexa pc = new PerguntaComplexa();
        PerguntaMultiplaEscolha pm = new PerguntaMultiplaEscolha();

        gerarNumeros();

        System.out.println("-Primeira Pergunta-");
        pc.executarPergunta(primeiro, p1);
        pc.executarPergunta(segundo, p1);
        pc.executarPergunta(terceiro, p1);
        pc.executarPergunta(quarto, p1);

        pm.executarPergunta(quinto, p1);
        pm.executarPergunta(sexto, p1);
        pm.executarPergunta(setimo, p1);
        pm.executarPergunta(oitavo, p1);

        p1.defineResultado();

        String resposta;
        do {
            System.out.println("Jogar novamente?\n[s] para sim [n] para n�o");
            System.out.print("Resposta: ");
            resposta = tecla.nextLine();
            if (resposta.toLowerCase().equals("s")) {
                Iniciar(tecla);
            } else if (resposta.toLowerCase().equals("n")) {
                tecla.close();
                fecharJogo();
            } else {
                System.out.println("Comando n�o reconhecido");
            }
        } while (!resposta.toLowerCase().matches("s|n"));
    }

    public void gerarNumeros() {
        //Gera os numeros para serem utilizados nas perguntas nao repetindo dentro de seus conjuntos
        Random gerador = new Random();
        //primeiro conjunto de 4
        primeiro = gerador.nextInt(qtd);
        segundo = verifica(primeiro, gerador);
        terceiro = verifica(primeiro, segundo, gerador);
        quarto = verifica(primeiro, segundo, terceiro, gerador);
        //segundo conjunto de 4
        quinto = gerador.nextInt(qtd);
        sexto = verifica(quinto, gerador);
        setimo = verifica(quinto, sexto, gerador);
        oitavo = verifica(quinto, sexto, setimo, gerador);
        //ultimo conjunto de numeros
        nono = gerador.nextInt(qtd);
        decimo = verifica(nono, gerador);

        //demonstra os numeros criados, somente para visualiza�ao em testes, deve estar comentado no codigo final.
        System.out.println(primeiro);
        System.out.println(segundo);
        System.out.println(terceiro);
        System.out.println(quarto);
        System.out.println(quinto);
        System.out.println(sexto);
        System.out.println(setimo);
        System.out.println(oitavo);
        System.out.println(nono);
        System.out.println(decimo);
    }

    public int verifica(int comparador, Random gerador) {
        int novo = 0;
        do {
            novo = gerador.nextInt(qtd);
        } while (novo == comparador);
        return novo;
    }

    public int verifica(int compara1, int compara2, Random gerador) {
        int novo = 0;
        do {
            novo = gerador.nextInt(qtd);
        } while (novo == compara1 || novo == compara2);
        return novo;
    }

    public int verifica(int compara1, int compara2, int compara3, Random gerador) {
        int novo = 0;
        do {
            novo = gerador.nextInt(qtd);
        } while (novo == compara1 || novo == compara2 || novo == compara3);
        return novo;
    }

    public void fecharJogo() {
        System.out.println("Obrigado por jogar!");
        System.exit(0);
    }

}

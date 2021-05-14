package quiz_v2;

import java.util.Random;

public class Gerenciador {

    private int primeiro, segundo, terceiro, quarto, quinto, sexto, setimo, oitavo, nono, decimo;
    private static int qtd = 10;

    public Gerenciador() {
        Gerar();
    }

    public void Gerar() {
        //gera 10 numeros aleatorios de 0 a 9 em 3 conjuntos, 2 de 4 valores e 1 de 2 valores
        //o metodo faz com que os numeros aletorios nao se repitam dentro de seus conjuntos
        //apos a geracao o metodo vai executar as perguntas de acordo com os numeros gerados
        Random gerador = new Random();
        Player p1 = new Player();
        PerguntaComplexa pc = new PerguntaComplexa();
        PerguntaMultiplaEscolha pm = new PerguntaMultiplaEscolha();
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

        pc.executarPergunta(primeiro, p1);
        pc.executarPergunta(segundo, p1);
        pc.executarPergunta(terceiro, p1);
        pc.executarPergunta(quarto, p1);

        pm.executarPergunta(quinto, p1);
        pm.executarPergunta(sexto, p1);
        pm.executarPergunta(setimo, p1);
        pm.executarPergunta(oitavo, p1);

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
}

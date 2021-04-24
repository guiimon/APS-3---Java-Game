package apsv1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player jogador = new Player();
		//PerguntaMultiplaEscolha p1 = new PerguntaMultiplaEscolha();
		PerguntaComplexa p2 = new PerguntaComplexa();
		/*
		p1.executarPergunta(1,jogador);
		jogador.defineResultado();
		System.out.println(jogador.getPontuacao());
		*/
		p2.executarPergunta(0, jogador);
		jogador.defineResultado();
		System.out.println(jogador.getPontuacao());
	}

}

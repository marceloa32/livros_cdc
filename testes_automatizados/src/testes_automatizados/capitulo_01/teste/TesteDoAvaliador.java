package testes_automatizados.capitulo_01.teste;

import testes_automatizados.capitulo_01.Avaliador;
import testes_automatizados.capitulo_01.model.Lance;
import testes_automatizados.capitulo_01.model.Leilao;
import testes_automatizados.capitulo_01.model.Usuario;

/**
 * 
 * @since 1.1 p.2
 * @version 1.3
 *
 */
public class TesteDoAvaliador {

	public static void main(String[] args) {

		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propor(new Lance(maria, 250.0));
		leilao.propor(new Lance(joao, 300.0));
		leilao.propor(new Lance(jose, 400.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avaliar(leilao);

		// testando valores esperados
		double maiorEsperado = 400;
		double menorEsperado = 250;

		System.out.println(leiloeiro.getMaiorLance() == maiorEsperado);
		System.out.println(leiloeiro.getMenorLance() == menorEsperado);

	}
}

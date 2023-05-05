package testes_automatizados.capitulo_01;

import testes_automatizados.capitulo_01.model.Lance;
import testes_automatizados.capitulo_01.model.Leilao;

/**
 * 
 * @since 1.1 pp.1-2
 * @version 1.2
 * 
 */
public class Avaliador {

	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	
	public void avaliar(Leilao leilao) {
		
		for(Lance lance : leilao.getLances()) {
			if(lance.getValor() > maiorDeTodos) {
				maiorDeTodos = lance.getValor();
			} else if (lance.getValor() < menorDeTodos) {
				menorDeTodos = lance.getValor();
			}
		}
	}
	
	public double getMaiorLance() {
		return maiorDeTodos;
	}

	public double getMenorLance() {
		return menorDeTodos;
	}
	
	
}

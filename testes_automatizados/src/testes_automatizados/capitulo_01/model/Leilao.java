package testes_automatizados.capitulo_01.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public class Leilao {

	private List<Lance> lances = new ArrayList<>();
	private String titulo;

	public Leilao(String titulo) {
		this.setTitulo(titulo);
	}

	public List<Lance> getLances() {
		return lances;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void propor(Lance lance) {
		getLances().add(lance);
		
	}
	
	
	
}

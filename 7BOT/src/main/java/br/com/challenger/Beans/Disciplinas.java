
package br.com.challenger.Beans;

import java.util.ArrayList;
import java.util.List;

public class Disciplinas {
	
	


	private String titulo;
//	private String autor;
	public List<String> materias;
	
	
	public Disciplinas(String titulo, List materias) {
		this.materias = new ArrayList<String>();
		this.titulo = titulo;
		this.materias = materias;
	}

	
	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public List<String> getMaterias() {
		return materias;
	}


	public void setMaterias(List<String> materias) {
		this.materias = materias;
	}
	
	
	
}


package br.com.challenger.Beans;

public class Material {
	private String titulo;
	private String escopo;
	private String escopo2;
	
	
	public Material(String titulo, String escopo) {
		super();
		this.titulo = titulo;
		this.escopo = escopo;
	}
	public Material(String titulo, String escopo, String escopo2) {
		super();
		this.titulo = titulo;
		this.escopo = escopo;
		this.escopo2 = escopo2;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEscopo() {
		return escopo;
	}
	public void setEscopo(String escopo) {
		this.escopo = escopo;
	}
	public String getEscopo2() {
		return escopo2;
	}
	public void setEscopo2(String escopo2) {
		this.escopo2 = escopo2;
	}
	
}

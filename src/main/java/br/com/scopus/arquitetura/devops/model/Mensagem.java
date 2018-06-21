package br.com.scopus.arquitetura.devops.model;

public class Mensagem {
	
	private long id;
	private String conteudo;
	
	public Mensagem(long id, String conteudo) {
		this.id = id;
		this.conteudo = conteudo;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
}

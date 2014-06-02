package ecommerce;

import java.io.Serializable;

public class Autor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int autor_id;
	private String autor_nome;
	
	public Autor(){
		
	}
	
	public Autor(int autor_id, String autor_nome) {
		super();
		this.autor_id = autor_id;
		this.autor_nome = autor_nome;
	}

	public int getAutor_id() {
		return autor_id;
	}

	public void setAutor_id(int autor_id) {
		this.autor_id = autor_id;
	}

	public String getAutor_nome() {
		return autor_nome;
	}

	public void setAutor_nome(String autor_nome) {
		this.autor_nome = autor_nome;
	}

	
}

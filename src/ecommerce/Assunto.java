package ecommerce;

import java.io.Serializable;

public class Assunto implements Serializable {

	private static final long serialVersionUID = 1L;
	private int assunto_id;
	private String assunto_nome;
	
	public Assunto(){
		
	}
	
	public Assunto(int assunto_id, String assunto_nome) {
		super();
		this.assunto_id = assunto_id;
		this.assunto_nome = assunto_nome;
	}

	public int getAssunto_id() {
		return assunto_id;
	}

	public void setAssunto_id(int assunto_id) {
		this.assunto_id = assunto_id;
	}

	public String getAssunto_nome() {
		return assunto_nome;
	}

	public void setAssunto_nome(String assunto_nome) {
		this.assunto_nome = assunto_nome;
	}
	

}

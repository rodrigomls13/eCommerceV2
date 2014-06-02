package ecommerce;

import java.io.Serializable;

public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int cliente_id;
	private String cliente_nome;
	private String email;
	private String senha;
	
	public Cliente(){
		
	}
	
	public Cliente(int cliente_id, String cliente_nome, String email,
			String senha) {
		super();
		this.cliente_id = cliente_id;
		this.cliente_nome = cliente_nome;
		this.email = email;
		this.senha = senha;
	}

	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}

	public String getCliente_nome() {
		return cliente_nome;
	}

	public void setCliente_nome(String cliente_nome) {
		this.cliente_nome = cliente_nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
}

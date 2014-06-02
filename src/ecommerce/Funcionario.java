package ecommerce;

import java.io.Serializable;

public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	private String login;
	private String senha;
	private String funcionario_nome;
	
	public Funcionario(){		
		
	}
	
	public Funcionario(String login, String senha, String funcionario_nome) {
		super();
		this.login = login;
		this.senha = senha;
		this.funcionario_nome = funcionario_nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getFuncionario_nome() {
		return funcionario_nome;
	}
	public void setFuncionario_nome(String funcionario_nome) {
		this.funcionario_nome = funcionario_nome;
	}

}

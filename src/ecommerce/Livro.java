package ecommerce;

import java.io.Serializable;

public class Livro implements Serializable{

	private static final long serialVersionUID = 1L;
	private int livro_id;
	private String titulo;
	private double preco;
	private int ano;
	private int paginas;
	private int assunto_id;
	
	public Livro(){
		
	}
	
	public Livro(int livro_id, String titulo, double preco, int ano,
			int paginas, int assunto_id) {
		super();
		this.livro_id = livro_id;
		this.titulo = titulo;
		this.preco = preco;
		this.ano = ano;
		this.paginas = paginas;
		this.assunto_id = assunto_id;
	}

	public int getLivro_id() {
		return livro_id;
	}

	public void setLivro_id(int livro_id) {
		this.livro_id = livro_id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public int getAssunto_id() {
		return assunto_id;
	}

	public void setAssunto_id(int assunto_id) {
		this.assunto_id = assunto_id;
	}
	
}

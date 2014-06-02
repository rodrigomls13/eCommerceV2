package ecommerce;

import java.io.Serializable;

public class LivroAutor implements Serializable {

	private static final long serialVersionUID = 1L;
	private int livro_autor_id;
	private int livro_id;
	private int autor_id;
	
	public LivroAutor(){
		
	}
	
	public LivroAutor(int livro_autor_id, int livro_id, int autor_id) {
		super();
		this.livro_autor_id = livro_autor_id;
		this.livro_id = livro_id;
		this.autor_id = autor_id;
	}

	public int getLivro_autor_id() {
		return livro_autor_id;
	}

	public void setLivro_autor_id(int livro_autor_id) {
		this.livro_autor_id = livro_autor_id;
	}

	public int getLivro_id() {
		return livro_id;
	}

	public void setLivro_id(int livro_id) {
		this.livro_id = livro_id;
	}

	public int getAutor_id() {
		return autor_id;
	}

	public void setAutor_id(int autor_id) {
		this.autor_id = autor_id;
	}
	

}

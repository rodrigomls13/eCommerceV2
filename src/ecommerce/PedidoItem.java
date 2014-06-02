package ecommerce;

import java.io.Serializable;

public class PedidoItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int pedido_item_id;
	private int pedido_id;
	private int livro_id;
	private int quantidade;
	private float unitario;
	private float total;
	
	public PedidoItem(){
		
	}
	
	public PedidoItem(int pedido_item_id, int pedido_id, int livro_id,
			int quantidade, float unitario, float total) {
		super();
		this.pedido_item_id = pedido_item_id;
		this.pedido_id = pedido_id;
		this.livro_id = livro_id;
		this.quantidade = quantidade;
		this.unitario = unitario;
		this.total = total;
	}

	public int getPedido_item_id() {
		return pedido_item_id;
	}

	public void setPedido_item_id(int pedido_item_id) {
		this.pedido_item_id = pedido_item_id;
	}

	public int getPedido_id() {
		return pedido_id;
	}

	public void setPedido_id(int pedido_id) {
		this.pedido_id = pedido_id;
	}

	public int getLivro_id() {
		return livro_id;
	}

	public void setLivro_id(int livro_id) {
		this.livro_id = livro_id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getUnitario() {
		return unitario;
	}

	public void setUnitario(float unitario) {
		this.unitario = unitario;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	

}

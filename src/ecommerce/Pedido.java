package ecommerce;

import java.io.Serializable;
import java.util.Date;

public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int pedido_id;
	private Date dma_pedido;
	private String horario;
	private int cliente_id;
	
	public Pedido(){
		
	}
	
	public Pedido(int pedido_id, Date dma_pedido, String horario, int cliente_id) {
		super();
		this.pedido_id = pedido_id;
		this.dma_pedido = dma_pedido;
		this.horario = horario;
		this.cliente_id = cliente_id;
	}

	public int getPedido_id() {
		return pedido_id;
	}

	public void setPedido_id(int pedido_id) {
		this.pedido_id = pedido_id;
	}

	public Date getDma_pedido() {
		return dma_pedido;
	}

	public void setDma_pedido(Date dma_pedido) {
		this.dma_pedido = dma_pedido;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}
	
	

}

package ecommerce;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

public class PedidoADO {
		public static void Incluir(Pedido sender) throws Exception {
			String sql = String.format("INSERT INTO Pedido (dma_pedido, horario, cliente_id) VALUES ('%1$s', '%2$s', '%3$s') ",
					sender.getDma_pedido(),
					sender.getHorario(),
					sender.getCliente_id());
			Conexao.execSql(sql) ;
		}
		
		public static void Alterar(Pedido sender) throws Exception {
			String sql = String.format("UPDATE Pedido SET " +
					"dma_pedido ='%1$s', " +
					"horario = '%2$s', " +
					"cliente_id ='%3$s' " +
					"WHERE pedido_id = %4$s",
					sender.getDma_pedido(),
					sender.getHorario(),
					sender.getCliente_id(),
					sender.getPedido_id());
			Conexao.execSql(sql);
		}
		
		public static void Excluir(Pedido sender) throws Exception{
			String sql = ("DELETE FROM Pedido WHERE pedido_id =  "+	sender.getPedido_id());
			Conexao.execSql(sql);	
		}
		
		public static Collection<Pedido> getDado() throws Exception{ 
			String sql = "SELECT * FROM Pedido ";
			
			ResultSet rs = Conexao.getList(sql);
			Collection<Pedido> result = new Vector<Pedido>();
			
			while (rs.next())
			{
				result.add(new Pedido(
					rs.getInt("pedido_id"), 
					rs.getDate("dma_pedido"),
					rs.getString("horario"),
					rs.getInt("cliente_id")
				));
			}
			Conexao.fechar();
			return result;
		}
		
		public static Pedido getById(String codigo) throws Exception {
			String sql = "SELECT * FROM Pedido WHERE pedido_id = "+codigo;
			ResultSet rs = Conexao.getList(sql);
			Pedido result = new Pedido(
					rs.getInt("pedido_id"), 
					rs.getDate("dma_pedido"),
					rs.getString("horario"),
					rs.getInt("cliente_id")
				);
			Conexao.fechar();
			return result;
		}
		
		public static Pedido getByNome(String nome) throws Exception{ 
			String sql = "SELECT * FROM Pedido WHERE horario = '"+nome+"'";
			ResultSet rs = Conexao.getList(sql);
			Pedido result = new Pedido(
					rs.getInt("pedido_id"), 
					rs.getDate("dma_pedido"),
					rs.getString("horario"),
					rs.getInt("cliente_id")
				);
			Conexao.fechar();
			return result;
		}
		
	}

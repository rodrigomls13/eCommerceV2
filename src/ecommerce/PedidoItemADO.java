package ecommerce;


import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

public class PedidoItemADO {
		public static void Incluir(PedidoItem sender) throws Exception {
			String sql = String.format("INSERT INTO pedido_item (pedido_id, livro_id, quantidade, unitario, total) VALUES ('%1$s', '%2$s', '%3$s', '%4$s', '%5$s') ",
					sender.getPedido_id(),
					sender.getLivro_id(),
					sender.getQuantidade(),
					sender.getUnitario(),
					sender.getTotal());
			Conexao.execSql(sql) ;
		}
		
		public static void Alterar(PedidoItem sender) throws Exception {
			String sql = String.format("UPDATE pedido_item SET " +
					"pedido_id ='%1$s', " +
					"livro_id = '%2$s', " +
					"quantidade ='%3$s', " +
					"unitario ='%4$s', " +
					"total ='%5$s' " +
					"WHERE pedido_item_id = %6$s",
					sender.getPedido_id(),
					sender.getLivro_id(),
					sender.getQuantidade(),
					sender.getUnitario(),
					sender.getTotal(),
					sender.getPedido_item_id());
			Conexao.execSql(sql);
		}
		
		public static void Excluir(PedidoItem sender) throws Exception{
			String sql = ("DELETE FROM pedido_item WHERE pedido_item_id =  "+	sender.getPedido_item_id());
			Conexao.execSql(sql);	
		}
		
		public static Collection<PedidoItem> getDado() throws Exception{ 
			String sql = "SELECT * FROM pedido_item ";
			
			ResultSet rs = Conexao.getList(sql);
			Collection<PedidoItem> result = new Vector<PedidoItem>();
			
			while (rs.next())
			{
				result.add(new PedidoItem(
					rs.getInt("pedido_item_id"), 
					rs.getInt("pedido_id"),
					rs.getInt("livro_id"),
					rs.getInt("quantidade"),
					rs.getFloat("unitario"),
					rs.getFloat("total")
				));
			}
			Conexao.fechar();
			return result;
		}
		
		public static PedidoItem getById(String codigo) throws Exception {
			String sql = "SELECT * FROM pedido_item WHERE pedido_item_id = "+codigo;
			ResultSet rs = Conexao.getList(sql);
			PedidoItem result = new PedidoItem(
					rs.getInt("pedido_item_id"), 
					rs.getInt("pedido_id"),
					rs.getInt("livro_id"),
					rs.getInt("quantidade"),
					rs.getFloat("unitario"),
					rs.getFloat("total")
				);
			Conexao.fechar();
			return result;
		}
	
	}

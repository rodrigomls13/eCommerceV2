package ecommerce;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

public class ClienteADO {
		public static void Incluir(Cliente sender) throws Exception {
			String sql = String.format("INSERT INTO Cliente (cliente_nome, email, senha) VALUES ('%1$s', '%2$s', '%3$s') ",
					sender.getCliente_nome(),
					sender.getEmail(),
					sender.getSenha());
			Conexao.execSql(sql) ;
		}
		
		public static void Alterar(Cliente sender) throws Exception {
			String sql = String.format("UPDATE Cliente SET " +
					"cliente_nome ='%1$s', " +
					"email = '%2$s', " +
					"senha ='%3$s' " +
					"WHERE cliente_id = %4$s",
					sender.getCliente_nome(),
					sender.getEmail(),
					sender.getSenha(),
					sender.getCliente_id());
			Conexao.execSql(sql);
		}
		
		public static void Excluir(Cliente sender) throws Exception{
			String sql = ("DELETE FROM Cliente WHERE cliente_id =  "+	sender.getCliente_id());
			Conexao.execSql(sql);	
		}
		
		public static Collection<Cliente> getDado() throws Exception{ 
			String sql = "SELECT * FROM Cliente ";
			
			ResultSet rs = Conexao.getList(sql);
			Collection<Cliente> result = new Vector<Cliente>();
			
			while (rs.next())
			{
				result.add(new Cliente(
					rs.getInt("cliente_id"), 
					rs.getString("cliente_nome"),
					rs.getString("email"),
					rs.getString("senha")
				));
			}
			Conexao.fechar();
			return result;
		}
		
		public static Cliente getById(String codigo) throws Exception {
			String sql = "SELECT * FROM Cliente WHERE cliente_id = "+codigo;
			ResultSet rs = Conexao.getList(sql);
			Cliente result = new Cliente(
					rs.getInt("cliente_id"), 
					rs.getString("cliente_nome"),
					rs.getString("email"),
					rs.getString("senha")
				);
			Conexao.fechar();
			return result;
		}
		
		public static Cliente getByNome(String nome) throws Exception{ 
			String sql = "SELECT * FROM Cliente WHERE cliente_nome = '"+nome+"'";
			ResultSet rs = Conexao.getList(sql);
			Cliente result = new Cliente(
					rs.getInt("cliente_id"), 
					rs.getString("cliente_nome"),
					rs.getString("email"),
					rs.getString("senha")
				);
			Conexao.fechar();
			return result;
		}
		
		public static void getClienteLogin(String email, String senha) throws Exception{

			
			String sql = String.format("SELECT COUNT(*)V FROM Cliente WHERE email = '%1$s' "+ 
										"AND senha = '%2$s'", 
										email, senha);
			ResultSet rs = Conexao.getList(sql);

			if (rs.getInt("V") == 0)
				throw new Exception("Login Inválido.");

			Conexao.fechar();
			
		}
	}

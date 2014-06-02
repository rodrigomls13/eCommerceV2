package ecommerce;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

public class AutorADO {
		public static void Incluir(Autor sender) throws Exception {
			String sql = String.format("INSERT INTO Autor (autor_nome) VALUES ('%1$s') ",
					sender.getAutor_nome());
			Conexao.execSql(sql) ;
		}
		
		public static void Alterar(Autor sender) throws Exception {
			String sql = String.format("UPDATE Autor SET " +					
					"autor_nome ='%1$s' " +
					"WHERE autor_id = %2$s",
					sender.getAutor_nome(),
					sender.getAutor_id());
			Conexao.execSql(sql);
		}
		
		public static void Excluir(Autor sender) throws Exception{
			String sql = ("DELETE FROM Autor WHERE autor_id =  "+	sender.getAutor_id());
			Conexao.execSql(sql);	
		}
		
		public static Collection<Autor> getDado() throws Exception{ 
			String sql = "SELECT * FROM Autor ";
			
			ResultSet rs = Conexao.getList(sql);
			Collection<Autor> result = new Vector<Autor>();
			
			while (rs.next())
			{
				result.add(new Autor(
					rs.getInt("autor_id"), 
					rs.getString("autor_nome")					
				));
			}
			Conexao.fechar();
			return result;
		}
		
		public static Autor getById(String codigo) throws Exception {
			String sql = "SELECT * FROM Autor WHERE autor_id = "+codigo;
			ResultSet rs = Conexao.getList(sql);
			Autor result = new Autor(
					rs.getInt("autor_id"), 
					rs.getString("autor_nome")		
				);
			Conexao.fechar();
			return result;
		}
		
		public static Autor getByNome(String nome) throws Exception{ 
			String sql = "SELECT * FROM Autor WHERE autor_nome = '"+nome+"'";
			ResultSet rs = Conexao.getList(sql);
			Autor result = new Autor(
					rs.getInt("autor_id"), 
					rs.getString("autor_nome")		
				);
			Conexao.fechar();
			return result;
		}
		
	}

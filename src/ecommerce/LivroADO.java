package ecommerce;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

public class LivroADO {
		public static void Incluir(Livro sender) throws Exception {
			String sql = String.format("INSERT INTO Livro (titulo, preco, ano, paginas, assunto_id) VALUES ('%1$s', '%2$s', '%3$s', '%4$s', '%5$s') ",
					sender.getTitulo(),
					sender.getPreco(),
					sender.getAno(),
					sender.getPaginas(),
					sender.getAssunto_id());
			Conexao.execSql(sql) ;
		}
		
		public static void Alterar(Livro sender) throws Exception {
			String sql = String.format("UPDATE Livro SET " +
					"titulo ='%1$s', " +
					"preco = '%2$s', " +
					"ano ='%3$s', " +
					"paginas ='%4$s', " +
					"assunto_id ='%5$s' " +
					"WHERE livro_id = %6$s",
					sender.getTitulo(),
					sender.getPreco(),
					sender.getAno(),
					sender.getPaginas(),
					sender.getAssunto_id(),
					sender.getLivro_id());
			Conexao.execSql(sql);
		}
		
		public static void Excluir(Livro sender) throws Exception{
			String sql = ("DELETE FROM Livro WHERE livro_id =  "+	sender.getLivro_id());
			Conexao.execSql(sql);	
		}
		
		public static Collection<Livro> getDado() throws Exception{ 
			String sql = "SELECT * FROM Livro ";
			
			ResultSet rs = Conexao.getList(sql);
			Collection<Livro> result = new Vector<Livro>();
			
			while (rs.next())
			{
				result.add(new Livro(
					rs.getInt("livro_id"), 
					rs.getString("titulo"),
					rs.getDouble("preco"),
					rs.getInt("ano"),
					rs.getInt("paginas"),
					rs.getInt("assunto_id")
				));
			}
			Conexao.fechar();
			return result;
		}
		
		public static Livro getById(String codigo) throws Exception {
			String sql = "SELECT * FROM Livro WHERE livro_id = "+codigo;
			ResultSet rs = Conexao.getList(sql);
			Livro result = new Livro(
					rs.getInt("livro_id"), 
					rs.getString("titulo"),
					rs.getDouble("preco"),
					rs.getInt("ano"),
					rs.getInt("paginas"),
					rs.getInt("assunto_id")
				);
			Conexao.fechar();
			return result;
		}
		
		public static Livro getByNome(String nome) throws Exception{ 
			String sql = "SELECT * FROM Livro WHERE titulo = '"+nome+"'";
			ResultSet rs = Conexao.getList(sql);
			Livro result = new Livro(
					rs.getInt("livro_id"), 
					rs.getString("titulo"),
					rs.getDouble("preco"),
					rs.getInt("ano"),
					rs.getInt("paginas"),
					rs.getInt("assunto_id")
				);
			Conexao.fechar();
			return result;
		}
		
	}

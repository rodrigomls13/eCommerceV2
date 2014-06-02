package ecommerce;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

public class LivroAutorADO {
		public static void Incluir(LivroAutor sender) throws Exception {
			String sql = String.format("INSERT INTO livro_autor (livro_id, autor_id) VALUES ('%1$s', '%2$s') ",
					sender.getLivro_id(),
					sender.getAutor_id());
			Conexao.execSql(sql) ;
		}
		
		public static void Alterar(LivroAutor sender) throws Exception {
			String sql = String.format("UPDATE livro_autor SET " +
					"livro_id ='%1$s', " +
					"autor_id = '%2$s' " +
					"WHERE livro_autor_id = %3$s",
					sender.getLivro_id(),
					sender.getAutor_id(),
					sender.getLivro_autor_id());
			Conexao.execSql(sql);
		}
		
		public static void Excluir(LivroAutor sender) throws Exception{
			String sql = ("DELETE FROM livro_autor WHERE livro_autor_id =  "+	sender.getLivro_autor_id());
			Conexao.execSql(sql);	
		}
		
		public static Collection<LivroAutor> getDado() throws Exception{ 
			String sql = "SELECT * FROM livro_autor ";
			
			ResultSet rs = Conexao.getList(sql);
			Collection<LivroAutor> result = new Vector<LivroAutor>();
			
			while (rs.next())
			{
				result.add(new LivroAutor(
					rs.getInt("livro_autor_id"),
					rs.getInt("livro_id"),
					rs.getInt("autor_id")
				));
			}
			Conexao.fechar();
			return result;
		}
		
		public static LivroAutor getById(String codigo) throws Exception {
			String sql = "SELECT * FROM livro_autor WHERE livro_autor_id = "+codigo;
			ResultSet rs = Conexao.getList(sql);
			LivroAutor result = new LivroAutor(
					rs.getInt("livro_autor_id"),
					rs.getInt("livro_id"),
					rs.getInt("autor_id")
				);
			Conexao.fechar();
			return result;
		}
				
	}
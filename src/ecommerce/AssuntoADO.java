package ecommerce;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

public class AssuntoADO {
		public static void Incluir(Assunto sender) throws Exception {
			String sql = String.format("INSERT INTO Assunto (assunto_nome) VALUES ('%1$s') ",
					sender.getAssunto_nome());
			Conexao.execSql(sql) ;
		}
		
		public static void Alterar(Assunto sender) throws Exception {
			String sql = String.format("UPDATE Assunto SET " +					
					"assunto_nome ='%1$s' " +
					"WHERE assunto_id = %2$s",
					sender.getAssunto_nome(),
					sender.getAssunto_id());
			Conexao.execSql(sql);
		}
		
		public static void Excluir(Assunto sender) throws Exception{
			String sql = ("DELETE FROM Assunto WHERE assunto_id =  "+	sender.getAssunto_id());
			Conexao.execSql(sql);	
		}
		
		public static Collection<Assunto> getDado() throws Exception{ 
			String sql = "SELECT * FROM Assunto ";
			
			ResultSet rs = Conexao.getList(sql);
			Collection<Assunto> result = new Vector<Assunto>();
			
			while (rs.next())
			{
				result.add(new Assunto(
					rs.getInt("assunto_id"), 
					rs.getString("assunto_nome")					
				));
			}
			Conexao.fechar();
			return result;
		}
		
		public static Assunto getById(int codigo) throws Exception {
			String sql = "SELECT * FROM Assunto WHERE assunto_id = "+codigo;
			ResultSet rs = Conexao.getList(sql);
			Assunto result = new Assunto(
					rs.getInt("assunto_id"), 
					rs.getString("assunto_nome")		
				);
			Conexao.fechar();
			return result;
		}
		
		public static String getById2(int codigo) throws Exception {
			String sql = "SELECT assunto_nome FROM Assunto  WHERE assunto_id = "+codigo;
			ResultSet rs = Conexao.getList(sql);
			String result = rs.getString("assunto_nome");		
			Conexao.fechar();
			return result;

		}
		
		public static Assunto getByNome(String nome) throws Exception{ 
			String sql = "SELECT * FROM Assunto WHERE assunto_nome = '"+nome+"'";
			ResultSet rs = Conexao.getList(sql);
			Assunto result = new Assunto(
					rs.getInt("assunto_id"), 
					rs.getString("assunto_nome")		
				);
			Conexao.fechar();
			return result;
		}
}
		
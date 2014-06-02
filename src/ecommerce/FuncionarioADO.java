package ecommerce;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

public class FuncionarioADO {
		public static void Incluir(Funcionario sender) throws Exception {
			String sql = String.format("INSERT INTO Funcionario (login, senha, funcionario_nome) VALUES ('%1$s', '%2$s', '%3$s') ",
					sender.getLogin(),
					sender.getSenha(),
					sender.getFuncionario_nome());
			Conexao.execSql(sql) ;
		}
		
		public static void Alterar(Funcionario sender) throws Exception {
			String sql = String.format("UPDATE Funcionario SET " +
					"senha = '%1$s', " +
					"funcionario_nome ='%2$s' " +
					"WHERE login = '%3$s' ",
					sender.getSenha(),
					sender.getFuncionario_nome(),
					sender.getLogin());
			Conexao.execSql(sql);
		}
		
		public static void Excluir(Funcionario sender) throws Exception{
			String sql = ("DELETE FROM Funcionario WHERE login =  '"+	sender.getLogin()+"'");
			Conexao.execSql(sql);	
		}
		
		public static Collection<Funcionario> getDado() throws Exception{ 
			String sql = "SELECT * FROM Funcionario ";
			
			ResultSet rs = Conexao.getList(sql);
			Collection<Funcionario> result = new Vector<Funcionario>();
			
			while (rs.next())
			{
				result.add(new Funcionario(
					rs.getString("login"), 					
					rs.getString("senha"),
					rs.getString("funcionario_nome")
				));
			}
			Conexao.fechar();
			return result;
		}
		
		public static Funcionario getById(String codigo) throws Exception {
			String sql = "SELECT * FROM Funcionario WHERE login = '"+codigo+"'";
			ResultSet rs = Conexao.getList(sql);
			Funcionario result = new Funcionario(
					rs.getString("login"), 					
					rs.getString("senha"),
					rs.getString("funcionario_nome")
				);
			Conexao.fechar();
			return result;
		}
		
		public static Funcionario getByNome(String nome) throws Exception{ 
			String sql = "SELECT * FROM Funcionario WHERE funcionario_nome = '"+nome+"'";
			ResultSet rs = Conexao.getList(sql);
			Funcionario result = new Funcionario(
					rs.getString("login"), 					
					rs.getString("senha"),
					rs.getString("funcionario_nome")
				);
			Conexao.fechar();
			return result;
		}
		
		public static void getFuncionarioLogin(String login, String senha) throws Exception{
			
			String sql = String.format("SELECT COUNT(*)V FROM Funcionario WHERE login = '%1$s' "+ 
										"AND senha = '%2$s'", 
										login, senha);
			ResultSet rs = Conexao.getList(sql);
			
			if(rs.getInt("V")==0){
				throw new Exception("Login Inválido");
			}
			
			Conexao.fechar();
			
		}
	}

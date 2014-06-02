package ecommerce;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/cadastro_func","/rel_func","/FuncionarioController"})
public class FuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FuncionarioController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcessa(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcessa(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doProcessa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String acao = request.getParameter("acao");
		String url = "/cadastro_func.jsp";

		if (acao.contains("Gravar"))
			url = Gravar(request, response);

		else if (acao.equals("Listar"))
			url = Listar(request, response);

		else if (acao.equals("Alterar"))
			url = Alterar(request, response);

		else if (acao.equals("Incluir"))
			url = Incluir(request, response);

		else if (acao.equals("Excluir"))
			url = Excluir(request, response);

		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);

		// forma reduzida
		// getServletContext().getRequestDispatcher(url).forward(request,
		// response);
	}

	protected String Gravar(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		Funcionario Funcionario = new Funcionario(
			request.getParameter("login"),
			request.getParameter("senha"),
			request.getParameter("funcionario_nome")
		);

		try {
			if (acao.equals("GravarAlterar"))
				FuncionarioADO.Alterar(Funcionario);

			else if (acao.equals("GravarIncluir"))
				FuncionarioADO.Incluir(Funcionario);

			else if (acao.equals("GravarExcluir"))
				FuncionarioADO.Excluir(Funcionario);
			
			else if (acao.equals("GravarLogar"))
				FuncionarioADO.getFuncionarioLogin(Funcionario.getLogin(),Funcionario.getSenha());			
			

		} catch (Exception ex) {
			request.setAttribute("erro", ex);
			return "/erro.jsp";
		}
		
		request.setAttribute("Funcionario", Funcionario);
		
		
		request.setAttribute("url", "principal_func.jsp");

		
		return "/sucesso.jsp";
	}

	protected String Incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Funcionario Funcionario = new Funcionario("", "", "");

		request.setAttribute("Funcionario", Funcionario);
		request.setAttribute("acao", "Incluir");
		return "/cadastro_func.jsp";
	}
	protected String Alterar(HttpServletRequest request,HttpServletResponse response) throws Exception {

		Funcionario funcionario = FuncionarioADO.getById(request.getParameter("codigo"));

		request.setAttribute("funcionario", funcionario);
		request.setAttribute("acao", "Alterar");
		return "/cadastro_func.jsp";
	}

	protected String Excluir(HttpServletRequest request,HttpServletResponse response) throws Exception {

		Funcionario funcionario = FuncionarioADO.getById(request.getParameter("codigo"));

		request.setAttribute("funcionario", funcionario);
		request.setAttribute("acao", "Excluir");
		request.setAttribute("readOnly", true);
		return "/cadastro_func.jsp";
	}

	protected String Listar(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException {
		try {
			Collection<Funcionario> funcionarios = FuncionarioADO.getDado();
			request.setAttribute("funcionarios", funcionarios);
			return "/rel_func.jsp";
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("erro", ex);
			return "/erro.jsp";
		}
	}
}


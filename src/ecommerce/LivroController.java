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

@WebServlet("/LivroController")
public class LivroController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public LivroController() {
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
		String url = "/cadastro_livro.jsp";

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
		Livro livro = new Livro(
			Integer.parseInt(request.getParameter("codigo")),	
			request.getParameter("titulo"),
			Double.parseDouble(request.getParameter("preco")),
			Integer.parseInt(request.getParameter("ano")),
			Integer.parseInt(request.getParameter("paginas")),
			Integer.parseInt(request.getParameter("assunto"))
		);

		try {
			if (acao.equals("GravarAlterar"))
				LivroADO.Alterar(livro);

			else if (acao.equals("GravarIncluir"))
				LivroADO.Incluir(livro);

			else if (acao.equals("GravarExcluir"))
				LivroADO.Excluir(livro);							

		} catch (Exception ex) {
			request.setAttribute("erro", ex);
			return "/erro.jsp";
		}
		
		request.setAttribute("livro", livro);
		request.setAttribute("url", "principal_func.jsp");

		return "/sucesso.jsp";
	}

	protected String Incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Livro livro = new Livro(0, "",0,0,0,0);

		request.setAttribute("livro", livro);
		request.setAttribute("acao", "Incluir");
		try {
			Collection<Assunto> assuntos = AssuntoADO.getDado();
			request.setAttribute("assuntos", assuntos);
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("erro", ex);
			return "/erro.jsp";
		}
		return "/cadastro_livro.jsp";
	}

	protected String Alterar(HttpServletRequest request,HttpServletResponse response) throws Exception {

		Livro livro = LivroADO.getById(request.getParameter("codigo"));
		try {
			Collection<Assunto> assuntos = AssuntoADO.getDado();
			request.setAttribute("assuntos", assuntos);
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("erro", ex);
			return "/erro.jsp";
		}
		request.setAttribute("livro", livro);
		request.setAttribute("acao", "Alterar");
		return "/cadastro_livro.jsp";
	}

	protected String Excluir(HttpServletRequest request,HttpServletResponse response) throws Exception {

		Livro livro = LivroADO.getById(request.getParameter("codigo"));
		try {
			Collection<Assunto> assuntos = AssuntoADO.getDado();
			request.setAttribute("assuntos", assuntos);
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("erro", ex);
			return "/erro.jsp";
		}
		request.setAttribute("livro", livro);
		request.setAttribute("acao", "Excluir");
		request.setAttribute("readOnly", true);
		return "/cadastro_livro.jsp";
	}

	protected String Listar(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException {
		try {
			Collection<Livro> livros = LivroADO.getDado();
			request.setAttribute("livros", livros);
			return "/rel_livro.jsp";
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("erro", ex);
			return "/erro.jsp";
			
		}
	}
}

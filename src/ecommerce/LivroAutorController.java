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

@WebServlet("/LivroAutorController")
public class LivroAutorController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public LivroAutorController() {
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
		String url = "/cadastro_livro_autor.jsp";

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
		LivroAutor livro_autor = new LivroAutor(
			1,	
			Integer.parseInt(request.getParameter("livro_id")),
			Integer.parseInt(request.getParameter("autor_id"))
		);

		try {
			if (acao.equals("GravarAlterar"))
				LivroAutorADO.Alterar(livro_autor);

			else if (acao.equals("GravarIncluir"))
				LivroAutorADO.Incluir(livro_autor);

			else if (acao.equals("GravarExcluir"))
				LivroAutorADO.Excluir(livro_autor);							

		} catch (Exception ex) {
			request.setAttribute("erro", ex);
			return "/erro.jsp";
		}
		
		request.setAttribute("livro_autor", livro_autor);
		request.setAttribute("url", "principal_func.jsp");

		return "/sucesso.jsp";
	}

	protected String Incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LivroAutor livro_autor = new LivroAutor(0,0,0);

		request.setAttribute("livro_autor", livro_autor);
		request.setAttribute("acao", "Incluir");
		return "/LivroAutorForm.jsp";
	}

	protected String Alterar(HttpServletRequest request,HttpServletResponse response) throws Exception {

		LivroAutor livro_autor = LivroAutorADO.getById(request.getParameter("codigo").toString());

		request.setAttribute("livro_autor", livro_autor);
		request.setAttribute("acao", "Alterar");
		return "/LivroAutorForm.jsp";
	}

	protected String Excluir(HttpServletRequest request,HttpServletResponse response) throws Exception {

		LivroAutor livro_autor = LivroAutorADO.getById(request.getParameter("codigo").toString());

		request.setAttribute("livro_autor", livro_autor);
		request.setAttribute("acao", "Excluir");
		request.setAttribute("readOnly", true);
		return "/LivroAutorForm.jsp";
	}

	protected String Listar(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException {
		try {
			Collection<LivroAutor> livro_autor = LivroAutorADO.getDado();
			request.setAttribute("livro_autor", livro_autor);
			return "/LivroAutorListar.jsp";
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("erro", ex);
			return "/erro.jsp";
		}
	}
}

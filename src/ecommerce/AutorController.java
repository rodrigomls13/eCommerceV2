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

@WebServlet(urlPatterns = {"/cadastro_autor","/rel_autor","/AutorController"})
public class AutorController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public AutorController() {
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
		String url = "/cadastro_autor.jsp";

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
		Autor autor = new Autor(
			Integer.parseInt(request.getParameter("codigo")),	
			request.getParameter("nome")
		);

		try {
			if (acao.equals("GravarAlterar"))
				AutorADO.Alterar(autor);

			else if (acao.equals("GravarIncluir"))
				AutorADO.Incluir(autor);

			else if (acao.equals("GravarExcluir"))
				AutorADO.Excluir(autor);							

		} catch (Exception ex) {
			request.setAttribute("erro", ex);
			return "/erro.jsp";
		}
		
		request.setAttribute("autor", autor);
		request.setAttribute("url", "principal_func.jsp");

		return "/sucesso.jsp";
	}

	protected String Incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Autor autor = new Autor(0, "");

		request.setAttribute("autor", autor);
		request.setAttribute("acao", "Incluir");
		return "/cadastro_autor.jsp";
	}

	protected String Alterar(HttpServletRequest request,HttpServletResponse response) throws Exception {

		Autor autor = AutorADO.getById(request.getParameter("codigo").toString());

		request.setAttribute("autor", autor);
		request.setAttribute("acao", "Alterar");
		return "/cadastro_autor.jsp";
	}

	protected String Excluir(HttpServletRequest request,HttpServletResponse response) throws Exception {

		Autor autor = AutorADO.getById(request.getParameter("codigo").toString());

		request.setAttribute("autor", autor);
		request.setAttribute("acao", "Excluir");
		request.setAttribute("readOnly", true);
		return "/cadastro_autor.jsp";
	}

	protected String Listar(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException {
		try {
			Collection<Autor> autores = AutorADO.getDado();
			request.setAttribute("autores", autores);
			return "/rel_autor.jsp";
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("erro", ex);
			return "/erro.jsp";
		}
	}
}

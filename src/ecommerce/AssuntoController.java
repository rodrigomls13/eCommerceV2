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

@WebServlet("/AssuntoController")
public class AssuntoController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public AssuntoController() {
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
		String url = "/cadastro_assunto.jsp";

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
		Assunto assunto = new Assunto(
			Integer.parseInt(request.getParameter("codigo")),	
			request.getParameter("nome")
		);

		try {
			if (acao.equals("GravarAlterar"))
				AssuntoADO.Alterar(assunto);

			else if (acao.equals("GravarIncluir"))
				AssuntoADO.Incluir(assunto);

			else if (acao.equals("GravarExcluir"))
				AssuntoADO.Excluir(assunto);							

		} catch (Exception ex) {
			request.setAttribute("erro", ex);
			return "/erro.jsp";
		}
		
		request.setAttribute("assunto", assunto);
		request.setAttribute("url", "principal_func.jsp");

		return "/sucesso.jsp";
	}

	protected String Incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Assunto assunto = new Assunto(0, "");

		request.setAttribute("assunto", assunto);
		request.setAttribute("acao", "Incluir");
		return "/cadastro_assunto.jsp";
	}

	protected String Alterar(HttpServletRequest request,HttpServletResponse response) throws Exception {

		Assunto assunto = AssuntoADO.getById(Integer.parseInt(request.getParameter("codigo")));

		request.setAttribute("assunto", assunto);
		request.setAttribute("acao", "Alterar");
		return "/cadastro_assunto.jsp";
	}

	protected String Excluir(HttpServletRequest request,HttpServletResponse response) throws Exception {

		Assunto assunto = AssuntoADO.getById(Integer.parseInt(request.getParameter("codigo")));

		request.setAttribute("assunto", assunto);
		request.setAttribute("acao", "Excluir");
		request.setAttribute("readOnly", true);
		return "/cadastro_assunto.jsp";
	}

	protected String Listar(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException {
		try {
			Collection<Assunto> assuntos = AssuntoADO.getDado();
			request.setAttribute("assuntos", assuntos);
			return "/rel_assunto.jsp";
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("erro", ex);
			return "/erro.jsp";
		}
	}
}

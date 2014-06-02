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

@WebServlet(urlPatterns = {"/rel_cliente","/cadastro_cliente","/ClienteController"})
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClienteController() {
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
		String url = "/cadastro_cliente.jsp";

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
		Cliente cliente = new Cliente(
			Integer.parseInt(request.getParameter("codigo")),	
			request.getParameter("nome"),
			request.getParameter("email"),
			request.getParameter("senha")
		);

		try {
			if (acao.equals("GravarAlterar"))
				ClienteADO.Alterar(cliente);

			else if (acao.equals("GravarIncluir"))
				ClienteADO.Incluir(cliente);

			else if (acao.equals("GravarExcluir"))
				ClienteADO.Excluir(cliente);
			
			else if (acao.equals("GravarLogar"))
				ClienteADO.getClienteLogin(cliente.getEmail(),cliente.getSenha());
			
			

		} catch (Exception ex) {
			request.setAttribute("erro", ex);
			return "/erro.jsp";
		}
		
		request.setAttribute("cliente", cliente);
		
		if (acao.equals("GravarLogar")){
			request.setAttribute("url", "principal_cliente.jsp");
		}
		
		else if(acao.equals("GravarIncluir")){
			request.setAttribute("url", "index.jsp");

		}else{
			
			request.setAttribute("url", "principal_func.jsp");
		}
		return "/sucesso.jsp";
	}

	protected String Incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cliente cliente = new Cliente(0, "","", "");

		request.setAttribute("cliente", cliente);
		request.setAttribute("acao", "Incluir");
		return "/cadastro_cliente.jsp";
	}

	protected String Alterar(HttpServletRequest request,HttpServletResponse response) throws Exception {

		Cliente cliente = ClienteADO.getById(request.getParameter("codigo").toString());

		request.setAttribute("cliente", cliente);
		request.setAttribute("acao", "Alterar");
		return "/cadastro_cliente.jsp";
	}

	protected String Excluir(HttpServletRequest request,HttpServletResponse response) throws Exception {

		Cliente cliente = ClienteADO.getById(request.getParameter("codigo").toString());

		request.setAttribute("cliente", cliente);
		request.setAttribute("acao", "Excluir");
		request.setAttribute("readOnly", true);
		return "/cadastro_cliente.jsp";
	}

	protected String Listar(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException {
		try {
			Collection<Cliente> clientes = ClienteADO.getDado();
			request.setAttribute("clientes", clientes);
			return "/rel_cliente.jsp";
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("erro", ex);
			return "/erro.jsp";
		}
	}
}

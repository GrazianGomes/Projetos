package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/update1", "/update2", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			novocontato(request, response);
		} else if (action.equals("/update1")) {
			editarContato(request, response);
		} else if (action.equals("/update2")) {
			editarContato2(request, response);
		} else if (action.equals("/delete")) {
			excluirContato(request, response);
		}

	}

	// Listar contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que irá receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarContatos();
		// Encaminha a listar ao documento agendar.jsp
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}

	// Novo contatos
	protected void novocontato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Teste de refcebimeno dos dados de formulario
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("fone"));
		System.out.println(request.getParameter("email"));
		// Setar as variaveis Javabeans
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		// chamar o metodo inserircontato passando o objeto contato
		dao.inserirContato(contato);
		// redirencionar para o documento agenda.jsp
		response.sendRedirect("main");

	}

	// **Editar contato**/
	//Updata1
	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		// System.out.println(id);
		contato.setIdcon(id);
		dao.listarContato(contato);
		request.setAttribute("id", contato.getIdcon());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("email", contato.getEmail());
		// Execytar o encaminhamento
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);

	}
	//Updata2
	protected void editarContato2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		contato.setIdcon(request.getParameter("id"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		dao.alterarContato(contato);
		response.sendRedirect("main");

	}
	// **Excluir contato**/
	protected void excluirContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		contato.setIdcon(id);
		dao.apagarContato(contato);
		response.sendRedirect("main");

	}
}

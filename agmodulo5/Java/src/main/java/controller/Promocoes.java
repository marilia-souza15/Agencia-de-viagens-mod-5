package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAOPromocoes;
import model.JbPromocoes;

/**
 * Servlet implementation class Clientes
 */
@WebServlet(urlPatterns = { "/Promocoes", "/main2", "/insert2", "/select2", "/update2", "/delete2", "/report2" })
public class Promocoes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAOPromocoes dao = new DAOPromocoes();

	/** Objeto contato. */
	JbPromocoes contato = new JbPromocoes();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Promocoes() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/main2")) {
			contatos(request, response);
		} else if (action.equals("/insert2")) {
			adicionarContato(request, response);
		} else if (action.equals("/select2")) {
			listarContato(request, response);
		} else if (action.equals("/update2")) {
			editarContato(request, response);
		} else if (action.equals("/delete2")) {
			removerContato(request, response);
		} else if (action.equals("/report2")) {
			gerarRelatorio(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Contatos.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JbPromocoes> lista = dao.listarContatos();
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}

	/**
	 * Adicionar contato.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */

	protected void adicionarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setPreco(request.getParameter("preco"));
		contato.setData_ida(request.getParameter("data_ida"));
		dao.inserirContato(contato);
		response.sendRedirect("main2");
	}

	/**
	 * Listar contato.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setId_promocoes(request.getParameter("id_promocoes"));
		dao.selecionarContato(contato);
		request.setAttribute("id_promocoes", contato.getId_promocoes());
		request.setAttribute("preco", contato.getPreco());
		request.setAttribute("data_ida", contato.getData_ida());
		request.setAttribute("nome_promocoes", contato.getNome_promocoes());
		RequestDispatcher rd = request.getRequestDispatcher("editar2.jsp");
		rd.forward(request, response);
	}

	/**
	 * Editar contato.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setId_promocoes(request.getParameter("id_promocoes"));
		contato.setPreco(request.getParameter("preco"));
		contato.setData_ida(request.getParameter("data_ida"));
		contato.setNome_promocoes(request.getParameter("nome_promocoes"));
		dao.alterarContato(contato);
		response.sendRedirect("main2");
	}

	/**
	 * Remover contato.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setId_promocoes(request.getParameter("id_promocoes"));
		dao.deletarContato(contato);
		response.sendRedirect("main2");
	}

	/**
	 * Gerar relatorio.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "contatos.pdf");
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();
			documento.add(new Paragraph("Lista de Promocoes:"));
			documento.add(new Paragraph(" "));
			PdfPTable tabela = new PdfPTable(3
);
			PdfPCell col1 = new PdfPCell(new Paragraph("Pre?o"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Data Ida"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Data Volta"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			ArrayList<JbPromocoes> lista = dao.listarContatos();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getPreco());
				tabela.addCell(lista.get(i).getData_ida());
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}

}
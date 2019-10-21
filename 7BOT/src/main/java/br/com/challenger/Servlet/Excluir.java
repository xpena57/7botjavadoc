package br.com.challenger.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.challenger.Bo.BOUsuario;

/**
 * Servlet implementation class ExcluirAluno
 */
@WebServlet("/excluirAluno")
public class Excluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			String excluir = BOUsuario.excluirUsuario(id);
			boolean excluido = excluir.equals("ok");
			
			response.sendRedirect(excluido ? "adm" : "views/adm-index.jsp?" + excluir);
			
		}	catch(Exception e) {
			e.printStackTrace();
		}
	}
}



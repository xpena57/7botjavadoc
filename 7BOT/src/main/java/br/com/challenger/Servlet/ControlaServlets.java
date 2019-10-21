package br.com.challenger.Servlet;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/controlador")
public class ControlaServlets extends HttpServlet{

	
	private static final long serialVersionUID = -1488846977917973438L;
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String tarefa = "";
		boolean adm = false;
		if(req.getParameter("email").equals("adm@hotmail.com") &&
				req.getParameter("senha").equals("adm1234567")) {
			tarefa = "Adm";
			adm = true;
		} else {
			tarefa = req.getParameter("tarefa");
		}
		
		tarefa = "br.com.challenger.Servlet." + tarefa;
		
		try {
			Class<?> classe = Class.forName(tarefa);
			Tarefa instancia = (Tarefa) classe.newInstance();
			String url = instancia.processarRequest(req, resp);
			
			if(adm)  
				req.getRequestDispatcher(url).forward(req, resp);
			else
			resp.sendRedirect(url);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

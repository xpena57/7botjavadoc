package br.com.challenger.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


import br.com.challenger.Dao.AdmDAO;
import br.com.challenger.Beans.Usuario;


public class Adm implements Tarefa{

	private static final long serialVersionUID = -5183145833756227731L;

	@Override
	public String processarRequest(HttpServletRequest req, HttpServletResponse resp) {	
		AdmDAO aDao = null;
		List<Usuario> usuario = null;
		
		try {
			usuario = new AdmDAO().criarLista();
		} catch(Exception e) {
			e.printStackTrace();
		}
			req.setAttribute("listaUsuarios", usuario);
			System.out.println("Ola adm !");
			return "views/index-adm.jsp";
			

	}

}

package br.com.challenger.Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.challenger.Beans.Usuario;
import br.com.challenger.Bo.BOUsuario;



public class Cadastrar implements Tarefa {

	private static final long serialVersionUID = 80515293618763397L;

	
	@Override
	public String processarRequest(HttpServletRequest req, HttpServletResponse resp) {
	
		String user = "";
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Usuario u = new Usuario(nome, email, senha, sdf.format(new Date()));
		try {
			user = BOUsuario.adicionarUsuario(u);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(user.equals("ok"))
			return "index.html?cadastrado";

		return "index.html?erro=" + user;
	}
}


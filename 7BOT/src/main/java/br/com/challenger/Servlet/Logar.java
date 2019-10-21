package br.com.challenger.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.challenger.Bo.BOUsuario;

public class Logar implements Tarefa{

	@Override
	public String processarRequest(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("TO AQUI xD");
		
		Cookie cookie = null;
		String email = req.getParameter("email");
		System.out.println(email);
		String senha = req.getParameter("senha");
		System.out.println(senha);
		
		if(email.equals("7bot@adm.com") && senha.equals("adm123456")) 
			return "adm";
		String user = "";
		try {
			user = BOUsuario.autenticarUsuario(email, senha);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(user.indexOf(";") < 1) 
			return "app.html?" + user;
		
		// ESSA PARTE EU QUIS PEGAR O VALOR 'NOME' E PEGAR O PRIMEIRO NOME DO USUARIO
		String nome = user.split(";")[0].split(" ")[0];
		email = user.split(";")[1];
		senha = user.split(";")[2];

		
		
		cookie = new Cookie("logado", nome);
		resp.addCookie(cookie);
		return "app.html";

	
	}
	
	
}



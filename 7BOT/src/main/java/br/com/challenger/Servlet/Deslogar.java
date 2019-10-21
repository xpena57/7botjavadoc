package br.com.challenger.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeslogarServlet
 */
@WebServlet(urlPatterns = "/deslogar")
public class Deslogar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	Cookie[] cookies = req.getCookies();
    	
    	for(Cookie cookie: cookies) {
    		if(cookie.getName().equals("logado")) {
    			cookie.setMaxAge(0);
    			resp.addCookie(cookie);
    		}
    	}
    	
    	resp.sendRedirect("index.html");
    }

}

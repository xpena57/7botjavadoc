package br.com.challenger.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.challenger.Beans.Disciplinas;
import br.com.challenger.Dao.DisciplinasDAO;

/**
 * Servlet implementation class listarDisciplinas
 */
@WebServlet("/disciplinas")
public class listarDisciplinas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	DisciplinasDAO dDAO = null;
    	
    	try {
    		
    		dDAO = new DisciplinasDAO();
    		List<Disciplinas> lista = dDAO.getDisciplinas();
    		
    		req.setAttribute("lista", lista);
    		req.getRequestDispatcher("disciplinas.jsp").forward(req, resp);
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			dDAO.Encerrar();
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	
    	
    	
    }

}

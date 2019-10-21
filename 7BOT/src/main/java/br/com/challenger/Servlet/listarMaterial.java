package br.com.challenger.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.challenger.Beans.Material;
import br.com.challenger.Dao.MaterialDAO;

/**
 * Servlet implementation class listarConteudo
 */
@WebServlet("/listarMaterial")
public class listarMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	MaterialDAO mDAO = null;
    	try {
    		String disciplina = req.getParameter("disciplina");
    		String materia = req.getParameter("material");
    		
    		mDAO = new MaterialDAO();
    		List<Material> lista = mDAO.getConteudos();
    		System.out.println(lista);
    		req.setAttribute("nomeDisciplina", disciplina);
    		req.setAttribute("nomeMateria", materia);
    		req.setAttribute("lista", lista);
    		
    		req.getRequestDispatcher("conteudo.jsp").forward(req, resp);
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			mDAO.Encerrar();
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    }

}

package br.com.challenger.Dao;
/**
 * @author Leonardo Pena
 * @version 1.0
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.challenger.Beans.Disciplinas;
import br.com.challenger.Conexao.Conexao;

public class DisciplinasDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public DisciplinasDAO() throws Exception{
		con = Conexao.Conectar();
	}
	
	public void Encerrar() throws Exception {
		con.close();
	}
	
	public List<Disciplinas> getDisciplinas() throws Exception{
		stmt = con.prepareStatement("SELECT * FROM SETEBOT_DISCIPLINA");
		rs = stmt.executeQuery();
		
		List<Disciplinas> listaDisciplinas = new ArrayList<Disciplinas>();
		System.out.println("AQUI ENTRO");
		while(rs.next()) {
			listaDisciplinas.add(
					
					new Disciplinas(rs.getString("NOME_DISCIPLINA"), 
							getConteudo(rs.getInt("ID_DISCIPLINA"))));
			
		}
		
		return listaDisciplinas;
		/**Metodo usado para: Escolher a disciplina desejada
		 * @author Leonardo Pena
		 * @return lista de disciplinas
		 */
		
	}
	
	public List<String> getConteudo(int id) throws Exception {
		stmt = con.prepareStatement("select NOME from SETEBOT_CONTEUDO where ID_DISCIPLINA = ?");
		
		stmt.setInt(1, id);
		
		rs = stmt.executeQuery();
		
		List<String> listaConteudo = new ArrayList<String>();
		while(rs.next()) {
			listaConteudo.add(rs.getString("NOME"));
		}
		
		return listaConteudo;
		/**Metodo usado para: Escolher o conteudo desejado
		 * @author Leonardo Pena
		 * @return lista de conteúdo
		 */
		
	}
	
	
}

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

import br.com.challenger.Beans.Material;
import br.com.challenger.Conexao.Conexao;

public class MaterialDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public MaterialDAO() throws Exception{
		con = Conexao.Conectar();
	}
	
	public void Encerrar() throws Exception {
		con.close();
	}
	
	public List<Material> getConteudos() throws Exception{
		stmt = con.prepareStatement("SELECT * FROM SETEBOT_MATERIAL");
		rs = stmt.executeQuery();
		List<Material> lista = new ArrayList<Material>();
		
		while(rs.next()) {
			if(rs.getString("ESCOPO2") == null)
				lista.add(new Material(rs.getString("TITULO"),
						rs.getString("ESCOPO")));
			else 
				lista.add(new Material(rs.getString("TITULO"),
						rs.getString("ESCOPO"), rs.getString("ESCOPO2")));
		}
		
		return lista;
	}
	/**Metodo usado para: Escolha do material desejado pelo usuario
	 * @author Leonardo Pena
	 * @return lista de material
	 */
	
}

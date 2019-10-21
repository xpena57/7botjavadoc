package br.com.challenger.Bo;
/**
 * @author Leonardo Pena
 * @version 1.0
 * 
 */

import br.com.challenger.Beans.Usuario;
import br.com.challenger.Dao.UsuarioDAO;

public class BOUsuario {
	
	public static String autenticarUsuario(String email, String senha) throws Exception{
		UsuarioDAO uDAO = new UsuarioDAO();
	
		if(email.equals("")) {
			return "Email em branco";
			
		}
		if(email.indexOf("@") < 1) {
			return "Email invalido: Não possui arroba ( @ )";
			
		}
		if(email.length() < 8) {
			return "Email invalido: poucos caracteres para ser um email";
			
		}
		
		if(senha.equals("")) {
			return "Senha em branco";
			
		}
		
		if(senha.length() < 8) {
			return "Senha é menor que 8 caracteres!";
			
		}
		
		Usuario autenticado = uDAO.authUser(email, senha);
		uDAO.Encerrar();
		
		if(autenticado.getNome() == null) {
			return "Senha ou/e Email não estão corretos!";
			
		}
		return autenticado.getNome() + ";" + autenticado.getEmail() + ";" + autenticado.getSenha();
		
		/** Metodo usado para: Autenticação do usuario.
		 * @author Leonardo Pena
		 * @return email em branco 
		 * @return email invalido não possui @
		 * @return email invalido poucos caracteres 
		 * @return senha em branco 
		 * @return senha menor que 8 caracteres
		 * @return senha e email incorretos
		 */
		
		
	}
	
	public static String excluirUsuario(int codigo) throws Exception{
		UsuarioDAO uDAO = new UsuarioDAO();
		
		if(codigo < 1) 
			return "Codigo invalido!";
		
		
		if(uDAO.getUser(codigo) < 1) 
			return "Usuario não existe!";
		
		boolean excluido = uDAO.deleteUser(codigo);
		uDAO.Encerrar();
		
		if(!excluido)
			return "Erro em excluir!";
		
		return "ok";
		
		/** Metodo Usado para: O usuario excluir sua conta
		 * @author Leonardo Pena
		 * @return codigo invalido
		 * @return usuario inexistente
		 * @return erro de exclusão
		 */
	}
	
	public static String adicionarUsuario(Usuario objUsuario) throws Exception{
		
		UsuarioDAO uDAO = new UsuarioDAO();

		if(objUsuario.getNome().equals(""))
			return "Nome em branco";
			
		if(uDAO.getUser(objUsuario.getEmail()) > 0) 
			return "Email já cadastrado";
		
		if(objUsuario.getEmail().equals(""))
			return "Email em branco";
		
		if(objUsuario.getEmail().indexOf("@") < 1) 
			return "Email não possui arroba ( @ )";
		
		
		for(int c = 0; c <= 9; c++) {
			if(objUsuario.getNome().equals(c)) 
				return "O nome não pode possuir numeros!";
		}
		
		if(objUsuario.getSenha().length() < 8) 
			return "A senha não pode ter menos que 9 caracteres";
		
		
		int adicionado = uDAO.insertUsuario(objUsuario);
		uDAO.Encerrar();
		
		if(adicionado < 1) {
			return "Erro ao adicionar";
		}
		
		return "ok";
		
		/** Metodo Usado para: Adicionar um novo usuario no sistema
		 * @author Leonardo Pena
		 * @return nome em branco
		 * @return email já cadastrado
		 * @return email em branco
		 * @return email não possui o caractere @
		 * @return o nome não pode possuir numeros
		 * @return a senha não pode ser menor que 9 caracteres
		 * @return erro ao adicionar usuario
		 */
	}
	
}

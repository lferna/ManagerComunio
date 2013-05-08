package usuario;

import java.sql.SQLException;

import email.Email;
import encrypt.EncryptMD5;
import exception.EncryptException;
import factory.DAOFactory;

public class UsuarioBO {
	
	public UsuarioBO(){
		
	}
	
	public void crearUsuario(UsuarioVO usuario) throws ClassNotFoundException, SQLException, EncryptException{
		DAOFactory daoFactory=new DAOFactory();
		UsuarioDAO usuarioDao=daoFactory.getUsuarioDAO();
		
		String password = usuario.getHash();
		//encriptamos la clave
		String hash = EncryptMD5.encriptar(usuario.getHash());
		usuario.setHash(hash);
		//fin de la encriptación
		
		usuarioDao.crearUsuario(usuario);
		//volvemos a establecer la password para enviar el email con los datos
		usuario.setHash(password);		
		//enviamos el correo
		Email email = new Email();
		email.enviarEmail(usuario);
		
		//y cerramos conexion
		usuarioDao.cerrarConexion();
	}
	
	public void modificarUsuario(){
		
	}
	
	public void eliminarUsuario(UsuarioVO usuario) throws SQLException, ClassNotFoundException{
		DAOFactory daoFactory=new DAOFactory();
		UsuarioDAO usuarioDao=daoFactory.getUsuarioDAO();
		usuarioDao.eliminarUsuario(usuario);
		usuarioDao.cerrarConexion();
	}

}

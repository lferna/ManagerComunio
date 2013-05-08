package tactica;

import java.sql.SQLException;

import usuario.UsuarioDAO;
import usuario.UsuarioVO;
import email.Email;
import encrypt.EncryptMD5;
import exception.EncryptException;
import factory.DAOFactory;

public class TacticaBO {

public TacticaBO(){
		
	}
	
	/**
	 * Método que nos permite crear una táctica nueva
	 * @param tactica Tactica
	 * @throws ClassNotFoundException Excepcion generada
	 * @throws SQLException Excepcion generada
	 * @throws EncryptException Excepcion generada
	 */
	public void crearTactica(TacticaVO tactica) throws ClassNotFoundException, SQLException, EncryptException{
		DAOFactory daoFactory=new DAOFactory();
		TacticaDAO tacticaDao=daoFactory.getTacticaDAO();
		
		tacticaDao.crearTactica(tactica);
	
		//y cerramos conexion
		tacticaDao.cerrarConexion();
	}
	
	/**
	 * Método que nos permite devolver una táctica nueva
	 * @param idTactica Tactica
	 * @throws ClassNotFoundException Excepcion generada
	 * @throws SQLException Excepcion generada
	 * @throws EncryptException Excepcion generada
	 */
	public TacticaVO devolverTactica(String idTactica) throws ClassNotFoundException, SQLException, EncryptException{
		DAOFactory daoFactory=new DAOFactory();
		TacticaDAO tacticaDao=daoFactory.getTacticaDAO();
		
		TacticaVO tactica = tacticaDao.devolverTactica(idTactica);
	
		//y cerramos conexion
		tacticaDao.cerrarConexion();
		
		return tactica;
	}
	
}

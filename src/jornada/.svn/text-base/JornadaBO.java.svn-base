package jornada;

import java.sql.SQLException;
import java.util.Collection;

import exception.EncryptException;
import factory.DAOFactory;

public class JornadaBO {
	
	
	/**
	 * Método que nos permite devolver las jornadas
	 * @return Jornadas
	 * @throws ClassNotFoundException Excepcion generada
	 * @throws SQLException Excepcion generada
	 * @throws EncryptException Excepcion generada
	 */
	public Collection devolverJornadas() throws ClassNotFoundException, SQLException, EncryptException{
		DAOFactory daoFactory=new DAOFactory();
		JornadaDAO jornadaDao=daoFactory.getJornadaDAO();
		
		Collection jornadas = jornadaDao.devolverJornadas();
	
		//y cerramos conexion
		jornadaDao.cerrarConexion();
		
		return jornadas;
	}

}

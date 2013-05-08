package puntuacion;

import java.sql.SQLException;
import java.util.Collection;

import exception.EncryptException;
import factory.DAOFactory;

public class PuntuacionBO {
	
	/**
	 * M�todo que se encarga de ver la puntuaci�n de un jugador una jornada
	 * @param puntuacion Vo con los datos de b�squeda
	 * @return puntos
	 * @throws ClassNotFoundException Excepci�n generada
	 * @throws SQLException Excepci�n generada
	 * @throws EncryptException Excepci�n generada
	 */
	public int verPuntuacionJugadorJornada(PuntuacionVO puntuacion) throws ClassNotFoundException, SQLException, EncryptException{
		DAOFactory daoFactory=new DAOFactory();
		PuntuacionDAO puntuacionDao=daoFactory.getPuntuacionDAO();
		
		int puntos = puntuacionDao.verPuntuacionJugadorJornada(puntuacion);
		puntuacionDao.cerrarConexion();
		return puntos;
	}

	/**
	 * M�todo que se encarga de ver la puntuaci�n de un determinado jugador
	 * @param puntuacion Vo con los datos de b�squeda
	 * @return puntos
	 * @throws ClassNotFoundException Excepci�n generada
	 * @throws SQLException Excepci�n generada
	 * @throws EncryptException Excepci�n generada
	 */
	public int verPuntuacionJugador(PuntuacionVO puntuacion) throws ClassNotFoundException, SQLException, EncryptException{
		DAOFactory daoFactory=new DAOFactory();
		PuntuacionDAO puntuacionDao=daoFactory.getPuntuacionDAO();
		
		int puntos = puntuacionDao.verPuntuacionJugador(puntuacion);
		puntuacionDao.cerrarConexion();
		return puntos;
	}
		

	/**
	 * M�todo que se encarga de ver la puntuaci�n de todos los jugadores en una jornada
	 * @param puntuacion Vo con los datos de b�squeda
	 * @return Colecci�n de puntos
	 * @throws ClassNotFoundException Excepci�n generada
	 * @throws SQLException Excepci�n generada
	 * @throws EncryptException Excepci�n generada
	 */
	public Collection verPuntuacionJornada(PuntuacionVO puntuacion) throws ClassNotFoundException, SQLException, EncryptException{
		DAOFactory daoFactory=new DAOFactory();
		PuntuacionDAO puntuacionDao=daoFactory.getPuntuacionDAO();
		
		Collection coleccionPuntos = puntuacionDao.verPuntuacionJornada(puntuacion);
		puntuacionDao.cerrarConexion();
		return coleccionPuntos;
	}
		

}

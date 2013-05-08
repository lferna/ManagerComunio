package puntuacion;

import java.sql.SQLException;
import java.util.Collection;

import exception.EncryptException;
import factory.DAOFactory;

public class PuntuacionBO {
	
	/**
	 * Método que se encarga de ver la puntuación de un jugador una jornada
	 * @param puntuacion Vo con los datos de búsqueda
	 * @return puntos
	 * @throws ClassNotFoundException Excepción generada
	 * @throws SQLException Excepción generada
	 * @throws EncryptException Excepción generada
	 */
	public int verPuntuacionJugadorJornada(PuntuacionVO puntuacion) throws ClassNotFoundException, SQLException, EncryptException{
		DAOFactory daoFactory=new DAOFactory();
		PuntuacionDAO puntuacionDao=daoFactory.getPuntuacionDAO();
		
		int puntos = puntuacionDao.verPuntuacionJugadorJornada(puntuacion);
		puntuacionDao.cerrarConexion();
		return puntos;
	}

	/**
	 * Método que se encarga de ver la puntuación de un determinado jugador
	 * @param puntuacion Vo con los datos de búsqueda
	 * @return puntos
	 * @throws ClassNotFoundException Excepción generada
	 * @throws SQLException Excepción generada
	 * @throws EncryptException Excepción generada
	 */
	public int verPuntuacionJugador(PuntuacionVO puntuacion) throws ClassNotFoundException, SQLException, EncryptException{
		DAOFactory daoFactory=new DAOFactory();
		PuntuacionDAO puntuacionDao=daoFactory.getPuntuacionDAO();
		
		int puntos = puntuacionDao.verPuntuacionJugador(puntuacion);
		puntuacionDao.cerrarConexion();
		return puntos;
	}
		

	/**
	 * Método que se encarga de ver la puntuación de todos los jugadores en una jornada
	 * @param puntuacion Vo con los datos de búsqueda
	 * @return Colección de puntos
	 * @throws ClassNotFoundException Excepción generada
	 * @throws SQLException Excepción generada
	 * @throws EncryptException Excepción generada
	 */
	public Collection verPuntuacionJornada(PuntuacionVO puntuacion) throws ClassNotFoundException, SQLException, EncryptException{
		DAOFactory daoFactory=new DAOFactory();
		PuntuacionDAO puntuacionDao=daoFactory.getPuntuacionDAO();
		
		Collection coleccionPuntos = puntuacionDao.verPuntuacionJornada(puntuacion);
		puntuacionDao.cerrarConexion();
		return coleccionPuntos;
	}
		

}

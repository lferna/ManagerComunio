package puntuacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class PuntuacionDAO {
	
	private Connection conexion=null;;
	private PreparedStatement sentencia=null;
	
	public PuntuacionDAO(Connection conexion) {
		this.conexion=conexion;
	}
		
	public void cerrarConexion() throws SQLException {

			if (sentencia!=null) sentencia.close();
			if (conexion!=null)
				conexion.close();
		
	}
	
	/**
	 * Método que nos permite ver la puntuación de un jugador en una jornada
	 * @param grupo Grupo a crear
	 * @throws SQLException Excepción generada
	 */
	public int verPuntuacionJugadorJornada(PuntuacionVO puntuacion) throws SQLException{
		String consulta="";
		consulta="select puntos from comunio.puntuacion where jornada=? and idJugador=?";
		sentencia=conexion.prepareStatement(consulta);
		sentencia.setInt(1, puntuacion.getJornada());
		sentencia.setInt(2, puntuacion.getIdJugador());
		ResultSet rs = sentencia.executeQuery();
		int puntos = 0;
		while (rs.next()){
			puntos = rs.getInt("puntos");
		}
		return puntos;
	}
	
	/**
	 * Método que nos permite ver la puntuación de un jugador
	 * @param grupo Grupo a crear
	 * @throws SQLException Excepción generada
	 */
	public int verPuntuacionJugador(PuntuacionVO puntuacion) throws SQLException{
		String consulta="";
		consulta="select puntos from comunio.puntuacion where idJugador=?";
		sentencia=conexion.prepareStatement(consulta);
		sentencia.setInt(1, puntuacion.getIdJugador());
		ResultSet rs = sentencia.executeQuery();
		int puntos = 0;
		while (rs.next()){
			puntos = rs.getInt("puntos");
		}
		return puntos;
	}
	
	/**
	 * Método que nos permite ver la puntuación de un jugador
	 * @param grupo Grupo a crear
	 * @throws SQLException Excepción generada
	 */
	public Collection verPuntuacionJornada(PuntuacionVO puntuacion) throws SQLException{
		String consulta="";
		consulta="select idJugador,puntos from comunio.puntuacion where jornada=?";
		sentencia=conexion.prepareStatement(consulta);
		sentencia.setInt(1, puntuacion.getJornada());
		ResultSet rs = sentencia.executeQuery();
		PuntuacionVO puntuacionVo = null;
		Collection coleccionPuntuacion = new ArrayList();
		while (rs.next()){
			puntuacionVo = new PuntuacionVO();
			puntuacionVo.setPuntos(rs.getInt("puntos"));
			puntuacionVo.setIdJugador(rs.getInt("idJugador"));
			coleccionPuntuacion.add(puntuacionVo);
		}
		return coleccionPuntuacion;
	}


}

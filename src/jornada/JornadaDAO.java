package jornada;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


public class JornadaDAO {

	
	private Connection conexion=null;;
	private PreparedStatement sentencia=null;
	
	public JornadaDAO(Connection conexion) {
		this.conexion=conexion;
	}
		
	public void cerrarConexion() throws SQLException {

			if (sentencia!=null) sentencia.close();
			if (conexion!=null)
				conexion.close();
		
	}
	
	/**
	 * Método que nos permite ver la jornada de una determinada fecha
	 * @param fecha Fecha por la que buscar
	 * @return jornada que devolveremos
	 * @throws SQLException Excepción generada
	 */
	public JornadaVO devolverJornadaPorFecha(Date fecha) throws SQLException{
		String consulta="";
		consulta="select jornada,descripcion from comunio.jornada where fecha=?";
		sentencia=conexion.prepareStatement(consulta);
		sentencia.setDate(1, fecha);
		ResultSet rs = sentencia.executeQuery();
		JornadaVO jornada = new JornadaVO();
		while (rs.next()){
			jornada.setDescripcion(rs.getString("descripcion"));
			jornada.setJornada(rs.getInt("jornada"));
		}
		
		return jornada;
	}
	
	/**
	 * Método que nos permite ver la jornada ordenada por jornada
	 * @return Colección de jornadas que devolveremos
	 * @throws SQLException Excepción generada
	 */
	public Collection devolverJornadas() throws SQLException{
		String consulta="";
		consulta="select jornada,descripcion,fecha from comunio.jornada order by jornada";
		sentencia=conexion.prepareStatement(consulta);
		ResultSet rs = sentencia.executeQuery();
		JornadaVO jornada =null;
		Collection coleccionJornadas = new ArrayList();
		while (rs.next()){
			jornada= new JornadaVO();
			jornada.setDescripcion(rs.getString("descripcion"));
			jornada.setJornada(rs.getInt("jornada"));
			jornada.setFecha(rs.getDate("fecha"));
			coleccionJornadas.add(jornada);
		}
		
		return coleccionJornadas;
	}

}

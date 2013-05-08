package tactica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TacticaDAO {

	private Connection conexion=null;;
	private PreparedStatement sentencia=null;
	
	public TacticaDAO(Connection conexion) {
		this.conexion=conexion;
	}
		
	public void cerrarConexion() throws SQLException {

			if (sentencia!=null) sentencia.close();
			if (conexion!=null)
				conexion.close();
		
	}
	
	/**
	 * Método que nos permite crear una táctica en base de datos
	 * @param tactica Táctica a crear
	 * @throws SQLException Excepción generada
	 */
	public void crearTactica(TacticaVO tactica) throws SQLException{
		String consulta="";
		consulta="insert into comunio.tactica(idTactica,descripcion) values(?,?)";
		sentencia=conexion.prepareStatement(consulta);
		sentencia.setString(1, tactica.getIdTactica());
		sentencia.setString(2, tactica.getDescripción());
		sentencia.executeUpdate();	
	}
	
	/**
	 * Método que nos permite devolver una táctica de base de datos
	 * @param idTactica Táctica a buscar
	 * @throws SQLException Excepción generada
	 */
	public TacticaVO devolverTactica(String idTactica) throws SQLException{
		String consulta="";
		consulta="select descripcion from comunio.tactica where idTactica=?";
		sentencia=conexion.prepareStatement(consulta);
		sentencia.setString(1, idTactica);
		ResultSet rs = sentencia.executeQuery();
		TacticaVO tactica = new TacticaVO();
		while (rs.next()){
			tactica.setDescripción(rs.getString("descripcion"));
		}
		
		return tactica;
	}
	

}

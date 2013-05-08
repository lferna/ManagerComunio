package grupo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class GrupoDAO {

	private Connection conexion=null;;
	private PreparedStatement sentencia=null;
	
	public GrupoDAO(Connection conexion) {
		this.conexion=conexion;
	}
		
	public void cerrarConexion() throws SQLException {

			if (sentencia!=null) sentencia.close();
			if (conexion!=null)
				conexion.close();
		
	}
	
	/**
	 * Método que nos permite crear un grupo en base de datos
	 * @param grupo Grupo a crear
	 * @throws SQLException Excepción generada
	 */
	public void crearGrupo(GrupoVO grupo) throws SQLException{
		String consulta="";
		consulta="insert into comunio.grupo(grupo,hash) values(?,?)";
		sentencia=conexion.prepareStatement(consulta);
		sentencia.setString(1, grupo.getGrupo());
		sentencia.setString(2, grupo.getHash());
		sentencia.executeUpdate();	
	}
	
	/**
	 * Método que nos permite listar los usuarios del grupo elegido.
	 * @param grupo Grupo a listar
	 * @return Colección de los usuarios
	 * @throws SQLException Excepción generada
	 */
	public Collection listarUsuarios(GrupoVO grupo) throws SQLException{
		String consulta="";
		consulta="select idUsuario from comunio.grupo where grupo=?";
		sentencia=conexion.prepareStatement(consulta);
		sentencia.setString(1, grupo.getGrupo());
		ResultSet rs = sentencia.executeQuery();
		String idUsuario = "";
		Collection tmpColeccionUsuarios = new ArrayList();
		while (rs.next()){
			idUsuario = rs.getString("idUsuario");
			tmpColeccionUsuarios.add(idUsuario);

		}
		
		return tmpColeccionUsuarios;
	}

	/**
	 * Método que nos permite eliminar un grupo en base de datos
	 * @param usuario Usuario a borrar
	 * @throws SQLException Excepción generada
	 */
	public void eliminarGrupo(GrupoVO grupo) throws SQLException{
		String consulta="";
		consulta="delete comunio.grupo(grupo,hash) values(?,?)";
		sentencia=conexion.prepareStatement(consulta);
		sentencia.setString(1, grupo.getGrupo());
		sentencia.setString(2, grupo.getHash());
		sentencia.executeUpdate();	
	}

}

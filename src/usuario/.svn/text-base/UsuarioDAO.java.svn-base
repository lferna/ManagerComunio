package usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
	
	private Connection conexion=null;;
	private PreparedStatement sentencia=null;
	
	public UsuarioDAO(Connection conexion) {
		this.conexion=conexion;
	}
		
	public void cerrarConexion() throws SQLException {

			if (sentencia!=null) sentencia.close();
			if (conexion!=null)
				conexion.close();
		
	}
	
	/**
	 * Método que nos permite crear un usuario en base de datos
	 * @param usuario Usuario a crear
	 * @throws SQLException Excepción generada
	 */
	public void crearUsuario(UsuarioVO usuario) throws SQLException{
		String consulta="";
		consulta="insert into comunio.usuario(idUsuario,hash,email) values(?,?,?)";
		sentencia=conexion.prepareStatement(consulta);
		sentencia.setString(1, usuario.getIdUsuario());
		sentencia.setString(2, usuario.getHash());
		sentencia.setString(3, usuario.getEmail());
		sentencia.executeUpdate();	
	}
	
	/**
	 * Método que nos permite asociar un usuario a un grupo
	 * @param usuario Usuario que vamos a asociar
	 * @throws SQLException Excepción generada
	 */
	public void asociarGrupo(UsuarioVO usuario) throws SQLException{
		String consulta="";
		consulta = "update comunio.usuario set grupo=? where idUsuario=?";
		sentencia=conexion.prepareStatement(consulta);
		sentencia.setString(1, usuario.getGrupo());
		sentencia.setString(2, usuario.getIdUsuario());
		sentencia.executeUpdate();	
	}

	/**
	 * Método que nos permite eliminar un usuario en base de datos
	 * @param usuario Usuario a borrar
	 * @throws SQLException Excepción generada
	 */
	public void eliminarUsuario(UsuarioVO usuario) throws SQLException{
		String consulta="";
		consulta="delete comunio.usuario(idUsuario) values(?)";
		sentencia=conexion.prepareStatement(consulta);
		sentencia.setString(1, usuario.getIdUsuario());
		sentencia.executeUpdate();	
	}

}

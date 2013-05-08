package equipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class EquipoDAO {
	
	private Connection conexion=null;;
	private PreparedStatement sentencia=null;
	
	public EquipoDAO(Connection conexion) {
		this.conexion=conexion;
	}
		
	public void cerrarConexion() throws SQLException {

			if (sentencia!=null) sentencia.close();
			if (conexion!=null)
				conexion.close();
		
	}
	
	/**
	 * Método para listar los equipos
	 * @return Colección con los equipos
	 * @throws SQLException
	 */
	public Collection listarEquipos() throws SQLException{
		String consulta="";
		consulta="select nombreCorto,nombre from comunio.equipo order by nombre";
		sentencia=conexion.prepareStatement(consulta);
		ResultSet rs = sentencia.executeQuery();
		EquipoVO equipoVo = null;
		Collection coleccionEquipos = new ArrayList();
		while (rs.next()){
			equipoVo = new EquipoVO();
			equipoVo.setNombre(rs.getString("nombre"));
			equipoVo.setNombreCorto(rs.getString("nombreCorto"));
			coleccionEquipos.add(equipoVo);
		}
		return coleccionEquipos;
	}

}

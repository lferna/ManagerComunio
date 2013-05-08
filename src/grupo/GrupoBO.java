package grupo;

import java.sql.SQLException;
import java.util.Collection;

import encrypt.EncryptMD5;
import exception.EncryptException;
import factory.DAOFactory;

public class GrupoBO {

	/**
	 * Método que se encarga de crear un grupo
	 * @param grupo Grupo que vamos a crear
	 * @throws ClassNotFoundException Excepción generada
	 * @throws SQLException Excepción generada
	 * @throws EncryptException Excepción generada
	 */
	public void crearGrupo(GrupoVO grupo) throws ClassNotFoundException, SQLException, EncryptException{
		DAOFactory daoFactory=new DAOFactory();
		GrupoDAO grupoDao=daoFactory.getGrupoDAO();
		
		//encriptamos la clave
		String hash = EncryptMD5.encriptar(grupo.getHash());
		grupo.setHash(hash);
		//fin de la encriptación
		
		grupoDao.crearGrupo(grupo);
		grupoDao.cerrarConexion();
	}
	
	/**
	 * Método que permite listar los usuarios del grupo
	 * @param grupo Grupo con los parámetros de búsqueda
	 * @return Colección con los usuarios
	 * @throws SQLException Excepción generada
	 * @throws ClassNotFoundException Excepción generada
	 */
	public Collection listarUsuarios(GrupoVO grupo) throws SQLException, ClassNotFoundException{
		
		DAOFactory daoFactory=new DAOFactory();
		GrupoDAO grupoDao=daoFactory.getGrupoDAO();
		
		Collection tmpColeccion = null;
		tmpColeccion = grupoDao.listarUsuarios(grupo);
		grupoDao.cerrarConexion();
		return tmpColeccion;
		
	}
	
	/**
	 * Método que se encarga de dar de baja un grupo
	 * @param grupo Grupo a eliminar
	 * @throws SQLException Excepción generada
	 * @throws ClassNotFoundException Excepción generada
	 */
	public void eliminarGrupo(GrupoVO grupo) throws SQLException, ClassNotFoundException{
		DAOFactory daoFactory=new DAOFactory();
		GrupoDAO grupoDao=daoFactory.getGrupoDAO();
		grupoDao.eliminarGrupo(grupo);
		grupoDao.cerrarConexion();
	}

}

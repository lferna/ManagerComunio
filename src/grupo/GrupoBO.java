package grupo;

import java.sql.SQLException;
import java.util.Collection;

import encrypt.EncryptMD5;
import exception.EncryptException;
import factory.DAOFactory;

public class GrupoBO {

	/**
	 * M�todo que se encarga de crear un grupo
	 * @param grupo Grupo que vamos a crear
	 * @throws ClassNotFoundException Excepci�n generada
	 * @throws SQLException Excepci�n generada
	 * @throws EncryptException Excepci�n generada
	 */
	public void crearGrupo(GrupoVO grupo) throws ClassNotFoundException, SQLException, EncryptException{
		DAOFactory daoFactory=new DAOFactory();
		GrupoDAO grupoDao=daoFactory.getGrupoDAO();
		
		//encriptamos la clave
		String hash = EncryptMD5.encriptar(grupo.getHash());
		grupo.setHash(hash);
		//fin de la encriptaci�n
		
		grupoDao.crearGrupo(grupo);
		grupoDao.cerrarConexion();
	}
	
	/**
	 * M�todo que permite listar los usuarios del grupo
	 * @param grupo Grupo con los par�metros de b�squeda
	 * @return Colecci�n con los usuarios
	 * @throws SQLException Excepci�n generada
	 * @throws ClassNotFoundException Excepci�n generada
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
	 * M�todo que se encarga de dar de baja un grupo
	 * @param grupo Grupo a eliminar
	 * @throws SQLException Excepci�n generada
	 * @throws ClassNotFoundException Excepci�n generada
	 */
	public void eliminarGrupo(GrupoVO grupo) throws SQLException, ClassNotFoundException{
		DAOFactory daoFactory=new DAOFactory();
		GrupoDAO grupoDao=daoFactory.getGrupoDAO();
		grupoDao.eliminarGrupo(grupo);
		grupoDao.cerrarConexion();
	}

}

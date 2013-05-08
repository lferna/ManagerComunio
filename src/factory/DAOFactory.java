package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jornada.JornadaDAO;
import puntuacion.PuntuacionDAO;
import tactica.TacticaDAO;
import usuario.UsuarioDAO;
import grupo.GrupoDAO;

public class DAOFactory {
	
	String driver="";
	String url="";
	String user="";
	String pwd="";
	
	public DAOFactory() throws ClassNotFoundException{
		
		driver = GestorDePropiedades.getParameter("DAOFactory.driver");
		url = GestorDePropiedades.getParameter("DAOFactory.url");
		user = GestorDePropiedades.getParameter("DAOFactory.user");
		pwd = GestorDePropiedades.getParameter("DAOFactory.pwd");
		Class.forName(driver);
		
	}
	
	public UsuarioDAO getUsuarioDAO() throws SQLException{
		return new UsuarioDAO(crearConexion());
	}
	
	public GrupoDAO getGrupoDAO() throws SQLException{
		return new GrupoDAO(crearConexion());
	}
	
	public TacticaDAO getTacticaDAO() throws SQLException{
		return new TacticaDAO(crearConexion());
	}
	
	public JornadaDAO getJornadaDAO() throws SQLException{
		return new JornadaDAO(crearConexion());
	}
	
	public PuntuacionDAO getPuntuacionDAO() throws SQLException{
		return new PuntuacionDAO(crearConexion());
	}
	
	private Connection crearConexion() throws SQLException{
		
		return DriverManager.getConnection(url,user,pwd);
		
	}

	
}

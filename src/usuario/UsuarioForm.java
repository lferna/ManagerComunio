package usuario;

import org.apache.struts.action.ActionForm;

public class UsuarioForm extends ActionForm {

	private String idUsuario;
	private String hash;
	private String email;
	
	public UsuarioForm(){
		idUsuario = "";
		hash = "";
		email = "";
	}
	
	public UsuarioForm(String idUsuario, String hash, String email){
		this.idUsuario = idUsuario;
		this.hash = hash;
		this.email = email;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}

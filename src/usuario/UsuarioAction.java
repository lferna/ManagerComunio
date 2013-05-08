package usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class UsuarioAction extends DispatchAction{

	/**
	 * Método para crear los usuarios, que únicamente llamara al BO
	 * @param mapping Mapping de la acción
	 * @param form Formulario de la acción 
	 * @param request Request
	 * @param response Response
	 * @return El ActionForward
	 * @throws Exception Excepción generada
	 */
	public ActionForward crearUsuario(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		UsuarioForm usuarioForm = (UsuarioForm)form;
		UsuarioVO usuarioVo = new UsuarioVO();
		//seteamos el VO
		usuarioVo.setIdUsuario(usuarioForm.getIdUsuario());
		usuarioVo.setHash(usuarioForm.getHash());
		usuarioVo.setEmail(usuarioForm.getEmail());
		//llamamos al BO
		UsuarioBO usuarioBo = new UsuarioBO();
		usuarioBo.crearUsuario(usuarioVo);
		
		return mapping.findForward("altaUsuario");
	}
	
	/**
	 * Método para eliminar un usuario
	 * @param mapping Mapping de la acción
	 * @param form Formulario de la acción 
	 * @param request Request
	 * @param response Response
	 * @return El ActionForward
	 * @throws Exception Excepción generada
	 */
	public ActionForward eliminarUsuario(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UsuarioForm usuarioForm = (UsuarioForm)form;
		UsuarioVO usuarioVo = new UsuarioVO();
		//seteamos el VO
		usuarioVo.setIdUsuario(usuarioForm.getIdUsuario());
		//llamamos al BO
		UsuarioBO usuarioBo = new UsuarioBO();
		usuarioBo.eliminarUsuario(usuarioVo);
		
		return mapping.findForward("bajaUsuario");
	}
	
	/**
	 * Método para asociar un usuario a un grupo
	 * @param mapping Mapping de la acción
	 * @param form Formulario de la acción 
	 * @param request Request
	 * @param response Response
	 * @return El ActionForward
	 * @throws Exception Excepción generada
	 */
	public ActionForward asociarGrupo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
	
	return mapping.findForward("asociarGrupo");
	}
}

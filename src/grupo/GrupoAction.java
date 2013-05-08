package grupo;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class GrupoAction extends DispatchAction {

	/**
	 * Método para crear los grupos, que únicamente llamara al BO
	 * @param mapping Mapping de la acción
	 * @param form Formulario de la acción 
	 * @param request Request
	 * @param response Response
	 * @return El ActionForward
	 * @throws Exception Excepción generada
	 */
	public ActionForward crearGrupo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		GrupoForm grupoForm = (GrupoForm)form;
		GrupoVO grupoVo = new GrupoVO();
		//seteamos el VO
		grupoVo.setGrupo(grupoForm.getGrupo());
		grupoVo.setHash(grupoForm.getHash());
		//llamamos al BO
		GrupoBO grupoBo = new GrupoBO();
		grupoBo.crearGrupo(grupoVo);
		
		return mapping.findForward("altaGrupo");
	}
	
	/**
	 * Método para listar los usuarios del grupo
	 * @param mapping Mapping de la acción
	 * @param form Formulario de la acción 
	 * @param request Request
	 * @param response Response
	 * @return El ActionForward
	 * @throws Exception Excepción generada
	 */
	public ActionForward listarUsuarios(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		GrupoForm grupoForm = (GrupoForm)form;
		GrupoVO grupoVo = new GrupoVO();
		//seteamos el VO
		grupoVo.setGrupo(grupoForm.getGrupo());
		//llamamos al BO
		GrupoBO grupoBo = new GrupoBO();
		Collection tmpColeccion = null;
		tmpColeccion = grupoBo.listarUsuarios(grupoVo);
		
		request.setAttribute("listadoUsuariosGrupo", tmpColeccion);
		
		return null;
	}
	
}

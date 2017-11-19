package com.farmacia.controller;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.farmacia.domain.Usuario;
import com.farmacia.form.UsuarioForm;
import com.farmacia.pojo.IFarmacia;
import com.farmacia.util.Constants;
import com.farmacia.util.RSA;
import com.ibatis.common.util.PaginatedList;



public class UsuarioAction extends ASpeedyAction {
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		if(request.getSession().getAttribute("REDUSR")!=null){
			return list(mapping, form, request, response);
		}else {
			return mapping.findForward("invalidsession");
		}
	}
	
	/**
	 * Metodo que permite obtener el listado
	 * 
	 * @param mapping    Es el path que se compara contra la URI solicitada de la
	 * solicitud entrante, y normalmente especifica el nombre totalmente cualificado
	 * de clase para la clase Action
	 * @param form    Bean que permite la interaccion con el formulario de entrada
	 * @param request    Request del servlet
	 * @param response    Response del servlet
	 * @exception java.lang.Exception
	 */
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Collection usuarios = iFarmacia.obtenerUsuarios();
		Iterator iterator = usuarios.iterator();
		while (iterator.hasNext()) {
			Usuario element = (Usuario) iterator.next();
			element.getApellido();
			
		}
		PaginatedList pList=(PaginatedList)usuarios;
		HttpSession session = request.getSession();
		session.setAttribute("USUARIOS", usuarios);
		session.setAttribute("stringpag",getStringPage(pList,"USUARIOS","usuarioForm","tolist"));
		return mapping.findForward("tolist");
	}
		/**
	 * Metodo que permite mostrar el popup para las referencias
	 * 
	 * @param mapping    Es el path que se compara contra la URI solicitada de la
	 * solicitud entrante, y normalmente especifica el nombre totalmente cualificado
	 * de clase para la clase Action
	 * @param form    Bean que permite la interaccion con el formulario de entrada
	 * @param request    Request del servlet
	 * @param response    Response del servlet
	 * @exception java.lang.Exception
	 */

	public ActionForward listPopup(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Collection usuarios = null;
		if(request.getParameter("perfil")!=null&&request.getParameter("perfil").equals("medico")){
			Usuario usuario = (Usuario) request.getSession().getAttribute("REDUSR");
			usuarios = iFarmacia.obtenerMedicos(usuario.getIdfarmacia().toString());
		}else {
			usuarios = iFarmacia.obtenerUsuarios();		
		}
		
		PaginatedList pList=(PaginatedList)usuarios;
		HttpSession session = request.getSession();
		session.setAttribute("USUARIOS", usuarios);
		session.setAttribute("stringpag",getStringPage(pList,"USUARIOS","usuarioForm","tolistpopup"));
		return mapping.findForward("tolistpopup");
	}	
	
		/**
	 * Metodo para mostrar la pagina para adicionar
	 * 
	 * @param mapping    Es el path que se compara contra la URI solicitada de la
	 * solicitud entrante, y normalmente especifica el nombre totalmente cualificado
	 * de clase para la clase Action
	 * @param form    Bean que permite la interaccion con el formulario de entrada
	 * @param request    Request del servlet
	 * @param response    Response del servlet
	 * @exception java.lang.Exception
	 */
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		UsuarioForm forma = (UsuarioForm) form;
		forma.clearStrings();
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Collection perfiles =iFarmacia.obtenerPerfils(Constants.SIN_PAGINAR);
		request.getSession().setAttribute("perfLista", perfiles);
		Collection farmacias =iFarmacia.obtenerFarmacias(Constants.SIN_PAGINAR);
		request.getSession().setAttribute("farmLista", farmacias);
		return mapping.findForward("toadd");
	}

	/**
	 * Metodo para salvar la informacion
	 * 
	 * @param mapping    Es el path que se compara contra la URI solicitada de la
	 * solicitud entrante, y normalmente especifica el nombre totalmente cualificado
	 * de clase para la clase Action
	 * @param form    Bean que permite la interaccion con el formulario de entrada
	 * @param request    Request del servlet
	 * @param response    Response del servlet
	 * @exception java.lang.Exception
	 */
	
	public ActionForward saveAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
	
			UsuarioForm forma = (UsuarioForm) form;
			ActionMessages errors = forma.validate(mapping, request);
			if (!errors.isEmpty()) {
			      saveErrors(request, errors);
			      return mapping.findForward("toadd");
			    }
			IServiceLocator locator = new ServiceLocator();
			IFarmacia iFarmacia = locator.getFarmacia();
			Usuario usuario = new Usuario();
			forma.setIdusuario("0");
			if(forma.getCedula().length()==0){
				forma.setCedula("0");
			}
			if(forma.getTelefono().length()==0){
				forma.setTelefono("0");
			}
			if(forma.getTelefono2().length()==0){
				forma.setTelefono2("0");
			}
			BeanUtils.copyProperties(usuario, forma);
			iFarmacia.insertarUsuario(usuario);
			request.setAttribute("mensaje", "mensaje.agregar.exito");
		
			return list(mapping, form, request, response);
	}
	
	/**
	 * Metodo para mostrar la pagina para editar registros
	 * 
	 * @param mapping    Es el path que se compara contra la URI solicitada de la
	 * solicitud entrante, y normalmente especifica el nombre totalmente cualificado
	 * de clase para la clase Action
	 * @param form    Bean que permite la interaccion con el formulario de entrada
	 * @param request    Request del servlet
	 * @param response    Response del servlet
	 * @exception java.lang.Exception
	 */
	
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Usuario buscar = new Usuario();
		
				buscar.setIdusuario(new java.math.BigDecimal(request.getParameter("idusuario")));
		
		Usuario usuario = iFarmacia.obtenerUsuarioPorId(buscar);
		
		UsuarioForm forma = (UsuarioForm) form;
		BeanUtils.copyProperties(forma,usuario);
		Collection perfiles =iFarmacia.obtenerPerfils(Constants.SIN_PAGINAR);
		request.getSession().setAttribute("perfLista", perfiles);
		Collection farmacias =iFarmacia.obtenerFarmacias(Constants.SIN_PAGINAR);
		request.getSession().setAttribute("farmLista", farmacias);
		
		return mapping.findForward("toedit");
	}
	
	/**
	 * Metodo para mostrar salvar la informacion cuando se edita
	 * 
	 * @param mapping    Es el path que se compara contra la URI solicitada de la
	 * solicitud entrante, y normalmente especifica el nombre totalmente cualificado
	 * de clase para la clase Action
	 * @param form    Bean que permite la interaccion con el formulario de entrada
	 * @param request    Request del servlet
	 * @param response    Response del servlet
	 * @exception java.lang.Exception
	 */
	
	public ActionForward saveEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
	
		UsuarioForm forma = (UsuarioForm) form;
		ActionMessages errors = forma.validate(mapping, request);
		if (!errors.isEmpty()) {
		      saveErrors(request, errors);
		      return mapping.findForward("toedit");
		    }
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		if(forma.getCedula().length()==0){
			forma.setCedula("0");
		}
		if(forma.getTelefono().length()==0){
			forma.setTelefono("0");
		}
		if(forma.getTelefono2().length()==0){
			forma.setTelefono2("0");
		}
		Usuario usuario = new Usuario();
				BeanUtils.copyProperties(usuario, forma);
		iFarmacia.actualizarUsuario(usuario);
		request.setAttribute("mensaje", "mensaje.editar.exito");
	
		return list(mapping, form, request, response);
	}
	
	/**
	 * Metodo para mostrar la informacion de un registro
	 * 
	 * @param mapping    Es el path que se compara contra la URI solicitada de la
	 * solicitud entrante, y normalmente especifica el nombre totalmente cualificado
	 * de clase para la clase Action
	 * @param form    Bean que permite la interaccion con el formulario de entrada
	 * @param request    Request del servlet
	 * @param response    Response del servlet
	 * @exception java.lang.Exception
	 */
	
	public ActionForward detail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Usuario buscar = new Usuario();
		
				buscar.setIdusuario(new java.math.BigDecimal(request.getParameter("idusuario")));
		
		Usuario usuario = iFarmacia.obtenerUsuarioPorId(buscar);
		
		UsuarioForm forma = (UsuarioForm) form;
		BeanUtils.copyProperties(forma,usuario);
		return mapping.findForward("todetail");
	}

	/**
	 * Metodo para mostrar la pagina para eliminar un registro
	 * 
	 * @param mapping    Es el path que se compara contra la URI solicitada de la
	 * solicitud entrante, y normalmente especifica el nombre totalmente cualificado
	 * de clase para la clase Action
	 * @param form    Bean que permite la interaccion con el formulario de entrada
	 * @param request    Request del servlet
	 * @param response    Response del servlet
	 * @exception java.lang.Exception
	 */
	
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Usuario buscar = new Usuario();
		
				buscar.setIdusuario(new java.math.BigDecimal(request.getParameter("idusuario")));
		
		Usuario usuario = iFarmacia.obtenerUsuarioPorId(buscar);
		
		UsuarioForm forma = (UsuarioForm) form;
		BeanUtils.copyProperties(forma,usuario);
		return mapping.findForward("todelete");
	}
	
	/**
	 * Metodo para mostrar eliminar un registro
	 * 
	 * @param mapping    Es el path que se compara contra la URI solicitada de la
	 * solicitud entrante, y normalmente especifica el nombre totalmente cualificado
	 * de clase para la clase Action
	 * @param form    Bean que permite la interaccion con el formulario de entrada
	 * @param request    Request del servlet
	 * @param response    Response del servlet
	 * @exception java.lang.Exception
	 */
	
	public ActionForward saveDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
	
		UsuarioForm forma = (UsuarioForm) form;
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Usuario usuario = new Usuario();
		BeanUtils.copyProperties(usuario, forma);
		iFarmacia.eliminarUsuario(usuario);
		request.setAttribute("mensaje", "mensaje.eliminar.exito");
	
		return list(mapping, form, request, response);
	}
	public ActionForward validar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
	
				
		
			UsuarioForm forma = (UsuarioForm) form;
			IServiceLocator locator = new ServiceLocator();
			IFarmacia iFarmacia = locator.getFarmacia();
			Usuario usuario = new Usuario();
			forma.iniciar();
			BeanUtils.copyProperties(usuario, forma);
			usuario = iFarmacia.validarUsuario(usuario);

			if(usuario!=null){
				System.out.println("Farm: "+usuario.getIdfarmacia()+" user: "+usuario.getIdfarmacia());
				Collection menus =	iFarmacia.obtenerMenuListByPerfil(usuario.getIdperfil());
				request.getSession().setAttribute("menusIni", menus);
				request.getSession().setAttribute("REDUSR", usuario);
				request.getSession().setAttribute("USRLGN", usuario.getDescripcion());
				return mapping.findForward("tomain");
			}else {
				request.setAttribute("userInvalid", "Usuario o clave incorrectos");
				return mapping.findForward("tointro");
			}
		
		
	}
	public ActionForward cerrar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
	
			request.getSession().removeAttribute("menusIni");
			request.getSession().removeAttribute("REDUSR");
			request.getSession().invalidate();
			return mapping.findForward("tointro");
			
		
		
	}
	
	public ActionForward toChangePassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Usuario buscar = (Usuario) request.getSession().getAttribute("REDUSR");
		Usuario usuario = iFarmacia.obtenerUsuarioPorId(buscar);
		RSA rsa2 = new RSA(new BigInteger("7"),new BigInteger("25073217964183"),new BigInteger("175512552247237")); 
		String descifrado1=null;
		if(usuario.getPassword().indexOf("?BI?")>0){
			descifrado1 = rsa2.desencriptar(usuario.getPassword().substring(0,usuario.getPassword().indexOf("?BI?")))+rsa2.desencriptar(usuario.getPassword().substring(usuario.getPassword().indexOf("?BI?")+4));
		}else{
			descifrado1 = rsa2.desencriptar(usuario.getPassword());	
		}
		usuario.setPasswordold(descifrado1);
		usuario.setPassword("");
		usuario.setPasswordconf("");
		UsuarioForm forma = (UsuarioForm) form;
		BeanUtils.copyProperties(forma,usuario);
		return mapping.findForward("tochange");
	}
	
	public ActionForward changePassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
	
		UsuarioForm forma = (UsuarioForm) form;
		
		ActionMessages errors = new ActionMessages();
		
		if(forma.getPassword().length()==0||!forma.getPassword().equals(forma.getPasswordconf())){
			errors.add("badpassword", new ActionMessage("errors.password",null));
		}
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return mapping.findForward("tochange");
	    }
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Usuario buscar = (Usuario) request.getSession().getAttribute("REDUSR");
		
		Usuario usuario = iFarmacia.obtenerUsuarioPorId(buscar);
		usuario.setPassword(forma.getPassword());		
		iFarmacia.actualizarUsuario(usuario);
		request.setAttribute("mensaje", "mensaje.editar.exito");
	
		return mapping.findForward("tochange");
	}
	
}

package com.farmacia.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.farmacia.domain.Clasificacion;
import com.farmacia.form.ClasificacionForm;
import com.farmacia.pojo.IFarmacia;
import com.farmacia.util.Constants;
import com.ibatis.common.util.PaginatedList;



public class ClasificacionAction extends ASpeedyAction {
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
		ClasificacionForm forma = (ClasificacionForm) form;
		Collection clasificacions  = null;
		if(forma.getNombre()!=null&&forma.getNombre().trim().length()>0){
			clasificacions = iFarmacia.obtenerClasificacionsByName(forma.getNombre());
		}else {
			clasificacions = iFarmacia.obtenerClasificacions(Constants.PAGINADOS);
		}
		
		PaginatedList pList=(PaginatedList)clasificacions;
		HttpSession session = request.getSession();
		session.setAttribute("LABORATORIOS", clasificacions);
		session.setAttribute("stringpag",getStringPage(pList,"LABORATORIOS","clasificacionForm","tolist"));
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
		ClasificacionForm forma = (ClasificacionForm) form;
		Collection clasificacions  = null;
		if(forma.getNombre()!=null&&forma.getNombre().trim().length()>0){
			clasificacions = iFarmacia.obtenerClasificacionsByName(forma.getNombre());
		}else {
			clasificacions = iFarmacia.obtenerClasificacions(Constants.PAGINADOS);
		}
		PaginatedList pList=(PaginatedList)clasificacions;
		HttpSession session = request.getSession();
		session.setAttribute("LABORATORIOS", clasificacions);
		session.setAttribute("stringpag",getStringPage(pList,"LABORATORIOS","clasificacionForm","tolistpopup"));
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
		ClasificacionForm forma = (ClasificacionForm) form;
		forma.clearStrings();
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
	
		ClasificacionForm forma = (ClasificacionForm) form;
		ActionMessages errors = forma.validate(mapping, request);
		if (!errors.isEmpty()) {
		      saveErrors(request, errors);
		      return mapping.findForward("toadd");
		    }
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Clasificacion clasificacion = new Clasificacion();
		forma.setIdclasificacion("0");
				BeanUtils.copyProperties(clasificacion, forma);
		iFarmacia.insertarClasificacion(clasificacion);
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
		Clasificacion buscar = new Clasificacion();
		
				buscar.setIdclasificacion(new java.math.BigDecimal(request.getParameter("idclasificacion")));
		
		Clasificacion clasificacion = iFarmacia.obtenerClasificacionPorId(buscar);
		
		ClasificacionForm forma = (ClasificacionForm) form;
		BeanUtils.copyProperties(forma,clasificacion);
		
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
	
		ClasificacionForm forma = (ClasificacionForm) form;
		ActionMessages errors = forma.validate(mapping, request);
		if (!errors.isEmpty()) {
		      saveErrors(request, errors);
		      return mapping.findForward("toedit");
		    }
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Clasificacion clasificacion = new Clasificacion();
				BeanUtils.copyProperties(clasificacion, forma);
		iFarmacia.actualizarClasificacion(clasificacion);
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
		Clasificacion buscar = new Clasificacion();
		
				buscar.setIdclasificacion(new java.math.BigDecimal(request.getParameter("idclasificacion")));
		
		Clasificacion clasificacion = iFarmacia.obtenerClasificacionPorId(buscar);
		
		ClasificacionForm forma = (ClasificacionForm) form;
		BeanUtils.copyProperties(forma,clasificacion);
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
		Clasificacion buscar = new Clasificacion();
		
				buscar.setIdclasificacion(new java.math.BigDecimal(request.getParameter("idclasificacion")));
		
		Clasificacion clasificacion = iFarmacia.obtenerClasificacionPorId(buscar);
		
		ClasificacionForm forma = (ClasificacionForm) form;
		BeanUtils.copyProperties(forma,clasificacion);
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
	
		ClasificacionForm forma = (ClasificacionForm) form;
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Clasificacion clasificacion = new Clasificacion();
		BeanUtils.copyProperties(clasificacion, forma);
		try {
			iFarmacia.eliminarClasificacion(clasificacion);
		} catch (Exception e) {
			
			if(e.getCause().toString().indexOf("foreign")>0){
				ActionMessages errors = new ActionMessages();
				errors.add("foreign", new ActionMessage("errors.foreign","Clasificacion"));
				if (!errors.isEmpty()) {
					saveErrors(request, errors);
					return list(mapping, form, request, response);
			    }
			}
		}
		
		request.setAttribute("mensaje", "mensaje.eliminar.exito");
	
		return list(mapping, form, request, response);
	}
	
	
}

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

import com.farmacia.domain.Laboratorio;
import com.farmacia.form.LaboratorioForm;
import com.farmacia.pojo.IFarmacia;
import com.farmacia.util.Constants;
import com.ibatis.common.util.PaginatedList;



public class LaboratorioAction extends ASpeedyAction {
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
		LaboratorioForm forma = (LaboratorioForm) form;
		Collection laboratorios  = null;
		if(forma.getNombre()!=null&&forma.getNombre().trim().length()>0){
			laboratorios = iFarmacia.obtenerLaboratoriosByName(forma.getNombre());
		}else {
			laboratorios = iFarmacia.obtenerLaboratorios(Constants.PAGINADOS);
		}
		
		PaginatedList pList=(PaginatedList)laboratorios;
		HttpSession session = request.getSession();
		session.setAttribute("LABORATORIOS", laboratorios);
		session.setAttribute("stringpag",getStringPage(pList,"LABORATORIOS","laboratorioForm","tolist"));
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
		LaboratorioForm forma = (LaboratorioForm) form;
		Collection laboratorios  = null;
		if(forma.getNombre()!=null&&forma.getNombre().trim().length()>0){
			laboratorios = iFarmacia.obtenerLaboratoriosByName(forma.getNombre());
		}else {
			laboratorios = iFarmacia.obtenerLaboratorios(Constants.PAGINADOS);
		}
		PaginatedList pList=(PaginatedList)laboratorios;
		HttpSession session = request.getSession();
		session.setAttribute("LABORATORIOS", laboratorios);
		session.setAttribute("stringpag",getStringPage(pList,"LABORATORIOS","laboratorioForm","tolistpopup"));
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
		LaboratorioForm forma = (LaboratorioForm) form;
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
	
		LaboratorioForm forma = (LaboratorioForm) form;
		ActionMessages errors = forma.validate(mapping, request);
		if (!errors.isEmpty()) {
		      saveErrors(request, errors);
		      return mapping.findForward("toadd");
		    }
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Laboratorio laboratorio = new Laboratorio();
		forma.setIdlaboratorio("0");
				BeanUtils.copyProperties(laboratorio, forma);
		iFarmacia.insertarLaboratorio(laboratorio);
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
		Laboratorio buscar = new Laboratorio();
		
				buscar.setIdlaboratorio(new java.math.BigDecimal(request.getParameter("idlaboratorio")));
		
		Laboratorio laboratorio = iFarmacia.obtenerLaboratorioPorId(buscar);
		
		LaboratorioForm forma = (LaboratorioForm) form;
		BeanUtils.copyProperties(forma,laboratorio);
		
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
	
		LaboratorioForm forma = (LaboratorioForm) form;
		ActionMessages errors = forma.validate(mapping, request);
		if (!errors.isEmpty()) {
		      saveErrors(request, errors);
		      return mapping.findForward("toedit");
		    }
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Laboratorio laboratorio = new Laboratorio();
				BeanUtils.copyProperties(laboratorio, forma);
		iFarmacia.actualizarLaboratorio(laboratorio);
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
		Laboratorio buscar = new Laboratorio();
		
				buscar.setIdlaboratorio(new java.math.BigDecimal(request.getParameter("idlaboratorio")));
		
		Laboratorio laboratorio = iFarmacia.obtenerLaboratorioPorId(buscar);
		
		LaboratorioForm forma = (LaboratorioForm) form;
		BeanUtils.copyProperties(forma,laboratorio);
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
		Laboratorio buscar = new Laboratorio();
		
				buscar.setIdlaboratorio(new java.math.BigDecimal(request.getParameter("idlaboratorio")));
		
		Laboratorio laboratorio = iFarmacia.obtenerLaboratorioPorId(buscar);
		
		LaboratorioForm forma = (LaboratorioForm) form;
		BeanUtils.copyProperties(forma,laboratorio);
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
	
		LaboratorioForm forma = (LaboratorioForm) form;
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Laboratorio laboratorio = new Laboratorio();
		BeanUtils.copyProperties(laboratorio, forma);
		try {
			iFarmacia.eliminarLaboratorio(laboratorio);
		} catch (Exception e) {
			
			if(e.getCause().toString().indexOf("foreign")>0){
				ActionMessages errors = new ActionMessages();
				errors.add("foreign", new ActionMessage("errors.foreign","Laboratorio"));
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

package com.farmacia.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.farmacia.domain.Detventa;
import com.farmacia.form.DetventaForm;
import com.farmacia.pojo.IFarmacia;
import com.ibatis.common.util.PaginatedList;



public class DetventaAction extends ASpeedyAction {
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
		Collection detventas = iFarmacia.obtenerDetventas();
		PaginatedList pList=(PaginatedList)detventas;
		HttpSession session = request.getSession();
		session.setAttribute("DETVENTAS", detventas);
		session.setAttribute("stringpag",getStringPage(pList,"DETVENTAS","detventaForm","tolist"));
		return mapping.findForward("tolist");
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
		DetventaForm forma = (DetventaForm) form;
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
	
		DetventaForm forma = (DetventaForm) form;
		ActionMessages errors = forma.validate(mapping, request);
		if (!errors.isEmpty()) {
		      saveErrors(request, errors);
		      return mapping.findForward("toadd");
		    }
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Detventa detventa = new Detventa();
							forma.setIdventa(request.getParameter("campoventa"));
					forma.setIdproducto(request.getParameter("campoproducto"));
					forma.setIddetventa("0");
							BeanUtils.copyProperties(detventa, forma);
		iFarmacia.insertarDetventa(detventa);
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
		Detventa buscar = new Detventa();
		
				buscar.setIddetventa(new java.math.BigDecimal(request.getParameter("iddetventa")));
		
		Detventa detventa = iFarmacia.obtenerDetventaPorId(buscar);
		
		DetventaForm forma = (DetventaForm) form;
		BeanUtils.copyProperties(forma,detventa);
		
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
	
		DetventaForm forma = (DetventaForm) form;
		ActionMessages errors = forma.validate(mapping, request);
		if (!errors.isEmpty()) {
		      saveErrors(request, errors);
		      return mapping.findForward("toedit");
		    }
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Detventa detventa = new Detventa();
							forma.setIdventa(request.getParameter("campoventa"));
					forma.setIdproducto(request.getParameter("campoproducto"));
							BeanUtils.copyProperties(detventa, forma);
		iFarmacia.actualizarDetventa(detventa);
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
		Detventa buscar = new Detventa();
		
				buscar.setIddetventa(new java.math.BigDecimal(request.getParameter("iddetventa")));
		
		Detventa detventa = iFarmacia.obtenerDetventaPorId(buscar);
		
		DetventaForm forma = (DetventaForm) form;
		BeanUtils.copyProperties(forma,detventa);
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
		Detventa buscar = new Detventa();
		
				buscar.setIddetventa(new java.math.BigDecimal(request.getParameter("iddetventa")));
		
		Detventa detventa = iFarmacia.obtenerDetventaPorId(buscar);
		
		DetventaForm forma = (DetventaForm) form;
		BeanUtils.copyProperties(forma,detventa);
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
	
		DetventaForm forma = (DetventaForm) form;
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Detventa detventa = new Detventa();
		BeanUtils.copyProperties(detventa, forma);
		iFarmacia.eliminarDetventa(detventa);
		request.setAttribute("mensaje", "mensaje.eliminar.exito");
	
		return list(mapping, form, request, response);
	}
	
	
}

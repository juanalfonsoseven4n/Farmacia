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

import com.farmacia.domain.Gasto;
import com.farmacia.domain.Usuario;
import com.farmacia.form.GastoForm;
import com.farmacia.pojo.IFarmacia;
import com.ibatis.common.util.PaginatedList;



public class GastoAction extends ASpeedyAction {
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
		GastoForm forma = (GastoForm) form;
		Collection gastos  = null;
		if( forma.getNombre()!=null&&forma.getNombre().trim().length()>0||
			forma.getUserdesc()!=null&&forma.getUserdesc().trim().length()>0){
			gastos = iFarmacia.obtenerGastosFiltro(forma);
		}else {
			gastos = iFarmacia.obtenerGastos();
		}
		 
		PaginatedList pList=(PaginatedList)gastos;
		HttpSession session = request.getSession();
		session.setAttribute("GASTOS", gastos);
		session.setAttribute("stringpag",getStringPage(pList,"GASTOS","gastoForm","tolist"));
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
		GastoForm forma = (GastoForm) form;
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
	
		GastoForm forma = (GastoForm) form;
		ActionMessages errors = forma.validate(mapping, request);
		if (!errors.isEmpty()) {
		      saveErrors(request, errors);
		      return mapping.findForward("toadd");
		    }
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Gasto gasto = new Gasto();
		if(request.getSession().getAttribute("REDUSR")!=null){
			Usuario usuario = (Usuario) request.getSession().getAttribute("REDUSR");
			forma.setIdfarmacia(usuario.getIdfarmacia().toString());
			forma.setIdusuario(usuario.getIdusuario().toString());
			forma.setIdgasto("0");
			BeanUtils.copyProperties(gasto, forma);
			iFarmacia.insertarGasto(gasto);
			request.setAttribute("mensaje", "mensaje.agregar.exito");
		}
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
		Gasto buscar = new Gasto();
		
				buscar.setIdgasto(new java.math.BigDecimal(request.getParameter("idgasto")));
		
		Gasto gasto = iFarmacia.obtenerGastoPorId(buscar);
		
		GastoForm forma = (GastoForm) form;
		BeanUtils.copyProperties(forma,gasto);
		
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
	
		GastoForm forma = (GastoForm) form;
		ActionMessages errors = forma.validate(mapping, request);
		if (!errors.isEmpty()) {
		      saveErrors(request, errors);
		      return mapping.findForward("toedit");
		    }
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Gasto gasto = new Gasto();
		if(request.getSession().getAttribute("REDUSR")!=null){
			Usuario usuario = (Usuario) request.getSession().getAttribute("REDUSR");
			forma.setIdfarmacia(usuario.getIdfarmacia().toString());
			forma.setIdusuario(usuario.getIdusuario().toString());
			BeanUtils.copyProperties(gasto, forma);
			iFarmacia.actualizarGasto(gasto);
			request.setAttribute("mensaje", "mensaje.editar.exito");
		}
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
		Gasto buscar = new Gasto();
		
				buscar.setIdgasto(new java.math.BigDecimal(request.getParameter("idgasto")));
		
		Gasto gasto = iFarmacia.obtenerGastoPorId(buscar);
		
		GastoForm forma = (GastoForm) form;
		BeanUtils.copyProperties(forma,gasto);
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
		Gasto buscar = new Gasto();
		
				buscar.setIdgasto(new java.math.BigDecimal(request.getParameter("idgasto")));
		
		Gasto gasto = iFarmacia.obtenerGastoPorId(buscar);
		
		GastoForm forma = (GastoForm) form;
		BeanUtils.copyProperties(forma,gasto);
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
	
		GastoForm forma = (GastoForm) form;
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Gasto gasto = new Gasto();
		BeanUtils.copyProperties(gasto, forma);
		iFarmacia.eliminarGasto(gasto);
		request.setAttribute("mensaje", "mensaje.eliminar.exito");
	
		return list(mapping, form, request, response);
	}
	
	
}

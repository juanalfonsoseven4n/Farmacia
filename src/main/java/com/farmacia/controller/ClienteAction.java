package com.farmacia.controller;

import java.math.BigDecimal;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.farmacia.domain.Cliente;
import com.farmacia.form.ClienteForm;
import com.farmacia.pojo.IFarmacia;
import com.farmacia.util.Constants;
import com.farmacia.util.Utilitario;
import com.ibatis.common.util.PaginatedList;



public class ClienteAction extends ASpeedyAction {
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		request.getSession().removeAttribute("clasLista");
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
		ClienteForm forma = (ClienteForm) form;
		Collection clientes = null;
		if((forma.getNombre()!=null&&forma.getNombre().trim().length()>0)||(forma.getIdclasificacion()!=null&&Integer.parseInt(forma.getIdclasificacion())>0)){
			Cliente buscar = new Cliente();
			buscar.setNombre(forma.getNombre());
			buscar.setIdclasificacion(new BigDecimal(forma.getIdclasificacion()));
			clientes = iFarmacia.obtenerClienteByName(buscar);
		}else {
			clientes = iFarmacia.obtenerClientes();
		}
		PaginatedList pList=(PaginatedList)clientes;
		HttpSession session = request.getSession();
		session.setAttribute("CLIENTES", clientes);
		session.setAttribute("stringpag",getStringPage(pList,"CLIENTES","clienteForm","tolist"));
		request.getSession().setAttribute("clasLista",iFarmacia.obtenerClasificacions(Constants.SIN_PAGINAR));
		
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
		ClienteForm forma = (ClienteForm) form;
		Collection clientes = null;
		if(forma.getNombre()!=null&&forma.getNombre().trim().length()>0){
			Cliente buscar = new Cliente();
			buscar.setNombre(forma.getNombre());
			clientes = iFarmacia.obtenerClienteByName(buscar);
		}else {
			clientes = iFarmacia.obtenerClientes();
		}
		PaginatedList pList=(PaginatedList)clientes;
		HttpSession session = request.getSession();
		session.setAttribute("CLIENTES", clientes);
		session.setAttribute("stringpag",getStringPage(pList,"CLIENTES","clienteForm","tolistpopup"));
		
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
		ClienteForm forma = (ClienteForm) form;
		forma.clearStrings();
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		request.getSession().setAttribute("clasLista",iFarmacia.obtenerClasificacions(Constants.SIN_PAGINAR));
		
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
	
		try {
		
			ClienteForm forma = (ClienteForm) form;
			ActionMessages errors = forma.validate(mapping, request);
			if (!errors.isEmpty()) {
			      saveErrors(request, errors);
			      return mapping.findForward("toadd");
			    }
			IServiceLocator locator = new ServiceLocator();
			IFarmacia iFarmacia = locator.getFarmacia();
			Cliente cliente = new Cliente();
			forma.setIdcliente("0");
			if(forma.getFechanac()!=null&&forma.getFechanac().trim().length()>0){
				forma.setFechanac(Utilitario.quitarFormato(forma.getFechanac()));
			}else {
				forma.setFechanac("0");
			}
			if(forma.getCedula()==null||forma.getCedula().trim().length()<=0){
				forma.setCedula("0");	
			}
					BeanUtils.copyProperties(cliente, forma);
			iFarmacia.insertarCliente(cliente);
			request.setAttribute("mensaje", "mensaje.agregar.exito");
			request.getSession().removeAttribute("clasLista");
		} catch (Exception e) {
			e.printStackTrace();
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
		Cliente buscar = new Cliente();
		
				buscar.setIdcliente(new java.math.BigDecimal(request.getParameter("idcliente")));
		
		Cliente cliente = iFarmacia.obtenerClientePorId(buscar);
		
		ClienteForm forma = (ClienteForm) form;
		BeanUtils.copyProperties(forma,cliente);
		
		request.getSession().setAttribute("clasLista",iFarmacia.obtenerClasificacions(Constants.SIN_PAGINAR));
		
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
	
		ClienteForm forma = (ClienteForm) form;
		ActionMessages errors = forma.validate(mapping, request);
		if (!errors.isEmpty()) {
		      saveErrors(request, errors);
		      return mapping.findForward("toedit");
		    }
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		if(forma.getFechanac()!=null&&forma.getFechanac().trim().length()>0){
			forma.setFechanac(Utilitario.quitarFormato(forma.getFechanac()));
		}else {
			forma.setFechanac("0");
		}
		if(forma.getCedula()==null||forma.getCedula().trim().length()<=0){
			forma.setCedula("0");	
		}
		Cliente cliente = new Cliente();
				BeanUtils.copyProperties(cliente, forma);
		iFarmacia.actualizarCliente(cliente);
		request.setAttribute("mensaje", "mensaje.editar.exito");
		request.getSession().removeAttribute("clasLista");
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
		Cliente buscar = new Cliente();
		
				buscar.setIdcliente(new java.math.BigDecimal(request.getParameter("idcliente")));
		
		Cliente cliente = iFarmacia.obtenerClientePorId(buscar);
		
		ClienteForm forma = (ClienteForm) form;
		BeanUtils.copyProperties(forma,cliente);
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
		Cliente buscar = new Cliente();
		
				buscar.setIdcliente(new java.math.BigDecimal(request.getParameter("idcliente")));
		
		Cliente cliente = iFarmacia.obtenerClientePorId(buscar);
		
		ClienteForm forma = (ClienteForm) form;
		BeanUtils.copyProperties(forma,cliente);
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
		try {
			
			ClienteForm forma = (ClienteForm) form;
			IServiceLocator locator = new ServiceLocator();
			IFarmacia iFarmacia = locator.getFarmacia();
			Cliente cliente = new Cliente();
			BeanUtils.copyProperties(cliente, forma);
			iFarmacia.eliminarCliente(cliente);
			request.setAttribute("mensaje", "mensaje.eliminar.exito");
		
		} catch (Exception e) {
			if(e.getCause().toString().indexOf("foreign")>0){
				System.out.println("Juank");
				request.setAttribute("mensaje", "errors.foreignerr");
			}
			
		}
		return list(mapping, form, request, response);
	}
	
	
}

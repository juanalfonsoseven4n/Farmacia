package com.farmacia.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.farmacia.domain.Detventa;
import com.farmacia.domain.Usuario;
import com.farmacia.domain.Venta;
import com.farmacia.form.VentaForm;
import com.farmacia.pojo.IFarmacia;
import com.farmacia.util.Constants;
import com.farmacia.util.Utilitario;
import com.ibatis.common.util.PaginatedList;



public class VentaAction extends ASpeedyAction {
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		if(request.getSession().getAttribute("RECVENTA")!=null){
			request.getSession().removeAttribute("RECVENTA");
		}
		if(request.getSession().getAttribute("REDUSR")!=null){
			Usuario usuario = (Usuario) request.getSession().getAttribute("REDUSR");
			if(!usuario.getIdperfil().equals(Constants.PERFIL_MEDICO)){
				return list(mapping, form, request, response);	
			}else {
				System.out.println("**********MEDICO***********");	
				return mapping.findForward("invalidsession");
			}
			
		}else {
			return mapping.findForward("invalidsession");
		}
	}
	
	public boolean revisaPerfil(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
	
		if(request.getSession().getAttribute("REDUSR")!=null){
			Usuario usuario = (Usuario) request.getSession().getAttribute("REDUSR");
			if(usuario.getIdperfil().equals(Constants.PERFIL_MEDICO)){
				System.out.println("**********MEDICO***********");	
				return true;
			}
			return false;
		}else {
			return true;
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
		
		try {
			if(revisaPerfil(mapping, form, request, response))
				return mapping.findForward("invalidsession");
			
			IServiceLocator locator = new ServiceLocator();
			IFarmacia iFarmacia = locator.getFarmacia();
			VentaForm forma = (VentaForm) form;
			Collection ventas = null;
			
			if ((forma.getUsuario() != null && forma.getUsuario().trim().length() > 0)
					|| (forma.getFechaini() != null && forma.getFechaini().trim().length() > 1 && forma.getFechafin() != null && forma.getFechafin().trim()
							.length() > 1)) {
				forma.setFechaini(Utilitario.quitarFormato(forma.getFechaini()));
				forma.setFechafin(Utilitario.quitarFormato(forma.getFechafin()));
				ventas = iFarmacia.obtenerVentasFiltradas(forma);
				forma.setTotalVentasConsulta(iFarmacia.obtenerVentasFiltradasSUM(forma));
			} else {
				ventas = iFarmacia.obtenerVentas();
				forma.setTotalVentasConsulta(iFarmacia.obtenerVentasSUM());
			}
			double totalVentas=0;
			Iterator iVentas = ventas.iterator();
			while (iVentas.hasNext()) {
				Venta venta = (Venta) iVentas.next();
				totalVentas+=venta.getValortotal().doubleValue();
			}
			forma.setTotalVentas(new BigDecimal(totalVentas));
			PaginatedList pList=(PaginatedList)ventas;
			HttpSession session = request.getSession();
			session.setAttribute("VENTAS", ventas);
			session.setAttribute("stringpag",getStringPage(pList,"VENTAS","ventaForm","tolist"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward("tolist");
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
	public ActionForward listFacturas(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		
		try {
			if(revisaPerfil(mapping, form, request, response))
				return mapping.findForward("invalidsession");
			
			IServiceLocator locator = new ServiceLocator();
			IFarmacia iFarmacia = locator.getFarmacia();
			VentaForm forma = (VentaForm) form;
			Collection ventas = null;
			
			if ((forma.getUsuario() != null && forma.getUsuario().trim().length() > 0)
					|| (forma.getFechaini() != null && forma.getFechaini().trim().length() > 1 && forma.getFechafin() != null && forma.getFechafin().trim()
							.length() > 1)) {
				forma.setFechaini(Utilitario.quitarFormato(forma.getFechaini()));
				forma.setFechafin(Utilitario.quitarFormato(forma.getFechafin()));
				ventas = iFarmacia.obtenerVentasFiltradas(forma);
				forma.setTotalVentasConsulta(iFarmacia.obtenerVentasFiltradasSUM(forma));
			} else {
				ventas = iFarmacia.obtenerVentas();
				forma.setTotalVentasConsulta(iFarmacia.obtenerVentasSUM());
			}
			double totalVentas=0;
			Iterator iVentas = ventas.iterator();
			while (iVentas.hasNext()) {
				Venta venta = (Venta) iVentas.next();
				totalVentas+=venta.getValortotal().doubleValue();
			}
			forma.setTotalVentas(new BigDecimal(totalVentas));
			PaginatedList pList=(PaginatedList)ventas;
			HttpSession session = request.getSession();
			session.setAttribute("VENTAS", ventas);
			session.setAttribute("stringpag",getStringPage(pList,"VENTAS","ventaForm","tolistFacturas"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward("tolistFacturas");
	}
	
	
	public ActionForward listConsulta(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		
		try {
			if(revisaPerfil(mapping, form, request, response))
				return mapping.findForward("invalidsession");
			
			IServiceLocator locator = new ServiceLocator();
			IFarmacia iFarmacia = locator.getFarmacia();
			VentaForm forma = (VentaForm) form;
			Collection ventas = null;
			
			if ((forma.getCliente() != null && forma.getCliente().trim().length() > 0)
					|| (forma.getDescproducto() != null && forma.getDescproducto().trim().length()>0)
					|| (forma.getIdclasificacion() != null && !forma.getIdclasificacion().equals("0"))) {
				
				ventas = iFarmacia.obtenerVentasConsulta(forma);
				
			} else {
				ventas = new ArrayList();
				
			}
			double totalVentas=0;
			Iterator iVentas = ventas.iterator();
			while (iVentas.hasNext()) {
				Venta venta = (Venta) iVentas.next();
				totalVentas+=venta.getValortotal().doubleValue();
			}
			forma.setTotalVentas(new BigDecimal(totalVentas));

			HttpSession session = request.getSession();
			session.setAttribute("VENTAS", ventas);
			session.setAttribute("clasLista",iFarmacia.obtenerClasificacions(Constants.SIN_PAGINAR));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward("tolistConsulta");
	}
	
	public ActionForward listVentas(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		VentaForm forma = (VentaForm) form;
		Collection ventas = null;
		try {
			
		
		if ((forma.getUsuario() != null && forma.getUsuario().trim().length() > 0)
				|| (forma.getFechaini() != null && forma.getFechaini().trim().length() > 1 && forma.getFechafin() != null && forma.getFechafin().trim()
						.length() > 1)||(forma.getDescproducto() != null && forma.getDescproducto().trim().length()>0)) {
			forma.setFechaini(Utilitario.quitarFormato(forma.getFechaini()));
			forma.setFechafin(Utilitario.quitarFormato(forma.getFechafin()));
			ventas = iFarmacia.obtenerVentasMarkedFiltradas(forma);
		} else {
			ventas = iFarmacia.obtenerVentasMarked();
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		PaginatedList pList=(PaginatedList)ventas;
		HttpSession session = request.getSession();
		session.setAttribute("VENTASLIST", ventas);
		session.setAttribute("stringpag",getStringPage(pList,"VENTASLIST","ventaForm","tolistVentas"));
		return mapping.findForward("tolistVentas");
	}
	public ActionForward listVentasProd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		
		try {
			
			IServiceLocator locator = new ServiceLocator();
			IFarmacia iFarmacia = locator.getFarmacia();
			VentaForm forma = (VentaForm) form;
			Collection ventas = null;
	
			if ((forma.getIdlaboratorio() != null && forma.getIdlaboratorio().trim().length() > 0)
					|| (forma.getFechaini() != null && forma.getFechaini().trim().length() > 1 
							&& forma.getFechafin() != null && forma.getFechafin().trim().length() > 1)
					||(forma.getDescproducto() != null && forma.getDescproducto().trim().length()>0)) {
				forma.setFechaini(Utilitario.quitarFormato(forma.getFechaini()));
				forma.setFechafin(Utilitario.quitarFormato(forma.getFechafin()));
				ventas = iFarmacia.obtenerVentasProdMarked(forma);
			}
			if(ventas != null){
				PaginatedList pList=(PaginatedList)ventas;
				HttpSession session = request.getSession();
				session.setAttribute("VENTASLISTPROD", ventas);
				session.setAttribute("stringpag",getStringPage(pList,"VENTASLISTPROD","ventaForm","tolistVentasProd"));
			}
			
			request.getSession().setAttribute("labLista",iFarmacia.obtenerLaboratorios(Constants.SIN_PAGINAR));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward("tolistVentasProd");
	}
	
	public ActionForward preventas(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		
		try {
			
			IServiceLocator locator = new ServiceLocator();
			IFarmacia iFarmacia = locator.getFarmacia();
			VentaForm forma = (VentaForm) form;
			Collection ventas = null;
	
			if ((forma.getIdlaboratorio() != null && forma.getIdlaboratorio().trim().length() > 0)
					|| (forma.getFechaini() != null && forma.getFechaini().trim().length() > 1 
							&& forma.getFechafin() != null && forma.getFechafin().trim().length() > 1)
					||(forma.getDescproducto() != null && forma.getDescproducto().trim().length()>0)) {
				forma.setFechaini(Utilitario.quitarFormato(forma.getFechaini()));
				forma.setFechafin(Utilitario.quitarFormato(forma.getFechafin()));
				ventas = iFarmacia.obtenerPreventas(forma);
			}
			if(ventas != null){
				PaginatedList pList=(PaginatedList)ventas;
				HttpSession session = request.getSession();
				session.setAttribute("PREVENTAS", ventas);
				session.setAttribute("stringpag",getStringPage(pList,"PREVENTAS","ventaForm","toPreventas"));
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward("toPreventas");
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
		if(revisaPerfil(mapping, form, request, response))
			return mapping.findForward("invalidsession");
		
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Collection ventas = iFarmacia.obtenerVentas();
		PaginatedList pList=(PaginatedList)ventas;
		HttpSession session = request.getSession();
		session.setAttribute("VENTAS", ventas);
		session.setAttribute("stringpag",getStringPage(pList,"VENTAS","ventaForm","tolistpopup"));
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
		VentaForm forma = (VentaForm) form;
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
	
		VentaForm forma = (VentaForm) form;
		ActionMessages errors = forma.validate(mapping, request);
		if (!errors.isEmpty()) {
		      saveErrors(request, errors);
		      return mapping.findForward("toadd");
		    }
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Venta venta = new Venta();
		forma.setIdfarmacia(request.getParameter("campofarmacia"));
		forma.setIdcliente(request.getParameter("campocliente"));
		forma.setIdmedico(request.getParameter("campousuario"));
		forma.setIdusuario(request.getParameter("campousuario"));
		forma.setIdventa("0");
		BeanUtils.copyProperties(venta, forma);
		iFarmacia.insertarVenta(venta);
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
		Venta buscar = new Venta();
		
				buscar.setIdventa(new java.math.BigDecimal(request.getParameter("idventa")));
		
		Venta venta = iFarmacia.obtenerVentaPorId(buscar);
		
		VentaForm forma = (VentaForm) form;
		BeanUtils.copyProperties(forma,venta);
		
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
	
		VentaForm forma = (VentaForm) form;
		ActionMessages errors = forma.validate(mapping, request);
		if (!errors.isEmpty()) {
		      saveErrors(request, errors);
		      return mapping.findForward("toedit");
		    }
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Venta venta = new Venta();
		forma.setIdfarmacia(request.getParameter("campofarmacia"));
		forma.setIdcliente(request.getParameter("campocliente"));
		forma.setIdmedico(request.getParameter("campousuario"));
		forma.setIdusuario(request.getParameter("campousuario"));
		BeanUtils.copyProperties(venta, forma);
		iFarmacia.actualizarVenta(venta);
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
		
		if(revisaPerfil(mapping, form, request, response))
			return mapping.findForward("invalidsession");
		request.getSession().removeAttribute("detailFactura");
		detailVentaLogic( mapping, form, request, response);
		
		return mapping.findForward("todetail");
	}
	
	public ActionForward detailFactura(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		
		if(revisaPerfil(mapping, form, request, response))
			return mapping.findForward("invalidsession");
		request.getSession().removeAttribute("detailFactura");
		detailVentaLogic( mapping, form, request, response);
		request.getSession().setAttribute("detailFactura", true);
		return mapping.findForward("todetail");
	}
	
	private void detailVentaLogic(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		
		
		
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Venta buscar = new Venta();
		
		buscar.setIdventa(new java.math.BigDecimal(request.getParameter("idventa")));
		
		Venta venta = iFarmacia.obtenerVentaPorId(buscar);
		
		VentaForm forma = (VentaForm) form;
		BeanUtils.copyProperties(forma,venta);
		forma.setVendedor(venta.getVendedor());
		forma.setMedico(venta.getMedico());
		forma.setCliente(venta.getCliente());
		System.out.println("Venta :"+venta.getCodigo() +" Ventaf :"+forma.getCodigo());
		System.out.println("getValortotal :"+venta.getValortotal());
		request.getSession().setAttribute("DETVENTAS", venta.getDetalles());

	}
	
	public ActionForward detailConsulta(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		
		if(revisaPerfil(mapping, form, request, response))
			return mapping.findForward("invalidsession");
		
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Venta buscar = new Venta();
		
		buscar.setIdventa(new java.math.BigDecimal(request.getParameter("idventa")));
		
		Venta venta = iFarmacia.obtenerVentaPorId(buscar);
		
		VentaForm forma = (VentaForm) form;
		String nombreCliente =forma.getCliente();
		BeanUtils.copyProperties(forma,venta);
		
		forma.setVendedor(venta.getVendedor());
		forma.setMedico(venta.getMedico());
		forma.setMarca((venta.getCliente().getNombre()!=null?venta.getCliente().getNombre():"")+" "+(venta.getCliente().getApellido()!=null?venta.getCliente().getApellido():""));
		forma.setDesccliente(venta.getCliente().getClasdesc());
		forma.setCliente(nombreCliente);
		System.out.println("Venta :"+venta.getCodigo() +" Ventaf :"+forma.getCodigo());
		System.out.println("getValortotal :"+venta.getValortotal());
		request.getSession().setAttribute("DETVENTAS", venta.getDetalles());
		return mapping.findForward("todetailConsulta");
	}

	
	public ActionForward detailVenta(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Venta buscar = new Venta();
		
				buscar.setIdventa(new java.math.BigDecimal(request.getParameter("idventa")));
		
		Venta venta = iFarmacia.obtenerVentaPorIdMarked(buscar);
		
		VentaForm forma = (VentaForm) form;
		BeanUtils.copyProperties(forma,venta);
		forma.setVendedor(venta.getVendedor());
		forma.setMedico(venta.getMedico());
		forma.setCliente(venta.getCliente());
		
		request.getSession().setAttribute("DETVENTASLIST", venta.getDetalles());
		return mapping.findForward("todetailVenta");
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
		Venta buscar = new Venta();
		
				buscar.setIdventa(new java.math.BigDecimal(request.getParameter("idventa")));
		
		Venta venta = iFarmacia.obtenerVentaPorId(buscar);
		
		VentaForm forma = (VentaForm) form;
		BeanUtils.copyProperties(forma,venta);
		forma.setVendedor(venta.getVendedor());
		forma.setMedico(venta.getMedico());
		forma.setCliente(venta.getCliente());
		request.getSession().setAttribute("DETVENTAS", venta.getDetalles());
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
	
		VentaForm forma = (VentaForm) form;
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Venta venta = new Venta();
		venta.setIdventa(new BigDecimal(forma.getIdventa()));
		iFarmacia.eliminarVenta(venta);
		request.setAttribute("mensaje", "mensaje.eliminar.exito");
	
		return list(mapping, form, request, response);
	}
	
	public ActionForward registrar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
	
		request.getSession().removeAttribute("RECVENTA");
		
		VentaForm forma = (VentaForm) form;
		forma.clearStrings();
		Usuario usuario = (Usuario)request.getSession().getAttribute("REDUSR");
		forma.setIdfarmacia(""+usuario.getIdfarmacia());
		forma.setIdusuario(""+usuario.getIdusuario());
		forma.setFecha(Utilitario.formatoDate(Utilitario.obtenerFechaSistema()));
		forma.setHora(Utilitario.obtenerHoraSistema());
		forma.setValortotal("0");
		forma.setIva("0");
		forma.setCantidad("0");
		forma.setValorunit("0");
		forma.setValor("0");
		forma.setDias("0");
		request.getSession().removeAttribute("DETVENTAS");
		LinkedList detalles = new LinkedList();
		request.getSession().setAttribute("DETVENTAS", detalles);
		return mapping.findForward("toregistrar");
	}
	
	public ActionForward agregarDet(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		try {
			
			System.out.println("agregarDet");
			VentaForm forma = (VentaForm) form;
			ActionMessages errors = forma.validate(mapping, request);
			if (!errors.isEmpty()) {
				  saveErrors(request, errors);
			      return mapping.findForward("toregistrar");
			    }
			Detventa detventa = new Detventa();
			detventa.setCantidad(new BigDecimal(forma.getCantidad()));
			detventa.setValor(new BigDecimal(forma.getValor()));
			detventa.setIva(new BigDecimal(forma.getIvadet()));
			detventa.setIdproducto(new BigDecimal(forma.getIdproducto()));
			detventa.setPresentacion(new BigDecimal(forma.getPresentacion()));
			if(forma.getPresentacion().equals("1")){
				detventa.setValorunit(new BigDecimal(forma.getValorunit()));
			}else if (forma.getPresentacion().equals("2")) {
				detventa.setValorunit(new BigDecimal(forma.getValorunitsobre()));
			}
			detventa.setNombreProducto(request.getParameter("descproducto"));
			if(Integer.parseInt(forma.getDias())>0){
				
				SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
				Calendar calendario = Calendar.getInstance();
				detventa.setDias(new BigDecimal(Utilitario.sumarFechas(formato.format(calendario.getTime()),Integer.parseInt(forma.getDias()))));	
			}else {
				detventa.setDias(new BigDecimal(0));
			}
			
			LinkedList detalles = (LinkedList) request.getSession().getAttribute("DETVENTAS");
			detalles.add(detventa);
			double valorTot=0;
			double iva = 0;
			Iterator iDetalles = detalles.iterator();
			while (iDetalles.hasNext()) {
				Detventa element = (Detventa) iDetalles.next();
				valorTot=valorTot+element.getValor().doubleValue();
				iva = iva+(element.getValor().doubleValue()*element.getIva().doubleValue())/100;
			}
			
			DecimalFormatSymbols dfs = new DecimalFormatSymbols();
			dfs.setDecimalSeparator('.');
			dfs.setGroupingSeparator(',');
			DecimalFormat format = new DecimalFormat("#0.00");
			format.setDecimalFormatSymbols(dfs);
			forma.setValortotal(format.format(valorTot));
			forma.setIva(format.format(iva));
			forma.setCantidad("0");
			forma.setValorunit("0");
			forma.setValorunitsobre("0");
			forma.setValor("0");
			forma.setDias("0");
			System.out.println("agregarDetEnd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward("toregistrar");
	}
	
	public ActionForward borrarDet(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		
		VentaForm forma = (VentaForm) form;
		forma.setCantidad("0");
		forma.setValorunit("0");
		forma.setValorunitsobre("0");
		forma.setValor("0");
		LinkedList detalles = (LinkedList) request.getSession().getAttribute("DETVENTAS");
		int index = Integer.parseInt(request.getParameter("regdel"));
		detalles.remove(index);
		return mapping.findForward("toregistrar");
		
	}
	
	public ActionForward registrarVenta(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
	
		ActionMessages errors = new ActionMessages();
		LinkedList detalles = (LinkedList) request.getSession().getAttribute("DETVENTAS");
		if(detalles==null||detalles.size()==0){
			errors.add("emptyList", new ActionMessage("errors.nodetalles",null));
		}
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return mapping.findForward("toregistrar");
	    }
		VentaForm forma = (VentaForm) form;
		
		Venta venta = new Venta();
		venta.setFecha(new BigDecimal(Utilitario.quitarFormato(forma.getFecha())));
		venta.setHora(new BigDecimal(Utilitario.quitarFormatoHora(forma.getHora())));
		venta.setIdusuario(new BigDecimal(forma.getIdusuario()));
		if(forma.getIdcliente().trim().length()>0){
			venta.setIdcliente(new BigDecimal(forma.getIdcliente()));
		}
		if(forma.getIdmedico().trim().length()>0){
			venta.setIdmedico(new BigDecimal(forma.getIdmedico()));
		}
		venta.setIdfarmacia(new BigDecimal(forma.getIdfarmacia()));
		venta.setValortotal(new BigDecimal(forma.getValortotal()));
		venta.setIva(new BigDecimal(forma.getIva()));
		venta.setMarca1(forma.isMarca1());		
	
		for (int i = 0; i < detalles.size(); i++) {
			Detventa detventa = (Detventa) detalles.get(i);
			String checked=request.getParameter("detventa["+i+"].marca");
			if(checked!=null&&checked.trim().length()>0){
				detventa.setMarca(new BigDecimal(checked));
			}else {
				detventa.setMarca(new BigDecimal("0"));
			}
		}
		
		venta.setDetalles(detalles);
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		venta =iFarmacia.insertarVenta(venta);
		request.getSession().setAttribute("RECVENTA", venta);
		
		forma.clearStrings();
		Usuario usuario = (Usuario)request.getSession().getAttribute("REDUSR");
		forma.setIdfarmacia(""+usuario.getIdfarmacia());
		forma.setIdusuario(""+usuario.getIdusuario());
		forma.setFecha(Utilitario.formatoDate(Utilitario.obtenerFechaSistema()));
		forma.setHora(Utilitario.obtenerHoraSistema());
		forma.setValortotal("0");
		forma.setIva("0");
		forma.setCantidad("0");
		forma.setValorunit("0");
		forma.setValor("0");
		forma.setMarca1(false);
		request.getSession().removeAttribute("DETVENTAS");
		detalles = new LinkedList();
		request.getSession().setAttribute("DETVENTAS", detalles);
		return mapping.findForward("toregistrar");
	}
	
}

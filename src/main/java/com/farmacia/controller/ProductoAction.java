package com.farmacia.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.farmacia.domain.Familia;
import com.farmacia.domain.Producto;
import com.farmacia.domain.Proveedor;
import com.farmacia.domain.Provprod;
import com.farmacia.form.MovimientoForm;
import com.farmacia.form.ProductoForm;
import com.farmacia.pojo.IFarmacia;
import com.farmacia.util.Constants;
import com.farmacia.util.PatternValidation;
import com.ibatis.common.util.PaginatedList;



public class ProductoAction extends ASpeedyAction {
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		if(request.getSession().getAttribute("REDUSR")!=null){
			request.getSession().removeAttribute("labLista");
			request.getSession().removeAttribute("catLista");
			request.getSession().removeAttribute("provLista");
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
		ProductoForm forma = (ProductoForm) form;
		Collection productos  = null;
		if(forma.getNombre()!=null&&forma.getNombre().trim().length()>0){
			productos = iFarmacia.obtenerProductosByName(forma.getNombre());
		}else {
			productos = iFarmacia.obtenerProductos();
		}
		PaginatedList pList=(PaginatedList)productos;
		HttpSession session = request.getSession();
		session.setAttribute("PRODUCTOS", productos);
		session.setAttribute("stringpag",getStringPage(pList,"PRODUCTOS","productoForm","tolist"));
		request.getSession().removeAttribute("provprodLista");
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
		ProductoForm forma = (ProductoForm) form;
		if(request.getParameter("barcode")!=null){
			forma.setBarcode(request.getParameter("barcode"));
		}
		Collection productos  = null;
		if(forma.getNombre()!=null&&forma.getNombre().trim().length()>0){
			productos = iFarmacia.obtenerProductosByName(forma.getNombre());
		}else {
			productos = iFarmacia.obtenerProductos();
		}
		PaginatedList pList=(PaginatedList)productos;
		HttpSession session = request.getSession();
		session.setAttribute("PRODUCTOS", productos);
		String forward= "tolistpopup";
		if(request.getParameter("venta")!=null){
			forward= "tolistpopupv";
		}
		session.setAttribute("stringpag",getStringPage(pList,"PRODUCTOS","productoForm",forward));
		return mapping.findForward(forward);
	}	
	
	public ActionForward listPopupBarcode(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		ProductoForm forma = (ProductoForm) form;
		Collection productos  = null;
		System.out.println("listPopupBarcode "+forma.getBarcode());
		if(forma.getBarcode()!=null&&forma.getBarcode().trim().length()>0){
			productos = iFarmacia.obtenerProductosByBarcode(forma.getBarcode());
		}else if(forma.getNombre()!=null&&forma.getNombre().trim().length()>0){
			productos = iFarmacia.obtenerProductosByName(forma.getNombre());
		}else {
			productos = iFarmacia.obtenerProductos();
		}
		PaginatedList pList=(PaginatedList)productos;
		HttpSession session = request.getSession();
		session.setAttribute("PRODUCTOS", productos);
		String forward= "tolistpopup";
		if(request.getParameter("venta")!=null){
			forward= "tolistpopupv";
		}
		session.setAttribute("stringpag",getStringPage(pList,"PRODUCTOS","productoForm",forward));
		return mapping.findForward(forward);
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
		ProductoForm forma = (ProductoForm) form;
		forma.clearStrings();
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		request.getSession().setAttribute("labLista",iFarmacia.obtenerLaboratorios(Constants.SIN_PAGINAR));
		request.getSession().setAttribute("catLista",iFarmacia.obtenerCategorias(Constants.SIN_PAGINAR));
		request.getSession().setAttribute("provLista",iFarmacia.obtenerProveedors(Constants.SIN_PAGINAR));
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
	
		ProductoForm forma = (ProductoForm) form;
		ActionMessages errors = forma.validate(mapping, request);
		if (!errors.isEmpty()) {
	      saveErrors(request, errors);
	      return mapping.findForward("toadd");
	    }
		try {
			
			IServiceLocator locator = new ServiceLocator();
			IFarmacia iFarmacia = locator.getFarmacia();
			Producto producto = new Producto();
				//	forma.setIdproveedor(request.getParameter("campoproveedor"));
			forma.setIdfamilia(request.getParameter("campofamilia"));
			forma.setIdproducto("0");
			
			if(forma.getCaja()==null||forma.getCaja().trim().length()<=0){
				forma.setCaja("0");	
			}
			if(forma.getSobre()==null||forma.getSobre().trim().length()<=0){
				forma.setSobre("0");	
			}
			BeanUtils.copyProperties(producto, forma);
			List provprods= (List) request.getSession().getAttribute("provprodLista");
			producto.setProvprods(provprods);
			iFarmacia.insertarProducto(producto);
			request.setAttribute("mensaje", "mensaje.agregar.exito");
			request.getSession().removeAttribute("labLista");
			request.getSession().removeAttribute("catLista");
			request.getSession().removeAttribute("provLista");	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list(mapping, form, request, response);
	}
	public ActionForward agregaProvProd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
	
		String next = request.getParameter("pageSource");
		
		ProductoForm forma = (ProductoForm) form;
		List provprods = new ArrayList();
		if(request.getSession().getAttribute("provprodLista")!=null){
			provprods= (List) request.getSession().getAttribute("provprodLista");
		}

		Provprod provprod = new Provprod();
		if(forma.getIdproducto()!=null&&!forma.getIdproducto().equals("")){
			provprod.setIdproducto(new BigDecimal(forma.getIdproducto()));
		}else {
			provprod.setIdproducto(new BigDecimal("0"));
		}
		ActionMessages errors = new ActionMessages();
		if(forma.getValorprovprod().trim().length()==0||!PatternValidation.validarNumerico(forma.getValorprovprod())){
			errors.add("valorprovprod", new ActionMessage("errors.invalid","Valor por Distribuidor"));
		}
		provprod.setIdproveedor(new BigDecimal(forma.getIdproveedor()));
		Iterator iProvprods = provprods.iterator();
		while (iProvprods.hasNext()) {
			Provprod element = (Provprod) iProvprods.next();
			if(element.getIdproveedor().equals(provprod.getIdproveedor())){
				errors.add("distribuidor", new ActionMessage("errors.distribuidor"));
			}
		}
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return mapping.findForward(next);
	    }
		provprod.setValor(new BigDecimal(forma.getValorprovprod()));
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		
		Proveedor buscar = new Proveedor();  
		buscar.setIdproveedor(provprod.getIdproveedor());
		Proveedor proveedor = 	iFarmacia.obtenerProveedorPorId(buscar);
		provprod.setProvdesc(proveedor.getNombre());
		provprods.add(provprod);
		request.getSession().setAttribute("provprodLista",provprods);
		forma.setValorprovprod("0");
		forma.setIdproveedor("0");
		return mapping.findForward(next);
	}
	
	public ActionForward borraProvProd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,	HttpServletResponse response)
			throws java.lang.Exception {
		String next = request.getParameter("pageSource");
		BigDecimal proveedorID = new BigDecimal(request.getParameter("proveedorID"));
		List provprods= (List) request.getSession().getAttribute("provprodLista");
		for (int i = 0; i < provprods.size(); i++) {
			Provprod provprod = (Provprod) provprods.get(i);
			if(provprod.getIdproveedor().equals(proveedorID)){
				provprods.remove(i);
			}
				
		}
		request.getSession().setAttribute("provprodLista",provprods);
		
		return mapping.findForward(next);
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
		Producto buscar = new Producto();
		buscar.setIdproducto(new java.math.BigDecimal(request.getParameter("idproducto")));
		
		Producto producto = iFarmacia.obtenerProductoPorId(buscar);
		Familia buscarFam = new Familia();
		buscarFam.setIdfamilia(producto.getIdfamilia());
		Familia familia = iFarmacia.obtenerFamiliaPorId(buscarFam); 
		ProductoForm forma = (ProductoForm) form;
		BeanUtils.copyProperties(forma,producto);
		producto.setFamdesc(familia.getNombre());
		request.getSession().setAttribute("labLista",iFarmacia.obtenerLaboratorios(Constants.SIN_PAGINAR));
		request.getSession().setAttribute("catLista",iFarmacia.obtenerCategorias(Constants.SIN_PAGINAR));
		request.getSession().setAttribute("provLista",iFarmacia.obtenerProveedors(Constants.SIN_PAGINAR));
		request.getSession().setAttribute("provprodLista",producto.getProvprods());
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
	
		ProductoForm forma = (ProductoForm) form;
		ActionMessages errors = forma.validate(mapping, request);
		if (!errors.isEmpty()) {
		      saveErrors(request, errors);
		      return mapping.findForward("toedit");
		    }
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Producto producto = new Producto();
						//	forma.setIdproveedor(request.getParameter("campoproveedor"));
		if(forma.getValor()==null||forma.getValor().trim().equals("")){
			forma.setValor("0");
		}
		forma.setIdfamilia(request.getParameter("campofamilia"));
		if(forma.getCaja()==null||forma.getCaja().trim().length()<=0){
			forma.setCaja("0");	
		}
		if(forma.getSobre()==null||forma.getSobre().trim().length()<=0){
			forma.setSobre("0");	
		}
		BeanUtils.copyProperties(producto, forma);
		List provprods= (List) request.getSession().getAttribute("provprodLista");
		producto.setProvprods(provprods);
		iFarmacia.actualizarProducto(producto);
		request.setAttribute("mensaje", "mensaje.editar.exito");
		request.getSession().removeAttribute("labLista");
		request.getSession().removeAttribute("catLista");
		request.getSession().removeAttribute("provLista");
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
		try {
			IServiceLocator locator = new ServiceLocator();
			IFarmacia iFarmacia = locator.getFarmacia();
			Producto buscar = new Producto();
			buscar.setIdproducto(new java.math.BigDecimal(request.getParameter("idproducto")));
			Producto producto = iFarmacia.obtenerProductoPorId(buscar);
			ProductoForm forma = (ProductoForm) form;
			BeanUtils.copyProperties(forma,producto);
			request.getSession().setAttribute("provprodLista",producto.getProvprods());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
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
		Producto buscar = new Producto();
		
				buscar.setIdproducto(new java.math.BigDecimal(request.getParameter("idproducto")));
		
		Producto producto = iFarmacia.obtenerProductoPorId(buscar);
		
		ProductoForm forma = (ProductoForm) form;
		BeanUtils.copyProperties(forma,producto);
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
	
		ProductoForm forma = (ProductoForm) form;
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Producto producto = new Producto();
		producto.setIdproducto(new BigDecimal(forma.getIdproducto()));
		try {
			MovimientoForm formaMov = new MovimientoForm();
			Collection movimientos = null;
			formaMov.setProddesc(forma.getNombre());
			if (formaMov.getProddesc() != null && formaMov.getProddesc().trim().length() > 0){
				movimientos = iFarmacia.obtenerMovimientosFiltrados(formaMov);
			}
			if(movimientos.size()>0){
				ActionMessages errors = new ActionMessages();
				errors.add("foreign", new ActionMessage("errors.foreign","Producto"));
				if (!errors.isEmpty()) {
					saveErrors(request, errors);
					return list(mapping, form, request, response);
			    }
			}
			iFarmacia.eliminarProducto(producto);
		} catch (Exception e) {
			
			if(e.getCause().toString().indexOf("foreign")>0){
				ActionMessages errors = new ActionMessages();
				errors.add("foreign", new ActionMessage("errors.foreign","Producto"));
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

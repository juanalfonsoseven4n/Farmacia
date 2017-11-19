package com.farmacia.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.farmacia.domain.Movimiento;
import com.farmacia.domain.MovimientoProd;
import com.farmacia.domain.Producto;
import com.farmacia.domain.Usuario;
import com.farmacia.form.MovimientoForm;
import com.farmacia.pojo.IFarmacia;
import com.farmacia.util.Constants;
import com.farmacia.util.Utilitario;
import com.ibatis.common.util.PaginatedList;

public class MovimientoAction extends ASpeedyAction {
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws java.lang.Exception {
		if (request.getSession().getAttribute("REDUSR") != null) {
			Usuario usuario = (Usuario) request.getSession().getAttribute("REDUSR");
			if(!usuario.getIdperfil().equals(Constants.PERFIL_MEDICO)){
				return list(mapping, form, request, response);	
			}else {
				System.out.println("**********MEDICO***********");	
				return mapping.findForward("invalidsession");
			}
		} else {
			return mapping.findForward("invalidsession");
		}
	}

	/**
	 * Metodo que permite obtener el listado
	 * 
	 * @param mapping
	 *            Es el path que se compara contra la URI solicitada de la solicitud entrante, y normalmente especifica el nombre totalmente cualificado de
	 *            clase para la clase Action
	 * @param form
	 *            Bean que permite la interaccion con el formulario de entrada
	 * @param request
	 *            Request del servlet
	 * @param response
	 *            Response del servlet
	 * @exception java.lang.Exception
	 */
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws java.lang.Exception {

		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		MovimientoForm forma = (MovimientoForm) form;
		Collection movimientos = null;

		if ((forma.getProddesc() != null && forma.getProddesc().trim().length() > 0)
				|| (forma.getFechaini() != null && forma.getFechaini().trim().length() > 1 && forma.getFechafin() != null && forma.getFechafin().trim()
						.length() > 1)) {
			forma.setFechaini(Utilitario.quitarFormato(forma.getFechaini()));
			forma.setFechafin(Utilitario.quitarFormato(forma.getFechafin()));
			movimientos = iFarmacia.obtenerMovimientosFiltrados(forma);
		} else {
			movimientos = iFarmacia.obtenerMovimientos();
		}
		PaginatedList pList = (PaginatedList) movimientos;
		HttpSession session = request.getSession();
		session.setAttribute("MOVIMIENTOS", movimientos);
		session.setAttribute("stringpag", getStringPage(pList, "MOVIMIENTOS", "movimientoForm", "tolist"));

		return mapping.findForward("tolist");
	}
	
	public ActionForward listCuarentena(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws java.lang.Exception {

		try{
			IServiceLocator locator = new ServiceLocator();
			IFarmacia iFarmacia = locator.getFarmacia();
			MovimientoForm forma = (MovimientoForm) form;
			Collection movimientos = iFarmacia.obtenerMovimientosCuarentena(forma);
			Iterator iMovimientos = movimientos.iterator();
			while (iMovimientos.hasNext()) {
				Movimiento movimiento = (Movimiento) iMovimientos.next();
				Producto buscar = new Producto();
				buscar.setIdproducto(movimiento.getIdproducto());
				Producto producto =iFarmacia.obtenerProductoPorId(buscar);
				movimiento.setCatdesc(producto.getCatdesc());
				movimiento.setCatdescd(producto.getCatdescd());
			}
			HttpSession session = request.getSession();
			session.setAttribute("PRODSCUARENTENA", movimientos);

		}catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward("tolistCuarentena");
	}

	public ActionForward listExistentes(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws java.lang.Exception {

		try{
			IServiceLocator locator = new ServiceLocator();
			IFarmacia iFarmacia = locator.getFarmacia();
			MovimientoForm forma = (MovimientoForm) form;
			Collection movimientos = iFarmacia.obtenerMovimientosExistentes(forma);
			Collection movimientosCuarentena = iFarmacia.obtenerMovimientosCuarentena(forma);
			Iterator iMovimientos = movimientos.iterator();
			List movimientosNew = new ArrayList();
			while (iMovimientos.hasNext()) {
				Movimiento movimiento = (Movimiento) iMovimientos.next();
				Producto buscar = new Producto();
				buscar.setIdproducto(movimiento.getIdproducto());
				Producto producto =iFarmacia.obtenerProductoPorId(buscar);
				movimiento.setCatdesc(producto.getCatdesc());
				movimiento.setCatdescd(producto.getCatdescd());
				movimiento.setPresentacion(producto.getPresentacion());
				//se uso el campo de caja para poner prioridad del producto 1 o 0
				movimiento.setPrioritario(""+producto.getCaja());
				//se uso el campo de nombre de farmacia para poner descripcion de familia
				movimiento.setFarmdesc(producto.getFamdesc());
				boolean agregar = false;
				if(forma.getIdlaboratorio()!=null&&forma.getIdlaboratorio().trim().length()>0&&!forma.getIdlaboratorio().equals("0")){
					if(forma.getIdlaboratorio().equals(producto.getIdlaboratorio().toString())){
						agregar=true;
					}
				}else if(forma.getIdcategoria()!=null&&forma.getIdcategoria().trim().length()>0&&!forma.getIdcategoria().equals("0")){
					if(forma.getIdcategoria().equals(producto.getIdcategoria().toString())){
						agregar=true;
					}/*else if(forma.getIdcategoria().equals(producto.getIdcategoriad().toString())){
						
					}*/
				}else{
					agregar=true;	
				}
				if(agregar){
					Iterator iMovimientosCuarentena = movimientosCuarentena.iterator();
					while (iMovimientosCuarentena.hasNext()) {
						Movimiento movimientoCuarentena= (Movimiento) iMovimientosCuarentena.next();
						if(movimientoCuarentena.getIdproducto().equals(movimiento.getIdproducto())){
							movimiento.setCuarentena(Constants.CUARENTENA);
						}
							
					}
					movimientosNew.add(movimiento);
				}
				Collections.sort(movimientosNew);
			}
			HttpSession session = request.getSession();
			session.setAttribute("EXISTENTES", movimientosNew);
			request.getSession().setAttribute("catLista",iFarmacia.obtenerCategorias(Constants.SIN_PAGINAR));
			request.getSession().setAttribute("labLista",iFarmacia.obtenerLaboratorios(Constants.SIN_PAGINAR));
			

		}catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward("tolistExistentes");
	}
	public ActionForward listExistenciasLab(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws java.lang.Exception {

		try{
			IServiceLocator locator = new ServiceLocator();
			IFarmacia iFarmacia = locator.getFarmacia();
			MovimientoForm forma = (MovimientoForm) form;
			Collection movimientos = iFarmacia.obtenerMovimientosExistentes(forma);
			Collection movimientosCuarentena = iFarmacia.obtenerMovimientosCuarentena(forma);
			Iterator iMovimientos = movimientos.iterator();
			List movimientosNew = new ArrayList();
			
			while (iMovimientos.hasNext()) {
				Movimiento temp = (Movimiento) iMovimientos.next();
				MovimientoProd movimiento = new MovimientoProd(temp);
				
				Producto buscar = new Producto();
				buscar.setIdproducto(movimiento.getIdproducto());
				Producto producto =iFarmacia.obtenerProductoPorId(buscar);
				movimiento.setCatdesc(producto.getCatdesc());
				movimiento.setCatdescd(producto.getCatdescd());
				movimiento.setPresentacion(producto.getPresentacion());
				//se uso el campo de caja para poner prioridad del producto 1 o 0
				movimiento.setPrioritario(""+producto.getCaja());
				//se uso el campo de nombre de farmacia para poner descripcion de familia
				movimiento.setFarmdesc(producto.getFamdesc());
				movimiento.setLabdesc(producto.getLabdesc());
				movimiento.setCodigoBarras(producto.getCodigo());
				boolean agregar = false;
				if(forma.getIdlaboratorio()!=null&&forma.getIdlaboratorio().trim().length()>0&&!forma.getIdlaboratorio().equals("0")){
					if(forma.getIdlaboratorio().equals(producto.getIdlaboratorio().toString())){
						agregar=true;
					}
				}else if(forma.getIdcategoria()!=null&&forma.getIdcategoria().trim().length()>0&&!forma.getIdcategoria().equals("0")){
					if(forma.getIdcategoria().equals(producto.getIdcategoria().toString())){
						agregar=true;
					}/*else if(forma.getIdcategoria().equals(producto.getIdcategoriad().toString())){
						
					}*/
				}else{
					agregar=true;	
				}
				
				if(agregar){
					Iterator iMovimientosCuarentena = movimientosCuarentena.iterator();
					while (iMovimientosCuarentena.hasNext()) {
						Movimiento movimientoCuarentena= (Movimiento) iMovimientosCuarentena.next();
						if(movimientoCuarentena.getIdproducto().equals(movimiento.getIdproducto())){
							movimiento.setCuarentena(Constants.CUARENTENA);
						}
							
					}
					movimientosNew.add(movimiento);
				}
				Collections.sort(movimientosNew);
				
			}
			HttpSession session = request.getSession();
			session.setAttribute("EXISTENTESLAB", movimientosNew);
			request.getSession().setAttribute("catLista",iFarmacia.obtenerCategorias(Constants.SIN_PAGINAR));
			request.getSession().setAttribute("labLista",iFarmacia.obtenerLaboratorios(Constants.SIN_PAGINAR));
			

		}catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward("tolistExistenciasLab");
	}
	
	public ActionForward listCompras(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws java.lang.Exception {

		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		MovimientoForm forma = (MovimientoForm) form;
		Collection movimientos = null;

		if ((forma.getProddesc() != null && forma.getProddesc().trim().length() > 0)
				|| (forma.getFechaini() != null && forma.getFechaini().trim().length() > 1 && forma.getFechafin() != null && forma.getFechafin().trim()
						.length() > 1)) {
			forma.setFechaini(Utilitario.quitarFormato(forma.getFechaini()));
			forma.setFechafin(Utilitario.quitarFormato(forma.getFechafin()));
			forma.setTipo(Constants.COMPRAS);
			movimientos = iFarmacia.obtenerMovimientosFiltradosList(forma);
		} 

		HttpSession session = request.getSession();
		session.setAttribute("COMPRAS", movimientos);


		return mapping.findForward("tolistCompras");
	}
	/**
	 * Metodo para mostrar la pagina para adicionar
	 * 
	 * @param mapping
	 *            Es el path que se compara contra la URI solicitada de la solicitud entrante, y normalmente especifica el nombre totalmente cualificado de
	 *            clase para la clase Action
	 * @param form
	 *            Bean que permite la interaccion con el formulario de entrada
	 * @param request
	 *            Request del servlet
	 * @param response
	 *            Response del servlet
	 * @exception java.lang.Exception
	 */

	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws java.lang.Exception {
		MovimientoForm forma = (MovimientoForm) form;
		forma.clearStrings();
		return mapping.findForward("toadd");
	}

	/**
	 * Metodo para salvar la informacion
	 * 
	 * @param mapping
	 *            Es el path que se compara contra la URI solicitada de la solicitud entrante, y normalmente especifica el nombre totalmente cualificado de
	 *            clase para la clase Action
	 * @param form
	 *            Bean que permite la interaccion con el formulario de entrada
	 * @param request
	 *            Request del servlet
	 * @param response
	 *            Response del servlet
	 * @exception java.lang.Exception
	 */

	public ActionForward saveAdd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws java.lang.Exception {
		try {

			MovimientoForm forma = (MovimientoForm) form;
			ActionMessages errors = forma.validate(mapping, request);
			if (!errors.isEmpty()) {
				saveErrors(request, errors);
				return mapping.findForward("toadd");
			}
			IServiceLocator locator = new ServiceLocator();
			IFarmacia iFarmacia = locator.getFarmacia();
			Movimiento movimiento = new Movimiento();
			if (request.getSession().getAttribute("REDUSR") != null) {
				Usuario usuario = (Usuario) request.getSession().getAttribute("REDUSR");
				forma.setIdfarmacia(usuario.getIdfarmacia().toString());
				forma.setIdusuario(usuario.getIdusuario().toString());
				forma.setIdmovimiento("0");
				forma.setCantidadCaja("0");
				forma.setCantidadSobre("0");
				forma.setFecha(Utilitario.quitarFormato(forma.getFecha()));
				if(forma.getFechaexp()!=null&&forma.getFechaexp().trim().length()>0){
					forma.setFechaexp(Utilitario.quitarFormato(forma.getFechaexp()));
				}else {
					forma.setFechaexp("0");
				}
				forma.setUnidades("0");
				forma.setVendido("0");
				BeanUtils.copyProperties(movimiento, forma);
				String hora = forma.getHoras() + forma.getMinutos();
				movimiento.setHora(new BigDecimal(hora));
				movimiento.setIddetventa(new BigDecimal(0));
				iFarmacia.insertarMovimiento(movimiento);
				request.setAttribute("mensaje", "mensaje.agregar.exito");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (request.getParameter("agregarCon") != null && request.getParameter("agregarCon").equals("AGREGA")) {
			return add(mapping, form, request, response);
		} else {
			return list(mapping, form, request, response);
		}

	}

	/**
	 * Metodo para mostrar la pagina para editar registros
	 * 
	 * @param mapping
	 *            Es el path que se compara contra la URI solicitada de la solicitud entrante, y normalmente especifica el nombre totalmente cualificado de
	 *            clase para la clase Action
	 * @param form
	 *            Bean que permite la interaccion con el formulario de entrada
	 * @param request
	 *            Request del servlet
	 * @param response
	 *            Response del servlet
	 * @exception java.lang.Exception
	 */

	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws java.lang.Exception {
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Movimiento buscar = new Movimiento();

		buscar.setIdmovimiento(new java.math.BigDecimal(request.getParameter("idmovimiento")));

		Movimiento movimiento = iFarmacia.obtenerMovimientoPorId(buscar);
		MovimientoForm forma = (MovimientoForm) form;
		
		BeanUtils.copyProperties(forma, movimiento);
		String hora = movimiento.getHora().toString().length() > 3 ? movimiento.getHora().toString().substring(0, 2) : movimiento.getHora().toString()
				.substring(0, 1);
		String minutos = movimiento.getHora().toString().length() > 3 ? movimiento.getHora().toString().substring(2, 4) : movimiento.getHora().toString()
				.substring(1, 3);
		forma.setHoras(hora);
		forma.setMinutos(minutos);
		movimiento.setHora(new BigDecimal(hora));
		return mapping.findForward("toedit");
	}

	/**
	 * Metodo para mostrar salvar la informacion cuando se edita
	 * 
	 * @param mapping
	 *            Es el path que se compara contra la URI solicitada de la solicitud entrante, y normalmente especifica el nombre totalmente cualificado de
	 *            clase para la clase Action
	 * @param form
	 *            Bean que permite la interaccion con el formulario de entrada
	 * @param request
	 *            Request del servlet
	 * @param response
	 *            Response del servlet
	 * @exception java.lang.Exception
	 */

	public ActionForward saveEdit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws java.lang.Exception {

		try{	
			MovimientoForm forma = (MovimientoForm) form;
			ActionMessages errors = forma.validate(mapping, request);
			if (!errors.isEmpty()) {
				saveErrors(request, errors);
				return mapping.findForward("toedit");
			}
			IServiceLocator locator = new ServiceLocator();
			IFarmacia iFarmacia = locator.getFarmacia();
			Movimiento movimiento = new Movimiento();
			if (request.getSession().getAttribute("REDUSR") != null) {
				Usuario usuario = (Usuario) request.getSession().getAttribute("REDUSR");
				forma.setIdfarmacia(usuario.getIdfarmacia().toString());
				forma.setIdusuario(usuario.getIdusuario().toString());
				forma.setFecha(Utilitario.quitarFormato(forma.getFecha()));
				if(forma.getFechaexp()!=null&&forma.getFechaexp().trim().length()>0){
					forma.setFechaexp(Utilitario.quitarFormato(forma.getFechaexp()));
				}else {
					forma.setFechaexp("0");
				}forma.setCantidadCaja("0");
				forma.setCantidadSobre("0");
				forma.setUnidades("0");
				BeanUtils.copyProperties(movimiento, forma);
				
				String hora = forma.getHoras() + forma.getMinutos();
				movimiento.setHora(new BigDecimal(hora));
				iFarmacia.actualizarMovimiento(movimiento);
				request.setAttribute("mensaje", "mensaje.editar.exito");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list(mapping, form, request, response);
	}

	/**
	 * Metodo para mostrar la informacion de un registro
	 * 
	 * @param mapping
	 *            Es el path que se compara contra la URI solicitada de la solicitud entrante, y normalmente especifica el nombre totalmente cualificado de
	 *            clase para la clase Action
	 * @param form
	 *            Bean que permite la interaccion con el formulario de entrada
	 * @param request
	 *            Request del servlet
	 * @param response
	 *            Response del servlet
	 * @exception java.lang.Exception
	 */

	public ActionForward detail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws java.lang.Exception {
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Movimiento buscar = new Movimiento();

		buscar.setIdmovimiento(new java.math.BigDecimal(request.getParameter("idmovimiento")));

		Movimiento movimiento = iFarmacia.obtenerMovimientoPorId(buscar);

		MovimientoForm forma = (MovimientoForm) form;
		BeanUtils.copyProperties(forma, movimiento);
		String hora = movimiento.getHora().toString().length() > 3 ? movimiento.getHora().toString().substring(0, 2) : movimiento.getHora().toString()
				.substring(0, 1);
		String minutos = movimiento.getHora().toString().length() > 3 ? movimiento.getHora().toString().substring(2, 4) : movimiento.getHora().toString()
				.substring(1, 3);
		forma.setHoras(hora);
		forma.setMinutos(minutos);
		return mapping.findForward("todetail");
	}

	/**
	 * Metodo para mostrar la pagina para eliminar un registro
	 * 
	 * @param mapping
	 *            Es el path que se compara contra la URI solicitada de la solicitud entrante, y normalmente especifica el nombre totalmente cualificado de
	 *            clase para la clase Action
	 * @param form
	 *            Bean que permite la interaccion con el formulario de entrada
	 * @param request
	 *            Request del servlet
	 * @param response
	 *            Response del servlet
	 * @exception java.lang.Exception
	 */

	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws java.lang.Exception {
		IServiceLocator locator = new ServiceLocator();
		IFarmacia iFarmacia = locator.getFarmacia();
		Movimiento buscar = new Movimiento();

		buscar.setIdmovimiento(new java.math.BigDecimal(request.getParameter("idmovimiento")));

		Movimiento movimiento = iFarmacia.obtenerMovimientoPorId(buscar);

		MovimientoForm forma = (MovimientoForm) form;
		BeanUtils.copyProperties(forma, movimiento);
		String hora = movimiento.getHora().toString().length() > 3 ? movimiento.getHora().toString().substring(0, 2) : movimiento.getHora().toString()
				.substring(0, 1);
		String minutos = movimiento.getHora().toString().length() > 3 ? movimiento.getHora().toString().substring(2, 4) : movimiento.getHora().toString()
				.substring(1, 3);
		forma.setHoras(hora);
		forma.setMinutos(minutos);
		return mapping.findForward("todelete");
	}

	/**
	 * Metodo para mostrar eliminar un registro
	 * 
	 * @param mapping
	 *            Es el path que se compara contra la URI solicitada de la solicitud entrante, y normalmente especifica el nombre totalmente cualificado de
	 *            clase para la clase Action
	 * @param form
	 *            Bean que permite la interaccion con el formulario de entrada
	 * @param request
	 *            Request del servlet
	 * @param response
	 *            Response del servlet
	 * @exception java.lang.Exception
	 */

	public ActionForward saveDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws java.lang.Exception {

		try{
			MovimientoForm forma = (MovimientoForm) form;
			IServiceLocator locator = new ServiceLocator();
			IFarmacia iFarmacia = locator.getFarmacia();
			Movimiento movimiento = new Movimiento();
			movimiento.setIdmovimiento(new BigDecimal(forma.getIdmovimiento()));
			iFarmacia.eliminarMovimiento(movimiento);
			request.setAttribute("mensaje", "mensaje.eliminar.exito");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list(mapping, form, request, response);
	}

	/**
	 * Metodo que permite obtener el listado
	 * 
	 * @param mapping
	 *            Es el path que se compara contra la URI solicitada de la solicitud entrante, y normalmente especifica el nombre totalmente cualificado de
	 *            clase para la clase Action
	 * @param form
	 *            Bean que permite la interaccion con el formulario de entrada
	 * @param request
	 *            Request del servlet
	 * @param response
	 *            Response del servlet
	 * @exception java.lang.Exception
	 */
	public ActionForward consolidado(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws java.lang.Exception {
		try {
			
			IServiceLocator locator = new ServiceLocator();
			IFarmacia iFarmacia = locator.getFarmacia();
			MovimientoForm forma = (MovimientoForm) form;
			Collection movimientos = iFarmacia.obtenerMovimientosConsol(forma);
			HttpSession session = request.getSession();
			session.setAttribute("MOVIMIENTOS", movimientos);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward("tolistConsol");
	}

	/**
	 * Metodo que permite obtener el listado
	 * 
	 * @param mapping
	 *            Es el path que se compara contra la URI solicitada de la solicitud entrante, y normalmente especifica el nombre totalmente cualificado de
	 *            clase para la clase Action
	 * @param form
	 *            Bean que permite la interaccion con el formulario de entrada
	 * @param request
	 *            Request del servlet
	 * @param response
	 *            Response del servlet
	 * @exception java.lang.Exception
	 */
	public ActionForward saldo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws java.lang.Exception {
		try {
			IServiceLocator locator = new ServiceLocator();
			IFarmacia iFarmacia = locator.getFarmacia();
			MovimientoForm forma = (MovimientoForm) form;
			BigDecimal totalCompras = new BigDecimal(0);
			BigDecimal totalVentas = new BigDecimal(0);
			BigDecimal totalMercancia = new BigDecimal(0);
			BigDecimal totalMercanciaCompra = new BigDecimal(0);
			Collection movimientos = iFarmacia.obtenerSaldos(forma);
			Iterator iMovimientos = movimientos.iterator();
			while (iMovimientos.hasNext()) {
				Movimiento movimiento = (Movimiento) iMovimientos.next();
				totalCompras=new BigDecimal(totalCompras.doubleValue()+movimiento.getPreciocosto().doubleValue());
				totalVentas=new BigDecimal(totalVentas.doubleValue()+movimiento.getPrecio().doubleValue());
				Producto buscarProducto = new Producto();
				buscarProducto.setIdproducto(movimiento.getIdproducto());
				Producto producto = iFarmacia.obtenerProductoPorId(buscarProducto);
				double precioCaja=0;
				if(producto.getPrecioventa()!=null){
					precioCaja=producto.getPrecioventa().doubleValue()*movimiento.getCantidad().doubleValue();
				}
				double precioSobre=0;
				if(producto.getValor()!=null){
					precioSobre=producto.getValor().doubleValue()*movimiento.getUnidades().doubleValue();
				}
				movimiento.setValorMercancia(new BigDecimal(precioCaja+precioSobre));
				movimiento.setValorMercanciaCompra(new BigDecimal(movimiento.getValorMercancia().doubleValue()/2));
				movimiento.setCodigoBarras(producto.getCodigo());
				totalMercancia=new BigDecimal(totalMercancia.doubleValue()+movimiento.getValorMercancia().doubleValue());
				totalMercanciaCompra=new BigDecimal(totalMercanciaCompra.doubleValue()+movimiento.getValorMercanciaCompra().doubleValue());
			}
			forma.setTotalMercanciaCompra(totalMercanciaCompra);
			forma.setTotalCompras(totalCompras);
			forma.setTotalVentas(totalVentas);
			forma.setTotalMercancia(totalMercancia);
			HttpSession session = request.getSession();
			session.setAttribute("SALDOS", movimientos);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward("tolistSaldo");
	}
}

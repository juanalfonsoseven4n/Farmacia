package com.farmacia.pojo;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import com.farmacia.domain.Categoria;
import com.farmacia.domain.Clasificacion;
import com.farmacia.domain.Cliente;
import com.farmacia.domain.Detventa;
import com.farmacia.domain.Familia;
import com.farmacia.domain.Farmacia;
import com.farmacia.domain.Gasto;
import com.farmacia.domain.Inventario;
import com.farmacia.domain.Laboratorio;
import com.farmacia.domain.Menu;
import com.farmacia.domain.Movimiento;
import com.farmacia.domain.Opcion;
import com.farmacia.domain.Opcper;
import com.farmacia.domain.Perfil;
import com.farmacia.domain.Producto;
import com.farmacia.domain.Proveedor;
import com.farmacia.domain.Provprod;
import com.farmacia.domain.Usuario;
import com.farmacia.domain.Venta;
import com.farmacia.exceptions.ApplicationException;
import com.farmacia.form.GastoForm;
import com.farmacia.form.MovimientoForm;
import com.farmacia.form.VentaForm;
import com.farmacia.persistence.iface.ICategoriaDao;
import com.farmacia.persistence.iface.IClasificacionDao;
import com.farmacia.persistence.iface.IClienteDao;
import com.farmacia.persistence.iface.IDetventaDao;
import com.farmacia.persistence.iface.IFamiliaDao;
import com.farmacia.persistence.iface.IFarmaciaDao;
import com.farmacia.persistence.iface.IGastoDao;
import com.farmacia.persistence.iface.IInventarioDao;
import com.farmacia.persistence.iface.ILaboratorioDao;
import com.farmacia.persistence.iface.IMenuDao;
import com.farmacia.persistence.iface.IMovimientoDao;
import com.farmacia.persistence.iface.IOpcionDao;
import com.farmacia.persistence.iface.IOpcperDao;
import com.farmacia.persistence.iface.IPerfilDao;
import com.farmacia.persistence.iface.IProductoDao;
import com.farmacia.persistence.iface.IProveedorDao;
import com.farmacia.persistence.iface.IProvprodDao;
import com.farmacia.persistence.iface.IUsuarioDao;
import com.farmacia.persistence.iface.IVentaDao;
import com.farmacia.persistence.sqlmapdao.DaoConfig;
import com.farmacia.util.Constants;
import com.farmacia.util.RSA;
import com.ibatis.common.util.PaginatedArrayList;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;





/**
 * Esta clase facade implementa los métodos del negocio para el proyecto Farmacia
 * @version 1.0
 * @created 11-Oct-2006 10:36:55 AM
 */
public class FarmaciaModel implements IFarmacia{

	
	
	/**
	 * Objeto DAO que permite el acceso a la base de datos para el manejo de la tabla
	 * de categorias
	 */
		private IInventarioDao inventarioDao;
		private IDetventaDao detventaDao;
		private IFarmaciaDao farmaciaDao;
		private IMovimientoDao movimientoDao;
		private IProveedorDao proveedorDao;
		private IGastoDao gastoDao;
		private IClienteDao clienteDao;
		private IUsuarioDao usuarioDao;
		private IVentaDao ventaDao;
		private IOpcperDao opcperDao;
		private IPerfilDao perfilDao;
		private IProductoDao productoDao;
		private IOpcionDao opcionDao;
		private IFamiliaDao familiaDao;
		private IMenuDao menuDao;
		private IProvprodDao provprodDao;
		private ILaboratorioDao laboratorioDao;
		private ICategoriaDao categoriaDao;
		private IClasificacionDao clasificacionDao;
		private final DaoManager daoManager = DaoConfig.getDaoManager();
	
	/**
	 * Objeto DAO que permite el acceso a la base de datos para el manejo de la tabla
	 * de parametros genericos
	 */
	
	/**
	 * Constructor por defecto público.
	 */
	public FarmaciaModel() {
				inventarioDao = (IInventarioDao) daoManager.getDao(IInventarioDao.class);
				detventaDao = (IDetventaDao) daoManager.getDao(IDetventaDao.class);
				farmaciaDao = (IFarmaciaDao) daoManager.getDao(IFarmaciaDao.class);
				movimientoDao = (IMovimientoDao) daoManager.getDao(IMovimientoDao.class);
				proveedorDao = (IProveedorDao) daoManager.getDao(IProveedorDao.class);
				gastoDao = (IGastoDao) daoManager.getDao(IGastoDao.class);
				clienteDao = (IClienteDao) daoManager.getDao(IClienteDao.class);
				usuarioDao = (IUsuarioDao) daoManager.getDao(IUsuarioDao.class);
				ventaDao = (IVentaDao) daoManager.getDao(IVentaDao.class);
				opcperDao = (IOpcperDao) daoManager.getDao(IOpcperDao.class);
				perfilDao = (IPerfilDao) daoManager.getDao(IPerfilDao.class);
				productoDao = (IProductoDao) daoManager.getDao(IProductoDao.class);
				opcionDao = (IOpcionDao) daoManager.getDao(IOpcionDao.class);
				familiaDao = (IFamiliaDao) daoManager.getDao(IFamiliaDao.class);
				menuDao = (IMenuDao) daoManager.getDao(IMenuDao.class);
				laboratorioDao = (ILaboratorioDao) daoManager.getDao(ILaboratorioDao.class);
				categoriaDao = (ICategoriaDao) daoManager.getDao(ICategoriaDao.class);
				clasificacionDao = (IClasificacionDao) daoManager.getDao(IClasificacionDao.class);
				provprodDao = (IProvprodDao) daoManager.getDao(IProvprodDao.class);
			}


	public void eliminarInventario(Inventario delete) throws ApplicationException {
		try{
			inventarioDao.deleteInventario(delete);
			
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
		
	}

	public Inventario obtenerInventarioPorId(Inventario elemento) throws ApplicationException {
		try{
			Inventario inventario = inventarioDao.getInventario(elemento);
			
			return inventario;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerInventarios() throws ApplicationException {
		try{
			Collection tablatests = inventarioDao.getInventarioList();
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public void insertarInventario(Inventario insert) throws ApplicationException {
		try{
									if(insert.getIdinventario()==null||insert.getIdinventario().toString().equals("0")){
					BigDecimal valor = inventarioDao.getMaxInventarioIdinventario();
					insert.setIdinventario(new BigDecimal(valor!=null?valor.doubleValue()+1:1));
				}
								inventarioDao.insertInventario(insert);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
		
	}

	public void actualizarInventario(Inventario update) throws ApplicationException {
		try{
			inventarioDao.updateInventario(update);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
	}
	
	
	
	
	public void eliminarDetventa(Detventa delete) throws ApplicationException {
		try{
			detventaDao.deleteDetventa(delete);
			
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
		
	}

	public Detventa obtenerDetventaPorId(Detventa elemento) throws ApplicationException {
		try{
			Detventa detventa = detventaDao.getDetventa(elemento);
			
			return detventa;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerDetventas() throws ApplicationException {
		try{
			Collection tablatests = detventaDao.getDetventaList();
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public void insertarDetventa(Detventa insert) throws ApplicationException {
		try{
									if(insert.getIddetventa()==null||insert.getIddetventa().toString().equals("0")){
					BigDecimal valor = detventaDao.getMaxDetventaIddetventa();
					insert.setIddetventa(new BigDecimal(valor!=null?valor.doubleValue()+1:1));
				}
								detventaDao.insertDetventa(insert);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
		
	}

	public void actualizarDetventa(Detventa update) throws ApplicationException {
		try{
			detventaDao.updateDetventa(update);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
	}
	
	
	public void eliminarFarmacia(Farmacia delete) throws ApplicationException {
		try{
			farmaciaDao.deleteFarmacia(delete);
			
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
		
	}

	public Farmacia obtenerFarmaciaPorId(Farmacia elemento) throws ApplicationException {
		try{
			Farmacia farmacia = farmaciaDao.getFarmacia(elemento);
			
			return farmacia;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerFarmacias(String pag) throws ApplicationException {
		try{
			Collection tablatests = null;
			if(pag.equals(Constants.PAGINADOS)){
				tablatests = farmaciaDao.getFarmaciaListPag();
			}else {
				tablatests = farmaciaDao.getFarmaciaList();
			}
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public void insertarFarmacia(Farmacia insert) throws ApplicationException {
		try{
									if(insert.getIdfarmacia()==null||insert.getIdfarmacia().toString().equals("0")){
					BigDecimal valor = farmaciaDao.getMaxFarmaciaIdfarmacia();
					insert.setIdfarmacia(new BigDecimal(valor!=null?valor.doubleValue()+1:1));
				}
								farmaciaDao.insertFarmacia(insert);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
		
	}

	public void actualizarFarmacia(Farmacia update) throws ApplicationException {
		try{
			farmaciaDao.updateFarmacia(update);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
	}
	
	
	public void eliminarMovimiento(Movimiento delete) throws ApplicationException {
		try{
			movimientoDao.deleteMovimiento(delete);
			
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
		
	}

	public Movimiento obtenerMovimientoPorId(Movimiento elemento) throws ApplicationException {
		try{
			Movimiento movimiento = movimientoDao.getMovimiento(elemento);
			
			return movimiento;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerMovimientos() throws ApplicationException {
		try{
			Collection tablatests = movimientoDao.getMovimientoList();
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	
	public Collection obtenerMovimientosFiltrados(MovimientoForm forma)throws ApplicationException {
		try{
			if(forma.getProddesc()!=null&&forma.getProddesc().trim().length()>0){
				forma.setProddesc(forma.getProddesc().toUpperCase());
			}
			
			Collection tablatests = movimientoDao.getMovimientosFiltrados(forma);
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	
	public Collection obtenerMovimientosFiltradosList(MovimientoForm forma)throws ApplicationException {
		try{
			if(forma.getProddesc()!=null&&forma.getProddesc().trim().length()>0){
				forma.setProddesc(forma.getProddesc().toUpperCase());
			}
			
			Collection tablatests = movimientoDao.getMovimientosFiltradosList(forma);
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	
	public Collection obtenerMovimientosConsol(MovimientoForm forma)throws ApplicationException{
		try{
			List tablatests = movimientoDao.getMovimientosConsolByProd(forma);
			for (int i = 0; i < tablatests.size(); i++) {
				Movimiento movimiento = (Movimiento) tablatests.get(i);
				Producto buscarProd = new Producto();
				buscarProd.setIdproducto(movimiento.getIdproducto());
				Producto producto = productoDao.getProducto(buscarProd);
				if((i+1)<tablatests.size()){
					Movimiento movSiguiente = (Movimiento) tablatests.get(i+1);
					if(movimiento.getIdproducto().equals(movSiguiente.getIdproducto())&&(movimiento.getTipo().equals(movSiguiente.getTipo()))){
						//para cajas
						long cajas = (long) (movSiguiente.getCantidad().doubleValue()/producto.getSobre().doubleValue());
						cajas +=movimiento.getCantidad().doubleValue();
						movimiento.setCantidad(new BigDecimal(cajas));
						//para sobres
						long sobres = (long) (movSiguiente.getCantidad().doubleValue()%producto.getSobre().doubleValue());
						movimiento.setUnidades(new BigDecimal(sobres));
						movimiento.setPreciocosto(new BigDecimal(movimiento.getPreciocosto().doubleValue()+movSiguiente.getPreciocosto().doubleValue()));
						tablatests.remove(i+1);
						
					}else if(movimiento.getValor().doubleValue()==2){
						movimiento.setUnidades(movimiento.getCantidad());
						movimiento.setCantidad(new BigDecimal(0));
					}else {
						movimiento.setUnidades(new BigDecimal(0));
					}
				}else if(movimiento.getValor().doubleValue()==2){
					movimiento.setUnidades(movimiento.getCantidad());
					movimiento.setCantidad(new BigDecimal(0));
				}else {
					movimiento.setUnidades(new BigDecimal(0));
				}
			}
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	public Collection obtenerSaldos(MovimientoForm forma)throws ApplicationException{
		try{
			List tablatests = (List) obtenerMovimientosConsol(forma);
		
			for (int i = 0; i < tablatests.size(); i++) {
				Movimiento movimiento = (Movimiento) tablatests.get(i);
				Producto buscarProd = new Producto();
				buscarProd.setIdproducto(movimiento.getIdproducto());
				Producto producto = productoDao.getProducto(buscarProd);
				if((i+1)<tablatests.size()){
					Movimiento movSiguiente = (Movimiento) tablatests.get(i+1);
					if(movimiento.getIdproducto().equals(movSiguiente.getIdproducto())){
						long cajas = (long) (movimiento.getCantidad().doubleValue()-movSiguiente.getCantidad().doubleValue());
						long sobres = (long) (movimiento.getUnidades().doubleValue()-movSiguiente.getUnidades().doubleValue());
						if(sobres!=0){
						cajas += (long) (sobres/producto.getSobre().doubleValue());
						sobres = (long) (sobres%producto.getSobre().doubleValue());
						}
						if(sobres<0&&cajas>0){
							cajas-=1;
							sobres+=producto.getSobre().doubleValue();
						}
						movimiento.setCantidad(new BigDecimal(cajas));
						movimiento.setUnidades(new BigDecimal(sobres));
						movimiento.setPrecio(movSiguiente.getPreciocosto());
						tablatests.remove(i+1);
					}else if(movimiento.getTipo().equals(new BigDecimal("1"))){
						movimiento.setPrecio(new BigDecimal(0));
					}else if (movimiento.getTipo().equals(new BigDecimal("2"))) {
						movimiento.setPrecio(movimiento.getPreciocosto());
						movimiento.setPreciocosto(new BigDecimal(0));
					}
				}else if(movimiento.getTipo().equals(new BigDecimal("1"))){
						movimiento.setPrecio(new BigDecimal(0));
				}else if (movimiento.getTipo().equals(new BigDecimal("2"))){
						movimiento.setPrecio(movimiento.getPreciocosto());
						movimiento.setPreciocosto(new BigDecimal(0));
				}
			}
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	
	public Collection obtenerMovimientosExistentes(MovimientoForm forma)throws ApplicationException {
		try{
			if(forma.getProddesc()!=null&&forma.getProddesc().trim().length()>0){
				forma.setProddesc(forma.getProddesc().toUpperCase());
			}
			List tablatests = (List) obtenerSaldos(forma);
			List movsExistenes= new ArrayList();
			for (int i = 0; i < tablatests.size(); i++) {
				Movimiento movimiento = (Movimiento) tablatests.get(i);
				if(movimiento.getCantidad().doubleValue()>0||movimiento.getUnidades().doubleValue()>0){
					Producto buscar = new Producto();
					buscar.setIdproducto(movimiento.getIdproducto());
					Producto producto = productoDao.getProducto(buscar);
					movimiento.setPrecioVentaCaja(producto.getPrecioventa());
					movimiento.setPrecioVentaUnid(producto.getValor());
					movsExistenes.add(movimiento);
				}
			}
			
			return movsExistenes;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	public Collection obtenerMovimientosCuarentena(MovimientoForm forma)throws ApplicationException {
		try{
			if(forma.getProddesc()!=null&&forma.getProddesc().trim().length()>0){
				forma.setProddesc(forma.getProddesc().toUpperCase());
			}
			Calendar fecha = Calendar.getInstance(); // obtiene la fecha actual
			fecha.add(Calendar.MONTH, +3); // incrementa en 30 días la fecha actual.
			SimpleDateFormat d1 = new SimpleDateFormat("yyyyMMdd");
			BigDecimal fechaExp = new BigDecimal(d1.format(fecha.getTime()));
		
			List movsExistenes = (List) obtenerMovimientosExistentes(forma);
			List movsCuarentena= new ArrayList();
			List movsMinFecha = movimientoDao.getMovimientosCuarentena();
		
			
			for (int i = 0; i < movsMinFecha.size(); i++) {
				Movimiento movimientomin = (Movimiento) movsMinFecha.get(i);
				//System.out.println("ProdCuaren: "+movimientomin.getIdproducto()+" "+movimientomin.getProddesc()+" "+movimientomin.getFechaexpFormated());
				
				if(movimientomin.getFechaexp().doubleValue()<=fechaExp.doubleValue()){
					for (int j = 0; j < movsExistenes.size(); j++) {
						Movimiento movimiento = (Movimiento) movsExistenes.get(j);
						if(movimientomin.getIdproducto().equals(movimiento.getIdproducto())){
							movimiento.setFechaexp(movimientomin.getFechaexp());
							movsCuarentena.add(movimiento);
						}
					}
				}
			}
			return movsCuarentena;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	
	public void insertarMovimiento(Movimiento insert) throws ApplicationException {
		try{
									if(insert.getIdmovimiento()==null||insert.getIdmovimiento().toString().equals("0")){
					BigDecimal valor = movimientoDao.getMaxMovimientoIdmovimiento();
					insert.setIdmovimiento(new BigDecimal(valor!=null?valor.doubleValue()+1:1));
				}
								movimientoDao.insertMovimiento(insert);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
		
	}

	public void actualizarMovimiento(Movimiento update) throws ApplicationException {
		try{
			movimientoDao.updateMovimiento(update);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
	}
	
	
	public void eliminarProveedor(Proveedor delete) throws ApplicationException {
		try{
			proveedorDao.deleteProveedor(delete);
			
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
		
	}

	public Proveedor obtenerProveedorPorId(Proveedor elemento) throws ApplicationException {
		try{
			Proveedor proveedor = proveedorDao.getProveedor(elemento);
			
			return proveedor;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerProveedors(String pag) throws ApplicationException {
		try{
			Collection tablatests = null;
			if(pag.equals(Constants.PAGINADOS)){
				tablatests = proveedorDao.getProveedorListPag();
			}else {
				tablatests = proveedorDao.getProveedorList();
			}
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	
	}

	public Collection obtenerProveedoresByName(String nombre) throws ApplicationException {
		try{
			Collection tablatests = proveedorDao.getProveedorByName(nombre.toUpperCase());
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	
	public void insertarProveedor(Proveedor insert) throws ApplicationException {
		try{
									if(insert.getIdproveedor()==null||insert.getIdproveedor().toString().equals("0")){
					BigDecimal valor = proveedorDao.getMaxProveedorIdproveedor();
					insert.setIdproveedor(new BigDecimal(valor!=null?valor.doubleValue()+1:1));
				}
								proveedorDao.insertProveedor(insert);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
		
	}

	public void actualizarProveedor(Proveedor update) throws ApplicationException {
		try{
			proveedorDao.updateProveedor(update);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
	}
	
	
	public void eliminarGasto(Gasto delete) throws ApplicationException {
		try{
			gastoDao.deleteGasto(delete);
			
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
		
	}

	public Gasto obtenerGastoPorId(Gasto elemento) throws ApplicationException {
		try{
			Gasto gasto = gastoDao.getGasto(elemento);
			
			return gasto;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerGastos() throws ApplicationException {
		try{
			Collection tablatests = gastoDao.getGastoList();
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	public Collection obtenerGastosFiltro(GastoForm forma) throws ApplicationException {
		try{
			Collection tablatests = gastoDao.getGastoListFiltro(forma);
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	public void insertarGasto(Gasto insert) throws ApplicationException {
		try{
									if(insert.getIdgasto()==null||insert.getIdgasto().toString().equals("0")){
					BigDecimal valor = gastoDao.getMaxGastoIdgasto();
					insert.setIdgasto(new BigDecimal(valor!=null?valor.doubleValue()+1:1));
				}
								gastoDao.insertGasto(insert);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
		
	}

	public void actualizarGasto(Gasto update) throws ApplicationException {
		try{
			gastoDao.updateGasto(update);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
	}
	
	
	public void eliminarCliente(Cliente delete) throws ApplicationException {
		try{
			clienteDao.deleteCliente(delete);
			
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
		
	}

	public Cliente obtenerClientePorId(Cliente elemento) throws ApplicationException {
		try{
			Cliente cliente = clienteDao.getCliente(elemento);
			
			return cliente;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	
	public Collection obtenerClienteByName(Cliente cliente) throws ApplicationException {
		try{
			
			cliente.setNombre(cliente.getNombre().toUpperCase());
			Collection clientesResul = clienteDao.getClienteByName(cliente);
			
			return clientesResul;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerClientes() throws ApplicationException {
		try{
			Collection tablatests = clienteDao.getClienteList();
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public void insertarCliente(Cliente insert) throws ApplicationException {
		try{
									if(insert.getIdcliente()==null||insert.getIdcliente().toString().equals("0")){
					BigDecimal valor = clienteDao.getMaxClienteIdcliente();
					insert.setIdcliente(new BigDecimal(valor!=null?valor.doubleValue()+1:1));
				}
								clienteDao.insertCliente(insert);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
		
	}

	public void actualizarCliente(Cliente update) throws ApplicationException {
		try{
			clienteDao.updateCliente(update);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
	}
	
	
	public void eliminarUsuario(Usuario delete) throws ApplicationException {
		try{
			usuarioDao.deleteUsuario(delete);
			
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
		
	}

	public Usuario obtenerUsuarioPorId(Usuario elemento) throws ApplicationException {
		try{
			Usuario usuario = usuarioDao.getUsuario(elemento);
			
			return usuario;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerUsuarios() throws ApplicationException {
		try{
			Collection tablatests = usuarioDao.getUsuarioList();
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	
	public Collection obtenerMedicos(String farmacia) throws ApplicationException {
		try{
			Collection tablatests = usuarioDao.getMedicosList(farmacia);
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public void insertarUsuario(Usuario insert) throws ApplicationException {
		try{
			if(insert.getIdusuario()==null||insert.getIdusuario().toString().equals("0")){
					BigDecimal valor = usuarioDao.getMaxUsuarioIdusuario();
					insert.setIdusuario(new BigDecimal(valor!=null?valor.doubleValue()+1:1));
				}
			RSA rsa = new RSA(new BigInteger("7"),new BigInteger("25073217964183"),new BigInteger("175512552247237"));
			String cifrado1="";
			if(insert.getPassword().length()>6){
				 cifrado1 = rsa.encriptar(insert.getPassword().substring(0,6)) +"?BI?"+rsa.encriptar(insert.getPassword().substring(6));
			}else{
				cifrado1 = rsa.encriptar(insert.getPassword());
			}
			
			insert.setPassword(cifrado1);
			usuarioDao.insertUsuario(insert);
			
		}catch (DaoException e) {e.printStackTrace();
			e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
		
	}

	public void actualizarUsuario(Usuario update) throws ApplicationException {
		try{
			Usuario usuario = usuarioDao.getUsuario(update);
			if(update.getPassword().equals(update.getPassword())){
				RSA rsa = new RSA(new BigInteger("7"),new BigInteger("25073217964183"),new BigInteger("175512552247237"));
				String cifrado1="";
				if(update.getPassword().length()>6){
					 cifrado1 = rsa.encriptar(update.getPassword().substring(0,6)) +"?BI?"+rsa.encriptar(update.getPassword().substring(6));
				}else{
					cifrado1 = rsa.encriptar(update.getPassword());
				}
				update.setPassword(cifrado1);
			}
			usuarioDao.updateUsuario(update);
			
		}catch (DaoException e) {e.printStackTrace();
			e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
	}
	
	
	public void eliminarVenta(Venta delete) throws ApplicationException {
		try{
			List detalles = detventaDao.getDetventaListByVenta(delete.getIdventa());
			Iterator iDetalles = detalles.iterator();
			while (iDetalles.hasNext()) {
				Detventa element = (Detventa) iDetalles.next();
				movimientoDao.deleteMovimientoByDetVenta(element.getIddetventa());
				detventaDao.deleteDetventa(element);
			}
			ventaDao.deleteVenta(delete);
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
		
	}

	public Venta obtenerVentaPorId(Venta elemento) throws ApplicationException {
		try{
			Venta venta = ventaDao.getVenta(elemento);
			venta.setDetalles(detventaDao.getDetventaListByVenta(venta.getIdventa()));
			
			return venta;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	
	public Venta obtenerVentaPorIdMarked(Venta elemento) throws ApplicationException {
		try{
			Venta venta = ventaDao.getVenta(elemento);
			List detalles = detventaDao.getDetventaListByVentaMarked(venta.getIdventa());
			Iterator iDetalles = detalles.iterator();
			venta.setValortotal(new BigDecimal(0));
			while (iDetalles.hasNext()) {
				Detventa detventa = (Detventa) iDetalles.next();
				venta.setValortotal(new BigDecimal(venta.getValortotal().doubleValue()+detventa.getValor().doubleValue()));
			}
			venta.setIva(new BigDecimal(venta.getValortotal().doubleValue()*16/100));
			venta.setDetalles(detalles);
			return venta;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerVentas() throws ApplicationException {
		try{
			Collection tablatests = ventaDao.getVentaList();
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	
	public Collection obtenerVentasFiltradas(VentaForm forma) throws ApplicationException {
		try{
			
			if(forma.getUsuario()!=null&&forma.getUsuario().trim().length()>0){
				forma.setUsuario(forma.getUsuario().toUpperCase());
				Usuario userbuscar = new Usuario(); 
				userbuscar.setDescripcion(forma.getUsuario());
				Usuario usuario = usuarioDao.getUsuariobyUsername(userbuscar);
				if(usuario!=null){
					System.out.println("Usuario: "+usuario.getDescripcion());
					forma.setIdmedico(""+usuario.getIdusuario());
					forma.setIdusuario(""+usuario.getIdusuario());
				}
			}
			Collection tablatests = ventaDao.getVentaListFiltradas(forma);
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	
	public Collection obtenerVentasConsulta(VentaForm forma) throws ApplicationException {
		try{
			Collection ventas =new ArrayList();
			/*if ((forma.getCliente() != null && forma.getCliente().trim().length() > 0)
				
					|| (forma.getIdclasificacion() != null && !forma.getIdclasificacion().equals("0"))) {*/
				
				Collection tablatests = ventaDao.getVentaListConsulta(forma);
				if(	forma.getDescproducto() != null && forma.getDescproducto().trim().length()>0){
					Collection idsVentas = ventaDao.getIdVentas(forma.getDescproducto());
					Iterator  iTablatest = tablatests.iterator();
					while (iTablatest.hasNext()) {
						Venta venta = (Venta) iTablatest.next();
						Iterator iVentasIds = idsVentas.iterator();
						while (iVentasIds.hasNext()) {	
							BigDecimal idVenta = (BigDecimal) iVentasIds.next();
							if(idVenta.doubleValue()==venta.getIdventa().doubleValue()){
								ventas.add(venta);
								break;
							}
						}
					}
				}else{
					ventas=tablatests;	
				}
				
			/*}else if(	forma.getDescproducto() != null && forma.getDescproducto().trim().length()>0){
				ventas=ventaDao.getVentaListClientes(forma.getDescproducto());;	
			}*/
			return ventas;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	
	public BigDecimal obtenerVentasSUM() throws ApplicationException {
		try{
			BigDecimal totalVentas= ventaDao.getVentaListSUM();
			return totalVentas;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	
	public BigDecimal obtenerVentasFiltradasSUM(VentaForm forma) throws ApplicationException {
		try{
			BigDecimal totalVentas= ventaDao.getVentaListFiltradasSUM(forma);
			return totalVentas;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	
	public Collection obtenerVentasMarked() throws ApplicationException {
		try{
			Collection ventas = ventaDao.getVentaListMarked();
			Iterator iVentas = ventas.iterator();
			while (iVentas.hasNext()) {
				Venta venta = (Venta) iVentas.next();
				List detalles = detventaDao.getDetventaListByVentaMarked(venta.getIdventa());
				Iterator iDetalles = detalles.iterator();
				venta.setValortotal(new BigDecimal(0));
				while (iDetalles.hasNext()) {
					Detventa detventa = (Detventa) iDetalles.next();
					venta.setValortotal(new BigDecimal(venta.getValortotal().doubleValue()+detventa.getValor().doubleValue()));
				}
				venta.setIva(new BigDecimal(venta.getValortotal().doubleValue()*16/100));
			}
			
			return ventas;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	
	public Collection obtenerVentasMarkedFiltradas(VentaForm forma) throws ApplicationException {
		try{
			
			if(forma.getUsuario()!=null&&forma.getUsuario().trim().length()>0){
				forma.setUsuario(forma.getUsuario().toUpperCase());
				Usuario userbuscar = new Usuario(); 
				userbuscar.setDescripcion(forma.getUsuario());
				Usuario usuario = usuarioDao.getUsuariobyUsername(userbuscar);
				if(usuario!=null){
					System.out.println("Usuario: "+usuario.getDescripcion());
					forma.setIdmedico(""+usuario.getIdusuario());
					forma.setIdusuario(""+usuario.getIdusuario());
				}
			}
			Collection ventas = ventaDao.getVentaListMarkedFiltradas(forma);
			Iterator iVentas = ventas.iterator();
			while (iVentas.hasNext()) {
				Venta venta = (Venta) iVentas.next();
				List detalles = detventaDao.getDetventaListByVentaMarked(venta.getIdventa());
				Iterator iDetalles = detalles.iterator();
				venta.setValortotal(new BigDecimal(0));
				while (iDetalles.hasNext()) {
					Detventa detventa = (Detventa) iDetalles.next();
					venta.setValortotal(new BigDecimal(venta.getValortotal().doubleValue()+detventa.getValor().doubleValue()));
				}
				venta.setIva(new BigDecimal(venta.getValortotal().doubleValue()*16/100));
			}
			Collection ventasProd=new ArrayList(); 
			if(	forma.getDescproducto() != null && forma.getDescproducto().trim().length()>0){
				Collection idsVentas = ventaDao.getIdVentas(forma.getDescproducto());
				Iterator  iTablatest = ventas.iterator();
				while (iTablatest.hasNext()) {
					Venta venta = (Venta) iTablatest.next();
					Iterator iVentasIds = idsVentas.iterator();
					while (iVentasIds.hasNext()) {	
						BigDecimal idVenta = (BigDecimal) iVentasIds.next();
						if(idVenta.doubleValue()==venta.getIdventa().doubleValue()){
							ventasProd.add(venta);
							break;
						}
					}
				}
			}
			if(ventasProd.size()>0){
				String PAGE_SIZE = ResourceBundle.getBundle("com.farmacia.persistence.resources.database").getString("numberregister");

				PaginatedList pagVentasProd=new PaginatedArrayList(ventasProd,Integer.parseInt(PAGE_SIZE));
				return pagVentasProd;
			}
			return ventas;

		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	
	}
	
	
	
	public Collection obtenerVentasProdMarked(VentaForm forma) throws ApplicationException {
		try{
			
			
			Collection ventas = ventaDao.getVentasProdMarked(forma);
			return ventas;

		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	
	}
	public Collection obtenerPreventas(VentaForm forma) throws ApplicationException{
		try{
			Collection ventas = ventaDao.getPreventas(forma);
			return ventas;

		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	
	}
	public Venta insertarVenta(Venta insert) throws ApplicationException {
		try{
				BigDecimal idventa = new BigDecimal(0);
				BigDecimal codigo = new BigDecimal(0);
				if(insert.getIdventa()==null||insert.getIdventa().toString().equals("0")){
					idventa = ventaDao.getMaxVentaIdventa();
					
					insert.setIdventa(new BigDecimal(idventa!=null?idventa.doubleValue()+1:1));
					if(insert.isMarca1()){
					codigo = ventaDao.getMaxCodigo();
					insert.setCodigo(new BigDecimal(codigo!=null?codigo.doubleValue()+1:1));
					}
					idventa=insert.getIdventa();
					
				}
				ventaDao.insertVenta(insert);
				Iterator iDetalles = insert.getDetalles().iterator();
				while (iDetalles.hasNext()) {
					Detventa element = (Detventa) iDetalles.next();
					element.setIdventa(idventa);
					if(element.getIddetventa()==null||element.getIddetventa().toString().equals("0")){
						BigDecimal iddetventa = detventaDao.getMaxDetventaIddetventa();
						element.setIddetventa(new BigDecimal(iddetventa!=null?iddetventa.doubleValue()+1:1));
					}
					detventaDao.insertDetventa(element);
					Movimiento movimiento = new Movimiento();
					movimiento.setCantidad(element.getCantidad());
					movimiento.setIdfarmacia(insert.getIdfarmacia());
					movimiento.setIdproducto(element.getIdproducto());
					movimiento.setFecha(insert.getFecha());
					movimiento.setHora(insert.getHora());
					movimiento.setIdusuario(insert.getIdusuario());
					movimiento.setTipo(Constants.SALIDA);
					movimiento.setPrecio(element.getValorunit());
					movimiento.setPreciocosto(element.getValor());
					movimiento.setCodigo(Constants.COMENT_VENTA);
					movimiento.setValor(element.getPresentacion());
					movimiento.setIddetventa(element.getIddetventa());
					BigDecimal valor = movimientoDao.getMaxMovimientoIdmovimiento();
					movimiento.setIdmovimiento(new BigDecimal(valor!=null?valor.doubleValue()+1:1));
					
					movimientoDao.insertMovimiento(movimiento);
				}
							
		}catch (DaoException e) {
			e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
		return insert;	
	}

	public void actualizarVenta(Venta update) throws ApplicationException {
		try{
			ventaDao.updateVenta(update);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
	}
	
	
	public void eliminarOpcper(Opcper delete) throws ApplicationException {
		try{
			opcperDao.deleteOpcper(delete);
			
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
		
	}

	public Opcper obtenerOpcperPorId(Opcper elemento) throws ApplicationException {
		try{
			Opcper opcper = opcperDao.getOpcper(elemento);
			
			return opcper;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerOpcpers() throws ApplicationException {
		try{
			Collection tablatests = opcperDao.getOpcperList();
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public void insertarOpcper(Opcper insert) throws ApplicationException {
		try{
									if(insert.getIdopcper()==null||insert.getIdopcper().toString().equals("0")){
					BigDecimal valor = opcperDao.getMaxOpcperIdopcper();
					insert.setIdopcper(new BigDecimal(valor!=null?valor.doubleValue()+1:1));
				}
								opcperDao.insertOpcper(insert);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
		
	}

	public void actualizarOpcper(Opcper update) throws ApplicationException {
		try{
			opcperDao.updateOpcper(update);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
	}
	
	
	public void eliminarPerfil(Perfil delete) throws ApplicationException {
		try{
			perfilDao.deletePerfil(delete);
			
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
		
	}

	public Perfil obtenerPerfilPorId(Perfil elemento) throws ApplicationException {
		try{
			Perfil perfil = perfilDao.getPerfil(elemento);
			
			return perfil;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}


	
	public Collection obtenerPerfils(String pag) throws ApplicationException {
		try{
			Collection tablatests = null;
			if(pag.equals(Constants.PAGINADOS)){
				tablatests = perfilDao.getPerfilListPag();
			}else {
				tablatests = perfilDao.getPerfilList();
			}
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public void insertarPerfil(Perfil insert) throws ApplicationException {
		try{
									if(insert.getIdperfil()==null||insert.getIdperfil().toString().equals("0")){
					BigDecimal valor = perfilDao.getMaxPerfilIdperfil();
					insert.setIdperfil(new BigDecimal(valor!=null?valor.doubleValue()+1:1));
				}
								perfilDao.insertPerfil(insert);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
		
	}

	public void actualizarPerfil(Perfil update) throws ApplicationException {
		try{
			perfilDao.updatePerfil(update);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
	}
	
	
	public void eliminarProducto(Producto delete) throws ApplicationException {
		try{
			provprodDao.deleteProvprodByProd(delete.getIdproducto());
			productoDao.deleteProducto(delete);
			
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
		
	}

	public Producto obtenerProductoPorId(Producto elemento) throws ApplicationException {
		try{
			Producto producto = productoDao.getProducto(elemento);
			if(producto!=null){
				producto.setProvprods(provprodDao.getProvprodList(producto.getIdproducto()));
			}
			return producto;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerProductos() throws ApplicationException {
		try{
			Collection tablatests = productoDao.getProductoList();
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerProductosByName(String nombre) throws ApplicationException {
		try{
			
			Collection tablatests = productoDao.getProductoByName(nombre.toUpperCase());
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	
	public void insertarProducto(Producto insert) throws ApplicationException {
		try{
									if(insert.getIdproducto()==null||insert.getIdproducto().toString().equals("0")){
					BigDecimal valor = productoDao.getMaxProductoIdproducto();
					insert.setIdproducto(new BigDecimal(valor!=null?valor.doubleValue()+1:1));
				}
				 productoDao.insertProducto(insert);
				 if(insert.getProvprods()!=null){
					 Iterator iProvprods = insert.getProvprods().iterator();
					 while(iProvprods.hasNext()){
						 Provprod provprod = (Provprod) iProvprods.next();
						 BigDecimal valor = provprodDao.getMaxProvprodIdprovprod();
						 provprod.setIdprovprod(new BigDecimal(valor!=null?valor.doubleValue()+1:1));
						 provprod.setIdproducto(insert.getIdproducto());
						 provprodDao.insertProvprod(provprod);
					 }
				 }
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
		
	}

	public void actualizarProducto(Producto update) throws ApplicationException {
		try{
			productoDao.updateProducto(update);
			provprodDao.deleteProvprodByProd(update.getIdproducto());
			if(update.getProvprods()!=null){
			Iterator iProvprods = update.getProvprods().iterator();
				 while(iProvprods.hasNext()){
					 Provprod provprod = (Provprod) iProvprods.next();
					 BigDecimal valor = provprodDao.getMaxProvprodIdprovprod();
					 provprod.setIdprovprod(new BigDecimal(valor!=null?valor.doubleValue()+1:1));
					 provprod.setIdproducto(update.getIdproducto());
					 provprodDao.insertProvprod(provprod);
				 }
			}
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
	}
	
	
	public void eliminarOpcion(Opcion delete) throws ApplicationException {
		try{
			opcionDao.deleteOpcion(delete);
			
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
		
	}

	public Opcion obtenerOpcionPorId(Opcion elemento) throws ApplicationException {
		try{
			Opcion opcion = opcionDao.getOpcion(elemento);
			
			return opcion;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerOpcions() throws ApplicationException {
		try{
			Collection tablatests = opcionDao.getOpcionList();
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public void insertarOpcion(Opcion insert) throws ApplicationException {
		try{
									if(insert.getIdopcion()==null||insert.getIdopcion().toString().equals("0")){
					BigDecimal valor = opcionDao.getMaxOpcionIdopcion();
					insert.setIdopcion(new BigDecimal(valor!=null?valor.doubleValue()+1:1));
				}
								opcionDao.insertOpcion(insert);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
		
	}

	public void actualizarOpcion(Opcion update) throws ApplicationException {
		try{
			opcionDao.updateOpcion(update);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
	}
	
	
	public void eliminarFamilia(Familia delete) throws ApplicationException {
		try{
			familiaDao.deleteFamilia(delete);
			
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
		
	}

	public Familia obtenerFamiliaPorId(Familia elemento) throws ApplicationException {
		try{
			Familia familia = familiaDao.getFamilia(elemento);
			
			return familia;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerFamilias() throws ApplicationException {
		try{
			Collection tablatests = familiaDao.getFamiliaList();
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerFamiliasByName(String nombre) throws ApplicationException {
		try{
			Collection tablatests = familiaDao.getFamiliaByName(nombre);
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	
	public void insertarFamilia(Familia insert) throws ApplicationException {
		try{
			if(insert.getIdfamilia()==null||insert.getIdfamilia().toString().equals("0")){
					BigDecimal valor = familiaDao.getMaxFamiliaIdfamilia();
					insert.setIdfamilia(new BigDecimal(valor!=null?valor.doubleValue()+1:1));
				}
								familiaDao.insertFamilia(insert);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
		
	}

	public void actualizarFamilia(Familia update) throws ApplicationException {
		try{
			familiaDao.updateFamilia(update);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
	}


	
	public Usuario validarUsuario(Usuario usuario) throws ApplicationException {
		try{
			Usuario user = usuarioDao.getUsuariobyUsername(usuario);
			RSA rsa2 = new RSA(new BigInteger("7"),new BigInteger("25073217964183"),new BigInteger("175512552247237")); 
			
			if(user==null){
				return null;
			}else  {
				String descifrado1=null;
				if(user.getPassword().indexOf("?BI?")>0){
					descifrado1 = rsa2.desencriptar(user.getPassword().substring(0,user.getPassword().indexOf("?BI?")))+rsa2.desencriptar(user.getPassword().substring(user.getPassword().indexOf("?BI?")+4));
				}else{
					descifrado1 = rsa2.desencriptar(user.getPassword());	
				}
				if (descifrado1.equals(usuario.getPassword())) {
					return user;
				}
			}
			return null;
			
			
		}catch (Exception e) {
			return null;
		}
	}
	
	public Collection obtenerMenuListByPerfil(BigDecimal id_perfil) {
		Collection menus = menuDao.getMenuListByPerfil(id_perfil);
		Iterator iMenus = menus.iterator();
		while (iMenus.hasNext()) {
			Menu menu = (Menu) iMenus.next();
			menu.setOpciones(opcionDao.getOpcionesByMenuPerfil(id_perfil,menu.getIdmenu()));
		}
		return menus;
	}


	
	public void eliminarProvprod(Provprod delete) throws ApplicationException {
		try{
			provprodDao.deleteProvprod(delete);
			
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
		
	}

	public Provprod obtenerProvprodPorId(Provprod elemento) throws ApplicationException {
		try{
			Provprod provprod = provprodDao.getProvprod(elemento);
			
			return provprod;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerProvprods() throws ApplicationException {
		try{
			Collection tablatests = provprodDao.getProvprodList();
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public void insertarProvprod(Provprod insert) throws ApplicationException {
		try{
									if(insert.getIdprovprod()==null||insert.getIdprovprod().toString().equals("0")){
					BigDecimal valor = provprodDao.getMaxProvprodIdprovprod();
					insert.setIdprovprod(new BigDecimal(valor!=null?valor.doubleValue()+1:1));
				}
								provprodDao.insertProvprod(insert);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
		
	}

	public void actualizarProvprod(Provprod update) throws ApplicationException {
		try{
			provprodDao.updateProvprod(update);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
	}
	
	
	public void eliminarLaboratorio(Laboratorio delete) throws ApplicationException {
		try{
			laboratorioDao.deleteLaboratorio(delete);
			
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
		
	}

	public Laboratorio obtenerLaboratorioPorId(Laboratorio elemento) throws ApplicationException {
		try{
			Laboratorio laboratorio = laboratorioDao.getLaboratorio(elemento);
			
			return laboratorio;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerLaboratorios(String pag) throws ApplicationException {
		try{
			Collection tablatests = null;
			if(pag.equals(Constants.PAGINADOS)){
				tablatests = laboratorioDao.getLaboratorioListPag();
			}else {
				tablatests = laboratorioDao.getLaboratorioList();
			}
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerLaboratoriosByName(String nombre) throws ApplicationException {
		try{
			Collection tablatests = laboratorioDao.getLaboratorioByName(nombre);
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	
	public void insertarLaboratorio(Laboratorio insert) throws ApplicationException {
		try{
									if(insert.getIdlaboratorio()==null||insert.getIdlaboratorio().toString().equals("0")){
					BigDecimal valor = laboratorioDao.getMaxLaboratorioIdlaboratorio();
					insert.setIdlaboratorio(new BigDecimal(valor!=null?valor.doubleValue()+1:1));
				}
								laboratorioDao.insertLaboratorio(insert);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
		
	}

	public void actualizarLaboratorio(Laboratorio update) throws ApplicationException {
		try{
			laboratorioDao.updateLaboratorio(update);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
	}

/**CATEGORIA**/
	
	public void eliminarCategoria(Categoria delete) throws ApplicationException {
		try{
			categoriaDao.deleteCategoria(delete);
			
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
		
	}

	public Categoria obtenerCategoriaPorId(Categoria elemento) throws ApplicationException {
		try{
			Categoria categoria = categoriaDao.getCategoria(elemento);
			
			return categoria;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerCategorias(String pag) throws ApplicationException {
		try{
			Collection tablatests = null;
			if(pag.equals(Constants.PAGINADOS)){
				tablatests = categoriaDao.getCategoriaListPag();
			}else {
				tablatests = categoriaDao.getCategoriaList();
			}
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerCategoriasByName(String nombre) throws ApplicationException {
		try{
			Collection tablatests = categoriaDao.getCategoriaByName(nombre);
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	
	public void insertarCategoria(Categoria insert) throws ApplicationException {
		try{
									if(insert.getIdcategoria()==null||insert.getIdcategoria().toString().equals("0")){
					BigDecimal valor = categoriaDao.getMaxCategoriaIdcategoria();
					insert.setIdcategoria(new BigDecimal(valor!=null?valor.doubleValue()+1:1));
				}
								categoriaDao.insertCategoria(insert);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
		
	}

	public void actualizarCategoria(Categoria update) throws ApplicationException {
		try{
			categoriaDao.updateCategoria(update);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
	}
/**CLASIFICACION**/
	
	public void eliminarClasificacion(Clasificacion delete) throws ApplicationException {
		try{
			clasificacionDao.deleteClasificacion(delete);
			
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
		
	}

	public Clasificacion obtenerClasificacionPorId(Clasificacion elemento) throws ApplicationException {
		try{
			Clasificacion clasificacion = clasificacionDao.getClasificacion(elemento);
			
			return clasificacion;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerClasificacions(String pag) throws ApplicationException {
		try{
			Collection tablatests = null;
			if(pag.equals(Constants.PAGINADOS)){
				tablatests = clasificacionDao.getClasificacionListPag();
			}else {
				tablatests = clasificacionDao.getClasificacionList();
			}
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}

	public Collection obtenerClasificacionsByName(String nombre) throws ApplicationException {
		try{
			Collection tablatests = clasificacionDao.getClasificacionByName(nombre);
			
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}
	}
	
	public void insertarClasificacion(Clasificacion insert) throws ApplicationException {
		try{
									if(insert.getIdclasificacion()==null||insert.getIdclasificacion().toString().equals("0")){
					BigDecimal valor = clasificacionDao.getMaxClasificacionIdclasificacion();
					insert.setIdclasificacion(new BigDecimal(valor!=null?valor.doubleValue()+1:1));
				}
								clasificacionDao.insertClasificacion(insert);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
		
	}

	public void actualizarClasificacion(Clasificacion update) throws ApplicationException {
		try{
			clasificacionDao.updateClasificacion(update);
			
		}catch (DaoException e) {e.printStackTrace();
			if(!e.getMessage().equals("name.exist.error")){
				throw new ApplicationException("errors.system", e);
			}else{
				throw new ApplicationException("name.exist.error", e);
			}
		}
	}
	
	public Collection obtenerProductosByBarcode(String barcode)throws ApplicationException{
		
		try{
			Collection tablatests = productoDao.getProductoByBarcode(barcode);
			return tablatests;
		}catch (DaoException e) {e.printStackTrace();
			ApplicationException appException=new ApplicationException("errors.system",e);
			throw appException;
		}		
		
	}
	
	
	
}


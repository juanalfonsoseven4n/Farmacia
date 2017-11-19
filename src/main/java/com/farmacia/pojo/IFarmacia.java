package com.farmacia.pojo;
import java.math.BigDecimal;
import java.util.Collection;

import com.farmacia.domain.Categoria;
import com.farmacia.domain.Clasificacion;
import com.farmacia.domain.Cliente;
import com.farmacia.domain.Detventa;
import com.farmacia.domain.Familia;
import com.farmacia.domain.Farmacia;
import com.farmacia.domain.Gasto;
import com.farmacia.domain.Inventario;
import com.farmacia.domain.Laboratorio;
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



/**
 * Esta interfaz facade contiene métodos de negocio requeridos para la
 * administración de las tablas del proyecto.
 * @version 1.0
 * @created 11-Oct-2006 10:36:48 AM
 */
public interface IFarmacia{


	public Inventario obtenerInventarioPorId(Inventario idInventario)throws ApplicationException;

	public Collection obtenerInventarios()throws ApplicationException;
	
	public void insertarInventario(Inventario insert)throws ApplicationException;
	
	public void actualizarInventario(Inventario update)throws ApplicationException;
	
	public void eliminarInventario(Inventario delete)throws ApplicationException;	
	

	public Detventa obtenerDetventaPorId(Detventa idDetventa)throws ApplicationException;

	public Collection obtenerDetventas()throws ApplicationException;
	
	public void insertarDetventa(Detventa insert)throws ApplicationException;
	
	public void actualizarDetventa(Detventa update)throws ApplicationException;
	
	public void eliminarDetventa(Detventa delete)throws ApplicationException;	
	

	public Farmacia obtenerFarmaciaPorId(Farmacia idFarmacia)throws ApplicationException;

	public Collection obtenerFarmacias(String pag)throws ApplicationException;
	
	public void insertarFarmacia(Farmacia insert)throws ApplicationException;
	
	public void actualizarFarmacia(Farmacia update)throws ApplicationException;
	
	public void eliminarFarmacia(Farmacia delete)throws ApplicationException;	
	

	public Movimiento obtenerMovimientoPorId(Movimiento idMovimiento)throws ApplicationException;

	public Collection obtenerMovimientos()throws ApplicationException;
	
	public Collection obtenerMovimientosFiltrados(MovimientoForm forma)throws ApplicationException;
	
	public Collection obtenerMovimientosFiltradosList(MovimientoForm forma)throws ApplicationException;
	
	public Collection obtenerMovimientosCuarentena(MovimientoForm forma)throws ApplicationException;
	
	public Collection obtenerMovimientosExistentes(MovimientoForm forma)throws ApplicationException;
	
	public void insertarMovimiento(Movimiento insert)throws ApplicationException;
	
	public void actualizarMovimiento(Movimiento update)throws ApplicationException;
	
	public void eliminarMovimiento(Movimiento delete)throws ApplicationException;	
	
	public Collection obtenerMovimientosConsol(MovimientoForm forma)throws ApplicationException;
	
	public Collection obtenerSaldos(MovimientoForm forma)throws ApplicationException;
	

	public Proveedor obtenerProveedorPorId(Proveedor idProveedor)throws ApplicationException;

	public Collection obtenerProveedors(String pag)throws ApplicationException;
	
	public Collection obtenerProveedoresByName(String nombre)throws ApplicationException;
	
	public void insertarProveedor(Proveedor insert)throws ApplicationException;
	
	public void actualizarProveedor(Proveedor update)throws ApplicationException;
	
	public void eliminarProveedor(Proveedor delete)throws ApplicationException;	
	

	public Gasto obtenerGastoPorId(Gasto idGasto)throws ApplicationException;

	public Collection obtenerGastos()throws ApplicationException;
	
	public Collection obtenerGastosFiltro(GastoForm forma)throws ApplicationException;
	
	public void insertarGasto(Gasto insert)throws ApplicationException;
	
	public void actualizarGasto(Gasto update)throws ApplicationException;
	
	public void eliminarGasto(Gasto delete)throws ApplicationException;	
	

	public Cliente obtenerClientePorId(Cliente idCliente)throws ApplicationException;

	public Collection obtenerClientes()throws ApplicationException;
	
	public void insertarCliente(Cliente insert)throws ApplicationException;
	
	public void actualizarCliente(Cliente update)throws ApplicationException;
	
	public void eliminarCliente(Cliente delete)throws ApplicationException;	
	
	public Collection obtenerClienteByName(Cliente cliente) throws ApplicationException;
	

	public Usuario obtenerUsuarioPorId(Usuario idUsuario)throws ApplicationException;

	public Collection obtenerUsuarios()throws ApplicationException;
	
	public Collection obtenerMedicos(String farmacia)throws ApplicationException;
	
	public void insertarUsuario(Usuario insert)throws ApplicationException;
	
	public void actualizarUsuario(Usuario update)throws ApplicationException;
	
	public void eliminarUsuario(Usuario delete)throws ApplicationException;	
	

	public Venta obtenerVentaPorId(Venta idVenta)throws ApplicationException;
	
	public Venta obtenerVentaPorIdMarked(Venta idVenta)throws ApplicationException;

	public Collection obtenerVentas()throws ApplicationException;
	
	public Collection obtenerVentasFiltradas(VentaForm forma)throws ApplicationException;
	
	public Collection obtenerVentasConsulta(VentaForm forma) throws ApplicationException;
	
	public BigDecimal obtenerVentasSUM() throws ApplicationException;
	
	public BigDecimal obtenerVentasFiltradasSUM(VentaForm forma) throws ApplicationException;
	
	public Collection obtenerVentasMarked()throws ApplicationException;
		
	public Collection obtenerVentasMarkedFiltradas(VentaForm forma)throws ApplicationException;
	
	public Venta insertarVenta(Venta insert)throws ApplicationException;
	
	public void actualizarVenta(Venta update)throws ApplicationException;
	
	public void eliminarVenta(Venta delete)throws ApplicationException;	
	
	public Collection obtenerVentasProdMarked(VentaForm forma) throws ApplicationException;
	public Collection obtenerPreventas(VentaForm forma) throws ApplicationException;
	
	

	public Opcper obtenerOpcperPorId(Opcper idOpcper)throws ApplicationException;

	public Collection obtenerOpcpers()throws ApplicationException;
	
	public void insertarOpcper(Opcper insert)throws ApplicationException;
	
	public void actualizarOpcper(Opcper update)throws ApplicationException;
	
	public void eliminarOpcper(Opcper delete)throws ApplicationException;	
	

	public Perfil obtenerPerfilPorId(Perfil idPerfil)throws ApplicationException;

	public Collection obtenerPerfils(String pag)throws ApplicationException;
	
	public void insertarPerfil(Perfil insert)throws ApplicationException;
	
	public void actualizarPerfil(Perfil update)throws ApplicationException;
	
	public void eliminarPerfil(Perfil delete)throws ApplicationException;	
	

	public Producto obtenerProductoPorId(Producto idProducto)throws ApplicationException;

	public Collection obtenerProductos()throws ApplicationException;
	
	public Collection obtenerProductosByName(String nombre)throws ApplicationException;
	
	public void insertarProducto(Producto insert)throws ApplicationException;
	
	public void actualizarProducto(Producto update)throws ApplicationException;
	
	public void eliminarProducto(Producto delete)throws ApplicationException;	
	

	public Opcion obtenerOpcionPorId(Opcion idOpcion)throws ApplicationException;

	public Collection obtenerOpcions()throws ApplicationException;
	
	public void insertarOpcion(Opcion insert)throws ApplicationException;
	
	public void actualizarOpcion(Opcion update)throws ApplicationException;
	
	public void eliminarOpcion(Opcion delete)throws ApplicationException;	
	

	public Familia obtenerFamiliaPorId(Familia idFamilia)throws ApplicationException;

	public Collection obtenerFamilias()throws ApplicationException;
	
	public Collection obtenerFamiliasByName(String nombre)throws ApplicationException;
	
	public void insertarFamilia(Familia insert)throws ApplicationException;
	
	public void actualizarFamilia(Familia update)throws ApplicationException;
	
	public void eliminarFamilia(Familia delete)throws ApplicationException;

	public Usuario validarUsuario(Usuario usuario)throws ApplicationException;	
	
	public Collection obtenerMenuListByPerfil(BigDecimal id_perfil);
	
	
	public Provprod obtenerProvprodPorId(Provprod idProvprod)throws ApplicationException;

	public Collection obtenerProvprods()throws ApplicationException;
	
	public void insertarProvprod(Provprod insert)throws ApplicationException;
	
	public void actualizarProvprod(Provprod update)throws ApplicationException;
	
	public void eliminarProvprod(Provprod delete)throws ApplicationException;	
	
	
	public Laboratorio obtenerLaboratorioPorId(Laboratorio idLaboratorio)throws ApplicationException;

	public Collection obtenerLaboratorios(String pag)throws ApplicationException;
	
	public Collection obtenerLaboratoriosByName(String nombre)throws ApplicationException;
		
	public void insertarLaboratorio(Laboratorio insert)throws ApplicationException;
	
	public void actualizarLaboratorio(Laboratorio update)throws ApplicationException;
	
	public void eliminarLaboratorio(Laboratorio delete)throws ApplicationException;

	
	public Categoria obtenerCategoriaPorId(Categoria idCategoria)throws ApplicationException;

	public Collection obtenerCategorias(String pag)throws ApplicationException;
	
	public Collection obtenerCategoriasByName(String nombre)throws ApplicationException;
		
	public void insertarCategoria(Categoria insert)throws ApplicationException;
	
	public void actualizarCategoria(Categoria update)throws ApplicationException;
	
	public void eliminarCategoria(Categoria delete)throws ApplicationException;
	
	
	
	public Clasificacion obtenerClasificacionPorId(Clasificacion idClasificacion)throws ApplicationException;

	public Collection obtenerClasificacions(String pag)throws ApplicationException;
	
	public Collection obtenerClasificacionsByName(String nombre)throws ApplicationException;
		
	public void insertarClasificacion(Clasificacion insert)throws ApplicationException;
	
	public void actualizarClasificacion(Clasificacion update)throws ApplicationException;
	
	public void eliminarClasificacion(Clasificacion delete)throws ApplicationException;

	public Collection obtenerProductosByBarcode(String barcode)throws ApplicationException;
	


}
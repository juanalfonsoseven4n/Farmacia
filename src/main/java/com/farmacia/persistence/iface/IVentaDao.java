package com.farmacia.persistence.iface;
import java.util.Collection;

import com.farmacia.domain.Venta;
import com.farmacia.form.VentaForm;
/** 
 * @author SPEEDY
 * Interface que define los métodos de acceso principales a la base de datos 
 */
public interface IVentaDao {

	/**se genera
	 * Insertar registro en Base de datos
	 * @param com.farmacia.domain.Venta venta
	 */
	public void insertVenta(com.farmacia.domain.Venta venta);

	/**
	 * Actualizar registro en base de datos
 	 * @param java.math.BigDecimal idventa
	 * @param com.farmacia.domain.Venta venta
	 */
	public void updateVenta(com.farmacia.domain.Venta venta);

	/**
	 * Eliminar un registro de la base de datos
 	 * @param java.math.BigDecimal idventa
	 */
	public void deleteVenta(com.farmacia.domain.Venta venta);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idventa
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Venta getVenta(com.farmacia.domain.Venta venta);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idventa
	 * @return java.lang.String (XML resultante)
	 */
	public java.lang.String getVentaXmlString(java.math.BigDecimal idventa);

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public com.ibatis.common.util.PaginatedList getVentaList();
	
	public com.ibatis.common.util.PaginatedList getVentaListFiltradas(VentaForm form);
	
	public Collection getVentaListConsulta(VentaForm form);
	
	public java.math.BigDecimal getVentaListSUM();
	
	public java.math.BigDecimal getVentaListFiltradasSUM(VentaForm form);
	
	public com.ibatis.common.util.PaginatedList getVentaListMarked();
	
	public com.ibatis.common.util.PaginatedList getVentaListMarkedFiltradas(VentaForm form);
	
	public com.ibatis.common.util.PaginatedList getVentasProdMarked(VentaForm form);
	
	public com.ibatis.common.util.PaginatedList getPreventas(VentaForm form);
	
	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList (Objetos java.lang.String con la representación XML del registro)
	 */
	public com.ibatis.common.util.PaginatedList getVentaListXmlString();
		/**
	 * Consultar el maximo para insertar el siguiente
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMaxVentaIdventa();
	
	public java.math.BigDecimal getMaxCodigo();
		/**
	 * MÉTODOS PERSONALIZADOS A IMPLEMENTAR EN LAS CLASES HIJA
	 */
	public Collection getIdVentas(String nombre);
	
	public Collection getVentaListClientes(String nombre);
}

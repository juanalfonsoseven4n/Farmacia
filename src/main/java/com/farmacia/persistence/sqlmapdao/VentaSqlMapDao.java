package com.farmacia.persistence.sqlmapdao;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;

import com.farmacia.form.VentaForm;
import com.farmacia.util.Constants;
/**
 * Clase que implementa los métodos definidos en la interface correspondiente a 'VentaDao' 
 *    y extiende la plantilla de acceso a la base de datos 'SqlMapDaoTemplate'
 * @author .
 */
public class VentaSqlMapDao extends DAO implements com.farmacia.persistence.iface.IVentaDao {

	/**
	 * Definición de constructor de superclase
	 * @param daoManager
	 */
	public VentaSqlMapDao(com.ibatis.dao.client.DaoManager daoManager) {
		super(daoManager);
	}

	/**
	 * Implementación del método básico de inserción de un registro en la base de datos.
	 * @param com.farmacia.domain.Venta
	 */
	public void insertVenta(com.farmacia.domain.Venta venta) {
		HashMap datosseq = new HashMap();
		datosseq.put(Constants.SEQNAME,  "idventa");
		datosseq.put(Constants.TABLENAME,  "venta");
		Long id = getNext(datosseq);
		venta.setIdventa(new BigDecimal(id.longValue()));
		insert("insertVenta", venta);
	}

	/**
	 * Implementación del método básico de actualización de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Venta)
	 * @param com.farmacia.domain.Venta
	 */
	public void updateVenta( com.farmacia.domain.Venta venta) {
		update("updateVenta", venta);
	}

	/**
	 * Implementación del método básico de borrado de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Venta) 
	 */
	public void deleteVenta(com.farmacia.domain.Venta venta) {
		delete("deleteVenta", venta);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna un objeto con la misma estructura del registro de la tabla.
	 * @param java.math.BigDecimal (llave primaria de Venta)
	 * @return com.farmacia.domain.Venta (Objeto mapeado directamente de la BD) 
	 */
	public com.farmacia.domain.Venta getVenta(com.farmacia.domain.Venta venta) {
		return (com.farmacia.domain.Venta) queryForObject("getVenta", venta);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna una cadena con la estructura XML del registro de la tabla.
	 * @param int (llave primaria de Pv_header)
	 * @return java.lang.String (Cadena de texto XML mapeada directamente de la BD) 
	 */
	public String getVentaXmlString(java.math.BigDecimal idventa) {
		return (String) queryForObject("getVentaXmlString", idventa);
	}

	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getVentaList() {
		return queryForPaginatedList("getVentaList", null, Integer.parseInt( PAGE_SIZE));
	}

	public com.ibatis.common.util.PaginatedList getVentaListFiltradas(VentaForm form) {
		return queryForPaginatedList("getVentaListFiltradas", form, Integer.parseInt( PAGE_SIZE));
	}
	
	public Collection getVentaListConsulta(VentaForm form) {
		return queryForList("getVentaListConsulta", form);
	}
	
	public java.math.BigDecimal getVentaListSUM() {
		return (java.math.BigDecimal)queryForObject("getVentaListSUM", null);
	}

	public java.math.BigDecimal getVentaListFiltradasSUM(VentaForm form) {
		return (java.math.BigDecimal)queryForObject("getVentaListFiltradasSUM", form);
	}
	
	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getVentaListMarked() {
		return queryForPaginatedList("getVentaListMarked", null, 300);
	}
	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getVentaListMarkedFiltradas(VentaForm form) {
		return queryForPaginatedList("getVentaListMarkedFiltradas", form, 300);
	}
	
	
	public com.ibatis.common.util.PaginatedList getVentasProdMarked(VentaForm form) {
		return queryForPaginatedList("getVentasProdMarked", form, 300);
	}
	
	public com.ibatis.common.util.PaginatedList getPreventas(VentaForm form){
		return queryForPaginatedList("getPreventas", form, 300);
	}
	
	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'java.lang.String' 
	 *                                               correspondientes a estructuras XML de 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getVentaListXmlString() {
		return queryForPaginatedList("getVentaListXmlString", null, Integer.parseInt( PAGE_SIZE));
	}
		/**
	 * Implementación del método básico que consulta el registro maximo en la tabla 	 
	 * @return java.math.BigDecimal 
	 */
	public java.math.BigDecimal  getMaxVentaIdventa() {
		return (java.math.BigDecimal)queryForObject("getMaxVentaIdventa", null);
	}
	
	public java.math.BigDecimal  getMaxCodigo() {
		return (java.math.BigDecimal)queryForObject("getMaxCodigoVenta", null);
	}
		/**
	 * MÉTODOS PERSONALIZADOS DE ACCESO A LA BASE DE DATOS:	 
	 */
	public Collection getIdVentas(String nombre) {
		return queryForList("getIdVentas", nombre);
	}
	public Collection getVentaListClientes(String nombre) {
		return queryForList("getVentaListClientes", nombre);
	}
}
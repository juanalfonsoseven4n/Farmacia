package com.farmacia.persistence.iface;
import java.util.Collection;

import com.farmacia.domain.Proveedor;
/** 
 * @author SPEEDY
 * Interface que define los métodos de acceso principales a la base de datos 
 */
public interface IProveedorDao {

	/**se genera
	 * Insertar registro en Base de datos
	 * @param com.farmacia.domain.Proveedor proveedor
	 */
	public void insertProveedor(com.farmacia.domain.Proveedor proveedor);

	/**
	 * Actualizar registro en base de datos
 	 * @param java.math.BigDecimal idproveedor
	 * @param com.farmacia.domain.Proveedor proveedor
	 */
	public void updateProveedor(com.farmacia.domain.Proveedor proveedor);

	/**
	 * Eliminar un registro de la base de datos
 	 * @param java.math.BigDecimal idproveedor
	 */
	public void deleteProveedor(com.farmacia.domain.Proveedor proveedor);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idproveedor
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Proveedor getProveedor(com.farmacia.domain.Proveedor proveedor);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idproveedor
	 * @return java.lang.String (XML resultante)
	 */
	public java.lang.String getProveedorXmlString(java.math.BigDecimal idproveedor);

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Collection getProveedorList();
	
	public com.ibatis.common.util.PaginatedList getProveedorListPag();
	
	public com.ibatis.common.util.PaginatedList getProveedorByName(String nombre);
	
	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList (Objetos java.lang.String con la representación XML del registro)
	 */
	public com.ibatis.common.util.PaginatedList getProveedorListXmlString();
		/**
	 * Consultar el maximo para insertar el siguiente
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMaxProveedorIdproveedor();
		/**
	 * MÉTODOS PERSONALIZADOS A IMPLEMENTAR EN LAS CLASES HIJA
	 */

	

}

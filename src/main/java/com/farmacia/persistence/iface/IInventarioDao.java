package com.farmacia.persistence.iface;
import com.farmacia.domain.Inventario;
/** 
 * @author SPEEDY
 * Interface que define los m?todos de acceso principales a la base de datos 
 */
public interface IInventarioDao {

	/**se genera
	 * Insertar registro en Base de datos
	 * @param com.farmacia.domain.Inventario inventario
	 */
	public void insertInventario(com.farmacia.domain.Inventario inventario);

	/**
	 * Actualizar registro en base de datos
 	 * @param java.math.BigDecimal idinventario
	 * @param com.farmacia.domain.Inventario inventario
	 */
	public void updateInventario(com.farmacia.domain.Inventario inventario);

	/**
	 * Eliminar un registro de la base de datos
 	 * @param java.math.BigDecimal idinventario
	 */
	public void deleteInventario(com.farmacia.domain.Inventario inventario);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idinventario
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Inventario getInventario(com.farmacia.domain.Inventario inventario);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idinventario
	 * @return java.lang.String (XML resultante)
	 */
	public java.lang.String getInventarioXmlString(java.math.BigDecimal idinventario);

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public com.ibatis.common.util.PaginatedList getInventarioList();

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList (Objetos java.lang.String con la representaci?n XML del registro)
	 */
	public com.ibatis.common.util.PaginatedList getInventarioListXmlString();
		/**
	 * Consultar el maximo para insertar el siguiente
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMaxInventarioIdinventario();
		/**
	 * M?TODOS PERSONALIZADOS A IMPLEMENTAR EN LAS CLASES HIJA
	 */

}

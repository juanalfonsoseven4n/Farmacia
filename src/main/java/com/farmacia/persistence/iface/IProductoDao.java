package com.farmacia.persistence.iface;
import com.farmacia.domain.Producto;
/** 
 * @author SPEEDY
 * Interface que define los métodos de acceso principales a la base de datos 
 */
public interface IProductoDao {

	/**se genera
	 * Insertar registro en Base de datos
	 * @param com.farmacia.domain.Producto producto
	 */
	public void insertProducto(com.farmacia.domain.Producto producto);

	/**
	 * Actualizar registro en base de datos
 	 * @param java.math.BigDecimal idproducto
	 * @param com.farmacia.domain.Producto producto
	 */
	public void updateProducto(com.farmacia.domain.Producto producto);

	/**
	 * Eliminar un registro de la base de datos
 	 * @param java.math.BigDecimal idproducto
	 */
	public void deleteProducto(com.farmacia.domain.Producto producto);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idproducto
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Producto getProducto(com.farmacia.domain.Producto producto);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idproducto
	 * @return java.lang.String (XML resultante)
	 */
	public java.lang.String getProductoXmlString(java.math.BigDecimal idproducto);

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public com.ibatis.common.util.PaginatedList getProductoList();

	public com.ibatis.common.util.PaginatedList getProductoByName(String nombre);
	
	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList (Objetos java.lang.String con la representación XML del registro)
	 */
	public com.ibatis.common.util.PaginatedList getProductoListXmlString();
		/**
	 * Consultar el maximo para insertar el siguiente
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMaxProductoIdproducto();
		/**
	 * MÉTODOS PERSONALIZADOS A IMPLEMENTAR EN LAS CLASES HIJA
	 */

	public com.ibatis.common.util.PaginatedList getProductoByBarcode(String barcode);

}

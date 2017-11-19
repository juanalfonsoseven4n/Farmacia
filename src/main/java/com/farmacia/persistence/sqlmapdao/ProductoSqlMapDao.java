package com.farmacia.persistence.sqlmapdao;

/**
 * Clase que implementa los métodos definidos en la interface correspondiente a 'ProductoDao' 
 *    y extiende la plantilla de acceso a la base de datos 'SqlMapDaoTemplate'
 * @author .
 */
public class ProductoSqlMapDao extends DAO implements com.farmacia.persistence.iface.IProductoDao {

	/**
	 * Definición de constructor de superclase
	 * @param daoManager
	 */
	public ProductoSqlMapDao(com.ibatis.dao.client.DaoManager daoManager) {
		super(daoManager);
	}

	/**
	 * Implementación del método básico de inserción de un registro en la base de datos.
	 * @param com.farmacia.domain.Producto
	 */
	public void insertProducto(com.farmacia.domain.Producto producto) {
		insert("insertProducto", producto);
	}

	/**
	 * Implementación del método básico de actualización de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Producto)
	 * @param com.farmacia.domain.Producto
	 */
	public void updateProducto( com.farmacia.domain.Producto producto) {
		update("updateProducto", producto);
	}

	/**
	 * Implementación del método básico de borrado de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Producto) 
	 */
	public void deleteProducto(com.farmacia.domain.Producto producto) {
		delete("deleteProducto", producto);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna un objeto con la misma estructura del registro de la tabla.
	 * @param java.math.BigDecimal (llave primaria de Producto)
	 * @return com.farmacia.domain.Producto (Objeto mapeado directamente de la BD) 
	 */
	public com.farmacia.domain.Producto getProducto(com.farmacia.domain.Producto producto) {
		return (com.farmacia.domain.Producto) queryForObject("getProducto", producto);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna una cadena con la estructura XML del registro de la tabla.
	 * @param int (llave primaria de Pv_header)
	 * @return java.lang.String (Cadena de texto XML mapeada directamente de la BD) 
	 */
	public String getProductoXmlString(java.math.BigDecimal idproducto) {
		return (String) queryForObject("getProductoXmlString", idproducto);
	}

	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getProductoList() {
		return queryForPaginatedList("getProductoList", null, Integer.parseInt( PAGE_SIZE));
	}
	
	public com.ibatis.common.util.PaginatedList getProductoByName(String nombre) {
		return queryForPaginatedList("getProductoByName", nombre, Integer.parseInt( PAGE_SIZE));
	}
	
	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'java.lang.String' 
	 *                                               correspondientes a estructuras XML de 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getProductoListXmlString() {
		return queryForPaginatedList("getProductoListXmlString", null, Integer.parseInt( PAGE_SIZE));
	}
		/**
	 * Implementación del método básico que consulta el registro maximo en la tabla 	 
	 * @return java.math.BigDecimal 
	 */
	public java.math.BigDecimal  getMaxProductoIdproducto() {
		return (java.math.BigDecimal)queryForObject("getMaxProductoIdproducto", null);
	}
		/**
	 * MÉTODOS PERSONALIZADOS DE ACCESO A LA BASE DE DATOS:	 
	 */

	public com.ibatis.common.util.PaginatedList getProductoByBarcode(String barcode){
		return queryForPaginatedList("getProductoByBarcode", barcode, Integer.parseInt( PAGE_SIZE));
	}
}
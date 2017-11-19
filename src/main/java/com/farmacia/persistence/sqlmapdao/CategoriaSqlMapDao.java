package com.farmacia.persistence.sqlmapdao;

import java.util.Collection;
/**
 * Clase que implementa los m�todos definidos en la interface correspondiente a 'LaboratorioDao' 
 *    y extiende la plantilla de acceso a la base de datos 'SqlMapDaoTemplate'
 * @author .
 */
public class CategoriaSqlMapDao extends DAO implements com.farmacia.persistence.iface.ICategoriaDao {

	/**
	 * Definici�n de constructor de superclase
	 * @param daoManager
	 */
	public CategoriaSqlMapDao(com.ibatis.dao.client.DaoManager daoManager) {
		super(daoManager);
	}

	/**
	 * Implementaci�n del m�todo b�sico de inserci�n de un registro en la base de datos.
	 * @param com.farmacia.domain.Categoria
	 */
	public void insertCategoria(com.farmacia.domain.Categoria categoria) {
		insert("insertCategoria", categoria);
	}

	/**
	 * Implementaci�n del m�todo b�sico de actualizaci�n de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Categoria)
	 * @param com.farmacia.domain.Categoria
	 */
	public void updateCategoria( com.farmacia.domain.Categoria categoria) {
		update("updateCategoria", categoria);
	}

	/**
	 * Implementaci�n del m�todo b�sico de borrado de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Categoria) 
	 */
	public void deleteCategoria(com.farmacia.domain.Categoria categoria) {
		delete("deleteCategoria", categoria);
	}

	/**
	 * Implementaci�n del m�todo b�sico de consulta por llave primaria de un registro en la base de datos
	 * Retorna un objeto con la misma estructura del registro de la tabla.
	 * @param java.math.BigDecimal (llave primaria de Categoria)
	 * @return com.farmacia.domain.Categoria (Objeto mapeado directamente de la BD) 
	 */
	public com.farmacia.domain.Categoria getCategoria(com.farmacia.domain.Categoria categoria) {
		return (com.farmacia.domain.Categoria) queryForObject("getCategoria", categoria);
	}

	/**
	 * Implementaci�n del m�todo b�sico de consulta por llave primaria de un registro en la base de datos
	 * Retorna una cadena con la estructura XML del registro de la tabla.
	 * @param int (llave primaria de Pv_header)
	 * @return java.lang.String (Cadena de texto XML mapeada directamente de la BD) 
	 */
	public String getCategoriaXmlString(java.math.BigDecimal idcategoria) {
		return (String) queryForObject("getCategoriaXmlString", idcategoria);
	}

	/**
	 * Implementaci�n del m�todo b�sico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public Collection getCategoriaList() {
		return queryForList("getCategoriaList", null);
	}

	public com.ibatis.common.util.PaginatedList getCategoriaListPag() {
		return queryForPaginatedList("getCategoriaList", null, Integer.parseInt( PAGE_SIZE));
	}
	
	public com.ibatis.common.util.PaginatedList getCategoriaByName(String nombre) {
		return queryForPaginatedList("getCategoriaByName", nombre, Integer.parseInt( PAGE_SIZE));
	}
	/**
	 * Implementaci�n del m�todo b�sico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'java.lang.String' 
	 *                                               correspondientes a estructuras XML de 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getCategoriaListXmlString() {
		return queryForPaginatedList("getCategoriaListXmlString", null, Integer.parseInt( PAGE_SIZE));
	}
		/**
	 * Implementaci�n del m�todo b�sico que consulta el registro maximo en la tabla 	 
	 * @return java.math.BigDecimal 
	 */
	public java.math.BigDecimal  getMaxCategoriaIdcategoria() {
		return (java.math.BigDecimal)queryForObject("getMaxCategoriaIdcategoria", null);
	}
		/**
	 * M�TODOS PERSONALIZADOS DE ACCESO A LA BASE DE DATOS:	 
	 */

}
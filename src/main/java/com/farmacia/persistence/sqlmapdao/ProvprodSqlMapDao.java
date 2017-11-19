package com.farmacia.persistence.sqlmapdao;

import java.math.BigDecimal;
import java.util.Collection;
/**
 * Clase que implementa los métodos definidos en la interface correspondiente a 'ProvprodDao' 
 *    y extiende la plantilla de acceso a la base de datos 'SqlMapDaoTemplate'
 * @author .
 */
public class ProvprodSqlMapDao extends DAO implements com.farmacia.persistence.iface.IProvprodDao {

	/**
	 * Definición de constructor de superclase
	 * @param daoManager
	 */
	public ProvprodSqlMapDao(com.ibatis.dao.client.DaoManager daoManager) {
		super(daoManager);
	}

	/**
	 * Implementación del método básico de inserción de un registro en la base de datos.
	 * @param com.farmacia.domain.Provprod
	 */
	public void insertProvprod(com.farmacia.domain.Provprod provprod) {
		insert("insertProvprod", provprod);
	}

	/**
	 * Implementación del método básico de actualización de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Provprod)
	 * @param com.farmacia.domain.Provprod
	 */
	public void updateProvprod( com.farmacia.domain.Provprod provprod) {
		update("updateProvprod", provprod);
	}

	/**
	 * Implementación del método básico de borrado de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Provprod) 
	 */
	public void deleteProvprod(com.farmacia.domain.Provprod provprod) {
		delete("deleteProvprod", provprod);
	}
	public void deleteProvprodByProd(java.math.BigDecimal idproducto){
		delete("deleteProvprodByProd", idproducto);
	}
	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna un objeto con la misma estructura del registro de la tabla.
	 * @param java.math.BigDecimal (llave primaria de Provprod)
	 * @return com.farmacia.domain.Provprod (Objeto mapeado directamente de la BD) 
	 */
	public com.farmacia.domain.Provprod getProvprod(com.farmacia.domain.Provprod provprod) {
		return (com.farmacia.domain.Provprod) queryForObject("getProvprod", provprod);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna una cadena con la estructura XML del registro de la tabla.
	 * @param int (llave primaria de Pv_header)
	 * @return java.lang.String (Cadena de texto XML mapeada directamente de la BD) 
	 */
	public String getProvprodXmlString(java.math.BigDecimal idprovprod) {
		return (String) queryForObject("getProvprodXmlString", idprovprod);
	}

	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getProvprodList() {
		return queryForPaginatedList("getProvprodList", null, Integer.parseInt( PAGE_SIZE));
	}
	
	public Collection getProvprodList(BigDecimal idproducto) {
		return queryForList("getProvprodByProd", idproducto);
	}
	
	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'java.lang.String' 
	 *                                               correspondientes a estructuras XML de 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getProvprodListXmlString() {
		return queryForPaginatedList("getProvprodListXmlString", null, Integer.parseInt( PAGE_SIZE));
	}
		/**
	 * Implementación del método básico que consulta el registro maximo en la tabla 	 
	 * @return java.math.BigDecimal 
	 */
	public java.math.BigDecimal  getMaxProvprodIdprovprod() {
		return (java.math.BigDecimal)queryForObject("getMaxProvprodIdprovprod", null);
	}
		/**
	 * MÉTODOS PERSONALIZADOS DE ACCESO A LA BASE DE DATOS:	 
	 */

}
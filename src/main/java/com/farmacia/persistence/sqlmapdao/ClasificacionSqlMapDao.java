package com.farmacia.persistence.sqlmapdao;

import java.util.Collection;
/**
 * Clase que implementa los métodos definidos en la interface correspondiente a 'LaboratorioDao' 
 *    y extiende la plantilla de acceso a la base de datos 'SqlMapDaoTemplate'
 * @author .
 */
public class ClasificacionSqlMapDao extends DAO implements com.farmacia.persistence.iface.IClasificacionDao {

	/**
	 * Definición de constructor de superclase
	 * @param daoManager
	 */
	public ClasificacionSqlMapDao(com.ibatis.dao.client.DaoManager daoManager) {
		super(daoManager);
	}

	/**
	 * Implementación del método básico de inserción de un registro en la base de datos.
	 * @param com.farmacia.domain.Clasificacion
	 */
	public void insertClasificacion(com.farmacia.domain.Clasificacion clasificacion) {
		insert("insertClasificacion", clasificacion);
	}

	/**
	 * Implementación del método básico de actualización de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Clasificacion)
	 * @param com.farmacia.domain.Clasificacion
	 */
	public void updateClasificacion( com.farmacia.domain.Clasificacion clasificacion) {
		update("updateClasificacion", clasificacion);
	}

	/**
	 * Implementación del método básico de borrado de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Clasificacion) 
	 */
	public void deleteClasificacion(com.farmacia.domain.Clasificacion clasificacion) {
		delete("deleteClasificacion", clasificacion);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna un objeto con la misma estructura del registro de la tabla.
	 * @param java.math.BigDecimal (llave primaria de Clasificacion)
	 * @return com.farmacia.domain.Clasificacion (Objeto mapeado directamente de la BD) 
	 */
	public com.farmacia.domain.Clasificacion getClasificacion(com.farmacia.domain.Clasificacion clasificacion) {
		return (com.farmacia.domain.Clasificacion) queryForObject("getClasificacion", clasificacion);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna una cadena con la estructura XML del registro de la tabla.
	 * @param int (llave primaria de Pv_header)
	 * @return java.lang.String (Cadena de texto XML mapeada directamente de la BD) 
	 */
	public String getClasificacionXmlString(java.math.BigDecimal idclasificacion) {
		return (String) queryForObject("getClasificacionXmlString", idclasificacion);
	}

	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public Collection getClasificacionList() {
		return queryForList("getClasificacionList", null);
	}

	public com.ibatis.common.util.PaginatedList getClasificacionListPag() {
		return queryForPaginatedList("getClasificacionList", null, Integer.parseInt( PAGE_SIZE));
	}
	
	public com.ibatis.common.util.PaginatedList getClasificacionByName(String nombre) {
		return queryForPaginatedList("getClasificacionByName", nombre, Integer.parseInt( PAGE_SIZE));
	}
	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'java.lang.String' 
	 *                                               correspondientes a estructuras XML de 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getClasificacionListXmlString() {
		return queryForPaginatedList("getClasificacionListXmlString", null, Integer.parseInt( PAGE_SIZE));
	}
		/**
	 * Implementación del método básico que consulta el registro maximo en la tabla 	 
	 * @return java.math.BigDecimal 
	 */
	public java.math.BigDecimal  getMaxClasificacionIdclasificacion() {
		return (java.math.BigDecimal)queryForObject("getMaxClasificacionIdclasificacion", null);
	}
		/**
	 * MÉTODOS PERSONALIZADOS DE ACCESO A LA BASE DE DATOS:	 
	 */

}
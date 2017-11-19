package com.farmacia.persistence.sqlmapdao;

import java.util.Collection;
/**
 * Clase que implementa los m�todos definidos en la interface correspondiente a 'LaboratorioDao' 
 *    y extiende la plantilla de acceso a la base de datos 'SqlMapDaoTemplate'
 * @author .
 */
public class LaboratorioSqlMapDao extends DAO implements com.farmacia.persistence.iface.ILaboratorioDao {

	/**
	 * Definici�n de constructor de superclase
	 * @param daoManager
	 */
	public LaboratorioSqlMapDao(com.ibatis.dao.client.DaoManager daoManager) {
		super(daoManager);
	}

	/**
	 * Implementaci�n del m�todo b�sico de inserci�n de un registro en la base de datos.
	 * @param com.farmacia.domain.Laboratorio
	 */
	public void insertLaboratorio(com.farmacia.domain.Laboratorio laboratorio) {
		insert("insertLaboratorio", laboratorio);
	}

	/**
	 * Implementaci�n del m�todo b�sico de actualizaci�n de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Laboratorio)
	 * @param com.farmacia.domain.Laboratorio
	 */
	public void updateLaboratorio( com.farmacia.domain.Laboratorio laboratorio) {
		update("updateLaboratorio", laboratorio);
	}

	/**
	 * Implementaci�n del m�todo b�sico de borrado de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Laboratorio) 
	 */
	public void deleteLaboratorio(com.farmacia.domain.Laboratorio laboratorio) {
		delete("deleteLaboratorio", laboratorio);
	}

	/**
	 * Implementaci�n del m�todo b�sico de consulta por llave primaria de un registro en la base de datos
	 * Retorna un objeto con la misma estructura del registro de la tabla.
	 * @param java.math.BigDecimal (llave primaria de Laboratorio)
	 * @return com.farmacia.domain.Laboratorio (Objeto mapeado directamente de la BD) 
	 */
	public com.farmacia.domain.Laboratorio getLaboratorio(com.farmacia.domain.Laboratorio laboratorio) {
		return (com.farmacia.domain.Laboratorio) queryForObject("getLaboratorio", laboratorio);
	}

	/**
	 * Implementaci�n del m�todo b�sico de consulta por llave primaria de un registro en la base de datos
	 * Retorna una cadena con la estructura XML del registro de la tabla.
	 * @param int (llave primaria de Pv_header)
	 * @return java.lang.String (Cadena de texto XML mapeada directamente de la BD) 
	 */
	public String getLaboratorioXmlString(java.math.BigDecimal idlaboratorio) {
		return (String) queryForObject("getLaboratorioXmlString", idlaboratorio);
	}

	/**
	 * Implementaci�n del m�todo b�sico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public Collection getLaboratorioList() {
		return queryForList("getLaboratorioList", null);
	}

	public com.ibatis.common.util.PaginatedList getLaboratorioListPag() {
		return queryForPaginatedList("getLaboratorioList", null, Integer.parseInt( PAGE_SIZE));
	}
	
	public com.ibatis.common.util.PaginatedList getLaboratorioByName(String nombre) {
		return queryForPaginatedList("getLaboratorioByName", nombre, Integer.parseInt( PAGE_SIZE));
	}
	/**
	 * Implementaci�n del m�todo b�sico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'java.lang.String' 
	 *                                               correspondientes a estructuras XML de 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getLaboratorioListXmlString() {
		return queryForPaginatedList("getLaboratorioListXmlString", null, Integer.parseInt( PAGE_SIZE));
	}
		/**
	 * Implementaci�n del m�todo b�sico que consulta el registro maximo en la tabla 	 
	 * @return java.math.BigDecimal 
	 */
	public java.math.BigDecimal  getMaxLaboratorioIdlaboratorio() {
		return (java.math.BigDecimal)queryForObject("getMaxLaboratorioIdlaboratorio", null);
	}
		/**
	 * M�TODOS PERSONALIZADOS DE ACCESO A LA BASE DE DATOS:	 
	 */

}
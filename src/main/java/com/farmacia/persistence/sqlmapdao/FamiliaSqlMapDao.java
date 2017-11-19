package com.farmacia.persistence.sqlmapdao;

import java.math.BigDecimal;
import java.util.HashMap;

import com.farmacia.util.Constants;
/**
 * Clase que implementa los m�todos definidos en la interface correspondiente a 'FamiliaDao' 
 *    y extiende la plantilla de acceso a la base de datos 'SqlMapDaoTemplate'
 * @author .
 */
public class FamiliaSqlMapDao extends DAO implements com.farmacia.persistence.iface.IFamiliaDao {

	/**
	 * Definici�n de constructor de superclase
	 * @param daoManager
	 */
	public FamiliaSqlMapDao(com.ibatis.dao.client.DaoManager daoManager) {
		super(daoManager);
	}

	/**
	 * Implementaci�n del m�todo b�sico de inserci�n de un registro en la base de datos.
	 * @param com.farmacia.domain.Familia
	 */
	public void insertFamilia(com.farmacia.domain.Familia familia) {
		HashMap datosseq = new HashMap();
		datosseq.put(Constants.SEQNAME,  "idfamilia");
		datosseq.put(Constants.TABLENAME,  "familia");
		Long id = getNext(datosseq);
		familia.setIdfamilia(new BigDecimal(id.longValue()));
		insert("insertFamilia", familia);
	}

	/**
	 * Implementaci�n del m�todo b�sico de actualizaci�n de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Familia)
	 * @param com.farmacia.domain.Familia
	 */
	public void updateFamilia( com.farmacia.domain.Familia familia) {
		update("updateFamilia", familia);
	}

	/**
	 * Implementaci�n del m�todo b�sico de borrado de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Familia) 
	 */
	public void deleteFamilia(com.farmacia.domain.Familia familia) {
		delete("deleteFamilia", familia);
	}

	/**
	 * Implementaci�n del m�todo b�sico de consulta por llave primaria de un registro en la base de datos
	 * Retorna un objeto con la misma estructura del registro de la tabla.
	 * @param java.math.BigDecimal (llave primaria de Familia)
	 * @return com.farmacia.domain.Familia (Objeto mapeado directamente de la BD) 
	 */
	public com.farmacia.domain.Familia getFamilia(com.farmacia.domain.Familia familia) {
		return (com.farmacia.domain.Familia) queryForObject("getFamilia", familia);
	}

	/**
	 * Implementaci�n del m�todo b�sico de consulta por llave primaria de un registro en la base de datos
	 * Retorna una cadena con la estructura XML del registro de la tabla.
	 * @param int (llave primaria de Pv_header)
	 * @return java.lang.String (Cadena de texto XML mapeada directamente de la BD) 
	 */
	public String getFamiliaXmlString(java.math.BigDecimal idfamilia) {
		return (String) queryForObject("getFamiliaXmlString", idfamilia);
	}

	/**
	 * Implementaci�n del m�todo b�sico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getFamiliaList() {
		return queryForPaginatedList("getFamiliaList", null, Integer.parseInt( PAGE_SIZE));
	}
	
	public com.ibatis.common.util.PaginatedList getFamiliaByName(String nombre) {
		return queryForPaginatedList("getFamiliaByName", nombre, Integer.parseInt( PAGE_SIZE));
	}
	/**
	 * Implementaci�n del m�todo b�sico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'java.lang.String' 
	 *                                               correspondientes a estructuras XML de 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getFamiliaListXmlString() {
		return queryForPaginatedList("getFamiliaListXmlString", null, Integer.parseInt( PAGE_SIZE));
	}
		/**
	 * Implementaci�n del m�todo b�sico que consulta el registro maximo en la tabla 	 
	 * @return java.math.BigDecimal 
	 */
	public java.math.BigDecimal  getMaxFamiliaIdfamilia() {
		return (java.math.BigDecimal)queryForObject("getMaxFamiliaIdfamilia", null);
	}
		/**
	 * M�TODOS PERSONALIZADOS DE ACCESO A LA BASE DE DATOS:	 
	 */

}
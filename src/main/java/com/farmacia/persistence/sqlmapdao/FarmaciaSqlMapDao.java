package com.farmacia.persistence.sqlmapdao;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;

import com.farmacia.util.Constants;
/**
 * Clase que implementa los métodos definidos en la interface correspondiente a 'FarmaciaDao' 
 *    y extiende la plantilla de acceso a la base de datos 'SqlMapDaoTemplate'
 * @author .
 */
public class FarmaciaSqlMapDao extends DAO implements com.farmacia.persistence.iface.IFarmaciaDao {

	/**
	 * Definición de constructor de superclase
	 * @param daoManager
	 */
	public FarmaciaSqlMapDao(com.ibatis.dao.client.DaoManager daoManager) {
		super(daoManager);
	}

	/**
	 * Implementación del método básico de inserción de un registro en la base de datos.
	 * @param com.farmacia.domain.Farmacia
	 */
	public void insertFarmacia(com.farmacia.domain.Farmacia farmacia) {
		HashMap datosseq = new HashMap();
		datosseq.put(Constants.SEQNAME,  "idfarmacia");
		datosseq.put(Constants.TABLENAME,  "farmacia");
		Long id = getNext(datosseq);
		farmacia.setIdfarmacia(new BigDecimal(id.longValue()));
		insert("insertFarmacia", farmacia);
	}

	/**
	 * Implementación del método básico de actualización de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Farmacia)
	 * @param com.farmacia.domain.Farmacia
	 */
	public void updateFarmacia( com.farmacia.domain.Farmacia farmacia) {
		update("updateFarmacia", farmacia);
	}

	/**
	 * Implementación del método básico de borrado de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Farmacia) 
	 */
	public void deleteFarmacia(com.farmacia.domain.Farmacia farmacia) {
		delete("deleteFarmacia", farmacia);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna un objeto con la misma estructura del registro de la tabla.
	 * @param java.math.BigDecimal (llave primaria de Farmacia)
	 * @return com.farmacia.domain.Farmacia (Objeto mapeado directamente de la BD) 
	 */
	public com.farmacia.domain.Farmacia getFarmacia(com.farmacia.domain.Farmacia farmacia) {
		return (com.farmacia.domain.Farmacia) queryForObject("getFarmacia", farmacia);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna una cadena con la estructura XML del registro de la tabla.
	 * @param int (llave primaria de Pv_header)
	 * @return java.lang.String (Cadena de texto XML mapeada directamente de la BD) 
	 */
	public String getFarmaciaXmlString(java.math.BigDecimal idfarmacia) {
		return (String) queryForObject("getFarmaciaXmlString", idfarmacia);
	}

	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public Collection getFarmaciaListPag() {
		return queryForPaginatedList("getFarmaciaList", null, Integer.parseInt( PAGE_SIZE));
	}
	
	public Collection getFarmaciaList() {
		return queryForList("getFarmaciaList", null);
	}

	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'java.lang.String' 
	 *                                               correspondientes a estructuras XML de 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getFarmaciaListXmlString() {
		return queryForPaginatedList("getFarmaciaListXmlString", null, Integer.parseInt( PAGE_SIZE));
	}
		/**
	 * Implementación del método básico que consulta el registro maximo en la tabla 	 
	 * @return java.math.BigDecimal 
	 */
	public java.math.BigDecimal  getMaxFarmaciaIdfarmacia() {
		return (java.math.BigDecimal)queryForObject("getMaxFarmaciaIdfarmacia", null);
	}
		/**
	 * MÉTODOS PERSONALIZADOS DE ACCESO A LA BASE DE DATOS:	 
	 */

}
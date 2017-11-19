package com.farmacia.persistence.sqlmapdao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.farmacia.util.Constants;
/**
 * Clase que implementa los métodos definidos en la interface correspondiente a 'DetventaDao' 
 *    y extiende la plantilla de acceso a la base de datos 'SqlMapDaoTemplate'
 * @author .
 */
public class DetventaSqlMapDao extends DAO implements com.farmacia.persistence.iface.IDetventaDao {

	/**
	 * Definición de constructor de superclase
	 * @param daoManager
	 */
	public DetventaSqlMapDao(com.ibatis.dao.client.DaoManager daoManager) {
		super(daoManager);
	}

	/**
	 * Implementación del método básico de inserción de un registro en la base de datos.
	 * @param com.farmacia.domain.Detventa
	 */
	public void insertDetventa(com.farmacia.domain.Detventa detventa) {
		HashMap datosseq = new HashMap();
		datosseq.put(Constants.SEQNAME,  "iddetventa");
		datosseq.put(Constants.TABLENAME,  "detventa");
		Long id = getNext(datosseq);
		detventa.setIddetventa(new BigDecimal(id.longValue()));
		insert("insertDetventa", detventa);
	}

	/**
	 * Implementación del método básico de actualización de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Detventa)
	 * @param com.farmacia.domain.Detventa
	 */
	public void updateDetventa( com.farmacia.domain.Detventa detventa) {
		update("updateDetventa", detventa);
	}

	/**
	 * Implementación del método básico de borrado de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Detventa) 
	 */
	public void deleteDetventa(com.farmacia.domain.Detventa detventa) {
		delete("deleteDetventa", detventa);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna un objeto con la misma estructura del registro de la tabla.
	 * @param java.math.BigDecimal (llave primaria de Detventa)
	 * @return com.farmacia.domain.Detventa (Objeto mapeado directamente de la BD) 
	 */
	public com.farmacia.domain.Detventa getDetventa(com.farmacia.domain.Detventa detventa) {
		return (com.farmacia.domain.Detventa) queryForObject("getDetventa", detventa);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna una cadena con la estructura XML del registro de la tabla.
	 * @param int (llave primaria de Pv_header)
	 * @return java.lang.String (Cadena de texto XML mapeada directamente de la BD) 
	 */
	public String getDetventaXmlString(java.math.BigDecimal iddetventa) {
		return (String) queryForObject("getDetventaXmlString", iddetventa);
	}

	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getDetventaList() {
		return queryForPaginatedList("getDetventaList", null, Integer.parseInt( PAGE_SIZE));
	}

	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'java.lang.String' 
	 *                                               correspondientes a estructuras XML de 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getDetventaListXmlString() {
		return queryForPaginatedList("getDetventaListXmlString", null, Integer.parseInt( PAGE_SIZE));
	}
		/**
	 * Implementación del método básico que consulta el registro maximo en la tabla 	 
	 * @return java.math.BigDecimal 
	 */
	public java.math.BigDecimal  getMaxDetventaIddetventa() {
		return (java.math.BigDecimal)queryForObject("getMaxDetventaIddetventa", null);
	}
	
	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public List getDetventaListByVenta(BigDecimal idventa) {
		return queryForList("getDetventaListByVenta", idventa);
	}
	
	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public List getDetventaListByVentaMarked(BigDecimal idventa) {
		return queryForList("getDetventaListByVentaMarked", idventa);
	}
	
		/**
	 * MÉTODOS PERSONALIZADOS DE ACCESO A LA BASE DE DATOS:	 
	 */

}
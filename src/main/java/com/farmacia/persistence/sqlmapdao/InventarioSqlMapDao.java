package com.farmacia.persistence.sqlmapdao;

import java.math.BigDecimal;
import java.util.HashMap;

import com.farmacia.util.Constants;
/**
 * Clase que implementa los métodos definidos en la interface correspondiente a 'InventarioDao' 
 *    y extiende la plantilla de acceso a la base de datos 'SqlMapDaoTemplate'
 * @author .
 */
public class InventarioSqlMapDao extends DAO implements com.farmacia.persistence.iface.IInventarioDao {

	/**
	 * Definición de constructor de superclase
	 * @param daoManager
	 */
	public InventarioSqlMapDao(com.ibatis.dao.client.DaoManager daoManager) {
		super(daoManager);
	}

	/**
	 * Implementación del método básico de inserción de un registro en la base de datos.
	 * @param com.farmacia.domain.Inventario
	 */
	public void insertInventario(com.farmacia.domain.Inventario inventario) {
		HashMap datosseq = new HashMap();
		datosseq.put(Constants.SEQNAME,  "idinventario");
		datosseq.put(Constants.TABLENAME,  "inventario");
		Long id = getNext(datosseq);
		inventario.setIdinventario(new BigDecimal(id.longValue()));
		insert("insertInventario", inventario);
	}

	/**
	 * Implementación del método básico de actualización de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Inventario)
	 * @param com.farmacia.domain.Inventario
	 */
	public void updateInventario( com.farmacia.domain.Inventario inventario) {
		update("updateInventario", inventario);
	}

	/**
	 * Implementación del método básico de borrado de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Inventario) 
	 */
	public void deleteInventario(com.farmacia.domain.Inventario inventario) {
		delete("deleteInventario", inventario);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna un objeto con la misma estructura del registro de la tabla.
	 * @param java.math.BigDecimal (llave primaria de Inventario)
	 * @return com.farmacia.domain.Inventario (Objeto mapeado directamente de la BD) 
	 */
	public com.farmacia.domain.Inventario getInventario(com.farmacia.domain.Inventario inventario) {
		return (com.farmacia.domain.Inventario) queryForObject("getInventario", inventario);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna una cadena con la estructura XML del registro de la tabla.
	 * @param int (llave primaria de Pv_header)
	 * @return java.lang.String (Cadena de texto XML mapeada directamente de la BD) 
	 */
	public String getInventarioXmlString(java.math.BigDecimal idinventario) {
		return (String) queryForObject("getInventarioXmlString", idinventario);
	}

	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getInventarioList() {
		return queryForPaginatedList("getInventarioList", null, Integer.parseInt( PAGE_SIZE));
	}

	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'java.lang.String' 
	 *                                               correspondientes a estructuras XML de 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getInventarioListXmlString() {
		return queryForPaginatedList("getInventarioListXmlString", null, Integer.parseInt( PAGE_SIZE));
	}
		/**
	 * Implementación del método básico que consulta el registro maximo en la tabla 	 
	 * @return java.math.BigDecimal 
	 */
	public java.math.BigDecimal  getMaxInventarioIdinventario() {
		return (java.math.BigDecimal)queryForObject("getMaxInventarioIdinventario", null);
	}
		/**
	 * MÉTODOS PERSONALIZADOS DE ACCESO A LA BASE DE DATOS:	 
	 */

}
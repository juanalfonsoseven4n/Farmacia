package com.farmacia.persistence.sqlmapdao;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;

import com.farmacia.util.Constants;
/**
 * Clase que implementa los métodos definidos en la interface correspondiente a 'OpcionDao' 
 *    y extiende la plantilla de acceso a la base de datos 'SqlMapDaoTemplate'
 * @author .
 */
public class OpcionSqlMapDao extends DAO implements com.farmacia.persistence.iface.IOpcionDao {

	/**
	 * Definición de constructor de superclase
	 * @param daoManager
	 */
	public OpcionSqlMapDao(com.ibatis.dao.client.DaoManager daoManager) {
		super(daoManager);
	}

	/**
	 * Implementación del método básico de inserción de un registro en la base de datos.
	 * @param com.farmacia.domain.Opcion
	 */
	public void insertOpcion(com.farmacia.domain.Opcion opcion) {
		HashMap datosseq = new HashMap();
		datosseq.put(Constants.SEQNAME,  "idopcion");
		datosseq.put(Constants.TABLENAME,  "opcion");
		Long id = getNext(datosseq);
		opcion.setIdopcion(new BigDecimal(id.longValue()));
		insert("insertOpcion", opcion);
	}

	/**
	 * Implementación del método básico de actualización de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Opcion)
	 * @param com.farmacia.domain.Opcion
	 */
	public void updateOpcion( com.farmacia.domain.Opcion opcion) {
		update("updateOpcion", opcion);
	}

	/**
	 * Implementación del método básico de borrado de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Opcion) 
	 */
	public void deleteOpcion(com.farmacia.domain.Opcion opcion) {
		delete("deleteOpcion", opcion);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna un objeto con la misma estructura del registro de la tabla.
	 * @param java.math.BigDecimal (llave primaria de Opcion)
	 * @return com.farmacia.domain.Opcion (Objeto mapeado directamente de la BD) 
	 */
	public com.farmacia.domain.Opcion getOpcion(com.farmacia.domain.Opcion opcion) {
		return (com.farmacia.domain.Opcion) queryForObject("getOpcion", opcion);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna una cadena con la estructura XML del registro de la tabla.
	 * @param int (llave primaria de Pv_header)
	 * @return java.lang.String (Cadena de texto XML mapeada directamente de la BD) 
	 */
	public String getOpcionXmlString(java.math.BigDecimal idopcion) {
		return (String) queryForObject("getOpcionXmlString", idopcion);
	}

	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getOpcionList() {
		return queryForPaginatedList("getOpcionList", null, Integer.parseInt( PAGE_SIZE));
	}

	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'java.lang.String' 
	 *                                               correspondientes a estructuras XML de 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getOpcionListXmlString() {
		return queryForPaginatedList("getOpcionListXmlString", null, Integer.parseInt( PAGE_SIZE));
	}
		/**
	 * Implementación del método básico que consulta el registro maximo en la tabla 	 
	 * @return java.math.BigDecimal 
	 */
	public java.math.BigDecimal  getMaxOpcionIdopcion() {
		return (java.math.BigDecimal)queryForObject("getMaxOpcionIdopcion", null);
	}
		/**
	 * MÉTODOS PERSONALIZADOS DE ACCESO A LA BASE DE DATOS:	 
	 */
	public Collection getOpcionesByMenuPerfil(BigDecimal idperfil, BigDecimal idmenu){
		HashMap map = new HashMap();
		map.put("idperfil", idperfil);
		map.put("idmenu", idmenu);
		return queryForList("getOpcionesByMenuPerfil", map);
	}
}
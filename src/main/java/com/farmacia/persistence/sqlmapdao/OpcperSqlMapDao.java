package com.farmacia.persistence.sqlmapdao;

import java.math.BigDecimal;
import java.util.HashMap;

import com.farmacia.util.Constants;
/**
 * Clase que implementa los m�todos definidos en la interface correspondiente a 'OpcperDao' 
 *    y extiende la plantilla de acceso a la base de datos 'SqlMapDaoTemplate'
 * @author .
 */
public class OpcperSqlMapDao extends DAO implements com.farmacia.persistence.iface.IOpcperDao {

	/**
	 * Definici�n de constructor de superclase
	 * @param daoManager
	 */
	public OpcperSqlMapDao(com.ibatis.dao.client.DaoManager daoManager) {
		super(daoManager);
	}

	/**
	 * Implementaci�n del m�todo b�sico de inserci�n de un registro en la base de datos.
	 * @param com.farmacia.domain.Opcper
	 */
	public void insertOpcper(com.farmacia.domain.Opcper opcper) {
		HashMap datosseq = new HashMap();
		datosseq.put(Constants.SEQNAME,  "idopcper");
		datosseq.put(Constants.TABLENAME,  "opcper");
		Long id = getNext(datosseq);
		opcper.setIdopcper(new BigDecimal(id.longValue()));
		insert("insertOpcper", opcper);
	}

	/**
	 * Implementaci�n del m�todo b�sico de actualizaci�n de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Opcper)
	 * @param com.farmacia.domain.Opcper
	 */
	public void updateOpcper( com.farmacia.domain.Opcper opcper) {
		update("updateOpcper", opcper);
	}

	/**
	 * Implementaci�n del m�todo b�sico de borrado de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Opcper) 
	 */
	public void deleteOpcper(com.farmacia.domain.Opcper opcper) {
		delete("deleteOpcper", opcper);
	}

	/**
	 * Implementaci�n del m�todo b�sico de consulta por llave primaria de un registro en la base de datos
	 * Retorna un objeto con la misma estructura del registro de la tabla.
	 * @param java.math.BigDecimal (llave primaria de Opcper)
	 * @return com.farmacia.domain.Opcper (Objeto mapeado directamente de la BD) 
	 */
	public com.farmacia.domain.Opcper getOpcper(com.farmacia.domain.Opcper opcper) {
		return (com.farmacia.domain.Opcper) queryForObject("getOpcper", opcper);
	}

	/**
	 * Implementaci�n del m�todo b�sico de consulta por llave primaria de un registro en la base de datos
	 * Retorna una cadena con la estructura XML del registro de la tabla.
	 * @param int (llave primaria de Pv_header)
	 * @return java.lang.String (Cadena de texto XML mapeada directamente de la BD) 
	 */
	public String getOpcperXmlString(java.math.BigDecimal idopcper) {
		return (String) queryForObject("getOpcperXmlString", idopcper);
	}

	/**
	 * Implementaci�n del m�todo b�sico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getOpcperList() {
		return queryForPaginatedList("getOpcperList", null, Integer.parseInt( PAGE_SIZE));
	}

	/**
	 * Implementaci�n del m�todo b�sico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'java.lang.String' 
	 *                                               correspondientes a estructuras XML de 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getOpcperListXmlString() {
		return queryForPaginatedList("getOpcperListXmlString", null, Integer.parseInt( PAGE_SIZE));
	}
		/**
	 * Implementaci�n del m�todo b�sico que consulta el registro maximo en la tabla 	 
	 * @return java.math.BigDecimal 
	 */
	public java.math.BigDecimal  getMaxOpcperIdopcper() {
		return (java.math.BigDecimal)queryForObject("getMaxOpcperIdopcper", null);
	}
		/**
	 * M�TODOS PERSONALIZADOS DE ACCESO A LA BASE DE DATOS:	 
	 */

}
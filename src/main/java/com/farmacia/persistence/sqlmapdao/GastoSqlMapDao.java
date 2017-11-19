package com.farmacia.persistence.sqlmapdao;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;

import com.farmacia.form.GastoForm;
import com.farmacia.util.Constants;
/**
 * Clase que implementa los métodos definidos en la interface correspondiente a 'GastoDao' 
 *    y extiende la plantilla de acceso a la base de datos 'SqlMapDaoTemplate'
 * @author .
 */
public class GastoSqlMapDao extends DAO implements com.farmacia.persistence.iface.IGastoDao {

	/**
	 * Definición de constructor de superclase
	 * @param daoManager
	 */
	public GastoSqlMapDao(com.ibatis.dao.client.DaoManager daoManager) {
		super(daoManager);
	}

	/**
	 * Implementación del método básico de inserción de un registro en la base de datos.
	 * @param com.farmacia.domain.Gasto
	 */
	public void insertGasto(com.farmacia.domain.Gasto gasto) {
		HashMap datosseq = new HashMap();
		datosseq.put(Constants.SEQNAME,  "idgasto");
		datosseq.put(Constants.TABLENAME,  "gasto");
		Long id = getNext(datosseq);
		gasto.setIdgasto(new BigDecimal(id.longValue()));
		insert("insertGasto", gasto);
	}

	/**
	 * Implementación del método básico de actualización de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Gasto)
	 * @param com.farmacia.domain.Gasto
	 */
	public void updateGasto( com.farmacia.domain.Gasto gasto) {
		update("updateGasto", gasto);
	}

	/**
	 * Implementación del método básico de borrado de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Gasto) 
	 */
	public void deleteGasto(com.farmacia.domain.Gasto gasto) {
		delete("deleteGasto", gasto);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna un objeto con la misma estructura del registro de la tabla.
	 * @param java.math.BigDecimal (llave primaria de Gasto)
	 * @return com.farmacia.domain.Gasto (Objeto mapeado directamente de la BD) 
	 */
	public com.farmacia.domain.Gasto getGasto(com.farmacia.domain.Gasto gasto) {
		return (com.farmacia.domain.Gasto) queryForObject("getGasto", gasto);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna una cadena con la estructura XML del registro de la tabla.
	 * @param int (llave primaria de Pv_header)
	 * @return java.lang.String (Cadena de texto XML mapeada directamente de la BD) 
	 */
	public String getGastoXmlString(java.math.BigDecimal idgasto) {
		return (String) queryForObject("getGastoXmlString", idgasto);
	}

	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getGastoList() {
		return queryForPaginatedList("getGastoList", null, Integer.parseInt( PAGE_SIZE));
	}

	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'java.lang.String' 
	 *                                               correspondientes a estructuras XML de 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getGastoListXmlString() {
		return queryForPaginatedList("getGastoListXmlString", null, Integer.parseInt( PAGE_SIZE));
	}
		/**
	 * Implementación del método básico que consulta el registro maximo en la tabla 	 
	 * @return java.math.BigDecimal 
	 */
	public java.math.BigDecimal  getMaxGastoIdgasto() {
		return (java.math.BigDecimal)queryForObject("getMaxGastoIdgasto", null);
	}
		/**
	 * MÉTODOS PERSONALIZADOS DE ACCESO A LA BASE DE DATOS:	 
	 */
	public Collection getGastoListFiltro(GastoForm forma) {
		return queryForPaginatedList("getGastoListFiltro", forma, Integer.parseInt( PAGE_SIZE));
	}
}
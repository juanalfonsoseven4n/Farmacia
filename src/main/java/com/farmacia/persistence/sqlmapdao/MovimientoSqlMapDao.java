package com.farmacia.persistence.sqlmapdao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.farmacia.form.MovimientoForm;
import com.farmacia.util.Constants;
/**
 * Clase que implementa los métodos definidos en la interface correspondiente a 'MovimientoDao' 
 *    y extiende la plantilla de acceso a la base de datos 'SqlMapDaoTemplate'
 * @author .
 */
public class MovimientoSqlMapDao extends DAO implements com.farmacia.persistence.iface.IMovimientoDao {

	/**
	 * Definición de constructor de superclase
	 * @param daoManager
	 */
	public MovimientoSqlMapDao(com.ibatis.dao.client.DaoManager daoManager) {
		super(daoManager);
	}

	/**
	 * Implementación del método básico de inserción de un registro en la base de datos.
	 * @param com.farmacia.domain.Movimiento
	 */
	public void insertMovimiento(com.farmacia.domain.Movimiento movimiento) {
		HashMap datosseq = new HashMap();
		datosseq.put(Constants.SEQNAME,  "idmovimiento");
		datosseq.put(Constants.TABLENAME,  "movimiento");
		Long id = getNext(datosseq);
		movimiento.setIdmovimiento(new BigDecimal(id.longValue()));
		insert("insertMovimiento", movimiento);
	}

	/**
	 * Implementación del método básico de actualización de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Movimiento)
	 * @param com.farmacia.domain.Movimiento
	 */
	public void updateMovimiento( com.farmacia.domain.Movimiento movimiento) {
		update("updateMovimiento", movimiento);
	}

	/**
	 * Implementación del método básico de borrado de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Movimiento) 
	 */
	public void deleteMovimiento(com.farmacia.domain.Movimiento movimiento) {
		delete("deleteMovimiento", movimiento);
	}

	public void deleteMovimientoByDetVenta(java.math.BigDecimal iddetventa) {
		delete("deleteMovimientoByDetVenta", iddetventa);
	}
	
	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna un objeto con la misma estructura del registro de la tabla.
	 * @param java.math.BigDecimal (llave primaria de Movimiento)
	 * @return com.farmacia.domain.Movimiento (Objeto mapeado directamente de la BD) 
	 */
	public com.farmacia.domain.Movimiento getMovimiento(com.farmacia.domain.Movimiento movimiento) {
		return (com.farmacia.domain.Movimiento) queryForObject("getMovimiento", movimiento);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna una cadena con la estructura XML del registro de la tabla.
	 * @param int (llave primaria de Pv_header)
	 * @return java.lang.String (Cadena de texto XML mapeada directamente de la BD) 
	 */
	public String getMovimientoXmlString(java.math.BigDecimal idmovimiento) {
		return (String) queryForObject("getMovimientoXmlString", idmovimiento);
	}

	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getMovimientoList() {
		return queryForPaginatedList("getMovimientoList", null, Integer.parseInt( PAGE_SIZE));
	}
	
	public com.ibatis.common.util.PaginatedList getMovimientosFiltrados(MovimientoForm form) {
		return queryForPaginatedList("getMovimientosFiltradosList", form, Integer.parseInt( PAGE_SIZE));
	}
	
	public List getMovimientosFiltradosList(MovimientoForm form) {
		return queryForList("getMovimientosFiltradosList", form);
	}
	public List getMovimientosCuarentena() {
		return queryForList("getMovimientosCuarentena", null);
	}
	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'java.lang.String' 
	 *                                               correspondientes a estructuras XML de 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getMovimientoListXmlString() {
		return queryForPaginatedList("getMovimientoListXmlString", null, Integer.parseInt( PAGE_SIZE));
	}
		/**
	 * Implementación del método básico que consulta el registro maximo en la tabla 	 
	 * @return java.math.BigDecimal 
	 */
	public java.math.BigDecimal  getMaxMovimientoIdmovimiento() {
		return (java.math.BigDecimal)queryForObject("getMaxMovimientoIdmovimiento", null);
	}
		/**
	 * MÉTODOS PERSONALIZADOS DE ACCESO A LA BASE DE DATOS:	 
	 */
	public List getMovimientosConsolByProdTipo(MovimientoForm form) {
		return queryForPaginatedList("getMovimientosConsByProdTipoProd", form, Integer.parseInt( PAGE_SIZE));
	}
	
	public List getMovimientosConsolByProd(MovimientoForm form) {
		return queryForList("getMovimientosConsByProdTipoProd", form);
	}
}
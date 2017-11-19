package com.farmacia.persistence.iface;
import java.util.Collection;

import com.farmacia.domain.Gasto;
import com.farmacia.form.GastoForm;
/** 
 * @author SPEEDY
 * Interface que define los métodos de acceso principales a la base de datos 
 */
public interface IGastoDao {

	/**se genera
	 * Insertar registro en Base de datos
	 * @param com.farmacia.domain.Gasto gasto
	 */
	public void insertGasto(com.farmacia.domain.Gasto gasto);

	/**
	 * Actualizar registro en base de datos
 	 * @param java.math.BigDecimal idgasto
	 * @param com.farmacia.domain.Gasto gasto
	 */
	public void updateGasto(com.farmacia.domain.Gasto gasto);

	/**
	 * Eliminar un registro de la base de datos
 	 * @param java.math.BigDecimal idgasto
	 */
	public void deleteGasto(com.farmacia.domain.Gasto gasto);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idgasto
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Gasto getGasto(com.farmacia.domain.Gasto gasto);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idgasto
	 * @return java.lang.String (XML resultante)
	 */
	public java.lang.String getGastoXmlString(java.math.BigDecimal idgasto);

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public com.ibatis.common.util.PaginatedList getGastoList();

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList (Objetos java.lang.String con la representación XML del registro)
	 */
	public com.ibatis.common.util.PaginatedList getGastoListXmlString();
		/**
	 * Consultar el maximo para insertar el siguiente
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMaxGastoIdgasto();
		/**
	 * MÉTODOS PERSONALIZADOS A IMPLEMENTAR EN LAS CLASES HIJA
	 */

	public Collection getGastoListFiltro(GastoForm forma);

}

package com.farmacia.persistence.iface;
import java.math.BigDecimal;
import java.util.List;

import com.farmacia.domain.Detventa;
/** 
 * @author SPEEDY
 * Interface que define los métodos de acceso principales a la base de datos 
 */
public interface IDetventaDao {

	/**se genera
	 * Insertar registro en Base de datos
	 * @param com.farmacia.domain.Detventa detventa
	 */
	public void insertDetventa(com.farmacia.domain.Detventa detventa);

	/**
	 * Actualizar registro en base de datos
 	 * @param java.math.BigDecimal iddetventa
	 * @param com.farmacia.domain.Detventa detventa
	 */
	public void updateDetventa(com.farmacia.domain.Detventa detventa);

	/**
	 * Eliminar un registro de la base de datos
 	 * @param java.math.BigDecimal iddetventa
	 */
	public void deleteDetventa(com.farmacia.domain.Detventa detventa);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal iddetventa
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Detventa getDetventa(com.farmacia.domain.Detventa detventa);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal iddetventa
	 * @return java.lang.String (XML resultante)
	 */
	public java.lang.String getDetventaXmlString(java.math.BigDecimal iddetventa);

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public com.ibatis.common.util.PaginatedList getDetventaList();

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList (Objetos java.lang.String con la representación XML del registro)
	 */
	public com.ibatis.common.util.PaginatedList getDetventaListXmlString();
		/**
	 * Consultar el maximo para insertar el siguiente
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMaxDetventaIddetventa();
	
	public List getDetventaListByVenta(BigDecimal idventa);
	
	public List getDetventaListByVentaMarked(BigDecimal idventa);
		/**
	 * MÉTODOS PERSONALIZADOS A IMPLEMENTAR EN LAS CLASES HIJA
	 */

}

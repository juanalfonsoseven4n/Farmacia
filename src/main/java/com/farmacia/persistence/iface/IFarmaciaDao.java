package com.farmacia.persistence.iface;
import java.util.Collection;

import com.farmacia.domain.Farmacia;
/** 
 * @author SPEEDY
 * Interface que define los métodos de acceso principales a la base de datos 
 */
public interface IFarmaciaDao {

	/**se genera
	 * Insertar registro en Base de datos
	 * @param com.farmacia.domain.Farmacia farmacia
	 */
	public void insertFarmacia(com.farmacia.domain.Farmacia farmacia);

	/**
	 * Actualizar registro en base de datos
 	 * @param java.math.BigDecimal idfarmacia
	 * @param com.farmacia.domain.Farmacia farmacia
	 */
	public void updateFarmacia(com.farmacia.domain.Farmacia farmacia);

	/**
	 * Eliminar un registro de la base de datos
 	 * @param java.math.BigDecimal idfarmacia
	 */
	public void deleteFarmacia(com.farmacia.domain.Farmacia farmacia);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idfarmacia
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Farmacia getFarmacia(com.farmacia.domain.Farmacia farmacia);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idfarmacia
	 * @return java.lang.String (XML resultante)
	 */
	public java.lang.String getFarmaciaXmlString(java.math.BigDecimal idfarmacia);

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Collection getFarmaciaListPag();

	
	public Collection getFarmaciaList();

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList (Objetos java.lang.String con la representación XML del registro)
	 */
	public com.ibatis.common.util.PaginatedList getFarmaciaListXmlString();
		/**
	 * Consultar el maximo para insertar el siguiente
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMaxFarmaciaIdfarmacia();
		/**
	 * MÉTODOS PERSONALIZADOS A IMPLEMENTAR EN LAS CLASES HIJA
	 */

}

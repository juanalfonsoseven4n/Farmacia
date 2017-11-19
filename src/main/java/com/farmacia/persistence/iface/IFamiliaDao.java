package com.farmacia.persistence.iface;
import com.farmacia.domain.Familia;
/** 
 * @author SPEEDY
 * Interface que define los métodos de acceso principales a la base de datos 
 */
public interface IFamiliaDao {

	/**se genera
	 * Insertar registro en Base de datos
	 * @param com.farmacia.domain.Familia familia
	 */
	public void insertFamilia(com.farmacia.domain.Familia familia);

	/**
	 * Actualizar registro en base de datos
 	 * @param java.math.BigDecimal idfamilia
	 * @param com.farmacia.domain.Familia familia
	 */
	public void updateFamilia(com.farmacia.domain.Familia familia);

	/**
	 * Eliminar un registro de la base de datos
 	 * @param java.math.BigDecimal idfamilia
	 */
	public void deleteFamilia(com.farmacia.domain.Familia familia);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idfamilia
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Familia getFamilia(com.farmacia.domain.Familia familia);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idfamilia
	 * @return java.lang.String (XML resultante)
	 */
	public java.lang.String getFamiliaXmlString(java.math.BigDecimal idfamilia);

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public com.ibatis.common.util.PaginatedList getFamiliaList();

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public com.ibatis.common.util.PaginatedList getFamiliaByName(String nombre);
	
	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList (Objetos java.lang.String con la representación XML del registro)
	 */
	public com.ibatis.common.util.PaginatedList getFamiliaListXmlString();
		/**
	 * Consultar el maximo para insertar el siguiente
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMaxFamiliaIdfamilia();
		/**
	 * MÉTODOS PERSONALIZADOS A IMPLEMENTAR EN LAS CLASES HIJA
	 */

}

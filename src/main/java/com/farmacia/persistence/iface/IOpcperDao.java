package com.farmacia.persistence.iface;
import com.farmacia.domain.Opcper;
/** 
 * @author SPEEDY
 * Interface que define los métodos de acceso principales a la base de datos 
 */
public interface IOpcperDao {

	/**se genera
	 * Insertar registro en Base de datos
	 * @param com.farmacia.domain.Opcper opcper
	 */
	public void insertOpcper(com.farmacia.domain.Opcper opcper);

	/**
	 * Actualizar registro en base de datos
 	 * @param java.math.BigDecimal idopcper
	 * @param com.farmacia.domain.Opcper opcper
	 */
	public void updateOpcper(com.farmacia.domain.Opcper opcper);

	/**
	 * Eliminar un registro de la base de datos
 	 * @param java.math.BigDecimal idopcper
	 */
	public void deleteOpcper(com.farmacia.domain.Opcper opcper);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idopcper
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Opcper getOpcper(com.farmacia.domain.Opcper opcper);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idopcper
	 * @return java.lang.String (XML resultante)
	 */
	public java.lang.String getOpcperXmlString(java.math.BigDecimal idopcper);

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public com.ibatis.common.util.PaginatedList getOpcperList();

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList (Objetos java.lang.String con la representación XML del registro)
	 */
	public com.ibatis.common.util.PaginatedList getOpcperListXmlString();
		/**
	 * Consultar el maximo para insertar el siguiente
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMaxOpcperIdopcper();
		/**
	 * MÉTODOS PERSONALIZADOS A IMPLEMENTAR EN LAS CLASES HIJA
	 */

}

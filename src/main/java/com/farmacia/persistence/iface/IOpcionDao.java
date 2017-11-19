package com.farmacia.persistence.iface;
import java.math.BigDecimal;
import java.util.Collection;

import com.farmacia.domain.Opcion;
/** 
 * @author SPEEDY
 * Interface que define los métodos de acceso principales a la base de datos 
 */
public interface IOpcionDao {

	/**se genera
	 * Insertar registro en Base de datos
	 * @param com.farmacia.domain.Opcion opcion
	 */
	public void insertOpcion(com.farmacia.domain.Opcion opcion);

	/**
	 * Actualizar registro en base de datos
 	 * @param java.math.BigDecimal idopcion
	 * @param com.farmacia.domain.Opcion opcion
	 */
	public void updateOpcion(com.farmacia.domain.Opcion opcion);

	/**
	 * Eliminar un registro de la base de datos
 	 * @param java.math.BigDecimal idopcion
	 */
	public void deleteOpcion(com.farmacia.domain.Opcion opcion);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idopcion
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Opcion getOpcion(com.farmacia.domain.Opcion opcion);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idopcion
	 * @return java.lang.String (XML resultante)
	 */
	public java.lang.String getOpcionXmlString(java.math.BigDecimal idopcion);

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public com.ibatis.common.util.PaginatedList getOpcionList();

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList (Objetos java.lang.String con la representación XML del registro)
	 */
	public com.ibatis.common.util.PaginatedList getOpcionListXmlString();
		/**
	 * Consultar el maximo para insertar el siguiente
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMaxOpcionIdopcion();
		/**
	 * MÉTODOS PERSONALIZADOS A IMPLEMENTAR EN LAS CLASES HIJA
	 */

	public Collection getOpcionesByMenuPerfil(BigDecimal id_perfil, BigDecimal idmenu);

}

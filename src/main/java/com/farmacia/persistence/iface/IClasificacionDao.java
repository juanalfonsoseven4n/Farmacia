package com.farmacia.persistence.iface;
import java.util.Collection;

import com.farmacia.domain.Clasificacion;
/** 
 * @author SPEEDY
 * Interface que define los métodos de acceso principales a la base de datos 
 */
public interface IClasificacionDao {

	/**se genera
	 * Insertar registro en Base de datos
	 * @param com.farmacia.domain.Clasificacion laboratorio
	 */
	public void insertClasificacion(com.farmacia.domain.Clasificacion clasificacion);

	/**
	 * Actualizar registro en base de datos
 	 * @param java.math.BigDecimal idclasificacion
	 * @param com.farmacia.domain.Clasificacion clasificacion
	 */
	public void updateClasificacion(com.farmacia.domain.Clasificacion clasificacion);

	/**
	 * Eliminar un registro de la base de datos
 	 * @param java.math.BigDecimal idclasificacion
	 */
	public void deleteClasificacion(com.farmacia.domain.Clasificacion clasificacion);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idclasificacion
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Clasificacion getClasificacion(com.farmacia.domain.Clasificacion clasificacion);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idclasificacion
	 * @return java.lang.String (XML resultante)
	 */
	public java.lang.String getClasificacionXmlString(java.math.BigDecimal idclasificacion);

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Collection getClasificacionList();
	
	public com.ibatis.common.util.PaginatedList getClasificacionByName(String nombre);
	
	public com.ibatis.common.util.PaginatedList getClasificacionListPag();

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList (Objetos java.lang.String con la representación XML del registro)
	 */
	public com.ibatis.common.util.PaginatedList getClasificacionListXmlString();
		/**
	 * Consultar el maximo para insertar el siguiente
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMaxClasificacionIdclasificacion();
		/**
	 * MÉTODOS PERSONALIZADOS A IMPLEMENTAR EN LAS CLASES HIJA
	 */



}

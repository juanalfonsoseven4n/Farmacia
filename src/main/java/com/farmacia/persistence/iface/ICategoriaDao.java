package com.farmacia.persistence.iface;
import java.util.Collection;

import com.farmacia.domain.Categoria;
/** 
 * @author SPEEDY
 * Interface que define los métodos de acceso principales a la base de datos 
 */
public interface ICategoriaDao {

	/**se genera
	 * Insertar registro en Base de datos
	 * @param com.farmacia.domain.Categoria laboratorio
	 */
	public void insertCategoria(com.farmacia.domain.Categoria categoria);

	/**
	 * Actualizar registro en base de datos
 	 * @param java.math.BigDecimal idcategoria
	 * @param com.farmacia.domain.Categoria categoria
	 */
	public void updateCategoria(com.farmacia.domain.Categoria categoria);

	/**
	 * Eliminar un registro de la base de datos
 	 * @param java.math.BigDecimal idcategoria
	 */
	public void deleteCategoria(com.farmacia.domain.Categoria categoria);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idcategoria
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Categoria getCategoria(com.farmacia.domain.Categoria categoria);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idcategoria
	 * @return java.lang.String (XML resultante)
	 */
	public java.lang.String getCategoriaXmlString(java.math.BigDecimal idcategoria);

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Collection getCategoriaList();
	
	public com.ibatis.common.util.PaginatedList getCategoriaByName(String nombre);
	
	public com.ibatis.common.util.PaginatedList getCategoriaListPag();

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList (Objetos java.lang.String con la representación XML del registro)
	 */
	public com.ibatis.common.util.PaginatedList getCategoriaListXmlString();
		/**
	 * Consultar el maximo para insertar el siguiente
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMaxCategoriaIdcategoria();
		/**
	 * MÉTODOS PERSONALIZADOS A IMPLEMENTAR EN LAS CLASES HIJA
	 */



}

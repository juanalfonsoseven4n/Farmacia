package com.farmacia.persistence.iface;
import java.util.Collection;

import com.farmacia.domain.Laboratorio;
/** 
 * @author SPEEDY
 * Interface que define los métodos de acceso principales a la base de datos 
 */
public interface ILaboratorioDao {

	/**se genera
	 * Insertar registro en Base de datos
	 * @param com.farmacia.domain.Laboratorio laboratorio
	 */
	public void insertLaboratorio(com.farmacia.domain.Laboratorio laboratorio);

	/**
	 * Actualizar registro en base de datos
 	 * @param java.math.BigDecimal idlaboratorio
	 * @param com.farmacia.domain.Laboratorio laboratorio
	 */
	public void updateLaboratorio(com.farmacia.domain.Laboratorio laboratorio);

	/**
	 * Eliminar un registro de la base de datos
 	 * @param java.math.BigDecimal idlaboratorio
	 */
	public void deleteLaboratorio(com.farmacia.domain.Laboratorio laboratorio);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idlaboratorio
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Laboratorio getLaboratorio(com.farmacia.domain.Laboratorio laboratorio);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idlaboratorio
	 * @return java.lang.String (XML resultante)
	 */
	public java.lang.String getLaboratorioXmlString(java.math.BigDecimal idlaboratorio);

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Collection getLaboratorioList();
	
	public com.ibatis.common.util.PaginatedList getLaboratorioByName(String nombre);
	
	public com.ibatis.common.util.PaginatedList getLaboratorioListPag();

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList (Objetos java.lang.String con la representación XML del registro)
	 */
	public com.ibatis.common.util.PaginatedList getLaboratorioListXmlString();
		/**
	 * Consultar el maximo para insertar el siguiente
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMaxLaboratorioIdlaboratorio();
		/**
	 * MÉTODOS PERSONALIZADOS A IMPLEMENTAR EN LAS CLASES HIJA
	 */



}

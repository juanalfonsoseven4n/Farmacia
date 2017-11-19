package com.farmacia.persistence.iface;
import java.util.Collection;

import com.farmacia.domain.Perfil;
/** 
 * @author SPEEDY
 * Interface que define los métodos de acceso principales a la base de datos 
 */
public interface IPerfilDao {

	/**se genera
	 * Insertar registro en Base de datos
	 * @param com.farmacia.domain.Perfil perfil
	 */
	public void insertPerfil(com.farmacia.domain.Perfil perfil);

	/**
	 * Actualizar registro en base de datos
 	 * @param java.math.BigDecimal idperfil
	 * @param com.farmacia.domain.Perfil perfil
	 */
	public void updatePerfil(com.farmacia.domain.Perfil perfil);

	/**
	 * Eliminar un registro de la base de datos
 	 * @param java.math.BigDecimal idperfil
	 */
	public void deletePerfil(com.farmacia.domain.Perfil perfil);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idperfil
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Perfil getPerfil(com.farmacia.domain.Perfil perfil);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idperfil
	 * @return java.lang.String (XML resultante)
	 */
	public java.lang.String getPerfilXmlString(java.math.BigDecimal idperfil);

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Collection getPerfilListPag();
	
	public Collection getPerfilList();

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList (Objetos java.lang.String con la representación XML del registro)
	 */
	public com.ibatis.common.util.PaginatedList getPerfilListXmlString();
		/**
	 * Consultar el maximo para insertar el siguiente
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMaxPerfilIdperfil();
		/**
	 * MÉTODOS PERSONALIZADOS A IMPLEMENTAR EN LAS CLASES HIJA
	 */

}

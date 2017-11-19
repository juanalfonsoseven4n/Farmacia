package com.farmacia.persistence.iface;
import com.farmacia.domain.Usuario;
/** 
 * @author SPEEDY
 * Interface que define los métodos de acceso principales a la base de datos 
 */
public interface IUsuarioDao {

	/**se genera
	 * Insertar registro en Base de datos
	 * @param com.farmacia.domain.Usuario usuario
	 */
	public void insertUsuario(com.farmacia.domain.Usuario usuario);

	/**
	 * Actualizar registro en base de datos
 	 * @param java.math.BigDecimal idusuario
	 * @param com.farmacia.domain.Usuario usuario
	 */
	public void updateUsuario(com.farmacia.domain.Usuario usuario);

	/**
	 * Eliminar un registro de la base de datos
 	 * @param java.math.BigDecimal idusuario
	 */
	public void deleteUsuario(com.farmacia.domain.Usuario usuario);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idusuario
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Usuario getUsuario(com.farmacia.domain.Usuario usuario);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idusuario
	 * @return java.lang.String (XML resultante)
	 */
	public java.lang.String getUsuarioXmlString(java.math.BigDecimal idusuario);

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public com.ibatis.common.util.PaginatedList getUsuarioList();
	
	/**
	 * Consultar todo el conjunto de medicos paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public com.ibatis.common.util.PaginatedList getMedicosList(String farmacia);

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList (Objetos java.lang.String con la representación XML del registro)
	 */
	public com.ibatis.common.util.PaginatedList getUsuarioListXmlString();
		/**
	 * Consultar el maximo para insertar el siguiente
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMaxUsuarioIdusuario();
		/**
	 * MÉTODOS PERSONALIZADOS A IMPLEMENTAR EN LAS CLASES HIJA
	 */

	public Usuario getUsuariobyUsername(Usuario usuario);

}

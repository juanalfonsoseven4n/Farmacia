package com.farmacia.persistence.sqlmapdao;

import java.math.BigDecimal;
import java.util.HashMap;

import com.farmacia.domain.Usuario;
import com.farmacia.util.Constants;
/**
 * Clase que implementa los métodos definidos en la interface correspondiente a 'UsuarioDao' 
 *    y extiende la plantilla de acceso a la base de datos 'SqlMapDaoTemplate'
 * @author .
 */
public class UsuarioSqlMapDao extends DAO implements com.farmacia.persistence.iface.IUsuarioDao {

	/**
	 * Definición de constructor de superclase
	 * @param daoManager
	 */
	public UsuarioSqlMapDao(com.ibatis.dao.client.DaoManager daoManager) {
		super(daoManager);
	}

	/**
	 * Implementación del método básico de inserción de un registro en la base de datos.
	 * @param com.farmacia.domain.Usuario
	 */
	public void insertUsuario(com.farmacia.domain.Usuario usuario) {
		HashMap datosseq = new HashMap();
		datosseq.put(Constants.SEQNAME,  "idusuario");
		datosseq.put(Constants.TABLENAME,  "usuario");
		Long id = getNext(datosseq);
		usuario.setIdusuario(new BigDecimal(id.longValue()));
		insert("insertUsuario", usuario);
	}

	/**
	 * Implementación del método básico de actualización de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Usuario)
	 * @param com.farmacia.domain.Usuario
	 */
	public void updateUsuario( com.farmacia.domain.Usuario usuario) {
		update("updateUsuario", usuario);
	}

	/**
	 * Implementación del método básico de borrado de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Usuario) 
	 */
	public void deleteUsuario(com.farmacia.domain.Usuario usuario) {
		delete("deleteUsuario", usuario);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna un objeto con la misma estructura del registro de la tabla.
	 * @param java.math.BigDecimal (llave primaria de Usuario)
	 * @return com.farmacia.domain.Usuario (Objeto mapeado directamente de la BD) 
	 */
	public com.farmacia.domain.Usuario getUsuario(com.farmacia.domain.Usuario usuario) {
		return (com.farmacia.domain.Usuario) queryForObject("getUsuario", usuario);
	}
	public Usuario getUsuariobyUsername(Usuario usuario){
		usuario.setDescripcion(usuario.getDescripcion().toUpperCase());
		return (com.farmacia.domain.Usuario) queryForObject("getUsuariobyUserName", usuario);
	}
	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna una cadena con la estructura XML del registro de la tabla.
	 * @param int (llave primaria de Pv_header)
	 * @return java.lang.String (Cadena de texto XML mapeada directamente de la BD) 
	 */
	public String getUsuarioXmlString(java.math.BigDecimal idusuario) {
		return (String) queryForObject("getUsuarioXmlString", idusuario);
	}

	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getUsuarioList() {
		return queryForPaginatedList("getUsuarioList", null, Integer.parseInt( PAGE_SIZE));
	}
	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getMedicosList(String farmacia) {
		return queryForPaginatedList("getMedicosList", farmacia, Integer.parseInt( PAGE_SIZE));
	}
	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'java.lang.String' 
	 *                                               correspondientes a estructuras XML de 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getUsuarioListXmlString() {
		return queryForPaginatedList("getUsuarioListXmlString", null, Integer.parseInt( PAGE_SIZE));
	}
		/**
	 * Implementación del método básico que consulta el registro maximo en la tabla 	 
	 * @return java.math.BigDecimal 
	 */
	public java.math.BigDecimal  getMaxUsuarioIdusuario() {
		return (java.math.BigDecimal)queryForObject("getMaxUsuarioIdusuario", null);
	}
		/**
	 * MÉTODOS PERSONALIZADOS DE ACCESO A LA BASE DE DATOS:	 
	 */

}
package com.farmacia.persistence.sqlmapdao;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;

import com.farmacia.util.Constants;
/**
 * Clase que implementa los métodos definidos en la interface correspondiente a 'PerfilDao' 
 *    y extiende la plantilla de acceso a la base de datos 'SqlMapDaoTemplate'
 * @author .
 */
public class PerfilSqlMapDao extends DAO implements com.farmacia.persistence.iface.IPerfilDao {

	/**
	 * Definición de constructor de superclase
	 * @param daoManager
	 */
	public PerfilSqlMapDao(com.ibatis.dao.client.DaoManager daoManager) {
		super(daoManager);
	}

	/**
	 * Implementación del método básico de inserción de un registro en la base de datos.
	 * @param com.farmacia.domain.Perfil
	 */
	public void insertPerfil(com.farmacia.domain.Perfil perfil) {
		HashMap datosseq = new HashMap();
		datosseq.put(Constants.SEQNAME,  "idperfil");
		datosseq.put(Constants.TABLENAME,  "perfil");
		Long id = getNext(datosseq);
		perfil.setIdperfil(new BigDecimal(id.longValue()));
		insert("insertPerfil", perfil);
	}

	/**
	 * Implementación del método básico de actualización de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Perfil)
	 * @param com.farmacia.domain.Perfil
	 */
	public void updatePerfil( com.farmacia.domain.Perfil perfil) {
		update("updatePerfil", perfil);
	}

	/**
	 * Implementación del método básico de borrado de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Perfil) 
	 */
	public void deletePerfil(com.farmacia.domain.Perfil perfil) {
		delete("deletePerfil", perfil);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna un objeto con la misma estructura del registro de la tabla.
	 * @param java.math.BigDecimal (llave primaria de Perfil)
	 * @return com.farmacia.domain.Perfil (Objeto mapeado directamente de la BD) 
	 */
	public com.farmacia.domain.Perfil getPerfil(com.farmacia.domain.Perfil perfil) {
		return (com.farmacia.domain.Perfil) queryForObject("getPerfil", perfil);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna una cadena con la estructura XML del registro de la tabla.
	 * @param int (llave primaria de Pv_header)
	 * @return java.lang.String (Cadena de texto XML mapeada directamente de la BD) 
	 */
	public String getPerfilXmlString(java.math.BigDecimal idperfil) {
		return (String) queryForObject("getPerfilXmlString", idperfil);
	}

	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public Collection getPerfilListPag() {
		return queryForPaginatedList("getPerfilList", null, Integer.parseInt( PAGE_SIZE));
	}
	
	public Collection getPerfilList() {
		return queryForList("getPerfilList", null);
	}

	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'java.lang.String' 
	 *                                               correspondientes a estructuras XML de 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getPerfilListXmlString() {
		return queryForPaginatedList("getPerfilListXmlString", null, Integer.parseInt( PAGE_SIZE));
	}
		/**
	 * Implementación del método básico que consulta el registro maximo en la tabla 	 
	 * @return java.math.BigDecimal 
	 */
	public java.math.BigDecimal  getMaxPerfilIdperfil() {
		return (java.math.BigDecimal)queryForObject("getMaxPerfilIdperfil", null);
	}
		/**
	 * MÉTODOS PERSONALIZADOS DE ACCESO A LA BASE DE DATOS:	 
	 */

}
package com.farmacia.persistence.sqlmapdao;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;

import com.farmacia.util.Constants;
/**
 * Clase que implementa los m�todos definidos en la interface correspondiente a 'ProveedorDao' 
 *    y extiende la plantilla de acceso a la base de datos 'SqlMapDaoTemplate'
 * @author .
 */
public class ProveedorSqlMapDao extends DAO implements com.farmacia.persistence.iface.IProveedorDao {

	/**
	 * Definici�n de constructor de superclase
	 * @param daoManager
	 */
	public ProveedorSqlMapDao(com.ibatis.dao.client.DaoManager daoManager) {
		super(daoManager);
	}

	/**
	 * Implementaci�n del m�todo b�sico de inserci�n de un registro en la base de datos.
	 * @param com.farmacia.domain.Proveedor
	 */
	public void insertProveedor(com.farmacia.domain.Proveedor proveedor) {
		HashMap datosseq = new HashMap();
		datosseq.put(Constants.SEQNAME,  "idproveedor");
		datosseq.put(Constants.TABLENAME,  "proveedor");
		Long id = getNext(datosseq);
		proveedor.setIdproveedor(new BigDecimal(id.longValue()));
		insert("insertProveedor", proveedor);
	}

	/**
	 * Implementaci�n del m�todo b�sico de actualizaci�n de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Proveedor)
	 * @param com.farmacia.domain.Proveedor
	 */
	public void updateProveedor( com.farmacia.domain.Proveedor proveedor) {
		update("updateProveedor", proveedor);
	}

	/**
	 * Implementaci�n del m�todo b�sico de borrado de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Proveedor) 
	 */
	public void deleteProveedor(com.farmacia.domain.Proveedor proveedor) {
		delete("deleteProveedor", proveedor);
	}

	/**
	 * Implementaci�n del m�todo b�sico de consulta por llave primaria de un registro en la base de datos
	 * Retorna un objeto con la misma estructura del registro de la tabla.
	 * @param java.math.BigDecimal (llave primaria de Proveedor)
	 * @return com.farmacia.domain.Proveedor (Objeto mapeado directamente de la BD) 
	 */
	public com.farmacia.domain.Proveedor getProveedor(com.farmacia.domain.Proveedor proveedor) {
		return (com.farmacia.domain.Proveedor) queryForObject("getProveedor", proveedor);
	}

	/**
	 * Implementaci�n del m�todo b�sico de consulta por llave primaria de un registro en la base de datos
	 * Retorna una cadena con la estructura XML del registro de la tabla.
	 * @param int (llave primaria de Pv_header)
	 * @return java.lang.String (Cadena de texto XML mapeada directamente de la BD) 
	 */
	public String getProveedorXmlString(java.math.BigDecimal idproveedor) {
		return (String) queryForObject("getProveedorXmlString", idproveedor);
	}

	/**
	 * Implementaci�n del m�todo b�sico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public Collection getProveedorList() {
		return queryForList("getProveedorList", null);
	}
	
	public com.ibatis.common.util.PaginatedList getProveedorListPag() {
		return queryForPaginatedList("getProveedorList", null, Integer.parseInt( PAGE_SIZE));
	}
	
	public com.ibatis.common.util.PaginatedList getProveedorByName(String nombre) {
		return queryForPaginatedList("getProveedorByName", nombre, Integer.parseInt( PAGE_SIZE));
	}
	
	/**
	 * Implementaci�n del m�todo b�sico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'java.lang.String' 
	 *                                               correspondientes a estructuras XML de 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getProveedorListXmlString() {
		return queryForPaginatedList("getProveedorListXmlString", null, Integer.parseInt( PAGE_SIZE));
	}
		/**
	 * Implementaci�n del m�todo b�sico que consulta el registro maximo en la tabla 	 
	 * @return java.math.BigDecimal 
	 */
	public java.math.BigDecimal  getMaxProveedorIdproveedor() {
		return (java.math.BigDecimal)queryForObject("getMaxProveedorIdproveedor", null);
	}
		/**
	 * M�TODOS PERSONALIZADOS DE ACCESO A LA BASE DE DATOS:	 
	 */

}
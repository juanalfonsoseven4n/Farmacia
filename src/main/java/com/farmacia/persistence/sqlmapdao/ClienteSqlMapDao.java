package com.farmacia.persistence.sqlmapdao;

import java.math.BigDecimal;
import java.util.HashMap;

import com.farmacia.util.Constants;
/**
 * Clase que implementa los m�todos definidos en la interface correspondiente a 'ClienteDao' 
 *    y extiende la plantilla de acceso a la base de datos 'SqlMapDaoTemplate'
 * @author .
 */
public class ClienteSqlMapDao extends DAO implements com.farmacia.persistence.iface.IClienteDao {

	
	/**
	 * Definici�n de constructor de superclase
	 * @param daoManager
	 */
	public ClienteSqlMapDao(com.ibatis.dao.client.DaoManager daoManager) {
		super(daoManager);
	}

	/**
	 * Implementaci�n del m�todo b�sico de inserci�n de un registro en la base de datos.
	 * @param com.farmacia.domain.Cliente
	 */
	public void insertCliente(com.farmacia.domain.Cliente cliente) {
		HashMap datosseq = new HashMap();
		datosseq.put(Constants.SEQNAME,  "idcliente");
		datosseq.put(Constants.TABLENAME,  "cliente");
		Long id = getNext(datosseq);
		cliente.setIdcliente(new BigDecimal(id.longValue()));
		insert("insertCliente", cliente);
	}

	/**
	 * Implementaci�n del m�todo b�sico de actualizaci�n de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Cliente)
	 * @param com.farmacia.domain.Cliente
	 */
	public void updateCliente( com.farmacia.domain.Cliente cliente) {
		update("updateCliente", cliente);
	}

	/**
	 * Implementaci�n del m�todo b�sico de borrado de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Cliente) 
	 */
	public void deleteCliente(com.farmacia.domain.Cliente cliente) {
		delete("deleteCliente", cliente);
	}

	/**
	 * Implementaci�n del m�todo b�sico de consulta por llave primaria de un registro en la base de datos
	 * Retorna un objeto con la misma estructura del registro de la tabla.
	 * @param java.math.BigDecimal (llave primaria de Cliente)
	 * @return com.farmacia.domain.Cliente (Objeto mapeado directamente de la BD) 
	 */
	public com.farmacia.domain.Cliente getCliente(com.farmacia.domain.Cliente cliente) {
		return (com.farmacia.domain.Cliente) queryForObject("getCliente", cliente);
	}
	
	public com.ibatis.common.util.PaginatedList getClienteByName(com.farmacia.domain.Cliente cliente) {
		return queryForPaginatedList("getClienteByName", cliente, Integer.parseInt( PAGE_SIZE));
	}
	/**
	 * Implementaci�n del m�todo b�sico de consulta por llave primaria de un registro en la base de datos
	 * Retorna una cadena con la estructura XML del registro de la tabla.
	 * @param int (llave primaria de Pv_header)
	 * @return java.lang.String (Cadena de texto XML mapeada directamente de la BD) 
	 */
	public String getClienteXmlString(java.math.BigDecimal idcliente) {
		return (String) queryForObject("getClienteXmlString", idcliente);
	}

	/**
	 * Implementaci�n del m�todo b�sico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getClienteList() {
		return queryForPaginatedList("getClienteList", null, Integer.parseInt( PAGE_SIZE));
	}

	/**
	 * Implementaci�n del m�todo b�sico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'java.lang.String' 
	 *                                               correspondientes a estructuras XML de 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getClienteListXmlString() {
		return queryForPaginatedList("getClienteListXmlString", null, Integer.parseInt( PAGE_SIZE));
	}
		/**
	 * Implementaci�n del m�todo b�sico que consulta el registro maximo en la tabla 	 
	 * @return java.math.BigDecimal 
	 */
	public java.math.BigDecimal  getMaxClienteIdcliente() {
		return (java.math.BigDecimal)queryForObject("getMaxClienteIdcliente", null);
	}
		/**
	 * M�TODOS PERSONALIZADOS DE ACCESO A LA BASE DE DATOS:	 
	 */

}
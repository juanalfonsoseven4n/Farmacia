package com.farmacia.persistence.iface;
import com.farmacia.domain.Cliente;
/** 
 * @author SPEEDY
 * Interface que define los métodos de acceso principales a la base de datos 
 */
public interface IClienteDao {

	/**se genera
	 * Insertar registro en Base de datos
	 * @param com.farmacia.domain.Cliente cliente
	 */
	public void insertCliente(com.farmacia.domain.Cliente cliente);

	/**
	 * Actualizar registro en base de datos
 	 * @param java.math.BigDecimal idcliente
	 * @param com.farmacia.domain.Cliente cliente
	 */
	public void updateCliente(com.farmacia.domain.Cliente cliente);

	/**
	 * Eliminar un registro de la base de datos
 	 * @param java.math.BigDecimal idcliente
	 */
	public void deleteCliente(com.farmacia.domain.Cliente cliente);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idcliente
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Cliente getCliente(com.farmacia.domain.Cliente cliente);
	
	public com.ibatis.common.util.PaginatedList getClienteByName(com.farmacia.domain.Cliente cliente);
	
	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idcliente
	 * @return java.lang.String (XML resultante)
	 */
	public java.lang.String getClienteXmlString(java.math.BigDecimal idcliente);

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public com.ibatis.common.util.PaginatedList getClienteList();

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList (Objetos java.lang.String con la representación XML del registro)
	 */
	public com.ibatis.common.util.PaginatedList getClienteListXmlString();
		/**
	 * Consultar el maximo para insertar el siguiente
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMaxClienteIdcliente();
		/**
	 * MÉTODOS PERSONALIZADOS A IMPLEMENTAR EN LAS CLASES HIJA
	 */

}

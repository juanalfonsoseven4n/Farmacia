package com.farmacia.persistence.iface;
import java.math.BigDecimal;
import java.util.Collection;

import com.farmacia.domain.Provprod;
/** 
 * @author SPEEDY
 * Interface que define los métodos de acceso principales a la base de datos 
 */
public interface IProvprodDao {

	/**se genera
	 * Insertar registro en Base de datos
	 * @param com.farmacia.domain.Provprod provprod
	 */
	public void insertProvprod(com.farmacia.domain.Provprod provprod);

	/**
	 * Actualizar registro en base de datos
 	 * @param java.math.BigDecimal idprovprod
	 * @param com.farmacia.domain.Provprod provprod
	 */
	public void updateProvprod(com.farmacia.domain.Provprod provprod);

	/**
	 * Eliminar un registro de la base de datos
 	 * @param java.math.BigDecimal idprovprod
	 */
	public void deleteProvprod(com.farmacia.domain.Provprod provprod);
	
	public void deleteProvprodByProd(java.math.BigDecimal idproducto);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idprovprod
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Provprod getProvprod(com.farmacia.domain.Provprod provprod);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idprovprod
	 * @return java.lang.String (XML resultante)
	 */
	public java.lang.String getProvprodXmlString(java.math.BigDecimal idprovprod);

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public com.ibatis.common.util.PaginatedList getProvprodList();

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList (Objetos java.lang.String con la representación XML del registro)
	 */
	public com.ibatis.common.util.PaginatedList getProvprodListXmlString();
		/**
	 * Consultar el maximo para insertar el siguiente
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMaxProvprodIdprovprod();
		/**
	 * MÉTODOS PERSONALIZADOS A IMPLEMENTAR EN LAS CLASES HIJA
	 */
	public Collection getProvprodList(BigDecimal idproducto);
}

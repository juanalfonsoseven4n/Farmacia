package com.farmacia.persistence.iface;
import java.math.BigDecimal;
import java.util.List;

import com.farmacia.domain.Movimiento;
import com.farmacia.form.MovimientoForm;
/** 
 * @author SPEEDY
 * Interface que define los métodos de acceso principales a la base de datos 
 */
public interface IMovimientoDao {

	/**se genera
	 * Insertar registro en Base de datos
	 * @param com.farmacia.domain.Movimiento movimiento
	 */
	public void insertMovimiento(com.farmacia.domain.Movimiento movimiento);

	/**
	 * Actualizar registro en base de datos
 	 * @param java.math.BigDecimal idmovimiento
	 * @param com.farmacia.domain.Movimiento movimiento
	 */
	public void updateMovimiento(com.farmacia.domain.Movimiento movimiento);

	/**
	 * Eliminar un registro de la base de datos
 	 * @param java.math.BigDecimal idmovimiento
	 */
	public void deleteMovimiento(com.farmacia.domain.Movimiento movimiento);
	
	public void deleteMovimientoByDetVenta(BigDecimal iddetventa);
	
	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idmovimiento
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Movimiento getMovimiento(com.farmacia.domain.Movimiento movimiento);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param java.math.BigDecimal idmovimiento
	 * @return java.lang.String (XML resultante)
	 */
	public java.lang.String getMovimientoXmlString(BigDecimal idmovimiento);

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public com.ibatis.common.util.PaginatedList getMovimientoList();
	
	public com.ibatis.common.util.PaginatedList getMovimientosFiltrados(MovimientoForm form);
	
	public List getMovimientosFiltradosList(MovimientoForm form);
	
	public List getMovimientosCuarentena();
	
	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList (Objetos java.lang.String con la representación XML del registro)
	 */
	public com.ibatis.common.util.PaginatedList getMovimientoListXmlString();
		/**
	 * Consultar el maximo para insertar el siguiente
	 * @return java.math.BigDecimal
	 */
	public BigDecimal getMaxMovimientoIdmovimiento();
		/**
	 * MÉTODOS PERSONALIZADOS A IMPLEMENTAR EN LAS CLASES HIJA
	 */
	public List getMovimientosConsolByProdTipo(MovimientoForm form);
	
	public List getMovimientosConsolByProd(MovimientoForm form);
}

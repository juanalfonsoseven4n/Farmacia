
package com.farmacia.domain;

/**
 * Clase que representa un objeto de la tabla Inventario
 * @author SPEEDY
 * 
 */
 
public class Inventario implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Definición de atributos privados de clase:
	 */
			private java.math.BigDecimal idinventario; 
			private java.math.BigDecimal idproducto; 
			private java.math.BigDecimal cantidad; 
			private java.math.BigDecimal fechaexpir; 
			private java.math.BigDecimal fechaing; 
			private java.lang.String codigo; 
			private java.math.BigDecimal preciocosto; 
			private java.math.BigDecimal idfarmacia; 
	
	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdinventario () {
		return idinventario;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdproducto () {
		return idproducto;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getCantidad () {
		return cantidad;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getFechaexpir () {
		return fechaexpir;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getFechaing () {
		return fechaing;
	}
	
	/**
	 * @return java.lang.String
	 */
	public java.lang.String getCodigo () {
		return codigo;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getPreciocosto () {
		return preciocosto;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdfarmacia () {
		return idfarmacia;
	}
		
	
	/**
	 * @param idinventario
	 */
	public void setIdinventario(java.math.BigDecimal idinventario) {
		this.idinventario = idinventario;
	}
	
	/**
	 * @param idproducto
	 */
	public void setIdproducto(java.math.BigDecimal idproducto) {
		this.idproducto = idproducto;
	}
	
	/**
	 * @param cantidad
	 */
	public void setCantidad(java.math.BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	
	/**
	 * @param fechaexpir
	 */
	public void setFechaexpir(java.math.BigDecimal fechaexpir) {
		this.fechaexpir = fechaexpir;
	}
	
	/**
	 * @param fechaing
	 */
	public void setFechaing(java.math.BigDecimal fechaing) {
		this.fechaing = fechaing;
	}
	
	/**
	 * @param codigo
	 */
	public void setCodigo(java.lang.String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * @param preciocosto
	 */
	public void setPreciocosto(java.math.BigDecimal preciocosto) {
		this.preciocosto = preciocosto;
	}
	
	/**
	 * @param idfarmacia
	 */
	public void setIdfarmacia(java.math.BigDecimal idfarmacia) {
		this.idfarmacia = idfarmacia;
	}

		
}

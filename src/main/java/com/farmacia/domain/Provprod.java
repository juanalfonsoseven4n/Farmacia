
package com.farmacia.domain;

/**
 * Clase que representa un objeto de la tabla Provprod
 * @author SPEEDY
 * 
 */
 
public class Provprod implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Definición de atributos privados de clase:
	 */
			private java.math.BigDecimal idproveedor; 
			private java.math.BigDecimal idproducto; 
			private java.math.BigDecimal idprovprod; 
			private java.math.BigDecimal valor; 
			private String provdesc; 
	
	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdproveedor () {
		return idproveedor;
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
	public java.math.BigDecimal getIdprovprod () {
		return idprovprod;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getValor () {
		return valor;
	}
		
	
	/**
	 * @param idproveedor
	 */
	public void setIdproveedor(java.math.BigDecimal idproveedor) {
		this.idproveedor = idproveedor;
	}
	
	/**
	 * @param idproducto
	 */
	public void setIdproducto(java.math.BigDecimal idproducto) {
		this.idproducto = idproducto;
	}
	
	/**
	 * @param idprovprod
	 */
	public void setIdprovprod(java.math.BigDecimal idprovprod) {
		this.idprovprod = idprovprod;
	}
	
	/**
	 * @param valor
	 */
	public void setValor(java.math.BigDecimal valor) {
		this.valor = valor;
	}

	public String getProvdesc() {
		return provdesc;
	}

	public void setProvdesc(String provdesc) {
		this.provdesc = provdesc;
	}
		
}

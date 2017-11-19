
package com.farmacia.domain;

/**
 * Clase que representa un objeto de la tabla Detventa
 * @author SPEEDY
 * 
 */
 
public class Detventa implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Definición de atributos privados de clase:
	 */
			private java.math.BigDecimal iddetventa; 
			private java.math.BigDecimal idventa; 
			private java.math.BigDecimal idproducto; 
			private java.math.BigDecimal cantidad; 
			private java.math.BigDecimal valor; 
			private java.math.BigDecimal iva; 
			private java.math.BigDecimal valorunit; 
			private java.math.BigDecimal marca; 
			private java.math.BigDecimal presentacion;
			private java.math.BigDecimal dias; 
			private String nombreProducto; 
	
	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIddetventa () {
		return iddetventa;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdventa () {
		return idventa;
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
	public java.math.BigDecimal getValor () {
		return valor;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIva () {
		return iva;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getValorunit () {
		return valorunit;
	}
		
	
	/**
	 * @param iddetventa
	 */
	public void setIddetventa(java.math.BigDecimal iddetventa) {
		this.iddetventa = iddetventa;
	}
	
	/**
	 * @param idventa
	 */
	public void setIdventa(java.math.BigDecimal idventa) {
		this.idventa = idventa;
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
	 * @param valor
	 */
	public void setValor(java.math.BigDecimal valor) {
		this.valor = valor;
	}
	
	/**
	 * @param iva
	 */
	public void setIva(java.math.BigDecimal iva) {
		this.iva = iva;
	}
	
	/**
	 * @param valorunit
	 */
	public void setValorunit(java.math.BigDecimal valorunit) {
		this.valorunit = valorunit;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public java.math.BigDecimal getMarca() {
		return marca;
	}

	public void setMarca(java.math.BigDecimal marca) {
		this.marca = marca;
	}

	public java.math.BigDecimal getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(java.math.BigDecimal presentacion) {
		this.presentacion = presentacion;
	}

	public java.math.BigDecimal getDias() {
		return dias;
	}

	public void setDias(java.math.BigDecimal dias) {
		this.dias = dias;
	}

	

	
		
}

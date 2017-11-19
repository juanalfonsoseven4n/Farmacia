
package com.farmacia.domain;

/**
 * Clase que representa un objeto de la tabla Familia
 * @author SPEEDY
 * 
 */
 
public class Familia implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Definición de atributos privados de clase:
	 */
			private java.lang.String nombre; 
			private java.math.BigDecimal idfamilia; 
			private java.lang.String descripcion; 
	
	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	/**
	 * @return java.lang.String
	 */
	public java.lang.String getNombre () {
		return nombre;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdfamilia () {
		return idfamilia;
	}
	
	/**
	 * @return java.lang.String
	 */
	public java.lang.String getDescripcion () {
		return descripcion;
	}
		
	
	/**
	 * @param nombre
	 */
	public void setNombre(java.lang.String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @param idfamilia
	 */
	public void setIdfamilia(java.math.BigDecimal idfamilia) {
		this.idfamilia = idfamilia;
	}
	
	/**
	 * @param descripcion
	 */
	public void setDescripcion(java.lang.String descripcion) {
		this.descripcion = descripcion;
	}
		
}

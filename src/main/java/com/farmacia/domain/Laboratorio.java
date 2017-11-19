
package com.farmacia.domain;

/**
 * Clase que representa un objeto de la tabla Laboratorio
 * @author SPEEDY
 * 
 */
 
public class Laboratorio implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Definición de atributos privados de clase:
	 */
			private java.math.BigDecimal idlaboratorio; 
			private java.lang.String nombre; 
			private java.lang.String descripcion; 
	
	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdlaboratorio () {
		return idlaboratorio;
	}
	
	/**
	 * @return java.lang.String
	 */
	public java.lang.String getNombre () {
		return nombre;
	}
	
	/**
	 * @return java.lang.String
	 */
	public java.lang.String getDescripcion () {
		return descripcion;
	}
		
	
	/**
	 * @param idlaboratorio
	 */
	public void setIdlaboratorio(java.math.BigDecimal idlaboratorio) {
		this.idlaboratorio = idlaboratorio;
	}
	
	/**
	 * @param nombre
	 */
	public void setNombre(java.lang.String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @param descripcion
	 */
	public void setDescripcion(java.lang.String descripcion) {
		this.descripcion = descripcion;
	}
		
}

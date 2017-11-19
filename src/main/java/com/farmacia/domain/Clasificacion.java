
package com.farmacia.domain;

/**
 * Clase que representa un objeto de la tabla Laboratorio
 * @author SPEEDY
 * 
 */
 
public class Clasificacion implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Definición de atributos privados de clase:
	 */
			private java.math.BigDecimal idclasificacion; 
			private java.lang.String nombre; 
			private java.lang.String descripcion; 
	
	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdclasificacion () {
		return idclasificacion;
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
	 * @param idclasificacion
	 */
	public void setIdclasificacion(java.math.BigDecimal idclasificacion) {
		this.idclasificacion = idclasificacion;
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

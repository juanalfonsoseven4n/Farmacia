
package com.farmacia.domain;

/**
 * Clase que representa un objeto de la tabla Gasto
 * @author SPEEDY
 * 
 */
 
public class Gasto implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Definición de atributos privados de clase:
	 */
			private java.math.BigDecimal idgasto; 
			private java.lang.String descripcion; 
			private java.lang.String nombre; 
			private java.math.BigDecimal fecha; 
			private java.math.BigDecimal valor; 
			private java.math.BigDecimal idusuario; 
			private java.math.BigDecimal idfarmacia; 
			private String userdesc;
			private String farmdesc;
	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdgasto () {
		return idgasto;
	}
	
	/**
	 * @return java.lang.String
	 */
	public java.lang.String getDescripcion () {
		return descripcion;
	}
	
	/**
	 * @return java.lang.String
	 */
	public java.lang.String getNombre () {
		return nombre;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getFecha () {
		return fecha;
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
	public java.math.BigDecimal getIdusuario () {
		return idusuario;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdfarmacia () {
		return idfarmacia;
	}
		
	
	/**
	 * @param idgasto
	 */
	public void setIdgasto(java.math.BigDecimal idgasto) {
		this.idgasto = idgasto;
	}
	
	/**
	 * @param descripcion
	 */
	public void setDescripcion(java.lang.String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * @param nombre
	 */
	public void setNombre(java.lang.String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @param fecha
	 */
	public void setFecha(java.math.BigDecimal fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * @param valor
	 */
	public void setValor(java.math.BigDecimal valor) {
		this.valor = valor;
	}
	
	/**
	 * @param idusuario
	 */
	public void setIdusuario(java.math.BigDecimal idusuario) {
		this.idusuario = idusuario;
	}
	
	/**
	 * @param idfarmacia
	 */
	public void setIdfarmacia(java.math.BigDecimal idfarmacia) {
		this.idfarmacia = idfarmacia;
	}

	public String getFarmdesc() {
		return farmdesc;
	}

	public void setFarmdesc(String farmdesc) {
		this.farmdesc = farmdesc;
	}

	public String getUserdesc() {
		return userdesc;
	}

	public void setUserdesc(String userdesc) {
		this.userdesc = userdesc;
	}
		
}

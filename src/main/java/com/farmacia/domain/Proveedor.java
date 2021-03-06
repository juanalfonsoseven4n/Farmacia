
package com.farmacia.domain;

/**
 * Clase que representa un objeto de la tabla Proveedor
 * @author SPEEDY
 * 
 */
 
public class Proveedor implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Definición de atributos privados de clase:
	 */
			private java.math.BigDecimal idproveedor; 
			private java.lang.String nombre; 
			private java.lang.String descripcion; 
			private java.lang.String codigo; 
			private java.math.BigDecimal telefono; 
			private java.lang.String direccion; 
			private java.lang.String representante; 
			private java.math.BigDecimal telefono2; 
			private java.lang.String mail; 
			private java.lang.String nit; 
	
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
	 * @return java.lang.String
	 */
	public java.lang.String getCodigo () {
		return codigo;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getTelefono () {
		return telefono;
	}
	
	/**
	 * @return java.lang.String
	 */
	public java.lang.String getDireccion () {
		return direccion;
	}
	
	/**
	 * @return java.lang.String
	 */
	public java.lang.String getRepresentante () {
		return representante;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getTelefono2 () {
		return telefono2;
	}
	
	/**
	 * @return java.lang.String
	 */
	public java.lang.String getMail () {
		return mail;
	}
	
	/**
	 * @return java.lang.String
	 */
	public java.lang.String getNit () {
		return nit;
	}
		
	
	/**
	 * @param idproveedor
	 */
	public void setIdproveedor(java.math.BigDecimal idproveedor) {
		this.idproveedor = idproveedor;
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
	
	/**
	 * @param codigo
	 */
	public void setCodigo(java.lang.String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * @param telefono
	 */
	public void setTelefono(java.math.BigDecimal telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * @param direccion
	 */
	public void setDireccion(java.lang.String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * @param representante
	 */
	public void setRepresentante(java.lang.String representante) {
		this.representante = representante;
	}
	
	/**
	 * @param telefono2
	 */
	public void setTelefono2(java.math.BigDecimal telefono2) {
		this.telefono2 = telefono2;
	}
	
	/**
	 * @param mail
	 */
	public void setMail(java.lang.String mail) {
		this.mail = mail;
	}
	
	/**
	 * @param nit
	 */
	public void setNit(java.lang.String nit) {
		this.nit = nit;
	}
		
}

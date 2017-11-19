package com.farmacia.domain;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Clase que representa un objeto de la tabla Menu
 * 
 */
 
public class Menu implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Definición de atributos privados de clase:
	 */
	private BigDecimal idmenu; 
	private java.lang.String nombre; 
	private BigDecimal orden; 
	private java.lang.String descripcion; 
	private java.lang.String titulo; 
	private Collection opciones;
	
	
	public java.lang.String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(java.lang.String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	public BigDecimal getIdmenu() {
		return idmenu;
	}
	public void setIdmenu(BigDecimal idmenu) {
		this.idmenu = idmenu;
	}
	public java.lang.String getNombre() {
		return nombre;
	}
	public void setNombre(java.lang.String nombre) {
		this.nombre = nombre;
	}
	public Collection getOpciones() {
		return opciones;
	}
	public void setOpciones(Collection opciones) {
		this.opciones = opciones;
	}
	public BigDecimal getOrden() {
		return orden;
	}
	public void setOrden(BigDecimal orden) {
		this.orden = orden;
	}
	public java.lang.String getTitulo() {
		return titulo;
	}
	public void setTitulo(java.lang.String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
			
}

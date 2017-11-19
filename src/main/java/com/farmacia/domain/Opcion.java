package com.farmacia.domain;

import java.math.BigDecimal;

/**
 * Clase que representa un objeto de la tabla Opcion
 * @author SPEEDY
 * 
 */
 
public class Opcion implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Definición de atributos privados de clase:
	 */
	private BigDecimal idopcion; 
	private BigDecimal idmenu; 
	private java.lang.String nombre; 
	private java.lang.String descripcion; 
	private java.lang.String linkopcion; 
	private BigDecimal orden; 
	private java.lang.String estado; 
	private java.lang.String titulo; 
	private Menu menu;
	
	public java.lang.String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(java.lang.String descripcion) {
		this.descripcion = descripcion;
	}
	public java.lang.String getEstado() {
		return estado;
	}
	public void setEstado(java.lang.String estado) {
		this.estado = estado;
	}
	public BigDecimal getIdmenu() {
		return idmenu;
	}
	public void setIdmenu(BigDecimal idmenu) {
		this.idmenu = idmenu;
	}
	public BigDecimal getIdopcion() {
		return idopcion;
	}
	public void setIdopcion(BigDecimal idopcion) {
		this.idopcion = idopcion;
	}
	public java.lang.String getLinkopcion() {
		return linkopcion;
	}
	public void setLinkopcion(java.lang.String linkopcion) {
		this.linkopcion = linkopcion;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public java.lang.String getNombre() {
		return nombre;
	}
	public void setNombre(java.lang.String nombre) {
		this.nombre = nombre;
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
	



}

package com.farmacia.domain;

import java.util.Collection;

/**
 * Clase que representa un objeto de la tabla Producto
 * @author SPEEDY
 * 
 */
 
public class Producto implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Definición de atributos privados de clase:
	 */
			private java.math.BigDecimal idproducto; 
			private java.lang.String nombre; 
			private java.lang.String presentacion; 
			private java.math.BigDecimal idcategoria; 
			private java.math.BigDecimal idcategoriad; 
			private java.lang.String codigo; 
			private java.math.BigDecimal iva; 
			private java.math.BigDecimal valorunit; 
			private java.math.BigDecimal valor; 
			private Collection provprods; 
			private java.math.BigDecimal precioventa; 
			private java.math.BigDecimal cantidadmin; 
			private java.math.BigDecimal idlaboratorio; 
			private java.lang.String comentarios; 
			private java.lang.String indicaciones; 
			private java.math.BigDecimal idfamilia; 
			private java.lang.String labdesc;
			private java.lang.String catdesc;
			private java.lang.String catdescd;
			private java.lang.String famdesc;
			private java.math.BigDecimal sobre; 
			private java.math.BigDecimal caja;
			private java.lang.String invima;
			
	
	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdproducto () {
		return idproducto;
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
	public java.lang.String getPresentacion () {
		return presentacion;
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
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getValor () {
		return valor;
	}
	
	
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getPrecioventa () {
		return precioventa;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getCantidadmin () {
		return cantidadmin;
	}
	
	
	
	/**
	 * @return java.lang.String
	 */
	public java.lang.String getComentarios () {
		return comentarios;
	}
	
	/**
	 * @return java.lang.String
	 */
	public java.lang.String getIndicaciones () {
		return indicaciones;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdfamilia () {
		return idfamilia;
	}
		
	
	/**
	 * @param idproducto
	 */
	public void setIdproducto(java.math.BigDecimal idproducto) {
		this.idproducto = idproducto;
	}
	
	/**
	 * @param nombre
	 */
	public void setNombre(java.lang.String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @param presentacion
	 */
	public void setPresentacion(java.lang.String presentacion) {
		this.presentacion = presentacion;
	}
	
		
	public java.math.BigDecimal getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(java.math.BigDecimal idcategoria) {
		this.idcategoria = idcategoria;
	}

	/**
	 * @param codigo
	 */
	public void setCodigo(java.lang.String codigo) {
		this.codigo = codigo;
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
	
	/**
	 * @param valor
	 */
	public void setValor(java.math.BigDecimal valor) {
		this.valor = valor;
	}
	
	

	public Collection getProvprods() {
		return provprods;
	}

	public void setProvprods(Collection provprods) {
		this.provprods = provprods;
	}

	/**
	 * @param precioventa
	 */
	public void setPrecioventa(java.math.BigDecimal precioventa) {
		this.precioventa = precioventa;
	}
	
	/**
	 * @param cantidadmin
	 */
	public void setCantidadmin(java.math.BigDecimal cantidadmin) {
		this.cantidadmin = cantidadmin;
	}
	
	
	
	public java.math.BigDecimal getIdlaboratorio() {
		return idlaboratorio;
	}

	public void setIdlaboratorio(java.math.BigDecimal idlaboratorio) {
		this.idlaboratorio = idlaboratorio;
	}

	/**
	 * @param comentarios
	 */
	public void setComentarios(java.lang.String comentarios) {
		this.comentarios = comentarios;
	}
	
	/**
	 * @param indicaciones
	 */
	public void setIndicaciones(java.lang.String indicaciones) {
		this.indicaciones = indicaciones;
	}
	
	/**
	 * @param idfamilia
	 */
	public void setIdfamilia(java.math.BigDecimal idfamilia) {
		this.idfamilia = idfamilia;
	}

	public java.lang.String getFamdesc() {
		return famdesc;
	}

	public void setFamdesc(java.lang.String famdesc) {
		this.famdesc = famdesc;
	}

	public java.lang.String getLabdesc() {
		return labdesc;
	}

	public void setLabdesc(java.lang.String labdesc) {
		this.labdesc = labdesc;
	}

	/**
	 * Se utilizo para la prioridad es decir si un medicamento es urgente
	 * @return
	 */
	public java.math.BigDecimal getCaja() {
		return caja;
	}
	
	public void setCaja(java.math.BigDecimal caja) {
		this.caja = caja;
	}

	public java.math.BigDecimal getSobre() {
		return sobre;
	}

	public void setSobre(java.math.BigDecimal sobre) {
		this.sobre = sobre;
	}

	public java.lang.String getCatdesc() {
		return catdesc;
	}

	public void setCatdesc(java.lang.String catdesc) {
		this.catdesc = catdesc;
	}

	public java.lang.String getCatdescd() {
		return catdescd;
	}

	public void setCatdescd(java.lang.String catdescd) {
		this.catdescd = catdescd;
	}

	public java.math.BigDecimal getIdcategoriad() {
		return idcategoriad;
	}

	public void setIdcategoriad(java.math.BigDecimal idcategoriad) {
		this.idcategoriad = idcategoriad;
	}

	public java.lang.String getInvima() {
		return invima;
	}

	public void setInvima(java.lang.String invima) {
		this.invima = invima;
	}
		
}

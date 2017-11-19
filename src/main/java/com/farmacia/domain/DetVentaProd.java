
package com.farmacia.domain;

import java.math.BigDecimal;

import com.farmacia.util.Utilitario;

/**
 * Clase que representa un objeto de la tabla Detventa
 * @author SPEEDY
 * 
 */
 
public class DetVentaProd implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Definición de atributos privados de clase:
	 */
			private BigDecimal iddetventa; 
			private BigDecimal idventa; 
			private BigDecimal idproducto; 
			private BigDecimal idlaboratorio; 
			private BigDecimal fecha; 
			private BigDecimal cantidad; 
			private BigDecimal valor; 
			private BigDecimal valorunit; 
			private BigDecimal marca; 
			private BigDecimal presentacion;
			private BigDecimal dias; 
			private String nombreProducto; 
			private String usuario; 
			private String labdesc;
			
	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */		
			
			
			public BigDecimal getCantidad() {
				return cantidad;
			}
			public void setCantidad(BigDecimal cantidad) {
				this.cantidad = cantidad;
			}
			public BigDecimal getIddetventa() {
				return iddetventa;
			}
			public void setIddetventa(BigDecimal iddetventa) {
				this.iddetventa = iddetventa;
			}
			public BigDecimal getIdlaboratorio() {
				return idlaboratorio;
			}
			public void setIdlaboratorio(BigDecimal idlaboratorio) {
				this.idlaboratorio = idlaboratorio;
			}
			public BigDecimal getIdproducto() {
				return idproducto;
			}
			public void setIdproducto(BigDecimal idproducto) {
				this.idproducto = idproducto;
			}
			public BigDecimal getIdventa() {
				return idventa;
			}
			public void setIdventa(BigDecimal idventa) {
				this.idventa = idventa;
			}
			public String getLabdesc() {
				return labdesc;
			}
			public void setLabdesc(String labdesc) {
				this.labdesc = labdesc;
			}
			public BigDecimal getMarca() {
				return marca;
			}
			public void setMarca(BigDecimal marca) {
				this.marca = marca;
			}
			public String getNombreProducto() {
				return nombreProducto;
			}
			public void setNombreProducto(String nombreProducto) {
				this.nombreProducto = nombreProducto;
			}
			public BigDecimal getPresentacion() {
				return presentacion;
			}
			public void setPresentacion(BigDecimal presentacion) {
				this.presentacion = presentacion;
			}
			public BigDecimal getValor() {
				return valor;
			}
			public void setValor(BigDecimal valor) {
				this.valor = valor;
			}
			public BigDecimal getValorunit() {
				return valorunit;
			}
			public void setValorunit(BigDecimal valorunit) {
				this.valorunit = valorunit;
			}
			public String getUsuario() {
				return usuario;
			}
			public void setUsuario(String usuario) {
				this.usuario = usuario;
			}
			public BigDecimal getFecha() {
				return fecha;
			}
			public void setFecha(BigDecimal fecha) {
				this.fecha = fecha;
			} 

			public String getFechaFormated() {
				return Utilitario.formatoDate(""+fecha);
			}
			public BigDecimal getDias() {
				return dias;
			}
			public void setDias(BigDecimal dias) {
				this.dias = dias;
			}
		
}

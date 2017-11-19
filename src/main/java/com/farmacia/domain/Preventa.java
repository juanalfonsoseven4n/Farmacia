
package com.farmacia.domain;

import java.math.BigDecimal;

import com.farmacia.util.Utilitario;

/**
 * Clase que representa un objeto de la tabla Detventa
 * @author SPEEDY
 * 
 */
 
public class Preventa implements java.io.Serializable {

	
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
			private BigDecimal fechaVenta; 
			private BigDecimal cantidad; 
			private BigDecimal valor; 
			private BigDecimal valorunit;
			private BigDecimal precioventa; 
			private String presentacion;
			private BigDecimal fechaProxVenta;
			private BigDecimal idcliente;
			private String nombreProducto;
			private String nombreLaboratorio;
			private String nombre; 
			private String telefono;
			private String direccion;
			private String apellido;
			
			
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
						
			public String getNombreProducto() {
				return nombreProducto;
			}
			public void setNombreProducto(String nombreProducto) {
				this.nombreProducto = nombreProducto;
			}
			public String getPresentacion() {
				return presentacion;
			}
			public void setPresentacion(String presentacion) {
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
			
			public String getDireccion() {
				return direccion;
			}
			public void setDireccion(String direccion) {
				this.direccion = direccion;
			}
			public String getFechaProxVentaFormated() {
				return  Utilitario.formatoDate(""+fechaProxVenta);
			}
			public void setFechaProxVenta(BigDecimal fechaProxVenta) {
				this.fechaProxVenta = fechaProxVenta;
			}
			public String getFechaVentaFormated() {
				return  Utilitario.formatoDate(""+fechaVenta);
			}
			public void setFechaVenta(BigDecimal fechaVenta) {
				this.fechaVenta = fechaVenta;
			}
			public String getTelefono() {
				return telefono;
			}
			public void setTelefono(String telefono) {
				this.telefono = telefono;
			}
			public BigDecimal getFechaProxVenta() {
				return fechaProxVenta;
			}
			public BigDecimal getFechaVenta() {
				return fechaVenta;
			}
			public String getApellido() {
				return apellido;
			}
			public void setApellido(String apellido) {
				this.apellido = apellido;
			}
			public BigDecimal getIdcliente() {
				return idcliente;
			}
			public void setIdcliente(BigDecimal idcliente) {
				this.idcliente = idcliente;
			}
			public String getNombre() {
				return nombre;
			}
			public void setNombre(String nombre) {
				this.nombre = nombre;
			}
			public String getNombreLaboratorio() {
				return nombreLaboratorio;
			}
			public void setNombreLaboratorio(String nombreLaboratorio) {
				this.nombreLaboratorio = nombreLaboratorio;
			}
			public BigDecimal getPrecioventa() {
				return precioventa;
			}
			public void setPrecioventa(BigDecimal precioventa) {
				this.precioventa = precioventa;
			}
			
		
}


package com.farmacia.domain;

import com.farmacia.util.Utilitario;

/**
 * Clase que representa un objeto de la tabla Movimiento
 * @author SPEEDY
 * 
 */
 
public class Movimiento implements java.io.Serializable,Comparable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Definición de atributos privados de clase:
	 */
			protected java.math.BigDecimal fecha; 
			protected java.math.BigDecimal cantidad; 
			protected java.math.BigDecimal valor; 
			protected java.lang.String codigo; 
			protected java.math.BigDecimal idusuario; 
			protected java.math.BigDecimal tipo; 
			protected java.math.BigDecimal preciocosto; 
			protected java.math.BigDecimal precio; 
			protected java.math.BigDecimal idmovimiento; 
			protected java.math.BigDecimal idfarmacia; 
			protected java.math.BigDecimal idproducto; 
			protected java.math.BigDecimal hora; 
			protected java.lang.String usudesc;
			protected java.lang.String farmdesc;
			protected java.lang.String proddesc;
			protected java.lang.String catdesc;
			protected java.lang.String catdescd;
			protected java.lang.String labdesc;
			protected java.lang.String presentacion;
			protected java.math.BigDecimal cantidadSobre; 
			protected java.math.BigDecimal cantidadCaja;
			protected java.math.BigDecimal valorMercancia;
			protected java.math.BigDecimal valorMercanciaCompra;
			protected java.math.BigDecimal unidades;
			protected java.math.BigDecimal fechaexp;
			protected java.math.BigDecimal iddetventa;
			protected java.math.BigDecimal precioVentaUnid;
			protected java.math.BigDecimal precioVentaCaja;
			protected java.lang.String lote;
			protected java.lang.String cuarentena;
			protected java.lang.String prioritario;
			protected java.math.BigDecimal vendido;
			protected String codigofac;
			protected String codigoBarras;
	
	public String getCodigoBarras() {
			return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public java.math.BigDecimal getCantidadCaja() {
		return cantidadCaja;
	}

	public void setCantidadCaja(java.math.BigDecimal cantidadCaja) {
		this.cantidadCaja = cantidadCaja;
	}

	public java.math.BigDecimal getCantidadSobre() {
		return cantidadSobre;
	}

	public void setCantidadSobre(java.math.BigDecimal cantidadSobre) {
		this.cantidadSobre = cantidadSobre;
	}

	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	
	
	public java.lang.String getFarmdesc() {
				return farmdesc;
			}

	public void setFarmdesc(java.lang.String farmdesc) {
		this.farmdesc = farmdesc;
	}

	public java.lang.String getProddesc() {
		return proddesc;
	}

	public void setProddesc(java.lang.String proddesc) {
		this.proddesc = proddesc;
	}

	public java.lang.String getUsudesc() {
		return usudesc;
	}

	public void setUsudesc(java.lang.String usudesc) {
		this.usudesc = usudesc;
	}

	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getFecha () {
		return fecha;
	}
	
	public String getFechaFormated() {
		return Utilitario.formatoDate(""+fecha);
	}
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getCantidad () {
		return cantidad;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getValor () {
		return valor;
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
	public java.math.BigDecimal getIdusuario () {
		return idusuario;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getTipo () {
		return tipo;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getPreciocosto () {
		return preciocosto;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getPrecio () {
		return precio;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdmovimiento () {
		return idmovimiento;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdfarmacia () {
		return idfarmacia;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdproducto () {
		return idproducto;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getHora () {
		return hora;
	}
		
	
	
	
	/**
	 * @param fecha
	 */
	public void setFecha(java.math.BigDecimal fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * @param cantidad
	 */
	public void setCantidad(java.math.BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	
	/**
	 * @param valor
	 */
	public void setValor(java.math.BigDecimal valor) {
		this.valor = valor;
	}
	
	/**
	 * @param codigo
	 */
	public void setCodigo(java.lang.String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * @param idusuario
	 */
	public void setIdusuario(java.math.BigDecimal idusuario) {
		this.idusuario = idusuario;
	}
	
	/**
	 * @param tipo
	 */
	public void setTipo(java.math.BigDecimal tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * @param preciocosto
	 */
	public void setPreciocosto(java.math.BigDecimal preciocosto) {
		this.preciocosto = preciocosto;
	}
	
	/**
	 * @param precio
	 */
	public void setPrecio(java.math.BigDecimal precio) {
		this.precio = precio;
	}
	
	/**
	 * @param idmovimiento
	 */
	public void setIdmovimiento(java.math.BigDecimal idmovimiento) {
		this.idmovimiento = idmovimiento;
	}
	
	/**
	 * @param idfarmacia
	 */
	public void setIdfarmacia(java.math.BigDecimal idfarmacia) {
		this.idfarmacia = idfarmacia;
	}
	
	/**
	 * @param idproducto
	 */
	public void setIdproducto(java.math.BigDecimal idproducto) {
		this.idproducto = idproducto;
	}
	
	/**
	 * @param hora
	 */
	public void setHora(java.math.BigDecimal hora) {
		this.hora = hora;
	}

	public java.math.BigDecimal getUnidades() {
		return unidades;
	}

	public void setUnidades(java.math.BigDecimal unidades) {
		this.unidades = unidades;
	}

	public java.math.BigDecimal getFechaexp() {
		return fechaexp;
	}

	public void setFechaexp(java.math.BigDecimal fechaexp) {
		this.fechaexp = fechaexp;
	}
	public String getFechaexpFormated() {
		return Utilitario.formatoDate(""+fechaexp);
	}

	public java.lang.String getLote() {
		return lote;
	}

	public void setLote(java.lang.String lote) {
		this.lote = lote;
	}

	public java.math.BigDecimal getValorMercancia() {
		return valorMercancia;
	}

	public void setValorMercancia(java.math.BigDecimal valorMercancia) {
		this.valorMercancia = valorMercancia;
	}

	public java.math.BigDecimal getValorMercanciaCompra() {
		return valorMercanciaCompra;
	}

	public void setValorMercanciaCompra(java.math.BigDecimal valorMercanciaCompra) {
		this.valorMercanciaCompra = valorMercanciaCompra;
	}

	public java.math.BigDecimal getIddetventa() {
		return iddetventa;
	}

	public void setIddetventa(java.math.BigDecimal iddetventa) {
		this.iddetventa = iddetventa;
	}

	public java.math.BigDecimal getPrecioVentaCaja() {
		return precioVentaCaja;
	}

	public void setPrecioVentaCaja(java.math.BigDecimal precioVentaCaja) {
		this.precioVentaCaja = precioVentaCaja;
	}

	public java.math.BigDecimal getPrecioVentaUnid() {
		return precioVentaUnid;
	}

	public void setPrecioVentaUnid(java.math.BigDecimal precioVentaUnid) {
		this.precioVentaUnid = precioVentaUnid;
	}

	public java.lang.String getCatdesc() {
		return catdesc;
	}

	public void setCatdesc(java.lang.String catdesc) {
		this.catdesc = catdesc;
	}

	public int compareTo(Object movimiento) {
		int result = catdesc.compareTo(((Movimiento)movimiento).getCatdesc());
		return result;
	}

	public java.lang.String getCatdescd() {
		return catdescd;
	}

	public void setCatdescd(java.lang.String catdescd) {
		this.catdescd = catdescd;
	}

	public java.lang.String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(java.lang.String presentacion) {
		this.presentacion = presentacion;
	}

	public java.lang.String getCuarentena() {
		return cuarentena;
	}

	public void setCuarentena(java.lang.String cuarentena) {
		this.cuarentena = cuarentena;
	}

	public java.math.BigDecimal getVendido() {
		return vendido;
	}

	public void setVendido(java.math.BigDecimal vendido) {
		this.vendido = vendido;
	}

	public String getCodigofac() {
		return codigofac;
	}

	public void setCodigofac(String codigofac) {
		this.codigofac = codigofac;
	}

	public java.lang.String getLabdesc() {
		return labdesc;
	}

	public void setLabdesc(java.lang.String labdesc) {
		this.labdesc = labdesc;
	}

	public java.lang.String getPrioritario() {
		return prioritario;
	}

	public void setPrioritario(java.lang.String prioritario) {
		this.prioritario = prioritario;
	}

	

	
}

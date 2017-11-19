

package com.farmacia.form;

import java.math.BigDecimal;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



/**
 * Clase que representa un objeto de la tabla MovimientoForm
 * @author SPEEDY
 * 
 */

public class MovimientoForm extends ValidatorForm  {
	  
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	  private int strutsAction;
	  private String strutsOrderby;
	  private String searchButton = "";
	  private String strutsLimit;
	  private String strutsButton = "";
	  
	/**
	 * Definición de atributos privados de clase:
	 */
			private String fecha; 
			private String fechafin; 
			private String fechaini; 
			private String cantidad; 
			private String valor; 
			private String codigo; 
			private String idusuario; 
			private String tipo; 
			private String preciocosto; 
			private String precio; 
			private String idmovimiento; 
			private String idfarmacia; 
			private String idproducto; 
			private String idcategoria;
			private String idlaboratorio;
			private String horas; 
			private String minutos;
			private String usudesc;
			private String farmdesc;
			private String proddesc;
			private String cantidadSobre; 
			private String cantidadCaja; 
			private String unidades; 
			private String fechaexp;
			private String lote;
			private BigDecimal totalCompras;
			private BigDecimal totalVentas;
			private BigDecimal totalMercancia;
			private BigDecimal totalMercanciaCompra;
			private String vendido; 
			private String codigofac;
			
	public String getCodigofac() {
				return codigofac;
			}

			public void setCodigofac(String codigofac) {
				this.codigofac = codigofac;
			}

	public BigDecimal getTotalCompras() {
		return totalCompras;
	}

	public BigDecimal getTotalMercancia() {
		return totalMercancia;
	}

	public BigDecimal getTotalVentas() {
		return totalVentas;
	}

	public String getCantidadCaja() {
		return cantidadCaja;
	}

	public void setCantidadCaja(String cantidadCaja) {
		this.cantidadCaja = cantidadCaja;
	}

	public String getCantidadSobre() {
		return cantidadSobre;
	}

	public void setCantidadSobre(String cantidadSobre) {
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
	public String getFecha () {
		return fecha;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getCantidad () {
		return cantidad;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getValor () {
		return valor;
	}
	
	/**
	 * @return java.lang.String
	 */
	public String getCodigo () {
		return codigo;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdusuario () {
		return idusuario;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getTipo () {
		return tipo;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getPreciocosto () {
		return preciocosto;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getPrecio () {
		return precio;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdmovimiento () {
		return idmovimiento;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdfarmacia () {
		return idfarmacia;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdproducto () {
		return idproducto;
	}
	
	
	
	
	/**
	 * @param fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * @param cantidad
	 */
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	/**
	 * @param valor
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	/**
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * @param idusuario
	 */
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	
	/**
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * @param preciocosto
	 */
	public void setPreciocosto(String preciocosto) {
		this.preciocosto = preciocosto;
	}
	
	/**
	 * @param precio
	 */
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	/**
	 * @param idmovimiento
	 */
	public void setIdmovimiento(String idmovimiento) {
		this.idmovimiento = idmovimiento;
	}
	
	/**
	 * @param idfarmacia
	 */
	public void setIdfarmacia(String idfarmacia) {
		this.idfarmacia = idfarmacia;
	}
	
	/**
	 * @param idproducto
	 */
	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}
	
	

	public void clear () {
	  				
			 	fecha = "0";
			 	fechaexp = "0";
				fechafin = "0"; 
				fechaini = "0"; 
				cantidad = "0"; 
				valor = "0"; 
				codigo = "0"; 
				idusuario = "0"; 
				tipo = "0"; 
				preciocosto = "0"; 
				precio = "0"; 
				idmovimiento = "0"; 
				idfarmacia = "0"; 
				idproducto = "0"; 
				horas = "00"; 
				minutos = "00";
				usudesc = "00";
				farmdesc = "00";
				proddesc  = "0";
				cantidadSobre = "0"; 
				cantidadCaja = "0"; 
				unidades = "0"; 
				lote = "0"; 
				vendido = "0";
			}
	public void clearStrings() {
					
					 fecha = "";
					 fechaexp = "";
					 fechafin = "0"; 
					 fechaini = "0"; 
					 cantidad = ""; 
					 valor = ""; 
					 codigo = ""; 
					 idusuario = ""; 
					 tipo = ""; 
					 preciocosto = ""; 
					 precio = ""; 
					 idmovimiento = ""; 
					 idfarmacia = ""; 
					 idproducto = ""; 
					 horas = "0";
					 minutos = "00";
					 usudesc = "";
					 farmdesc = "";
					 proddesc = "";
					 lote = "";
					 vendido = "0";
			}

	public ActionErrors validate(ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
		    ActionErrors aes = super.validate(mapping, request);
		    return aes;
		  }	
	public String getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(String searchButton) {
		this.searchButton = searchButton;
	}

	public int getStrutsAction() {
		return strutsAction;
	}

	public void setStrutsAction(int strutsAction) {
		this.strutsAction = strutsAction;
	}

	public String getStrutsButton() {
		return strutsButton;
	}

	public void setStrutsButton(String strutsButton) {
		this.strutsButton = strutsButton;
	}

	public String getStrutsLimit() {
		return strutsLimit;
	}

	public void setStrutsLimit(String strutsLimit) {
		this.strutsLimit = strutsLimit;
	}

	public String getStrutsOrderby() {
		return strutsOrderby;
	}

	public void setStrutsOrderby(String strutsOrderby) {
		this.strutsOrderby = strutsOrderby;
	}

	public String getHoras() {
		return horas;
	}

	public void setHoras(String horas) {
		this.horas = horas;
	}

	public String getMinutos() {
		return minutos;
	}

	public void setMinutos(String minutos) {
		this.minutos = minutos;
	}

	public String getFechafin() {
		return fechafin;
	}
	public long getFechafinNum() {
		return Long.parseLong(fechafin);
	}
	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}

	public String getFechaini() {
		return fechaini;
	}
	public long getFechainiNum() {
		return Long.parseLong(fechaini);
	}
	public void setFechaini(String fechaini) {
		this.fechaini = fechaini;
	}

	public String getUnidades() {
		return unidades;
	}

	public void setUnidades(String unidades) {
		this.unidades = unidades;
	}

	public String getFechaexp() {
		return fechaexp;
	}

	public void setFechaexp(String fechaexp) {
		this.fechaexp = fechaexp;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public void setTotalCompras(BigDecimal totalCompras) {
		this.totalCompras = totalCompras;
	}

	public void setTotalMercancia(BigDecimal totalMercancia) {
		this.totalMercancia = totalMercancia;
	}

	public void setTotalVentas(BigDecimal totalVentas) {
		this.totalVentas = totalVentas;
	}

	public BigDecimal getTotalMercanciaCompra() {
		return totalMercanciaCompra;
	}

	public void setTotalMercanciaCompra(BigDecimal totalMercanciaCompra) {
		this.totalMercanciaCompra = totalMercanciaCompra;
	}

	public String getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(String idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getVendido() {
		return vendido;
	}

	public void setVendido(String vendido) {
		this.vendido = vendido;
	}

	public String getIdlaboratorio() {
		return idlaboratorio;
	}

	public void setIdlaboratorio(String idlaboratorio) {
		this.idlaboratorio = idlaboratorio;
	}

	


}

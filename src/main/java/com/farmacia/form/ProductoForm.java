

package com.farmacia.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



/**
 * Clase que representa un objeto de la tabla ProductoForm
 * @author SPEEDY
 * 
 */

public class ProductoForm extends ValidatorForm  {
	  
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
			private String idproducto; 
			private String nombre; 
			private String presentacion; 
			private String idcategoria; 
			private String idcategoriad; 
			private String codigo; 
			private String iva; 
			private String valorunit; 
			private String valor; 
			private String precioventa; 
			private String cantidadmin; 
			private String idlaboratorio; 
			private String comentarios; 
			private String indicaciones; 
			private String idfamilia; 
			private String labdesc;
			private String catdesc;
			private String catdescd;
			private String famdesc; 
			private String idproveedor; 
			private String valorprovprod; 
			private String sobre; 
			private String caja; 
			private String invima; 
			private String barcode; 


	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdproducto () {
		return idproducto;
	}
	
	/**
	 * @return java.lang.String
	 */
	public String getNombre () {
		return nombre;
	}
	
	/**
	 * @return java.lang.String
	 */
	public String getPresentacion () {
		return presentacion;
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
	public String getIva () {
		return iva;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getValorunit () {
		return valorunit;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getValor () {
		return valor;
	}

	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getPrecioventa () {
		return precioventa;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getCantidadmin () {
		return cantidadmin;
	}
	
	
	
	/**
	 * @return java.lang.String
	 */
	public String getComentarios () {
		return comentarios;
	}
	
	/**
	 * @return java.lang.String
	 */
	public String getIndicaciones () {
		return indicaciones;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdfamilia () {
		return idfamilia;
	}
		
	
	/**
	 * @param idproducto
	 */
	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}
	
	/**
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @param presentacion
	 */
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
	
	
	
	/**
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * @param iva
	 */
	public void setIva(String iva) {
		this.iva = iva;
	}
	
	/**
	 * @param valorunit
	 */
	public void setValorunit(String valorunit) {
		this.valorunit = valorunit;
	}
	
	/**
	 * @param valor
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	/**
	 * @param precioventa
	 */
	public void setPrecioventa(String precioventa) {
		this.precioventa = precioventa;
	}
	
	/**
	 * @param cantidadmin
	 */
	public void setCantidadmin(String cantidadmin) {
		this.cantidadmin = cantidadmin;
	}
	
	
	
	public String getIdlaboratorio() {
		return idlaboratorio;
	}

	public void setIdlaboratorio(String idlaboratorio) {
		this.idlaboratorio = idlaboratorio;
	}

	/**
	 * @param comentarios
	 */
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	/**
	 * @param indicaciones
	 */
	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}
	
	/**
	 * @param idfamilia
	 */
	public void setIdfamilia(String idfamilia) {
		this.idfamilia = idfamilia;
	}
	

	public void clear () {
	  				 idproducto = "0"; 
					 nombre = ""; 
					 presentacion = ""; 
					 idcategoria = "0";
					 idcategoriad = "0";
					 codigo = ""; 
					 iva = "0"; 
					 valorunit = "0"; 
					 valor = "0"; 
					 precioventa = "0"; 
					 cantidadmin = "0"; 
					 idlaboratorio = ""; 
					 comentarios = ""; 
					 indicaciones = ""; 
					 idfamilia = "0"; 
					 famdesc ="";
			}
	public void clearStrings() {
					 idproducto = ""; 
					 nombre = ""; 
					 presentacion = ""; 
					 idcategoria = "0";
					 idcategoriad = "0";
					 codigo = ""; 
					 iva = "0"; 
					 valorunit = "0"; 
					 valor = "0"; 
					 precioventa = "0"; 
					 cantidadmin = "0"; 
					 idlaboratorio = ""; 
					 comentarios = ""; 
					 indicaciones = ""; 
					 idfamilia = ""; 
					 idproveedor = ""; 
					 valorprovprod= "";
					 famdesc ="";
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

	public String getFamdesc() {
		return famdesc;
	}

	public void setFamdesc(String famdesc) {
		this.famdesc = famdesc;
	}

	public String getLabdesc() {
		return labdesc;
	}

	public void setLabdesc(String labdesc) {
		this.labdesc = labdesc;
	}

	public String getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(String idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getValorprovprod() {
		return valorprovprod;
	}

	public void setValorprovprod(String valorprovprod) {
		this.valorprovprod = valorprovprod;
	}

	public String getCaja() {
		return caja;
	}

	public void setCaja(String caja) {
		this.caja = caja;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	public String getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(String idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getCatdesc() {
		return catdesc;
	}

	public void setCatdesc(String catdesc) {
		this.catdesc = catdesc;
	}

	public String getCatdescd() {
		return catdescd;
	}

	public void setCatdescd(String catdescd) {
		this.catdescd = catdescd;
	}

	public String getIdcategoriad() {
		return idcategoriad;
	}

	public void setIdcategoriad(String idcategoriad) {
		this.idcategoriad = idcategoriad;
	}

	public String getInvima() {
		return invima;
	}

	public void setInvima(String invima) {
		this.invima = invima;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
}

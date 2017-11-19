

package com.farmacia.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



/**
 * Clase que representa un objeto de la tabla ProveedorForm
 * @author SPEEDY
 * 
 */

public class ProveedorForm extends ValidatorForm  {
	  
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
			private String idproveedor; 
			private String nombre; 
			private String descripcion; 
			private String codigo; 
			private String telefono; 
			private String direccion; 
			private String representante; 
			private String telefono2; 
			private String mail; 
			private String nit; 
	


	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdproveedor () {
		return idproveedor;
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
	public String getDescripcion () {
		return descripcion;
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
	public String getTelefono () {
		return telefono;
	}
	
	/**
	 * @return java.lang.String
	 */
	public String getDireccion () {
		return direccion;
	}
	
	/**
	 * @return java.lang.String
	 */
	public String getRepresentante () {
		return representante;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getTelefono2 () {
		return telefono2;
	}
	
	/**
	 * @return java.lang.String
	 */
	public String getMail () {
		return mail;
	}
	
	/**
	 * @return java.lang.String
	 */
	public String getNit () {
		return nit;
	}
		
	
	/**
	 * @param idproveedor
	 */
	public void setIdproveedor(String idproveedor) {
		this.idproveedor = idproveedor;
	}
	
	/**
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * @param representante
	 */
	public void setRepresentante(String representante) {
		this.representante = representante;
	}
	
	/**
	 * @param telefono2
	 */
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	
	/**
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * @param nit
	 */
	public void setNit(String nit) {
		this.nit = nit;
	}
	

	public void clear () {
	  				 idproveedor = "0"; 
					 nombre = ""; 
					 descripcion = ""; 
					 codigo = ""; 
					 telefono = "0"; 
					 direccion = ""; 
					 representante = ""; 
					 telefono2 = "0"; 
					 mail = ""; 
					 nit = ""; 
			}
	public void clearStrings() {
					 idproveedor = ""; 
					 nombre = ""; 
					 descripcion = ""; 
					 codigo = ""; 
					 telefono = "0"; 
					 direccion = ""; 
					 representante = ""; 
					 telefono2 = "0"; 
					 mail = ""; 
					 nit = ""; 
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
}

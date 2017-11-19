

package com.farmacia.form;

import java.math.BigDecimal;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import com.farmacia.domain.Cliente;
import com.farmacia.domain.Usuario;
import com.farmacia.util.Utilitario;



/**
 * Clase que representa un objeto de la tabla VentaForm
 * @author SPEEDY
 * 
 */

public class VentaForm extends ValidatorForm  {
	  
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
		private String idventa; 
		private String fecha; 
		private String idusuario; 
		private String idmedico; 
		private String valortotal; 
		private String iva; 
		private String idcliente; 
		private String idfarmacia; 
		private String codigo; 
		private String hora; 
		private String idproducto; 
		private String cantidad; 
		private String valor; 
		private String iddetventa; 
		private String valorunit; 
		private String medico; 
		private String vendedor;
		private String cliente;
		private String valorunitsobre;
		private String marca;
		//para registrarf
		private boolean marca1;
		private String presentacion;
		private String descusuario;
		private String desccliente;
		private String fechafin; 
		private String fechaini; 
		private String usuario; 
		private String idclasificacion; 
		private String descproducto; 
		private String idlaboratorio;
		private String dias;
		private BigDecimal totalVentas;
		private BigDecimal totalVentasConsulta;
		private String ivadet = "";

	public BigDecimal getTotalVentas() {
			return totalVentas;
		}

		public void setTotalVentas(BigDecimal totalVentas) {
			this.totalVentas = totalVentas;
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

		public long getFechainiNum() {
			return Long.parseLong(fechaini);
		}
		public String getFechaini() {
			return fechaini;
		}

		public void setFechaini(String fechaini) {
			this.fechaini = fechaini;
		}

	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	public String getPresentacion() {
				return presentacion;
			}

			public void setPresentacion(String presentacion) {
				this.presentacion = presentacion;
			}

	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdventa () {
		return idventa;
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
	public String getIdusuario () {
		return idusuario;
	}
	public Long getIdusuarioNum() {
		return Long.parseLong(idusuario);
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdmedico () {
		return idmedico;
	}
	public Long getIdmedicoNum() {
		return Long.parseLong(idmedico);
	}
	/**
	 * @return java.math.BigDecimal
	 */
	public String getValortotal () {
		return valortotal;
	}
	
	public BigDecimal getValortotalNum() {
		return new BigDecimal(valortotal);
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIva () {
		return iva;
	}
	
	public BigDecimal getIvaNum() {
		return new BigDecimal(iva);
	}
	
	
	
	public String getIvadet() {
		return ivadet;
	}

	public void setIvadet(String ivadet) {
		this.ivadet = ivadet;
	}

	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdcliente () {
		return idcliente;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdfarmacia () {
		return idfarmacia;
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
	public String getValor () {
		return valor;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getHora () {
		return hora;
	}
		
	
	/**
	 * @param idventa
	 */
	public void setIdventa(String idventa) {
		this.idventa = idventa;
	}
	
	/**
	 * @param fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * @param idusuario
	 */
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	
	/**
	 * @param idmedico
	 */
	public void setIdmedico(String idmedico) {
		this.idmedico = idmedico;
	}
	
	/**
	 * @param valortotal
	 */
	public void setValortotal(String valortotal) {
		this.valortotal = valortotal;
	}
	
	/**
	 * @param iva
	 */
	public void setIva(String iva) {
		this.iva = iva;
	}
	
	/**
	 * @param idcliente
	 */
	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
	}
	
	/**
	 * @param idfarmacia
	 */
	public void setIdfarmacia(String idfarmacia) {
		this.idfarmacia = idfarmacia;
	}
	
	/**
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * @param valor
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	/**
	 * @param hora
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}
	

	public void clear () {
	  				idventa = "0"; 
					fecha = "0"; 
					idusuario = "0"; 
					idmedico = "0"; 
					valortotal = "0"; 
					iva = "0"; 
					ivadet = "0"; 
					idcliente = "0"; 
					idfarmacia = "0"; 
					codigo = ""; 
					valor = "0"; 
					hora = "0"; 
					valorunitsobre = "0"; 
					marca = "0"; 
					presentacion = "0"; 
					descusuario = "0"; 
					desccliente = "0"; 
			}
	public void clearStrings() {
					 idventa = ""; 
					 fecha = ""; 
					 idusuario = ""; 
					 idmedico = ""; 
					 valortotal = ""; 
					 iva = ""; 
					 ivadet = ""; 
					 idcliente = ""; 
					 idfarmacia = ""; 
					 codigo = ""; 
					 valor = ""; 
					 hora = ""; 
					 valorunitsobre = "0"; 
					 marca = "0"; 
					 presentacion = "1"; 
					 descusuario = ""; 
					 desccliente = ""; 
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

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getIddetventa() {
		return iddetventa;
	}

	public void setIddetventa(String iddetventa) {
		this.iddetventa = iddetventa;
	}

	public String getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getValorunit() {
		return valorunit;
	}

	public void setValorunit(String valorunit) {
		this.valorunit = valorunit;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(Cliente ucliente) {
		
		this.cliente = (ucliente.getNombre()!=null?ucliente.getNombre():"")+" "+(ucliente.getApellido()!=null?ucliente.getApellido():"");
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(Usuario umedico) {
		this.medico = umedico.getDescripcion();
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(Usuario uvendedor) {
		this.vendedor = uvendedor.getDescripcion();
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getValorunitsobre() {
		return valorunitsobre;
	}

	public void setValorunitsobre(String valorunitsobre) {
		this.valorunitsobre = valorunitsobre;
	}

	public String getDesccliente() {
		return desccliente;
	}

	public void setDesccliente(String desccliente) {
		this.desccliente = desccliente;
	}

	public String getDescusuario() {
		return descusuario;
	}

	public void setDescusuario(String descusuario) {
		this.descusuario = descusuario;
	}
	public String getHoraFormated() {
		return Utilitario.formatoHora(""+hora);
	}
	public String getFechaFormated() {
		return Utilitario.formatoDate(""+fecha);
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getTotalVentasConsulta() {
		return totalVentasConsulta;
	}

	public void setTotalVentasConsulta(BigDecimal totalVentasConsulta) {
		this.totalVentasConsulta = totalVentasConsulta;
	}

	public String getDescproducto() {
		return descproducto;
	}

	public void setDescproducto(String descproducto) {
		this.descproducto = descproducto;
	}

	public String getIdclasificacion() {
		return idclasificacion;
	}
	
	public long getIdclasificacionNum() {
		return Long.parseLong(idclasificacion);
	}

	public void setIdclasificacion(String idclasificacion) {
		this.idclasificacion = idclasificacion;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getIdlaboratorio() {
		return idlaboratorio;
	}
	
	public long getIdlaboratorioNum() {
		return Long.parseLong(idlaboratorio);
	}

	public void setIdlaboratorio(String idlaboratorio) {
		this.idlaboratorio = idlaboratorio;
	}

	public boolean isMarca1() {
		return marca1;
	}

	public void setMarca1(boolean marca1) {
		this.marca1 = marca1;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	
}

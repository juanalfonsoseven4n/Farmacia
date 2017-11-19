
package com.farmacia.domain;

import java.util.List;

import com.farmacia.util.Utilitario;

/**
 * Clase que representa un objeto de la tabla Venta
 * @author SPEEDY
 * 
 */
 
public class Venta implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Definición de atributos privados de clase:
	 */
			private java.math.BigDecimal idventa; 
			private java.math.BigDecimal fecha; 
			private java.math.BigDecimal idusuario; 
			private java.math.BigDecimal idmedico; 
			private java.math.BigDecimal valortotal; 
			private java.math.BigDecimal iva; 
			private java.math.BigDecimal idcliente; 
			private java.math.BigDecimal idfarmacia; 
			private java.math.BigDecimal codigo; 
			private java.math.BigDecimal valor; 
			private java.math.BigDecimal hora;
			private boolean marca1;
			private List detalles;
			private Usuario medico; 
			private Usuario vendedor;
			private Cliente cliente;
			
	
	

	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	public List getDetalles() {
				return detalles;
			}

			public void setDetalles(List detalles) {
				this.detalles = detalles;
			}

	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdventa () {
		return idventa;
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
	public java.math.BigDecimal getIdusuario () {
		return idusuario;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdmedico () {
		return idmedico;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getValortotal () {
		return valortotal;
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
	public java.math.BigDecimal getIdcliente () {
		return idcliente;
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
	public java.math.BigDecimal getValor () {
		return valor;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getHora () {
		return hora;
	}

	public String getHoraFormated() {
		return Utilitario.formatoHora(""+hora);
	}	
	
	/**
	 * @param idventa
	 */
	public void setIdventa(java.math.BigDecimal idventa) {
		this.idventa = idventa;
	}
	
	/**
	 * @param fecha
	 */
	public void setFecha(java.math.BigDecimal fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * @param idusuario
	 */
	public void setIdusuario(java.math.BigDecimal idusuario) {
		this.idusuario = idusuario;
	}
	
	/**
	 * @param idmedico
	 */
	public void setIdmedico(java.math.BigDecimal idmedico) {
		this.idmedico = idmedico;
	}
	
	/**
	 * @param valortotal
	 */
	public void setValortotal(java.math.BigDecimal valortotal) {
		this.valortotal = valortotal;
	}
	
	/**
	 * @param iva
	 */
	public void setIva(java.math.BigDecimal iva) {
		this.iva = iva;
	}
	
	/**
	 * @param idcliente
	 */
	public void setIdcliente(java.math.BigDecimal idcliente) {
		this.idcliente = idcliente;
	}
	
	/**
	 * @param idfarmacia
	 */
	public void setIdfarmacia(java.math.BigDecimal idfarmacia) {
		this.idfarmacia = idfarmacia;
	}
	
	
	
	public java.math.BigDecimal getCodigo() {
		return codigo;
	}

	public void setCodigo(java.math.BigDecimal codigo) {
		this.codigo = codigo;
	}

	/**
	 * @param valor
	 */
	public void setValor(java.math.BigDecimal valor) {
		this.valor = valor;
	}
	
	/**
	 * @param hora
	 */
	public void setHora(java.math.BigDecimal hora) {
		this.hora = hora;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente ucliente) {
		if(ucliente==null){
			ucliente = new Cliente();
		}
		this.cliente = ucliente;
	}

	public Usuario getMedico() {
		return medico;
	}

	public void setMedico(Usuario umedico) {
		if(umedico==null){
			umedico = new Usuario();
		}
		this.medico = umedico;
	}

	public Usuario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Usuario uvendedor) {
		if(uvendedor==null){
			uvendedor = new Usuario();
		}
		this.vendedor = uvendedor;
	}

	public boolean isMarca1() {
		return marca1;
	}

	public void setMarca1(boolean marca1) {
		this.marca1 = marca1;
	}

 
		
}

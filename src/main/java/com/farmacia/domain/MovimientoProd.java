
package com.farmacia.domain;


/**
 * Clase que representa un objeto de la tabla Movimiento
 * @author SPEEDY
 * 
 */
 
public class MovimientoProd extends Movimiento {
	

	public MovimientoProd(Movimiento movimiento) {
		super();

		this.fecha=movimiento.getFecha(); 
		this.cantidad=movimiento.getCantidad(); 
		this.valor=movimiento.getValor(); 
		this.codigo=movimiento.getCodigo(); 
		this.idusuario=movimiento.getIdusuario(); 
		this.tipo=movimiento.getTipo(); 
		this.preciocosto=movimiento.getPreciocosto(); 
		this.precio=movimiento.getPrecio(); 
		this.idmovimiento=movimiento.getIdmovimiento(); 
		this.idfarmacia=movimiento.getIdfarmacia(); 
		this.idproducto=movimiento.getIdproducto(); 
		this.hora=movimiento.getHora(); 
		this.usudesc=movimiento.getUsudesc();
		this.farmdesc=movimiento.getFarmdesc();
		this.proddesc=movimiento.getProddesc();
		this.catdesc=movimiento.getCatdesc();
		this.catdescd=movimiento.getCatdescd();
		this.labdesc=movimiento.getLabdesc();
		this.presentacion=movimiento.getPresentacion();
		this.cantidadSobre=movimiento.getCantidadSobre(); 
		this.cantidadCaja=movimiento.getCantidadCaja();
		this.valorMercancia=movimiento.getValorMercancia();
		this.valorMercanciaCompra=movimiento.getValorMercanciaCompra();
		this.unidades=movimiento.getUnidades();
		this.fechaexp=movimiento.getFechaexp();
		this.iddetventa=movimiento.getIddetventa();
		this.precioVentaUnid=movimiento.getPrecioVentaUnid();
		this.precioVentaCaja=movimiento.getPrecioVentaCaja();
		this.lote=movimiento.getLote();
		this.cuarentena=movimiento.getCuarentena();
		this.vendido=movimiento.getVendido();
		this.codigofac=movimiento.getCodigofac();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int compareTo(Object movimiento) {
		int result = proddesc.compareTo(((MovimientoProd)movimiento).getProddesc());
		return result;
	}


	

	
}

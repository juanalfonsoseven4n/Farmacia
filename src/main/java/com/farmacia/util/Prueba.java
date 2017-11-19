package com.farmacia.util;

import java.math.BigDecimal;

import com.farmacia.domain.Movimiento;
import com.farmacia.domain.Producto;

public class Prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Movimiento element = new Movimiento();
		element.setCantidad(new BigDecimal(2));
		Producto producto = new Producto();
		producto.setCaja(new BigDecimal(10));
		producto.setSobre(new BigDecimal(3));
		if (producto.getCaja() != null && producto.getCaja().doubleValue() > 0&& element.getCantidad().doubleValue()>=producto.getCaja().doubleValue()) {
			int cantCajas = (int) (element.getCantidad().doubleValue() / producto.getCaja().doubleValue());
			element.setCantidadCaja(new BigDecimal(cantCajas));
			double residuoC = element.getCantidad().doubleValue() - cantCajas * producto.getCaja().doubleValue();
			if (residuoC > 0) {
				if (producto.getSobre() != null && producto.getSobre().doubleValue() > 0 && residuoC >= producto.getSobre().doubleValue()) {
					int cantSobres = (int) (residuoC / producto.getSobre().doubleValue());
					element.setCantidadSobre(new BigDecimal(cantSobres));
					double residuoS = residuoC - cantSobres * producto.getSobre().doubleValue();
					element.setCantidad(new BigDecimal(residuoS));
				}else {
					element.setCantidadSobre(new BigDecimal(0));
					double residuo =residuoC;
					element.setCantidad(new BigDecimal(residuo));
				}
			}else {
				element.setCantidadSobre(new BigDecimal(0));
				double residuo =0;
				element.setCantidad(new BigDecimal(residuo));
			}
		}else if(producto.getSobre() != null && producto.getSobre().doubleValue() > 0 && element.getCantidad().doubleValue() >= producto.getSobre().doubleValue()) {
			element.setCantidadCaja(new BigDecimal(0));
			int cantSobres = (int) (element.getCantidad().doubleValue() / producto.getSobre().doubleValue());
			element.setCantidadSobre(new BigDecimal(cantSobres));
			double residuoS = element.getCantidad().doubleValue() - cantSobres * producto.getSobre().doubleValue();
			element.setCantidad(new BigDecimal(residuoS));
		}else {
			element.setCantidadCaja(new BigDecimal(0));
			element.setCantidadSobre(new BigDecimal(0));
		}
	}

}

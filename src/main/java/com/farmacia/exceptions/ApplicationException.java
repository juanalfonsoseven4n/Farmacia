
package com.farmacia.exceptions;


public class ApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5045463550093876928L;
	/**
	 * Codigo de error de la exception
	 */
	protected String errorCode;
	
	/**
	 * Constructor para ApplicationException.
	 * @param s codigo de error de la excepcion 
	 */
	public ApplicationException(String s) {
		super(s);		
		errorCode=s;		
	}	
	
	/**
	 * Constructor for ApplicationException.
	 * @param s codigo de error de la exception
	 * @param ex causa del problema que origino la exception
	 */
	public ApplicationException(String s, Throwable ex) {
		super(s, ex);
		errorCode=s;
	}
	
	/**
	 * Metodo que permite obtener el codigo de error asignado a la exception.
	 * @return String codigo de error.
	 */	
	public String getErrorCode(){
		return errorCode;
	}	
}

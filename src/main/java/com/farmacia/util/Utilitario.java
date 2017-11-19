package com.farmacia.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;



public class Utilitario {
	
	/**
	 * Este m�todo le asigna formato de Fecha (2004-01-15) a una
	 * cadena que tenga la siguiente estructura (20040115).
	 */
	public static String formatoDate(String str) {
	try{	
			if (str.trim().length() >= 8) {
				String parte1 = null;
				String parte2 = null;
				String parte3 = null;
				parte1 = str.substring(0,4);
				parte2 = str.substring(4,6);
				parte3 = str.substring(6,8);
				str = parte1 + "/" + parte2 + "/" + parte3; 
			}	
			else {
				str = "";	
			}
	}catch(Exception e){
	}
	return str;
	}
	public static String formatoHora(String str) {
		try{	
				if (str.trim().length() >= 6) {
					String parte1 = null;
					String parte2 = null;
					String parte3 = null;
					parte1 = str.substring(0,2);
					parte2 = str.substring(2,4);
					parte3 = str.substring(4,6);
					str = parte1 + ":" + parte2 + ":" + parte3; 
				}else if (str.trim().length() == 5) {
					String parte1 = null;
					String parte2 = null;
					String parte3 = null;
					parte1 = str.substring(0,1);
					parte2 = str.substring(1,3);
					parte3 = str.substring(3,5);
					str = "0"+parte1 + ":" + parte2 + ":" + parte3; 
				}	
				else {
					str = "";	
				}
		}catch(Exception e){
		}
		return str;
		}
	
	public static String compararFechas(String fechaInicial, String fechaFinal){
		String comparacion = "";
		long aux1 = Long.parseLong(fechaInicial);
		long aux2 = Long.parseLong(fechaFinal);
		if(aux1>aux2){
			comparacion = "INICIO_MAYOR_QUE_FIN";
		}else if(aux1<aux2){
			comparacion = "INICIO_MENOR_QUE_FIN";
		}else{
			comparacion = "INICIO_IGUAL_FIN";
		}
		return comparacion;
	}
	
	public static int restarFechas(String fechaInicial, String fechaFinal){
		int year = new Integer(fechaInicial.substring(0,4)).intValue();
		int mes = new Integer(fechaInicial.substring(4,6)).intValue();
		int dia = new Integer(fechaInicial.substring(6,8)).intValue();
		Calendar calendario = new GregorianCalendar();
		calendario.set(year, mes-1, dia);
		
		year = new Integer(fechaFinal.substring(0,4)).intValue();
		mes = new Integer(fechaFinal.substring(4,6)).intValue();
		dia = new Integer(fechaFinal.substring(6,8)).intValue();
		Calendar calendario2 = new GregorianCalendar();
		calendario2.set(year, mes-1, dia);
		
		long diferencia = calendario2.getTimeInMillis()- calendario.getTimeInMillis();
		int diferenciaDias = (int)((((diferencia / 1000) / 60) / 60) / 24) ;  
		return diferenciaDias;
	}
	
	public static String sumarFechas(String fecha, int dias){
		Calendar calendario = new GregorianCalendar();
		int year = new Integer(fecha.substring(0,4)).intValue();
		int mes = new Integer(fecha.substring(4,6)).intValue();
		int dia = new Integer(fecha.substring(6,8)).intValue();
		calendario.set(year, mes-1, dia);
		calendario.add(Calendar.DATE,dias);
		String yearString = new Integer(calendario.get(Calendar.YEAR)).toString();
		String month = new Integer(calendario.get(Calendar.MONTH)+1).toString();
		String day = new Integer(calendario.get(Calendar.DAY_OF_MONTH)).toString();
		if(month.length()<2){
			month = "0"+month;
		}
		if(day.length()<2){
			day = "0"+day;
		}
		return yearString+month+day;
	}
	
	public static Long multiplicarPorSemanaLanzamiento(String semana, int duracionSemana){
		int aux1 = Integer.parseInt(semana);
		int producto = aux1 * duracionSemana;
		Long total = new Long(producto);
		return  total;
	}
	
	public static String calculaFechaInicioLanzamientos(String fechaInicioLanzamiento, int semanaInicioTarea, int semanaInicioProceso){
		Calendar calendario = new GregorianCalendar();
		int year = new Integer(fechaInicioLanzamiento.substring(0,4)).intValue();
		int mes = new Integer(fechaInicioLanzamiento.substring(4,6)).intValue();
		int dia = new Integer(fechaInicioLanzamiento.substring(6,8)).intValue();
		calendario.set(year, mes-1, dia);
		int diferenciaSemanaTareaSemanaProceso = semanaInicioTarea - semanaInicioProceso;
		calendario.add(Calendar.DATE, diferenciaSemanaTareaSemanaProceso);
		String yearString = new Integer(calendario.get(Calendar.YEAR)).toString();
		String month = new Integer(calendario.get(Calendar.MONTH)+1).toString();
		String day = new Integer(calendario.get(Calendar.DAY_OF_MONTH)).toString();
		if(month.length()<2){
			month = "0"+month;
		}
		if(day.length()<2){
			day = "0"+day;
		}
		return yearString+month+day;
	}
	
		
	public static String quitarFormato (String str){
		String fechaSinFormato=str;
		if(str!=null &&str.indexOf("/")>0){
			fechaSinFormato = str.replaceAll("/", "");
		}
		return fechaSinFormato;
	}
	
	public static String quitarFormatoHora (String str){
		String fechaSinFormato=str;
		if(str!=null &&str.indexOf(":")>0){
			fechaSinFormato = str.replaceAll(":", "");
		}
		return fechaSinFormato;
	}
	
	public static String compararFechaSistema (String fecha){
		String comparacion = "";
		Calendar calendario = Calendar.getInstance();
		SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
		long aux1 = Long.parseLong(formato.format(calendario.getTime()));
		long aux2 = Long.parseLong(fecha);
		if(aux1<aux2){
			comparacion = "FECHA_MAYOR_SISTEMA";
		}else{
			comparacion = "FECHA_MENOR_SISTEMA";
		}
		return comparacion;
	}
	
	
	public static long calcularDiferenciaSistema (String fecha){
		Calendar calendario = Calendar.getInstance();
		SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
		long aux1 = Long.parseLong(formato.format(calendario.getTime()));
		long aux2 = Long.parseLong(fecha);
		long diferencia = aux2 - aux1;
		return diferencia;
	}
	
	
	
	public static String obtenerFechaSistema (){
		Calendar calendario = Calendar.getInstance();
		SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
		return formato.format(calendario.getTime());
		
	}
	
	public static String obtenerHoraSistema (){
		Calendar calendario = Calendar.getInstance();
		String horaSistema = (StringUtils.leftPad(""+calendario.get(Calendar.HOUR_OF_DAY),2,"0")
				  +":"+StringUtils.leftPad(""+calendario.get(Calendar.MINUTE),2,"0")
				  +":"+StringUtils.leftPad(""+calendario.get(Calendar.SECOND),2,"0"));
		return horaSistema;
		
	}
}


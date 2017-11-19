package com.farmacia.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternValidation 
{
	
	public static boolean validarNumerico(String texto){
		
		 Pattern p = Pattern.compile("^[1-9]{1}[0-9\\.]*$");
	      
	      //Match the given string with the pattern
	      Matcher m = p.matcher(texto);

	      //check whether match is found 
	      boolean matchFound = m.matches();
	      
	      
	      return matchFound;
	}
}

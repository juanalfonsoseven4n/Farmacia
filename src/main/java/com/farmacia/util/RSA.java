package com.farmacia.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA   
{   
    public final String encriptar(String original)   
    {   
        try   
        {   
            BigInteger numero = new BigInteger(original.getBytes("ISO-8859-1"));   
            BigInteger encriptado = this.encrypt(numero);   
            String strEncriptado="_"+encriptado.toString(36);   
            return strEncriptado;   
        }   
        catch (UnsupportedEncodingException ex)   
        {   
            return ex.getMessage();   
        }   
    }   
    
    
    public final String desencriptar(String senhaEncriptada) throws NumberFormatException   
    {   
        String desencriptado;   
        if (senhaEncriptada.startsWith("_"))   
	        desencriptado = new String(this.decrypt(new BigInteger(senhaEncriptada.substring(1),36)).toByteArray());   
        else if (senhaEncriptada.startsWith("+"))   
            desencriptado = new String(this.decrypt(new BigInteger(senhaEncriptada.substring(1),36)).toByteArray());   
        else   
            desencriptado = new String(this.decrypt(new BigInteger(senhaEncriptada)).toByteArray());   
        return desencriptado;   
    }   
  
  
    private BigInteger publicKey, privateKey, e;   
    
    public RSA(int bitlen)   
    {   
        SecureRandom r = new SecureRandom();   
        BigInteger p = new BigInteger(bitlen / 2, 100, r);   
        BigInteger q = new BigInteger(bitlen / 2, 100, r);   
        publicKey = p.multiply(q);   
        BigInteger m = (p.subtract(BigInteger.ONE))   
        .multiply(q.subtract(BigInteger.ONE));   
        e = new BigInteger("3");   
        while(m.gcd(e).intValue() > 1) 
        {	
        	e = e.add(new BigInteger("2"));   
        }
        privateKey = e.modInverse(m);   
    }   
     
    public RSA(BigInteger e, BigInteger privateKey, BigInteger publicKey)   
    {   
        this.e=e;   
        this.privateKey=privateKey;   
        this.publicKey=publicKey;   
    }   
    public RSA(BigInteger privateKey)   
    {   
        this.e=new BigInteger("5");   
        this.privateKey=privateKey;   
        this.publicKey=new BigInteger("8496133897567932221559267089164065267221377078566337104866771208480189113695076911576868324903413008512741498700587851315525414979963642608998181269527941");   
    }   
   public RSA()   
    {   
        this.e=new BigInteger("5");   
        this.privateKey=null;   
        this.publicKey=new BigInteger("8496133897567932221559267089164065267221377078566337104866771208480189113695076911576868324903413008512741498700587851315525414979963642608998181269527941");   
    }   
    private final BigInteger encrypt(BigInteger message)   
    {   
        return message.modPow(e, publicKey);   
    }   
    private final BigInteger decrypt(BigInteger message)   
    {   
        if (privateKey==null)   
            System.out.println("You shouldn't be seen this, please report it on openp2m page");   
        return message.modPow(privateKey, publicKey);   
    }   
    public static void main(String[] args) {
		String cadena = "juank";

		RSA rsa1 = new RSA(new BigInteger("7"),new BigInteger("25073217964183"),new BigInteger("175512552247237")); 
		String cifrado1="";
		if(cadena.length()>6){
			 cifrado1 = rsa1.encriptar(cadena.substring(0,6)) +"?BI?"+rsa1.encriptar(cadena.substring(6));
		}else{
			cifrado1 = rsa1.encriptar(cadena);
		}
		System.out.println(cifrado1);

		RSA rsa2 = new RSA(new BigInteger("7"),new BigInteger("25073217964183"),new BigInteger("175512552247237")); 
		String descifrado1=null;
		if(cifrado1.indexOf("?BI?")>0){
			descifrado1 = rsa2.desencriptar(cifrado1.substring(0,cifrado1.indexOf("?BI?")))+rsa2.desencriptar(cifrado1.substring(cifrado1.indexOf("?BI?")+4));
		}else{
			descifrado1 = rsa2.desencriptar(cifrado1);	
		}
		System.out.println(descifrado1);

	}
}
package io.swagger.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.swagger.model.JsonApiBodyRequest;

public class Check {
	
	
	
	public boolean isValidBody(JsonApiBodyRequest body) {
		
		if(		   body.getPersona().get(0).getNombre().isEmpty()
				|| body.getPersona().get(0).getCorreo().isEmpty()
				|| body.getPersona().get(0).getEstado().isEmpty()
				) {
			return false;
		}
		
		return true;
		
		
	}
	
	public static boolean validarCorreo(String email) {
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	} 
	
		
	public static boolean validarNumerico(String value) {
		return (value.matches("[+-]?\\d*(\\.\\d+)?") && value.equals("")==false);
	}
	
	public static boolean validarLetras(String value){
		Pattern pattern = Pattern.compile("[A-Za-z]*");
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}

	public static boolean validarContrasena(String value) {
		Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$");
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}

}




/*
 [‎30/‎07/‎2018 10:33 a. m.]  Rueda, Orlando:  
No Title 
public class ValidateFields {
	
	public static boolean checkEmail(String email) {
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(email);
		
		return matcher.matches();
	}
	
	public static boolean checkNumberField(String value) {
		return (value.matches("[+-]?\\d*(\\.\\d+)?") && value.equals("")==false);
	}
	
	public static boolean checkField(String value) {
		Pattern pattern = Pattern.compile("[A-Za-z]*");
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}
	
	public static boolean checkPassword(String value) {
		Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$");
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}
public class ValidateFields {
	
	public static boolean checkEmail(String email) {
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(email);
		
		return matcher.matches();
	}
	
	public static boolean checkNumberField(String value) {
		return (value.matches("[+-]?\\d*(\\.\\d+)?") && value.equals("")==false);
	}
	
	public static boolean checkField(String value) {
		Pattern pattern = Pattern.compile("[A-Za-z]*");
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}
	
	public static boolean checkPassword(String value) {
		Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$");
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}

	
} 
	
} 
 

 */











 
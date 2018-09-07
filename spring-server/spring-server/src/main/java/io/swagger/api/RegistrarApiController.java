package io.swagger.api;

import io.swagger.model.JsonApiBodyRequest;
import io.swagger.model.JsonApiBodyResponseErrors;
import io.swagger.model.JsonApiBodyResponseSuccess;
import io.swagger.model.RegistrarRequest;
import io.swagger.repository.UserRepository;
import io.swagger.utils.FlagsInformation;
import io.swagger.utils.ReadWriteFile;
import io.swagger.utils.Security;
import io.swagger.utils.Check;


import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.core.joran.conditional.IfAction;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-25T19:46:33.644Z")

@Controller
public class RegistrarApiController implements RegistrarApi {
	
	@Autowired
	UserRepository userRepository;
	
    private static final Logger log = LoggerFactory.getLogger(RegistrarApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    public List<JsonApiBodyRequest> personas = new ArrayList<>();
    
    private FlagsInformation flagsInformation = new FlagsInformation();

    private Check check = new Check();
    
    private Security security = new Security();
    
    private ReadWriteFile filemanage = new ReadWriteFile();
    
    @org.springframework.beans.factory.annotation.Autowired
    public RegistrarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
    
    public ResponseEntity<?> registrarPost(@ApiParam(value = "body" ,required=true )  
    @Valid @RequestBody JsonApiBodyRequest body) {
    	String accept = request.getHeader("Accept");
    	if (true) {
        	JsonApiBodyResponseErrors responseErrors = new JsonApiBodyResponseErrors();
	    	JsonApiBodyResponseSuccess responseSuccess = new JsonApiBodyResponseSuccess();
	    	//System.out.println(body);	    	
	    	
	    	//validar superadministradores
	    	if(body.getPersona().get(0).getRol().equalsIgnoreCase("superadmin")) {
	    		responseErrors.setCodigo("2525");
        		responseErrors.setDetalle("NO ES POSIBLE REGISTRAR MÁS SUPERADMINISTRADORES");
        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.OK);
	    	}
	    	//validar correo
	    	if(!Check.validarCorreo(body.getPersona().get(0).getCorreo()) || body.getPersona().get(0).getCorreo().equals("")) {
	    		responseErrors.setCodigo(flagsInformation.CODE_0003);
        		responseErrors.setDetalle(flagsInformation.MSN_CODE_0003);
        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.OK);
	    	}
	    	//validar el apellido solo tenga letras 
	    	if(!Check.validarLetras(body.getPersona().get(0).getApellidos()) || body.getPersona().get(0).getApellidos().equals("")) {
	    		responseErrors.setCodigo(flagsInformation.CODE_0002);
        		responseErrors.setDetalle(flagsInformation.MSN_CODE_0002);
        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.OK);	    		
	    	}
	    	//validar nombre solo tenga letras
	    	if(!Check.validarLetras(body.getPersona().get(0).getNombre()) || body.getPersona().get(0).getNombre().equals("")) {
	    		responseErrors.setCodigo(flagsInformation.CODE_0001);
        		responseErrors.setDetalle(flagsInformation.MSN_CODE_0001);
        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.OK);
	    	}
	    	
	    	if (!body.getPersona().get(0).getContrasena().equals("")) {
				JsonApiBodyRequest persona = new JsonApiBodyRequest();
		    	persona = body;
	
		    	try {
		    		List<RegistrarRequest> correo = (List<RegistrarRequest>) userRepository.findByCorreo(persona.getPersona().get(0).getCorreo());
					if(correo.isEmpty()) {
						String token = persona.getPersona().get(0).gettoken();
						List<RegistrarRequest> tokens = (List<RegistrarRequest>) userRepository.findByToken(token);
						if(!tokens.isEmpty()) {
							String rolFinal = tokens.get(0).getRol();
							String rol = persona.getPersona().get(0).getRol();
							if (
									( rolFinal.equalsIgnoreCase("SUPERADMIN") && rol.equalsIgnoreCase("SUPERADMIN") )||
									( rol.equalsIgnoreCase("ADMIN") && !token.equalsIgnoreCase("user"))||
									( rol.equalsIgnoreCase("USER"))
									) {
									body.getPersona().get(0).settoken(rol.toLowerCase());
									RegistrarRequest respuestadb = userRepository.save(body.getPersona().get(0));
	    			            	responseSuccess.setEstado(respuestadb.getEstado());
	    			            	responseSuccess.setId(respuestadb.getId());
	    			            	responseSuccess.setNombre(respuestadb.getNombre());   			            	
	    			            	return new ResponseEntity<JsonApiBodyResponseSuccess>(responseSuccess, HttpStatus.OK);
							}else {
									responseErrors.setCodigo(flagsInformation.CODE_5002);
		    		        		responseErrors.setDetalle(flagsInformation.MSN_CODE_5002);
		    		        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.OK);

							}
						}else {
								responseErrors.setCodigo(flagsInformation.CODE_8001);
	    		        		responseErrors.setDetalle(flagsInformation.MSN_CODE_8001);
	    		        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.OK);
								
						}
							
					} else {	
						responseErrors.setCodigo(flagsInformation.CODE_6001);
		        		responseErrors.setDetalle(flagsInformation.MSN_CODE_6001);
		        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.OK);
					}
						
					} catch (Exception e) {
						
						responseErrors.setCodigo(flagsInformation.CODE_5001);
		        		responseErrors.setDetalle(flagsInformation.MSN_CODE_5001);
		        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.OK);

					}
		    	
		    	//}					
				
				
			}else{
				responseErrors.setCodigo(flagsInformation.CODE_0004);
        		responseErrors.setDetalle(flagsInformation.MSN_CODE_0004);
        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.OK);
				
			} 
	    	
	    	
	    	
	    	
	    	
	    	
	    	/*
	    	if(check.validarCorreo(body.getPersona().get(0).getCorreo())) {	    		
	    		if(check.validarLetras(body.getPersona().get(0).getApellidos()) && !body.getPersona().get(0).getApellidos().equals("")) {	    			
	    			if(check.validarLetras(body.getPersona().get(0).getNombre()) && !body.getPersona().get(0).getNombre().equals("")) {	    				
	    				if (!body.getPersona().get(0).getContrasena().equals("")) {
							JsonApiBodyRequest persona = new JsonApiBodyRequest();
	    			    	persona = body;
	    			    	
	    			    	//if(persona.getPersona().get(0).getRol().equalsIgnoreCase(flagsInformation.SUPERADMINMASTER)){
	    		        	//	responseErrors.setCodigo(flagsInformation.SUPERADMINMASTER_ERROR_CODE);
	    		        	//	responseErrors.setDetalle(flagsInformation.SUPERADMINMASTER_ERROR_MSN);
	    		        	//	return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
	    		        	//}else {	
	    			    		try {
	    			    			List<RegistrarRequest> correo = (List<RegistrarRequest>) userRepository.findByCorreo(persona.getPersona().get(0).getCorreo());
	    							if(correo.isEmpty()) {
	    								String token = persona.getPersona().get(0).gettoken();
	    								List<RegistrarRequest> tokens = (List<RegistrarRequest>) userRepository.findByToken(token);
	    								if(!tokens.isEmpty()) {
	    									String rolFinal = tokens.get(0).getRol();
		    								String rol = persona.getPersona().get(0).getRol();
		    								if (
		    										( rolFinal.equalsIgnoreCase("SUPERADMIN") && rol.equalsIgnoreCase("SUPERADMIN") )||
		    										( rol.equalsIgnoreCase("ADMIN") && !token.equalsIgnoreCase("user"))||
		    										( rol.equalsIgnoreCase("USER"))
		    										) {
		    										body.getPersona().get(0).settoken(rol.toLowerCase());
													RegistrarRequest respuestadb = userRepository.save(body.getPersona().get(0));
				    			            		responseSuccess.setEstado(respuestadb.getEstado());
				    			            		responseSuccess.setId(respuestadb.getId());
				    			            		responseSuccess.setNombre(respuestadb.getNombre());
				    			            		return new ResponseEntity<JsonApiBodyResponseSuccess>(responseSuccess, HttpStatus.OK);
											}else {
												responseErrors.setCodigo(flagsInformation.CODE_5002);
		    		    		        		responseErrors.setDetalle(flagsInformation.MSN_CODE_5002);
		    		    		        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);

											}
	    								}else {
	    									responseErrors.setCodigo(flagsInformation.CODE_8001);
	    		    		        		responseErrors.setDetalle(flagsInformation.MSN_CODE_8001);
	    		    		        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
	    									
	    								}
	    								
	    							}else {	
	    							responseErrors.setCodigo(flagsInformation.CODE_6001);
	    			        		responseErrors.setDetalle(flagsInformation.MSN_CODE_6001);
	    			        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
	    							}
	    							
	    						} catch (Exception e) {
	    							
	    							responseErrors.setCodigo(flagsInformation.CODE_5001);
	    			        		responseErrors.setDetalle(flagsInformation.MSN_CODE_5001);
	    			        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);

	    						}
	    			    	
	    			    	//}					
	    					
	    					
						}else{
							responseErrors.setCodigo(flagsInformation.CODE_0004);
			        		responseErrors.setDetalle(flagsInformation.MSN_CODE_0004);
			        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
							
						} 				
	    				
	    			}else {
	    				responseErrors.setCodigo(flagsInformation.CODE_0001);
		        		responseErrors.setDetalle(flagsInformation.MSN_CODE_0001);
		        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
	    			}
	    			
	    			
	    		}else {
	    			responseErrors.setCodigo(flagsInformation.CODE_0002);
	        		responseErrors.setDetalle(flagsInformation.MSN_CODE_0002);
	        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
	    		}
	    		
	    	}else {
	    		responseErrors.setCodigo(flagsInformation.CODE_0003);
        		responseErrors.setDetalle(flagsInformation.MSN_CODE_0003);
        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
	    	}*/
	    	
	   }
        return new ResponseEntity<JsonApiBodyResponseSuccess>(HttpStatus.NOT_IMPLEMENTED);
     }
    
   
 }


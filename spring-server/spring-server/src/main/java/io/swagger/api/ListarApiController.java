package io.swagger.api;

import io.swagger.model.JsonApiBodyRequest;
import io.swagger.model.JsonApiBodyRequest2;
import io.swagger.model.JsonApiBodyRequest3;
import io.swagger.model.JsonApiBodyResponseErrors;
import io.swagger.model.RegistrarRequest;
import io.swagger.model.RegistrarRequest2;
import io.swagger.repository.UserRepository;
import io.swagger.utils.FlagsInformation;
import io.swagger.utils.Security;
import io.swagger.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.primitives.Bytes;

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
public class ListarApiController implements ListarApi {

	@Autowired
	UserRepository userRepository;
	
	
	private static final Logger log = LoggerFactory.getLogger(ListarApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    private FlagsInformation FlagsInformation = new FlagsInformation();
    
    private FlagsInformation flagsInformation = new FlagsInformation();
    
    JsonApiBodyResponseErrors responseErrors = new JsonApiBodyResponseErrors();
    
    private Security security = new Security();

    @org.springframework.beans.factory.annotation.Autowired
    public ListarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    
    public ResponseEntity<?> listarEstadoEstadoGet(@ApiParam(value = "body",required=true) 
    @Valid @RequestBody JsonApiBodyRequest2 body) {
    	String accept = request.getHeader("Accept");
    	if (accept != null && accept.contains("application/json")){
			try {
				if(body.getPersona().get(0).getRol().equals("SUPERADMIN") 
						&& body.getPersona().get(0).gettoken().equalsIgnoreCase("SUPERADMIN")) {
					String estado = body.getPersona().get(0).getEstado();
					List<RegistrarRequest> persona = (List<RegistrarRequest>) userRepository.findByEstado(estado);
					if(persona != null) {					
						if(!persona.isEmpty()) {
							JsonApiBodyRequest body_response = new JsonApiBodyRequest();
							body_response.setPersona(persona);
							return new ResponseEntity<JsonApiBodyRequest>(body_response, HttpStatus.OK);
						}			
					}
					responseErrors.setCodigo(FlagsInformation.CODE_3001);
					responseErrors.setDetalle(FlagsInformation.MSN_CODE_3001);
					return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
				}else {
					responseErrors.setCodigo(FlagsInformation.CODE_5002);
					responseErrors.setDetalle(FlagsInformation.MSN_CODE_5002);
					return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
				responseErrors.setCodigo(flagsInformation.CODE_5001);
        		responseErrors.setDetalle(flagsInformation.MSN_CODE_5001);
        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
			}
			
		}		
	return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.NOT_IMPLEMENTED);
}

    public ResponseEntity<?> listarGet(@ApiParam(value = "body",required=true) 
    @Valid @RequestBody JsonApiBodyRequest2 body) { 
    	try {
    		if(body.getPersona().get(0).getRol().equals("SUPERADMIN") 
    				&& body.getPersona().get(0).gettoken().equalsIgnoreCase("SUPERADMIN")) {
	        	List<RegistrarRequest> persona = (List<RegistrarRequest>) userRepository.findAll();
	        	JsonApiBodyRequest body_response = new JsonApiBodyRequest();
				body_response.setPersona(persona);
				return new ResponseEntity<JsonApiBodyRequest>(body_response, HttpStatus.OK);
    		}else {
				responseErrors.setCodigo(FlagsInformation.CODE_5002);
				responseErrors.setDetalle(FlagsInformation.MSN_CODE_5002);
				return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
			}
		} catch (Exception e) {
			// TODO: handle exception
			responseErrors.setCodigo(flagsInformation.CODE_5001);
    		responseErrors.setDetalle(flagsInformation.MSN_CODE_5001);
    		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
			
		}  
    }

    
    public ResponseEntity<?> listarIdGet(@ApiParam(value = "body",required=true) 
    @Valid @RequestBody JsonApiBodyRequest2 body) {
    	String accept = request.getHeader("Accept");
    		if (accept != null && accept.contains("application/json")) {
    			try {
    				String id = body.getPersona().get(0).getId();
    				RegistrarRequest persona = userRepository.findOne(id);
        			if(persona == null) {
        				JsonApiBodyResponseErrors responseErrors = new JsonApiBodyResponseErrors();
        				responseErrors.setCodigo(FlagsInformation.CODE_1001);
        				responseErrors.setDetalle(FlagsInformation.MSN_CODE_1001);
        				return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
        			}
        			if( body.getPersona().get(0).gettoken().equalsIgnoreCase("SUPERADMIN")) {
        				JsonApiBodyRequest body_response = new JsonApiBodyRequest();
        				List<RegistrarRequest> lista = new ArrayList<RegistrarRequest>();
        				lista.add(persona);
        				body_response.setPersona(lista);
        				return new ResponseEntity<JsonApiBodyRequest>(body_response, HttpStatus.OK);       				
        			}else {
        				responseErrors.setCodigo(FlagsInformation.CODE_5002);
        				responseErrors.setDetalle(FlagsInformation.MSN_CODE_5002);
        				return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
        			}
				} catch (Exception e) {
					// TODO: handle exception
					responseErrors.setCodigo(flagsInformation.CODE_5001);
	        		responseErrors.setDetalle(flagsInformation.MSN_CODE_5001);
	        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
				}
    		}
    	return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.NOT_IMPLEMENTED);
    } 
    
    public ResponseEntity<?> listarRolRolGet(@ApiParam(value = "body",required=true) 
    @Valid @RequestBody JsonApiBodyRequest2 body) {
    	String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				if( body.getPersona().get(0).gettoken().equalsIgnoreCase("SUPERADMIN")) {
					String rol = body.getPersona().get(0).getRol();
					List<RegistrarRequest> persona = (List<RegistrarRequest>) userRepository.findByRol(rol);
					if(persona != null) {					
						if(!persona.isEmpty()) {
							JsonApiBodyRequest body_response = new JsonApiBodyRequest();
							body_response.setPersona(persona);
							return new ResponseEntity<JsonApiBodyRequest>(body_response, HttpStatus.OK);
						}			
					}
					responseErrors.setCodigo(FlagsInformation.CODE_3001);
					responseErrors.setDetalle(FlagsInformation.MSN_CODE_3001);
					return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
				}else {
					responseErrors.setCodigo(FlagsInformation.CODE_5002);
					responseErrors.setDetalle(FlagsInformation.MSN_CODE_5002);
					return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
				responseErrors.setCodigo(flagsInformation.CODE_5001);
        		responseErrors.setDetalle(flagsInformation.MSN_CODE_5001);
        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
			}
			
		}
	return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.NOT_IMPLEMENTED);
    }


    public ResponseEntity<?> listarCorreoCorreoGet(@ApiParam(value = "body",required=true) 
    @Valid @RequestBody JsonApiBodyRequest3 body) {
    	String accept = request.getHeader("Accept");
	
    	if (accept != null && accept.contains("application/json")){
			try {
					
				String correo = body.getPersona().get(0).getcorreo();
				
				List<RegistrarRequest> persona = (List<RegistrarRequest>) userRepository.findByCorreo(correo);
				
				if(!persona.isEmpty()) {
					String contrasena = persona.get(0).getContrasena();
					
					if (contrasena.equals(body.getPersona().get(0).getcontrasena())) {
						
						JsonApiBodyRequest body_response = new JsonApiBodyRequest();
						body_response.setPersona(persona);
						return new ResponseEntity<JsonApiBodyRequest>(body_response, HttpStatus.OK);
						
					}else {
						responseErrors.setCodigo(FlagsInformation.CODE_0004);
						responseErrors.setDetalle(FlagsInformation.MSN_CODE_0004);
						return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
					}
					
				}else {
					
					responseErrors.setCodigo(FlagsInformation.CODE_4002);
					responseErrors.setDetalle(FlagsInformation.MSN_CODE_4002);
					return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
				}					
			} catch (Exception e) {
				
				responseErrors.setCodigo(flagsInformation.CODE_5001);
        		responseErrors.setDetalle(flagsInformation.MSN_CODE_5001);
        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
			}
			
		}		
	return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.NOT_IMPLEMENTED);
}
}

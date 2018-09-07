package io.swagger.api;

import io.swagger.model.JsonApiBodyRequest;
import io.swagger.model.JsonApiBodyResponseErrors;
import io.swagger.model.JsonApiBodyResponseSuccess;
import io.swagger.model.RegistrarRequest;
import io.swagger.repository.NegocioRepository;
import io.swagger.utils.FlagsInformation;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-01T20:15:25.137Z")

@Controller
public class ListarApiController implements ListarApi {

	@Autowired
	NegocioRepository negocioRepository;
	
	private FlagsInformation flagsInformation = new FlagsInformation();
	
	private static final Logger log = LoggerFactory.getLogger(ListarApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ListarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<?> listarGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	System.out.println("ListarNegocios");
        	JsonApiBodyResponseErrors responseErrors = new JsonApiBodyResponseErrors();
	    	JsonApiBodyResponseSuccess responseSuccess = new JsonApiBodyResponseSuccess();
        	try {
    	        	List<RegistrarRequest> negocio = (List<RegistrarRequest>) negocioRepository.findAll();
    	        	JsonApiBodyRequest body_response = new JsonApiBodyRequest();
    				body_response.setNegocio(negocio);
    				System.out.println(body_response);
    				return new ResponseEntity<JsonApiBodyRequest>(body_response, HttpStatus.OK);
        		
    		} catch (Exception e) {
    			// TODO: handle exception
    			responseErrors.setCode(flagsInformation.CODE_5001);
        		responseErrors.setDetalle(flagsInformation.MSN_CODE_5001);
        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
    			
    		} 
        }

        return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<?> listarIdadminIdadminGet(@ApiParam(value = "ID del negocio",required=true) 
    @PathVariable("idadmin") String idadmin) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	System.out.println("llego el idadmin: "+ idadmin);
        	JsonApiBodyResponseErrors responseErrors = new JsonApiBodyResponseErrors();
	    	JsonApiBodyResponseSuccess responseSuccess = new JsonApiBodyResponseSuccess();
        	try {
    	        	List<RegistrarRequest> negocios = (List<RegistrarRequest>) negocioRepository.findByIdadmin(idadmin);
    	        	if (!negocios.isEmpty()) {
    	        		JsonApiBodyRequest body_response = new JsonApiBodyRequest();
        				body_response.setNegocio(negocios);
        				return new ResponseEntity<JsonApiBodyRequest>(body_response, HttpStatus.OK);
					}else {
						responseErrors.setCode("57");
		        		responseErrors.setDetalle("el admin no tiene negocios");
		        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
					}
    	    } catch (Exception e) {
    			// TODO: handle exception
    			responseErrors.setCode(flagsInformation.CODE_5001);
        		responseErrors.setDetalle(flagsInformation.MSN_CODE_5001);
        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
    			
    		}
        }

        return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<?> listarIdnegocioGet(@ApiParam(value = "ID del negocio",required=true) 
    @PathVariable("idnegocio") String idnegocio) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	JsonApiBodyResponseErrors responseErrors = new JsonApiBodyResponseErrors();
	    	JsonApiBodyResponseSuccess responseSuccess = new JsonApiBodyResponseSuccess();
        	try {
    	        	List<RegistrarRequest> negocios = (List<RegistrarRequest>) negocioRepository.findByIdnegocio(idnegocio);
    	        	if (!negocios.isEmpty()) {
    	        		JsonApiBodyRequest body_response = new JsonApiBodyRequest();
        				body_response.setNegocio(negocios);
        				return new ResponseEntity<JsonApiBodyRequest>(body_response, HttpStatus.OK);
					}else {
						responseErrors.setCode("58");
		        		responseErrors.setDetalle("no exite negocios con dicho id");
		        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
					}
    	    } catch (Exception e) {
    			// TODO: handle exception
    			responseErrors.setCode(flagsInformation.CODE_5001);
        		responseErrors.setDetalle(flagsInformation.MSN_CODE_5001);
        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
    			
    		}
        }
        return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<?> listarTiponegocioTiponegocioGet(@ApiParam(value = "ID de la persona",required=true) 
    @PathVariable("tiponegocio") String tiponegocio) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	JsonApiBodyResponseErrors responseErrors = new JsonApiBodyResponseErrors();
	    	JsonApiBodyResponseSuccess responseSuccess = new JsonApiBodyResponseSuccess();
        	try {
    	        	List<RegistrarRequest> negocios = (List<RegistrarRequest>) negocioRepository.findByTipo(tiponegocio);
    	        	if (!negocios.isEmpty()) {
    	        		JsonApiBodyRequest body_response = new JsonApiBodyRequest();
        				body_response.setNegocio(negocios);
        				return new ResponseEntity<JsonApiBodyRequest>(body_response, HttpStatus.OK);
					}else {
						responseErrors.setCode("58");
		        		responseErrors.setDetalle("no exite negocios de ese tipo");
		        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
					}
    	    } catch (Exception e) {
    			// TODO: handle exception
    			responseErrors.setCode(flagsInformation.CODE_5001);
        		responseErrors.setDetalle(flagsInformation.MSN_CODE_5001);
        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
    			
    		}
        }

        return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.NOT_IMPLEMENTED);
    }

}

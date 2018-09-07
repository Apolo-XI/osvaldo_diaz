package io.swagger.api;

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
public class EliminarApiController implements EliminarApi {

	@Autowired
	NegocioRepository negocioRepository;
	
	private FlagsInformation flagsInformation = new FlagsInformation();
		
	private static final Logger log = LoggerFactory.getLogger(EliminarApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public EliminarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<?> eliminarIdnegocioDelete(@ApiParam(value = "ID del negocio",required=true) 
    @PathVariable("idnegocio") String idnegocio) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	System.out.println("llego el id"+ idnegocio);
        	JsonApiBodyResponseErrors responseErrors = new JsonApiBodyResponseErrors();
	    	JsonApiBodyResponseSuccess responseSuccess = new JsonApiBodyResponseSuccess();
        	try {
        		RegistrarRequest negocio = negocioRepository.findOne(idnegocio);
                if (negocio == null) {                       
                      responseErrors.setCode("59"); 
                      responseErrors.setDetalle("NO EXISTE NEGOCIO CON ESE ID");;
                      return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
               }
        		negocioRepository.delete(idnegocio);
                responseSuccess.setIdnegocio(negocio.getIdnegocio());
                responseSuccess.setNombreNegocio(negocio.getNombreNegocio());
                responseSuccess.setTipo(negocio.getTipo());
                return new ResponseEntity<JsonApiBodyResponseSuccess>(responseSuccess, HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
				responseErrors.setCode(flagsInformation.CODE_5001);
        		responseErrors.setDetalle(flagsInformation.MSN_CODE_5001);
        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
			}
        }

        return new ResponseEntity<JsonApiBodyResponseSuccess>(HttpStatus.NOT_IMPLEMENTED);
    }

}

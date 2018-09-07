package io.swagger.api;

import io.swagger.model.JsonApiBodyRequest;
import io.swagger.model.JsonApiBodyResponseErrors;
import io.swagger.model.JsonApiBodyResponseSuccess;
import io.swagger.model.RegistrarRequest;
import io.swagger.repository.OfertaRepository;

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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-17T21:36:33.675Z")

@Controller
public class RegistrarApiController implements RegistrarApi {

	@Autowired
	OfertaRepository ofertaRepository;
	
    private static final Logger log = LoggerFactory.getLogger(RegistrarApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public RegistrarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<?> registrarPost(@ApiParam(value = "body" ,required=true )  
    	@Valid 
    	@RequestBody JsonApiBodyRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	JsonApiBodyResponseErrors responseErrors = new JsonApiBodyResponseErrors();
	    	JsonApiBodyResponseSuccess responseSuccess = new JsonApiBodyResponseSuccess();
        	try {
		    	RegistrarRequest respuestadb = ofertaRepository.save(body.getOferta().get(0));
				responseSuccess.setId(respuestadb.getId());
				responseSuccess.setDetalle(respuestadb.getDetalle());
				responseSuccess.setProducto(respuestadb.getProducto());
				return new ResponseEntity<JsonApiBodyResponseSuccess>(responseSuccess, HttpStatus.OK);
			} catch (Exception e) {
				responseErrors.setCode("050");
				responseErrors.setDetalle("NO SE PUDO GUARDAR LA OFERTA");
				return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.OK);
			}
        }

        return new ResponseEntity<JsonApiBodyResponseSuccess>(HttpStatus.NOT_IMPLEMENTED);
    }

}

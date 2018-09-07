package io.swagger.api;

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
public class EliminarApiController implements EliminarApi {

	@Autowired
	OfertaRepository ofertaRepository;
	
    private static final Logger log = LoggerFactory.getLogger(EliminarApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public EliminarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<?> eliminarIdofertaDelete(@ApiParam(value = "ID de la oferta",required=true) 
    @PathVariable("idoferta") String idoferta) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	JsonApiBodyResponseErrors responseErrors = new JsonApiBodyResponseErrors();
	    	JsonApiBodyResponseSuccess responseSuccess = new JsonApiBodyResponseSuccess();
        	try {
        		RegistrarRequest oferta = ofertaRepository.findOne(idoferta);
                if (oferta == null) {                       
                      responseErrors.setCode("59"); 
                      responseErrors.setDetalle("NO EXISTE OFERTA CON ESE ID");;
                      return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
               }
        		ofertaRepository.delete(idoferta);
                responseSuccess.setId(oferta.getId());
                responseSuccess.setDetalle(oferta.getDetalle());
                responseSuccess.setProducto(oferta.getProducto());
                return new ResponseEntity<JsonApiBodyResponseSuccess>(responseSuccess, HttpStatus.OK);
			} catch (Exception e) {
				responseErrors.setCode("051");
        		responseErrors.setDetalle("NO SE PUDO COMUNICAR CON LA BASE DE DATOS");
        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
			}
        }

        return new ResponseEntity<JsonApiBodyResponseSuccess>(HttpStatus.NOT_IMPLEMENTED);
    }

}

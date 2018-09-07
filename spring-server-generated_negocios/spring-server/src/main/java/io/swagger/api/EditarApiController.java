package io.swagger.api;

import io.swagger.model.JsonApiBodyRequest;
import io.swagger.model.JsonApiBodyResponseErrors;
import io.swagger.model.JsonApiBodyResponseSuccess;
import io.swagger.model.RegistrarRequest;
import io.swagger.repository.NegocioRepository;
import io.swagger.utils.Check;
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
public class EditarApiController implements EditarApi {

	@Autowired
	NegocioRepository negocioRepository;
	
	private FlagsInformation flagsInformation = new FlagsInformation();
	
    private static final Logger log = LoggerFactory.getLogger(EditarApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    private Check check = new Check();

    @org.springframework.beans.factory.annotation.Autowired
    public EditarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<?> editarIdnegocioPut(@ApiParam(value = "ID del negocio",required=true) 
    @PathVariable("idnegocio") String idnegocio,@ApiParam(value = "body" ,required=true )  
    @Valid @RequestBody JsonApiBodyRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	JsonApiBodyResponseErrors responseErrors = new JsonApiBodyResponseErrors();
	    	JsonApiBodyResponseSuccess responseSuccess = new JsonApiBodyResponseSuccess();
        	if (!check.validarCorreo(body.getNegocio().get(0).getCorreo())) {
        		responseErrors.setCode("55");
        		responseErrors.setDetalle("correo equivocado");
        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
			}
//		    if (!check.validarNumerico(body.getNegocio().get(0).getIdadmin())) {
//		    	responseErrors.setCode("56");
//        		responseErrors.setDetalle("Id ADMIN NO CORRECTO");
//        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
//			}
//		    if (!check.validarNumerico(body.getNegocio().get(0).getIdnegocio())) {
//		    	responseErrors.setCode("57");
//        		responseErrors.setDetalle("Id negocio NO CORRECTO");
//        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
//			}
		    if (!check.validarNumerico(body.getNegocio().get(0).getTelefono())) {
		    	responseErrors.setCode("58");
        		responseErrors.setDetalle("TELEFONO NO CORRECTO");
        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
			}
		    try {
		    	RegistrarRequest respuestadb = negocioRepository.save(body.getNegocio().get(0));
				responseSuccess.setIdnegocio(respuestadb.getIdnegocio());
				responseSuccess.setNombreNegocio(respuestadb.getNombreNegocio());
				responseSuccess.setTipo(respuestadb.getTipo());
				return new ResponseEntity<JsonApiBodyResponseSuccess>(responseSuccess, HttpStatus.OK);
			} catch (Exception e) {
				responseErrors.setCode("59");
        		responseErrors.setDetalle("NO SE PUDO ACTUALIZAR EL NEGOCIO");
        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
			}
        }

        return new ResponseEntity<JsonApiBodyResponseSuccess>(HttpStatus.NOT_IMPLEMENTED);
    }

}

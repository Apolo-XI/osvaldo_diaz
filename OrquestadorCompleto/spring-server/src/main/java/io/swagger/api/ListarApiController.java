package io.swagger.api;


import io.swagger.model.JsonApiBodyRequest2;
import io.swagger.model.JsonApiBodyRequestNegocio;
import io.swagger.model.JsonApiBodyRequestOfertas;
import io.swagger.model.JsonApiBodyRequestPersona;
import io.swagger.model.JsonApiBodyResponseErrors;
import io.swagger.model.JsonApiBodyResponseErrorsOferta;
import io.swagger.model.JsonApiBodyResponseSuccessNegocio;
import io.swagger.model.JsonApiBodyResponseSuccessPersona;

import io.swagger.model.RegistrarRequestPersona;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;

import org.apache.camel.EndpointInject;
import org.apache.camel.FluentProducerTemplate;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-17T22:23:09.345Z")

@Controller
public class ListarApiController implements ListarApi {

	@EndpointInject(uri="direct:get-personas")
	private FluentProducerTemplate producerPersona;
	     
	@EndpointInject(uri="direct:get-negocios")
	private FluentProducerTemplate producerNegocio;
	
	@EndpointInject(uri="direct:get-negocios-idadmin")
	private FluentProducerTemplate producerNegociogetidadmin;
	
	
	private static final Logger log = LoggerFactory.getLogger(ListarApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ListarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<?> listarNegociosGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	System.out.println("estamos en el get");
        	try {
                JsonApiBodyRequestNegocio negocio = (JsonApiBodyRequestNegocio) producerNegocio.request();
                return new ResponseEntity<JsonApiBodyRequestNegocio>(negocio,HttpStatus.OK);
              } catch (Exception e) {
            	  JsonApiBodyResponseErrors Errors = new JsonApiBodyResponseErrors();
            	  Errors.setCode("0700");
            	  Errors.setDetalle("ERROR EN EL ORQUESTADOR");
                  return new ResponseEntity<JsonApiBodyResponseErrors>(Errors,  HttpStatus.INTERNAL_SERVER_ERROR);
              }
        }

        return new ResponseEntity<JsonApiBodyRequestNegocio>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<?> listarNegociosIdadminIdadminGet(@ApiParam(value = "ID del negocio",required=true) 
    @PathVariable("idadmin") String idadmin) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	try {
        		System.out.println("el id del admin es  "+idadmin);
            	JsonApiBodyRequestNegocio negocio = (JsonApiBodyRequestNegocio) producerNegociogetidadmin.withBody(idadmin).request();
                return new ResponseEntity<JsonApiBodyRequestNegocio>(negocio,HttpStatus.OK);
             
            } catch (Exception e) {
          	  JsonApiBodyResponseErrors Errors = new JsonApiBodyResponseErrors();
          	  Errors.setCode("0700");
          	  Errors.setDetalle("ERROR EN EL ORQUESTADOR");
               return new ResponseEntity<JsonApiBodyResponseErrors>(Errors,  HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<JsonApiBodyRequestNegocio>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<JsonApiBodyRequestNegocio> listarNegociosIdnegocioGet(@ApiParam(value = "ID del negocio",required=true) @PathVariable("idnegocio") String idnegocio) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<JsonApiBodyRequestNegocio>(objectMapper.readValue("{  \"negocio\" : [ {    \"idnegocio\" : \"idnegocio\",    \"nombre_negocio\" : \"nombre_negocio\",    \"tipo\" : \"tipo\",    \"ubicacion\" : \"ubicacion\",    \"foto\" : \"foto\",    \"correo\" : \"correo\",    \"nit\" : \"nit\",    \"idadmin\" : \"idadmin\",    \"telefono\" : \"telefono\",    \"detalle\" : \"detalle\"  }, {    \"idnegocio\" : \"idnegocio\",    \"nombre_negocio\" : \"nombre_negocio\",    \"tipo\" : \"tipo\",    \"ubicacion\" : \"ubicacion\",    \"foto\" : \"foto\",    \"correo\" : \"correo\",    \"nit\" : \"nit\",    \"idadmin\" : \"idadmin\",    \"telefono\" : \"telefono\",    \"detalle\" : \"detalle\"  } ]}", JsonApiBodyRequestNegocio.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<JsonApiBodyRequestNegocio>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<JsonApiBodyRequestNegocio>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<JsonApiBodyRequestNegocio> listarNegociosTiponegocioTiponegocioGet(@ApiParam(value = "ID de la persona",required=true) @PathVariable("tiponegocio") String tiponegocio) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<JsonApiBodyRequestNegocio>(objectMapper.readValue("{  \"negocio\" : [ {    \"idnegocio\" : \"idnegocio\",    \"nombre_negocio\" : \"nombre_negocio\",    \"tipo\" : \"tipo\",    \"ubicacion\" : \"ubicacion\",    \"foto\" : \"foto\",    \"correo\" : \"correo\",    \"nit\" : \"nit\",    \"idadmin\" : \"idadmin\",    \"telefono\" : \"telefono\",    \"detalle\" : \"detalle\"  }, {    \"idnegocio\" : \"idnegocio\",    \"nombre_negocio\" : \"nombre_negocio\",    \"tipo\" : \"tipo\",    \"ubicacion\" : \"ubicacion\",    \"foto\" : \"foto\",    \"correo\" : \"correo\",    \"nit\" : \"nit\",    \"idadmin\" : \"idadmin\",    \"telefono\" : \"telefono\",    \"detalle\" : \"detalle\"  } ]}", JsonApiBodyRequestNegocio.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<JsonApiBodyRequestNegocio>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<JsonApiBodyRequestNegocio>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<JsonApiBodyRequestOfertas> listarOfertasGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<JsonApiBodyRequestOfertas>(objectMapper.readValue("{  \"oferta\" : [ {    \"fechainicio\" : \"fechainicio\",    \"idnegocio\" : \"idnegocio\",    \"foto\" : \"foto\",    \"descuento\" : \"descuento\",    \"valor\" : \"valor\",    \"id\" : \"id\",    \"producto\" : \"producto\",    \"fechafinal\" : \"fechafinal\",    \"detalle\" : \"detalle\"  }, {    \"fechainicio\" : \"fechainicio\",    \"idnegocio\" : \"idnegocio\",    \"foto\" : \"foto\",    \"descuento\" : \"descuento\",    \"valor\" : \"valor\",    \"id\" : \"id\",    \"producto\" : \"producto\",    \"fechafinal\" : \"fechafinal\",    \"detalle\" : \"detalle\"  } ]}", JsonApiBodyRequestOfertas.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<JsonApiBodyRequestOfertas>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<JsonApiBodyRequestOfertas>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<JsonApiBodyRequestOfertas> listarOfertasIdnegocioIdnegocioGet(@ApiParam(value = "ID del negocio",required=true) @PathVariable("idnegocio") String idnegocio) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<JsonApiBodyRequestOfertas>(objectMapper.readValue("{  \"oferta\" : [ {    \"fechainicio\" : \"fechainicio\",    \"idnegocio\" : \"idnegocio\",    \"foto\" : \"foto\",    \"descuento\" : \"descuento\",    \"valor\" : \"valor\",    \"id\" : \"id\",    \"producto\" : \"producto\",    \"fechafinal\" : \"fechafinal\",    \"detalle\" : \"detalle\"  }, {    \"fechainicio\" : \"fechainicio\",    \"idnegocio\" : \"idnegocio\",    \"foto\" : \"foto\",    \"descuento\" : \"descuento\",    \"valor\" : \"valor\",    \"id\" : \"id\",    \"producto\" : \"producto\",    \"fechafinal\" : \"fechafinal\",    \"detalle\" : \"detalle\"  } ]}", JsonApiBodyRequestOfertas.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<JsonApiBodyRequestOfertas>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<JsonApiBodyRequestOfertas>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<JsonApiBodyRequestOfertas> listarOfertasIdofertaGet(@ApiParam(value = "ID de la ofertas",required=true) @PathVariable("idoferta") String idoferta) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<JsonApiBodyRequestOfertas>(objectMapper.readValue("{  \"oferta\" : [ {    \"fechainicio\" : \"fechainicio\",    \"idnegocio\" : \"idnegocio\",    \"foto\" : \"foto\",    \"descuento\" : \"descuento\",    \"valor\" : \"valor\",    \"id\" : \"id\",    \"producto\" : \"producto\",    \"fechafinal\" : \"fechafinal\",    \"detalle\" : \"detalle\"  }, {    \"fechainicio\" : \"fechainicio\",    \"idnegocio\" : \"idnegocio\",    \"foto\" : \"foto\",    \"descuento\" : \"descuento\",    \"valor\" : \"valor\",    \"id\" : \"id\",    \"producto\" : \"producto\",    \"fechafinal\" : \"fechafinal\",    \"detalle\" : \"detalle\"  } ]}", JsonApiBodyRequestOfertas.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<JsonApiBodyRequestOfertas>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<JsonApiBodyRequestOfertas>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<JsonApiBodyRequestOfertas> listarOfertasProductoProductoGet(@ApiParam(value = "ID de la persona",required=true) @PathVariable("producto") String producto) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<JsonApiBodyRequestOfertas>(objectMapper.readValue("{  \"oferta\" : [ {    \"fechainicio\" : \"fechainicio\",    \"idnegocio\" : \"idnegocio\",    \"foto\" : \"foto\",    \"descuento\" : \"descuento\",    \"valor\" : \"valor\",    \"id\" : \"id\",    \"producto\" : \"producto\",    \"fechafinal\" : \"fechafinal\",    \"detalle\" : \"detalle\"  }, {    \"fechainicio\" : \"fechainicio\",    \"idnegocio\" : \"idnegocio\",    \"foto\" : \"foto\",    \"descuento\" : \"descuento\",    \"valor\" : \"valor\",    \"id\" : \"id\",    \"producto\" : \"producto\",    \"fechafinal\" : \"fechafinal\",    \"detalle\" : \"detalle\"  } ]}", JsonApiBodyRequestOfertas.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<JsonApiBodyRequestOfertas>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<JsonApiBodyRequestOfertas>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<JsonApiBodyRequestPersona> listarPersonasEstadoEstadoGet(@ApiParam(value = "ID de la persona",required=true) @PathVariable("estado") String estado) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<JsonApiBodyRequestPersona>(objectMapper.readValue("{  \"persona\" : [ {    \"apellidos\" : \"apellidos\",    \"estado\" : \"estado\",    \"correo\" : \"correo\",    \"genero\" : \"genero\",    \"contrasena\" : \"contrasena\",    \"id\" : \"id\",    \"telefono\" : \"telefono\",    \"nombre\" : \"nombre\",    \"rol\" : \"rol\",    \"token\" : \"token\"  }, {    \"apellidos\" : \"apellidos\",    \"estado\" : \"estado\",    \"correo\" : \"correo\",    \"genero\" : \"genero\",    \"contrasena\" : \"contrasena\",    \"id\" : \"id\",    \"telefono\" : \"telefono\",    \"nombre\" : \"nombre\",    \"rol\" : \"rol\",    \"token\" : \"token\"  } ]}", JsonApiBodyRequestPersona.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<JsonApiBodyRequestPersona>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<JsonApiBodyRequestPersona>(HttpStatus.NOT_IMPLEMENTED);
    }

    //public ResponseEntity<?> listarPersonasGet() 
    public ResponseEntity<?> listarPersonasGet(@ApiParam(value = "body" ,required=true )  
    @Valid @RequestBody JsonApiBodyRequest2 body)
    {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	try {
                JsonApiBodyRequestPersona persona = (JsonApiBodyRequestPersona) producerPersona.withBody(body).request();
                return new ResponseEntity<JsonApiBodyRequestPersona>(persona,HttpStatus.OK);
              } catch (Exception e) {
            	  JsonApiBodyResponseErrors Errors = new JsonApiBodyResponseErrors();
            	  Errors.setCode("0700");
            	  Errors.setDetalle("ERROR EN EL ORQUESTADOR");
                  return new ResponseEntity<JsonApiBodyResponseErrors>(Errors,  HttpStatus.INTERNAL_SERVER_ERROR);
              } 

        }

        return new ResponseEntity<JsonApiBodyRequestPersona>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<JsonApiBodyRequestPersona> listarPersonasIdpersonaGet(@ApiParam(value = "ID de la persona",required=true) @PathVariable("idpersona") String idpersona) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<JsonApiBodyRequestPersona>(objectMapper.readValue("{  \"persona\" : [ {    \"apellidos\" : \"apellidos\",    \"estado\" : \"estado\",    \"correo\" : \"correo\",    \"genero\" : \"genero\",    \"contrasena\" : \"contrasena\",    \"id\" : \"id\",    \"telefono\" : \"telefono\",    \"nombre\" : \"nombre\",    \"rol\" : \"rol\",    \"token\" : \"token\"  }, {    \"apellidos\" : \"apellidos\",    \"estado\" : \"estado\",    \"correo\" : \"correo\",    \"genero\" : \"genero\",    \"contrasena\" : \"contrasena\",    \"id\" : \"id\",    \"telefono\" : \"telefono\",    \"nombre\" : \"nombre\",    \"rol\" : \"rol\",    \"token\" : \"token\"  } ]}", JsonApiBodyRequestPersona.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<JsonApiBodyRequestPersona>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<JsonApiBodyRequestPersona>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<JsonApiBodyRequestPersona> listarPersonasRolRolGet(@ApiParam(value = "ID de la persona",required=true) @PathVariable("rol") String rol) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<JsonApiBodyRequestPersona>(objectMapper.readValue("{  \"persona\" : [ {    \"apellidos\" : \"apellidos\",    \"estado\" : \"estado\",    \"correo\" : \"correo\",    \"genero\" : \"genero\",    \"contrasena\" : \"contrasena\",    \"id\" : \"id\",    \"telefono\" : \"telefono\",    \"nombre\" : \"nombre\",    \"rol\" : \"rol\",    \"token\" : \"token\"  }, {    \"apellidos\" : \"apellidos\",    \"estado\" : \"estado\",    \"correo\" : \"correo\",    \"genero\" : \"genero\",    \"contrasena\" : \"contrasena\",    \"id\" : \"id\",    \"telefono\" : \"telefono\",    \"nombre\" : \"nombre\",    \"rol\" : \"rol\",    \"token\" : \"token\"  } ]}", JsonApiBodyRequestPersona.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<JsonApiBodyRequestPersona>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<JsonApiBodyRequestPersona>(HttpStatus.NOT_IMPLEMENTED);
    }

}

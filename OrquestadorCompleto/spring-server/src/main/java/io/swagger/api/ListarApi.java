/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.JsonApiBodyRequest2;
import io.swagger.model.JsonApiBodyRequestNegocio;
import io.swagger.model.JsonApiBodyRequestOfertas;
import io.swagger.model.JsonApiBodyRequestPersona;
import io.swagger.model.JsonApiBodyResponseErrors;
import io.swagger.model.JsonApiBodyResponseErrorsOferta;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-17T22:23:09.345Z")

@Api(value = "listar", description = "the listar API")
public interface ListarApi {

    @ApiOperation(value = "Listado de negocios", nickname = "listarNegociosGet", notes = "Listado de negocios de la tabla negocios de la base de datos.", response = JsonApiBodyRequestNegocio.class, tags={ "servicio", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = JsonApiBodyRequestNegocio.class),
        @ApiResponse(code = 404, message = "NEGOCIOS NO ENCONTRADOS", response = JsonApiBodyResponseErrors.class) })
    @RequestMapping(value = "/listar/negocios/",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<?> listarNegociosGet();


    @ApiOperation(value = "Busqueda de negocios por id de administrador", nickname = "listarNegociosIdadminIdadminGet", notes = "Busqueda de negocios por id de administrador en la tabla negocio de la base de datos.", response = JsonApiBodyRequestNegocio.class, tags={ "servicio", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = JsonApiBodyRequestNegocio.class),
        @ApiResponse(code = 404, message = "NEGOCIO NO ENCONTRADO", response = JsonApiBodyResponseErrors.class) })
    @RequestMapping(value = "/listar/negocios/idadmin/{idadmin}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<?> listarNegociosIdadminIdadminGet(@ApiParam(value = "ID del negocio",required=true) @PathVariable("idadmin") String idadmin);


    @ApiOperation(value = "Busqueda de negocios por id de negocio", nickname = "listarNegociosIdnegocioGet", notes = "Busqueda de negocios por id de negocio en la tabla negocio de la base de datos.", response = JsonApiBodyRequestNegocio.class, tags={ "servicio", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = JsonApiBodyRequestNegocio.class),
        @ApiResponse(code = 404, message = "NEGOCIO NO ENCONTRADO", response = JsonApiBodyResponseErrors.class) })
    @RequestMapping(value = "/listar/negocios/{idnegocio}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<JsonApiBodyRequestNegocio> listarNegociosIdnegocioGet(@ApiParam(value = "ID del negocio",required=true) @PathVariable("idnegocio") String idnegocio);


    @ApiOperation(value = "Busqueda de negocio por tipo de negocio", nickname = "listarNegociosTiponegocioTiponegocioGet", notes = "Busqueda de negocio por tipo de negocio en la tabla negocio de la base de datos.", response = JsonApiBodyRequestNegocio.class, tags={ "servicio", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = JsonApiBodyRequestNegocio.class),
        @ApiResponse(code = 404, message = "NO ENCONTRADO", response = JsonApiBodyResponseErrors.class) })
    @RequestMapping(value = "/listar/negocios/tiponegocio/{tiponegocio}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<JsonApiBodyRequestNegocio> listarNegociosTiponegocioTiponegocioGet(@ApiParam(value = "ID de la persona",required=true) @PathVariable("tiponegocio") String tiponegocio);


    @ApiOperation(value = "Listado de ofertas", nickname = "listarOfertasGet", notes = "Listado de ofertas de la tabla Ofertas de la base de datos.", response = JsonApiBodyRequestOfertas.class, tags={ "servicio", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = JsonApiBodyRequestOfertas.class),
        @ApiResponse(code = 404, message = "OFERTAS NO ENCONTRADOS", response = JsonApiBodyResponseErrorsOferta.class) })
    @RequestMapping(value = "/listar/ofertas/",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<JsonApiBodyRequestOfertas> listarOfertasGet();


    @ApiOperation(value = "Busqueda de ofertas por id de negocio", nickname = "listarOfertasIdnegocioIdnegocioGet", notes = "Busqueda de ofertas por id de negocio en la tabla negocio de la base de datos.", response = JsonApiBodyRequestOfertas.class, tags={ "servicio", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = JsonApiBodyRequestOfertas.class),
        @ApiResponse(code = 404, message = "NEGOCIO NO ENCONTRADO", response = JsonApiBodyResponseErrorsOferta.class) })
    @RequestMapping(value = "/listar/ofertas/idnegocio/{idnegocio}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<JsonApiBodyRequestOfertas> listarOfertasIdnegocioIdnegocioGet(@ApiParam(value = "ID del negocio",required=true) @PathVariable("idnegocio") String idnegocio);


    @ApiOperation(value = "Busqueda de ofertas por id de negocio", nickname = "listarOfertasIdofertaGet", notes = "Busqueda de ofertas por id de negocio en la tabla negocio de la base de datos.", response = JsonApiBodyRequestOfertas.class, tags={ "servicio", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = JsonApiBodyRequestOfertas.class),
        @ApiResponse(code = 404, message = "OFERTA NO ENCONTRADA", response = JsonApiBodyResponseErrorsOferta.class) })
    @RequestMapping(value = "/listar/ofertas/{idoferta}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<JsonApiBodyRequestOfertas> listarOfertasIdofertaGet(@ApiParam(value = "ID de la ofertas",required=true) @PathVariable("idoferta") String idoferta);


    @ApiOperation(value = "Busqueda de ofertas por tipo de producto", nickname = "listarOfertasProductoProductoGet", notes = "Busqueda de ofertas por tipo de producto en la tabla ofertas de la base de datos.", response = JsonApiBodyRequestOfertas.class, tags={ "servicio", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = JsonApiBodyRequestOfertas.class),
        @ApiResponse(code = 404, message = "NO ENCONTRADO", response = JsonApiBodyResponseErrorsOferta.class) })
    @RequestMapping(value = "/listar/ofertas/producto/{producto}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<JsonApiBodyRequestOfertas> listarOfertasProductoProductoGet(@ApiParam(value = "ID de la persona",required=true) @PathVariable("producto") String producto);


    @ApiOperation(value = "Busqueda de personas por estado", nickname = "listarPersonasEstadoEstadoGet", notes = "Busqueda de personas por estado en la tabla personas de la base de datos.", response = JsonApiBodyRequestPersona.class, tags={ "servicio", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = JsonApiBodyRequestPersona.class),
        @ApiResponse(code = 404, message = "NO ENCONTRADO", response = JsonApiBodyResponseErrors.class) })
    @RequestMapping(value = "/listar/personas/estado/{estado}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<JsonApiBodyRequestPersona> listarPersonasEstadoEstadoGet(@ApiParam(value = "ID de la persona",required=true) @PathVariable("estado") String estado);


    @ApiOperation(value = "Listado de personas", nickname = "listarPersonasGet", notes = "Listado de personas de la tabla negocios de la base de datos.", response = JsonApiBodyRequestPersona.class, tags={ "servicio", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = JsonApiBodyRequestPersona.class),
        @ApiResponse(code = 404, message = "NEGOCIOS NO ENCONTRADOS", response = JsonApiBodyResponseErrors.class) })
    @RequestMapping(value = "/listar/personas/",
        produces = { "application/json" }, 
        //method = RequestMethod.GET)
        method = RequestMethod.POST)
    //ResponseEntity<?> listarPersonasGet();
      ResponseEntity<?> listarPersonasGet(@ApiParam(value = "body" ,required=true )  @Valid @RequestBody JsonApiBodyRequest2 body);


    @ApiOperation(value = "Busqueda de personas por id", nickname = "listarPersonasIdpersonaGet", notes = "Busqueda de personas por id en la tabla personas de la base de datos.", response = JsonApiBodyRequestPersona.class, tags={ "servicio", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = JsonApiBodyRequestPersona.class),
        @ApiResponse(code = 404, message = "PERSONA NO ENCONTRADA", response = JsonApiBodyResponseErrors.class) })
    @RequestMapping(value = "/listar/personas/{idpersona}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<JsonApiBodyRequestPersona> listarPersonasIdpersonaGet(@ApiParam(value = "ID de la persona",required=true) @PathVariable("idpersona") String idpersona);


    @ApiOperation(value = "Busqueda de personas por rol", nickname = "listarPersonasRolRolGet", notes = "Busqueda de personas por rol en la tabla personas de la base de datos.", response = JsonApiBodyRequestPersona.class, tags={ "servicio", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = JsonApiBodyRequestPersona.class),
        @ApiResponse(code = 404, message = "NO ENCONTRADO", response = JsonApiBodyResponseErrors.class) })
    @RequestMapping(value = "/listar/personas/rol/{rol}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<JsonApiBodyRequestPersona> listarPersonasRolRolGet(@ApiParam(value = "ID de la persona",required=true) @PathVariable("rol") String rol);

}

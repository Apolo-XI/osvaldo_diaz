/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.JsonApiBodyRequest;
import io.swagger.model.JsonApiBodyResponseErrors;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-01T20:15:25.137Z")

@Api(value = "listar", description = "the listar API")
public interface ListarApi {

    @ApiOperation(value = "Listado de negocio", nickname = "listarGet", notes = "Listado de negocios de la tabla negocios de la base de datos.", response = JsonApiBodyRequest.class, tags={ "negocio", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = JsonApiBodyRequest.class),
        @ApiResponse(code = 404, message = "NEGOCIOS NO ENCONTRADOS", response = JsonApiBodyResponseErrors.class) })
    @RequestMapping(value = "/listar",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<?> listarGet();


    @ApiOperation(value = "Busqueda de negocios por id de administrador", nickname = "listarIdadminIdadminGet", notes = "Busqueda de negocios por id de administrador en la tabla negocio de la base de datos.", response = JsonApiBodyRequest.class, tags={ "negocio", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = JsonApiBodyRequest.class),
        @ApiResponse(code = 404, message = "NEGOCIO NO ENCONTRADO", response = JsonApiBodyResponseErrors.class) })
    @RequestMapping(value = "/listar/idadmin/{idadmin}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<?> listarIdadminIdadminGet(@ApiParam(value = "ID del negocio",required=true) @PathVariable("idadmin") String idadmin);


    @ApiOperation(value = "Busqueda de negocios por id de negocio", nickname = "listarIdnegocioGet", notes = "Busqueda de negocios por id de negocio en la tabla negocio de la base de datos.", response = JsonApiBodyRequest.class, tags={ "negocio", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = JsonApiBodyRequest.class),
        @ApiResponse(code = 404, message = "NEGOCIO NO ENCONTRADO", response = JsonApiBodyResponseErrors.class) })
    @RequestMapping(value = "/listar/{idnegocio}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<?> listarIdnegocioGet(@ApiParam(value = "ID del negocio",required=true) @PathVariable("idnegocio") String idnegocio);


    @ApiOperation(value = "Busqueda de negocio por tipo de negocio", nickname = "listarTiponegocioTiponegocioGet", notes = "Busqueda de negocio por tipo de negocio en la tabla negocio de la base de datos.", response = JsonApiBodyRequest.class, tags={ "negocio", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = JsonApiBodyRequest.class),
        @ApiResponse(code = 404, message = "NO ENCONTRADO", response = JsonApiBodyResponseErrors.class) })
    @RequestMapping(value = "/listar/tiponegocio/{tiponegocio}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<?> listarTiponegocioTiponegocioGet(@ApiParam(value = "ID de la persona",required=true) @PathVariable("tiponegocio") String tiponegocio);

}

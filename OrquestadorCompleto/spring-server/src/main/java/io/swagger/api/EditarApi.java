/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.JsonApiBodyRequestNegocio;
import io.swagger.model.JsonApiBodyRequestOfertas;
import io.swagger.model.JsonApiBodyRequestPersona;
import io.swagger.model.JsonApiBodyResponseErrors;
import io.swagger.model.JsonApiBodyResponseErrorsOferta;
import io.swagger.model.JsonApiBodyResponseSuccessNegocio;
import io.swagger.model.JsonApiBodyResponseSuccessOferta;
import io.swagger.model.JsonApiBodyResponseSuccessPersona;
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

@Api(value = "editar", description = "the editar API")
public interface EditarApi {

    @ApiOperation(value = "Editar negocio", nickname = "editarNegociosIdnegocioPut", notes = "Editar negocio por id de negocio", response = JsonApiBodyResponseSuccessNegocio.class, tags={ "servicio", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "NEGOCIO ACTUALIZADO", response = JsonApiBodyResponseSuccessNegocio.class),
        @ApiResponse(code = 400, message = "Datos incompletos o incorrectos.", response = JsonApiBodyResponseErrors.class) })
    @RequestMapping(value = "/editar/negocios/{idnegocio}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<JsonApiBodyResponseSuccessNegocio> editarNegociosIdnegocioPut(@ApiParam(value = "ID del negocio",required=true) @PathVariable("idnegocio") String idnegocio,@ApiParam(value = "body" ,required=true )  @Valid @RequestBody JsonApiBodyRequestNegocio body);


    @ApiOperation(value = "Editar oferta", nickname = "editarOfertasIdofertaPut", notes = "Editar oferta por id de oferta", response = JsonApiBodyResponseSuccessOferta.class, tags={ "servicio", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OFERTA ACTUALIZADO", response = JsonApiBodyResponseSuccessOferta.class),
        @ApiResponse(code = 400, message = "Datos incompletos o incorrectos.", response = JsonApiBodyResponseErrorsOferta.class) })
    @RequestMapping(value = "/editar/ofertas/{idoferta}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<JsonApiBodyResponseSuccessOferta> editarOfertasIdofertaPut(@ApiParam(value = "ID del negocio",required=true) @PathVariable("idoferta") String idoferta,@ApiParam(value = "body" ,required=true )  @Valid @RequestBody JsonApiBodyRequestOfertas body);


    @ApiOperation(value = "Editar persona", nickname = "editarPersonasIdPut", notes = "Editar persona por id", response = JsonApiBodyResponseSuccessPersona.class, tags={ "servicio", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Persona editada", response = JsonApiBodyResponseSuccessPersona.class),
        @ApiResponse(code = 400, message = "Datos incompletos o incorrectos.", response = JsonApiBodyResponseErrors.class) })
    @RequestMapping(value = "/editar/personas/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<JsonApiBodyResponseSuccessPersona> editarPersonasIdPut(@ApiParam(value = "ID de la persona",required=true) @PathVariable("id") String id,@ApiParam(value = "body" ,required=true )  @Valid @RequestBody JsonApiBodyRequestPersona body);

}

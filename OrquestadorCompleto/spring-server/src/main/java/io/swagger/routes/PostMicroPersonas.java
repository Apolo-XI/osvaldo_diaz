package io.swagger.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import io.swagger.model.JsonApiBodyRequestPersona;
import io.swagger.model.JsonApiBodyResponseErrors;


@Component
public class PostMicroPersonas extends RouteBuilder {

	
	
	
	@Override
	public void configure() throws Exception {
//		from("direct:post-negocio").end();
		
		from("direct:post-personas")
			.routeId("Personas")
			.setHeader(Exchange.HTTP_METHOD, constant("POST"))	
			.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
			.setHeader("Accept", constant("application/json"))
			.process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					
					JsonApiBodyRequestPersona requestPersona = (JsonApiBodyRequestPersona) exchange.getIn().getBody();
					//exchange.setProperty("id", requestPersona.getPersona().get(0).getId());
					exchange.setProperty("nombre", requestPersona.getPersona().get(0).getNombre());
					exchange.setProperty("apellidos", requestPersona.getPersona().get(0).getApellidos());
					exchange.setProperty("correo", requestPersona.getPersona().get(0).getCorreo());
					exchange.setProperty("contrasena", requestPersona.getPersona().get(0).getContrasena());
					exchange.setProperty("telefono", requestPersona.getPersona().get(0).getTelefono());
					exchange.setProperty("genero", requestPersona.getPersona().get(0).getGenero());
					exchange.setProperty("rol", requestPersona.getPersona().get(0).getRol());
					exchange.setProperty("estado", requestPersona.getPersona().get(0).getEstado());
					exchange.setProperty("ciudad", requestPersona.getPersona().get(0).getciudad());
					exchange.setProperty("token", requestPersona.getPersona().get(0).getToken());
					
				}
			})
			.to("freemarker:templates/SetPeople.ftl")
			.hystrix()
			.hystrixConfiguration().executionTimeoutInMilliseconds(3000).end()
			.to("http4://localhost:8060/personas/registrar/")
			
			
			.convertBodyTo(String.class)
			.log("LLLLLLLLLLLLLLL ${body}")
			//.unmarshal().json(JsonLibrary.Jackson, ClientJsonApiBodyResponseSuccess.class)
			.endHystrix()
			.onFallback()
			.log("sMMMMMMMMMMMMM${body}")
			.unmarshal().json(JsonLibrary.Jackson,JsonApiBodyResponseErrors.class)
			.process(new Processor() {
				
				@Override
				public void process(Exchange exchange) throws Exception {
					JsonApiBodyResponseErrors negocios= (JsonApiBodyResponseErrors) exchange.getIn().getBody();
					System.out.println("este el el objeto ya parciado "+negocios.getDetalle());
//					JsonApiBodyResponseErrors error =(JsonApiBodyResponseErrors) exchange.getIn().getBody();
//					System.out.println(error.toString());
				}
			})
			.end();
	}
}

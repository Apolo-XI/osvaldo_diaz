package io.swagger.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import io.swagger.model.JsonApiBodyRequestNegocio;

@Component
public class PostMicroNegocios extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:post-negocios")
			.routeId("Negocios")
			.setHeader(Exchange.HTTP_METHOD, constant("POST"))	
			.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
			.setHeader("Accept", constant("application/json"))
			.log("request microservice para Negocios ${body}")
			.process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					// TODO Auto-generated method stub
					JsonApiBodyRequestNegocio requestPersona = (JsonApiBodyRequestNegocio) exchange.getIn().getBody();
					//exchange.setProperty("id", requestPersona.getPersona().get(0).getId());
					exchange.setProperty("idadmin", requestPersona.getNegocio().get(0).getIdadmin());
					exchange.setProperty("nombre_negocio", requestPersona.getNegocio().get(0).getNombreNegocio());
					exchange.setProperty("nit", requestPersona.getNegocio().get(0).getNit());
					exchange.setProperty("telefono", requestPersona.getNegocio().get(0).getTelefono());
					exchange.setProperty("correo", requestPersona.getNegocio().get(0).getCorreo());
					exchange.setProperty("tipo", requestPersona.getNegocio().get(0).getTipo());
					exchange.setProperty("foto", requestPersona.getNegocio().get(0).getFoto());
					exchange.setProperty("ubicacion", requestPersona.getNegocio().get(0).getUbicacion());
					exchange.setProperty("detalle", requestPersona.getNegocio().get(0).getDetalle());
					
				}
			})
			.to("freemarker:templates/SetNegocio.ftl")
			//.log("ANTES ${body}")
			.hystrix()
			.hystrixConfiguration().executionTimeoutInMilliseconds(2000).end()
			.to("http4://localhost:8050/negocios/registrar")
			.convertBodyTo(String.class)
			//.log("response microservice Osvaldo ${body}")
			//.unmarshal().json(JsonLibrary.Jackson, ClientJsonApiBodyResponseSuccess.class)
			.endHystrix()
			.onFallback()
			.log("se respondio esto ${body}")
			.end();
	}

}
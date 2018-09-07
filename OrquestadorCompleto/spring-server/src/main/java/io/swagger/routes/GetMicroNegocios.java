package io.swagger.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import io.swagger.model.JsonApiBodyRequest2;
import io.swagger.model.JsonApiBodyRequestNegocio;
import io.swagger.model.JsonApiBodyRequestPersona;

@Component
public class GetMicroNegocios extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:get-negocios")
			.routeId("Negocios-Get")
			.setHeader(Exchange.HTTP_METHOD, constant("GET"))	
			.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
			.setHeader("Accept", constant("application/json"))
			/*.process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					
					JsonApiBodyRequest2 requestPersona = (JsonApiBodyRequest2) exchange.getIn().getBody();
					exchange.setProperty("id", requestPersona.getPersona().get(0).getId());
					exchange.setProperty("rol", requestPersona.getPersona().get(0).getRol());
					exchange.setProperty("estado", requestPersona.getPersona().get(0).getEstado());
					exchange.setProperty("token", requestPersona.getPersona().get(0).gettoken());
				}
			})*/
			//.to("freemarker:templates/getPeople.ftl")
			.log("estamos en el connect")
			.hystrix()
			.hystrixConfiguration().executionTimeoutInMilliseconds(3000).end()
			.to("http4://localhost:8050/negocios/listar")
			.convertBodyTo(String.class)
			.unmarshal().json(JsonLibrary.Jackson,JsonApiBodyRequestNegocio.class)
			.process(new Processor() {
				
				@Override
				public void process(Exchange exchange) throws Exception {
					JsonApiBodyRequestNegocio negocios= (JsonApiBodyRequestNegocio) exchange.getIn().getBody();
					System.out.println("este el el objeto ya parciado "+negocios.getNegocio());
//					JsonApiBodyResponseErrors error =(JsonApiBodyResponseErrors) exchange.getIn().getBody();
//					System.out.println(error.toString());
				}
			})
			.endHystrix()  
			.onFallback()
			.log("se respondio esto ${body}")
			.end();
	}

}


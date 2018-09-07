package io.swagger.routes;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import io.swagger.model.JsonApiBodyRequestNegocio;


@Component
public class GetMicroNegociosIdadmin extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:get-negocios-idadmin")
			.routeId("Negocios-get-idadmin")
			.setHeader(Exchange.HTTP_METHOD, constant("GET"))	
			.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
			.setHeader("Accept", constant("application/json"))
			.hystrix()
			.hystrixConfiguration().executionTimeoutInMilliseconds(3000).end()
			.recipientList(simple("http4://localhost:8050/negocios/listar/idadmin/${body}"))
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
			.log("PROBLEMAS CON LA CONEXION")
			.end();
	}

}
package io.swagger.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import io.swagger.model.JsonApiBodyResponseSuccessNegocio;

@Component
public class DeleteMicroNegocios extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:delete-negocios")
			.routeId("Negocios-delete")
			.setHeader(Exchange.HTTP_METHOD, constant("DELETE"))	
			.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
			.setHeader("Accept", constant("application/json"))
			.hystrix()
			.hystrixConfiguration().executionTimeoutInMilliseconds(3000).end()
			.recipientList(simple("http4://localhost:8050/negocios/eliminar/${body}")) 
			//.to("http4://localhost:8050/negocios/eliminar/${body}")
			//.convertBodyTo(String.class)
			//.unmarshal().json(JsonLibrary.Jackson,JsonApiBodyRequestNegocio.class)
			.process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					JsonApiBodyResponseSuccessNegocio negocios= (JsonApiBodyResponseSuccessNegocio) exchange.getIn().getBody();	
				}
			})
			.endHystrix()  
			.onFallback()
			.log("PROBLEMAS CON LA CONEXION")
			.end();
	}

}
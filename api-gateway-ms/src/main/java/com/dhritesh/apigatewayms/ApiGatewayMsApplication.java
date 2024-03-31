package com.dhritesh.apigatewayms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayMsApplication {
//	@Bean
//	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route("REVIEW-MS", r -> r.path("/api/review/**")
//						.uri("lb://REVIEW-MS"))
////				.route("service2", r -> r.path("/service2/**")
////						.filters(f -> f.stripPrefix(1))
////						.uri("lb://SERVICE-NAME2"))
//				.build();
//	}
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayMsApplication.class, args);
	}

}

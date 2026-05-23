package com.miniarcade.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(
            RouteLocatorBuilder builder,
            @Value("${routes.auth-service-uri}") String authUri,
            @Value("${routes.score-service-uri}") String scoreUri
    ) {
        return builder.routes()
            .route("auth-service", r -> r
                .path("/api/auth/**")
                .uri(authUri))
            .route("score-service", r -> r
                .path("/api/scores", "/api/scores/**")
                .uri(scoreUri))
            .build();
    }
}
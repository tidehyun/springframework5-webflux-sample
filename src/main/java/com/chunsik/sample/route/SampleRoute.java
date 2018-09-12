package com.chunsik.sample.route;

import com.chunsik.sample.handler.SampleHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class SampleRoute implements WebFluxConfigurer {

    @Autowired
    SampleHandler handler;

    @Bean
    public RouterFunction<ServerResponse> restRoutes() {
        return RouterFunctions.route(RequestPredicates.GET("/sayHi"), handler::sayHi)
                .andRoute(RequestPredicates.GET("/sample").and(accept(APPLICATION_JSON)), handler::sample);
    }

}

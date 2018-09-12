package com.chunsik.sample.handler;

import com.chunsik.sample.model.Sample;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class SampleHandler {

    @Autowired
    private ObjectMapper mapper;

    public Mono<ServerResponse> sayHi(ServerRequest request) {
        return ServerResponse.ok().body(Mono.just(new String("hi")).doOnNext(c -> log.info("{}", c)), String.class);
    }

    public Mono<ServerResponse> sample(ServerRequest request) {
        String result = null;
        try {
            result = mapper.writeValueAsString(Sample.builder().name("test").email("test@test.com").build());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ServerResponse.ok().body(Mono.just(result).doOnNext(c -> log.info("data : {}", c)), String.class);
    }
}

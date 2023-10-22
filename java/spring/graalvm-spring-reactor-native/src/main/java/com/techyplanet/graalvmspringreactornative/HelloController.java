package com.techyplanet.graalvmspringreactornative;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello/{name}")
    public Mono<String> getHelloMessage(@PathVariable String name) {
        logger.info("Received path variable name : {}", name);
        return Mono.just(String.format("Hello %s!!", name));
    }
}

package com.qkyrie.spring.examples.caching.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * User: Quinten
 * Date: 25-4-2014
 * Time: 12:54
 *
 * @author Quinten De Swaef
 */
@Profile("production")
@Configuration
public class HelloWorldProductionProducer {

    @Bean(name = "helloWorld")
    public String produceHelloWorld() {
        return "Hello production world!";
    }

}

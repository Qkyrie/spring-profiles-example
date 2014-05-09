package com.qkyrie.spring.examples.caching.producer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

/**
 * User: Quinten
 * Date: 25-4-2014
 * Time: 12:54
 *
 * @author Quinten De Swaef
 */
@Profile("test")
@Configuration
public class HelloWorldTestProducer {

    private Log LOG = LogFactory.getLog(HelloWorldTestProducer.class);


    @PostConstruct
    public void init() {
        LOG.info("test world has been produced");
    }

    @Bean(name = "helloWorld")
    public String produceHelloWorld() {
        return "Hello test world!";
    }

}

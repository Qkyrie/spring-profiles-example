package com.deswaef.spring.examples.profiles;

import com.deswaef.spring.examples.profiles.mvc.GreetController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: Quinten
 * Date: 30-5-2014
 * Time: 09:54
 *
 * @author Quinten De Swaef
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = {ProfileApplication.class})
@IntegrationTest("server.port:0")
public class TestProfileApplicationTest {

    @Autowired
    private GreetController greetController;

    @Test
    public void correctProducerHasBeenDeployed() {
        assertThat(greetController.getHelloWorld()).isEqualTo("Hello test world!");
    }
}

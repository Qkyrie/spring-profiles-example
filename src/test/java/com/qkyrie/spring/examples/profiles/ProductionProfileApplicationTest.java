package com.qkyrie.spring.examples.profiles;

import com.qkyrie.spring.examples.profiles.mvc.GreetController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
@ActiveProfiles("production")
@ContextConfiguration(classes = {ProfileApplication.class})
public class ProductionProfileApplicationTest {

    @Autowired
    private GreetController greetController;

    @Test
    public void correctProducerHasBeenDeployed() {
        assertThat(greetController.getHelloWorld()).isEqualTo("Hello production world!");
    }


}

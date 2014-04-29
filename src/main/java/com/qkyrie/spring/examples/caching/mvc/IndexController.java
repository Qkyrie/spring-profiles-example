package com.qkyrie.spring.examples.caching.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: Quinten
 * Date: 25-4-2014
 * Time: 12:52
 *
 * @author Quinten De Swaef
 */
@Controller
public class IndexController {

    @Qualifier("helloWorld")
    @Autowired
    String helloWorld;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public
    @ResponseBody
    String index() {
        return helloWorld;
    }

}

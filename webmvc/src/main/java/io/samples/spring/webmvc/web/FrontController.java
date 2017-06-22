package io.samples.spring.webmvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

@Controller
public class FrontController {
    @Autowired
    private WebApplicationContext ctx;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String openHomePage() {
        return "home";
    }

    @RequestMapping(value = "/stats", method = RequestMethod.GET)
    @ResponseBody
    public String[] statistics() {
        return ctx.getBeanDefinitionNames();
    }
}

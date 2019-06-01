package org.vision.springrest.test.dummy;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestRestController {

    @RequestMapping("/hello")
    public String getHello(){
        return "Hello World";
    }

    @RequestMapping("/hello/{name}")
    public String getHello(@PathVariable String name){
        return "Hello " + StringUtils.capitalize(name);
    }
}

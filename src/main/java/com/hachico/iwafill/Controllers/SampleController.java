package com.hachico.iwafill.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    //http://localhost:8080/new-hello
    @GetMapping("/new-hello")
    public String helloWorld(){
        return "Hello World";
    }  
}

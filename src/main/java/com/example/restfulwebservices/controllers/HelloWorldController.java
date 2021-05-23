package com.example.restfulwebservices.controllers;

import com.example.restfulwebservices.beans.HelloWorldBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {


    @RequestMapping(method = RequestMethod.GET,path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @RequestMapping(method = RequestMethod.GET,path = "/hello-world-bean/{name}")
    public HelloWorldBean helloWorldBeanWithName(@PathVariable String name){

        return new HelloWorldBean("Hello " +name);
    }

    @RequestMapping(value="/", method = RequestMethod.OPTIONS)
    ResponseEntity<?> collectionOptions()
    {
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.OPTIONS)
                .build();
    }

}

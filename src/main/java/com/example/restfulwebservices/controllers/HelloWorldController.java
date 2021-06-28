package com.example.restfulwebservices.controllers;

import com.example.restfulwebservices.beans.AuthenticationBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {


    @RequestMapping(method = RequestMethod.GET,path = "/basicauth")
    public AuthenticationBean authenticate(){
        return new AuthenticationBean("You are authenticated");
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

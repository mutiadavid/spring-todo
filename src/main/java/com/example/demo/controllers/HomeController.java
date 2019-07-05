package com.example.demo.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "api/home")
@RestController
public class HomeController {
    @RequestMapping(value = "/Hello",method = RequestMethod.GET)
    public String hello(){
        return  "Hello Spring!";
    }
}

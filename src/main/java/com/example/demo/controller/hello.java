package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class hello {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return "hello";
    }


}

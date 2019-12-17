package com.example.getmap.controller;

import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class DemoController {
    @GetMapping("/demo")
    public String demo(@RequestBody String value){
        return value;
    }
}

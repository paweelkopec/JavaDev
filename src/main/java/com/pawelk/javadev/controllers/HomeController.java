package com.pawelk.javadev.controllers;

import com.pawelk.javadev.models.Home;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return "Welcome home ";
    }

    @GetMapping("/home")
    public Home home(@RequestParam(value="user", defaultValue = "Guest") String user){
        return new Home("Hello "+user);
    }

    @RequestMapping("/test")
    public String test(){
        return "test ";
    }

    @RequestMapping("/resource")
    public Map<String,Object> home() {
        Map<String,Object> model = new HashMap<>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }
}

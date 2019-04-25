package com.pawelk.javadev.controllers;

import com.pawelk.javadev.models.Home;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return "Welcome home ";
    }

    @RequestMapping("/home")
    public Home home(@RequestParam(value="user", defaultValue = "Guest") String user){
        return new Home("Hello "+user);
    }
}

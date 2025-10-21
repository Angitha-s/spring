package com.example.website.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class home {

    @GetMapping("/home")
    public String aboutus() {
        return "home";
    }
    @GetMapping("/product")
    public String productlist() {
    	return "product";
    	
    }
    
    @GetMapping("/partials")
    public String navigation() {
        return "index";
    }
}
package com.example.bookstore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class storehome {

    @GetMapping("/home")
    public String aboutus() {
        return "storehome";
    }
    @GetMapping("/books")
    public String productlist() {
    	return "books";
    	
    }
    
    @GetMapping("/partials")
    public String navigation() {
        return "store";
    }
}
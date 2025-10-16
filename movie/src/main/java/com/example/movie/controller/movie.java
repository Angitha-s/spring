package com.example.movie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class movie {
	 @GetMapping("/home")
	    public String home() {
	        return "redirect:/hello";
	 }
	 @GetMapping("/hello")
	    public String hello(Model model) {
	        String message = "Gilli";
	        model.addAttribute("message", message);
	        String hello = "<h1>This an amazing movie in which thalapathy actor Vijay and Trisha acted together.</h1>";
	        model.addAttribute("hello", hello);
	        boolean isLoggedIn = true;
	        model.addAttribute("isLoggedIn", isLoggedIn);
	        return "movie";
	    }
	}
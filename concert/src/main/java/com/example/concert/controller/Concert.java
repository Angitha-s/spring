package com.example.concert.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class Concert {

    @GetMapping("/concert")
    public String showConcertPage() {
        return "concert"; 
    }
}
package com.example.mystudent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class Mystudent {

    @GetMapping("/student")
    public String Student() {
        return "student";
    }
}
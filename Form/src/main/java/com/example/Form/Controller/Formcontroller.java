package com.example.Form.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Formcontroller {
    @GetMapping("/form")
    public String processForm(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "userdetails";
    }
    @GetMapping("/submit")
    public String handleFormSubmission(@RequestParam String name,Model model) {
        model.addAttribute("name", name);
        return "success";
    }
}

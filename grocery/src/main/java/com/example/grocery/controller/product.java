package com.example.grocery.controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.grocery.Models.grocery;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class product{

    @GetMapping("/product")
    public String getProduct(Model model) {
        grocery product = new grocery(101,"sugar",(float) 55.5);
        model.addAttribute("product", product);
        return "product";
    }

    @GetMapping("/products")
    public String getProducts(Model model) {
        List<grocery> products = new ArrayList<>();
        products.add(new grocery(101, "sugar",(float) 55.5));
        products.add(new grocery(102, "salt",(float) 20.0));
        products.add(new grocery(103, "wheat flour",(float) 38.75));
        model.addAttribute("products", products);
        return "products";
    }
}

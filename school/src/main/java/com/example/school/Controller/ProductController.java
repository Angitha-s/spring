package com.example.school.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.data.repository.query.Param;
import com.example.school.Models.Product;
import com.example.school.Repository.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/create")
    public String createAction(Model model) {
        model.addAttribute("message", "Enter The Student Details");
        return "create";
    }

    @PostMapping("/create")
    public String createActionProcess(Product productData, Model model) {
        productRepository.save(productData);
        model.addAttribute("message", "The Student " + productData.getName() + " has been created successfully");
        return "create";
    }

    @GetMapping("/all")
    public String getAllProducts(Model model, @Param("keyword") String keyword) {
        List<Product> products;
        if (keyword != null && !keyword.isEmpty()) {
            products = productRepository. findByNameContaining(keyword);
        } else {
            products = productRepository.findAll();
        }
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable Integer id, Model model) {
        Optional<Product> optionalProductDetails = productRepository.findById(id);
        if (optionalProductDetails.isPresent()) {
            model.addAttribute("productDetails", optionalProductDetails.get());
            return "update";
        }
        return "redirect:/all";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Integer id, Product productData) {
        Optional<Product> optionalProductDetails = productRepository.findById(id);
        if (optionalProductDetails.isPresent()) {
            Product productDetails = optionalProductDetails.get();
            productDetails.setName(productData.getName());
            productDetails.setStudentClass(productData.getStudentClass());
            productDetails.setAge(productData.getAge());
            productRepository.save(productDetails);
        }
        return "redirect:/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id, Model model) {
        Optional<Product> optionalProductDetails = productRepository.findById(id);
        if (optionalProductDetails.isPresent()) {
            model.addAttribute("productDetails", optionalProductDetails.get());
            return "delete";
        }
        return "redirect:/all";     }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productRepository.deleteById(id);
        return "redirect:/all";
    }
}
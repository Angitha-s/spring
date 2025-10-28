package com.example.Mobileshop.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.Mobileshop.Models.ProductModel;
import com.example.Mobileshop.Repository.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/create")
    public String createAction(Model model) {
        model.addAttribute("message", "Enter The Product Details");
        return "create";
    }

    @PostMapping("/create")
    public String createActionProcess(ProductModel productData, Model model) {
        productRepository.save(productData);
        model.addAttribute("message", "The Product " + productData.getName() + " has been created successfully");
        return "create";
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        List<ProductModel> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable Integer id, Model model) {
        Optional<ProductModel> optionalProductDetails = productRepository.findById(id);
        if (optionalProductDetails.isPresent()) {
            model.addAttribute("productDetails", optionalProductDetails.get());
            return "update";
        }
        return "redirect:/all";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Integer id, ProductModel productData) {
        Optional<ProductModel> optionalProductDetails = productRepository.findById(id);
        if (optionalProductDetails.isPresent()) {
            ProductModel productDetails = optionalProductDetails.get();
            productDetails.setName(productData.getName());
            productDetails.setDescription(productData.getDescription());
            productDetails.setPrice(productData.getPrice());
            productRepository.save(productDetails);
        }
        return "redirect:/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id, Model model) {
        Optional<ProductModel> optionalProductDetails = productRepository.findById(id);
        if (optionalProductDetails.isPresent()) {
            model.addAttribute("productDetails", optionalProductDetails.get());
            return "delete";
        }
        return "redirect:/all";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productRepository.deleteById(id);
        return "redirect:/all";
    }
}
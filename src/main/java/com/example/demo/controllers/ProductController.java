package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    private final ProductRepository productRepository;
    @Autowired
    public ProductController(ProductRepository productRepository){
       this.productRepository = productRepository;
    }
    @GetMapping("/product/{productName}")
    public String getProductPage(@PathVariable String productName, Model model) {
        List<Product> products = productRepository.search(productName);
        if (!products.isEmpty()) {
            Product product = products.get(0); // Assuming there's only one product with the given name
            model.addAttribute("product", product);
            return "product";
        } else {
            return "product-not-found"; // Handle product not found
        }
    }

    @PostMapping("/purchase")
    public String purchaseProduct(@ModelAttribute Product product, Model model) {
        // Check inventory and perform the purchase logic
        if (product.getInv() > 0) {
            // Reduce the inventory
            product.setInv(product.getInv() - 1);
            productRepository.save(product);
            return "purchase-confirmation"; // Redirect to a confirmation page
        } else {
            return "purchase-failure"; // Redirect to a "purchase failure" page
        }
    }
}
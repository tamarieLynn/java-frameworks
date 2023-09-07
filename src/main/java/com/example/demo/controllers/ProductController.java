package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/buyProduct")
    public String buyProduct(
            @RequestParam("productId") Long productId,
            Model model
    ) {
        // Retrieve the product by its ID from the database
        Product product = productRepository.findById(productId).orElse(null);

        if (product != null && product.getInv() > 0) {
            // Perform purchase logic, update inventory, etc.
            // Redirect to a purchase confirmation page
            product.setInv(product.getInv()- 1);
            productRepository.save(product);
            return "purchase-confirmation";
        } else {
            // Redirect to a purchase failure page
            return "purchase-failure";
        }
    }
}
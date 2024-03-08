package com.project.productservice.controllers;

import com.project.productservice.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping()
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        return new Product();
    }
}
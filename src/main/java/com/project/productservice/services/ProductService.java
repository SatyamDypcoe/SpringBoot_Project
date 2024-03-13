package com.project.productservice.services;

import com.project.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long id);


    Product addNewProduct(Product product);

    List<Product> getAllProducts();
}

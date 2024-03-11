package com.project.productservice.services;

import com.project.productservice.models.Product;

public interface ProductService {

    Product getSingleProduct(Long id);


    Product addNewProduct(Product product);
}

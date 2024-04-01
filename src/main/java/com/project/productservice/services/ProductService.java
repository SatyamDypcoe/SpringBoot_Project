package com.project.productservice.services;

import com.project.productservice.exceptions.ProductNotExistsException;
import com.project.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long id) throws ProductNotExistsException;


    Product addNewProduct(Product product);

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product);

    Product replaceProduct(Long id, Product product);


    boolean deleteProduct(Long id);
}

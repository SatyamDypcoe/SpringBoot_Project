package com.project.productservice.services;

import com.project.productservice.exceptions.ProductNotExistsException;
import com.project.productservice.models.Category;
import com.project.productservice.models.Product;
import com.project.productservice.repositories.CategoryRepository;
import com.project.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")

public class SelfProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository){

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException {
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isEmpty()){
            throw new ProductNotExistsException("Product with id " + id + " doesn't exist.");
        }

        Product product = productOptional.get();
        return product;
    }

    @Override
    public Product addNewProduct(Product product) {

        Category category = product.getCategory();
        if(category.getId() == null){
            Category savedCategory = categoryRepository.save(category);
            product.setCategory(savedCategory);
        }
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()) throw new RuntimeException();

         Product savedProduct = productOptional.get();

         if(product.getTitle() != null){
             savedProduct.setTitle(product.getTitle());
         }
         if (product.getDescription() != null){
             savedProduct.setDescription(product.getDescription());
         }
         if(product.getPrice() != null){
            savedProduct.setPrice(product.getPrice());
         }
         if(product.getImageUrl() != null){
             savedProduct.setImageUrl(product.getImageUrl());
         }
        return productRepository.save(savedProduct);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }
}

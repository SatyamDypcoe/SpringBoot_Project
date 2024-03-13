package com.project.productservice.services;

import com.project.productservice.dtos.FakeStoreProductDto;
import com.project.productservice.models.Category;
import com.project.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProduct){
        Product product = new Product();
        product.setTitle(fakeStoreProduct.getTitle());
        product.setId(fakeStoreProduct.getId());
        product.setPrice(fakeStoreProduct.getPrice());
        product.setDescription(fakeStoreProduct.getDescription());
        product.setImageUrl(fakeStoreProduct.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProduct.getCategory());

        return product;
    }
    @Override
    public Product getSingleProduct(Long id){
        FakeStoreProductDto productDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class
                );
        return convertFakeStoreProductToProduct(productDto);
    }

    @Override
    public Product addNewProduct(Product product){
        FakeStoreProductDto productDto = restTemplate.postForObject(
                "https://fakestoreapi.com/products",product,
                 FakeStoreProductDto.class
        );
        return convertFakeStoreProductToProduct(productDto);
    }

    @Override
    public List<Product> getAllProducts(){
        FakeStoreProductDto[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );
        List<Product> ans = new ArrayList<>();
        for(FakeStoreProductDto dto : response){
            ans.add(convertFakeStoreProductToProduct(dto));
        }
        return ans;
    }
}

package com.project.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String tittle;
    private double price;
    private Category category;
    private String description;
    private String imageUrl;
}

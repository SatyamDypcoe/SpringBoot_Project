package com.project.productservice.exceptions;

public class ProductNotExistsException extends Exception{

    public ProductNotExistsException(String message){
        super(message);
    }
}

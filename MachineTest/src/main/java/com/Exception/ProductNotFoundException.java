package com.Exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String msg) {
        super(msg);
        System.out.println("ProductNotFoundException occurs :: " + msg);
    }
}

package com.example.mvcproducts.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Cart {
    public List<Product> cartProducts =new ArrayList<>();

    public void addProducts(Product p){
        cartProducts.add(p);
    }

    public List<Product> getProducts(){
        return cartProducts;
    }

}

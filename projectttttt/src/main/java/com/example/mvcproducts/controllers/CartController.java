package com.example.mvcproducts.controllers;

import com.example.mvcproducts.domain.Cart;
import com.example.mvcproducts.domain.Product;
import com.example.mvcproducts.domain.User;
import com.example.mvcproducts.services.ProductService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SessionAttributes("cart")
@Controller
@RequestMapping("/cart")
public class CartController {
    private final ProductService productService;

    public CartController(ProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("cart")
    public Cart cart() {
        return new Cart();
    }
    @GetMapping("/add")
    public String addToCart(@RequestParam Long pid, @ModelAttribute("cart") Cart cart){
        List<Product> prod =new ArrayList<>(productService.findAll());
        for (Product p:
             prod) {
            if (p.getId()==pid)
                cart.addProducts(p);
        }
        return "redirect:/products";
    }

    @GetMapping
    public String seeCart(Authentication authentication) {
        //User user = (User) authentication.getPrincipal();
        return "cart";
    }
}

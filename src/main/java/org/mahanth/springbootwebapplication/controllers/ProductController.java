package org.mahanth.springbootwebapplication.controllers;

import org.mahanth.springbootwebapplication.model.Product;
import org.mahanth.springbootwebapplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

//    @RequestMapping("/getProducts")
    @GetMapping("/getProducts")
    public List<Product> getProducts(){

        return productService.getProductList();
    }

//    @RequestMapping("/getProduct/{id}")
    @GetMapping("/getProduct/{id}")
    public Product getProductById(@PathVariable int id){

        return productService.getProductById(id);
    }

    @PostMapping("/addProducts")
    public String addProduct(@RequestBody Product product){

        return productService.addProduct(product);
    }
}

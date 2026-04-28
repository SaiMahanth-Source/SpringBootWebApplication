package org.mahanth.springbootwebapplication.controllers;

import org.mahanth.springbootwebapplication.model.Product;
import org.mahanth.springbootwebapplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/getProducts")
    public List<Product> getProducts(){
        return productService.getProductList();
    }
}

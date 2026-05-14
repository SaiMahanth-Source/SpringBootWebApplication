package org.mahanth.springbootwebapplication.controllers;

import org.mahanth.springbootwebapplication.model.Product;
import org.mahanth.springbootwebapplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

//    @RequestMapping("/getProducts")
    @GetMapping("/getProducts")
    public ResponseEntity<List<Product>> getProducts(){

        return new ResponseEntity<>(productService.getProductList(), HttpStatus.OK);
    }

//    @RequestMapping("/getProduct/{id}")
    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){

        if(productService.getProductById(id) != null){
            return new ResponseEntity(productService.getProductById(id), HttpStatus.FOUND);
        }
        return new ResponseEntity(productService.getProductById(id), HttpStatus.NOT_FOUND);

    }

    @PostMapping("/addProducts")
    public String addProduct(@RequestBody Product product){// @RequestBody annotation is to accept the data from the client

        return productService.addProduct(product);
    }

    @PutMapping("/modifyProducts")
    public String modifyProduct(@RequestBody Product product){

        return productService.modifyProduct(product);
    }

    @DeleteMapping("/removeProduct/{id}")
    public String removeProduct(@PathVariable int id){

        return productService.removeProduct(id);
    }
}

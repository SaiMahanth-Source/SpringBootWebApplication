package org.mahanth.springbootwebapplication.service;

import org.mahanth.springbootwebapplication.model.Product;
import org.mahanth.springbootwebapplication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service // Which ic also a Component but more than that
public class ProductService {

    /*
    Implemented using Spring Data jpa for all the methods without any hard coding
     */

    @Autowired
    ProductRepository productRepository;

    public ProductService() {


    }

    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;
        System.out.println("ProductService Created");
    }

    public List<Product> getProductList() {

        return productRepository.findAll();
    }

    public Product getProductById(int id) {

        return productRepository.findById(id).orElse(null);
    }

    public String addProduct(Product product) {

        productRepository.save(product);
        return "SUCCESS" ;
    }

    public String modifyProduct(Product product) {

        productRepository.save(product);
        return "SUCCESSFULLY PRODUCT UPDATED" ;
    }

    public String removeProduct(int id) {

        productRepository.deleteById(id);
        return "PRODUCT SUCCESSFULLY DELETED";
    }

//    List<Product> productList = new ArrayList<>(Arrays.asList(
//            new Product(1, "iPhone 15", "799.99", "Electronics", "Latest Apple smartphone with A16 chip", 50),
//            new Product(2, "Samsung Galaxy S23", "699.99", "Electronics", "Flagship Android smartphone", 40),
//            new Product(3, "Nike Running Shoes", "120.00", "Footwear", "Lightweight running shoes for daily training", 100),
//            new Product(4, "Wooden Dining Table", "350.00", "Furniture", "Solid wood table for 6 people", 10),
//            new Product(5, "LED Desk Lamp", "25.50", "Home Decor", "Adjustable brightness desk lamp", 75),
//            new Product(6, "Backpack", "45.99", "Accessories", "Water-resistant travel backpack", 60),
//            new Product(7, "Bluetooth Headphones", "89.99", "Electronics", "Noise-cancelling over-ear headphones", 30),
//            new Product(8, "Coffee Maker", "55.00", "Kitchen", "Automatic drip coffee machine", 20),
//            new Product(9, "Notebook Pack", "12.99", "Stationery", "Set of 5 ruled notebooks", 200),
//            new Product(10, "Gaming Mouse", "39.99", "Electronics", "Ergonomic mouse with RGB lighting", 80),
//            new Product(11, "Smart Watch", "149.99", "Electronics", "Fitness tracking smartwatch with heart rate monitor", 35)
//    ));

//    public List<Product> getProductList() {
//
//        return productList;
//    }
//
//    public Product getProductById(int id) {
//
//        /*
//        Using Stream API(Advanced)
//         */
//        return productList.stream()
//                .filter(product -> product.getProductId() == id)
////                .findFirst().get();
//                .findFirst().orElse(null); // To handle the NoSuchElementException
//
//        /*
//        Using enhanced for each loop
//         */
////        Product product = null;
////        if(id > 0){
////            for (Product p : productList) {
////                if(p.getProductId()==id){
////                    product =  p;
////                    break;
////                }
////            }
////        }
////        return product;
//    }

//    public String addProduct(Product product) {
//
//        return productList.add(product)? "SUCCESS" : "FAILURE";
//    }
//
//    public String modifyProduct(Product product) {
//
//        return productList.add(product)? "SUCCESSFULLY PRODUCT UPDATED" : "UNSUCCESSFULLY PRODUCT NOT UPDATED";
//    }
//
//    public String removeProduct(int id) {
//
//        Product product = null ;
//        for(Product p : productList){
//            if(p.getProductId() == id){
//                product = p ;
//            }
//        }
//        return (product != null)? "PRODUCT SUCCESSFULLY DELETED" : "PRODUCT UNSUCCESSFULLY DELETED";
//    }
}



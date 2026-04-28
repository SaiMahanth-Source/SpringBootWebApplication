package org.mahanth.springbootwebapplication.service;

import org.mahanth.springbootwebapplication.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service // Which ic also a Component but more than that
public class ProductService {

    List<Product> productList = Arrays.asList(
            new Product(1, "iPhone 15", "799.99", "Electronics", "Latest Apple smartphone with A16 chip", 50),
            new Product(2, "Samsung Galaxy S23", "699.99", "Electronics", "Flagship Android smartphone", 40),
            new Product(3, "Nike Running Shoes", "120.00", "Footwear", "Lightweight running shoes for daily training", 100),
            new Product(4, "Wooden Dining Table", "350.00", "Furniture", "Solid wood table for 6 people", 10),
            new Product(5, "LED Desk Lamp", "25.50", "Home Decor", "Adjustable brightness desk lamp", 75),
            new Product(6, "Backpack", "45.99", "Accessories", "Water-resistant travel backpack", 60),
            new Product(7, "Bluetooth Headphones", "89.99", "Electronics", "Noise-cancelling over-ear headphones", 30),
            new Product(8, "Coffee Maker", "55.00", "Kitchen", "Automatic drip coffee machine", 20),
            new Product(9, "Notebook Pack", "12.99", "Stationery", "Set of 5 ruled notebooks", 200),
            new Product(10, "Gaming Mouse", "39.99", "Electronics", "Ergonomic mouse with RGB lighting", 80),
            new Product(11, "Smart Watch", "149.99", "Electronics", "Fitness tracking smartwatch with heart rate monitor", 35)
    );

    public List<Product> getProductList(){
        return productList;
    }
}

package org.mahanth.springbootwebapplication.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mahanth.springbootwebapplication.model.Product;
import org.mahanth.springbootwebapplication.repository.ProductRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

//    @Mock
    @InjectMocks
    ProductService productService ;

    @Test
    void sampleTest(){

        System.out.println("sampleTest case");
    }

    @Test
    void addProductShouldAddProductSuccessfully(){

        System.out.println("Adding Product");
        Product product = new Product(1, "iPhone 15", "799.99", "Electronics", "Latest Apple smartphone with A16 chip", 50);

        // Mocking using mockito if we import static then Mockito is not required
        Mockito.when(productRepository.save(product)).thenReturn(product);

        String addedProduct = productService.addProduct(product);

//        System.out.println(addedProduct);
        Assertions.assertNotNull(addedProduct);
        Assertions.assertEquals(addedProduct,"SUCCESS");
        Assertions.assertTrue(addedProduct.equals("SUCCESS"));
        Assertions.assertTrue(product.getProductId() == 1);
        Assertions.assertTrue(product.getProductId() == 11);

        /*
        Using Static import class name is not required
        */
        assertNotNull(addedProduct);
        assertEquals(addedProduct,"SUCCESS");
        assertTrue(addedProduct.equals("SUCCESS"));
        assertTrue(product.getProductId() == 1);
        assertTrue(product.getProductId() == 11);
    }
}

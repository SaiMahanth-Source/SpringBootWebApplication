package org.mahanth.springbootwebapplication.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mahanth.springbootwebapplication.model.Product;
import org.mahanth.springbootwebapplication.repository.ProductRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

//    @Mock
    @InjectMocks
    ProductService productService;

    private static Product product = null ;

    @BeforeAll
    public static void classLevelSetup(){

        System.out.println("This annotation executes only once & class level setup before the test like db connections etc");
        product = new Product(1, "iPhone 15", "799.99", "Electronics", "Latest Apple smartphone with A16 chip", 50);

    }

    @BeforeEach
    public void setup(){

        System.out.println("This annotation is for the setup before each test to tweak the data objects if any");

    }

    @AfterEach
    public void cleanup(){

        System.out.println("This annotation is for executing method after the every test");
    }

    @AfterAll
    public static void destroy(){

        System.out.println("This annotation is for executing the method only once after all test executions");
    }

    @Test
    void sampleTest(){

        System.out.println("sampleTest case");
    }

    @Test
    void addProductShouldAddProductSuccessfully() {

//        System.out.println("Adding Product");
        Product product = new Product(1, "iPhone 15", "799.99", "Electronics", "Latest Apple smartphone with A16 chip", 50);

        // Mocking using mockito if we import static then Mockito is not required
        Mockito.when(productRepository.save(product)).thenReturn(product);

        String addedProduct = productService.addProduct(product);

//        System.out.println(addedProduct);
//        Assertions.assertNotNull(addedProduct);
//        Assertions.assertEquals(addedProduct,"SUCCESS");
//        Assertions.assertTrue(addedProduct.equals("SUCCESS"));
//        Assertions.assertTrue(product.getProductId() == 1);
//        Assertions.assertTrue(product.getProductId() == 11);

        /*
        Using Static import class name is not required
        */
        assertNotNull(addedProduct);
        assertEquals(addedProduct, "SUCCESSFULLY PRODUCT UPDATED");
        assertTrue(addedProduct.equals("SUCCESSFULLY PRODUCT UPDATED"));
        assertTrue(product.getProductId() == 1);

        if (addedProduct.equals("SUCCESSFULLY PRODUCT UPDATED")) {

            System.out.println("Successfully added product successfully");
        }
    }

    @Test // doNothing(), Verify()
    public void removeProductShouldRemoveProductById(){

        Mockito.doNothing().when(productRepository).deleteById(1);
        productService.removeProduct(1);
        Mockito.verify(productRepository, times(1)).deleteById(1);
    }

    @Test
    void testPrivateMethodValidateProduct() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method validateProduct = ProductService.class.getDeclaredMethod("validateProduct", Product.class );

        validateProduct.setAccessible(true);


        Boolean result = (Boolean) validateProduct.invoke(productService, product);
        assertTrue(result);
    }

    @Test
    void testPrivateMethodValidateProductInvalidIfProductIsNull() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method validateProduct = ProductService.class.getDeclaredMethod("validateProduct", Product.class );
        validateProduct.setAccessible(true);

        Product product = null ;

        Boolean result = (Boolean) validateProduct.invoke(productService, (Product) null); // Passing null argument of type product
        assertFalse(result);
    }

    @Test
    void addProductShouldThrowExceptionForInvalidProduct() {

//        System.out.println("Adding Product");
        Product product = new Product(1, "", "799.99", "Electronics", "Latest Apple smartphone with A16 chip", 50);

        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> { // Using lambda expression
            productService.addProduct(product);
        });
        assertEquals("Invalid Product", runtimeException.getMessage());
        Mockito.verify(productRepository, times(0)).save(product);
        Mockito.verify(productRepository, times(0)).save(any(Product.class));
        Mockito.verify(productRepository, never()).save(any(Product.class));
    }
}

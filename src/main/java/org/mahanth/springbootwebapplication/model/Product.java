package org.mahanth.springbootwebapplication.model;

public class Product {

    private Integer productId;
    private String productName;
    private String productPrice;
    private String productCategory;
    private String productDescription;
    private Integer productStock;

    public Product(Integer productId, String productName, String productPrice, String productCategory, String productDescription, Integer productStock) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.productStock = productStock;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public int getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public String getProductPrice() {
        return productPrice;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public String getProductCategory() {
        return productCategory;
    }
    public int getProductStock() {
        return productStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productStock=" + productStock +
                '}';
    }
}


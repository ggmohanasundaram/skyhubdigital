package org.skyhubdigital.com.salestax.products;

/**
 * Created by MohanDivya on 8/31/2016.
 * This Class used to define the properties of various products. The products details can be loaded from Database
 * or Inventory or configuration files and create ProductItems objects with Name, Type, Price and imported flag
 *
 */
public class ProductItems implements Product {


    private ProductTypeEnum productTypeEnum;
    private String productName;
    private Double price;
    private boolean isImported;

    public ProductItems(String productName, ProductTypeEnum productTypeEnum, Double price, boolean isImported )
    {

        this.productName = productName;
        this.productTypeEnum = productTypeEnum;
        this.price = price;
        this.isImported = isImported;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public boolean isImported() {
        return isImported;
    }

    @Override
    public ProductTypeEnum getProductTypeEnum() {
        return productTypeEnum;
    }
}

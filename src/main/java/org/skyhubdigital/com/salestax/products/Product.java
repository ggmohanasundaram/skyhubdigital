package org.skyhubdigital.com.salestax.products;

/**
 * Created by MohanDivya on 8/31/2016.
 *
 * This Interface is used to define product details and the implementation
 * is available in ProductItems.java
 */
public interface Product {

    public ProductTypeEnum getProductTypeEnum();
    public String getProductName();
    public Double getPrice();
    public boolean isImported();

}

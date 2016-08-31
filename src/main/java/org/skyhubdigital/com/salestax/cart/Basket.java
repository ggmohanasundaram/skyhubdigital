package org.skyhubdigital.com.salestax.cart;

import org.skyhubdigital.com.salestax.products.Product;

import java.util.List;

/**
 * Created by MohanDivya on 8/31/2016.
 */
public interface Basket {

    public void addToCart(Product product);
    public List<Product> getAddedProducts();
}

package org.skyhubdigital.com.salestax.cart;

import org.skyhubdigital.com.salestax.products.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MohanDivya on 8/31/2016.
 *
 * ShoppingCart to store  all the shopped Products
 *
 * */
public class ShoppingCart implements Basket {

   private List<Product> productList = new ArrayList<Product>();

    @Override
    public void addToCart(Product product) {
        productList.add(product);
    }

    @Override
    public List<Product> getAddedProducts() {
        return productList;
    }
}

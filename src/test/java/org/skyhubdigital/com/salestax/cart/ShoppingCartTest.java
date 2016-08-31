package org.skyhubdigital.com.salestax.cart;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.skyhubdigital.com.salestax.products.Product;
import org.skyhubdigital.com.salestax.products.ProductItems;
import org.skyhubdigital.com.salestax.products.ProductTypeEnum;

import java.util.List;


/**
 * Created by MohanDivya on 8/31/2016.
 */
public class ShoppingCartTest {

    ShoppingCart shoppingCart = null;
    @Before
    public  void setupShoppingCart(){
         shoppingCart = new ShoppingCart();
    }

    @Test
    public void shouldReturnEmptyList(){
        List<Product> addedProducts = shoppingCart.getAddedProducts();
        assertThat(addedProducts.size(),is(0));
    }

    @Test
    public void shouldReturnProductList(){
        Product product = new ProductItems("someProductName", ProductTypeEnum.Book,0.0,false);
        shoppingCart.addToCart(product);
        shoppingCart.addToCart(product);
        List<Product> addedProducts = shoppingCart.getAddedProducts();
        assertThat(addedProducts.size(),is(2));
    }


}

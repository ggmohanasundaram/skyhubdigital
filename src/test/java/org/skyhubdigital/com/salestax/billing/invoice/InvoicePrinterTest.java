package org.skyhubdigital.com.salestax.billing.invoice;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.skyhubdigital.com.salestax.cart.ShoppingCart;
import org.skyhubdigital.com.salestax.products.Product;
import org.skyhubdigital.com.salestax.products.ProductItems;
import org.skyhubdigital.com.salestax.products.ProductTypeEnum;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by MohanDivya on 8/31/2016.
 */
public class InvoicePrinterTest {

    ShoppingCart shoppingCart = null;
    Invoice invoicePrinter = null;

    @Before
    public  void setupShoppingCart(){
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void shouldReturnEmptyList() throws Exception {
        Product book = new ProductItems("someProductName", ProductTypeEnum.Book,10.0,false);
        Product food = new ProductItems("someProductName", ProductTypeEnum.Food,10.0,false);
        Product otherLocal = new ProductItems("someProductName", ProductTypeEnum.Other,10.0,false);
        Product bookImported = new ProductItems("someProductName", ProductTypeEnum.Book,10.0,true);
        Product foodImported = new ProductItems("someProductName", ProductTypeEnum.Food,10.0,true);
        Product otherImported = new ProductItems("someProductName", ProductTypeEnum.Other,10.0,true);
        shoppingCart.addToCart(book);
        shoppingCart.addToCart(food);
        shoppingCart.addToCart(otherLocal);
        shoppingCart.addToCart(bookImported);
        shoppingCart.addToCart(foodImported);
        shoppingCart.addToCart(otherImported);

        invoicePrinter = new InvoicePrinter(shoppingCart);
        Double calculateTotal =  invoicePrinter.printBill();
        assertThat(calculateTotal, CoreMatchers.is(63.5));
    }

}

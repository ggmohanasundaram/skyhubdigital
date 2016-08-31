package org.skyhubdigital.com.salestax;

import org.skyhubdigital.com.salestax.billing.invoice.Invoice;
import org.skyhubdigital.com.salestax.billing.invoice.InvoicePrinter;
import org.skyhubdigital.com.salestax.cart.Basket;
import org.skyhubdigital.com.salestax.cart.ShoppingCart;
import org.skyhubdigital.com.salestax.products.Product;

/**
 * Created by MohanDivya on 8/31/2016.
 *
 * ShoppingApplication is a sample orchestration class to run the shopping workflow
 * ShopProducts method used to add the selected items in shopping Cart
 * getInvoice method is used to invoke the printBill method for shopped products
 *
 */
public class ShoppingApplication {

    private Basket shoppingCart = new ShoppingCart();
    private Invoice invoice = new InvoicePrinter(shoppingCart);


    public void shopProducts(Product product) {
        shoppingCart.addToCart(product);
    }

    public void getInvoice() throws Exception {
        invoice.printBill();

    }

}

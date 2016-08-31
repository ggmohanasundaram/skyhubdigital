package org.skyhubdigital.com.salestax;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.skyhubdigital.com.salestax.products.Product;
import org.skyhubdigital.com.salestax.products.ProductItems;
import org.skyhubdigital.com.salestax.products.ProductTypeEnum;

/**
 * Created by MohanDivya on 8/31/2016.
 */
public class ShoppingApplicationTest {

    ShoppingApplication shoppingApplication;
    @Before
    public  void setUp(){
        shoppingApplication = new ShoppingApplication();

    }

    @Test
    public void shoppingApplicationTestOne() throws Exception {
        /**
         * 1 book at 12.49
         1 music CD at 14.99
         1 chocolate bar at 0.85
         */
        Product book = new ProductItems("Book", ProductTypeEnum.Book,12.49,false);
        Product cd = new ProductItems("Music CD", ProductTypeEnum.Other,14.99,false);
        Product chocolate = new ProductItems("chocolate bar", ProductTypeEnum.Food,0.85,false);
        shoppingApplication.shopProducts(book);
        shoppingApplication.shopProducts(cd);
        shoppingApplication.shopProducts(chocolate);

        shoppingApplication.getInvoice();

    }

    @Test
    public void shoppingApplicationTestTwo() throws Exception {
        /**
         * 1 imported box of chocolates at 10.00
         1 imported bottle of perfume at 47.50
         */
        Product chocolate = new ProductItems("box of chocolates", ProductTypeEnum.Food,10.0,true);
        Product perfume = new ProductItems("bottle of perfume", ProductTypeEnum.Other,47.50,true);

        shoppingApplication.shopProducts(chocolate);
        shoppingApplication.shopProducts(perfume);

        shoppingApplication.getInvoice();

    }

    @Test
    public void shoppingApplicationTestThree() throws Exception {
        /**
         * 1 imported bottle of perfume at 27.99
         1 bottle of perfume at 18.99
         1 packet of headache pills at 9.75
         1 box of imported chocolates at 11.25
         */
        Product imported_perfume = new ProductItems("bottle of perfume", ProductTypeEnum.Other,27.99,true);
        Product  perfume = new ProductItems("bottle of perfume", ProductTypeEnum.Other,18.99,false);
        Product  headache_pills = new ProductItems("Packet of headache pills", ProductTypeEnum.Medicine,9.75,false);
        Product chocolate = new ProductItems("box of chocolates", ProductTypeEnum.Food,11.25,true);

        shoppingApplication.shopProducts(imported_perfume);
        shoppingApplication.shopProducts(perfume);
        shoppingApplication.shopProducts(headache_pills);
        shoppingApplication.shopProducts(chocolate);

        shoppingApplication.getInvoice();

    }




}

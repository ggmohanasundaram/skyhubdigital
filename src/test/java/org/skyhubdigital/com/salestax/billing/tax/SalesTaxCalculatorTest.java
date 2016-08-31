package org.skyhubdigital.com.salestax.billing.tax;

import org.junit.BeforeClass;
import org.junit.Test;
import org.skyhubdigital.com.salestax.products.Product;
import org.skyhubdigital.com.salestax.products.ProductItems;
import org.skyhubdigital.com.salestax.products.ProductTypeEnum;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by MohanDivya on 8/31/2016.
 */
public class SalesTaxCalculatorTest {

    private static TaxCalculatorImplementation taxCalculatorImplementation;
    @BeforeClass
    public static void setUp(){
        taxCalculatorImplementation = new TaxCalculatorImplementation();

    }
    @Test
    public void shouldNotAddSalesTaxForExemptedItems() throws Exception {
        Product product = new ProductItems("someProductName", ProductTypeEnum.Book, 10.0, true);
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(taxCalculatorImplementation);
        Double calculateTax = salesTaxCalculator.calculateTax(product);
        assertThat(calculateTax,is(10.0));

    }

    @Test
    public void shouldAddSalesTaxForNonExemptedItems() throws Exception {
        Product product = new ProductItems("someProductName", ProductTypeEnum.Other, 504.0, true);
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(taxCalculatorImplementation);
        Double totalPrice = salesTaxCalculator.calculateTax(product);
        assertThat(totalPrice,is(554.4));

    }

    @Test
    public void shouldAddSalesTaxForNonExemptedItemsTestDataTwo() throws Exception {
        Product product = new ProductItems("someProductName", ProductTypeEnum.Other, 14.99, true);
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(taxCalculatorImplementation);
        Double totalPrice = salesTaxCalculator.calculateTax(product);
        assertThat(totalPrice,is(16.49));

    }
}

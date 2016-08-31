package org.skyhubdigital.com.salestax.billing.tax;

import org.hamcrest.CoreMatchers;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.skyhubdigital.com.salestax.products.ProductItems;
import org.skyhubdigital.com.salestax.products.ProductTypeEnum;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by MohanDivya on 8/31/2016.
 */
public class TaxCalculatorImplementationTest {

    private static TaxCalculatorImplementation taxCalculatorImplementation;
    @BeforeClass
    public static void setUp(){
        taxCalculatorImplementation = new TaxCalculatorImplementation();

    }
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void ShouldThrowProperExceptionMessage() throws Exception {
        exception.expect(Exception.class);
        exception.expectMessage(is("Product is Null"));
        taxCalculatorImplementation.calculateTax(null);
    }

    @Test
    public void ShouldReturnProperPrice() throws Exception {

        ProductItems product = new ProductItems("someProductName", ProductTypeEnum.Book, 10.0, true);
        Double actualValue = taxCalculatorImplementation.calculateTax(product);
        assertThat(actualValue,is(10.0));
    }
}

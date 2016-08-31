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
public class ImportTaxCalculatorTest {

    private static TaxCalculatorImplementation taxCalculatorImplementation;
    @BeforeClass
    public static void setUp(){
        taxCalculatorImplementation = new TaxCalculatorImplementation();

    }

    @Test
    public void shouldReturnImportTaxForInputOne() throws Exception {
        Product product = new ProductItems("someProductName", ProductTypeEnum.Book, 10.00, true);
        ImportTaxCalculator importTaxCalculator = new ImportTaxCalculator(taxCalculatorImplementation);
        Double totalPrice = importTaxCalculator.calculateTax(product);
        assertThat(totalPrice,is(10.5));
    }

    @Test
    public void shouldReturnImportTaxForInputTwo() throws Exception {
        Product product = new ProductItems("someProductName", ProductTypeEnum.Book, 47.50, true);
        ImportTaxCalculator importTaxCalculator = new ImportTaxCalculator(taxCalculatorImplementation);
        Double totalPrice = importTaxCalculator.calculateTax(product);
        assertThat(totalPrice,is(49.9));


    }
}

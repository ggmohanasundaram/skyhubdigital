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
public class TaxDecoratorTest {

    private static TaxCalculatorImplementation taxCalculatorImplementation;
    @BeforeClass
    public static void setUp(){
        taxCalculatorImplementation = new TaxCalculatorImplementation();

    }

    @Test
    public void shouldCalculateOnlySalesTax() throws Exception {
        Product product = new ProductItems("someProductName", ProductTypeEnum.Other, 10.0, false);
        TaxDecorator taxDecorator = new SalesTaxCalculator(taxCalculatorImplementation);
        Double calculateTax = taxDecorator.calculateTax(product);
        assertThat(calculateTax,is(11.0));

    }

    @Test
    public void shouldCalculateOnlyImportTax() throws Exception {
        Product product = new ProductItems("someProductName", ProductTypeEnum.Other, 47.5, false);
        TaxDecorator taxDecorator = new ImportTaxCalculator(taxCalculatorImplementation);
        Double calculateTax = taxDecorator.calculateTax(product);
        assertThat(calculateTax,is(49.9));

    }

    @Test
    public void shouldCalculateSalesTaxAndImportTax() throws Exception {
        Product product = new ProductItems("someProductName", ProductTypeEnum.Other, 47.5, false);
        TaxDecorator taxDecorator = new ImportTaxCalculator(new SalesTaxCalculator(taxCalculatorImplementation));
        Double calculateTax = taxDecorator.calculateTax(product);
        assertThat(calculateTax,is(54.65));

    }
}

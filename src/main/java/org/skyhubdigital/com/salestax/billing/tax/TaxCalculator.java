package org.skyhubdigital.com.salestax.billing.tax;

import org.skyhubdigital.com.patterns.exceptions.WrongInputException;
import org.skyhubdigital.com.salestax.products.Product;

/**
 * Created by MohanDivya on 8/31/2016.
 *
 * The SalesTax and Import Tax are implemented using Decorator Pattern.
 * This Interface declares the common Method
 */
public interface TaxCalculator {


    public Double calculateTax(Product product) throws Exception;
    
}

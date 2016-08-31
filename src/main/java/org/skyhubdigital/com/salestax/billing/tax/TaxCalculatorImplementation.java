package org.skyhubdigital.com.salestax.billing.tax;

import org.skyhubdigital.com.patterns.exceptions.WrongInputException;
import org.skyhubdigital.com.salestax.products.Product;

/**
 * Created by MohanDivya on 8/31/2016.
 * TaxCalculatorImplementation is providing default implementation of TaxCalculator
 */
public class TaxCalculatorImplementation  implements TaxCalculator{

    @Override
    public Double calculateTax(Product product) throws Exception {

        if(product!=null){
        return product.getPrice();}
        else {
            throw new WrongInputException("Product is Null");
        }
    }
}

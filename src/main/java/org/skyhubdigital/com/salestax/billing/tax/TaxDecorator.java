package org.skyhubdigital.com.salestax.billing.tax;

/**
 * Created by MohanDivya on 8/31/2016.
 *
 * This is the Abstract Decorator
 * it has TaxCalculator - class which has TaxCalculator reference to wrap the TaxCalculator
 * It is TaxCalculator - It confirms TaxCalculator Interface
 *
 */
public  abstract class TaxDecorator implements TaxCalculator {

    protected TaxCalculator taxCalculator;


    public TaxDecorator(TaxCalculator taxCalculator){

        this.taxCalculator = taxCalculator;
    }

}

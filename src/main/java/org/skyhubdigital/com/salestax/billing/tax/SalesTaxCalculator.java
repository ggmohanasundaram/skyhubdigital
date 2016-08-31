package org.skyhubdigital.com.salestax.billing.tax;

import org.skyhubdigital.com.patterns.exceptions.WrongInputException;
import org.skyhubdigital.com.salestax.billing.BillingUtility;
import org.skyhubdigital.com.salestax.products.Product;

/**
 * Created by MohanDivya on 8/31/2016.
 *
 * SalesTaxCalculator - is an implementation to calculate the Sales tax
 */
public class SalesTaxCalculator extends TaxDecorator {

    private static final Double tax =  10.0;

    public SalesTaxCalculator(TaxCalculator taxCalculator){
        super(taxCalculator);

    }

    /**
     *
     * @param product
     * @return
     * @throws Exception
     *
     * calculateTax method used to calculate the percentage value if the product is Non-Exempted
     */

    @Override
    public Double calculateTax(Product product) throws Exception
    {
        Double basePrice = taxCalculator.calculateTax(product);
        Double salesTax = 0.00;

        if(!product.getProductTypeEnum().isTaxExempted()){
            salesTax = BillingUtility.roundOff(BillingUtility.calculateTax(product.getPrice(),tax));
        }

        basePrice = basePrice + salesTax;

        return Math.round(basePrice*100.0)/100.0;
    }


}

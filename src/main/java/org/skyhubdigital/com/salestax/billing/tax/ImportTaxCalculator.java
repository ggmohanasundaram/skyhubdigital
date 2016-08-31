package org.skyhubdigital.com.salestax.billing.tax;

import org.skyhubdigital.com.salestax.billing.BillingUtility;
import org.skyhubdigital.com.salestax.products.Product;

/**
 * Created by MohanDivya on 8/31/2016.
 *
 * ImportTaxCalculator is used to calculate the import tax
 */
public class ImportTaxCalculator extends TaxDecorator{

    private static final Double tax =  5.0;
    public ImportTaxCalculator(TaxCalculator taxCalculator){
        super(taxCalculator);

    }

    /**
     *
     * @param product
     * @return
     * @throws Exception
     *
     * calculateTax method invokes it's reference calculate tax and accumulate the import tax
     * with the base Tax
     */
    @Override
    public Double calculateTax(Product product) throws Exception {
        Double price = taxCalculator.calculateTax(product);
        Double importTax = 0.00;
        importTax = BillingUtility.roundOff(BillingUtility.calculateTax(product.getPrice(),tax));
        price += importTax;
        return Math.round(price*100.0)/100.0;

    }


}

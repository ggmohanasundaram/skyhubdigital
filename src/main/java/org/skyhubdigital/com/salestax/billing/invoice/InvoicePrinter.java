package org.skyhubdigital.com.salestax.billing.invoice;

import org.skyhubdigital.com.patterns.exceptions.WrongInputException;
import org.skyhubdigital.com.salestax.billing.tax.ImportTaxCalculator;
import org.skyhubdigital.com.salestax.billing.tax.SalesTaxCalculator;
import org.skyhubdigital.com.salestax.billing.tax.TaxCalculator;
import org.skyhubdigital.com.salestax.billing.tax.TaxCalculatorImplementation;
import org.skyhubdigital.com.salestax.cart.Basket;
import org.skyhubdigital.com.salestax.products.BilledProductItems;
import org.skyhubdigital.com.salestax.products.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MohanDivya on 8/31/2016.
 */
public class InvoicePrinter implements Invoice{

   private static final String format = "%s %s %s\n";

    private Basket shoppingCart;
    private TaxCalculator taxCalculator;
    private List<BilledProductItems> billedProductItems = new ArrayList<BilledProductItems>();




    public InvoicePrinter(Basket shoppingCart){

        this.shoppingCart = shoppingCart;
    }

    /**
     * printBill Method  calls calculateTotal to populate the tax value and prints the bill with
     *
     *  For Each product -Product Name + Price ( inclusive of Tax)
     *  Total Amount
     *  Total Service Tax
     */
    @Override
    public Double printBill() throws Exception {
        Double totalPrice = calculateTotal();

        Double originalPrice = 0.00;
        for (BilledProductItems billedProductItem : billedProductItems) {

            originalPrice = originalPrice + billedProductItem.getPrice();
            System.out.format(format,  billedProductItem.isImported() ? "1 Imported" : "1", billedProductItem.getProductName(), billedProductItem.getTaxedPrice());
        }

        Double salesTax = Math.round((totalPrice - originalPrice)*100.0)/100.0;
        System.out.println(String.format("%s %s","SalesTaxes :", salesTax));
        System.out.println(String.format("%s %s","Total :",totalPrice));

        return totalPrice;
    }

    /**
     *
     * calculateTotal method used to define the decorator pattern based on Product attribute - isImported
     *
     * For Imported Products - TaxDecorator will be configured with ImportTaxCalculator & SalesTaxCalculator
     * For non-Imported Products -TaxDecorator will be configured SalesTaxCalculator
     *
     *
     */
    private Double calculateTotal() throws Exception {

            List<Product> products = shoppingCart.getAddedProducts();
            Double total = 0.0;
        for (Product product : products) {
            Double calculateTax = 0.0;
                try {
                    if (product.isImported()) {

                        taxCalculator = new ImportTaxCalculator(new SalesTaxCalculator(new TaxCalculatorImplementation()));
                    }else {
                        taxCalculator = new SalesTaxCalculator(new TaxCalculatorImplementation());
                    }
                        calculateTax = taxCalculator.calculateTax(product);

                    billedProductItems.add(new BilledProductItems(product,calculateTax));
                    total+= calculateTax;


                }catch (Exception e){
                    throw new WrongInputException("Please check the Product Details and Price"+product.getProductName());

            }
        }
        return total;
    }
}

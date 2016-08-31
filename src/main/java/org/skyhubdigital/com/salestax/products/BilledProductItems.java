package org.skyhubdigital.com.salestax.products;

/**
 * Created by MohanDivya on 8/31/2016.
 *
 * This sub class of ProductItems is used to stored the calculated tax price
 */
public class BilledProductItems extends ProductItems {

    private Double taxedPrice;

    public BilledProductItems(Product product, Double taxedPrice) {

         super(product.getProductName(), product.getProductTypeEnum(), product.getPrice(), product.isImported());

        this.taxedPrice = taxedPrice;
    }

    public Double getTaxedPrice() {
        return taxedPrice;
    }
}

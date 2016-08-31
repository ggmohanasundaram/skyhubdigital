package org.skyhubdigital.com.salestax.products;

/**
 * Created by MohanDivya on 8/31/2016.
 *
 *  This Enumeration is used to configure ProductType and whether it is exempted from Tax or Not
 *
 *  Example -
 *  ProductType(True) - is Tax exempted - Like Books, Medicine, Food
 *  ProductType(false) - is Tax non-exempted - Other
 *
 */
public enum ProductTypeEnum {
    Book(true),
    Medicine(true),
    Food(true),
    Other(false);

    private boolean isTaxExempted;

    ProductTypeEnum(boolean isTaxExempted) {

        this.isTaxExempted = isTaxExempted;
    }

    public boolean isTaxExempted(){
        return isTaxExempted;
    }
}

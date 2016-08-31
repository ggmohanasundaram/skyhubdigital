package org.skyhubdigital.com.salestax.products;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by MohanDivya on 8/31/2016.
 */
public class ProductTypeEnumTest {

    @Test
    public void shouldReturnProperExemptionResult() {

        assertTrue(ProductTypeEnum.Book.isTaxExempted());
        assertTrue(ProductTypeEnum.Medicine.isTaxExempted());
        assertTrue(ProductTypeEnum.Food.isTaxExempted());
        assertFalse(ProductTypeEnum.Other.isTaxExempted());




    }
}

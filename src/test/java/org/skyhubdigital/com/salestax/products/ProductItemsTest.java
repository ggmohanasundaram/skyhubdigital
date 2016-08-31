package org.skyhubdigital.com.salestax.products;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by MohanDivya on 8/31/2016.
 */
public class ProductItemsTest {

    @Test
    public void shouldReturnProperValues(){

        Product product = new ProductItems("someProductName", ProductTypeEnum.Book,10.0,true);
        assertThat(product.getProductName(),is("someProductName"));
        assertThat(product.getProductTypeEnum(),is(ProductTypeEnum.Book));
        assertThat(product.getPrice(),is(10.0));
        assertTrue(product.isImported());

    }
}

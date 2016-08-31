package org.skyhubdigital.com.salestax.billing;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.skyhubdigital.com.patterns.exceptions.WrongInputException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by MohanDivya on 8/31/2016.
 */
public final class BillingUtilityTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldReturnProperPercentageValueForInputOne() throws WrongInputException {

        Double actualValue = BillingUtility.calculateTax(100.0, 10.0);

        assertThat(actualValue,is(10.0));


    }

    @Test
    public void shouldReturnProperPercentageValueForInputTwo() throws WrongInputException {

        Double actualValue = BillingUtility.calculateTax(1000.39, 1.0);

        assertThat(actualValue,is(10.0039));


    }

    @Test
    public void shouldReturnProperRoundOfValueForInputOne() throws WrongInputException {

        Double roundOff = BillingUtility.roundOff(23.19);
        assertThat(roundOff,is(23.2));
    }
    @Test
    public void shouldReturnProperRoundOfValueForInputTwo() throws WrongInputException {

        Double roundOff = BillingUtility.roundOff(14.13);
        assertThat(roundOff,is(14.15));
    }
    @Test
    public void shouldReturnProperRoundOfValueForInputThree() throws WrongInputException {

        Double roundOff = BillingUtility.roundOff(24.16);
        assertThat(roundOff,is(24.15));
    }
    @Test
    public void shouldReturnProperRoundOfValueForInputFour() throws WrongInputException {

        Double roundOff = BillingUtility.roundOff(100.05);
        assertThat(roundOff,is(100.05));
    }
    @Test
    public void shouldReturnProperRoundOfValueForInputFive() throws WrongInputException {

        Double roundOff = BillingUtility.roundOff(100.30);
        assertThat(roundOff,is(100.30));
    }

    @Test
    public void shouldReturnProperPercentageValueForInputThree() throws WrongInputException {

        Double actualValue = BillingUtility.calculateTax(1000.39, 0.0);

        assertThat(actualValue,is(0.0));


    }

    @Test
    public void shouldReturnProperExceptionForNull() throws WrongInputException {

        exception.expect(Exception.class);
        exception.expectMessage(CoreMatchers.is("Please Provide Proper Input"));
        BillingUtility.calculateTax(null, null);

    }
}

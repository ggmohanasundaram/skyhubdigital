package org.skyhubdigital.com.salestax.billing;

import org.skyhubdigital.com.patterns.exceptions.WrongInputException;

/**
 * Created by MohanDivya on 8/31/2016.
 *
 *
 */
public final  class BillingUtility {
    /**
     *
     * @param price
     * @param percentage
     * @return
     * @throws WrongInputException
     * This static method used to calculate the percentage Value
     */

    public static Double calculateTax(Double price,Double percentage) throws WrongInputException {

        Double actualTax = 0.0;
        try {
            if (price != null && percentage != null) {

                actualTax = (price * percentage) / 100;
            }
            else {
                throw new WrongInputException("Please Provide Proper Input");
            }
        }catch (Exception e){
            throw new WrongInputException("Please Provide Proper Input");
        }

        return actualTax;
    }

    /**
     *
     * @param price
     * @return
     * @throws WrongInputException
     *
     * This roundoff method is used to rounded up the value txo the nearest 0.05
     */

    public static Double roundOff(Double price) throws WrongInputException {

        Double roundOffValue = 0.0;
        try {
            if (price != null ) {

                roundOffValue = (double) Math.round(price * 20) / 20.0;

            }
            else {
                throw new WrongInputException("Please Provide Proper Input");
            }
        }catch (Exception e){
            throw new WrongInputException("Please Provide Proper Input");
        }

        return roundOffValue;
    }
}

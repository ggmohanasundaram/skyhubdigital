package org.skyhubdigital.com.patterns.exceptions;

/**
 * Created by MohanDivya on 8/30/2016.
 *
 * UserDefined Exception for Wrong Inputs
 */
public class WrongInputException extends Exception{

   public WrongInputException(String message){
       super(message);
   }

}

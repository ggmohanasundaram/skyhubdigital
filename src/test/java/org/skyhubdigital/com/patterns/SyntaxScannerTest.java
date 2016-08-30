package org.skyhubdigital.com.patterns;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.rules.ExpectedException;

/**
 * Created by MohanDivya on 8/30/2016.
 */
public class SyntaxScannerTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

   @Test
    public void shouldThrowExceptionMessageForNullInput() throws Exception {

        exception.expect(Exception.class);
        exception.expectMessage(is("Input is Null"));
        SyntaxScanner.isBalancedString(null);
    }

    @Test
    public void shouldReturnTrueForValidPatternsWithoutBrackets() throws Exception {

        String input = "Unit Test";
       assertTrue(SyntaxScanner.isBalancedString(input));
    }

    @Test
    public void shouldReturnTrueForEmptyString() throws Exception {

        String input = "";
        assertTrue(SyntaxScanner.isBalancedString(input));
    }

    @Test
    public void shouldReturnTrueForValidPatternOne() throws Exception {

        String input = "{ [ ] ( ) }";
        assertTrue(SyntaxScanner.isBalancedString(input));
    }

    @Test
    public void shouldReturnTrueForValidPatternTwoWithAdditionalValues() throws Exception {

        String input = "{ Unit Test }";
        assertTrue(SyntaxScanner.isBalancedString(input));
    }

    @Test
    public void shouldReturnTrueForValidPatternThreeWithAdditionalValues() throws Exception {

        String input = "{ Unit ( Test ) }";
        assertTrue(SyntaxScanner.isBalancedString(input));
    }

    @Test
    public void shouldReturnFalseForInValidPatternOne() throws Exception {

        String input = "{ [ ( ] ) }";
        assertFalse(SyntaxScanner.isBalancedString(input));
    }

    @Test
    public void shouldReturnFalseForInValidPatternTwo() throws Exception {

        String input = "{ [ }";
        assertFalse(SyntaxScanner.isBalancedString(input));
    }

    @Test
    public void shouldReturnFalseForValidPatternFourWithAdditionalValues() throws Exception {

        String input = "{ Unit (  [ Test  ) }";
        assertFalse(SyntaxScanner.isBalancedString(input));
    }

}

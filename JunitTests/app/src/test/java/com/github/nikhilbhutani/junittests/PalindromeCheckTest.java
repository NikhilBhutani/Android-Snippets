package com.github.nikhilbhutani.junittests;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Nikhil Bhutani on 9/4/2016.
 */
public class PalindromeCheckTest{
   private PalindromeCheck palindromeCheck;

    @Before
    public void setUp() throws Exception {

        palindromeCheck = new PalindromeCheck();

    }

    @Test
    public void checker() throws Exception{

        PalindromeCheck palindromeCheck = new PalindromeCheck();
        boolean result = palindromeCheck.checker("MOM");
        assertEquals(true, result);

    }

}

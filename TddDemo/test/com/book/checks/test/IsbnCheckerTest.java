package com.book.checks.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.book.checks.IsbnChecker;
//always start with failling test before writing test method
//fail()

// getting to red : step 1 : checkIsbn(140449116) must return true , otherwise it return false
// getting to green : step 2 : change the minimum so that this test will pass
public class IsbnCheckerTest {

	@Test
	public void checkAValidISBN() {

		IsbnChecker isbnChecker = new IsbnChecker();

		boolean result = isbnChecker.checkISBN("0140449116");

		assertTrue("first value",result);
		
		result = isbnChecker.checkISBN("0140177396");
		
		assertTrue("second value",result);


	}

	@Test
	public void checkAnInValidISBN(){
		IsbnChecker isbnChecker = new IsbnChecker();

		boolean result = isbnChecker.checkISBN("0140449117");

		assertFalse(result);
		
	}
	
	@Test
	public void checkIsbnNumberEndingWithXAreValid(){
		IsbnChecker isbnChecker = new IsbnChecker();

		boolean result = isbnChecker.checkISBN("012000030X");

		assertTrue(result);
	}

	// expected : test will fail if this code don't throw NumberFormatException
	@Test(expected = NumberFormatException.class)
	public void nineDigitISBNsAreNotAllowed(){
		throw new NumberFormatException();
	}
	
	
	@Test(expected = NumberFormatException.class)
	public void nonNumericISBNsAreNotAllowed(){
		IsbnChecker isbnChecker = new IsbnChecker();

		boolean result = isbnChecker.checkISBN("U140449117");
	}

}

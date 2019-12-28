package com.book.checks.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.book.checks.IsbnChecker;
//always start with failling test before writing test method
//fail()

// getting to red : step 1 : checkIsbn(140449116) must return true , otherwise it return false
// getting to green : step 2 : change the minimum so that this test will pass

// in test : we don't test methods( test methods must be like the methode tested , no one to one methods)
//	in test : we test funtionnalities or bussiness logic
// test method must have one assert methods
// test method must be consistent , must return the same result at all the execution
public class IsbnCheckerTest {

	/**
	 * how to get the test methods , we simplly ask this questions :
	 * 	1 . what is the logic checked ? ( checkAValidIsbn)
	 *  2.  when is the opposite of this logic  ? ( check a not valid isbn)
	 *  3.  Edge cases ? ( isbn ending with X )
	 *  4. Error condition ? ( when we must throw like exeption)
	 */
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
	
	@Test
	public void checkIsbn13() {
		IsbnChecker isbnChecker = new IsbnChecker();
		boolean result = isbnChecker.checkISBN("9871853260087");
		assertTrue(result);
	}
}

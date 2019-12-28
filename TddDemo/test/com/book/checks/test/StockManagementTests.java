package com.book.checks.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.book.checks.Book;
import com.book.checks.ExternalISBNDataService;
import com.book.checks.StockManager;

import static org.mockito.Mockito.*;

// Test method must not be the same as the method tested , after the first test failure we write the test method
// with the correct input and assert or verify the correct output 
// we have not to write a logic in our test methods

public class StockManagementTests {
	
	ExternalISBNDataService webService;
	ExternalISBNDataService dataBaseService;
	StockManager stock;
	
	
	@Before
	public void setting() {
		webService = mock(ExternalISBNDataService.class);
		dataBaseService = mock(ExternalISBNDataService.class);
		stock = new StockManager();
		stock.setService(webService);
		stock.setDataBaseService(dataBaseService);
	}
	
	@Test
	public void testCanGetACorrectLocatorCode() {
		String isbn = "0140177396";
		
		when(webService.lookup(anyString())).thenReturn(new Book(isbn, "Of Mice and Men", "J. Steinbeck"));
		when(dataBaseService.lookup(anyString())).thenReturn(null);
		
		String localtorCode = stock.getLocatorCode(isbn);
		assertEquals("7396J4", localtorCode);
	}
	
	@Test
	public void dataBaseIsUsedIfDataIsPresent() {
		when(dataBaseService.lookup("0140177396")).thenReturn(new Book("0140177396", "abc", "abc"));

		String isbn = "0140177396";
		String localtorCode = stock.getLocatorCode(isbn);
		
		verify(dataBaseService,times(1)).lookup("0140177396");
		verify(webService,never()).lookup(anyString());
	}
	
	@Test 
	public void webServieIsUsedIfDataIsNotPresent() {
		when(dataBaseService.lookup("0140177396")).thenReturn(null);
		when(webService.lookup("0140177396")).thenReturn(new Book("0140177396", "abc", "abc"));
		
		String isbn = "0140177396";
		String localtorCode = stock.getLocatorCode(isbn);
		
		verify(webService,times(1)).lookup("0140177396");
		verify(dataBaseService,times(1)).lookup("0140177396");
	}
}

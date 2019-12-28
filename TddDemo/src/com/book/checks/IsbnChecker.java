package com.book.checks;

public class IsbnChecker {

	private static final int SHORT_ISBN_MULTIPLIER = 10;
	private static final int LONG_ISBN_MULTIPLIER = 11;
	private static final int SHORT_ISBN_LENGTH = 10;
	private static final int LONG_ISBN_LENGTH = 13;
	
	
	public boolean checkISBN(String isbn) {
		if(isbn.length() == LONG_ISBN_LENGTH) 
			isThisAvalidLongIsbn(isbn);
		
		else if(isbn.length() == SHORT_ISBN_LENGTH)
			return isthisAvalidShortIsbn(isbn);
		
		throw new NumberFormatException("isbn must be 10 or 13 digit lengrh");
		
	}

	private boolean isthisAvalidShortIsbn(String isbn) {
		int total = 0;
		
		for (int i = 0; i < SHORT_ISBN_LENGTH ; i++){
			if(!Character.isDigit(isbn.charAt(i))){

				if (i == 9 && isbn.charAt(i) == 'X'){
					total +=10;					
				}
				else {
					throw new NumberFormatException("chacters in isbn must be digit");					
				}
			}
			else {
				total += Character.getNumericValue(isbn.charAt(i))*(10-i);				
			}

		}
		
		return (total % SHORT_ISBN_MULTIPLIER == 0);

	}
	
	private boolean isThisAvalidLongIsbn(String isbn) {
		int total = 0;
		
		for (int i = 0; i < LONG_ISBN_LENGTH ; i++){
			if( i % 2 == 0)
				total +=Character.getNumericValue(isbn.charAt(i));
			else
				total += Character.getNumericValue(isbn.charAt(i))*3;
		}
		
		return (total % LONG_ISBN_MULTIPLIER == 0);
	}

}

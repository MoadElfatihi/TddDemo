package com.book.checks;

public class IsbnChecker {

	public boolean checkISBN(String isbn) {
		if(isbn.length() != 10)
			throw new NumberFormatException("isbn must be 10 digit lengrh");
		
		int total = 0;
		
		for (int i = 0; i < 10 ; i++){
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
		
		if(total % 11 == 0)
			return true;
		return false;
	}

}

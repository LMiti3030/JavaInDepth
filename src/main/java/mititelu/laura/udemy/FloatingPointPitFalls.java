package mititelu.laura.udemy;

import java.math.BigDecimal;

public class FloatingPointPitFalls {
	
	public static void main(String[] args) {
		System.out.println(1-0.9); //prints 0.09999999999999998

		System.out.println(0.1+0.2); //prints 0.30000000000000004
		
		//issue because Binary Floating Point format cannot be accurately represented
		//with all languages
		
		
		double price = 1000;
		double discountPercentage = 0.9;
		double discountAmount = price * discountPercentage;
		System.out.println(price - discountAmount); //prints 100.0
		System.out.println(price * (1-discountPercentage)); //prints 99.99999999999997
		
		//SOLUTION: WORK WITH BIG DECIMAL when working with exact numbers
		
		BigDecimal first = new BigDecimal("0.1");
		BigDecimal second = new BigDecimal("0.2");
		System.out.println(first.add(second));
	}

}

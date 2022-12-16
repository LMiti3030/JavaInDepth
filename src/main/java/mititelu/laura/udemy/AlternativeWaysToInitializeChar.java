package mititelu.laura.udemy;

public class AlternativeWaysToInitializeChar {
	
	public static void main(String[] args) {
		char charInt = 65;
		char charHex = 0x0041; //65
		char charBinary = 0b0100_0001; //65
		
		System.out.println(charInt); // -> prints A
		System.out.println(charHex); //prints A
		System.out.println(charBinary); //prints A
		
		
		// char testInt = -15 ; COMPILATION ERROR - range can only be 0-65535  = unsigned int
		
		char testOutside = 65535;
		System.out.println(testOutside); //prints 65
		
		int intChar = 'A';
		System.out.println(intChar); //prints 65
		
		//char variable : unicode escape sequence, char literal, int literal 
	}

}

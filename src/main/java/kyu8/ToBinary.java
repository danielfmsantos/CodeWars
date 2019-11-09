package kyu8;

/**
 * https://www.codewars.com/kata/convert-to-binary/
 * @author Daniel Santos
 *
 */
public class ToBinary {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(toBinary(1));
		System.out.println(toBinary(2));
		System.out.println(toBinary(3));
		System.out.println(toBinary(4));
		System.out.println(toBinary(5));
		System.out.println(toBinary(6));
		System.out.println(toBinary(7));
	}
	
	public static int toBinary(int n) {
		return Integer.parseInt(Integer.toBinaryString(n));
	}

}

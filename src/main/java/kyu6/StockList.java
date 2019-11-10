package kyu6;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/54dc6f5a224c26032800005c
 * @author Daniel Santos
 *
 */
public class StockList {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String art[] = new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
		String cd[] = new String[]{"A", "B"};
		System.out.println(stockSummary(art, cd));

	}

	// 1st parameter is the stocklist (L in example),
	// 2nd parameter is list of categories (M in example)
	public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
		int lstOfArtInd = 0;
		while(lstOfArtInd < lstOfArt.length) {
			String book[] = lstOfArt[lstOfArtInd].split(" ");
			String book1sLetter = Character.toString(book[0].charAt(0));
			if(Arrays.stream(lstOf1stLetter).anyMatch(book1sLetter::equals)) {
				
			}
			lstOfArtInd++;
		}
	}
}
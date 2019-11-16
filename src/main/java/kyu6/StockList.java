package kyu6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://www.codewars.com/kata/54dc6f5a224c26032800005c
 * @author Daniel Santos
 *
 */
public class StockList {
	public static void main(String[] args) {
		
		String art[] = new String[]{"ABAR 200", "CDXE 500", "BKWR -250", "BTSQ 890", "DRTY 600"};
		String cd[] = new String[]{"A", "B", "Z"};
		System.out.println(stockSummary2(art, cd));
	}

	// 1st parameter is the stocklist (L in example),
	// 2nd parameter is list of categories (M in example)
	public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
		if(lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
			return "";
		}
		int lstOfArtInd = 0;
		Map<String, Integer> bookList = new HashMap<String, Integer>();
		for (String letter : lstOf1stLetter) {
			bookList.put(letter, 0);
		}
		while(lstOfArtInd < lstOfArt.length) {
			String book[] = lstOfArt[lstOfArtInd].split(" ");
			String book1sLetter = Character.toString(book[0].charAt(0));
			if(Arrays.stream(lstOf1stLetter).anyMatch(book1sLetter::equals)) {
				int bookValue = Integer.parseInt(book[1]);
				bookList.put(book1sLetter, bookList.get(book1sLetter) + bookValue);
			}
			lstOfArtInd++;
		}
		return bookList.keySet().stream()
			      .map(key -> "(" + key + " : " + bookList.get(key) + ")")
			      .collect(Collectors.joining(" - "));
	}
	
	public static String stockSummary2(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0)
          return "";
        Map<String, Integer> categoryCounts = Arrays.stream(lstOfArt)
                .map(Book::new)
                .collect(Collectors.groupingBy(book -> book.category,
                         Collectors.summingInt(book -> book.quantity)));
        String r = Arrays.stream(lstOf1stLetter)
                .map(initial -> String.format("(%s : %d)", 
                                              initial, categoryCounts.getOrDefault(initial, 0)))
                .collect(Collectors.joining(" - "));
        
        return r;
    }
	
	private static class Book {
        public final String category;
        public final String code;
        public final int quantity;

        public Book(String label) {
            category = label.substring(0,1);
            code = label.split(" ")[0].substring(1);
            quantity = Integer.parseInt(label.split(" ")[1]);
        }
    }
}
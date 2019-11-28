package kyu5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.codewars.com/kata/55c6126177c9441a570000cc
 * @author Daniel Santos
 *
 */
public class WeightSort {

	public static void main(String[] args) {
		//System.out.println(sumNumbersStr("1", 0));
		System.out.println(orderWeight("10 12 13 00 99 100 010"));
	}
	
	public static String orderWeight(String strng) {
		String[] nums = strng.split(" ");
		List<NumberValue> list = Arrays.stream(nums)
				.map(n -> {
					return new NumberValue(n, sumNumbersStr(n, 0));					
				})
				.sorted(Comparator.comparing(NumberValue::getValue)
						.thenComparing(NumberValue::getNum))
				.collect(Collectors.toList());		
		return list.stream().map(n ->n.num).collect(Collectors.joining(" "));
						
	}
	
	private static int sumNumbersStr(String num, int index) {
		return index >= num.length() ? 0 : Character.getNumericValue(num.charAt(index)) + sumNumbersStr(num, index + 1);
	}
	
	private static class NumberValue {
		private final String num;
		private final int value;
		
		public NumberValue(String num, int value) {
			this.num = num;
			this.value = value;
		}
		
		public int getValue() {
			return this.value;
		}
		
		public String getNum() {
			return this.num;
		}
	}
}
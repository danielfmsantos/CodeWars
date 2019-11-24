package kyu5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.codewars.com/kata/55c6126177c9441a570000cc
 * @author Daniel Santos
 *
 */
public class WeightSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(sumNumbersStr("1", 0));
		System.out.println(orderWeight("10 12 13 00 99 100"));
	}
	
	public static String orderWeight(String strng) {
		String[] nums = strng.split(" ");
		List<Number> list = Arrays.stream(nums)
				.map(n -> {
					return new Number(n, sumNumbersStr(n, 0));					
				})
				.sorted(Comparator.comparing(Number::getValue))
				.collect(Collectors.toList());		
		return list.stream().map(n ->n.num).collect(Collectors.joining(" "));
						
	}
	
	private static int sumNumbersStr(String num, int index) {
		return index >= num.length() ? 0 : Character.getNumericValue(num.charAt(index)) + sumNumbersStr(num, index + 1);
	}
	
	private static class Number {
		public final String num;
		public final int value;
		
		public Number(String num, int value) {
			this.num = num;
			this.value = value;
		}
		
		public int getValue() {
			return this.value;
		}
	}
}
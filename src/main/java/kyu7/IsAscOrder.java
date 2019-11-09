package kyu7;

import java.util.stream.IntStream;

/**
 * https://www.codewars.com/kata/are-the-numbers-in-order/
 * @author Daniel Santos
 *
 */
public class IsAscOrder {
	
	public static void main(String[] args) {
		boolean a = isAscOrder(new int[] { 1, 2 });
		System.out.println(a);
		System.out.println(isAscOrder(new int[] { 2, 1 }));
	}
	
	/**
	 * Lambda
	 * @param arr
	 * @return
	 */
	public static boolean isAscOrder(int[] arr) {
		return arr.length == 1 ||
				IntStream.range(0, arr.length - 1).allMatch(x -> arr[x] < arr[x + 1]);
	}
	
	/**
	 * Basic solution
	 * @param arr
	 * @return
	 */
	public static boolean isAscOrder2(int[] arr) {
		
		if(arr.length == 1) {
			return true;
		}
		int ite = 1;
		while(ite < arr.length) {
			if(arr[ite - 1] > arr[ite]) {
				return false;
			}
			ite++;
		}
		return true;
	}

}

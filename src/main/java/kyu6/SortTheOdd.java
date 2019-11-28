package kyu6;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/578aa45ee9fd15ff4600090d/
 * @author Daniel Santos
 *
 */
public class SortTheOdd {
	public static void main(String[] args) {

		int[] a = sortArray(new int[]{ 1, 3, 2, 8, 5, 4 });
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static int[] sortArray(int[] array) {
		 if(array.length <= 0) {
			 return array;
		 }
		 
		 int[] filteredArr = Arrays.stream(array)
				 .filter((a) -> a % 2 != 0)
				 .sorted()
				 .toArray();
		 
		 if(filteredArr.length == 0 || filteredArr.equals(array)) {
			 return array;
		 }
		 
		 int[] evenSorted = new int[array.length];		 
		 int arrayInd = 0, filteredArrInd = 0;
		 while(arrayInd < array.length || filteredArrInd < filteredArr.length) {
			 if(array[arrayInd] % 2 == 0) {
				 // Even number in array
				 evenSorted[arrayInd] = array[arrayInd];
			 } else {
				 // Odd number in array
				 evenSorted[arrayInd] = filteredArr[filteredArrInd];
				 filteredArrInd++;				 
			 }
			 arrayInd++;
		 }
		 return evenSorted;		 
	 }
}

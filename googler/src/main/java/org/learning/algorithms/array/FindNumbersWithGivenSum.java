package org.learning.algorithms.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindNumbersWithGivenSum {

	public static void main(String[] args) {
		int[] arr = { 8, 7, 2, 5, 3, 1 };
		findPairsUsingHashing(arr, 10);
	}

	// Time complexity is O(n^2) and auxiliary space used is O(1).
	public static void findPairs(int[] arr, int sum) {
		for (int i = 0; i < arr.length - 1; i++)
			for (int j = i + 1; j < arr.length; j++)
				if (sum == arr[i] + arr[j])
					System.out.println(arr[i] + " , " + arr[j]);
	}

	// Time complexity is O(nlogn) and auxiliary space used is O(1).
	public static void findPairsUsingSorting(int[] arr, int sum) {
		Arrays.sort(arr);
		int startIndex = 0, endIndex = arr.length - 1;

		while (startIndex < endIndex) {
			if (sum == arr[startIndex] + arr[endIndex])
				System.out.println(arr[startIndex] + " , " + arr[endIndex]);

			if (arr[startIndex] + arr[endIndex] < sum)
				startIndex++;
			else
				endIndex--;
		}
	}

	// Time complexity is O(n) and auxiliary space used is O(1).
	public static void findPairsUsingHashing(int[] arr, int sum) {

		Map<Integer, Integer> mapObj = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (mapObj.containsKey(sum - arr[i]))
				System.out.println(arr[i] + " , " + (sum - arr[i]));
			mapObj.put(arr[i], i);
		}
	}

}

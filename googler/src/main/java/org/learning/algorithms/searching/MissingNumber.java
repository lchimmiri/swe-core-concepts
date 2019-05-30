package org.learning.algorithms.searching;

public class MissingNumber {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 4, 5, 6, 7, 8 };
		System.out.println(findMissingNumUsingXOR(arr));
	}

	// Time Complexity : O(n)
	public static int findMissingNumUsingSumFormula(int[] arr) {
		int sum = 0;
		int length = arr.length;
		for (int i : arr)
			sum += i;

		int total = (length + 1) * (length + 2) / 2;
		return total - sum;
	}

	// Time Complexity : O(n). Even though we have two loops, they are running one after the other.
	public static int findMissingNumUsingXOR(int[] arr) {
		int length = arr.length;
		int x1 = arr[0];
		int x2 = 1;

		for (int i = 1; i < length; i++)
			x1 = x1 ^ arr[i];

		for (int i = 2; i <= (length+1); i++)
			x2 = x2 ^ i;

		return x1 ^ x2;
	}
}

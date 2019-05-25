package org.learning.algorithms;

public class Searching {

	public static void main(String[] args) {

		Integer[] arr = { 2, 3, 4, 10, 40 };

//		int result = linearSearch(arr, 10);

//		int result = binarySearchRecursive(arr, 0, arr.length - 1, 3);

		int result = binarySearchIterative(arr, 0, arr.length - 1, 2);

		if (result >= 0)
			System.out.println("Element found at index : " + result);
		else
			System.out.println("Element doesn't found");
	}

	/**
	 * The time complexity of Binary Search algorithm is O(Log n)
	 */
	public static <T extends Comparable<T>> int binarySearchRecursive(T[] arr, int startIndex, int endIndex,
			T elementToSearch) {

		if (endIndex >= startIndex) {
			int midIndex = startIndex + (endIndex - startIndex) / 2;

			if (arr[midIndex] == elementToSearch)
				return midIndex;

			if (arr[midIndex].compareTo(elementToSearch) >= 0)
				return binarySearchRecursive(arr, startIndex, midIndex - 1, elementToSearch);
			else
				return binarySearchRecursive(arr, midIndex + 1, endIndex, elementToSearch);
		}

		return -1;
	}

	/**
	 * The time complexity of Binary Search algorithm is O(Log n)
	 */
	public static <T extends Comparable<T>> int binarySearchIterative(T[] arr, int startIndex, int endIndex,
			T elementToSearch) {

		while (endIndex >= startIndex) {
			int midIndex = startIndex + (endIndex - startIndex) / 2;

			if (arr[midIndex] == elementToSearch)
				return midIndex;

			if (arr[midIndex].compareTo(elementToSearch) > 0)
				endIndex = midIndex - 1;
			else
				startIndex = midIndex + 1;
		}

		return -1;
	}

	/**
	 * The time complexity of Linear Search algorithm is O(n)
	 */
	public static <T> int linearSearch(T[] arr, T elementToSearch) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(elementToSearch))
				return i;
		}
		return -1;
	}

}

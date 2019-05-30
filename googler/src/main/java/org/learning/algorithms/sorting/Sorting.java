package org.learning.algorithms.sorting;

public class Sorting {

	public static void main(String[] args) {

//		 Integer[] arr = {64,25,12,22,11};
		String[] arr = { "GeeksforGeeks", "Practice.GeeksforGeeks", "GeeksQuiz" };
		selectionSort(arr);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	// Time Complexity: O(n2) as there are two nested loops.
	public static <T extends Comparable<T>> void selectionSort(T[] arr) {
		int length = arr.length;
		for (int i = 0; i < length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < length; j++)
				if (arr[j].compareTo(arr[minIndex]) < 0)
					minIndex = j;

			T temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}

}

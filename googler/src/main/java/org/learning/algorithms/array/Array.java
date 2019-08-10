package org.learning.algorithms.array;

public class Array {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 65, 2, 3, 2, 6, 2, 4, 65, 2, 256, 6, 7, 2, 4 };
		printAllElements(arr);

		insertElementAtIndex(arr, 2, 5);
		printAllElements(arr);

		arr = insertExtraElementAtIndex(arr, 5, -1);
		printAllElements(arr);

		arr = appendElement(arr, 3000);
		printAllElements(arr);
	}

	public static void printAllElements(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void insertElementAtIndex(int[] arr, int startIndex, int targetIndex) {

		int value = arr[startIndex];
		if (startIndex == targetIndex) {
			return;
		} else if (startIndex < targetIndex) {
			for (int i = startIndex + 1; i <= targetIndex; i++)
				arr[i - 1] = arr[i];

			arr[targetIndex] = value;
		} else {
			for (int i = startIndex - 1; i >= targetIndex; i--)
				arr[i + 1] = arr[i];

			arr[targetIndex] = value;
		}
	}

	public static int[] insertExtraElementAtIndex(int[] arr, int index, int value) {
		int[] newArr = new int[arr.length + 1];

		for (int i = 0; i < index; i++)
			newArr[i] = arr[i];

		newArr[index] = value;

		for (int i = index + 1; i < newArr.length; i++)
			newArr[i] = arr[i - 1];

		return newArr;
	}

	public static int[] appendElement(int[] arr, int value) {
		return insertExtraElementAtIndex(arr, arr.length, value);
	}
}

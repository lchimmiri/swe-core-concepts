package org.learning.algorithms.searching;

public class Searching {

	public static void main(String[] args) {

		Integer[] arr = { 2, 3, 4, 10, 40 };

		int sortedPivotedArr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}; 
		
//		int result = linearSearch(arr, 10);

//		int result = binarySearchRecursive(arr, 0, arr.length - 1, 3);

//		int result = binarySearchIterative(arr, 0, arr.length - 1, 2);

		int result = pivotedBinarySearch(sortedPivotedArr, 1);
		
		if (result >= 0)
			System.out.println("Element found at index : " + result);
		else
			System.out.println("Element doesn't found");
	}

	// Time Complexity O(logn)
	public static int pivotedBinarySearch(int[] sortedPivotedArr, int key) {
		int length = sortedPivotedArr.length;
		int pivot = findPivot(sortedPivotedArr, 0, length-1);
		
		if(pivot==-1)
			return binarySearch(sortedPivotedArr, 0, length-1, key);
		
		if(sortedPivotedArr[pivot] == key)
			return pivot;
		
		if(sortedPivotedArr[0] <= key)
			return binarySearch(sortedPivotedArr, 0, pivot-1, key);
		
		return binarySearch(sortedPivotedArr, pivot+1, length-1, key);
			
	}
	
	public static int findPivot(int[] sortedPivotedArr, int low, int high)  {
		if(high <low)
			return -1;
		
		if(high == low)
			return low;
		
		int mid=(low+high)/2;
		if(mid<high && sortedPivotedArr[mid] > sortedPivotedArr[mid+1])
			return mid;
		if(mid>low && sortedPivotedArr[mid]<sortedPivotedArr[mid-1])
			return mid-1;
		if(sortedPivotedArr[low]>=sortedPivotedArr[mid])
			return findPivot(sortedPivotedArr, low, mid-1);
		
		return findPivot(sortedPivotedArr, mid+1, high);
		
	}
	
	/* Non generic recursive Binary Search method */
    static int binarySearch(int arr[], int low, int high, int key) 
    { 
       if (high < low) 
           return -1; 
         
       /* low + (high - low)/2; */       
       int mid = (low + high)/2;   
       if (key == arr[mid]) 
           return mid; 
       if (key > arr[mid]) 
           return binarySearch(arr, (mid + 1), high, key); 
       return binarySearch(arr, low, (mid -1), key); 
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

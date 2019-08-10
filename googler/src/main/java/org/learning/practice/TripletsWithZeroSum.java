package org.learning.practice;

import java.util.HashSet;
import java.util.Set;

public class TripletsWithZeroSum {

	public static void main(String[] args) {

		int arr[] = { 0, -1, 2, -3, 1 };
		findTripletsUsingHashing(arr);

	}

	// Time Complexity : O(n3)
	// Auxiliary Space : O(1)
	public static void findTriplets(int[] arr) {
		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = (i + 1); j < arr.length - 1; j++) {
				for (int k = (j + 1); k < arr.length; k++) {
					if (arr[i] + arr[j] + arr[k] == 0)
						System.out.println("Triplets are :: " + arr[i] + " " + arr[j] + " " + arr[k]);
				}
			}
		}
	}

	public static void findTripletsUsingHashing(int[] arr) {
		Set<Integer> tempSet = new HashSet<Integer>();
		for(int i=0;i<arr.length-1;i++) {
			for(int j=(i+1);j<arr.length;j++) {
				int temp = -(arr[i]+arr[j]);
				if(tempSet.contains(temp))
						System.out.println("Triplets are :: " + arr[i] + " " + arr[j] + " " + temp);
				else 
					tempSet.add(temp);
					
			}
		}
	}

}

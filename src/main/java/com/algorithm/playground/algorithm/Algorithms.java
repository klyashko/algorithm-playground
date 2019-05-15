package com.algorithm.playground.algorithm;

public class Algorithms {

	public static int maxSumSubArray(int[] arr) {
		int max = Integer.MIN_VALUE;
		int curr = 0;
		for (int i : arr) {
			curr = Math.max(i, curr + i);
			max = Math.max(max, curr);
		}
		return max;
	}

}

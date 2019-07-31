package com.algorithm.playground.google.kickstart._2019.d.task3;

import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000051061/0000000000161476
 */
@SuppressWarnings("Duplicates")
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int k = console.nextInt();
				int n = console.nextInt();
				long[] positions = new long[n];
				long[] costs = new long[n];

				for (int i = 0; i < n; i++) {
					positions[i] = console.nextLong();
				}

				for (int i = 0; i < n; i++) {
					costs[i] = console.nextLong();
				}

				long cost = solve(positions, costs, k);
				System.out.println("Case #" + test + ": " + cost);
			}
		}
	}

	private static long solve(long[] positions, long[] costs, int k) {
		long cost = Long.MAX_VALUE;
		int n = costs.length;

		long[] tmp = new long[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j != i) {
					tmp[j] = costs[j] + Math.abs(positions[i] - positions[j]);
				} else {
					tmp[j] = Long.MAX_VALUE;
				}
			}
			cost = Math.min(cost, min(tmp, k) + costs[i]);
		}

		return cost;
	}

	private static long min(long[] arr, int k) {
		min(arr, 0, arr.length, k);
		long sum = 0;
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}
		return sum;
	}

	private static void min(long[] arr, int lo, int hi, int k) {
		int len = hi - lo + 1;
		if (lo < hi && len > k) {
			int i = sort(arr, lo, hi);
			int left = i - lo;
			min(arr, lo, i - 1, k);
			if (left < k) {
				min(arr, i, hi, k - left);
			}
		}
	}

	private static int sort(long[] arr, int lo, int hi) {
		long pivot = arr[lo];
		int i = lo + 1;
		for (int j = lo; j < hi; j++) {
			if (arr[j] < pivot) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i - 1, lo);
		return i;
	}

	private static void swap(long[] arr, int i1, int i2) {
		long tmp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = tmp;
	}

}

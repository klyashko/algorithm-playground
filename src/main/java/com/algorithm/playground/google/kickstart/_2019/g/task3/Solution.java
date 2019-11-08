package com.algorithm.playground.google.kickstart._2019.g.task3;

import com.algorithm.playground.google.utils.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050e02/000000000018fd5e
 */
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int n = console.nextInt();
				long h = console.nextInt();
				long[] a = console.nextLongArray(n);
				long[] b = console.nextLongArray(n);
				long ans = solve(n, h, a, b);
				System.out.println("Case #" + test + ": " + ans);
			}
		}
	}

	private static long solve(int n, long h, long[] a, long[] b) {
		boolean[] aSets = getSets(n, h, a);
		boolean[] bSets = getSets(n, h, b);
		int[] cnts = new int[1 << n];
		for (int i = 0; i < 1 << n; i++) {
			if (aSets[i]) {
				cnts[(1 << n) - i - 1] = 1;
			}
		}
		for (int i = 0; i < n; i++) {
			int mask = (1 << n) - (1 << i) - 1;
			for (int j = mask; ; j = (j - 1) & mask) {
				cnts[j | (1 << i)] += cnts[j];
				if (j == 0) {
					break;
				}
			}
		}
		long ans = 0;
		for (int i = 0; i < 1 << n; i++) {
			if (bSets[i]) {
				ans += cnts[i];
			}
		}
		return ans;
	}

	private static boolean[] getSets(int n, long h, long[] a) {
		boolean[] aSets = new boolean[1 << n];
		long aSum = 0;
		i:
		for (int i = 0; ; i++) {
			if (aSum >= h) {
				aSets[i] = true;
			}
			for (int j = 0; ; j++) {
				if (j == n) {
					break i;
				}
				if ((i & (1 << j)) != 0) {
					aSum -= a[j];
				} else {
					aSum += a[j];
					break;
				}
			}
		}
		return aSets;
	}

}
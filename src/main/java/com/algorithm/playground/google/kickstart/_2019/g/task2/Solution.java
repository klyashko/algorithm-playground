package com.algorithm.playground.google.kickstart._2019.g.task2;

import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050e02/000000000018fe36
 */
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int n = console.nextInt();
				long m = console.nextLong();

				long[] laws = new long[n];
				for (int i = 0; i < n; i++) {
					laws[i] = console.nextLong();
				}
				long ans = solve(m, laws);
				System.out.println("Case #" + test + ": " + ans);
			}
		}

	}

	private static long solve(long m, long[] laws) {
		int[] zeros = new int[60];
		int[] ones = new int[60];
		for (long a : laws) {
			for (int j = 0; j < 60; j++) {
				if ((a & (1L << j)) != 0) {
					ones[j]++;
				} else {
					zeros[j]++;
				}
			}
		}

		for (int i = 0; i < 60; i++) {
			m -= (long) Math.min(zeros[i], ones[i]) << i;
		}

		if (m < 0) {
			return -1;
		}

		long k = 0;
		for (int i = 59; i >= 0; i--) {
			if (ones[i] >= zeros[i]) {
				k |= 1L << i;
			} else if (zeros[i] - ones[i] <= Long.MAX_VALUE >> i && m >= (long) (zeros[i] - ones[i]) << i) {
				m -= (long) (zeros[i] - ones[i]) << i;
				k |= 1L << i;
			}
		}
		return k;
	}

}

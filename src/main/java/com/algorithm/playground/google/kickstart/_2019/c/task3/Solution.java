package com.algorithm.playground.google.kickstart._2019.c.task3;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Comparator.comparingLong;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050ff2/0000000000150a0d
 */
public class Solution {

	private static int COLORS = 1001;

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int N = console.nextInt();
				int K = console.nextInt();

				Dog[] dogs = new Dog[N];
				int[] freq = new int[COLORS];
				for (int i = 0; i < N; i++) {
					dogs[i] = new Dog(console.nextLong());
				}
				for (int i = 0; i < N; i++) {
					dogs[i].color = console.nextInt();
					freq[dogs[i].color]++;
				}

				Arrays.sort(dogs, comparingLong(d -> d.pos));

				long ans = solve(dogs, freq, K);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		}
	}

	private static long solve(Dog[] dogs, int[] freq, int k) {
		long[][] dist = new long[COLORS][];
		int[] ptr = new int[COLORS];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = new long[freq[i] + 1];
			ptr[i] = 1;
		}

		for (Dog dog : dogs) {
			int curr = dog.color;
			dist[curr][ptr[curr]] = dog.pos;
			ptr[curr]++;
		}

		long[][][] dp = new long[COLORS][k + 1][2];
		for (long[][] r : dp) {
			for (long[] rr : r) {
				Arrays.fill(rr, Long.MAX_VALUE);
			}
		}

		dp[0][0][0] = 0;
		dp[0][0][1] = 0;

		for (int i = 1; i < COLORS; i++) {
			for (int j = 0; j <= k; j++) {
				dp[i][j][0] = dp[i - 1][j][0];
				dp[i][j][1] = dp[i - 1][j][1];

				int lim = Math.min(j, freq[i]);
				for (int l = 0; l <= lim; l++) {
					if (dp[i - 1][j - l][1] != Long.MAX_VALUE) {
						dp[i][j][1] = Math.min(dp[i - 1][j - l][1] + 2L * dist[i][l], dp[i][j][1]);
						dp[i][j][0] = Math.min(dp[i - 1][j - l][1] + dist[i][l], dp[i][j][0]);
					}
					if (dp[i - 1][j - l][0] != Long.MAX_VALUE) {
						dp[i][j][0] = Math.min(dp[i - 1][j - l][0] + 2L * dist[i][l], dp[i][j][0]);
					}
				}
			}
		}

		return dp[COLORS - 1][k][0];
	}

	private static class Dog {

		private long pos;
		private int color;

		private Dog(long pos) {
			this.pos = pos;
		}

		@Override
		public String toString() {
			return "Dog{" +
					"pos=" + pos +
					", color=" + color +
					'}';
		}
	}

}

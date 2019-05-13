package com.algorithm.playground.google.kickstart._2019.b.task2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050eda/00000000001198c3
 */
public class Solution {

	private static int[][] cache;

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				Stone[] stones = new Stone[console.nextInt()];
				int wallTime = 0;
				for (int i = 0; i < stones.length; i++) {
					stones[i] = new Stone(console.nextInt(), console.nextInt(), console.nextInt());
					wallTime += stones[i].s;
				}
				cache = new int[wallTime][stones.length];
				for (int[] row : cache) {
					Arrays.fill(row, -1);
				}
				int ans = solve(stones);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		}
	}

	private static int solve(Stone[] stones) {
		Arrays.sort(stones, (s1, s2) -> s1.s * s2.l - s2.s * s1.l);
		return dp(stones, 0, 0);
	}

	private static int dp(Stone[] stones, int time, int i) {
		if (i == stones.length) {
			return 0;
		} else if (cache[time][i] != -1) {
			return cache[time][i];
		} else {
			Stone s = stones[i];
			int energy = Math.max(0, s.e - s.l * time);
			int max;
			if (energy == 0) {
				max = dp(stones, time, i + 1);
			} else {
				max = Math.max(
						dp(stones, time + s.s, i + 1) + energy,
						dp(stones, time, i + 1)
				);
			}
			return cache[time][i] = max;
		}
	}

	private static class Stone {

		private int s, e, l;

		private Stone(int s, int e, int l) {
			this.s = s;
			this.e = e;
			this.l = l;
		}

		@Override
		public String toString() {
			return "Stone{" +
					"s=" + s +
					", e=" + e +
					", l=" + l +
					'}';
		}
	}

}

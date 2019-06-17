package com.algorithm.playground.google.codejam._2019.round3.task2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

import static java.util.Comparator.comparingInt;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051707/00000000001591be
 */
public class Solution {

	private static final long MOD = 1000000007;

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int[][] sizes = new int[console.nextInt()][2];
				long[] prefSum = new long[sizes.length + 1];
				for (int i = 0; i < sizes.length; i++) {
					sizes[i][0] = console.nextInt();
					sizes[i][1] = i;
					prefSum[i + 1] = prefSum[i] + sizes[i][0];
				}
				long ans = solve(sizes, prefSum);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		}
	}

	private static long solve(int[][] sizes, long[] prefSum) {
		Arrays.sort(sizes, comparingInt((int[] a) -> a[0]).reversed());
		TreeSet<Integer> positions = new TreeSet<>();
		long ans = 0;
		for (int[] curr : sizes) {
			Integer next = positions.higher(curr[1]);
			Integer prev = positions.lower(curr[1]);
			if (next != null) {
				long sum = prefSum[next] - prefSum[curr[1] + 1];
				long need = (long) curr[0] * (next - curr[1] - 1) - sum;
				need %= MOD;
				long cntLeft = prev == null ? curr[1] + 1 : curr[1] - prev;
				long cntRight = sizes.length - next;
				ans += cntLeft * cntRight % MOD * need % MOD;
			}
			if (prev != null) {
				long sum = prefSum[curr[1]] - prefSum[prev + 1];
				long need = (long) curr[0] * (curr[1] - prev - 1) - sum;
				need %= MOD;
				long cntLeft = prev + 1;
				long cntRight = next == null ? sizes.length - curr[1] : next - curr[1];
				ans += cntLeft * cntRight % MOD * need % MOD;
			}
			positions.add(curr[1]);
		}
		return ans % MOD;
	}

}

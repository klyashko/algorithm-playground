package com.algorithm.playground.google.codejam._2019.round2.task3;

import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051679/0000000000146184
 */
@SuppressWarnings("Duplicates")
public class Solution {

	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int n = console.nextInt();
				int[] codium = new int[n];
				int[] jamarium = new int[n];
				for (int i = 0; i < n; i++) {
					codium[i] = console.nextInt();
					jamarium[i] = console.nextInt();
				}
				String ans = solve(codium, jamarium);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		}
	}

	private static String solve(int[] codium, int[] jamarium) {
		long minA = 1;
		long minB = INF;
		long maxA = INF;
		long maxB = 1;

		for (int i = 1; i < codium.length; i++) {
			int a = codium[i - 1] - codium[i];
			int b = jamarium[i] - jamarium[i - 1];
			if (a == 0 && b < 0 || b == 0 && a > 0) {
				return "IMPOSSIBLE";
			} else if (a != 0 || b != 0) {
				if (a > 0) {
					if (a * minB > minA * b) {
						minA = a;
						minB = b;
					}
				} else {
					a = -a;
					b = -b;
					if (a * maxB < maxA * b) {
						maxA = a;
						maxB = b;
					}
				}
			}
		}
		if (minA * maxB >= maxA * minB) {
			return "IMPOSSIBLE";
		}
		return calculate(minA, minB, maxA, maxB);
	}

	private static String calculate(long minA, long minB, long maxA, long maxB) {
		long minGcd = gcd(minA, minB);
		minA /= minGcd;
		minB /= minGcd;

		long maxGcd = gcd(maxA, maxB);
		maxA /= maxGcd;
		maxB /= maxGcd;

		if (minB * maxA - minA * maxB == 1) {
			return (minB + maxB) + " " + (minA + maxA);
		}
		for (long x = 1; ; x++) {
			long y = x * minA / minB + 1;
			if (y * maxB < x * maxA) {
				return x + " " + y;
			}
		}
	}

	private static long gcd(long a, long b) {
		while (a > 0) {
			long t = b % a;
			b = a;
			a = t;
		}
		return b;
	}

}

package com.algorithm.playground.google.codejam._2019.round2.task1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051679/0000000000146183
 */
public class Solution {

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
				int ans = solve(codium, jamarium);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		}
	}

	private static int solve(int[] codium, int[] jamarium) {
		Set<Long> set = new HashSet<>();
		for (int i = 0; i < codium.length; i++) {
			for (int j = 0; j < codium.length; j++) {
				int x = codium[i] - codium[j];
				int y = jamarium[i] - jamarium[j];
				if (x > 0 && y < 0) {
					int gcd = gcd(x, -y);
					x /= gcd;
					y /= gcd;
					set.add(x * 2_000_000_000L + y);
				}
			}
		}
		return set.size() + 1;
	}

	private static int gcd(int a, int b) {
		while (a > 0) {
			int t = b % a;
			b = a;
			a = t;
		}
		return b;
	}

}

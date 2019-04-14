package com.algorithm.playground.google.codejam._2019.a.task2;

import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051635/0000000000104f1a
 */
public class Solution {

	private static final int N = 18;
	private static Scanner console;

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			Solution.console = console;
			int tests = console.nextInt();
			//Number of tries
			int n = console.nextInt();
			//Number of gopher
			int m = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int ans = solve(n, m);
				System.out.println(ans);
				if (console.nextInt() == -1) {
					throw new RuntimeException("WA");
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	static int solve(int n, int m) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < N; i++) {
			builder.append("18 ");
		}
		String request = builder.toString().trim();

		int max = 0;
		for (int i = 0; i < n; i++) {
			System.out.println(request);
			int curr = 0;
			for (int j = 0; j < N; j++) {
				curr += console.nextInt();
			}
			max = Math.max(max, curr);
		}
		return max;
	}

}

package com.algorithm.playground.google.codejam._2019.round1.a.task2;

import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051635/0000000000104f1a
 */
public class Solution {

	private static final int N = 18;
	private static final int[] BLADES = {5, 7, 9, 11, 13, 16, 17};
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

	private static int solve(int n, int m) {
		int[] mods = new int[n];
		for (int i = 0; i < n; i++) {
			int curr = BLADES[i % BLADES.length];
			for (int j = 0; j < N; j++) {
				System.out.print(curr);
				System.out.print(' ');
			}
			System.out.println();
			int sum = 0;
			for (int j = 0; j < N; j++) {
				sum += console.nextInt();
			}
			mods[i] = sum % curr;
		}
		int ans = 0;
		for (int i = 1; i <= m && ans == 0; i++) {
			for (int j = 0; j < n; j++) {
				if (i % BLADES[j % BLADES.length] == mods[j]) {
					ans = i;
				} else {
					ans = 0;
					break;
				}
			}
		}
		return ans;
	}

}

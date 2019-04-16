package com.algorithm.playground.google.codejam._2019.a.task2;

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
				int ans = n == 7 ? solveBig(m) : solveSmall();
				System.out.println(ans);
				if (console.nextInt() == -1) {
					throw new RuntimeException("WA");
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static int solveBig(int m) {
		int[] mods = new int[7];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(BLADES[i]);
				System.out.print(' ');
			}
			System.out.println();
			int sum = 0;
			for (int j = 0; j < N; j++) {
				sum += console.nextInt();
			}
			mods[i] = sum % BLADES[i];
		}
		int ans = 0;
		for (int i = 1; i <= m && ans == 0; i++) {
			for (int j = 0; j < BLADES.length; j++) {
				if (i % BLADES[j] == mods[j]) {
					ans = i;
				} else {
					ans = 0;
					break;
				}
			}
		}
		return ans;
	}

	private static int solveSmall() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < N; i++) {
			builder.append("18 ");
		}
		String request = builder.toString().trim();

		int max = 0;
		for (int i = 0; i < 365; i++) {
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

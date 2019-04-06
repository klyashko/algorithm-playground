package com.algorithm.playground.google.codejam._2019.qualification.foregonesolution;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int[][] ans = solve(console.next().trim());
				System.out.print(String.format("Case #%s: ", test));
				print(ans[0]);
				System.out.print(" ");
				print(ans[1]);
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static void print(int[] n) {
		int idx = 0;
		for (; idx < n.length; idx++) {
			if (n[idx] != 0) {
				break;
			}
		}
		for (; idx < n.length; idx++) {
			System.out.print(n[idx]);
		}
	}

	static int[][] solve(String n) {
		int[] a = new int[n.length()];
		int[] b = new int[n.length()];
		for (int i = 0; i < n.length(); i++) {
			char ch = n.charAt(i);
			if (ch == '4') {
				b[i] = 1;
				a[i] = 3;
			} else {
				a[i] = ch - '0';
			}
		}
		return new int[][]{a, b};
	}

}

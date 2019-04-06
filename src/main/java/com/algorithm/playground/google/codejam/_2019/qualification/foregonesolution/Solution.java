package com.algorithm.playground.google.codejam._2019.qualification.foregonesolution;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int[] ans = solve(console.nextInt());
				System.out.println(String.format("Case #%s: %s %s", test, ans[0], ans[1]));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	static int[] solve(int n) {
		String s = Integer.toString(n);
		int start = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '4') {
				start += Math.pow(10, (s.length() - 1 - i));
			}
		}
		for (; start < n - 1; start++) {
			int b = n - start;
			if (notContains4(start) && notContains4(b)) {
				return new int[]{start, b};
			}
		}
		return new int[2];
	}

	private static boolean notContains4(int n) {
		return !Integer.toString(n).contains("4");
	}

}

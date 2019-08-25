package com.algorithm.playground.google.kickstart._2019.e.task3;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int l = console.nextInt();
				int r = console.nextInt();
				int ans = solve(l, r);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static int solve(int l, int r) {
		int count = 0;
		for (int i = l; i <= r; i++) {
			int odd = 0;
			for (int j = 1; j <= i; j += 2) {
				if (i % j == 0) {
					odd++;
				}
			}
			int even = 0;
			for (int j = 2; j <= i; j += 2) {
				if (i % j == 0) {
					even++;
				}
			}
			if (Math.abs(even - odd) <= 2) {
				count++;
			}
		}
		return count;
	}

}

package com.algorithm.playground.google.codejam._2018.qualification.task1;

import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/00000000000000cb/0000000000007966
 */
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int d = console.nextInt();
				String line = console.nextLine().trim();
				int ans = solve(line, d);
				System.out.println(String.format("Case #%s: %s", test, ans == -1 ? "IMPOSSIBLE" : ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	static int solve(String line, int n) {
		StringBuilder builder = new StringBuilder(line);
		int power = 1;
		int damage = 0;
		for (char ch : line.toCharArray()) {
			if (ch == 'C') {
				power <<= 1;
			} else {
				damage += power;
			}
		}
		int idx = line.length();
		int count = 0;
		while (damage > n && idx >= 0) {
			idx = builder.lastIndexOf("C", idx - 1);
			if (idx >= 0) {
				int half = power >> 1;
				for (int i = idx + 1; i < builder.length() && damage > n; i++) {
					if (builder.charAt(i) == 'C') {
						break;
					}
					swap(builder, idx++, i);
					damage -= half;
					count++;
				}
				power = half;
			}

		}
		return damage <= n ? count : -1;
	}

	private static void swap(StringBuilder builder, int i, int j) {
		char ch = builder.charAt(i);
		builder.setCharAt(i, builder.charAt(j));
		builder.setCharAt(j, ch);
	}

}

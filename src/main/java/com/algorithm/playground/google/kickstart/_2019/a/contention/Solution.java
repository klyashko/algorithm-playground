package com.algorithm.playground.google.kickstart._2019.a.contention;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				//number of seats
				int n = console.nextInt();
				//number of intervals
				int q = console.nextInt();
				int[][] intervals = readIntervals(console, new int[q][2]);
				int ans = solve(intervals, n);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	static int solve(int[][] intervals, int n) {
		boolean[] reserved = new boolean[n + 1];
		Set<int[]> rest = new HashSet<>();
		Collections.addAll(rest, intervals);
		int min = Integer.MAX_VALUE;
		while (!rest.isEmpty()) {
			int[] curr = next(reserved, rest);
			rest.remove(curr);
			int sum = 0;
			for (int i = curr[0]; i <= curr[1]; i++) {
				if (!reserved[i]) {
					sum++;
					reserved[i] = true;
				}
			}
			min = Math.min(min, sum);
		}
		return min;
	}

	private static int[] next(boolean[] reserved, Set<int[]> intervals) {
		int[] curr = null;
		int min = Integer.MAX_VALUE;
		for (int[] interval : intervals) {
			int sum = 0;
			for (int i = interval[0]; i <= interval[1]; i++) {
				if (!reserved[i]) {
					sum++;
				}
			}
			if (sum < min) {
				curr = interval;
				min = sum;
			}
			if (min == 0) {
				break;
			}
		}
		return curr;
	}

	private static int[][] readIntervals(Scanner console, int[][] rows) {
		for (int i = 0; i < rows.length; i++) {
			rows[i][0] = console.nextInt();
			rows[i][1] = console.nextInt();
		}
		return rows;
	}

}

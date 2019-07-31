package com.algorithm.playground.google.kickstart._2019.d.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000051061/0000000000161427
 */
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int n = console.nextInt();
				int g = console.nextInt();
				int m = console.nextInt();

				int tmp = m % n;

				Map<Integer, Integer> clockwise = new HashMap<>();
				Map<Integer, Integer> antiClockwise = new HashMap<>();

				int[] parents = new int[g];

				for (int i = 0; i < g; i++) {
					int h = console.nextInt() - 1;
					String d = console.next();
					if ("C".equals(d)) {
						h = (h + tmp) % n;
						Integer parent = clockwise.get(h);
						if (parent == null) {
							clockwise.put(h, i);
							parent = i;

						}
						parents[i] = parent;
					} else {
						h = (h - tmp + n) % n;
						Integer parent = antiClockwise.get(h);
						if (parent == null) {
							antiClockwise.put(h, i);
							parent = i;

						}
						parents[i] = parent;
					}
				}
				int[] counts = solve(clockwise, antiClockwise, n, g, m);
				System.out.print("Case #" + test + ": ");
				for (int i = 0; i < g; i++) {
					System.out.print(counts[parents[i]] + " ");
				}
				System.out.println();
			}
		}
	}

	private static int[] solve(Map<Integer, Integer> clockwise, Map<Integer, Integer> antiClockwise, int n, int g, int m) {
		int[] clockwiseTime = new int[n];
		int[] antiClockwiseTime = new int[n];
		int[] clockwiseOwner = new int[n];
		int[] antiClockwiseOwner = new int[n];

		for (int i = 0; i < n; i++) {
			clockwiseTime[i] = Integer.MIN_VALUE;
			antiClockwiseTime[i] = Integer.MIN_VALUE;
			clockwiseOwner[i] = -1;
			antiClockwiseOwner[i] = -1;
		}

		for (int i = 0; i < n; i++) {
			Integer curr = clockwise.get(i);
			if (curr != null) {
				for (int pos = i, time = m; time >= 0; time--) {
					clockwiseOwner[pos] = curr;
					clockwiseTime[pos] = time;

					pos = (pos - 1 + n) % n;
					if (clockwise.containsKey(pos)) {
						break;
					}
				}
			}
			curr = antiClockwise.get(i);
			if (curr != null) {
				for (int pos = i, time = m; time >= 0; time--) {
					antiClockwiseOwner[pos] = curr;
					antiClockwiseTime[pos] = time;

					pos = (pos + 1) % n;
					if (antiClockwise.containsKey(pos)) {
						break;
					}
				}
			}
		}

		int[] counts = new int[g];

		for (int i = 0; i < n; i++) {
			if (clockwiseOwner[i] != -1 || antiClockwiseOwner[i] != -1) {
				if (clockwiseTime[i] > antiClockwiseTime[i]) {
					counts[clockwiseOwner[i]]++;
				} else if (clockwiseTime[i] < antiClockwiseTime[i]) {
					counts[antiClockwiseOwner[i]]++;
				} else {
					counts[clockwiseOwner[i]]++;
					counts[antiClockwiseOwner[i]]++;
				}
			}
		}

		return counts;
	}

}

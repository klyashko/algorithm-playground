package com.algorithm.playground.google.kickstart._2019.a.contention;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050e01/0000000000069881
 */
@SuppressWarnings("Duplicates")
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
		SegmentTree tree = new SegmentTree(n + 1);
		Set<int[]> rest = new HashSet<>();
		Collections.addAll(rest, intervals);
		int min = Integer.MAX_VALUE;
		while (!rest.isEmpty()) {
			int[] curr = next(tree, rest);
			rest.remove(curr);
			min = Math.min(min, tree.available(curr[0], curr[1]));
			if (min == 0) {
				break;
			}
			for (int i = curr[0]; i <= curr[1]; i++) {
				tree.update(i);
			}
		}
		return min;
	}

	private static int[] next(SegmentTree tree, Set<int[]> intervals) {
		int[] curr = null;
		int min = Integer.MAX_VALUE;
		for (int[] interval : intervals) {
			int sum = tree.available(interval[0], interval[1]);
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

	private static class SegmentTree {

		private final int[] tree;
		private final int n;

		SegmentTree(int n) {
			int size = 1;
			while (size < n) {
				size = size << 1;
			}
			this.n = n;
			this.tree = new int[size << 1];
		}

		int available(int li, int ri) {
			return ri - li + 1 - query(0, n, li, ri, 1);
		}

		void update(int idx) {
			update(0, n, 1, idx);
		}

		private int query(int li, int ri, int from, int to, int idx) {
			if (li > to || ri < from) {
				return 0;
			} else if (li >= from && ri <= to) {
				return tree[idx - 1];
			} else {
				int mid = (ri - li) / 2 + li;
				int left = query(li, mid, from, to, idx * 2);
				int right = query(mid + 1, ri, from, to, idx * 2 + 1);
				return left + right;
			}
		}

		private int update(int li, int ri, int idx, int origin) {
			if (li > origin || ri < origin) {
				return tree[idx - 1];
			} else if (li == origin && ri == origin) {
				tree[idx - 1] = 1;
				return 1;
			} else {
				int mid = (ri - li) / 2 + li;
				int left = update(li, mid, idx * 2, origin);
				int right = update(mid + 1, ri, idx * 2 + 1, origin);
				tree[idx - 1] = left + right;
				return tree[idx - 1];
			}
		}

	}

}

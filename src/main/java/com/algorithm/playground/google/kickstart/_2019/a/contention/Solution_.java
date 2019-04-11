package com.algorithm.playground.google.kickstart._2019.a.contention;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Comparator.comparingInt;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050e01/0000000000069881
 */
@SuppressWarnings("Duplicates")
public class Solution_ {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				//number of seats
				console.nextInt();
				//number of intervals
				int q = console.nextInt();
				int[][] intervals = new int[q][2];
				int max = readIntervals(console, intervals);
				int ans = solve(intervals, max + 2);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	static int solve(int[][] intervals, int max) {
		boolean[] present = new boolean[max];
		int[] points = new int[max];
		for (int[] interval : intervals) {
			present[interval[0]] = true;
			present[interval[1]] = true;
			present[interval[1] + 1] = true;

			points[interval[0]]++;
			points[interval[1] + 1]--;
		}

		int[] indexes = new int[max];
		int[] seats = new int[points.length - 1];
		int[] multipliers = new int[points.length - 1];
		int val = 0;
		int idx = 0;

		int index = 0;

		//noinspection StatementWithEmptyBody
		for (; !present[index]; index++) {}

		while (index < present.length) {
			int prev = index;
			//noinspection StatementWithEmptyBody
			for (index++; index < present.length && !present[index]; index++) { }

			if (index != present.length) {
				val += points[prev];
				seats[idx] = val;
				multipliers[idx] = index - prev;
				indexes[prev] = idx++;
			}
		}

		List<int[]> rest = new ArrayList<>(intervals.length);
		for (int[] interval : intervals) {
			int li = indexes[interval[0]];
			int ri = indexes[interval[1]];
			rest.add(new int[]{li, ri});
		}

		// compare by left increasing then by right deceasing
		rest.sort(comparingInt((int[] a) -> a[0]).thenComparing(comparingInt((int[] a) -> a[1]).reversed()));

		SegmentTree tree = new SegmentTree(seats, multipliers);

		int min = Integer.MAX_VALUE;
		while (!rest.isEmpty()) {
			int[] meta = next(tree, rest);
			int[] curr = rest.get(meta[0]);
			rest.remove(meta[0]);
			min = Math.min(min, meta[1]);
			if (min == 0) {
				break;
			}
			for (int i = curr[0]; i <= curr[1]; i++) {
				tree.decrease(i);
			}
		}
		return min;
	}

	private static int[] next(SegmentTree tree, List<int[]> intervals) {
		int curr = 0;
		int max = Integer.MIN_VALUE;
		int right = -1;
		for (int i = 0; i < intervals.size(); i++) {
			int[] interval = intervals.get(i);
			int left = Math.max(interval[0], right);
			if (left <= interval[1]) {
				int sum = tree.query(left, interval[1]);
				if (sum > max) {
					curr = i;
					max = sum;
				}
				right = interval[1] + 1;
			}
		}
		return new int[]{curr, max};
	}

	private static int readIntervals(Scanner console, int[][] rows) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < rows.length; i++) {
			rows[i][0] = console.nextInt();
			rows[i][1] = console.nextInt();
			max = Math.max(max, rows[i][1]);
		}
		return max;
	}

	private static class SegmentTree {

		private final int[] tree;
		private final int[] values;
		private final int[] multipliers;
		private final int n;

		SegmentTree(int[] values, int[] multipliers) {
			int size = 1;
			while (size < values.length) {
				size = size << 1;
			}
			this.values = values;
			this.multipliers = multipliers;
			this.n = values.length - 1;
			this.tree = new int[size << 1];
			buildTree(values, 1, 0, n);
		}

		int query(int li, int ri) {
			return query(0, n, li, ri, 1);
		}

		void decrease(int idx) {
			values[idx]--;
			if (values[idx] == 1) {
				update(0, n, 1, idx, multipliers[idx]);
			}
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

		private int update(int li, int ri, int idx, int origin, int val) {
			if (li > origin || ri < origin) {
				return tree[idx - 1];
			} else if (li == origin && ri == origin) {
				tree[idx - 1] = val;
				return val;
			} else {
				int mid = (ri - li) / 2 + li;
				int left = update(li, mid, idx * 2, origin, val);
				int right = update(mid + 1, ri, idx * 2 + 1, origin, val);
				tree[idx - 1] = left + right;
				return tree[idx - 1];
			}
		}

		private int buildTree(int[] values, int idx, int from, int to) {
			if (from == to) {
				int val = values[from] == 1 ? multipliers[from] : 0;
				tree[idx - 1] = val;
				return val;
			}
			int mid = (to - from) / 2 + from;
			int left = buildTree(values, idx * 2, from, mid);
			int right = buildTree(values, idx * 2 + 1, mid + 1, to);
			tree[idx - 1] = left + right;
			return tree[idx - 1];
		}

	}

}

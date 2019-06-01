package com.algorithm.playground.google.kickstart._2019.c.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.binarySearch;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050ff2/0000000000150aac
 */
@SuppressWarnings("Duplicates")
public class Solution_ {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				//skip N
				console.nextInt();
				int R = console.nextInt();
				int C = console.nextInt();
				int SR = console.nextInt();
				int SC = console.nextInt();
				String moves = console.next();
				int[] ans = solve(R, C, SR, SC, moves);
				System.out.println(String.format("Case #%s: %s %s", test, ans[0], ans[1]));
			}
		}
	}

	private static int[] solve(int rows, int cols, int sr, int sc, String moves) {
		int r = sr, c = sc;
		IntervalList[] listRows = new IntervalList[rows + 1];
		IntervalList[] listCols = new IntervalList[cols + 1];

		for (int i = 0; i <= rows; i++) {
			listRows[i] = new IntervalList();
		}
		for (int i = 0; i <= cols; i++) {
			listCols[i] = new IntervalList();
		}

		listRows[r].insert(c);
		listCols[c].insert(r);

		for (int i = 0; i < moves.length(); i++) {
			char ch = moves.charAt(i);
			switch (ch) {
				case 'W': {
					c--;
					IntervalList.Interval n = listRows[r].get(c);
					if (n != null) {
						c = n.le - 1;
					}
					break;
				}
				case 'E': {
					c++;
					IntervalList.Interval n = listRows[r].get(c);
					if (n != null) {
						c = n.ri + 1;
					}
					break;
				}
				case 'S': {
					r++;
					IntervalList.Interval n = listCols[c].get(r);
					if (n != null) {
						r = n.ri + 1;
					}
					break;
				}
				default: {
					r--;
					IntervalList.Interval n = listCols[c].get(r);
					if (n != null) {
						r = n.le - 1;
					}
				}
			}
			listRows[r].insert(c);
			listCols[c].insert(r);
		}
		return new int[]{r, c};
	}

	private static class IntervalList {

		private List<Interval> intervals;

		private IntervalList() {
			intervals = new ArrayList<>();
		}

		private void insert(int val) {
			//noinspection ComparatorMethodParameterNotUsed
			int idx = binarySearch(intervals, null, (node, key) -> node.le - val);
			idx = Math.max(idx, Math.abs(idx) - 1);
			if (intervals.isEmpty()) {
				intervals.add(idx, new Interval(val, val));
			} else {
				if (idx != 0 && intervals.get(idx - 1).ri + 1 == val) {
					if (idx != intervals.size() && intervals.get(idx).le - 1 == val) {
						intervals.get(idx - 1).ri = intervals.get(idx).ri;
						intervals.remove(idx);
					} else {
						intervals.get(idx - 1).ri = val;
					}
				} else if (idx != intervals.size() && intervals.get(idx).le - 1 == val) {
					intervals.get(idx).le = val;
				} else {
					intervals.add(idx, new Interval(val, val));
				}
			}
		}

		public Interval get(int val) {
			//noinspection ComparatorMethodParameterNotUsed
			int idx = binarySearch(intervals, null, (node, key) -> {
				if (node.le <= val && node.ri >= val) {
					return 0;
				}
				return node.le - val;
			});
			if (idx < 0) {
				return null;
			} else {
				return intervals.get(idx);
			}
		}

		private static class Interval {

			private int le, ri;

			private Interval(int le, int ri) {
				this.le = le;
				this.ri = ri;
			}

			@Override
			public String toString() {
				return "Node{" +
						"le=" + le +
						", ri=" + ri +
						'}';
			}
		}

	}

}

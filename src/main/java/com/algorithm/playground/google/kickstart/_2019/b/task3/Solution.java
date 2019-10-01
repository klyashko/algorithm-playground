package com.algorithm.playground.google.kickstart._2019.b.task3;

import java.util.*;
import java.util.Map.Entry;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050eda/00000000001198c1
 */
@SuppressWarnings("DuplicatedCode")
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int n = console.nextInt();
				int s = console.nextInt();
				int[] row = new int[n];
				for (int i = 0; i < n; i++) {
					row[i] = console.nextInt();
				}
				int ans = solve(row, s);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		}
	}

	private static int solve(int[] row, int s) {
		Map<Integer, List<Integer>> positions = new HashMap<>();
		for (int i = 0; i < row.length; i++) {
			if (!positions.containsKey(row[i])) {
				positions.put(row[i], new ArrayList<>());
			}
			positions.get(row[i]).add(i);
		}
		Map<Integer, Integer> offsets = new HashMap<>();
		int[] prefixes = new int[row.length];
		for (Entry<Integer, List<Integer>> entry : positions.entrySet()) {
			int idx = 0;
			List<Integer> list = entry.getValue();
			for (int i = 0; i < list.size() && i <= s; i++) {
				if (i < s) {
					prefixes[list.get(i)] = 1;
				} else {
					prefixes[list.get(i)] = -s;
				}
				idx = i;
			}
			offsets.put(entry.getKey(), idx);
		}
		SegmentTree tree = new SegmentTree(prefixes);
		int max = tree.getTop();
		for (int i = 0; i < row.length; i++) {
			int type = row[i];
			tree.update(i, 0);
			Integer offset = offsets.get(type);
			List<Integer> list = positions.get(type);
			if (offset >= s && offset < list.size()) {
				tree.update(list.get(offset++), 1);
				if (offset < list.size()) {
					tree.update(list.get(offset), -s);
				}
				offsets.put(type, offset);
			}
			max = Math.max(max, tree.getTop());
		}
		return max;
	}

	private static class SegmentTree {

		private int[] sum;
		private int[] max;
		private int size;

		private SegmentTree(int[] values) {
			int size = 1;
			while (size < values.length) {
				size <<= 1;
			}
			this.size = values.length - 1;
			this.sum = new int[size << 1];
			this.max = new int[size << 1];

			buildTree(values, 1, 0, this.size);
		}

		private int getTop() {
			return max[0];
		}

		private void update(int idx, int val) {
			update(idx, val, 1, 0, size);
		}

		private void update(int i, int val, int idx, int lo, int hi) {
			if (lo == i && lo == hi) {
				sum[idx - 1] = val;
				max[idx - 1] = val;
			} else if (lo <= i && hi >= i) {
				int mid = (hi - lo >> 1) + lo;
				int left = idx * 2;
				int right = left + 1;

				update(i, val, left, lo, mid);
				update(i, val, right, mid + 1, hi);
				update(idx, left, right);
			}
		}

		private void buildTree(int[] values, int idx, int lo, int hi) {
			if (lo == hi) {
				sum[idx - 1] = values[lo];
				max[idx - 1] = values[lo];
			} else {
				int mid = (hi - lo >> 1) + lo;
				int left = idx * 2;
				int right = left + 1;

				buildTree(values, left, lo, mid);
				buildTree(values, right, mid + 1, hi);
				update(idx, left, right);
			}
		}

		private void update(int idx, int left, int right) {
			sum[idx - 1] = sum[left - 1] + sum[right - 1];
			max[idx - 1] = Math.max(max[left - 1], sum[left - 1] + max[right - 1]);
		}

		@Override
		public String toString() {
			return "SegmentTree{" +
					"max=" + Arrays.toString(max) +
					'}';
		}
	}

}

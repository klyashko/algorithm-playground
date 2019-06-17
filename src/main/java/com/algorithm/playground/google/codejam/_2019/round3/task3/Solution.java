package com.algorithm.playground.google.codejam._2019.round3.task3;

import java.util.*;

import static java.util.Collections.emptyList;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051707/0000000000158f1c
 */
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int rows = console.nextInt();
				int cols = console.nextInt();
				char[][] grid = new char[rows][];
				for (int r = 0; r < rows; r++) {
					grid[r] = console.next().toCharArray();
				}
				List<String> ans = solve(grid, rows, cols);
				if (ans.isEmpty()) {
					System.out.println(String.format("Case #%s: IMPOSSIBLE", test));
				} else {
					System.out.println(String.format("Case #%s: POSSIBLE", test));
					for (String s : ans) {
						System.out.println(s);
					}
				}
			}
		}
	}

	private static List<String> solve(char[][] grid, int rows, int cols) {
		DSU dsu = new DSU(rows * cols, cols);
		for (int c = 0; c < cols - 1; c++) {
			if (grid[0][c] == grid[0][c + 1]) {
				dsu.union(0, c, 0, c + 1);
			}
		}

		for (int r = 1; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (grid[r - 1][c] == grid[r][c]) {
					dsu.union(r - 1, c, r, c);
				}
				if (c < cols - 1 && grid[r][c] == grid[r][c + 1]) {
					dsu.union(r, c, r, c + 1);
				}
			}
		}

		List<String> ans = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		for (int r = 1; r < rows; r++) {
			builder.setLength(0);
			for (int c = 0; c < cols - 1; c++) {
				if (grid[r - 1][c + 1] == grid[r][c] && dsu.find(r - 1, c + 1) != dsu.find(r, c)) {
					dsu.union(r - 1, c + 1, r, c);
					builder.append('/');
				} else if (grid[r - 1][c] == grid[r][c + 1] && dsu.find(r - 1, c) != dsu.find(r, c + 1)) {
					dsu.union(r - 1, c, r, c + 1);
					builder.append('\\');
				} else {
					builder.append('.');
				}
			}
			ans.add(builder.toString());
		}

		Set<Integer> sets = new HashSet<>();
		for (int i : dsu.sets) {
			sets.add(dsu.find(i));
			if (sets.size() > 2) {
				return emptyList();
			}
		}
		return ans;
	}

	private static class DSU {

		private int[] sets;
		private int cols;

		private DSU(int capacity, int cols) {
			this.sets = new int[capacity];
			this.cols = cols;
			for (int i = 0; i < capacity; i++) {
				sets[i] = i;
			}
		}

		private void union(int r1, int c1, int r2, int c2) {
			int key1 = key(r1, c1);
			int key2 = key(r2, c2);
			sets[find(key1)] = find(key2);
		}

		private int key(int r, int c) {
			return r * cols + c;
		}

		private int find(int r, int c) {
			return find(key(r, c));
		}

		private int find(int key) {
			if (sets[key] == key) {
				return key;
			}
			return sets[key] = find(sets[key]);
		}

	}

}

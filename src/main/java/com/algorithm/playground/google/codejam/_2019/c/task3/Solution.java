package com.algorithm.playground.google.codejam._2019.c.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class Solution {

	private static int rows;
	private static int cols;
	private static Map<String, Integer> cache = new HashMap<>();

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				cache.clear();
				rows = console.nextInt();
				cols = console.nextInt();
				char[][] grid = new char[rows][];
				for (int i = 0; i < rows; i++) {
					grid[i] = console.next().toCharArray();
				}
				int ans = solve(grid);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static int solve(char[][] grid) {
		return dp(grid);
	}

	private static int dp(char[][] grid) {
		String key = key(grid);
		Integer result = cache.get(key);
		if (result != null) {
			return result;
		}
		result = 0;
		boolean[] y = new boolean[cols];
		boolean[] x = new boolean[rows];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (grid[r][c] == '.') {
					if (!y[c]) {
						int[] vertical = vertical(grid, r, c);
						if (vertical(grid, c, vertical) && dp(grid) == 0) {
							result++;
							y[c] = true;
						}
						vertical(grid, vertical, c);
					} else {
						result++;
					}

					if (!x[r]) {
						int[] horizontal = horizontal(grid, r, c);
						if (horizontal(grid, r, horizontal) && dp(grid) == 0) {
							result++;
							x[r] = true;
						}
						horizontal(grid, horizontal, r);
					} else {
						result++;
					}
				} else {
					y[c] = false;
					x[r] = false;
				}
			}
		}
		cache.put(key, result);
		return result;
	}

	private static boolean vertical(char[][] grid, int c, int[] interval) {
		int from = interval[0], to = interval[1];
		return (from == 0 || grid[from - 1][c] != '#') && (to == rows - 1 || grid[to + 1][c] != '#');
	}

	private static boolean horizontal(char[][] grid, int r, int[] interval) {
		int from = interval[0], to = interval[1];
		return (from == 0 || grid[r][from - 1] != '#') && (to == cols - 1 || grid[r][to + 1] != '#');
	}

	private static String key(char[][] grid) {
		StringBuilder builder = new StringBuilder();
		for (char[] row : grid) {
			builder.append(row);
		}
		return builder.toString();
	}

	private static void vertical(char[][] grid, int[] r, int c) {
		for (int i = r[0]; i <= r[1]; i++) {
			grid[i][c] = '.';
		}
	}

	private static void horizontal(char[][] grid, int[] c, int r) {
		for (int i = c[0]; i <= c[1]; i++) {
			grid[r][i] = '.';
		}
	}

	private static int[] vertical(char[][] grid, int r, int c) {
		int[] interval = {r, r};
		for (int i = r; i >= 0; i--) {
			if (grid[i][c] != '.') {
				break;
			}
			grid[i][c] = '*';
			interval[0] = i;
		}

		for (int i = r + 1; i < rows; i++) {
			if (grid[i][c] != '.') {
				break;
			}
			grid[i][c] = '*';
			interval[1] = i;
		}
		return interval;
	}

	private static int[] horizontal(char[][] grid, int r, int c) {
		int[] interval = {c, c};
		for (int i = c; i >= 0; i--) {
			if (grid[r][i] != '.') {
				break;
			}
			grid[r][i] = '*';
			interval[0] = i;
		}

		for (int i = c + 1; i < cols; i++) {
			if (grid[r][i] != '.') {
				break;
			}
			grid[r][i] = '*';
			interval[1] = i;
		}
		return interval;
	}

}

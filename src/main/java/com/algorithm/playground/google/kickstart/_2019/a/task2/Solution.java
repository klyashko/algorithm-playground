package com.algorithm.playground.google.kickstart._2019.a.task2;

import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050e01/000000000006987d
 */
@SuppressWarnings("Duplicates")
public class Solution {

	public static void main(String[] args) {
		try {
			Scanner console = new Scanner(System.in);
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int rows = console.nextInt();
				int cols = console.nextInt();
				char[][] grid = readGrid(rows, console);

				int ans = solve(grid, rows, cols);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	static int solve(char[][] grid, int rows, int cols) {
		int[][] cache = new int[rows][cols];
		int li = 0;
		int ri = distance(cache, grid);

		while (li < ri) {
			int mid = (ri - li) / 2 + li;
			if (validate(cache, mid)) {
				ri = mid;
			} else {
				li = mid + 1;
			}
		}
		return li;
	}

	private static boolean validate(int[][] distances, int lim) {
		int rows = distances.length;
		int cols = distances[0].length;

		int plus_max = Integer.MAX_VALUE;
		int plus_min = Integer.MIN_VALUE;
		int minus_max = Integer.MAX_VALUE;
		int minus_min = Integer.MIN_VALUE;

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (distances[i][j] > lim) {
					plus_max = Math.min(plus_max, i + j + lim);
					plus_min = Math.max(plus_min, i + j - lim);
					minus_max = Math.min(minus_max, i - j + lim);
					minus_min = Math.max(minus_min, i - j - lim);
				}
			}
		}
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				int plus = i + j, minus = i - j;
				if (plus_min <= plus && plus <= plus_max && minus_min <= minus && minus <= minus_max)
					return true;
			}
		}
		return false;
	}

	private static char[][] readGrid(int rows, Scanner console) {
		char[][] grid = new char[rows][];
		for (int i = 0; i < grid.length; i++) {
			grid[i] = console.next().toCharArray();
		}
		return grid;
	}

	private static int distance(int[][] cache, char[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				cache[r][c] = Integer.MAX_VALUE / 2;

				if (grid[r][c] == '1') {
					cache[r][c] = 0;
				} else {
					if (r > 0) {
						cache[r][c] = Math.min(cache[r][c], cache[r - 1][c] + 1);
					}
					if (c > 0) {
						cache[r][c] = Math.min(cache[r][c], cache[r][c - 1] + 1);
					}
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (int r = rows - 1; r >= 0; r--) {
			for (int c = cols - 1; c >= 0; c--) {
				if (r < rows - 1) {
					cache[r][c] = Math.min(cache[r][c], cache[r + 1][c] + 1);
				}
				if (c < cols - 1) {
					cache[r][c] = Math.min(cache[r][c], cache[r][c + 1] + 1);
				}
				max = Math.max(max, cache[r][c]);
			}
		}
		return max;
	}

}
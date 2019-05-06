package com.algorithm.playground.google.codejam._2019.c.task3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/00000000000516b9/0000000000134cdf
 */
public class Solution {

	private static int rows;
	private static int cols;
	private static int[][] vertical;
	private static int[][] horizontal;
	private static int[][][][] cache;
	private static Scanner console;

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			Solution.console = console;
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				rows = console.nextInt();
				cols = console.nextInt();
				initCache();
				initIndexes();
				int ans = solve();
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static int solve() {
		int validRows = getRows(0, 0, rows, cols);
		int validCols = getCols(0, 0, rows, cols);

		int count = 0;
		for (int r = 0; r < rows; r++) {
			int curr = 1 << r;
			if ((validRows & curr) == curr) {
				int left = grundy(0, 0, r, cols);
				int right = grundy(r + 1, 0, rows, cols);
				if ((left ^ right) == 0) {
					count += cols;
				}
			}
		}
		for (int c = 0; c < cols; c++) {
			int curr = 1 << c;
			if ((validCols & curr) == curr) {
				int left = grundy(0, 0, rows, c);
				int right = grundy(0, c + 1, rows, cols);
				if ((left ^ right) == 0) {
					count += rows;
				}
			}
		}
		return count;
	}

	private static int grundy(int r1, int c1, int r2, int c2) {
		if (r2 == r1 || c2 == c1) {
			return 0;
		} else if (cache[r1][c1][r2 - 1][c2 - 1] != -1) {
			return cache[r1][c1][r2 - 1][c2 - 1];
		} else {
			int rows = getRows(r1, c1, r2, c2);
			int cols = getCols(r1, c1, r2, c2);

			Set<Integer> grundy = new HashSet<>();
			for (int r = r1; r < r2; r++) {
				int curr = 1 << r;
				if ((rows & curr) == curr) {
					int left = grundy(r1, c1, r, c2);
					int right = grundy(r + 1, c1, r2, c2);
					grundy.add(left ^ right);
				}
			}
			for (int c = c1; c < c2; c++) {
				int curr = 1 << c;
				if ((cols & curr) == curr) {
					int left = grundy(r1, c1, r2, c);
					int right = grundy(r1, c + 1, r2, c2);
					grundy.add(left ^ right);
				}
			}
			for (int i = 0; ; i++) {
				if (!grundy.contains(i)) {
					return cache[r1][c1][r2 - 1][c2 - 1] = i;
				}
			}
		}
	}

	private static void initIndexes() {
		vertical = new int[rows][cols];
		horizontal = new int[rows][cols];

		for (int c = 0; c < cols; c++) {
			vertical[0][c] = -1;
		}

		for (int r = 0; r < rows; r++) {
			horizontal[r][0] = -1;
		}

		for (int r = 0; r < rows; r++) {
			char[] row = console.next().toCharArray();
			for (int c = 0; c < cols; c++) {
				if (row[c] == '#') {
					vertical[r][c] = r;
					horizontal[r][c] = c;
				} else {
					vertical[r][c] = vertical[Math.max(0, r - 1)][c];
					horizontal[r][c] = horizontal[r][Math.max(0, c - 1)];
				}
			}
		}
	}

	private static void initCache() {
		cache = new int[rows][cols][rows][cols];
		for (int[][][] i : cache) {
			for (int[][] ii : i) {
				for (int[] iii : ii) {
					Arrays.fill(iii, -1);
				}
			}
		}
	}

	private static int getRows(int r1, int c1, int r2, int c2) {
		int rows = 0;
		for (int r = r1; r < r2; r++) {
			if (horizontal[r][c1] < c1 && horizontal[r][c2 - 1] == horizontal[r][c1]) {
				rows |= 1 << r;
			}
		}
		return rows;
	}

	private static int getCols(int r1, int c1, int r2, int c2) {
		int cols = 0;
		for (int c = c1; c < c2; c++) {
			if (vertical[r1][c] < r1 && vertical[r2 - 1][c] == vertical[r1][c]) {
				cols |= 1 << c;
			}
		}
		return cols;
	}

}

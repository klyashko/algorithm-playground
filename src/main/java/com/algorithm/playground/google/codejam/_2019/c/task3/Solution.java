package com.algorithm.playground.google.codejam._2019.c.task3;

import java.util.*;

@SuppressWarnings("Duplicates")
public class Solution {

	private static int rows;
	private static int cols;
	private static int[][] vertical;
	private static int[][] horizontal;
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
		vertical = new int[rows][cols];
		horizontal = new int[rows][cols];

		for (int c = 0; c < cols; c++) {
			vertical[0][c] = -1;
		}

		for (int r = 0; r < rows; r++) {
			horizontal[r][0] = -1;
		}

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (grid[r][c] == '#') {
					vertical[r][c] = r;
					horizontal[r][c] = c;
				} else {
					vertical[r][c] = vertical[Math.max(0, r - 1)][c];
					horizontal[r][c] = horizontal[r][Math.max(0, c - 1)];
				}
			}
		}

//		for (int[] row : vertical) {
//			System.out.println(Arrays.toString(row));
//		}
//
//		System.out.println();
//
//		for (int[] row : horizontal) {
//			System.out.println(Arrays.toString(row));
//		}

//		return dp(grid);
//		return dp(0, 0, rows - 1, cols - 1);
		int validRows = getRows(0, 0, rows - 1, cols - 1);
		int validCols = getCols(0, 0, rows - 1, cols - 1);

		int count = 0;
		for (int r = 0; r < rows; r++) {
			int curr = 1 << r;
			if ((validRows & curr) == curr) {
				int left = grundy(0, 0, r - 1, cols - 1);
				int right = grundy(r + 1, 0, rows - 1, cols - 1);
				if ((left ^ right) == 0) {
					count += cols;
				}
			}
		}
		for (int c = 0; c < cols; c++) {
			int curr = 1 << c;
			if ((validCols & curr) == curr) {
				int left = grundy(0, 0, rows - 1, c - 1);
				int right = grundy(0, c + 1, rows - 1, cols - 1);
				if ((left ^ right) == 0) {
					count += rows;
				}
			}
		}
		return count;
	}

	private static int grundy(int r1, int c1, int r2, int c2) {
		if (r2 < r1 || c2 < c1) {
			return 0;
		} else {
			int rows = getRows(r1, c1, r2, c2);
			int cols = getCols(r1, c1, r2, c2);

			Set<Integer> grundy = new HashSet<>();
			for (int r = r1; r <= r2; r++) {
				int curr = 1 << r;
				if ((rows & curr) == curr) {
					int left = grundy(r1, c1, r - 1, c2);
					int right = grundy(r + 1, c1, r2, c2);
					grundy.add(left ^ right);
				}
			}
			for (int c = c1; c <= c2; c++) {
				int curr = 1 << c;
				if ((cols & curr) == curr) {
					int left = grundy(r1, c1, r2, c - 1);
					int right = grundy(r1, c + 1, r2, c2);
					grundy.add(left ^ right);
				}
			}
			for (int i = 0; ; i++) {
				if (!grundy.contains(i)) {
					return i;
				}
			}
		}
	}

	private static int getCount(int left, int right) {
		return (left == 0 && right == 0) || (left != 0 && right != 0) ? 1 : 0;
	}

	private static int getRows(int r1, int c1, int r2, int c2) {
		int rows = 0;
		for (int r = r1; r <= r2; r++) {
			if (horizontal[r][c1] < c1 && horizontal[r][c2] == horizontal[r][c1]) {
				rows |= 1 << r;
			}
		}
		return rows;
	}

	private static int getCols(int r1, int c1, int r2, int c2) {
		int cols = 0;
		for (int c = c1; c <= c2; c++) {
			if (vertical[r1][c] < r1 && vertical[r2][c] == vertical[r1][c]) {
				cols |= 1 << c;
			}
		}
		return cols;
	}

	private static int dp(char[][] grid) {
		String key = key(grid);
		Integer result = cache.get(key);
		if (result != null) {
			return result;
		}
		result = 0;
		int y = 0;
		int x = 0;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (grid[r][c] == '.') {
					if ((y & (1 << c)) == 0) {
						int[] vertical = vertical(grid, r, c);
						if (vertical(grid, c, vertical) && dp(grid) == 0) {
							result++;
							y |= 1 << c;
						}
						vertical(grid, vertical, c);
					} else {
						result++;
					}

					if ((x & (1 << r)) == 0) {
						int[] horizontal = horizontal(grid, r, c);
						if (horizontal(grid, r, horizontal) && dp(grid) == 0) {
							result++;
							x |= 1 << r;
						}
						horizontal(grid, horizontal, r);
					} else {
						result++;
					}
				} else {
					if ((y & (1 << c)) == 1) {
						y ^= 1 << c;
					}
					if ((x & (1 << r)) == 1) {
						x ^= 1 << r;
					}
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

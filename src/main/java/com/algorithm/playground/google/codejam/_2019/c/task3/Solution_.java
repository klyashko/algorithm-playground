package com.algorithm.playground.google.codejam._2019.c.task3;

import java.util.*;

@SuppressWarnings("Duplicates")
public class Solution_ {

	static int rows, cols;
	static char[][] arr;
	static int[][][][] memo;

	static List<Integer> goodRows(int r1, int r2, int c1, int c2) {
		List<Integer> res = new ArrayList<>();
		for (int row = r1; row <= r2; row++) {
			boolean good = true;
			for (int col = c1; col <= c2; col++) {
				good &= arr[row][col] == '.';
			}
			if (good) {
				res.add(row);
			}
		}
		return res;
	}

	static List<Integer> goodCols(int r1, int r2, int c1, int c2) {
		List<Integer> res = new ArrayList<>();
		for (int col = c1; col <= c2; col++) {
			boolean good = true;
			for (int row = r1; row <= r2; row++) {
				good &= arr[row][col] == '.';
			}
			if (good) {
				res.add(col);
			}
		}
		return res;
	}

	static int grundy(int r1, int r2, int c1, int c2) {
		if (r1 > r2 || c1 > c2) {
			return 0;
		} else if (memo[r1][r2][c1][c2] != -1) {
			return memo[r1][r2][c1][c2];
		}

		List<Integer> goodRows = goodRows(r1, r2, c1, c2);
		List<Integer> goodCols = goodCols(r1, r2, c1, c2);

		Set<Integer> grundies = new HashSet<>();
		for (int row : goodRows) {
			grundies.add(grundy(r1, row - 1, c1, c2) ^ grundy(row + 1, r2, c1, c2));
		}
		for (int col : goodCols) {
			grundies.add(grundy(r1, r2, c1, col - 1) ^ grundy(r1, r2, col + 1, c2));
		}

		System.out.println(grundies);

		for (int i = 0; ; i++) {
			if (!grundies.contains(i)) {
				return memo[r1][r2][c1][c2] = i;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCases = sc.nextInt();
		for (int testCase = 1; testCase <= testCases; testCase++) {
			rows = sc.nextInt();
			cols = sc.nextInt();
			arr = new char[rows][cols];
			memo = new int[16][16][16][16];
			for (int[][][] m : memo) {
				for (int[][] mm : m) {
					for (int[] mmm : mm) {
						Arrays.fill(mmm, -1);
					}
				}
			}

			for (int i = 0; i < rows; i++) {
				arr[i] = sc.next().toCharArray();
			}

			List<Integer> goodRows = goodRows(0, rows - 1, 0, cols - 1);
			List<Integer> goodCols = goodCols(0, rows - 1, 0, cols - 1);

			int res = 0;
			for (int row : goodRows) {
				if ((grundy(0, row - 1, 0, cols - 1) ^ grundy(row + 1, rows - 1, 0, cols - 1)) == 0) {
					res += cols;
				}
			}
			for (int col : goodCols) {
				if ((grundy(0, rows - 1, 0, col - 1) ^ grundy(0, rows - 1, col + 1, cols - 1)) == 0) {
					res += rows;
				}
			}

			System.out.println(String.format("Case #%s: %s", testCase, res));
		}

		System.out.close();
	}

}

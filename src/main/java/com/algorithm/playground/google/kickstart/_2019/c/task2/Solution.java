package com.algorithm.playground.google.kickstart._2019.c.task2;

import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050ff2/0000000000150aae
 */
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int rows = console.nextInt();
				int cols = console.nextInt();
				int k = console.nextInt();
				int[][] board = new int[rows][cols];
				for (int r = 0; r < rows; r++) {
					for (int c = 0; c < cols; c++) {
						board[r][c] = console.nextInt();
					}
				}
				int ans = solve(board, k);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		}
	}

	private static int solve(int[][] board, int k) {
		int rows = board.length;
		int cols = board[0].length;

		int max = 0;
		for (int i = 0; i < cols; i++) {

			Stat[] stats = new Stat[rows];
			for (int r = 0; r < rows; r++) {
				stats[r] = new Stat(k);
			}
			for (int c = i, curr = 0; c < cols; c++) {
				for (int r = 0; r < rows; r++) {
					stats[r].add(board[r][c]);

					if (stats[r].isValid()) {
						curr += stats[r].getSize();
					} else {
						curr = 0;
					}
					max = Math.max(max, curr);
				}
			}
		}

		return max;
	}

	private static class Stat {

		private final int k;
		private int count, min, max;

		private Stat(int k) {
			this.k = k;
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
		}

		private void add(int val) {
			max = Math.max(max, val);
			min = Math.min(min, val);
			count++;
		}

		private boolean isValid() {
			return max - min <= k;
		}

		private int getSize() {
			return count;
		}

		@Override
		public String toString() {
			return "Stat{" +
					"count=" + count +
					", min=" + min +
					", max=" + max +
					", k=" + k +
					'}';
		}
	}

}

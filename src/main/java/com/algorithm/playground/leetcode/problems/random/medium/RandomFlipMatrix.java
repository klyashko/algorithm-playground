package com.algorithm.playground.leetcode.problems.random.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * https://leetcode.com/problems/random-flip-matrix/description/
 */
public class RandomFlipMatrix {

	public static Solution solution(int n_rows, int n_cols) {
		return new RandomFlipMatrix().create(n_rows, n_cols);
	}

	private Solution create(int n_rows, int n_cols) {
		return new Solution(n_rows, n_cols);
	}

	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(n_rows, n_cols);
	 * int[] param_1 = obj.flip();
	 * obj.reset();
	 */
	class Solution {

		private Map<Integer, Integer> map;
		private int rows, cols, total;
		private Random rand;

		public Solution(int n_rows, int n_cols) {
			map = new HashMap<>();
			rand = new Random();
			rows = n_rows;
			cols = n_cols;
			total = rows * cols;
		}

		public int[] flip() {
			int r = rand.nextInt(total--);
			int x = map.getOrDefault(r, r);
			map.put(r, map.getOrDefault(total, total));
			return new int[]{x / cols, x % cols};
		}

		public void reset() {
			map.clear();
			total = rows * cols;
		}
	}

}

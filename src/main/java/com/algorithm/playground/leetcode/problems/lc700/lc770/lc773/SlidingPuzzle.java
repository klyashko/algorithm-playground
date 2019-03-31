package com.algorithm.playground.leetcode.problems.lc700.lc770.lc773;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/sliding-puzzle/
 */
@SuppressWarnings("ConstantConditions")
public class SlidingPuzzle {

	class Solution {

		private final int[][] moves = new int[][]{
				{1, 3},
				{0, 2, 4},
				{1, 5},
				{0, 4},
				{1, 3, 5},
				{2, 4}
		};

		private final String end = "123450";

		public int slidingPuzzle(int[][] board) {
			StringBuilder builder = new StringBuilder();
			for (int[] r : board) {
				for (int i : r) {
					builder.append(i);
				}
			}
			Queue<String> queue = new ArrayDeque<>();
			Set<String> seen = new HashSet<>();
			String start = builder.toString();
			queue.offer(start);
			seen.add(start);

			for (int move = 0; !queue.isEmpty(); move++) {
				for (int size = queue.size(); size > 0; size--) {
					String curr = queue.poll();
					if (curr.equals(end)) {
						return move;
					}
					int idx = curr.indexOf('0');
					for (int m : this.moves[idx]) {
						String next = swap(curr, idx, m);
						if (seen.add(next)) {
							queue.offer(next);
						}
					}
				}
			}

			return -1;
		}

		private String swap(String s, int i, int j) {
			StringBuilder builder = new StringBuilder(s);
			char ch = builder.charAt(i);
			builder.setCharAt(i, builder.charAt(j));
			builder.setCharAt(j, ch);
			return builder.toString();
		}
	}

}

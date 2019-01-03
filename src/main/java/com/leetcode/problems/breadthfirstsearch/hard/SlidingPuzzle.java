package com.leetcode.problems.breadthfirstsearch.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/sliding-puzzle/
 */
@SuppressWarnings("ConstantConditions")
public class SlidingPuzzle {

	class Solution {

		private final int[] dr = new int[]{1, -1, 0, 0};
		private final int[] dc = new int[]{0, 0, 1, -1};

		public int slidingPuzzle(int[][] board) {
			Queue<Node> queue = new ArrayDeque<>();
			Set<String> seen = new HashSet<>();
			Node start = new Node(board);
			queue.offer(start);
			seen.add(start.key());

			int move = 0;

			while (!queue.isEmpty()) {
				int size = queue.size();
				for (; size > 0; size--) {
					Node n = queue.poll();
					if (n.score == 1 && n.value[1][2] == 0) {
						return move;
					}
					for (int r = 0; r < n.value.length; r++) {
						int[] row = n.value[r];
						for (int c = 0; c < row.length; c++) {
							if (row[c] == 0) {
								for (int i = 0; i < 4; i++) {
									int tr = r + dr[i], tc = c + dc[i];
									if (tr < 2 && tr >= 0 && tc < 3 && tc >= 0) {
										n.value[r][c] = n.value[tr][tc];
										n.value[tr][tc] = 0;
										Node next = new Node(n.value);
										if (seen.add(next.key())) {
											queue.offer(next);
										}
										n.value[tr][tc] = n.value[r][c];
										n.value[r][c] = 0;
									}
								}
							}
						}
					}
				}
				move += 1;
			}

			return -1;
		}

		private class Node {

			int[][] value;
			int score;

			public Node(int[][] value) {
				int[][] tmp = new int[value.length][];
				for (int i = 0; i < value.length; i++) {
					tmp[i] = Arrays.copyOf(value[i], value[i].length);
				}
				this.value = tmp;
				for (int i = 0; i < 6; i++) {
					int r = i / 3;
					int c = i % 3;
					if (tmp[r][c] != i + 1) {
						score += 1;
					}
				}
			}

			private String key() {
				return Arrays.toString(value[0]) + Arrays.toString(value[1]);
			}
		}
	}

}

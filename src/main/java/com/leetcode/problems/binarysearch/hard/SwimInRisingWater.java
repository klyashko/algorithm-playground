package com.leetcode.problems.binarysearch.hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/swim-in-rising-water/description/
 */
public class SwimInRisingWater {

	class Solution {

		private final int[] dr = new int[]{1, -1, 0, 0};
		private final int[] dc = new int[]{0, 0, 1, -1};

		public int swimInWater(int[][] grid) {
			int rows = grid.length;
			int cols = grid[0].length;
			boolean[][] visited = new boolean[rows][cols];

			Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
			Node start = new Node(0, 0, grid[0][0]);
			queue.add(start);

			while (!queue.isEmpty()) {
				Node current = queue.poll();
				System.out.println(current);
				//noinspection ConstantConditions
				int r = current.r;
				int c = current.c;
				int val = current.val;
				if (visited[r][c]) {
					continue;
				}
				if (r + 1 == rows && c + 1 == cols) {
					return val;
				}
				visited[r][c] = true;
				for (int i = 0; i < 4; i++) {
					int tr = r + dr[i], tc = c + dc[i];
					if (tc >= 0 && tc < cols && tr >= 0 && tr < rows && !visited[tr][tc]) {
						Node next = new Node(tr, tc, Math.max(val, grid[tr][tc]));
						queue.add(next);
					}
				}
			}

			return 0;
		}

		private int dfs(int[][] grid, boolean[][] visited, int r, int c, int rows, int cols) {
			if (c < 0 || c == cols || r < 0 || r == rows || visited[r][c]) {
				return Integer.MAX_VALUE;
			}
			if (r + 1 == rows && c + 1 == cols) {
				return grid[r][c];
			}
			visited[r][c] = true;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 4; i++) {
				min = Math.min(min, dfs(grid, visited, r + dr[i], c + dc[i], rows, cols));
			}
			visited[r][c] = false;

			return Math.max(min, grid[r][c]);
		}

		private class Node {
			int r, c, val;

			private Node(int r, int c, int val) {
				this.r = r;
				this.c = c;
				this.val = val;
			}

			@Override
			public String toString() {
				return "Node{" +
						"r=" + r +
						", c=" + c +
						", val=" + val +
						'}';
			}
		}
	}

}

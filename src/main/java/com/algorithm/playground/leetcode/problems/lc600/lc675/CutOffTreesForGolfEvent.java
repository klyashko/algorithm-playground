package com.algorithm.playground.leetcode.problems.lc600.lc675;

import java.util.*;

/**
 * https://leetcode.com/problems/cut-off-trees-for-golf-event/description/
 */
public class CutOffTreesForGolfEvent {

	class Solution {

		private final int[] dr = new int[]{1, -1, 0, 0};
		private final int[] dc = new int[]{0, 0, 1, -1};

		public int cutOffTree(List<List<Integer>> forest) {
			Queue<Point> queueToCut = new PriorityQueue<>(Comparator.comparingInt(n -> forest.get(n.r).get(n.c)));
			for (int r = 0; r < forest.size(); r++) {
				List<Integer> l = forest.get(r);
				for (int c = 0; c < l.size(); c++) {
					Integer val = forest.get(r).get(c);
					if (val > 1) {
						queueToCut.add(new Point(r, c));
					}
				}
			}
			int steps = 0;
			Point curr = new Point(0, 0);

			while (!queueToCut.isEmpty()) {
				Point next = queueToCut.poll();
				int dist = distance(curr, next, forest);
				if (dist == -1) {
					return -1;
				}
				steps += dist;
				curr = next;
			}

			return steps;
		}

		private int distance(Point from, Point to, List<List<Integer>> forest) {
			Set<Point> visited = new HashSet<>();
			Queue<Point> queue = new ArrayDeque<>();
			queue.add(from);
			visited.add(from);
			int steps = -1;

			while (!queue.isEmpty()) {
				int size = queue.size();
				steps++;
				while (size > 0) {
					Point curr = queue.poll();
					size--;
					//noinspection ConstantConditions
					if (curr.equals(to)) {
						return steps;
					}
					if (forest.get(curr.r).get(curr.c) == 0) {
						continue;
					}
					for (int i = 0; i < 4; i++) {
						int r = curr.r + dr[i];
						int c = curr.c + dc[i];
						if (r >= 0 && r < forest.size() && c >= 0 && c < forest.get(r).size()) {
							Point next = new Point(r, c);
							if (visited.add(next)) {
								queue.add(next);
							}
						}
					}
				}
			}

			return -1;
		}

		private class Point {
			int r, c;

			private Point(int r, int c) {
				this.r = r;
				this.c = c;
			}

			@Override
			public String toString() {
				return "Node{" +
						"r=" + r +
						", c=" + c +
						'}';
			}

			@Override
			public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Point node = (Point) o;
				return r == node.r &&
						c == node.c;
			}

			@Override
			public int hashCode() {
				return Objects.hash(r, c);
			}
		}
	}

	/**
	 * Time Limit Exceeded
	 */
	class AllNodeDistancesSolution {

		private final int[] dr = new int[]{1, -1, 0, 0};
		private final int[] dc = new int[]{0, 0, 1, -1};

		public int cutOffTree(List<List<Integer>> forest) {
			Queue<int[]> queueToCut = new PriorityQueue<>(Comparator.comparingInt(p -> forest.get(p[0]).get(p[1])));
			int rows = forest.size();
			int cols = forest.get(0).size();
			int n = rows * cols;
			int inf = n * 2;

			int[][] distances = getDistances(forest, queueToCut, rows, cols, n, inf);

			int steps = 0;
			int curr = node(0, 0, cols);

			while (!queueToCut.isEmpty()) {
				int[] next = queueToCut.poll();
				//noinspection ConstantConditions
				int node = node(next[0], next[1], cols);
				int dist = distances[curr][node];
				if (dist == inf) {
					return -1;
				}
				steps += dist;
				curr = node;
			}

			return steps;
		}

		private int[][] getDistances(List<List<Integer>> forest, Queue<int[]> queue, int rows, int cols, int n, int inf) {
			int[][] distances = new int[n][n];

			for (int[] row : distances) {
				Arrays.fill(row, inf);
			}

			for (int i = 0; i < n; i++) {
				distances[i][i] = 0;
			}

			/** distance initialization */
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					int node = node(r, c, cols);
					if (forest.get(r).get(c) > 1) {
						queue.add(new int[]{r, c});
					}
					for (int i = 0; i < 4; i++) {
						int tr = r + dr[i];
						int tc = c + dc[i];
						if (tr >= 0 && tr < rows && tc >= 0 && tc < cols) {
							if (forest.get(tr).get(tc) == 0) {
								distances[node][node(tr, tc, cols)] = inf;
							} else {
								distances[node][node(tr, tc, cols)] = 1;
							}
						}
					}
				}
			}

			/** shortest path search */
			for (int k = 0; k < distances.length; k++) {
				for (int i = 0; i < distances.length; i++) {
					for (int j = 0; j < distances.length; j++) {
						if (distances[i][k] == inf || distances[k][j] == inf) {
							continue;
						}
						if (distances[i][j] > distances[i][k] + distances[k][j]) {
							distances[i][j] = distances[i][k] + distances[k][j];
						}
					}
				}
			}
			return distances;
		}

		private int node(int r, int c, int cols) {
			return cols * r + c;
		}
	}
}
